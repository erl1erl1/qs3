<template>
<div class="queue-dimensions" id="container">
  <div id="queue-info">
    <h3 id="name">Nicolai Thorer Sivesind</h3>
    <div id="content">
      <div class="field">
        <font-awesome-icon icon="location-dot" class="icon" size="sm"/>
        <p>Bord 18</p>
      </div>
      <div class="field">
        <font-awesome-icon icon="clock" class="icon" size="sm"/>
        <p>2 min</p>
      </div>

    </div>
  </div>
  <div id="actions"></div>
</div>
</template>

<script>
export default {
  name: "QueueItem"
}
</script>

<style scoped>
p {
  margin: 5px 1px 5px 2px;
}

#container {
  min-height: 100px;
  min-width: 310px;
  width: 80%;
  max-width: 700px;
  background-color: whitesmoke;
  border: solid 1px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  display: flex;
  flex-wrap: wrap;
  align-items: flex-start;
  flex-direction: column;
}

.icon {
  color: #f7a81b;
  margin: 1px 4px 3px 3px;
}

.field {
  display: flex;
  flex-direction: row;
  align-items: center;
}

#queue-info {
  margin: 0 10px 0 10px;
}

#name {
  margin: 7px 2px 1px 2px;
}

#content {
  display: flex;
  justify-content: left;
  align-items: start;

}
</style>