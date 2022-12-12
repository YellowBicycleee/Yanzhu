import Cookies from 'js-cookie'

const TokenKey = 'vue_admin_template_token'
const UserKey = 'name'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function getName() {
  return Cookies.get(UserKey)
}

export function setName(name) {
  return Cookies.set(UserKey, name)
}
