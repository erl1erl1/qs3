<template>
  <h1>{{  this.queueItems[0].subjectCode  }}</h1>
  <div id="queue" v-for="q in queueItems" v-bind:key="q.personId">
    <QueueItem :name="q.name" :location="q.location" :queue-time="q.date" :task="q.assignmentId" :type="q.type"/>
  </div>
</template>

<script>
import QueueItem from "@/components/QueueItem";
import { mapGetters } from "vuex";
export default {
  name: "Queue",
  components: { QueueItem },
  data(){
    return {
      queueItems: [],
      names: null,
      counter: 0
    }
  },
  computed: {
    ...mapGetters([
      'getActiveSubject',
    ]),
  },
  mounted(){
    this.updateQueue();
  },
  methods: {
    async updateQueue(){
      await this.$store.dispatch('getQueue').then(resp => this.queueItems = resp.data);
      for(let i = 0; i < this.queueItems.length; i++){
        this.queueItems[i].name = await this.$store.dispatch('getName', this.queueItems[i].personId).then(resp => resp.data);
      }
    },
    countSeconds(){
      setTimeout(() => {
        this.counter++;
        this.countSeconds()
      }, 1000);
    }
  }
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