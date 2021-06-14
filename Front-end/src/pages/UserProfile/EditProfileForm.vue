<template>
  <card id = "card" class="card" title="Your Profile">
      <br>
      <div>
        <div class = "center">
        <div class="col-md-3">
          <fg-input
            type="text"
            label="UserId"
            :disabled="true"
            placeholder="User Id"
            v-model="user.userid"
            style="width:600px"
          >
          </fg-input>
        </div>
        
        <div class="col-md-3">
          <fg-input id ="upassword"
            type="password"
            label="UserPassword"
            :disabled="true"
            placeholder="User password"
            v-model="user.userpwd"
            style="width:600px"
          >
          </fg-input>
        </div>
        <div class="col-md-3">
          <fg-input id = "uname"
            type="text"
            label="UserName"
            :disabled="true"
            placeholder="UserName"
            v-model="user.username"
            style="width:600px"
          >
          </fg-input>
        </div>

        <div class="col-md-3">
          <fg-input id ="uemail"
            type="email"
            label="UserEmail"
            :disabled="true"
            placeholder="Email"
            v-model="user.email"
            style="width:600px"
          >
          </fg-input>
        </div>

          <div class="col-md-3">
            <fg-input
              type="text" id = "uaddress"
              label="Address"
              :disabled="true"
              placeholder="Home Address"
              v-model="user.address"
              style="width:600px"
            >
            </fg-input>
          </div>

        <div class="col-md-3">
          <fg-input
            type="text"
            label="JoinDate"
            :disabled="true"
            placeholder="Join Date"
            v-model="user.joindate"
            style="width:600px"
          >
          </fg-input>
        </div>
        <br>
        <div class="text-center">
            <p-button class ="m-2" v-if="!this.edit" type="info" round @click.native.prevent="editProfile">
              Edit Profile
            </p-button>
            <p-button v-if="this.edit" type="info" round @click.native.prevent="updateProfile">
              Update Profile
            </p-button>
        
            <p-button type="info" round @click.native.prevent="deleteProfile">
              Delete Profile
            </p-button>
          
        </div>
        </div>
    </div>
  </card>
</template>
<script>

import { mapGetters, mapActions } from "vuex";

export default {
  // data() {
  //   return {
  //     user: {
  //       id: "",
  //       username: "",
  //       email: "",
  //       name: "",
  //       address: "",
  //       joindate: ""
  //     }
  //   };
  // },
  data(){
    return{
      edit : false
    }
  },
  computed: {
    ...mapGetters("user", ["check","user"]),

  },
  watch:{
    edit : function(){
      if(this.edit){
        var upassword = document.getElementById("upassword");
          var uname = document.getElementById("uname");
          var uemail = document.getElementById("uemail");
          var uaddress = document.getElementById("uaddress");

        upassword.disabled = false;
        uname.disabled = false;
        uaddress.disabled = false;
        uemail.disabled = false;
      }
      else{
        var upassword = document.getElementById("upassword");
          var uname = document.getElementById("uname");
          var uemail = document.getElementById("uemail");
          var uaddress = document.getElementById("uaddress");
        
        upassword.disabled = true;
        uname.disabled = true;
        uemail.disabled = true;
        uaddress.disabled = true;
      }
    },
    check : function(){
      this.$router.push("/login");

    }
  },
  methods: {
    ...mapActions("user",["modifyMember","deleteMember"]),

    editProfile() {
      this.edit = true;
    },
    updateProfile() {
      if (this.user.userpwd == "") {
        alert("비밀번호 입력");
        return;
      }
      if (this.user.username == "") {
        alert("이름 입력");
        return;
      }
      if (this.user.email == "") {
        alert("이메일 입력");
        return;
      }else if(!this.validEmail(this.user.email)) {
        alert("이메일 형식을 확인해주세요");
        return;
      }
      if (this.user.address == "") {
        alert("주소 입력");
        return;
      }
      this.modifyMember([this.user.userid, this.user.userpwd, this.user.username, this.user.email, this.user.address]);
      this.edit = false;
    },

    deleteProfile(){
      if(confirm("탈퇴하시겠습니까???")==true){
        // console.log("탈퇴");
        this.deleteMember([this.user.userid, this.user.userpwd, this.user.username, this.user.email, this.user.address]);
        this.$router.push("/login");
      }else{
        return;
      }
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
</style>>

