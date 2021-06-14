<template>
  <div class="row">
    <card :title="table1.title" :subTitle="table1.subTitle">
      <div slot="raw-content" class="table-responsive">
        <interest-view> </interest-view>
      </div>
    </card>
  </div>
</template>
<script>
import { InterestView } from "@/components";
import { mapState } from "vuex";
export default {
  data() {
    return {
      table1: {
        title: "관심지역 목록",
        subTitle: "Interest Lists"
      }
    };
  },
  components: {
    InterestView
  },
  computed: {
    ...mapState("user", ["user", "bookList"])
  }
};
</script>
<style></style>
