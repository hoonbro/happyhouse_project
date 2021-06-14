<template>
  <card id = "card" class="card" title="Sign up">
    <br>
        <div class="col-md-3">
          <fg-input
            type="text"
            label="UserId"
            placeholder="User Id"
            v-model="userid"
            style="width:600px"

          >
          </fg-input>
        </div>
        <div class="col-md-3">
          <fg-input
            type="password"
            label="UserPassword"
            placeholder="User password"
            v-model="userpwd"
            style="width:600px"
          >
          </fg-input>
        </div>
        <div class="col-md-3">
          <fg-input
            type="text"
            label="UserName"
            placeholder="UserName"
            v-model="username"
            style="width:600px"
          >
          </fg-input>
        </div>

        <div class="col-md-3">
          <fg-input
            type="email"
            label="UserEmail"
            placeholder="Email"
            v-model="email"
            style="width:600px"
          >
          </fg-input>
        </div>

          <div class="col-md-3">
            <fg-input
              type="text"
              label="Address"
              placeholder="Home Address"
              v-model="address"
            style="width:600px"
            >
            </fg-input>
          </div>
        
        <br>
        <div class="text-center">
          <p-button type="info" round @click.native.prevent="signUpBtn">
            Sign up
          </p-button>
        </div>
        <div class="clearfix"></div>
   
  </card>
</template>
<script>
import { mapActions } from "vuex";

export default {
  data() {
    return {
        userid: "",
        userpwd: "",
        username: "",
        email: "",
        address: "",
    };
  },
  methods: {
    ...mapActions("user",["registerMember"]),

    signUpBtn() {
      if (this.userid == "") {
        alert("아이디 입력");
        return;
      }
      if (this.userpwd == "") {
        alert("비밀번호 입력");
        return;
      }
      if (this.username == "") {
        alert("이름 입력");
        return;
      }
      if (this.email == "") {
        alert("이메일 입력");
        return;
      } else if(!this.validEmail(this.email)) {
        alert("이메일 형식을 확인해주세요");
        return;
      }

      if (this.address == "") {
        alert("주소 입력");
        return;
      }
      // alert("Your data: " + JSON.stringify(this.userid));
      // console.log(this.userid+" "+this.userpwd+" "+this.username+" "+this.email+" "+this.address);
      this.registerMember([this.userid, this.userpwd, this.username, this.email, this.address]);
      this.$router.push("/login");
    },

     validEmail: function(email) {
      var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      return re.test(email);
    }
  }
};
</script>
<style scoped>
/* #loginForm {
  margin: 0 auto;
} */
#card {
  width: 700px;
  margin: 0 auto;
}
</style>
