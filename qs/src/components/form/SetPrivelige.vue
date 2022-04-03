<template>
  <div class="form-container">
    <h2>Gi rettigheter</h2>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <TextInput label="Brukernavn" name="username" placeholder="Brukernavn" type="text"
                 rules="required|alpha_num" error-message="Du må skrive et brukernavn"/>
      <div class="input-container">
        <label>Rolle</label>
        <Field as="select" name="role" rules="required" validateOnInput>
          <option value="Student" selected>Student</option>
          <option value="Øvingslærer">Øvingslærer</option>
          <option value="Emneansvarlig">Emneansvarlig</option>
        </Field>
      </div>

      <button :disabled="!(meta.valid)">Gi rettigheter</button>
    </Form>
    <p v-if="this.SUBMIT_FAIL" style="color: red">Klarte ikke å legge til</p>
    <hr/>
  </div>
</template>
<script>
import { Form, Field } from 'vee-validate'
import TextInput from "./TextInput";
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
    TextInput,
    Form,
    Field,
  },

  methods: {
    onSubmit() {

    }
  },

}
</script>
<style scoped>
hr {
  margin-top: 25px;
}
</style>