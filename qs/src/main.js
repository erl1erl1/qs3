import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// Form Validation Rules
import { defineRule } from 'vee-validate';
import { required, email, alpha_spaces, alpha_num, numeric, confirmed } from '@vee-validate/rules';

defineRule('required', required);
defineRule('email', email);
defineRule('alpha_spaces', alpha_spaces);
defineRule('numeric', numeric);
defineRule('alpha_num', alpha_num)
defineRule('confirmed', confirmed)

// custom
defineRule('min_max', (value, [min, max]) => {
    if (value.length < min) {
        return `You need at least ${min} characters`
    } else if (value.length > max) {
        return `Maximum ${max} characters`
    }
    return true
})

// Create app
createApp(App)
    .use(store)
    .use(router)
    .mount('#app')