<template>
  <div class="form-container">
    <h1>Administrator</h1>
    <hr/>
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
  font-size: small;
}
</style>