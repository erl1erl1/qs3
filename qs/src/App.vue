<template>
  <div v-show="activeUser !== null" id="nav">
    <div v-if="onMobile" id="item-container">
      <img alt="logo" src="@/assets/qs-light.svg" id="nav-logo"/>
      <div id="user">
        <font-awesome-icon id="user-icon" :icon="icon" :size="iconSize" fixed-width/>
        <p style="color: #f7a81b">NicolaiSivesind</p>
      </div>
    </div>
    <div v-else>Hey</div>
  </div>
  <div id="nav-space"/>
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
    return {
      onMobile: Boolean,
      iconSize: "xs",
      icon: "user"
    }
  },

  mounted() {
    // Reactively update if mobile device
    window.addEventListener('resize', () => {
      this.onMobile = (window.innerWidth < 750)
    })
  },

  computed: {
    ...mapState([
      'activeUser'
    ]),
  }
}
</script>
<style>
@import "styles/global-styles.css";
</style>
<style scoped>
#nav {
  position: fixed;
  background-color: #102c40;
  height: 70px;
  width: 100vw;
}

#item-container {
  height: 100%;
  padding: 0 10px 0 10px;
  color: white;
  font-size: 18px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
  flex-wrap: nowrap;
}

#user {
  display: inline-flex;
  margin-left: auto;
  align-content: baseline;
}

#user-icon {
  align-self: center;
  margin: 0 3px 0 3px;
}

#nav-logo {
  height: 60px;
  margin-right: auto;
}

/* Since nav-menu is fixed, it wont take up space in body */
#nav-space {
  height: 100px;
}

</style>