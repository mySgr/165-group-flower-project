<template>
  <div id="app">
    
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "app",
  methods: {
    test() {
      this.$axios.get("/api/test", {
        params: { name: "admin" },
      })
        .then((result) => {
          console.log(result);
        })
        .catch((err) => {});
    },
  },
  created() {
    this.test();
  },
};
</script>
*{
  margin:0px;
  padding:0px;
}
<style>
