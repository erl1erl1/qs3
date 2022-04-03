<template>
  <h1>Dine emner</h1>
  <hr/>
  <div id="subjects" v-for="s in getSubjects" v-bind:key="s.subjectCode">
    <SubjectTile :subject-code="s.subjectCode" :subject-name="s.subjectName" @click="setSubject(s.subjectCode)"></SubjectTile>
  </div>
</template>

<script>
import SubjectTile from "@/components/SubjectTile";
import { mapGetters } from "vuex";

export default {
  name: "Home",
  components: { SubjectTile },
  computed: {
    ...mapGetters([
        'getSubjects',
    ]),
  },
  methods: {
    setSubject(value){
      let subject = {
        "subjectCode": value
      }

      this.$store.dispatch('setSubject', subject).then(
        () => {
          this.$router.push("/queue");
        },
        error => {
          console.log(error);
        }
      )
    }
  },
  mounted(){
    this.getSubjects
  }
}
</script>

<style scoped>

h1 {
  margin-bottom: 7px;
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