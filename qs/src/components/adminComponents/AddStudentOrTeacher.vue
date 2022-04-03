<template>
  <div class="form-container">
    <h2>Legg til student/lærer</h2>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <div class="input-container">
        <label>Student brukernavn</label>
        <Field class="input" name="studentMail" type="username" placeholder="Brukernavn" validateOnInput/>
        <span class="error">
          <ErrorMessage name="studentMail">Angi lærer eller student</ErrorMessage>
        </span>
      </div>
      <div class="input-container">
        <label>Lærer brukernavn</label>
        <Field class="input" name="teacherMail" type="username" placeholder="Brukernavn" validateOnInput/>
        <span class="error">
          <ErrorMessage name="teacherMail">Angi lærer eller student</ErrorMessage>
        </span>
      </div>
      <div class="input-container">
        <label>Fagkode</label>
        <Field class="input" rules="required" name="subjectCode" type="alpha_num" placeholder="Fagkode" validateOnInput/>
        <span class="error">
          <ErrorMessage name="subjectCode">Angi en fagkode</ErrorMessage>
        </span>
      </div>
      <button class="button" :disabled="!(meta.valid)">Legg til</button>
    </Form>
    <p v-if="this.SUBMIT_FAIL" style="color: red">Klarte ikke å legge til</p>
    <hr/>
  </div>
</template>
<script>
import { Form, Field, ErrorMessage} from 'vee-validate'
// import axios from "axios";
// import authHeader from "../../services/header-token";

export default {
  name: "AddSubject",


  data() {
    return {
      SUBMIT_FAIL: false,
    }
  },

  components: {
    Form,
    Field,
    ErrorMessage,
  },

  methods: {
    onSubmit() {

    }
  },

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