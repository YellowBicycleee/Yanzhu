<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'
require('echarts/theme/macarons') // echarts theme
import resize from './mixins/resize'

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
      default: '300px'
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
          text: '历年录取人数',
          left: 'center',
          textStyle: {
            color: '#333',
            fontWeight: 'bolder'
          }

        },
        // toolbox: {
        //   feature: {
        //     saveAsImage: {}
        //   }
        // },
        xAxis: {
          data: xAxis || ['2019', '2020', '2021', '2022', '2023'],
          boundaryGap: false,
          axisTick: {
            show: false
          },
          // nameTextStyle: {
          //   color: ['#9B9EAC']
          // },
          axisLine: {
            lineStyle: {
              color: '#9B9EAC'
            }
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          },
          padding: [5, 10]
        },
        yAxis: {
          axisTick: {
            show: false
          },
          // nameTextStyle: {
          //   color: ['#9B9EAC']
          // },
          axisLine: {
            lineStyle: {
              color: '#9B9EAC'
            }
          }
        },
        series: [
          {
            name: '当前时段',
            smooth: false,
            type: 'line',
            itemStyle: {
              color: '#0770FF'
            },
            areaStyle: {
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {
                  offset: 0,
                  color: 'rgba(58,77,233,0.8)'
                },
                {
                  offset: 1,
                  color: 'rgba(58,77,233,0.3)'
                }
              ])
            },
            data: data || [100, 50, 20, 40, 100],
            animationDuration: 2800,
            animationEasing: 'quadraticOut'
          }]
      })
    }
  }
}
</script>
