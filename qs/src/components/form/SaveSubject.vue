<template>
  <div class="form-container">
    <h2>Arkiver fag</h2>
    <Form>
      <div class="input-container">
        <label>Fagkode</label>
        <Field rules="required|alpha_num" name="subjectCodeSave" type="number" placeholder="Fagkode" validateOnInput/>
      </div>
      <button>Slett</button>
    </Form>
    <hr/>
  </div>
</template>

<script>
import {Field, Form} from 'vee-validate'

export default {
  name: "Admin",

  data() {
    return {
    }
  },

  components: {
    Form,
    Field,
  },

  methods: {
    onSubmit(value) {
      this.subject = {
        subjectCode: value.subjectCode,
        subjectName: value.subjectName
      }
    },
  }
}
</script>
<style scoped>
hr {
  margin-top: 25px;
}
</style>