<template>
  <h1>Dine emner</h1>
  <hr/>
  <div id="subjects">
    <SubjectTile subject-code="IDATT2105" subject-name="Full-stack applikasjonsutvikling"/>
    <SubjectTile subject-code="IDATT2104" subject-name="Nettverksprogrammering"/>
    <SubjectTile subject-code="IFYTT1001" subject-name="Fysikk"/>
  </div>
</template>

<script>
import SubjectTile from "@/components/SubjectTile";
export default {
  name: "Home",
  components: { SubjectTile }
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

#subjects {
  margin: 30px 10% 10px 10%;
  display: flex;
  justify-content: center;
  align-content: start;
  flex-wrap: wrap;
  gap: 20px;

}
</style>