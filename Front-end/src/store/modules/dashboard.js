import axios from "axios";
import Chartist from "chartist";

// initial state
const state = () => ({
  type: "",
  commerceCnt: "",
  maxMonth: "",
  Distribution: "",
  activityChart: {
    data: {
      labels: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"],
      series: []
    },
    options: {
      seriesBarDistance: 10,
      axisX: {
        showGrid: false
      },
      height: "245px"
    }
  },
  usersChart: {
    data: {
      labels: [
        "1억원 미만",
        "1억원",
        "2억원",
        "3억원",
        "4억원",
        "5억원",
        "6억원",
        "7억원",
        "8억원",
        "9억원",
        "10억원",
        "20억원 이상"
      ],
      series: [[], [], []]
    },
    options: {
      low: 0,
      high: 20,
      showArea: true,
      height: "245px",
      axisX: {
        showGrid: false
      },
      lineSmooth: Chartist.Interpolation.simple({
        divisor: 3
      }),
      showLine: true,
      showPoint: false
    }
  },
  barChart: {
    data: {
      labels: ["편의점", "치킨", "피자", "카페"],
      series: [
        [10, 10, 10, 10],
        [10, 10, 10, 10]
      ]
    },
    options: {
      seriesBarDistance: 10,
      axisX: {
        showGrid: false
      },
      height: "245px"
    },
    responsiveOptions: [
      [
        "screen and (max-width: 640px)",
        {
          seriesBarDistance: 10,
          axisX: {
            labelInterpolationFnc(value) {
              return value[0];
            }
          }
        }
      ]
    ]
  },
  preferencesChart: {
    data: {
      labels: ["33%", "33%", "33%"],
      series: [33, 33, 33]
    },
    options: {}
  },
  statsCards: [
    {
      type: "warning",
      icon: "ti-server",
      title: "총 거래량",
      value: "0건",
      footerText: "평균 거래량 : 421건",
      footerIcon: "ti-agenda"
    },
    {
      type: "success",
      icon: "ti-wallet",
      title: "평균 매매 가격",
      value: "0원",
      footerText: "전체 평균 매매 가격 : 60,104만원",
      footerIcon: "ti-money"
    },
    {
      type: "danger",
      icon: "ti-stats-up",
      title: "매매 최고가",
      value: "0원",
      footerText: "평균 최고가 : 149,045만원",
      footerIcon: "ti-bar-chart"
    },
    {
      type: "info",
      icon: "ti-stats-down",
      title: "매매 최저가",
      value: "0원",
      footerText: "평균 최저가 : 19,540만원",
      footerIcon: "ti-bar-chart-alt"
    }
  ]
});

// getters
const getters = {
  getTemp(state) {
    return state.temp;
  }
};

// mutations
const mutations = {
  setAptTotal(state, payload) {
    state.statsCards[0].value =
      payload.total.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +
      "건";
    state.statsCards[2].value =
      payload.maxAmount
        .toString()
        .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") + "만원";
    state.statsCards[3].value =
      payload.minAmount
        .toString()
        .replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") + "만원";
  },
  setAvgAmount(state, payload) {
    state.statsCards[1].value =
      payload.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",") +
      "만원";
  },
  setTypeTotal(state, payload) {
    state.preferencesChart.data.series[0] = payload[0];
    state.preferencesChart.data.series[1] = payload[1];
    state.preferencesChart.data.series[2] = payload[2];
    state.preferencesChart.data.labels[0] =
      Math.round((payload[0] / payload[3]) * 100) + "%";
    state.preferencesChart.data.labels[1] =
      Math.round((payload[1] / payload[3]) * 100) + "%";
    state.preferencesChart.data.labels[2] =
      Math.round((payload[2] / payload[3]) * 100) + "%";
    var max = 0;
    var idx = 0;
    for (let i = 0; i < payload.length - 1; i++) {
      if (max < payload[i]) {
        max = payload[i];
        idx = i;
      }
    }
    if (idx == 0) state.type = "아파트가 가장 많아요";
    else if (idx == 1) state.type = "오피스텔이 가장 많아요";
    else state.type = "연립주택이 가장 많아요";
  },
  setCommerceTotal(state, payload) {
    state.barChart.data.series[0] = payload;
  },
  setCommerceDong(state, payload) {
    var cnt = 0;
    state.commerceCnt = "";
    if (payload[0] >= 21) cnt++;
    if (payload[1] >= 14) cnt++;
    if (payload[2] >= 6) cnt++;
    if (payload[3] >= 48) cnt++;

    if (cnt < 2) state.commerceCnt = "주변 음식점이 적은 편입니다.";
    else if (cnt == 2) state.commerceCnt = "주변 음식점이 적당합니다";
    else state.commerceCnt = "주변 음식점이 많은 편입니다..";
    state.barChart.data.series[1] = payload;
  },
  setPriceTotal(state, payload) {
    state.usersChart.data.series[0] = payload;
  },
  setPriceGugun(state, payload) {
    state.usersChart.data.series[1] = payload;
  },
  setPriceDong(state, payload) {
    state.usersChart.data.series[2] = payload;
  },
  setDistribution(state, payload) {
    state.Distribution =
      state.usersChart.data.labels[payload] + "에 가장 많이 분포되어있습니다.";
  },
  resetMax(state) {
    state.usersChart.options.high = 20;
  },
  setMax(state, payload) {
    if (state.usersChart.options.high < payload)
      state.usersChart.options.high = payload + 5;
  },
  setMonthlyTotal(state, payload) {
    state.activityChart.data.series[0] = payload;
  },
  setMonthly(state, payload) {
    state.activityChart.data.series[1] = payload;
    var max = Math.max(...payload);
    var idx = [];
    state.maxMonth = "";
    for (let i = 0; i < payload.length; i++) {
      if (max == payload[i]) {
        idx.push(i + 1);
      }
    }
    state.maxMonth = idx + "월에 거래량이 가장 많습니다.";
  },
  setTemp(state) {
    state.temp = state.temp + 1;
  },
  setDong(state, payload) {
    state.statsCards[0].title = payload + " 총 거래량";
    state.statsCards[1].title = payload + " 평균 매매 가격";
    state.statsCards[2].title = payload + " 매매 최고가";
    state.statsCards[3].title = payload + " 매매 최저가";
  }
};

// actions
const actions = {
  aptTotal({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/aptTotal/" + payload[2] + "/" + payload[0]
      )
      .then(({ data }) => {
        commit("setAptTotal", data);
      })
      .catch(() => {
        console.log("aptTotal Fail");
      });
  },

  avgAmount({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/avgAmount/" + payload[2] + "/" + payload[0]
      )
      .then(data => {
        commit("setAvgAmount", data.data);
      })
      .catch(() => {
        console.log("avgAmount Fail");
      });
  },

  typeTotal({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/typeTotal/" + payload[2] + "/" + payload[0]
      )
      .then(({ data }) => {
        commit("setTypeTotal", data);
        commit("setTemp");
      })
      .catch(() => {
        console.log("setTypeTotal Fail");
      });
  },
  commerceTotal({ commit }) {
    axios
      .get("http://localhost/api/house/commerceTotal")
      .then(({ data }) => {
        commit("setCommerceTotal", data);
      })
      .catch(() => {
        console.log("commerceTotal Fail");
      });
  },
  commerceDong({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/commerceDong/" +
          payload[2] +
          "/" +
          payload[0]
      )
      .then(({ data }) => {
        let com = [0, 0, 0, 0];
        for (let i = 0; i < data.length; i++) {
          if (data[i].category == "D03A01") com[0] = data[i].cnt;
          else if (data[i].category == "Q05A08") com[1] = data[i].cnt;
          else if (data[i].category == "Q07A01") com[2] = data[i].cnt;
          else com[3] = data[i].cnt;
        }
        commit("setCommerceDong", com);
      })
      .catch(() => {
        console.log("setCommerceDong Fail");
      });
  },
  priceTotal({ commit }) {
    axios
      .get("http://localhost/api/house/priceTotal")
      .then(({ data }) => {
        let prices = [];
        var max = 0;
        for (let i = 0; i < data.length - 1; i++) {
          prices[i] = Math.round((data[i] / data[12]) * 100);
          if (prices[i] > max) max = prices[i];
        }
        commit("setPriceTotal", prices);
      })
      .catch(() => {
        console.log("priceTotal Fail");
      });
  },
  priceGugun({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/priceGugun/" +
          payload[2] +
          "/" +
          payload[1] +
          "/" +
          payload[0]
      )
      .then(({ data }) => {
        let prices = [];
        var max = 0;
        for (let i = 0; i < data.length - 1; i++) {
          prices[i] = Math.round((data[i].cnt / data[12].cnt) * 100);
          if (prices[i] > max) max = prices[i];
        }
        commit("setMax", max);
        commit("setPriceGugun", prices);
      })
      .catch(() => {
        console.log("priceGugun Fail");
      });
  },
  priceDong({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/priceDong/" +
          payload[2] +
          "/" +
          payload[1] +
          "/" +
          payload[0]
      )
      .then(({ data }) => {
        let prices = [];
        var max = 0;
        var m = 0;
        for (let i = 0; i < data.length - 1; i++) {
          prices[i] = Math.round((data[i].cnt / data[12].cnt) * 100);
          if (prices[i] > max) {
            max = prices[i];
            m = i;
          }
        }
        commit("setDistribution", m);
        commit("setMax", max);
        commit("setPriceDong", prices);
      })
      .catch(() => {
        console.log("priceDong Fail");
      });
  },
  monthlyTotal({ commit }) {
    axios
      .get("http://localhost/api/house/monthlyTotal")
      .then(({ data }) => {
        let amounts = [];
        var max = 0;
        for (let i = 0; i < data.length - 1; i++) {
          amounts[i] = Math.round((data[i] / data[12]) * 100);
          if (amounts[i] > max) max = amounts[i];
        }
        commit("setMonthlyTotal", amounts);
      })
      .catch(() => {
        console.log("monthlyTotal Fail");
      });
  },
  monthly({ commit }, payload) {
    if (payload[2] == "dong") payload[0] = payload[1];
    axios
      .get(
        "http://localhost/api/house/monthly/" + payload[2] + "/" + payload[0]
      )
      .then(({ data }) => {
        let amounts = [];
        var max = 0;
        for (let i = 0; i < data.length - 1; i++) {
          amounts[i] = Math.round((data[i].cnt / data[12].cnt) * 100);
          if (amounts[i] > max) max = amounts[i];
        }
        commit("setMonthly", amounts);
      })
      .catch(() => {
        console.log("setMonthly Fail");
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
