<template>
  <div class="dashboard">
    <DashboardInfo />
    <DashboardContent />
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import DashboardInfo from '../Dashboard/DashboardInfo.vue'
import DashboardContent from '../Dashboard/DashboardContent.vue'

export default {
  name: 'Dashboard',
  components: {
    DashboardInfo,
    DashboardContent
  },
  computed: {
    ...mapGetters(['getTaskList'])
  },
  watch: {
    getTaskList: {
      handler() {
        this.createTaskListLocalStorage()
      },
      deep: true
    }
  },
  mounted() {
    this.checkTaskListLocalStorage()
  },
  methods: {
    ...mapActions(['checkTaskListLocalStorage', 'createTaskListLocalStorage'])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  position: relative;
  width: 100%;
  margin: 0 auto 10px;
  overflow: hidden;
  transition: 0.5s ease-in-out 0s;
  background-color: #fff;
  max-width: inherit;
}
</style>
