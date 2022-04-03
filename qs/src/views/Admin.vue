<template>
  <div id="inputs">
    <AddSubjects/>
    <AddStudentOrTeacher/>
    <DeleteSubject/>
  </div>
</template>
<script>
import AddSubjects from "../components/form/AddSubjects";
import AddStudentOrTeacher from "../components/form/AddStudentOrTeacher";
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


