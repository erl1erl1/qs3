<template>
  <img alt="logo" class="logo" src="@/assets/qs-dark.svg">
  <div class="form-container">
    <h1>Pålogging</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <TextInput label="Brukernavn" name="username" placeholder="brukernavn" type="text"
                 rules="required" error-message="Du må skrive et brukernavn" validate-on-input/>
      <TextInput label="Passord" name="password" placeholder="passord" type="password"
                 rules="required" error-message="Du må skrive et passord" validate-on-input/>
      <button :disabled="!(meta.valid)">Logg inn</button>
    </Form>
    <p v-if="!this.correctPassword" style="color: red">Feil brukernavn eller passor</p>
    <p style="margin-bottom: 10px">Har du ikke en bruker? <router-link as="a" class="link" to="register">Registrer deg</router-link></p>
  </div>
</template>

<script>
import { Form} from 'vee-validate'
import TextInput from "../components/form/TextInput";

export default {
  name: "Login",

  data() {
    return {
      correctPassword: true
    }
  },

  components: {
    Form,
    TextInput,
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