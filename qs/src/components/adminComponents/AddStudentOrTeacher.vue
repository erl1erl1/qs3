<template>
  <div class="form-container">
    <hr/>
    <div class="form-container">
      <h2>Legg til student/lærer</h2>
      <Form>
        <div class="input-container">
          <label>Student navn</label>
          <Field class="input" name="studentIndividual" type="text" placeholder="Student navn" validateOnInput/>
        </div>
        <div class="input-container">
          <label>Lærer navn</label>
          <Field class="input" name="teacherIndividual" type="text" placeholder="Lærer navn" validateOnInput/>
        </div>
        <div class="input-container">
          <label>Fagkode</label>
          <Field class="input" rules="required|alpha_num" name="subjectCodeIndividual" type="number" placeholder="Fagkode" validateOnInput/>
        </div>
        <button class="button">Legg til</button>
      </Form>
      <hr/>
    </div>
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
