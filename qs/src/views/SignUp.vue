<template>
  <img alt="logo" class="logo" src="@/assets/qs-dark.svg">
  <div class="form-container">
    <h1>Registrer bruker</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <div class="input-container">
        <label>Brukernavn</label>
        <Field class="input" rules="required|alpha_num|min_max:3,16" name="username" type="text" placeholder="brukernavn" validateOnBlur/>
        <span class="error">
          <ErrorMessage name="username">Brukernavn må være mellom 3 og 16 karakterer langt</ErrorMessage>
        </span>
      </div>
      <div class="input-container">
        <label>Passord</label>
        <Field class="input" rules="required" name="password" type="password" placeholder="passord" validateOnBlur/>
        <span class="error">
          <ErrorMessage class="error" name="password">Passord kan ikke være tomt</ErrorMessage>
        </span>
      </div>
      <div class="input-container">
        <label>Bekreft passord</label>
        <Field class="input" rules="required|confirmed:@password"  name="confirm" type="password" placeholder="passord" validateOnInput/>
        <span class="error">
         <ErrorMessage class="error" name="confirm">Passordene samstemmer ikke</ErrorMessage>
        </span>
      </div>

      <button class="button" :disabled="!(meta.valid)">Sign in</button>
    </Form>
    <p style="margin-bottom: 10px">Har du allerede en bruker? <router-link as="a" class="link" to="/">Log inn</router-link></p>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate'
import { mapActions } from 'vuex'

export default {
  name: "Login",

  data() {
    return {

    }
  },

  components: {
    Form,
    Field,
    ErrorMessage,
  },

  methods: {
    ...mapActions([
      'addUser'
    ]),

    onSubmit(values) {
      const user = {
        username: values.username,
        password: values.password
      }
      this.addUser(user)
      this.$router.push('/')
    }
  }
}
</script>