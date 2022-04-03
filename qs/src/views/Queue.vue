<template>
  <div id="container">
    <div id="header">
      <h2>{{ this.subjectCode }}</h2>
    </div>
    <hr>
    <section>
      <p v-if="inQueue">Din posisjon:</p>
      <p v-else>Antall personer i køen:</p>
      <div  id="size-nums">
        <div v-if="inQueue">
          <font-awesome-icon icon="hashtag" size="4x"/>
          <p class="pos-num">{{  this.queueItems.map(function(e) { return e.personId}).indexOf(this.currentUser.personId)  }} / {{  this.queueItems.length  }}</p>
        </div>
        <p v-else class="{{  this.queueItems.length  }}">30</p>
      </div>
    </section>
    <section id="buttons">
      <button v-if="!inQueue" class="button" id="join">Bli med i kø</button>
      <button v-else class="button" id="leave" @click="deleteQueueItem">Forlat kø</button>
      <button class="button">Øvinger</button>
    </section>
    <section id="queue">
      <QueueItem v-for="(q, index) in queueItems" v-bind:key="q.personId"
                 :name="q.name" :location="q.location" :queue-time="q.time" :task="q.assignmentId" :type="q.type" :position="index+1"/>
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
      newQueueItems: [],
      names: null,
      counter: 0,
      inQueue: false,
      subjectName: null,
      subjectCode: null,
      currentUser: null
    }
  },
  computed: {
    ...mapGetters([
      'getUser',
    ]),
  },
  mounted(){
    this.setUser();
    this.getQueue();
    this.updateQueue();
  },
  created() {
    setInterval(() =>
      this.updateQueue(), 15000);
  },
  methods: {
    async updateQueue(){
      //Get queue items
      await this.$store.dispatch('getQueue').then(resp => this.newQueueItems = resp.data);
      if(this.newQueueItems != this.queueItems){
        this.queueItems = this.newQueueItems;
        this.getNames();
        this.checkIfUserInQueue();
        return;
      }

      //Check if current user is in queue
      //<QueueItem name="Nicolai Thorer Sivesind" location="Bord 3" queue-time="17 min" task="2" type="Godkjenning" position="2"/>
      //<QueueItem name="Erlend Rønning" location="Bord 14" queue-time="7 min" task=5 type="Hjelp" position="3"/>
      //<QueueItem name="Aleksander Brekke Røed" location="Bord 3" queue-time="1 min" task="2" type="Godkjenning" position="4"/>
    },
    async setUser(){
      await this.$store.dispatch('getUser').then(resp => this.currentUser = resp);
    },
    async deleteQueueItem(){
      let details = {
        "subjectCode": this.subjectCode,
        "personId": this.currentUser.personId
      }
      await this.$store.dispatch('deleteQueueItem', details);
      this.updateQueue();
    },
    async getQueue(){
      await this.$store.dispatch('getQueue').then(resp => this.queueItems = resp.data);
      this.subjectCode = this.queueItems[0].subjectCode;
    },
    async getNames(){
      for(let i = 0; i < this.queueItems.length; i++){
          if(!(typeof this.queueItems[i].name == 'string')){
            await this.$store.dispatch('getName', this.queueItems[i].personId).then(resp => this.queueItems[i].name = resp);
          }
        }
    },
    checkIfUserInQueue(){
      for(let i = 0; i < this.queueItems.length; i++){
        if(this.queueItems[i].personId == this.currentUser.personId){
          this.inQueue = true;
          return;
        }
        this.inQueue = false;
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