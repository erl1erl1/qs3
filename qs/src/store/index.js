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
    },
    SET_ACTIVE_USER(state, user){
      state.user = user;
    }
  },

  actions: {
    signIn(context, payload){
      return authService.signIn(payload).then(
        user => {
          context.commit('SIGN_IN_SUCCESS', user);
          return Promise.resolve(user);
        },
        error => {
          context.commit('SIGN_IN_FAILURE')
          return Promise.reject(error);
        }
      )
    },

    signUp(context, payload){
      return authService.register(payload).then(
        response => {
          context.commit('REGISTER_SUCCESS');
          return Promise.resolve(response.data);
        },
        error => {
          context.commit('REGISTER_FAILURE');
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