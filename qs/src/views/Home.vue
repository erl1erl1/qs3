<template>
  <h1>Dine emner</h1>
  <div id="subjects">
    <SubjectTile/>
  </div>
</template>

<script>
import SubjectTile from "@/components/SubjectTile";
export default {
  name: "Home",
  components: {SubjectTile}
}
</script>

<style scoped>
#subjects {
  margin: 10px 10% 10px 10%;
}
</style>