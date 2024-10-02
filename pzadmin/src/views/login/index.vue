<template>
  <el-row class="login-container"
          justify="center"
          :align="'middle'">
    <el-card style="max-width: 480px">
      <template #header>
        <div class="card-header">
          <img :src="imgUrl" alt="">
        </div>
      </template>
      <div class="jump-link">
        <el-link type="primary" @click="handleChange">{{ formType ? '返回登录' : '注册账号' }}</el-link>
      </div>
      <el-form
          ref="loginFormRef"
          :model="loginForm"
          style="max-width: 600px"
          class="demo-ruleForm"
          :rules="rules">
        <el-form-item prop="userName">
          <el-input v-model="loginForm.userName" placeholder="手机号" :prefix-icon="UserFilled"></el-input>
        </el-form-item>
        <el-form-item prop="passWord">
          <el-input v-model="loginForm.passWord" type="password" placeholder="密码" :prefix-icon="Lock"></el-input>
        </el-form-item>
        <el-form-item v-if="formType" prop="validCode">
          <el-input v-model="loginForm.validCode" placeholder="验证码" :prefix-icon="Lock">
            <template #append>
              <span @click="countDownChange">{{ countDown.validText }}</span>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%" @click="submitForm(loginFormRef)">
            {{ formType ? '注册' : '登录' }}
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </el-row>
</template>

<script setup lang="ts">
import {ref, reactive} from 'vue'
import {Lock, UserFilled} from "@element-plus/icons-vue";
import {ElMessage} from "element-plus";
import {getCode, userAuthentication, login} from "../../api";
import {useRouter} from "vue-router";

const imgUrl = new URL('../../../public/login-head.png', import.meta.url).href

// 表达数据
const loginForm = reactive({
  userName: '',
  passWord: '',
  validCode: ''
})

// 切换表单（0登录 1注册）
const formType = ref(0)

// 点击切换登录和注册
const handleChange = () => {
  formType.value = !formType.value
}

const rules = reactive({
  userName: [
    {required: true, message: '请输入手机号', trigger: 'blur'},
    {
      pattern: /^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\d{8}$/,
      message: '请输入正确的手机号',
      trigger: 'blur'
    }
  ],
  passWord: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 6, message: '密码长度不能小于6位', trigger: 'blur'},
    {
      pattern: /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$/,
      message: '密码必须包含字母和数字',
      trigger: 'blur'
    }
  ]
})

// 发送短信
const countDown = reactive({
  validText: '获取验证码',
  time: 10
});

let flag = false
const countDownChange = () => {
  // 如果已经发送短信，则返回
  if (flag) return
  // 判断手机号是否正确
  const phoneReg = /^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\d{8}$/
  if (!loginForm.userName || !phoneReg.test(loginForm.userName)) {
    return ElMessage({
      message: '请输入正确的手机号',
      type: 'warning'
    })
  }
  // 倒计时
  const time = setInterval(() => {
    if (countDown.time <= 0) {
      countDown.time = 10;
      countDown.validText = '获取验证码';
      flag = false
      clearInterval(time);
    } else {
      countDown.time--;
      countDown.validText = countDown.time + '秒后重发';
    }
  }, 1000);
  flag = true
  getCode({tel: loginForm.userName}).then(
      data => {
        if (data.code === 10000) {
          ElMessage.success('发送成功')
        }
      }
  )
}

const router = useRouter()
const loginFormRef = ref()
// 表单提交
const submitForm = async (formEl) => {
  ElMessage.warning('正在提交')
  if (!formEl) return
  // 手动触发校验
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log(loginForm, 'submit!')
      // 注册页面
      if (formType.value) {
        userAuthentication(loginForm).then(({data}) => {
          if (data.code === 10000) {
            ElMessage.success('注册成功，请登录')
            formType.value = 0
          }
        })
      } else {
        // 登录页面
        login(loginForm).then(({data}) => {
          if (data.code === 10000) {
            ElMessage.success('登录成功')
            console.log(data, 'data')
            // 将token和用户信息保存到localStorage
            localStorage.setItem('pz_token', data.data.token)
            localStorage.setItem('pz_userInfo', JSON.stringify(data.data.userInfo))
            router.push('/')
          }
        })
      }
    } else {
      console.log('error submit!', fields)
    }
  })
}
</script>

<style lang="less" scoped>
:deep(.el-card__header) {
  padding: 0
}

.login-container {
  height: 100%;

  .card-header {
    background-color: #899fe1;

    img {
      width: 430px;
    }
  }

  .jump-link {
    text-align: right;
    margin-bottom: 10px;
  }
}
</style>
