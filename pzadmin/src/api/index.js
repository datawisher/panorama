import request from "../utils/request.js";

// 发送验证码
export const getCode = (data) => {
    return request.post('/get/code', data)
}

// 注册用户
export const userAuthentication = (data) => {
    return request.post('/user/authentication', data)
}

// 登录
export const login = (data) => {
    return request.post('/login', data)
}
