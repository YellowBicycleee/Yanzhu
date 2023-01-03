import request from '@/utils/request'

// 报研
export function qaQuestion(question) {
  return request({
    url: `/qa/${question}/`,
    method: 'get'
  })
}
