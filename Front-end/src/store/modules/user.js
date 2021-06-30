import axios from "axios";

//initial state
const state = () => ({
  check: false,
  user: {
    userid: "",
    userpwd: "",
    username: "",
    email: "",
    address: "",
    joindate: ""
  },
  book: {
    userid: "",
    no: ""
  },
  bookList: []
});

//getters
const getters = {
  user: state => state.user,
  check: state => state.check
};

//mutations
const mutations = {
  loginSuccess(state, payload) {
    state.user = payload;
    state.check = true;
    // alert(state.user.username + "님 환영합니다.");
  },
  logout(state) {
    state.user = {
      userid: "",
      userpwd: "",
      username: "",
      email: "",
      address: "",
      joindate: ""
    };
    state.check = false;
    alert("로그아웃 되었습니다.");
  },
  registerMemberSuccess() {
    alert("회원등록");
  },
  modifyMemberSuccess() {
    alert("회원수정");
  },
  deleteMemberSuccess(state) {
    state.user = {
      userid: "",
      userpwd: "",
      username: "",
      email: "",
      address: "",
      joindate: ""
    };
    state.check = false;
    alert("회원탈퇴하였습니다...");
  },
  getBookListSuccess(state, payload) {
    state.bookList = [];
    state.bookList = payload;
    // console.log(state.bookList);
  },
  addBookSuccess() {
    alert("관심목록 추가");
  },
  deleteBookSuccess() {
    alert("관심목록 삭제");
  },
  deleteBookList(state, payload) {
    for (let i = 0; i < state.bookList.length; i++) {
      if (payload[1] == state.bookList[i].no) {
        state.bookList.splice(i, 1);
        i--;
      }
    }
    // console.log(payload[1] + "삭제완료");
  }
};

// actions
const actions = {
  login({ commit }, payload) {
    axios
      .post("http://localhost/api/member/login", {
        userid: payload[0],
        userpwd: payload[1]
      })
      .then(({ data }) => {
        commit("loginSuccess", data);
      })
      .catch(() => {
        alert("아이디와 비밀번호로를 확인해주세요");
      });
  },
  registerMember({ commit }, payload) {
    axios
      .post("http://localhost/api/member/register", {
        userid: payload[0],
        userpwd: payload[1],
        username: payload[2],
        email: payload[3],
        address: payload[4]
      })
      .then(() => {
        commit("registerMemberSuccess");
      })
      .catch(() => {
        alert("이미 등록된 아이디입니다.");
      });
  },
  modifyMember({ commit }, payload) {
    axios
      .put("http://localhost/api/member/modify", {
        userid: payload[0],
        userpwd: payload[1],
        username: payload[2],
        email: payload[3],
        address: payload[4]
      })
      .then(() => {
        commit("modifyMemberSuccess");
      })
      .catch(() => {
        alert("modifyMember Fail");
      });
  },
  deleteMember({ commit }, payload) {
    axios
      .post("http://localhost/api/member/delete", {
        userid: payload[0],
        userpwd: payload[1],
        username: payload[2],
        email: payload[3],
        address: payload[4]
      })
      .then(({ data }) => {
        commit("deleteMemberSuccess");
      })
      .catch(() => {
        alert("deleteMember Fail");
      });
  },
  getBookList({ commit }, payload) {
    axios
      .get("http://localhost/api/member/booklist/" + payload)
      .then(({ data }) => {
        let books = [];
        for (let i = 0; i < data.length; i++) {
          // console.log(data[i].dong);
          books[i] = {
            no: data[i].no,
            도광역시: data[i].city,
            시구군: data[i].gugun,
            동: data[i].dong,
            delete: data[i].no
          };
        }
        commit("getBookListSuccess", books);
      })
      .catch(() => {
        alert("관심목록을 받는데 실패했습니다.");
      });
  },
  addBook({ commit }, payload) {
    axios
      .post("http://localhost/api/member/newBooking", {
        userid: payload[0],
        city: payload[1],
        gugun: payload[2],
        dong: payload[3]
      })
      .then(() => {
        commit("addBookSuccess");
      })
      .catch(() => {
        alert("이미 등록된 지역입니다.");
      });
  },
  deleteBook({ commit }, payload) {
    commit("deleteBookList", payload);
    axios
      .post("http://localhost/api/member/deleteBook", {
        userid: payload[0],
        no: payload[1]
      })
      .then(() => {
        commit("deleteBookSuccess");
      })
      .catch(() => {
        alert("관심목록 삭제를 실패했습니다.");
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
