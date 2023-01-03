<template>
  <div :class="className" :style="{height:height, width:width}" />
</template>

<script>
import * as echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'

const total = [1626, 1668, 1706, 1761, 2001]
const baokao = [238, 290, 341, 377, 457]
const luqu = [72, 72, 114, 105, 111]

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '100%'
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    chartData: {
      type: Object,
      default: () => ({})
    }
  },
  data() {
    return {
      chart: null
    }
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.initChart()
      }
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOptions(this.chartData)
    },
    setOptions({ data, xAxis } = {}) {
      this.chart.setOption({
        title: {
          text: '历年考研情况(万人)',
          left: 'center',
          textStyle: {
            color: '#333',
            fontWeight: 'bolder'
          }

        },
        legend: {
          data: ['本科在校', '考研报考', '考研录取', '录取比例'],
          bottom: 0
        },
        xAxis: {
          type: 'category',
          data: xAxis || ['2018 年', '2019 年', '2020 年', '2021 年', '2022 年'],
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: 10,
          right: 40,
          bottom: 30,
          top: 35,
          containLabel: true
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          }
        },
        yAxis: [
          {
            type: 'value',
            name: '人数',
            min: 0,
            // max: 2100,
            axisLabel: {
              formatter: '{value} 万'
            }
          },
          {
            type: 'value',
            name: '录取比例',
            axisLabel: {
              formatter: '{value} %'
            }
          }],

        series: [
          {
            name: '本科在校',
            type: 'bar',
            barWidth: 20, // 柱图宽度
            tooltip: {
              valueFormatter: function(value) {
                return value + ' 万'
              }
            },
            data: total
          },
          {
            name: '考研报考',
            type: 'bar',
            barWidth: 20, // 柱图宽度
            tooltip: {
              valueFormatter: function(value) {
                return value + ' 万'
              }
            },
            data: baokao
          },
          {
            name: '考研录取',
            barWidth: 20, // 柱图宽度
            type: 'bar',
            tooltip: {
              valueFormatter: function(value) {
                return value + ' 万'
              }
            },
            data: luqu
          },
          {
            name: '录取比例',
            type: 'line',
            yAxisIndex: 1,
            tooltip: {
              valueFormatter: function(value) {
                return value + ' %'
              }
            },
            data: luqu.map((item, index) => {
              return +((item / baokao[index]) * 100).toFixed(2)
            })
          }

        ]
      })
    }
  }
}
</script>
