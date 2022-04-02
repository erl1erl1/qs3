<template>
  <div class="form-container">
    <h1>Administrator</h1>
    <hr/>
    <h2>Legg til fag</h2>
    <Form>
      <div class="input-container">
        <label>Fagkode</label>
        <Field class="input" rules="required|alpha_num" name="subjectCode" type="number" placeholder="Fagkode" validateOnInput/>
      </div>
      <div class="input-container">
        <label>Fagnavn</label>
        <Field class="input" rules="required" name="subjectName" type="text" placeholder="Fagnavn" validateOnInput/>
      </div>
      <div class="input-container">
        <label>Lærere</label>
        <Field class="input" rules="required" name="teachers" type="text" placeholder="Lærere" validateOnInput/>
      </div>
      <div class="input-container">
        <label>Øvingslærere</label>
        <Field class="input" rules="required" name="studentAssistent" type="text" placeholder="Øvingslærere" validateOnInput/>
      </div>
      <div class="input-container">
        <label>Studenter</label>
        <Field class="input" rules="required" name="student" type="text" placeholder="Studenter" validateOnInput/>
      </div>
      <input type="file" accept=".csv" id="csvInput" />
      <button class="button">Legg til</button>
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
#csvInput {
  margin-top: -10px;
}
</style>