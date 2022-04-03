<template>
  <div class="form-container">
    <h2>Slett fag</h2>

    <Form @submit="onSubmit" v-slot="{ meta }">
      <TextInput label="Fagkode" name="subjectCode" placeholder="Fagkode" type="text"
                 rules="required|alpha_num" error-message="Navn kan kun inneholde bokstaver"/>

      <button class="button" :disabled="!(meta.valid)">Slett</button>
    </Form>

    <p v-if="this.DELETE_FAIL" style="color: red">Klarte ikke å legge til fag!</p>
  </div>
</template>

<script>
import { Form} from 'vee-validate'
import axios from "axios";
import authHeader from "../../services/header-token";
import TextInput from "./TextInput";

export default {
  name: "Admin",

  data() {
    return {
      DELETE_FAIL: false,
    }
  },

  components: {
    Form,
    TextInput,
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
  margin-top: 25px;
}
</style>