<template>
  <div class="form-container">
    <h2>Legg til fag</h2>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <TextInput label="Fagkode" name="subjectCode" placeholder="Fagkode" type="text"
                 rules="required|alpha_num" error-message="Fag må ha en fagkode"/>
      <TextInput label="Fagnavn" name="subjectName" placeholder="Fagnavn" type="text"
                 rules="required|alpha_spaces" error-message="Fag må ha en fagkode"/>
      <div class="input-container" id="csv">
        <label>Studenter</label>
        <Field name="file" v-slot="{ handleChange, handleBlur }">
          <input type="file" accept=".csv" name="csvInput" id="csv-button" @change="handleChange" @blur="handleBlur">
        </Field>
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
import { Form, Field } from 'vee-validate'
import axios from "axios";
import authHeader from "../../services/header-token";
import TextInput from "@/components/form/TextInput";

export default {
  name: "AddSubject",

  data() {
    return {
      SUBMIT_FAIL: false
    }
  },

  components: {
    TextInput,
    Form,
    Field,
  },

  methods: {
    onSubmit(value) {
      axios.post("http://localhost:8080/subjects",
          {"subjectCode": value.subjectCode,
            "subjectName": value.subjectName,
            "assignments": value.assignments,
            "Students": this.csvToArray(value.csvInput)
          },

          {headers: authHeader()}
      ).then(response => {
        console.log(response)
      }).catch(error => {
        this.SUBMIT_FAIL = true;
        console.log(error)
      })
    },

    csvToArray(csvFile) {
      console.log(csvFile)
      // Read file
      const input = csvFile.files[0];
      const reader = new FileReader();

      reader.onload = function (e) {
        const text = e.target.result;
        document.write(text);
      };
      reader.readAsText(input);

      // Convert to Array
      const result = reader.result
      console.log(result)
      const delim = ", "
      const headers = result.slice(0, result.indexOf("\n")).split(delim);
      const rows = result.slice(result.indexOf("\n") + 1).split("\n");

      return rows.map(function (row) {
        const values = row.split(delim);
        return headers.reduce(function (object, header, index) {
          object[header] = values[index];
          return object;
        }, {});
      })
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