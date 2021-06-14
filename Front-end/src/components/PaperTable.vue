<template>
  <div class="overflow-auto">
    <b-table
      class="text-center"
      striped
      fixed
      hover
      id="my-table"
      :items="aptList"
      :fields="fields"
      :per-page="perPage"
      :current-page="currentPage"
      @row-clicked="clickRow"
    ></b-table>
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
import { mapState } from "vuex";
export default {
  name: "paper-table",
  data() {
    return {
      perPage: 10,
      currentPage: 1,
      fields: [
        {
          key: "아파트명",
          sortable: true
        },
        {
          key: "동",
          sortable: true
        },
        {
          key: "거래금액(만원)",
          sortable: true
        },
        {
          key: "면적",
          sortable: true
        },
        {
          key: "분류",
          sortable: false
        },
        {
          key: "건설일",
          sortable: true
        },
        {
          key: "거래일",
          sortable: false
        }
      ]
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
    ...mapState("search", ["aptList"]),
    tableClass() {
      return `table-${this.type}`;
    },
    rows() {
      return this.aptList.length;
    }
  },
  methods: {
    hasValue(item, column) {
      return item[column.toLowerCase()] !== "undefined";
    },
    itemValue(item, column) {
      return item[column.toLowerCase()];
    },
    clickRow(record, index) {
      console.log(record);
    }
  }
};
</script>
<style></style>
