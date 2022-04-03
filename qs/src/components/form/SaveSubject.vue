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
import { Form, Field} from 'vee-validate'

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
      const subject = {
        "subjectCode": value.subjectCode,
        "subjectName": value.subjectName
      }
      this.subject = subject;
    }
  }
}
</script>
<style scoped>
hr {
  min-width: 310px;
  width: 90%;
  max-width: 900px;
  border: 0;
  border-top: 1px solid rgb(0, 0, 0, 0.2);
  margin-top: 15px;
}
</style>