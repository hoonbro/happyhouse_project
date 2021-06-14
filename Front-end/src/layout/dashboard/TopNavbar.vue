<template>
  <nav class="navbar navbar-expand-lg navbar-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">{{ routeName }}</a>
      <div class="searchBar">
        <span>
          <input
            type="search"
            class="searchApt"
            v-model="searchInput"
            placeholder="검색어 입력"
            @keyup.enter="aptBtn"
          />
          <button class="btn btn-info btn-login" @click="aptBtn">검색</button>
        </span>
        <span class="selectAll ml-5">
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
          <button class="ml-2 btn btn-info btn-login" @click="dongBtn">
            검색
          </button>
        </span>
      </div>
      <button
        class="navbar-toggler navbar-burger"
        type="button"
        @click="toggleSidebar"
        :aria-expanded="$sidebar.showSidebar"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-bar"></span>
        <span class="navbar-toggler-bar"></span>
        <span class="navbar-toggler-bar"></span>
      </button>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
          <!-- <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="ti-panel"></i>
              <p>Stats</p>
            </a>
          </li>
          <drop-down
            class="nav-item"
            title="5 Notifications"
            title-classes="nav-link"
            icon="ti-bell"
          >
            <a class="dropdown-item" href="#">Notification 1</a>
            <a class="dropdown-item" href="#">Notification 2</a>
            <a class="dropdown-item" href="#">Notification 3</a>
            <a class="dropdown-item" href="#">Notification 4</a>
            <a class="dropdown-item" href="#">Another notification</a>
          </drop-down> -->
          <li v-if="user.userid != ''" class="nav-item">
            <a class="nav-link">
              <i class="ti-user"></i>
              <p>{{ user.username }}님 환영합니다</p>
            </a>
          </li>
          <li v-if="user.userid != ''" class="nav-item">
            <a href="#" class="nav-link" @click="interestBtn">
              <i class="ti-heart"></i>
              <p>
                Interest
              </p>
            </a>
          </li>
          <li v-if="user.userid != ''" class="nav-item">
            <a href="#" class="nav-link" @click="logoutBtn">
              <i class="ti-close"></i>
              <p>
                Logout
              </p>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<script>
import { mapMutations, mapActions, mapState, mapGetters } from "vuex";
export default {
  computed: {
    routeName() {
      const { name } = this.$route;
      return this.capitalizeFirstLetter(name);
    },
    ...mapState("search", [
      "searchType",
      "citys",
      "guguns",
      "dongs",
      "aptList",
      "maxDong"
    ]),
    ...mapGetters("user", ["user"]),
    ...mapGetters("search", ["aptLIst", "maxDong", "getGugun", "getDong"])
  },

  created() {
    this.getCitys();
  },

  watch: {
    aptList: function() {
      this.resetMax();
      this.setDong(this.getDong);
      if (this.$route.name != "table-list") this.$router.push("/");
      this.getLatLng(this.getDong);
      this.aptTotal([this.searchInput, this.getDong, this.searchType]);
      this.avgAmount([this.searchInput, this.getDong, this.searchType]);
      this.typeTotal([this.searchInput, this.getDong, this.searchType]);
      this.commerceTotal();
      this.commerceDong([this.searchInput, this.getDong, this.searchType]);
      this.priceTotal();
      this.priceGugun([this.searchInput, this.getGugun, this.searchType]);
      this.priceDong([this.searchInput, this.getDong, this.searchType]);
      this.monthlyTotal();
      this.monthly([this.searchInput, this.getDong, this.searchType]);
      this.getMarks([this.searchInput, this.getDong, this.searchType]);
      this.searchInput = "";
      this.city = "도/광역시";
      this.gugun = "시/구/군";
      this.dong = "동";
    }
    // maxDong: function() {
    //   this.getLatLng(this.maxDong);
    // }
  },

  data() {
    return {
      activeNotifications: false,
      city: "도/광역시",
      gugun: "시/구/군",
      dong: "동",
      searchInput: ""
    };
  },
  methods: {
    ...mapMutations("dashboard", ["setAptTotal", "resetMax", "setDong"]),
    ...mapMutations("user", ["logout"]),
    ...mapActions("search", [
      "dongSearch",
      "aptSearch",
      "getCitys",
      "getGuguns",
      "getDongs",
      "getLatLng",
      "getMaxArea"
    ]),
    ...mapActions("dashboard", [
      "aptTotal",
      "avgAmount",
      "typeTotal",
      "commerceTotal",
      "commerceDong",
      "priceTotal",
      "priceGugun",
      "priceDong",
      "monthlyTotal",
      "monthly"
    ]),
    ...mapActions("map", ["getMarks"]),
    ...mapActions("user", ["getBookList"]),
    changeCity() {
      this.getGuguns(this.city);
    },
    changeGugun() {
      this.getDongs([this.city, this.gugun]);
    },
    aptBtn() {
      this.getMaxArea(this.searchInput);
      this.aptSearch(this.searchInput);
      // if (this.$route.name != "table-list") this.$router.push("/");
      // this.$router.push("/table-list");
    },
    dongBtn() {
      this.dongSearch([this.city, this.gugun, this.dong]);
      // if (this.$route.name != "table-list") this.$router.push("/");
    },
    logoutBtn() {
      if (confirm("로그아웃하시겠습니까?") == true) {
        this.logout();
      } else {
        return;
      }
    },
    interestBtn() {
      this.getBookList([this.user.userid]);
      // console.log("목록가져오기");
      this.$router.push("/interest");
    },
    capitalizeFirstLetter(string) {
      return string.charAt(0).toUpperCase() + string.slice(1);
    },
    toggleNotificationDropDown() {
      this.activeNotifications = !this.activeNotifications;
    },
    closeDropDown() {
      this.activeNotifications = false;
    },
    toggleSidebar() {
      this.$sidebar.displaySidebar(!this.$sidebar.showSidebar);
    },
    hideSidebar() {
      this.$sidebar.displaySidebar(false);
    }
  }
};
</script>
<style>
.searchBar {
  position: absolute;
  margin-left: 150px;
}
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
</style>
