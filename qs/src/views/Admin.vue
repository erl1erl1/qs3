<template>
  <div id="inputs">
    <AddSubjects/>
    <AddStudentOrTeacher/>
    <DeleteSubject/>
  </div>
</template>
<script>
import AddSubjects from "@/components/adminComponents/AddSubjects";
import AddStudentOrTeacher from "@/components/adminComponents/AddStudentOrTeacher";
import DeleteSubject from "@/components/adminComponents/DeleteSubject";

export default {
  name: "Admin",
  components: {
    AddSubjects,
    AddStudentOrTeacher,
    DeleteSubject,
  }
}
</script>


