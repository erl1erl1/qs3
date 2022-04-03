<template>
<div id="queue-container">
  <div id="queue-info" @click="toggleToolBox">
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
  <div id="item-position" @click="toggleToolBox">
    <font-awesome-icon id="leave" icon="hashtag" size="lg"/>
    <p id="item-num">{{ position }}</p>
  </div>
  <div v-show="toolsOpen" id="tools">
    <font-awesome-icon id="check" icon="square-check" size="2x"/>
    <font-awesome-icon v-if="gettingHelp" id="hand" icon="circle-stop" size="2x"/>
    <font-awesome-icon v-else id="hand" icon="hand-holding-medical" size="2x"/>
    <font-awesome-icon id="x-mark" icon="right-from-bracket" size="2x"/>
  </div>
</div>
</template>

<script>
export default {
  name: "QueueItem",

  mounted() {
    if (this.gettingHelp) {
      document.getElementById("queue-container").style.backgroundColor = "#cce6ff"
    }
  },

  props: {
    name: String,
    location: String,
    queueTime: String,
    task: Number,
    type: String,
    position: Number,
    gettingHelp: Boolean,
    isAssistant: Boolean
  },

  data() {
    return {
      toolsOpen: false
    }
  },

  methods: {
    toggleToolBox() {
      if (this.isAssistant) {
        this.toolsOpen = !this.toolsOpen
      }
    }
  }
}
</script>

<style scoped>
p {
  margin: 1px 1px 1px 2px;
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

#tools {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  grid-area: tools;
  gap: 15px;
  padding: 5px 10px 10px 10px;
  border-top: 1px solid lightgray;
}

#item-position {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left: auto;
  margin-right: auto;
  color: darkgray;
  grid-area: position;
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
  grid-template-areas: "info info info info position"
                       "tools tools tools tools tools";
}

#leave {
  color: darkgray;
}

#check {
  color: #53b266;
}

#x-mark {
  margin-left: auto;
  color: #bd2452;
}

#hand {
  color: #f7a81b;
}

#queue-info {
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  margin: 0 0 0 10px;
  grid-area: info;
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