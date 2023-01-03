<template>
  <div class="task-new">
    <div class="task-new__field">
      <input
        v-model="taskNew.name"
        class="task-new__input"
        type="text"
        placeholder="New task"
        autofocus
        @keyup.enter="createTaskNew()"
      >
      <UIButton
        class="task-new__button-add button--icon"
        @button-click="createTaskNew()"
      >
        <span class="button__icon">
          <i class="icon">
            <FontAwesomeIcon icon="plus-circle" />
          </i>
        </span>
      </UIButton>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
import UIButton from '../UI/UIButton.vue'

export default {
  name: 'TaskNew',
  components: {
    UIButton
  },
  data() {
    return {
      taskNew: {
        name: ''
      }
    }
  },
  computed: {
    ...mapGetters(['getTaskLast']),
    createTaskId() {
      if (typeof this.getTaskLast !== 'undefined') {
        return this.getTaskLast.id + 1
      }

      return 1
    },
    createTaskName() {
      return this.taskNew.name.trim()
    }
  },
  methods: {
    ...mapActions(['addTask']),
    cleanTaskNew() {
      this.taskNew.name = ''
    },
    createTaskNew() {
      const taskId = this.createTaskId
      const taskName = this.createTaskName

      const task = {
        id: taskId,
        name: taskName
      }

      if (taskName != '') {
        this.addTask(task)
      }

      this.cleanTaskNew()
      this.emitAddTask()
    },
    emitAddTask() {
      this.$emit('add-task')
    }
  }
}
</script>

<style lang="scss" scoped>
	.task-new {
		padding: 8px 20px;
		transition: all 0.5s ease-in-out 0s;
		background-color: #f2f2f2;

		&__field {
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 3px 10px 3px 15px;
			overflow: hidden;
			transition: all 0.5s ease-in-out 0s;
			border: 3px solid #3e82c3;
			border-radius: 50px;
			background-color: #fff;

			> * {
				&:not(:last-child) {
					margin-right: 10px;
				}
			}
		}

		&__input {
			width: 100%;
			border: 0;
			outline: none;
			color: #3e82c3;
			// font-family: $font-brand-2;
			font-size: 16px;
			font-weight: 600;

			&::placeholder {
				// color: $color-gray;
				font-weight: 400;
			}
		}

		&__button-add {
			transition: all 0.5s ease-in-out 0s;
			color: #3e82c3;
			font-size: 24px;

			// @include media('md') {
			// 	font-size: 3em;
			// }

			&:hover {
				color: mix(#000, #3e82c3, 20%);
			}
		}
	}
</style>
