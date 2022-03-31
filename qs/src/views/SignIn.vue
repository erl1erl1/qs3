<template>
  <img alt="logo" id="logo" src="@/assets/qs-dark.svg">
  <div id="form-container">
    <h1>Sign in</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <Field class="input" rules="required|alpha_num|min_max:3,10" name="username" type="text" placeholder="username" validateOnInput/>
      <ErrorMessage name="username"/>
      <Field class="input" rules="required" name="password" type="password" placeholder="password" validateOnInput/>
      <button class="button" :disabled="!(meta.valid)">Sign in</button>
    </Form>
    <p v-if="!this.correctPassword" style="color: red">Incorrect credentials</p>
    <p style="margin-bottom: 10px">Don't have an account yet? <router-link as="a" class="link" to="SignUp">Sign up</router-link></p>
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
  width: 500px;
  min-height: 300px;
  background-color: lavender;
  border-radius: 10px;
  padding: 20px 20px 0 20px;
  margin-top: 100px;
}

#logo {
  width: 60%;
  max-width: 400px;
  margin: 2em 0 2em 0 ;
}
</style>