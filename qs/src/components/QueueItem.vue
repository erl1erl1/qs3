<template>
<div id="container">
  <div id="queue-info">
    <h3 id="name">{{ name }}</h3>
    <div id="content">
      <div class="field">
        <font-awesome-icon icon="location-dot" class="field-icon" size="sm"/>
        <p>{{ location }}</p>
      </div>
      <div class="field">
        <font-awesome-icon icon="clock" class="field-icon" size="sm"/>
        <p>{{ queueTime }}</p>
      </div>
      <div class="field">
        <font-awesome-icon icon="list-check" class="field-icon" size="sm"/>
        <p>{{ task }}</p>
      </div>
      <div class="field">
        <font-awesome-icon icon="handshake" class="field-icon" size="sm"/>
        <p>{{ type }}</p>
      </div>
    </div>
  </div>
  <div id="actions">
    <font-awesome-icon id="clock" icon="circle-xmark" size="2xl"/>
  </div>
</div>
</template>

<script>
export default {
  name: "QueueItem",

  props: {
    name: String,
    location: String,
    queueTime: Number,
    task: String,
    type: String
  }
}
</script>

<style scoped>
p {
  margin: 1px 1px 1px 2px;
}

#actions {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: auto;
  margin-right: auto;
}

#container {
  min-height: 60px;
  min-width: 310px;
  width: 80%;
  max-width: 700px;
  margin: 0 auto 0 auto;
  background-color: whitesmoke;
  border: solid 1px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  display: grid;
  grid-template-columns: 80% 20%;
}

.field-icon {
  color: #f7a81b;
  margin: 1px 4px 3px 0;
}

.field {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: 0 5px 0 5px;
}

#clock {
  color: #af292f;
}

#queue-info {
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  margin: 0 0 0 10px;
}

#name {
  margin: 7px 2px 1px 2px;
}

#content {
  display: flex;
  justify-content: left;
  align-items: flex-start;
  flex-wrap: wrap;
  margin-bottom: 7px;
}
</style>