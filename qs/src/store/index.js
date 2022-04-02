import axios from 'axios';
import { createStore as vuexCreateStore } from 'vuex'
import authService from '../services/auth.service';
import authHeader from '../services/header-token';

const user = localStorage.getItem('user');
const initialState = user
  ? {status: { loggedIn: true }, user, subject: null}
  : {status: { loggedIn: false }, user: null, subject: null};

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
    },
    SET_SUBJECT(state, subject){
      state.subject = subject;
    },
    SET_SUBJECT_FALURE(state){
      state.subject = null;
    }
  },

  actions: {
    signIn(context, payload){
      return authService.signIn(payload).then(
        user => {
          context.commit('SIGN_IN_SUCCESS', user);
          console.log(user.subjects)
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
    },

    setSubject(context, payload){
      return axios.get("http://localhost:8080/subjects/" + payload.subjectCode, {headers: authHeader()}).then(
        response => {
          context.commit('SET_SUBJECT', response.data);
          console.log(response.data);
          return Promise.resolve(response.data);
        },
        error => {
          context.commit('SET_SUBJECT_FAILURE');
          return Promise.reject(error);
        }
      )

    }
  },

  getters: {
    getSubjects(state){
      return  state.user.subjects;
    },
    getActiveSubject(state){
      console.log(state.subject)
      return state.subject;
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