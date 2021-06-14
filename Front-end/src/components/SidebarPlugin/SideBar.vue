<template>
  <div
    class="sidebar"
    :data-background-color="backgroundColor"
    :data-active-color="activeColor"
  >
    <!--
            Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black | darkblue"
            Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
        -->
    <!-- -->
    <div class="sidebar-wrapper" id="style-3">
      <div class="logo">
        <a href="/" class="simple-text">
          <div class="logo-img">
            <img
              src="data:image/png;base64,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"
              alt=""
            />
          </div>
          {{ title }}
        </a>
      </div>
      <slot> </slot>
      <ul class="nav">
        <!--By default vue-router adds an active class to each route link. This way the links are colored when clicked-->
        <slot name="links">
          <sidebar-link
            v-for="(link, index) in sidebarLinks"
            :key="index"
            :to="link.path"
            :name="link.name"
            :icon="link.icon"
          >
          </sidebar-link>
        </slot>
      </ul>
      <moving-arrow :move-y="arrowMovePx"> </moving-arrow>
    </div>
  </div>
</template>
<script>
import MovingArrow from "./MovingArrow.vue";
import SidebarLink from "./SidebarLink";
export default {
  props: {
    title: {
      type: String,
      default: "Happy House"
    },
    backgroundColor: {
      type: String,
      default: "black",
      validator: value => {
        let acceptedValues = ["white", "black", "darkblue"];
        return acceptedValues.indexOf(value) !== -1;
      }
    },
    activeColor: {
      type: String,
      default: "success",
      validator: value => {
        let acceptedValues = [
          "primary",
          "info",
          "success",
          "warning",
          "danger"
        ];
        return acceptedValues.indexOf(value) !== -1;
      }
    },
    sidebarLinks: {
      type: Array,
      default: () => []
    },
    autoClose: {
      type: Boolean,
      default: true
    }
  },
  provide() {
    return {
      autoClose: this.autoClose,
      addLink: this.addLink,
      removeLink: this.removeLink
    };
  },
  components: {
    MovingArrow,
    SidebarLink
  },
  computed: {
    /**
     * Styles to animate the arrow near the current active sidebar link
     * @returns {{transform: string}}
     */
    arrowMovePx() {
      if (this.activeLinkIndex < 2) {
        // console.log(this.linkHeight+" "+this.activeLinkIndex);
        return this.linkHeight * this.activeLinkIndex;
      } else {
        // console.log(this.linkHeight+" "+this.activeLinkIndex);
        return this.linkHeight * (this.activeLinkIndex - 1);
      }
    }
  },
  data() {
    return {
      linkHeight: 65,
      activeLinkIndex: 0,
      windowWidth: 0,
      isWindows: false,
      hasAutoHeight: false,
      links: []
    };
  },
  methods: {
    findActiveLink() {
      this.links.forEach((link, index) => {
        if (link.isActive()) {
          this.activeLinkIndex = index;
        }
      });
    },
    addLink(link) {
      const index = this.$slots.links.indexOf(link.$vnode);
      this.links.splice(index, 0, link);
    },
    removeLink(link) {
      const index = this.links.indexOf(link);
      if (index > -1) {
        this.links.splice(index, 1);
      }
    }
  },
  mounted() {
    this.$watch("$route", this.findActiveLink, {
      immediate: true
    });
  }
};
</script>
<style></style>
