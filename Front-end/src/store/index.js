import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";
import search from "./modules/search";
import dashboard from "./modules/dashboard";
import user from "./modules/user";
import map from "./modules/map";
Vue.use(Vuex);
export default new Vuex.Store({
  modules: {
    search,
    dashboard,
    user,
    map
  }
});
