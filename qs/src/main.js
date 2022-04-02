// Form Validation Rules
import { defineRule } from 'vee-validate';
import { required, email, alpha_spaces, alpha_num, numeric, confirmed } from '@vee-validate/rules';

    // Presets
defineRule('required', required);
defineRule('email', email);
defineRule('alpha_spaces', alpha_spaces);
defineRule('numeric', numeric);
defineRule('alpha_num', alpha_num)
defineRule('confirmed', confirmed)

    // Custom rules
defineRule('min_max', (value, [min, max]) => {
    if (value.length < min) {
        return `You need at least ${min} characters`
    } else if (value.length > max) {
        return `Maximum ${max} characters`
    }
    return true
})

// Font Awesome Icons
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import {
    faBook, faUser, faUserGraduate,
    faLocationDot, faClock, faCircleXmark,
    faHandshake, faListCheck, faHashtag
} from '@fortawesome/free-solid-svg-icons'

    // Add icons to library
library.add(
    faBook, faUser, faUserGraduate,
    faLocationDot, faClock, faCircleXmark,
    faHandshake, faListCheck, faHashtag
)

// Create app
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

createApp(App)
    .use(store)
    .use(router)
    .component('font-awesome-icon', FontAwesomeIcon)
    .mount('#app')