<template>
  <div v-show="activeUser !== null" id="nav">
    <!-- router here !-->
  </div>
  <font-awesome-icon icon="book" size="6x" /> <br><br>
  <font-awesome-icon icon="user-graduate" size="6x" /> <br><br>
  <font-awesome-icon icon="gear" size="6x" />
  <router-view/>
</template>

<script>
import { mapState } from 'vuex'

export default {
  created() {
    this.$store.commit('SET_ACTIVE_USER', {username: "username", password: "password"})
    // ^^^ Comment out this line before production ^^^

    if (this.activeUser === null) {
      this.$router.push('/signin')
    }
  },

  data() {
    return {}
  },

  computed: {
    ...mapState([
      'activeUser'
    ])
  }
}
</script>
<style>
@import "styles/global-styles.css";

#nav {
  position: relative;
  grid-area: menu;
  background-color: transparent;
  border-radius: 0 0 8px 8px;
  height: 100px;
  color: white;
  font-size: 18px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-margin-before: 0;
  margin-block-start: 0;
  -webkit-margin-after: 0;
  margin-block-end: 0;
  -webkit-padding-start: 0;
  -moz-padding-start: 0;
  padding-inline-start: 0;
}

</style>