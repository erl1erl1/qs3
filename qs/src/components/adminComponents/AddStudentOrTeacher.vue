<template>
  <div class="form-container">
    <h2>Legg til student/lærer</h2>
    <Form>
      <div class="input-container">
        <label>Student mail</label>
        <Field class="input" name="studentMail" type="email" placeholder="Email" validateOnInput/>
      </div>
      <div class="input-container">
        <label>Lærer mail</label>
        <Field class="input" name="teacherMail" type="email" placeholder="Email" validateOnInput/>
      </div>
      <button class="button">Slett</button>
    </Form>
    <hr/>
  </div>
</template>
<script>
import { Form, Field} from 'vee-validate'
import axios from "axios";
import authHeader from "@/services/header-token";

export default {
  name: "AddSubject",

  data() {
    return {
      SUBMIT_FAIL: false
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
        "subjectName": value.subjectName,
        "teachers": value.teachers,
        "studentAssistants": value.studentAssistants,
        "enrolledStudents": value.enrolledStudents,
        "assignments": value.assignments
      }

      axios.post("http://localhost:8080/subjects",
          {subject},
          {headers: authHeader()}
      ).then(response => {
        console.log(response)
      }).catch(error => {
        this.SUBMIT_FAIL = true;
        console.log(error)
      })
    },
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
  opacity: 0;
  position: absolute;
  z-index: 0;
  margin-top: -10px;
}
#labelCsv {
  font-weight: 700;
  padding: 3px 2px 3px 2px;
  text-align: right;
  color: #f7a81b;
  margin-top: -20px;
  font-size: small;
}
</style>