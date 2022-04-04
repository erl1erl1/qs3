<template>
  <div id="container">
    <div v-show="showJoinQueue" id="jq-container">
      <div id="jq-bg" @click="toggleJoinQueue"></div>
      <JoinQueue :task-amount="getActiveSubject.assignments" :personId="getUser.personId" :subjectCode="getActiveSubject.subjectCode" />
    </div>
    <div id="header">
      <h2>{{ getActiveSubject.subjectCode }}</h2>
      <h2>{{ getActiveSubject.subjectName }}</h2>
    </div>
    <hr>
    <section>
      <p v-if="inQueue">Din posisjon:</p>
        <p v-else>Antall personer i køen:</p>
      <div  id="size-nums">
        <div v-if="inQueue">
          <font-awesome-icon icon="hashtag" size="4x"/>
          <p class="pos-num">{{  this.queueItems.map(function(e) { return e.personId}).indexOf(this.currentUser.personId) + 1  }} / {{  this.queueItems.length  }}</p>
        </div>
        <p v-else class="pos-num">{{  this.queueItems.length  }}</p>
      </div>
    </section>
    <section id="buttons">
      <button v-if="!inQueue" class="button" id="join" @click="toggleJoinQueue" :disabled="isAssistant">Bli med i kø</button>
      <button v-else class="button" id="leave" @click="deleteQueueItem" :disabled="isAssistant">Forlat kø</button>
      <button class="button" :disabled="isAssistant">Øvinger</button>
    </section>
    <section id="queue">
      <QueueItem v-for="(q, index) in queueItems" v-bind:key="this.componentKey + index"
                 :name="q.name" :location="q.location" :queue-time="q.time" :task="q.assignmentId" :type="q.type" 
                 :position="index+1" :getting-help="q.beingHelped" :is-assistant="isAssistant" :personId="q.personId"
                 @clickFromQueueItem="updateQueue"/>
    </section>
  </div>
</template>

<script>
import QueueItem from "@/components/QueueItem";
import { mapGetters } from "vuex";
import JoinQueue from "@/components/form/JoinQueue";

export default {
  name: "Queue",
  components: { JoinQueue, QueueItem },
  data(){
    return {
      queueItems: [],
      newQueueItems: [],
      names: null,
      counter: 0,
      inQueue: false,
      subjectCode: null,
      currentUser: null,
      showJoinQueue: false,
      isAssistant: false,
      componentKey: 0,
    }
  },

  computed: {
    ...mapGetters([
      'getUser',
      'getActiveSubject'
    ]),
  },

  mounted(){
    this.setUser();
    this.getQueue();
    this.updateQueue();
    this.isAssistant = this.getUser.role === 'Øvingslærer';
  },

  created() {
    this.getQueue();
    setInterval(() =>
      this.updateQueue(), 15000);
  },

  methods: {
    async updateQueue(){
      //Get queue items
      await this.$store.dispatch('getQueue').then(resp => this.newQueueItems = resp.data);
      if(this.newQueueItems !== this.queueItems){
        this.queueItems = this.newQueueItems;
        this.getNames();
        this.checkIfUserInQueue();
        console.log(this.queueItems[0].beingHelped)
        this.forceUpdate();
        return;
      }
    },
    async setUser(){
      this.currentUser = this.getUser;
    },
    async deleteQueueItem(){
      let details = {
        "subjectCode": this.getActiveSubject.subjectCode,
        "personId": this.currentUser.personId
      }
      await this.$store.dispatch('deleteQueueItem', details);
      this.updateQueue();
      this.inQueue = false;
    },
    async getQueue(){
      await this.$store.dispatch('getQueue').then(resp => this.queueItems = resp.data);
    },
    async getNames(){
      for(let i = 0; i < this.queueItems.length; i++){
        if(!(typeof this.queueItems[i].name == 'string')){
          await this.$store.dispatch('getName', this.queueItems[i].personId).then(resp => this.queueItems[i].name = resp);
        }
      } 
    },
    forceUpdate(){
      this.componentKey++;
    },

    checkIfUserInQueue(){
      for(let i = 0; i < this.queueItems.length; i++){
        if(this.queueItems[i].personId == this.currentUser.personId){
          this.inQueue = true;
          return;
        }
        this.inQueue = false;
      }
    },
    toggleJoinQueue() {
      this.showJoinQueue = !this.showJoinQueue
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

#jq-container {
  position: absolute;
  top: 0;
  height: 100vh;
  width: 100vw;

  display: flex;
  align-items: center;
  justify-content: center;
}

#jq-bg {
  position: absolute;
  width: 100%;
  height: 100%;
  background-color: rgb(0, 0, 0, 0.8);
  z-index: 5;
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