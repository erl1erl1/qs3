<template>
  <h1>Full-stack applikasjonsutvikling</h1>
  <div id="queue">
    <QueueItem/>
    <QueueItem/>
    <QueueItem/>
  </div>
</template>

<script>
import QueueItem from "@/components/QueueItem";
export default {
  name: "Queue",
  components: { QueueItem }
}
</script>

<style scoped>
#queue {
  margin: 30px 10% 10px 10%;
  width: 80%;
  display: flex;
  justify-content: center;
  flex-direction: column;
}

#queue > div:first-of-type {
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

#queue > div:last-of-type {
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}

</style>