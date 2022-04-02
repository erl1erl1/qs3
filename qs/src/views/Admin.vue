<template>
  <div id="inputs">
    <AddSubjects/>
    <AddStudentOrTeacher/>
    <SaveSubject/>
    <DeleteSubject/>
  </div>
</template>
<script>
import AddSubjects from "@/components/adminComponents/AddSubjects";
import AddStudentOrTeacher from "@/components/adminComponents/AddStudentOrTeacher";
import SaveSubject from "@/components/adminComponents/SaveSubject";
import DeleteSubject from "@/components/adminComponents/DeleteSubject";

export default {
  name: "Admin",
  components: {
    AddSubjects,
    AddStudentOrTeacher,
    SaveSubject,
    DeleteSubject,
  }
}
</script>


