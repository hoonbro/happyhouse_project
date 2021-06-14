<template>
  <card class="card-map" title="Kakao Maps">
    <div class="map">
      <div id="map"></div>
    </div>
  </card>
</template>
<script>
import { mapState } from "vuex";
export default {
  data() {
    return {
      positions: [],
      deleteList: []
    };
  },
  computed: {
    ...mapState("map", ["markList"]),
    ...mapState("search", ["lat", "lng"])
  },
  mounted() {
    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },
  methods: {
    initMap() {
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(this.lat, this.lng),
        level: 5
      };
      var map = new kakao.maps.Map(container, options);
      var imageSrc =
        "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
      var imageSize = new window.kakao.maps.Size(25, 35);
      var markerImage = new window.kakao.maps.MarkerImage(imageSrc, imageSize);
      this.positions = [];

      // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
      var zoomControl = new kakao.maps.ZoomControl();
      map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

      for (let i = 0; i < this.deleteList.length; i++) {
        this.deleteList[i].setMap(null);
      }

      for (let i = 0; i < this.markList.length; i++) {
        this.positions.push({
          title: this.markList[i].title,
          latlng: new kakao.maps.LatLng(
            this.markList[i].lat,
            this.markList[i].lng
          ),
          content: this.markList[i].content
        });
      }

      this.positions.forEach(function(pos) {
        var marker = new window.kakao.maps.Marker({
          map: map,
          title: pos.title,
          position: pos.latlng
        });
        var overlay = new kakao.maps.CustomOverlay({
          content: pos.content,
          map: map,
          position: marker.getPosition()
        });
        overlay.setMap(null);
        // kakao.maps.event.addListener(marker, "mouseover", function() {
        //   overlay.setMap(map);
        // });
        // kakao.maps.event.addListener(marker, "mouseout", function() {
        //   overlay.setMap(null);
        // });
        kakao.maps.event.addListener(marker, "click", function() {
          if (overlay.getMap() == null) overlay.setMap(map);
          else overlay.setMap(null);
        });
      });

      this.deleteList = [];
      this.deleteList = this.positions;
    },
    closeOverlay() {
      overlay.setMap(null);
    },
    addScript() {
      const script = document.createElement("script");
      /* global kakao */ script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=eb94e0a165fada25939d9bf736b9992f";
      document.head.appendChild(script);
    }
  }
};
</script>
<style scoped></style>
