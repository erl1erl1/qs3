<template>
  <h1>Dine emner</h1>
  <hr/>
  <div id="subjects" v-for="s in getSubjects" v-bind:key="s.subjectCode">
    <SubjectTile :subject-code="s.subjectCode" :subject-name="s.subjectName"></SubjectTile>
  </div>
</template>

<script>
import SubjectTile from "@/components/SubjectTile";
import { mapGetters } from "vuex";

export default {
  name: "Home",
  components: {SubjectTile},
  computed: {
    ...mapGetters([
        'getSubjects',
    ]),
    /*
    getSubjects(){
      return this.$store.getters.getSubjects
    }
    */
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
}

ul {
  list-style-type: none;
}

#subjects {
  margin: 30px 10% 10px 10%;
  display: flex;
  justify-content: center;
  align-content: start;
  flex-wrap: wrap;
  gap: 20px;

}
</style>