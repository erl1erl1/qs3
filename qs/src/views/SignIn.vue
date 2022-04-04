<template>
  <img alt="logo" class="logo" src="@/assets/qs-dark.svg">
  <div class="form-container">
    <h1>Pålogging</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <TextInput label="Brukernavn" name="username" placeholder="brukernavn" type="text"
                 rules="required|alpha_num" error-message="Brukernavn kan ikke inneholde spesielle tegn" validate-on-input/>
      <TextInput label="Passord" name="password" placeholder="passord" type="password"
                 rules="required" error-message="Du må skrive et passord" validate-on-input/>
      <button :disabled="!(meta.valid)">Logg inn</button>
    </Form>
    <p v-if="!this.correctPassword" style="color: red">Feil brukernavn eller passord</p>
    <p style="margin-bottom: 10px">Har du ikke en bruker? <router-link as="a" class="link" to="register">Registrer deg</router-link></p>
  </div>
</template>

<script>
import { Form} from 'vee-validate'
import TextInput from "../components/form/TextInput";

export default {
  name: "Login",

  mounted() {
    if (this.user != null || this.user !== 'undefined')  {
      this.$router.push("/")
    }
  },

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