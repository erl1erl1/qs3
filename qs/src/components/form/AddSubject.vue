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
            "assignments": value.assignments},
          {headers: authHeader()}
      ).then(response => {
        console.log(response)
      }).catch(error => {
        this.SUBMIT_FAIL = true;
        console.log(error)
      })
    },
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