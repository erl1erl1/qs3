<template>
  <div class="input-container">
    <label>{{ label }}</label>
    <Field :rules="rules" :name="name" :type="type" :placeholder="placeholder" :validateOnInput=validateOnInput />
    <span class="error">
      <ErrorMessage :name="name">{{ errorMessage }}</ErrorMessage>
    </span>
  </div>
</template>

<script>
import { Field, ErrorMessage } from 'vee-validate'

export default {
  name: "TextInput",

  components: {
    Field,
    ErrorMessage,
  },

  props: {
    label: String,
    rules: String,
    name: String,
    type: String,
    placeholder: String,
    validateOnInput: Boolean,
    errorMessage: String
  }
}
</script>

<style scoped>

</style>