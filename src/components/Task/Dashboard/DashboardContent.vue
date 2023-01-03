<template>
  <div class="dashboard-content">
    <TaskList ref="taskList" />
    <TaskNew @add-task="scrollToBottom()" />
  </div>
</template>

<script>
import TaskList from '../Task/TaskList.vue'
import TaskNew from '../Task/TaskNew.vue'

export default {
  name: 'DashboardContent',
  components: {
    TaskList,
    TaskNew
  },
  methods: {
    scrollToBottom() {
      this.$refs.taskList.scrollToBottom()
    }
  }
}
</script>
