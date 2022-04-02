<template>
  <div id="container">
    <div id="header">
      <h2>{{ this.subjectCode }}</h2>
      <h3>{{  this.subjectName  }}</h3>
    </div>
    <hr>
    <section>
      <p v-if="inQueue">Din posisjon:</p>
      <p v-else>Antall personer i køen:</p>
      <div  id="size-nums">
        <div v-if="inQueue">
          <font-awesome-icon icon="hashtag" size="4x"/>
          <p class="pos-num">22/30</p>
        </div>
        <p v-else class="pos-num">30</p>
      </div>
    </section>
    <section id="buttons">
      <button v-if="!inQueue" class="button" id="join">Bli med i kø</button>
      <button v-else class="button" id="leave">Forlat kø</button>
      <button class="button">Øvinger</button>
    </section>
    <section id="queue">
      <QueueItem v-for="(q, index) in queueItems" v-bind:key="q.personId"
                 :name="q.name" :location="q.location" :queue-time="q.time" :task="q.assignmentId" :type="q.type" :position="index+1"/>
      <QueueItem name="Nicolai Thorer Sivesind" location="Bord 3" queue-time="17 min" task="2" type="Godkjenning" position="2"/>
      <QueueItem name="Erlend Rønning" location="Bord 14" queue-time="7 min" task=5 type="Hjelp" position="3"/>
      <QueueItem name="Aleksander Brekke Røed" location="Bord 3" queue-time="1 min" task="2" type="Godkjenning" position="4"/>
    </section>
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
      counter: 0,
      inQueue: false,
      subjectName: null,
      subjectCode: null
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
      this.subjectName = this.queueItems[0].subjectName;
      this.subjectCode = this.queueItems[0].subjectCode;
      for(let i = 0; i < this.queueItems.length; i++){
        this.queueItems[i].name = await this.$store.dispatch('getName', this.queueItems[i].personId).then(resp => resp.data);
      }
    }
  }
}
</script>

<style scoped>
p {
  margin: 0 0 0 3px;
}

h2 {
  margin: 0;
}

h3 {
  margin-top: 0;
  margin-bottom: 3px;
  color: #f7a81b;
}


h1 {
  margin-bottom: 7px;
}

.pos-num {
  font-size: 70px;
  font-weight: bold;
  margin: 0 0 0 3px;
}

#container {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: center;
  flex-wrap: nowrap;
}

#header {
  display: flex;
  justify-content: center;
  flex-direction: column;
  flex-wrap: wrap;
  margin-top: 10px;
}

#size-nums {
  margin: -10px auto 0 auto;
  display: inline-flex;
  align-items: center;
  flex-direction: row;
  flex-wrap: wrap;
  color: #f7a81b;
}

#buttons {
  display: flex;
  gap: 10px;
}

#join {
  background-color: #102c40;
}

#leave {
  background-color: #bd2452;
}

#queue {
  margin: 15px 10% 10px 10%;
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