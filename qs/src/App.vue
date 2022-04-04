<template>
  <div v-show="user !== null" id="nav">
    <div id="item-container">
      <img alt="logo" src="@/assets/qs-light.svg" id="nav-logo"/>
      <div id="user">
        <font-awesome-icon id="user-icon" :icon="icon" :size="iconSize" fixed-width @click="signOut"/>
        <p v-if="this.user" style="color: #f7a81b">{{this.user.name}}</p>
        <p v-else></p>
      </div>
    </div>
  </div>
  <div id="nav-space"/>
  <router-view/>
</template>

<script>
import { mapState } from 'vuex'
import { DESKTOP_BP } from "@/utils/constants";

export default {
  created() {
    // this.$store.commit('SET_ACTIVE_USER', {username: "username", password: "password"})
    // ^^^ Comment out this line before production ^^^

    if (this.user == null || this.user === 'undefined') {
      this.$router.push("/signin")
    }
  },

  computed: {
    ...mapState([
      'user',
    ]),
  },

  data() {
    return {
      onMobile: Boolean,
      iconSize: "xs",
      icon: "user",
      currentUser: null,
      pageOffset: window.pageYOffset,
    }
  },

  watch: {
    pageOffset(newPos, oldPos) {
      if (newPos > oldPos) {
        document.getElementById("nav").style.top = "-70px";
      } else {
        document.getElementById("nav").style.top = "0";
      }
    }
  },

  mounted() {
    // Reactively update if mobile device
    window.addEventListener('resize', () => {
      this.onMobile = (window.innerWidth < DESKTOP_BP)
    })

    // Scroll eventlistener
    window.addEventListener("scroll", this.onScroll)
  },

  beforeUnmount() {
    window.removeEventListener("scroll", this.onScroll, true)
  },

  methods: {
    onScroll() {
      this.pageOffset = window.pageYOffset
    },
    signOut(){
      this.$store.dispatch('signOut');
      this.$router.push("/signin")
    }  
  }

}
</script>
<style>
@import "styles/global-styles.css";
</style>
<style scoped>
#nav {
  position: fixed;
  top: 0;
  background-color: #102c40;
  height: 70px;
  width: 100vw;
  transition: top 0.2s;
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
  cursor: pointer;
}

#user-icon {
  align-self: center;
  margin: 0 3px 0 3px;
}

#nav-logo {
  height: 80%;
  margin-right: auto;
  cursor: pointer;
}

/* Since nav-menu is fixed, we need to restrict that space within relative positioning */
#nav-space {
  height: 70px;
}

@media screen and (min-width: 750px){
  #nav-space {
    height: 60px;
  }

  #nav {
    height: 50px;
    box-shadow: 0 2px 10px 0 rgba(0, 0, 0, 0.3);
  }
}

</style>