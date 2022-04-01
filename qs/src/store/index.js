import { createStore as vuexCreateStore } from 'vuex'
import authService from '../services/auth.service';

const user = localStorage.getItem('user');
const initialState = user
  ? {status: { loggedIn: true }, user}
  : {status: { loggedIn: false }, user: null};


// Helpers
const storeConfiguration = {
  state: initialState,
  mutations: {
    SIGN_IN_SUCCESS(state, user){
      state.status.loggedIn = true;
      state.user = user;
    },
    SIGN_IN_FAILURE(state){
      state.status.loggedIn = false;
      state.user = null;
    },
    SIGN_OUT(state) {
      state.status.loggedIn = false;
      state.user = null;
    },
    REGISTER_SUCCESS(state) {
      state.status.loggedIn = false;
    },
    REGISTER_FAILURE(state) {
      state.status.loggedIn = false;
    }
  },

  actions: {
    addUser(context, user) {
      context.commit('SET_PASSWORD', user)
    },

    validateUser(context, payload) {
      const users = this.state.users;
      // Check if user exist in database
      if (!users.has(payload.username)) {
        return false;
      }

      // Check if password is right
      const registeredUser = users.get(payload.username)
      return registeredUser.password === payload.password;
    },

    signIn(context, payload){
      return authService.signIn(payload).then(
        user => {
          context.commit('SIGN_IN_SUCCESS', user)
          return Promise.resolve()
        },
        error => {
          context.commit('SIGN_IN_FAILURE')
          return Promise.reject(error);
        }
      )
    }
  },

  getters: {
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