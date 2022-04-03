<template>
  <div class="form-container">
    <h1>Administrator</h1>
    <hr/>
    <h2>Legg til fag</h2>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <div class="input-container">
        <label>Fagkode</label>
        <Field rules="required|alpha_num" name="subjectCode" type="number" placeholder="Fagkode" validateOnInput/>
        <span class="error">
          <ErrorMessage name="subjectCode">Fag må ha en fagkode</ErrorMessage>
        </span>
      </div>
      <div class="input-container">
        <label>Fagnavn</label>
        <Field rules="required" name="subjectName" type="text" placeholder="Fagnavn" validateOnInput/>
        <span class="error">
          <ErrorMessage name="subjectName">Fag må ha et navn</ErrorMessage>
        </span>
      </div>
      <div class="input-container">
        <label>Studenter</label>
        <Field name="enrolledStudents" type="text" placeholder="Studenter" validateOnInput/>
      </div>
      <label for="csvInput" id="labelCsv">Legg til med CSV</label>
      <input type="file" accept=".csv" name="csvInput" id="csvInput" />
      <div class="input-container">
        <label>Antall øvinger</label>
        <Field rules="required" name="assignments" type="number" placeholder="Øvinger" validateOnInput/>
        <span class="error">
          <ErrorMessage name="assignments">Angi antall øvinger</ErrorMessage>
        </span>
      </div>
      <button :disabled="!(meta.valid)">Legg til</button>
    </Form>
    <p v-if="this.SUBMIT_FAIL" style="color: red">Klarte ikke å legge til fag!</p>
  </div>
  <hr/>
</template>
<script>
import { Form, Field, ErrorMessage} from 'vee-validate'
import axios from "axios";
import authHeader from "../../services/header-token";

export default {
  name: "AddSubject",

  data() {
    return {
      SUBMIT_FAIL: false
    }
  },

  components: {
    Form,
    Field,
    ErrorMessage,
  },

  methods: {
    onSubmit(value) {
      const subject = {
        "subjectCode": value.subjectCode,
        "subjectName": value.subjectName,
        "assignments": value.assignments
      }

      axios.post("http://localhost:8080/subjects",
          {subject},
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
  min-width: 310px;
  width: 90%;
  max-width: 900px;
  border: 0;
  border-top: 1px solid rgb(0, 0, 0, 0.2);
  margin-top: 15px;
}
#csvInput {
  opacity: 0;
  position: absolute;
  z-index: 0;
  margin-top: -10px;
}
#labelCsv {
  font-weight: 700;
  padding: 3px 2px 3px 2px;
  text-align: right;
  color: #f7a81b;
  margin-top: -20px;
  font-size: small;
}
</style>