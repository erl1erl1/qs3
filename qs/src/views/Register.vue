<template>
  <img alt="logo" class="logo" src="@/assets/qs-dark.svg">
  <div class="form-container">
    <h1>Registrer bruker</h1>
    <Form @submit="onSubmit" v-slot="{ meta }">
      <TextInput label="Fullt navn" name="name" placeholder="Fullt navn" type="text"
                 rules="required|alpha_spaces" error-message="Navn kan kun inneholde bokstaver"/>
      <TextInput label="Brukernavn" name="username" placeholder="brukernavn" type="text"
                 rules="required|alpha_num|min_max:3,16" error-message="Brukernavn må være mellom 3 og 16 karakterer langt"/>
      <TextInput label="Passord" name="password" placeholder="passord" type="password"
                 rules="required" error-message="Passord kan ikke være tomt"/>
      <TextInput label="Bekreft passord" name="confirm" placeholder="passord" type="password"
                 rules="required|confirmed:@password" error-message="Passordene samstemmer ikke" validate-on-input
      />
      <button :disabled="!(meta.valid)">Registrer deg</button>
    </Form>
    <p style="margin-bottom: 10px">Har du allerede en bruker? <router-link as="a" class="link" to="/signin">Log inn</router-link></p>
  </div>
</template>

<script>
import { Form } from 'vee-validate'
import TextInput from "@/components/form/TextInput";

export default {
  name: "Login",

  data() {
    return {
      initialErrors: {
        name: "Navn kan kun inneholde bokstaver",
        username: "Brukernavn må være mellom 3 og 16 karakterer langt",
        password: "Passord kan ikke være tomt",
        confirm: "Passordene samstemmer ikke",
      }
    }
  },

  components: {
    TextInput,
    Form,
  },

  methods: {
    onSubmit(value){
      const user = {
        "name": value.name,
        "username": value.username,
        "password" : value.password,
        "role": "student"
      }

      this.$store.dispatch("signUp", user).then(
        () => {
          this.$router.push("/signIn")
        },
        (error) => {
          console.log(error)
        }
      )
    }
  }
}
</script>