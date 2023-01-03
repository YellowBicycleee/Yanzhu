<template>
  <div
    class="tag"
    :class="{ 'tag--value-number': typeof tagValue == 'number' }"
  >
    <span class="tag__name">
      {{ tagName }}
    </span>
    <span class="tag__value">
      {{ tagValue }}
    </span>
  </div>
</template>

<script>
export default {
  name: 'UITag',
  props: {
    tagName: {
      type: String,
      required: true
    },
    tagValue: {
      type: [
        String,
        Number
      ]
    }
  }
}
</script>

<style lang="scss" scoped>
	.tag {
		display: flex;
		align-items: center;
		padding: 2px 2px 2px 10px;
		border-radius: 20px;
		background-color: #3e82c3;

		&__name {
			margin-right: 5px;
			color: #fff;
			font-weight: 600;
		}

		&__value {
			display: flex;
			align-items: center;
			justify-content: center;
			padding: 2px 5px;
			border-radius: 20px;
			background-color: #fff;
			color: #3e82c3;
			font-weight: 600;
			text-align: center;
		}

		&--value-number {
			.tag {
				&__value {
					width: 20px;
					height: 20px;
					border-radius: 50%;
				}
			}
		}
	}
</style>
