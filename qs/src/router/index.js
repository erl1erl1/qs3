import { createRouter, createWebHistory } from "vue-router";
import SignIn from "@/views/SignIn.vue";

const routes = [
  {
    path: "/",
    name: "SignIn",
    component: SignIn,
  },
  {
    path: "/signup",
    name: "SignUp",
    component: () => import("../views/SignUp.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
