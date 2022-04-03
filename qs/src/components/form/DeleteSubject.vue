<template>
  <div class="form-container">
    <h2>Slett fag</h2>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <div class="input-container">
        <label>Fagkode</label>
        <Field rules="required|alpha_num" name="subjectCode" type="alpha_num" placeholder="Fagkode" validateOnInput/>
      </div>
      <button class="button" :disabled="!(meta.valid)">Slett</button>
    </Form>
    <p v-if="this.DELETE_FAIL" style="color: red">Klarte ikke å legge til fag!</p>
  </div>
</template>

<script>
import { Form, Field} from 'vee-validate'
import axios from "axios";
import authHeader from "../../services/header-token";

export default {
  name: "Admin",

  data() {
    return {
      DELETE_FAIL: false,
    }
  },

  components: {
    Form,
    Field,
  },

  methods: {
    onSubmit(value) {
      axios.delete("http://localhost:8080/subjects/" + value.subjectCode,
          {headers: authHeader()}
      ).then(response => {
        console.log(response)
      }).catch(error => {
        this.DELETE_FAIL = true;
        console.log(error)
      })
    }
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
</style>