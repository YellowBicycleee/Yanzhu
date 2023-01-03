<template>
  <div
    class="message"
    :class="{ 'is-close': isClose }"
  >
    <div class="message__inner">
      <div class="message__content">
        <slot />
      </div>
      <UIButton
        v-if="!isClose"
        class="message__button button--bg-black button--icon"
        @button-click="closeMessage()"
      >
        <span class="button__icon">
          <i class="icon">
            <FontAwesomeIcon icon="times" />
          </i>
        </span>
      </UIButton>
      <UIButton
        v-else
        class="message__button button--bg-black button--icon"
        @button-click="openMessage()"
      >
        <span class="button__icon">
          <i class="icon">
            <FontAwesomeIcon icon="info" />
          </i>
        </span>
      </UIButton>
    </div>
  </div>
</template>

<script>
import UIButton from '../UI/UIButton.vue'

export default {
  name: 'UIMessage',
  components: {
    UIButton
  },
  data() {
    return {
      isClose: false
    }
  },
  methods: {
    openMessage() {
      this.isClose = false
    },
    closeMessage() {
      this.isClose = true
    }
  }
}
</script>

<style lang="scss" scoped>
	.message {
		z-index: 999;
		right: 30px;
		bottom: 30px;
		max-width: 600px;
		transition: all 0.3s ease-in-out 0s;
		border-radius: 30px;
		background-color: $color-brand-4;
		box-shadow: 0 1px 4px 1px rgba(#000, 0.6);

		@include media('md') {
			max-width: calc(100% - 30px * 2);
		}

		@include media('sm') {
			display: flex;
			position: relative;
			right: inherit;
			bottom: inherit;
			max-width: inherit;
			float: right;
		}

		@include media('md', 'max', 'height') {
			display: flex;
			position: relative;
			right: inherit;
			bottom: inherit;
			max-width: inherit;
			float: right;
		}

		&__inner {
			display: flex;
			position: relative;
			align-items: center;
			justify-content: flex-end;
			margin: 4px;
		}

		&__button {
			width: 25px;
			height: 25px;
			border-radius: 50%;
		}

		&__content {
			width: calc(100% - 25px);
			max-height: 50px;
			padding: 5px 30px 5px 25px;
			overflow: hidden;
			transition: all 0.5s ease-in-out 0.3s;
			color: #fff;
			font-size: 15px;
			font-weight: 600;
			line-height: 100%;

			@include media('sm') {
				font-size: 12px;
			}

			@include media('xs') {
				font-size: 3vw;
			}
		}

		&.is-close {
			.message {
				&__content {
					z-index: -1;
					width: 0;
					max-height: 0;
					padding: 0;
					opacity: 0;
				}
			}
		}
	}
</style>
