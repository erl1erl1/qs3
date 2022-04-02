<template>
<div id="subject-container">
  <h2>{{ subjectCode }}</h2>
  <h3>{{ subjectName }}</h3>
</div>
</template>

<script>

export default {
  name: "SubjectTile",

  props: {
    subjectCode: String,
    subjectName: String,
  }
}
</script>

<style scoped>
h2 {
  margin-bottom: 5px;
}

h3 {
  margin-top: 5px;
  margin-bottom: 22px;
  color: #f7a81b;
}

#subject-container {
  background-color: whitesmoke;
  min-height: 100px;
  border: solid 1px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  cursor: pointer;
  min-width: 310px;
  width: 80%;
  max-width: 700px;
}

@media screen and (min-width: 1000px){
  #subject-container:hover {

  }
}
</style>