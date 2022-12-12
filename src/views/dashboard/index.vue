<template>
  <div class="wrapper">
    <el-row :gutter="16">
      <el-col :span="24">
        <el-card>
          <div
            style="text-align: center; font-size: 24px; margin-bottom: 20px"
            class="color-dark-light"
          >
            <span style="font-weight: 600">2024</span> 年考研冲刺，祝金榜题名
          </div>
          <flip-countdown deadline="2023-12-24 00:00:00" />
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="16" style="margin-top: 16px">
      <el-col
        :span="12"
      >
        <el-card style="height: 436px">
          <div style="font-size: 12px">
            <TaskDashboard />
          </div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card style="height: 436px">
          <LineMarker sty />
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import FlipCountdown from 'vue2-flip-countdown'
import TaskDashboard from '@/components/Task/Dashboard/Dashboard.vue'
import LineMarker from '@/components/chart/LineMarker.vue'
export default {
  name: 'Dashboard',
  components: {
    FlipCountdown,
    TaskDashboard,
    LineMarker
  },
  computed: {
    ...mapGetters(['name'])
  }
}
</script>

<style lang="scss" scoped>
.wrapper {
  padding: 30px 20px;
  background-color: #f0f2f5;
  height: 100%;
  width: 100%;
  overflow: auto;
}

::v-deep {
.el-scrollbar__wrap {
  overflow: auto;
}

}
</style>
