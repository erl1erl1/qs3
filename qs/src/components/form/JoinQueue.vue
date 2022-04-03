<template>
<div id="jq">
  <h2>Bli med i kø</h2>
  <Form :initial-values="initialValues">
    <div class="input-container">
      <label>Øving</label>
      <Field as="select" class="input select" name="task" rules="required">
        <option v-for="taskNum in taskAmount" :value="'Øving ' + taskNum" :key=taskNum>Øving {{ taskNum }}</option>
      </Field>
    </div>
    <div class="input-container">
      <label>Type hjelp</label>
      <Field name="type" as="select" class="input select"  rules="required">
        <option value="Godkjenning">Godkjenning</option>
        <option value="Veiledning">Veiledning</option>
      </Field>
    </div>
    <div class="input-container">
      <label>Plassering</label>
      <Field name="location" as="select" class="input select" rules="required">
        <option value="Discord">Discord</option>
      </Field>
    </div>
    <button class="input button">Bli med i kø</button>
  </Form>
</div>
</template>

<script>
import { Form, Field } from 'vee-validate'

export default {
  name: "JoinQueue",
  components: {
    Form,
    Field
  },

  props: {
    taskAmount: Number
  },

  data() {
    return {
      initialValues: {
        task: "Øving 1",
        type: "Godkjenning",
        location: "Discord",
      }
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