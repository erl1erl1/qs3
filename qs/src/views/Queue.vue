<template>
  <h1>{{  getActiveSubject.subjectName  }}</h1>
  <div id="queue">
    <QueueItem name="Nicolai Thorer Sivesind" location="Bord 3" queue-time="2 min" task="Øving 2" type="Godkjenning"/>
  </div>
</template>

<script>
import QueueItem from "@/components/QueueItem";
import authHeader from "../services/header-token";
import axios from 'axios';
import { mapGetters } from "vuex";
export default {
  name: "Queue",
  components: { QueueItem },
  data(){
    return {
      queueItems: null,
      names: null
    }
  },
  computed: {
    ...mapGetters([
      'getActiveSubject',
    ]),
    subjectCode(){
      return this.$store.subject.subjectCode;
    }
  },
   mounted(){

    console.log(this.queueItems);
  },
  methods:{
    getQueue(subjectCode){
      axios.get("http://localhost:8080/subjects/" + subjectCode(), {headers: authHeader()}).then(
      resp => {
        this.queueItems = resp.data;
      }
    )
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