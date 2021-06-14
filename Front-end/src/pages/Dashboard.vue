<template>
  <div>
    <!--Stats cards-->
    <div class="row">
      <div
        class="col-md-6 col-xl-3"
        v-for="stats in statsCards"
        :key="stats.title"
      >
        <stats-card>
          <div
            class="icon-big text-center"
            :class="`icon-${stats.type}`"
            slot="header"
          >
            <i :class="stats.icon"></i>
          </div>
          <div class="numbers" slot="content">
            <p>{{ stats.title }}</p>
            {{ stats.value }}
          </div>
          <div class="stats" slot="footer">
            <i :class="stats.footerIcon"></i> {{ stats.footerText }}
          </div>
        </stats-card>
      </div>
    </div>

    <!--Charts-->
    <div class="row">
      <div class="col-12">
        <chart-card
          title="거래가격 분포"
          sub-title="Trade Price Distribution"
          :chart-data="usersChart.data"
          :chart-options="usersChart.options"
        >
          <span slot="footer">
            <i class="fa fa-check"></i>{{ this.Distribution }}
          </span>
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> 전체 평균
            <i class="fa fa-circle text-warning"></i> 선택(검색) 시/군/구
            <i class="fa fa-circle text-danger"></i> 선택(검색) 동
          </div>
        </chart-card>
      </div>

      <div class="col-md-4 col-12">
        <chart-card
          title="매매 타입"
          sub-title="Trading type"
          :chart-data="preferencesChart.data"
          chart-type="Pie"
        >
          <span slot="footer">
            <i class="fa fa-check"></i> {{ this.type }}</span
          >
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> 아파트
            <i class="fa fa-circle text-danger"></i> 연립주택
            <i class="fa fa-circle text-warning"></i> 오피스텔
          </div>
        </chart-card>
      </div>
      <div class="col-md-4">
        <chart-card
          title="음식 지수"
          sub-title="Food index"
          :chart-data="barChart.data"
          :chart-options="barChart.options"
          :chart-responsive-options="barChart.responsiveOptions"
          chart-type="Bar"
        >
          <span slot="footer">
            <i class="fa fa-check"></i> {{ this.commerceCnt }}</span
          >
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> 전체 평균
            <i class="fa fa-circle text-warning"></i> 선택(검색) 지역
          </div>
        </chart-card>
      </div>
      <div class="col-md-4 col-12">
        <chart-card
          title="월별 거래량"
          sub-title="Monthly trading volume"
          :chart-data="activityChart.data"
          :chart-options="activityChart.options"
        >
          <span slot="footer">
            <i class="fa fa-check"></i> {{ maxMonth }}
          </span>
          <div slot="legend">
            <i class="fa fa-circle text-info"></i> 전체 평균
            <i class="fa fa-circle text-warning"></i> 선택(검색) 지역
          </div>
        </chart-card>
      </div>
    </div>
  </div>
</template>
<script>
import { StatsCard, ChartCard } from "@/components/index";
import { mapState } from "vuex";
import Chartist from "chartist";
export default {
  components: {
    StatsCard,
    ChartCard
  },
  computed: {
    ...mapState("search", ["searchType", "total", "dong", "apt"]),
    ...mapState("dashboard", [
      "preferencesChart",
      "statsCards",
      "temp",
      "barChart",
      "usersChart",
      "activityChart",
      "type",
      "commerceCnt",
      "maxMonth",
      "Distribution"
    ]),
    temp: function() {
      console.log(this.preferencesChart.data);
    }
  },
  /**
   * Chart data used to render stats, charts. Should be replaced with server data
   */
  methods: {}
};
</script>
<style></style>
