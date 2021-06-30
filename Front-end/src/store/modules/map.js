import axios from "axios";

// initial state
const state = () => ({
  markList: []
});

// getters
const getters = {};

// mutations
const mutations = {
  setMarks(state, payload) {
    state.markList = [];
    for (let i = 0; i < payload.length; i++) {
      state.markList.push({
        title: payload[i].name,
        lat: payload[i].lat,
        lng: payload[i].lng,
        content:
          '<div class="wrap">' +
          '    <div class="info">' +
          '        <div class="">' +
          '  <a href="https://www.google.com/search?q=' +
          payload[i].dong +
          " " +
          payload[i].name +
          '&sxsrf=ALeKk00j6Q8Kb0U5DNyvR9EatfPYSzwLsw:1622010180820&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjP65jl2ubwAhXM62EKHTAPCfAQ_AUoAXoECAEQAw&cshid=1622010229864722&biw=1920&bih=969" target="_blank">' +
          '    <span class="title">' +
          payload[i].name +
          " </span>" +
          "  </a>" +
          "        </div>" +
          '        <div class="body">' +
          '            <div class="desc">' +
          '                <div class="ellipsis">' +
          payload[i].city +
          "</div>" +
          '                <div class="jibun ellipsis">(지번)' +
          payload[i].jibun +
          "</div>" +
          '                <div class="ellipsis">거래가 : ' +
          payload[i].dealAmount +
          "                만원</div>" +
          '                <div class="ellipsis">층수 : ' +
          payload[i].floor +
          "                층</div>" +
          '                <div class="ellipsis">거래일 : ' +
          payload[i].dealYear +
          "                </div>" +
          "            </div>" +
          "        </div>" +
          "    </div>" +
          "</div>"
      });
    }
  }
};

// actions
const actions = {
  getMarks({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/makeMark/" + payload[2] + "/" + payload[0]
      )
      .then(({ data }) => {
        commit("setMarks", data);
      })
      .catch(() => {
        console.log("setMarks Fail");
      });
  }
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
};
