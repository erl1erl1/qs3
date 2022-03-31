<template>
  <img alt="logo" id="logo" src="@/assets/qs-dark.svg">
  <div id="form-container">
    <h1>Pålogging</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <div class="input-container">
        <label>Brukernavn</label>
        <Field class="input" rules="required|alpha_num" name="username" type="text" placeholder="brukernavn" validateOnInput/>
        <ErrorMessage class="error" name="username"/>
      </div>

      <div class="input-container">
        <label>Passord</label>
        <Field class="input" rules="required" name="password" type="password" placeholder="passord" validateOnInput/>
      </div>
      <button class="button" :disabled="!(meta.valid)">Logg inn</button>
    </Form>
    <p v-if="!this.correctPassword" style="color: red">Incorrect credentials</p>
    <p style="margin-bottom: 10px">Ikke registrert? <router-link as="a" class="link" to="SignUp">Lag en bruker</router-link></p>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage } from 'vee-validate'
import { mapActions } from 'vuex'

export default {
  name: "Login",

  data() {
    return {
      correctPassword: true
    }
  },

  components: {
    Form,
    Field,
    ErrorMessage,
  },

  methods: {
    ...mapActions([
      'validateUser',
      'setActiveUser'
    ]),

    onSubmit(value) {
      const user = {
        username: value.username,
        password: value.password
      }

      const app = this

      this.validateUser(user).then(function (valid) {
        console.log(valid)
        if (valid) {
          app.correctPassword = true
          app.setActiveUser(user)
          app.$router.push('/calculator')
        } else {
          app.correctPassword = false
        }
      });
    }
  }
}
</script>

<style scoped>
#form-container {
  min-height: 300px;
  border-radius: 10px;
  text-align: center;
}

#logo {
  width: 60%;
  max-width: 400px;
  margin: 2em 0 2em 0 ;
}
</style>