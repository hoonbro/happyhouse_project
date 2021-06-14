<template>
  <div class>
    <div class="maincenter">
      <img
        id="logo"
        src="../assets/img/ssafy_logo_bgx.png"
        width="300px"
      /><br />
      <input
        type="search"
        class="searchApt"
        v-model="searchInput"
        placeholder="검색어 입력"
        @keyup.enter="aptBtn"
      />
      <button class="btn btn-primary btn-login" @click="aptBtn">검색</button>

      <div>
        <span class="selectAll">
          <select name="sido" id="sido" v-model="city" @change="changeCity">
            <option>도/광역시</option>
            <option v-for="(city, index) in citys" :key="index">{{
              city
            }}</option>
          </select>
          <select name="gugun" id="gugun" v-model="gugun" @change="changeGugun">
            <option>시/구/군</option>
            <option v-for="(gugun, index) in guguns" :key="index">{{
              gugun
            }}</option>
          </select>
          <select name="dong" id="dong" v-model="dong">
            <option>동</option>
            <option v-for="(dong, index) in dongs" :key="index">{{
              dong
            }}</option>
          </select>
        </span>
        <button class="btn btn-primary btn-login" @click="dongBtn">
          검색
        </button>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions, mapMutations, mapState } from "vuex";
import Button from "../components/Button.vue";
export default {
  components: { Button },
  data() {
    return {
      city: "도/광역시",
      gugun: "시/구/군",
      dong: "동",
      searchInput: ""
    };
  },
  created() {
    this.getCitys();
  },

  computed: {
    ...mapState("search", ["citys", "guguns", "dongs", "total"])
  },

  methods: {
    ...mapMutations("dashboard", ["setAptTotal"]),
    ...mapActions("search", [
      "dongSearch",
      "aptSearch",
      "getCitys",
      "getGuguns",
      "getDongs"
    ]),
    changeCity() {
      this.getGuguns(this.city);
    },
    changeGugun() {
      this.getDongs([this.city, this.gugun]);
    },
    aptBtn() {
      this.aptSearch(this.searchInput);
      this.$router.push("/dashboard");
    },
    dongBtn() {
      this.dongSearch([this.city, this.gugun, this.dong]);
      this.$router.push("/dashboard");
    }
  }
};
</script>
<style scoped>
/* * {
  background: #f4f3ef;
   */
/* background-color: black; */
/* width: 100%;
  height: 100%;
} */
.searchApt {
  height: 40px;
  width: 235px;
  margin-right: 5px;
}
.selectAll {
  margin-right: 5px;
}
select {
  height: 40px;
}
.maincenter {
  position: absolute;
  top: 20%;
  left: 50%;
  text-align: center;
  margin-left: -150px;
}
.selectForm {
  margin-top: 10px;
}</style
>>
