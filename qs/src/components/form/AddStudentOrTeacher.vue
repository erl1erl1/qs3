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
import axios from "axios";
import authHeader from "../../services/header-token";
// import authHeader from "../../services/header-token";

export default {
  name: "GrantRights",


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
    onSubmit(value) {
      axios.put("http://localhost:8080/persons/" + value.username + "/" + value.role,
          {}, {headers: authHeader()})
      .then(response => {
        console.log(response)
      }).catch(error => {
        this.SUBMIT_FAIL = true;
        console.log(error)
      })
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