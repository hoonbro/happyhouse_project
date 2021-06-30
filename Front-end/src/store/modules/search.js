import axios from "axios";

// initial state
const state = () => ({
  maxDong: "",
  city: "",
  gugun: "",
  dong: "",
  citys: [],
  guguns: [],
  dongs: [],
  aptList: [],
  apt: "",
  lat: 37.5639226938053,
  lng: 126.97704584308674,
  searchType: ""
});

// getters
const getters = {
  getDong(state) {
    return state.dong;
  },
  getGugun(state) {
    return state.gugun;
  },
  getApt(state) {
    return state.apt;
  },
  aptList: state => state.aptList,
  maxDong: state => state.maxDong
};

// mutations
const mutations = {
  getCitySuccess(state, payload) {
    state.citys = payload;
  },
  getGugunSuccess(state, payload) {
    state.guguns = payload;
  },
  getDongSuccess(state, payload) {
    state.dongs = payload;
  },
  dongSearchSuccess(state, payload) {
    state.aptList = [];
    state.aptList = payload;
  },
  aptSearchSuccess(state, payload) {
    state.aptList = [];
    state.aptList = payload;
  },
  setApt(state, payload) {
    state.searchType = "apt";
    state.apt = payload;
  },
  setArea(state, payload) {
    state.searchType = "dong";
    state.city = payload[0];
    state.gugun = payload[1];
    state.dong = payload[2];
  },
  setLatLng(state, payload) {
    state.lat = payload.lat;
    state.lng = payload.lng;
  },
  setMaxArea(state, payload) {
    state.city = payload.city;
    state.gugun = payload.gugun;
    state.dong = payload.dong;
  }
};

// actions
const actions = {
  getCitys({ commit }) {
    axios
      .get("http://localhost/api/addr/getCity")
      .then(({ data }) => {
        commit("getCitySuccess", data);
      })
      .catch(() => {
        console.log("getCity Fail");
      });
  },
  getGuguns({ commit }, payload) {
    axios
      .get("http://localhost/api/addr/getGugun/" + payload)
      .then(({ data }) => {
        commit("getGugunSuccess", data);
      })
      .catch(() => {
        console.log("getGugun Fail");
      });
  },
  getDongs({ commit }, payload) {
    axios
      .post("http://localhost/api/addr/getDong", {
        city: payload[0],
        gugun: payload[1]
      })
      .then(({ data }) => {
        commit("getDongSuccess", data);
      })
      .catch(() => {
        console.log("getDong Fail");
      });
  },
  aptSearch({ commit }, payload) {
    if (payload == "") {
      alert("아파트명 입력");
      return;
    }
    commit("setApt", payload);
    axios
      .get("http://localhost/api/house/aptSearch/" + payload)
      .then(({ data }) => {
        let apts = [];

        for (let i = 0; i < data.length; i++) {
          apts[i] = {
            아파트명: data[i].name,
            동: data[i].dong,
            건설년도: data[i].buildYear,
            거래년도: data[i].dealYear,
            "거래금액(만원)": data[i].dealAmount
              .toString()
              .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","),
            면적: data[i].area,
            분류: data[i].type
          };
        }
        commit("aptSearchSuccess", apts);
      })
      .catch(() => {
        alert(payload + "에 맞는 결과가 없습니다.");
      });
  },
  dongSearch({ commit }, payload) {
    if (payload[0] == "도/광역시") {
      alert("도/광역시를 선택하세요.");
      return false;
    }
    if (payload[1] == "시/구/군") {
      alert("시/구/군을 선택하세요.");
      return false;
    }
    if (payload[2] == "동") {
      alert("동을 선택하세요.");
      return;
    }
    commit("setArea", payload);
    axios
      .post("http://localhost/api/house/dongSearch", {
        city: payload[0],
        gugun: payload[1],
        dong: payload[2]
      })
      .then(({ data }) => {
        let apts = [];
        for (let i = 0; i < data.length; i++) {
          apts[i] = {
            아파트명: data[i].name,
            동: payload[2],
            건설년도: data[i].buildYear,
            거래년도: data[i].dealYear,
            "거래금액(만원)": data[i].dealAmount
              .toString()
              .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","),
            면적: data[i].area,
            분류: data[i].type
          };
        }
        commit("dongSearchSuccess", apts);
      })
      .catch(() => {
        console.log("dongSearch Fail");
      });
  },
  getLatLng({ commit }, payload) {
    // if (payload[0] != "") {
    //   payload[1] = state.maxDong;
    // }
    // console.log(payload[1]);

    if (payload == "동") {
      return;
    }
    axios
      .get("http://localhost/api/addr/getLatLng/" + payload)
      .then(({ data }) => {
        commit("setLatLng", data);
      })
      .catch(() => {
        commit("getLatLng Fail");
      });
  },
  getMaxArea({ commit }, payload) {
    axios
      .get("http://localhost/api/addr/getMaxArea/" + payload)
      .then(({ data }) => {
        commit("setMaxArea", data);
      })
      .catch(() => {
        commit("getMaxArea Fail");
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
