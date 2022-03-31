import { createStore as vuexCreateStore } from 'vuex'


// Helpers
const storeConfiguration = {
  state: {
    activeUser: null,
    users: new Map,
  },
  mutations: {
    SET_PASSWORD(state, user) {
      state.users.set(user.username, {
        username: user.username,
        password: user.password
      })
    },
    SET_ACTIVE_USER(state, user) {
      state.activeUser = user
    }
  },

  actions: {
    addUser(context, user) {
      context.commit('SET_PASSWORD', user)
    },

    validateUser(context, payload) {
      const users = this.state.users
      // Check if user exist in database
      if (!users.has(payload.username)) {
        return false
      }

      // Check if password is right
      const registeredUser = users.get(payload.username)
      return registeredUser.password === payload.password;
    },

    setActiveUser(context, payload) {
      context.commit('SET_ACTIVE_USER', this.state.users.get(payload.username))
    }
  },

  getters: {
    getUsers(state) {
      return state.users
    }
  },

  modules: {
  }
}

const defaultOverrides = {
  state: () => {
    return {

    }
  }
}

// Default
export default createStore(storeConfiguration)

// Testing
export function createStore(storeOverrides = defaultOverrides) {
  return vuexCreateStore({
    ...storeConfiguration,
    ...storeOverrides,
    ... {
      state: makeState(storeConfiguration.state, storeOverrides.state)
    }
  })
}

// Helper functions
function makeState(initialState, overridesState) {
  return {
    ...(typeof initialState === 'function' ? initialState() : initialState ),
    ...overridesState
  }
}