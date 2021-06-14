<template>
  <card id="card" class="card" title="Login">
    <br />
    <div>
      <div id="loginForm" class="col-md-3">
        <fg-input
          type="text"
          label="UserId"
          placeholder="User Id"
          v-model="userid"
          style="width:450px"
        >
        </fg-input>
        <fg-input
          type="password"
          label="UserPassword"
          placeholder="User password"
          v-model="userpwd"
          style="width:450px"
          @keyup.enter="loginBtn"
        >
        </fg-input>
      </div>

      <div class="text-center">
        <p-button
          class="m-2"
          type="info"
          round
          @click.native.prevent="loginBtn"
        >
          login
        </p-button>
        <p-button type="info" round @click.native.prevent="moveSignUp">
          Sign up
        </p-button>
      </div>
      <div class="clearfix"></div>
    </div>
  </card>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import Button from "../components/Button.vue";

export default {
  components: { Button },

  data() {
    return {
      userid: "",
      userpwd: ""
    };
  },
  computed: {
    ...mapGetters("user", ["check"])
  },
  watch: {
    ...mapActions("user", ["login", "getBookList"]),
    check: function() {
      // this.getBookList([this.userid]);
      this.$router.push("/");
    }
  },
  methods: {
    ...mapActions("user", ["login", "getBookList"]),
    loginBtn() {
      if (this.userid == "") {
        alert("아이디 입력");
        return;
      }
      if (this.userpwd == "") {
        alert("비밀번호 입력");
        return;
      }

      this.login([this.userid, this.userpwd]);
    },
    moveSignUp() {
      // console.log("회원가입");
      this.$router.push("/signup");
    }
  }
};
</script>

<style scoped>
#card {
  width: 500px;
  margin: 0 auto;
}</style
>>
