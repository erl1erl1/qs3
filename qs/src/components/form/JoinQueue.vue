<template>
<div id="jq">
  <h2>Bli med i kø</h2>
  <Form>
    <div class="input-container">
      <label>Øving</label>
      <select class="input select" v-model="task" name="task" rules="required">
        <option v-for="taskNum in taskAmount" :value= "taskNum" :key=taskNum>Øving {{ taskNum }}</option>
      </select>
    </div>
    <div class="input-container">
      <label>Type hjelp</label>
      <select name="queueType" v-model="queueType" class="input select" rules="required">
        <option value="Godkjenning">Godkjenning</option>
        <option value="Veiledning">Veiledning</option>
      </select>
    </div>
    <div class="input-container">
      <label>Plassering</label>
      <select name="location" v-model="location" class="input select" rules="required">
        <option>Discord</option>
        <option v-for="n in 18" :key="n">{{n}}</option>
      </select>
    </div>
    <button class="input button" @click="onSubmit">Bli med i kø</button>
  </Form>
</div>
</template>

<script>
import { Form } from 'vee-validate'

export default {
  name: "JoinQueue",
  components: {
    Form,
  },

  props: {
    taskAmount: Number,
    personId: Number,
    subjectCode: String
  },

  data() {
    return {
      task: "",
      queueType: "",
      location: "",
    }
  },

  methods: {
    async onSubmit(){
      const queueItem = {
        "personId": this.personId,
        "subjectCode": this.subjectCode,
        "assignmentId": this.task,
        "location": this.location,
        "type": this.queueType
      }
      
      await this.$store.dispatch('submitQueueItem', queueItem);
      this.$router.push("/queue");
      console.log(queueItem);
      
    }
  }
}
</script>

<style scoped>
Form {
  width: 80%;
  justify-content: stretch;
}

.button {
  align-self: center;
  margin-bottom: 30px;
}

.input-container {
  flex-direction: column;
  align-items: flex-start;
  width: 100%;
}

#jq {
  background-color: white;
  border-radius: 10px;
  min-width: 200px;
  width: 80%;
  max-width: 400px;
  min-height: 100px;
  max-height: 600px;

  display: flex;
  align-items: center;
  flex-direction: column;
  flex-wrap: wrap;
  z-index: 10;
}
</style>