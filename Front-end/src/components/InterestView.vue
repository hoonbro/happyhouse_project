<template>
  <div class="overflow-auto">
    <b-table
      class="text-center"
      striped
      hover
      fixed
      id="my-table"
      :items="bookList"
      :fields="fields"
      :per-page="perPage"
      :current-page="currentPage"
      @row-clicked="clickRow"
    >
      <template #cell(delete)="row">
        <b-button size="sm" @click="clickDelete(row.value)" class="mr-2">
          삭제
        </b-button>
      </template>
    </b-table>
    <b-pagination
      align="center"
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="my-table"
    ></b-pagination>
  </div>
</template>
<script>
import { mapActions, mapState } from "vuex";
export default {
  name: "interest-view",
  data() {
    return {
      deletecheck: false,
      fields: ["도광역시", "시구군", "동", "delete"],
      perPage: 10,
      currentPage: 1
    };
  },
  props: {
    type: {
      type: String, // striped | hover
      default: "striped"
    },
    title: {
      type: String,
      default: ""
    },
    subTitle: {
      type: String,
      default: ""
    }
  },
  computed: {
    ...mapState("user", ["user", "bookList"]),
    tableClass() {
      return `table-${this.type}`;
    },
    rows() {
      return this.bookList.length;
    }
  },
  methods: {
    ...mapActions("user", ["deleteBook", "getBookList"]),
    ...mapActions("search", ["dongSearch"]),
    hasValue(item, column) {
      return item[column.toLowerCase()] !== "undefined";
    },
    itemValue(item, column) {
      return item[column.toLowerCase()];
    },
    clickDelete(no) {
      this.deleteBook([this.user.userid, no]);
      this.deletecheck = !this.deletecheck;
    },
    clickRow(record, index) {
      this.dongSearch([record.도광역시, record.시구군, record.동]);
    }
  }
};
</script>
<style></style>
