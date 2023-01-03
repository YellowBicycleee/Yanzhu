<template>
  <div
    class="task-preview"
    :class="{
      'is-done': taskItem.status.done,
      'is-show': taskItem.status.show
    }"
  >
    <UIButton
      class="task-preview__button-done button--icon"
      @button-click="changeTaskDone(taskItem)"
    >
      <span class="button__icon">
        <i class="icon">
          <FontAwesomeIcon icon="check-circle" />
        </i>
      </span>
    </UIButton>
    <div class="task-preview__name">
      <p>
        {{ taskItem.name }}
      </p>
    </div>
    <ul class="task-preview__tools">
      <li>
        <UIModal
          :class="{ 'is-open': taskItem.status.show }"
          @modal-close="hideTask(taskItem)"
        >
          <template #modalButtonOpen>
            <UIButton
              class="task-preview__button-edit button--icon"
              @button-click="showTask(taskItem)"
            >
              <span class="button__icon">
                <i class="icon">
                  <FontAwesomeIcon icon="edit" />
                </i>
              </span>
            </UIButton>
          </template>
          <template #modalInner>
            <TaskEdit
              :task="taskItem"
              @task-edit-close="hideTask(taskItem)"
            />
          </template>
        </UIModal>
      </li>
      <li>
        <UIButton
          class="task-preview__button-emove button--icon"
          @button-click="removeTask(taskItem.id)"
        >
          <span class="button__icon">
            <i class="icon">
              <FontAwesomeIcon icon="trash" />
            </i>
          </span>
        </UIButton>
      </li>
    </ul>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import UIButton from '../UI/UIButton.vue'
import UIModal from '../UI/UIModal.vue'
import TaskEdit from '../Task/TaskEdit.vue'

export default {
  name: 'TaskPreview',
  components: {
    UIButton,
    UIModal,
    TaskEdit
  },
  props: {
    taskItem: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions([
      'removeTask',
      'updateTask'
    ]),
    changeTaskDone(task) {
      task.status.done = !task.status.done
      this.updateTask(task)
    },
    showTask(task) {
      task.status.show = true
      this.updateTask(task)
    },
    hideTask(task) {
      task.status.show = false
      this.updateTask(task)
    }
  }
}
</script>

<style lang="scss" scoped>
	.task-preview {
		display: flex;
		align-items: center;
		padding: 10px;
		border-radius: 5px;
		box-shadow: 0 0 3px rgba(#000, 0.4);
		line-height: 1;
		user-select: none;

		&__name {
			max-width: calc(100% - 100px);
			transition: all 0.2s ease-in-out;
			font-size: 15px;

			p {
				display: inline-block;
				position: relative;
				width: 100%;
				overflow: hidden;
				line-height: 150%;
				text-overflow: ellipsis;
				white-space: nowrap;

				&:before {
					content: '';
					position: absolute;
					top: 50%;
					left: 0;
					width: 0%;
					height: 2px;
					transition: all 0.2s ease-in-out;
					background-color: #000;
				}
			}
		}

		&__button-done {
			margin-right: 15px;
			opacity: 1;
			color: #c3bbb6;
			font-size: 24px;

			&:hover {
				color: mix(#000, #c3bbb6, 20%);
			}
		}

		&__tools {
			display: flex;
			margin-left: auto;
			opacity: 0;
			list-style: none;

			> * {
				&:not(:last-child) {
					margin-right: 12px;
				}
			}
		}

		&__button-edit,
		&__button-emove {
			font-size: 20px;
		}

		&__button-edit {
			color: #3e82c3;

			&:hover {
				color: mix(#000, #3e82c3, 20%);
			}
		}

		&__button-emove {
			color: #f65050;

			&:hover {
				color: mix(#000, #f65050, 20%);
			}
		}

		&:hover {
			background-color: #f2f2f2;

			.task-preview {
				&__tools {
					opacity: 1;
					cursor: pointer;
				}
			}
		}

		&.is-done {
			.task-preview {
				&__name {
					p {
						&:before {
							width: 100%;
						}
					}
				}

				&__button-done {
					color: #42b883;

					&:hover {
						color: mix(#000, #42b883, 20%);
					}
				}
			}
		}

		&.is-show {
			.task-preview {
				&__tools {
					opacity: 1;
				}
			}
		}
	}
</style>
