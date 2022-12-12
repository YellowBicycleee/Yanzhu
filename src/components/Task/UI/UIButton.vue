<template>
  <component
    :is="checkTag"
    :href="buttonHref"
    :to="buttonTo"
    :value="buttonValue"
    class="button"
    @click="buttonClick"
  >
    <slot />
  </component>
</template>

<script>
export default {
  name: 'UIButton',
  props: {
    buttonHref: {
      type: String,
      default: null
    },
    buttonTo: {
      type: String,
      default: null
    },
    buttonValue: {
      type: String,
      default: null
    }
  },
  computed: {
    checkTag() {
      if (this.href) {
        return 'a'
      } else if (this.value) {
        return 'input'
      } else if (this.to) {
        return 'router-link'
      }

      return 'button'
    }
  },
  methods: {
    buttonClick(event) {
      this.$emit('button-click', event)
    }
  }
}
</script>

<style lang="scss" scoped>
	.button {
		display: flex;
		align-items: center;
		justify-content: center;
		padding: 12px 2px;
		border: 0.1em solid transparent;
		outline: none;
		background-color: transparent;
		font-size: 16px;
		font-weight: 600;
		line-height: 110%;
		text-transform: capitalize;
		white-space: nowrap;
		cursor: pointer;
		user-select: none;
		appearance: none;

		> * {
			pointer-events: none;

			&:not(:last-child) {
				margin-right: 10px;
			}

			&:only-child {
				margin-right: 0;
			}
		}

		&__icon {
			display: flex;
			align-items: center;
			justify-content: center;

			.icon {
				display: flex;
				align-items: center;
				justify-content: center;
			}
		}

		&--icon {
			padding: 0;
		}

		&:not(.button--icon) {
			transition:
				color 0.15s ease-in-out 0s,
				background-color 0.15s ease-in-out 0s,
				border-color 0.15s ease-in-out 0s;
		}

		&--small {
			padding: 5px 8px;
			font-size: 15px;
		}

		&--bg-color {
			background-color: #42b883;
			color: #fff;

			&:hover {
				background-color: mix(#000, #42b883, 15%);
				color: #fff;
			}

			&-1 {
				background-color: #42b883;
				color: #000;

				&:hover {
					background-color: mix(#000, #42b883, 15%);
				}
			}

			&-2 {
				background-color: #35495e;
				color: #fff;

				&:hover {
					background-color: mix(#000, #35495e, 15%);
				}
			}

			&-3 {
				background-color: #3e82c3;
				color: #fff;

				&:hover {
					background-color: mix(#000, #3e82c3, 15%);
				}
			}

			&-error {
				background-color: #f65050;
				color: #fff;

				&:hover {
					background-color: mix(#000, #f65050, 15%);
				}
			}

			&-success {
				background-color: #42b883;
				color: #fff;

				&:hover {
					background-color: mix(#000, #42b883, 15%);
				}
			}
		}

		&--line-color {
			border-color: #42b883;
			color: #42b883;

			&:hover {
				border-color: #42b883;
				background-color: #42b883;
				color: #fff;
			}

			&-1 {
				border-color: #42b883;
				color: #42b883;

				&:hover {
					border-color: #42b883;
					background-color: #42b883;
					color: #fff;
				}
			}

			&-2 {
				border-color: #35495e;
				color: #35495e;

				&:hover {
					border-color: #35495e;
					background-color: #35495e;
					color: #fff;
				}
			}

			&-3 {
				border-color: #3e82c3;
				color: #3e82c3;

				&:hover {
					border-color: #3e82c3;
					background-color: #3e82c3;
					color: #fff;
				}
			}

			&-error {
				border-color: #f65050;
				color: #f65050;

				&:hover {
					border-color: #f65050;
					background-color: #f65050;
					color: #fff;
				}
			}

			&-success {
				border-color: #42b883;
				color: #42b883;

				&:hover {
					border-color: #42b883;
					background-color: #42b883;
					color: #fff;
				}
			}
		}

		&--bg-white {
			background-color: #fff;
			color: #000;

			&:hover {
				background-color: #000;
				color: #fff;
			}
		}

		&--line-white {
			border-color: #fff;
			color: #fff;

			&:hover {
				border-color: #fff;
				background-color: #fff;
				color: #000;
			}
		}

		&--bg-black {
			background-color: #000;
			color: #fff;

			&:hover {
				background-color: #fff;
				color: #000;
			}
		}

		&--line-black {
			border-color: #000;
			color: #000;

			&:hover {
				background-color: #000;
				color: #fff;
			}
		}
	}
</style>
