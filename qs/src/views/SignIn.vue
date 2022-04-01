<template>
  <img alt="logo" class="logo" src="@/assets/qs-dark.svg">
  <div class="form-container">
    <h1>Pålogging</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <div class="input-container">
        <label>Brukernavn</label>
        <Field class="input" rules="required|alpha_num" name="username" type="text" placeholder="brukernavn" validateOnInput/>
      </div>
      <div class="input-container">
        <label>Passord</label>
        <Field class="input" rules="required" name="password" type="password" placeholder="passord" validateOnInput/>
      </div>
      <button class="button" :disabled="!(meta.valid)">Logg inn</button>
    </Form>
    <p v-if="!this.correctPassword" style="color: red">Incorrect credentials</p>
    <p style="margin-bottom: 10px">Har du ikke en bruker? <router-link as="a" class="link" to="register">Registrer deg</router-link></p>
  </div>
</template>

<script>
import { Form, Field} from 'vee-validate'

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
  },

  methods: {
    onSubmit(value) {
      const user = {
        "username": value.username,
        "password": value.password
      }

      this.$store.dispatch("signIn", user).then(
        () => {
          this.$router.push("/")
        },
        (error) => {
          this.correctPassword = false;
          console.log(error)
        }    
      )
    }
  }
}
</script>