import { createApp } from 'vue'

import Cookies from 'js-cookie'

import ElementPlus from 'element-plus'
import locale from 'element-plus/lib/locale/lang/zh-cn' // 中文语言

import 'element-plus/dist/index.css'
import '@/assets/styles/index.scss' // global css

import App from './App'
import store from './store'
import router from './router'

// svg图标
import 'virtual:svg-icons-register'
import SvgIcon from '@/components/SvgIcon'
import elementIcons from '@/components/SvgIcon/svgicon'

import GLOBAL_VAR from '@/api/global_variable.js'
import GLOBAL_FUN from '@/api/global_function.js'

import './permission' // permission control

const app = createApp(App)

app.config.globalProperties.GLOBAL_VAR = GLOBAL_VAR
app.config.globalProperties.GLOBAL_FUN = GLOBAL_FUN

app.use(router)
app.use(store)

app.use(elementIcons)
app.component('svg-icon', SvgIcon)

// 使用element-plus 并且设置全局的大小
app.use(ElementPlus, {
  locale: locale,
  // 支持 large、default、small
  size: Cookies.get('size') || 'default'
})

app.mount('#app')
