<template>
  <h1>Administrator</h1>
  <hr id="hr-title"/>
  <AddSubjects/>
  <AddStudentOrTeacher/>
  <DeleteSubject/>
</template>
<script>
import AddSubjects from "../components/form/AddSubject";
import AddStudentOrTeacher from "../components/form/SetPrivelige";
import DeleteSubject from "../components/form/DeleteSubject";

export default {
  name: "Admin",
  components: {
    AddSubjects,
    AddStudentOrTeacher,
    DeleteSubject,
  }
}
</script>

<style scoped>
#hr-title {
  margin-top: -15px;
}
</style>


