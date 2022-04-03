<template>
<div id="queue-container">
  <div id="queue-info">
    <h3 id="name">{{ name }}</h3>
    <div id="content">
      <section>
        <div class="field">
          <font-awesome-icon icon="list-check" class="field-icon" size="sm"/>
          <p>Øving{{ task }}</p>
        </div>
        <div class="field">
          <font-awesome-icon icon="handshake" class="field-icon" size="sm"/>
          <p>{{ type }}</p>
        </div>
      </section>
      <section>
        <div class="field">
          <font-awesome-icon icon="location-dot" class="field-icon" size="sm"/>
          <p>{{ location }}</p>
        </div>
        <div class="field">
          <font-awesome-icon icon="clock" class="field-icon" size="sm"/>
          <p>{{ queueTime }} min</p>
        </div>
      </section>
    </div>
  </div>
  <div id="item-position">
    <font-awesome-icon id="leave" icon="hashtag" size="lg"/>
    <p id="item-num">{{ position }}</p>
  </div>
</div>
</template>

<script>
export default {
  name: "QueueItem",

  props: {
    name: String,
    location: String,
    queueTime: String,
    task: Number,
    type: String,
    position: Number
  }
}
</script>

<style scoped>
p {
  margin: 1px 1px 1px 2px;
}

section {
}

#item-position {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: auto;
  margin-right: auto;
  color: darkgray;
}

#item-position > #item-num {
  font-size: 22px;
  font-weight: 500;
}

#queue-container {
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

#leave {
  color: darkgray;
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
  flex-direction: row;
  align-items: flex-start;
  flex-wrap: wrap;
  margin-bottom: 7px;
}

@media screen and (min-width: 750px) {
  section {
    display: flex;
  }
}
</style>