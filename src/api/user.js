import request from '@/utils/request'

export function login(params) {
  return request({
    url: '/user/loginCheck',
    method: 'post',
    params
  })
}

export function getInfo(token) {
  return request({
    url: '/vue-admin-template/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}

// /user/resetPass

export function resetPass(params) {
  return request({
    url: '/user/resetPass',
    method: 'post',
    params
  })
}

export function registerUser(params) {
  return request({
    url: '/user/regAdd',
    method: 'post',
    params
  })
}
