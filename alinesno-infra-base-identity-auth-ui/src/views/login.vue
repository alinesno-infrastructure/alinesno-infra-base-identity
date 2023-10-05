<template>
  <el-container class="login-container">
    <el-header style="z-index: 100;height: 45px;background: #3b5998;box-shadow:0 2px 4px 0 var(--cb-color-shadow,rgba(0,0,0,0.16)) ;">
      <div>
        <div style="float: left;font-size: 30px;color:#fff;margin-top: 5px;">
          <img :src="homeLogo" style="width:35px" alt="">
        </div>
        <div class="banner-text">
          单点登陆服务
        </div>
        <a href="http://portal.infra.linesno.com/" 
           target="_blank" 
           style="float: right;font-weight: 500;font-size: 13px;margin-top: 14px;color:#fff;">
          <i class="fas fa-link"></i> 官网
        </a>
      </div>
    </el-header> 
    <el-main class="main-box" style="">

      <div class="login-content">
        
        <div class="marketing-wrapper">
          <div class="title-header">
            <span class="main-title">用户一次可通过一组登录凭证登入会话,在该次会话期间无需再次登录</span>
            <span class="sub-title">可安全访问多个相关的应用和服务</span>
          </div>
        </div>

        <div class="logo-box">
          <div class="wrapper">
            <div class="qr-method method ">
              <div class="alipay-channel">
                <div class="next-loading next-loading-inline" style="display: block; height: 100%;">
                  <div class="next-loading-wrap">
                    <div class="qrlogin-title">扫码登录</div>
                    <div class="qrcode-wrap app-text-wrap">
                      <div class="infra-qrcode-wrapper ">
                        <img class="infra-qrcode"
                          src="data:image/png;base64,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"
                          alt="二维码">
                      </div>
                      <div class="methods-text">使用
                        <span class="methods">二维码登陆</span>
                      </div>
                      <div class="methods-text hover-orange">使用OTLP绑定登陆</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="password-and-mobile-method method">
                  <div class="tabs-nav">
                    <div class="tabs-item" @click="loginType(true)" :class="smsLoginEnabled?'active':''">
                      <div class="tabs-item-text">验证码登陆</div>
                    </div>
                    <div class="tabs-item" @click="loginType(false)" :class="!smsLoginEnabled?'active':''" style="margin-left:30px;">
                      <div class="tabs-item-text">账号登录</div>
                    </div>
                  </div>
                  <div class="tab-content">

                    <!-- 验证码登陆_start  -->
                    <div class="tab-content-item" v-if="smsLoginEnabled" >
                      <div>
                        <div id="infra-login-iframe" class="password-login-wrapper iframe-loaded">

                              <div class="login">
                                <el-form ref="loginRef" :model="loginForm" :rules="loginRules" class="login-form">

                                  <el-form-item prop="phoneNumber">
                                    <el-input
                                      v-model="loginForm.phoneNumber"
                                      type="text"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="你的手机号"
                                    >
                                      <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                  </el-form-item>
                                  <el-form-item prop="phoneCode">
                                    <el-input
                                      v-model="loginForm.phoneCode"
                                      type="password"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="手机验证码"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="password" class="el-input__icon input-icon" /></template>
                                      <template #append>
                                        <el-button v-if="phoneCodeEnabled" type="primary" @click="getPhoneCode()" icon-class="search">获取验证码</el-button>
                                        <el-button v-if="!phoneCodeEnabled" type="primary" icon-class="search">{{ timer>=10?timer:'0'+timer }}秒后重发</el-button>
                                      </template>
                                    </el-input>
                                  </el-form-item>

                                  <el-form-item prop="code" v-if="captchaEnabled">
                                    <el-input
                                      v-model="loginForm.code"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="验证码"
                                      style="width: calc(100% - 120px)"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="validCode" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                    <div class="login-code">
                                      <img :src="codeUrl" @click="getCode" class="login-code-img"/>
                                    </div>
                                  </el-form-item>
                                  <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>
                                  <el-form-item style="width:100%;">
                                    <el-button
                                      :loading="loading"
                                      size="large"
                                      type="primary"
                                      style="width:100%;border:0px;background:#3b5998;"
                                      @click.prevent="handleLogin"
                                    >
                                      <span v-if="!loading">登 录</span>
                                      <span v-else>登 录 中...</span>
                                    </el-button>
                                  </el-form-item>
                                </el-form>
                              </div> 
                        </div>
                      </div>
                    </div>
                    <!-- 验证码登陆_end  -->


                    <!-- 账号密码登陆_start  -->
                    <div class="tab-content-item" v-if="!smsLoginEnabled" >
                      <div>
                        <div id="infra-login-iframe" class="password-login-wrapper iframe-loaded">

                              <div class="login">
                                <el-form ref="loginRef" :model="loginForm" :rules="loginRules" class="login-form">

                                  <el-form-item prop="username">
                                    <el-input
                                      v-model="loginForm.username"
                                      type="text"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="账号"
                                    >
                                      <template #prefix><svg-icon icon-class="user" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                  </el-form-item>
                                  <el-form-item prop="password">
                                    <el-input
                                      v-model="loginForm.password"
                                      type="password"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="密码"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="password" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                  </el-form-item>


                                  <el-form-item prop="code" v-if="captchaEnabled">
                                    <el-input
                                      v-model="loginForm.code"
                                      size="large"
                                      auto-complete="off"
                                      placeholder="验证码"
                                      style="width: calc(100% - 120px)"
                                      @keyup.enter="handleLogin"
                                    >
                                      <template #prefix><svg-icon icon-class="validCode" class="el-input__icon input-icon" /></template>
                                    </el-input>
                                    <div class="login-code">
                                      <img :src="codeUrl" @click="getCode" class="login-code-img"/>
                                    </div>
                                  </el-form-item>
                                  <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>

                                  <el-form-item style="width:100%;">
                                    <el-button
                                      :loading="loading"
                                      size="large"
                                      type="primary"
                                      style="width:100%;border:0px;background:#3b5998;"
                                      @click.prevent="handleLogin"
                                    >
                                      <span v-if="!loading">登 录</span>
                                      <span v-else>登 录 中...</span>
                                    </el-button>
                                  </el-form-item>
                                </el-form>
                              </div> 
                        </div>
                      </div>
                    </div>
                    <!-- 账号密码登陆_end  -->

                  </div>
            </div>
          </div>
          <div class="protocol">
            <div class="sc-eCImPb infra-dxc">未注册手机验证后自动登录，登录视为您已同意<span class="hover-orange"><a class="protocol">第三方账号绑定协议</a>、<a
                  class="protocol">服务条款</a>、<a class="protocol">隐私政策</a></span></div>
          </div>

        </div>
      </div>
    </el-main>
    <el-footer style="background: rgb(250, 250, 250);position: fixed;bottom: 0px;width: 100%;height: 45px;">
      <div class="copyright-text">© 2009-2023 portal.infra.linesno.com 版权所有 ICP证：桂ICP备15005934号-1</div>
    </el-footer>
  </el-container>
</template>

<script setup>
import { getCodeImg ,login , getRedirectUrl } from "@/api/login";
import Cookies from "js-cookie";
import { encrypt, decrypt } from "@/utils/jsencrypt";
import { getParam } from "@/utils/ruoyi" ;
import homeLogo from '@/assets/logo/logo.png'
import { setSaToken } from '@/utils/auth'

import useUserStore from '@/store/modules/user'
const userStore = useUserStore()
const router = useRouter();

const { proxy } = getCurrentInstance();

// 登陆方式类型
const smsLoginEnabled = ref(true);

const loginForm = ref({
  loginType: smsLoginEnabled.value  ,
  phoneNumber: "12345678901",
  phoneCode: "7653",
  username: "admin",
  password: "admin123",
  rememberMe: false,
  code: "9",
  uuid: ""
});

const loginRules = {
  phoneCode: [{ required: true, trigger: "blur", message: "请输入您的手机验证码" }],
  phoneNumber: [{ required: true, trigger: "blur", message: "请输入您的手机号" }],
  username: [{ required: true, trigger: "blur", message: "请输入您的账号" }],
  password: [{ required: true, trigger: "blur", message: "请输入您的密码" }],
  code: [{ required: true, trigger: "change", message: "请输入验证码" }]
};

const codeUrl = ref("");
const loading = ref(false);
// 验证码开关
const captchaEnabled = ref(true);
// 注册开关
// const register = ref(true);

// 控制发送验证码的倒计时效果
const timer = ref(0)
const phoneCodeEnabled = ref(true) ;

// 定时器id
let clearId ;

const redirect = ref(undefined);

// 点击获取手机验证码
const getPhoneCode = async() => {

  if (timer.value > 0){
    return;
  } 

  phoneCodeEnabled.value = false ; 

  // TODO 获取验证码
  // const res = await getCode(mobile.value, "login");

  timer.value = 60 ; 

  if(clearId){
    clearInterval(clearId) ;
  }

  clearId = setInterval(() => {
    timer.value--;
    if (timer.value == 0) {
      clearInterval(clearId);
      phoneCodeEnabled.value = true; 
    }
  }, 1000);

}


function handleLogin() {
  proxy.$refs.loginRef.validate(valid => {
    if (valid) {
      loading.value = true;

      // 勾选了需要记住密码设置在 cookie 中设置记住用户名和密码
      if (loginForm.value.rememberMe) {
        Cookies.set("username", loginForm.value.username, { expires: 30 });
        Cookies.set("password", encrypt(loginForm.value.password), { expires: 30 });
        Cookies.set("rememberMe", loginForm.value.rememberMe, { expires: 30 });

        Cookies.set("phoneNumber", loginForm.value.phoneNumber, { expires: 30 });
        Cookies.set("phoneCode", loginForm.value.phoneCode, { expires: 30 });
      } else {
        // 否则移除
        Cookies.remove("username");
        Cookies.remove("password");
        Cookies.remove("rememberMe");

        Cookies.remove("phoneNumber");
        Cookies.remove("phoneCode");
      }

      // 调用action的登录方法
      userStore.login(loginForm.value).then((res) => {

        console.log('res = ' + res) ;
        // 登陆成功，则刷新界面
        checkHasLogin();

      }).catch((err) => {
        console.log('error = ' + err) ;
        loading.value = false;
        // 重新获取验证码
        if (captchaEnabled.value) {
          getCode();
        }
      });

    }
  });
}

// 离开界面方法
onMounted(() => {
      clearInterval(clearId) ;
})

function loginType(tip) {
  smsLoginEnabled.value = tip ;
}

function getCode() {
  getCodeImg().then(res => {
    captchaEnabled.value = res.captchaEnabled === undefined ? true : res.captchaEnabled;
    if (captchaEnabled.value) {
      codeUrl.value = "data:image/gif;base64," + res.img;
      loginForm.value.uuid = res.uuid;
    }
  });
}

function getCookie() {

  const username = Cookies.get("username");
  const password = Cookies.get("password");
  const rememberMe = Cookies.get("rememberMe");

  loginForm.value = {
    username: username === undefined ? loginForm.value.username : username,
    password: password === undefined ? loginForm.value.password : decrypt(password),
    rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
  };
}

// 检查当前是否已经登录，如果已登录则直接开始跳转，如果未登录则等待用户输入账号密码
function checkHasLogin(){
  var pData = {
    client: getParam('client', ''), 
    redirect: getParam('redirect', ''), 
    mode: getParam('mode', '')
  };

  console.log('pData = ' + JSON.stringify(pData)) ;

  getRedirectUrl(pData).then(res => {
    console.log('res = ' + res) ;

    if(res.sso_login) {

      debugger 

      // 已登录，并且redirect地址有效，开始跳转  
      location.href = decodeURIComponent(res.data);
    } else if(res.code == 401) {
      console.log('未登录');
    } else {
      // TODO 输出异常信息
    }

  });

}

getCode();
getCookie();

checkHasLogin();

</script>

<style lang="scss">
</style>
