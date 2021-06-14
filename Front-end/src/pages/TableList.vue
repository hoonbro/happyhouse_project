<template>
  <div class="row">
    <div v-if="searchType == 'dong'" class="col-12">
      <card :title="this.getDong + table1.title" :subTitle="table1.subTitle">
        <p-button
          v-if="user.userid != ''"
          type="success"
          outline
          @click.native.prevent="bookBtn"
        >
          관심지역 등록
        </p-button>
        <div slot="raw-content" class="table-responsive">
          <paper-table> </paper-table>
        </div>
      </card>
    </div>
    <div v-if="searchType == 'apt'" class="col-12">
      <card :title="this.getApt + table2.title" :subTitle="table2.subTitle">
        <div slot="raw-content" class="table-responsive">
          <paper-table> </paper-table>
        </div>
      </card>
    </div>
  </div>
</template>
<script>
import { PaperTable } from "@/components";
import { mapActions, mapGetters, mapState } from "vuex";
export default {
  data() {
    return {
      table1: {
        title: " 매물 리스트",
        subTitle: "Dong Search List"
      },
      table2: {
        title: "(으)로 검색한 결과",
        subTitle: "Apt Search List"
      }
    };
  },
  components: {
    PaperTable
  },
  computed: {
    ...mapGetters("search", ["getDong", "getApt"]),
    ...mapState("search", ["searchType", "dong", "apt", "city", "gugun"]),
    ...mapState("user", ["user"])
  },
  methods: {
    ...mapActions("user", ["addBook", "getBookList"]),
    bookBtn() {
      // console.log("관심버튼 누름"+this.user.userid+" " +this.city+" " +this.gugun+" " +this.dong);
      this.addBook([this.user.userid, this.city, this.gugun, this.dong]);
      // this.getBookList([this.user.userid]);
      // console.log("리스트 갱신");
    }
  }
};
</script>
<style></style>
