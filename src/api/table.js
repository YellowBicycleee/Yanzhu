import request from '@/utils/request'

// 报研
export function getBaoYanList(params) {
  return request({
    url: '/postgraduateRecommendation/CSY',
    method: 'post',
    params: params
  })
}

export function getKaoYanList(params) {
  return request({
    url: '/postgraduateTest/all',
    method: 'get',
    params: params
  })
}
