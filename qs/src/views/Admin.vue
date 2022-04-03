<template>
  <div id="inputs">
    <AddSubjects/>
    <AddStudentOrTeacher/>
    <SaveSubject/>
    <DeleteSubject/>
  </div>
</template>
<script>
import AddSubjects from "@/components/form/AddSubjects";
import AddStudentOrTeacher from "@/components/form/AddStudentOrTeacher";
import SaveSubject from "@/components/form/SaveSubject";
import DeleteSubject from "@/components/form/DeleteSubject";

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


