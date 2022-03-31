<template>
  <div id="form-container">
    <h1>Sign up</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <Field class="input" rules="required|alpha_num|min_max:3,10" name="username" type="text" placeholder="username" validateOnInput/>
      <ErrorMessage name="username"/>
      <Field class="input" rules="required" name="password" type="password" placeholder="password" validateOnInput/>
      <Field class="input" rules="required|confirmed:@password"  name="confirm" type="password" placeholder="confirm password" validateOnInput/>
      <ErrorMessage name="confirm">Passwords must match</ErrorMessage>
      <button class="button" :disabled="!(meta.valid)">Sign in</button>
    </Form>
    <p style="margin-bottom: 10px">Already have an account yet? <router-link as="a" class="link" to="/">Sign In</router-link></p>
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

<style scoped>
#form-container {
  width: 500px;
  min-height: 300px;
  background-color: lightsteelblue;
  border-radius: 10px;
  padding: 20px 20px 20px 20px;
  margin-top: 100px;
}
</style>