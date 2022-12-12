<template>
  <section class="task-edit">
    <h3 class="task-edit__title">
      Edit task
    </h3>
    <div class="task-edit__content">
      <article class="task-edit__item">
        <label class="task-edit__subtitle">
          Task name
        </label>
        <input
          v-model="taskCopy.name"
          class="task-edit__field"
          type="text"
        >
      </article>

      <UIButton
        class="task-edit__button-save button--bg-color-3"
        style="padding: 6px 8px;"
        @button-click="
          editTaskName(task)
          emitTaskEditClose()
        "
      >
        <span class="button__icon">
          <i class="icon">
            <FontAwesomeIcon icon="edit" />
          </i>
        </span>
        <span>Save</span>
      </UIButton>
    </div>
  </section>
</template>

<script>
import { mapActions } from 'vuex'
import UIButton from '../UI/UIButton.vue'

export default {
  name: 'TaskEdit',
  components: {
    UIButton
  },
  props: {
    task: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      taskCopy: this.task
    }
  },
  watch: {
    task(newVal, oldVal) {
      if (newVal !== oldVal) {
        this.taskCopy = newVal
      }
    }
  },
  methods: {
    ...mapActions(['updateTask']),
    editTaskName(task) {
      this.updateTask(task)
    },
    emitTaskEditClose() {
      this.$emit('task-edit-close')
    }
  }
}
</script>

<style lang="scss" scoped>
	.task-edit {
		&__title {
			margin-bottom: 20px;
			font-size: 28px;
			font-weight: bold;
		}

		&__content {
			display: flex;
			flex-direction: column;
			justify-content: center;
		}

		&__item {
			display: flex;
			flex-direction: column;

			> * {
				&:not(:last-child) {
					margin-bottom: 12px;
				}
			}
		}

		&__subtitle {
			margin-bottom: 10px;
			font-size: 18px;
		}

		&__field {
			padding: 12px;
			overflow: hidden;
			border: 2px solid #3e82c3;
			border-radius: 5px;
			background-color: #fff;
			font-size: 15px;
		}

		&__button-save {
			align-self: flex-end;
			max-width: 100px;
			margin-top: 20px;
		}
	}
</style>
