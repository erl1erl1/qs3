<template>
  <div class="form-container">
    <h2>Legg til fag</h2>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <TextInput label="Fagkode" name="subjectCode" placeholder="Fagkode" type="text"
                 rules="required|alpha_num" error-message="Fag må ha en fagkode"/>
      <TextInput label="Fagnavn" name="subjectName" placeholder="Fagnavn" type="text"
                 rules="required|alpha_spaces" error-message="Fag må ha navn"/>
      <div class="input-container" id="csv">
        <label>Studenter</label>
        <input type="file" accept=".csv" name="csvInput" id="csv-button" @change="handleFile">
      </div>
      <TextInput label="Antalløvinger" name="assignments" placeholder="Øvinger" type="number"
                 rules="required|numeric" error-message="Må være ett tall"/>
      <button class="button" :disabled="!(meta.valid)">Legg til</button>
    </Form>
    <p v-if="this.SUBMIT_FAIL" style="color: red">Klarte ikke å legge til fag!</p>
  </div>
  <hr/>
</template>

<script>
import {Form} from 'vee-validate'
import axios from "axios";
import authHeader, { authHeaderCSV }  from "../../services/header-token";
import TextInput from "@/components/form/TextInput";

export default {
  name: "AddSubject",

  data() {
    return {
      SUBMIT_FAIL: false,
      file: Blob
    }
  },

  components: {
    TextInput,
    Form
  },

  methods: {
    onSubmit(value) {
      // Add File to Request
      const formData = new FormData()
      formData.append('file', this.file)
      console.log(value.subjectCode, value.subjectName, value.assignments)

      axios.post("http://localhost:8080/addSubject/" +
          value.subjectCode + "/" +
          value.subjectName + "/" +
          value.assignments,
          formData, {
        headers: authHeaderCSV()
      }
      ).then(response => {
        console.log(response)
      }).catch(error => {
        this.SUBMIT_FAIL = true;
        console.log(error)
      })

      axios.get("http://localhost:8080/assignments/update/" + value.SubjectCode, { headers: authHeader() });
    },

    handleFile({ target: { files } }) {
      console.log("File Change " + files.length)
      this.file = files[0]
      const reader = new FileReader()

      // Log output
      reader.readAsText(this.file)
      reader.onload = () => {
        console.log(reader.result)
      }
    }
  }
}
</script>
<style scoped>
hr {
  margin-top: 25px;
}

input[type=file]::file-selector-button {
  margin-top: 5px;
  padding: 5px 10px 5px 10px;
}
</style>