import { createWebHistory, createRouter } from 'vue-router'
/* Layout */
import Layout from '@/layout/SaaSLayout'
// import Layout from '@/layout'

/**
 * Note: 路由配置项
 *
 * hidden: true                     // 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1
 * alwaysShow: true                 // 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
 *                                  // 只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
 *                                  // 若你想不管路由下面的 children 声明的个数都显示你的根路由
 *                                  // 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
 * redirect: noRedirect             // 当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
 * name:'router-name'               // 设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
 * query: '{"id": 1, "name": "ry"}' // 访问路由的默认传递参数
 * roles: ['admin', 'common']       // 访问路由的角色权限
 * permissions: ['a:a:a', 'b:b:b']  // 访问路由的菜单权限
 * meta : {
    noCache: true                   // 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
    title: 'title'                  // 设置该路由在侧边栏和面包屑中展示的名字
    icon: 'svg-name'                // 设置该路由的图标，对应路径src/assets/icons/svg
    breadcrumb: false               // 如果设置为false，则不会在breadcrumb面包屑中显示
    activeMenu: '/system/user'      // 当路由设置了该属性，则会高亮相对应的侧边栏。
  }
 */

// 公共路由
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login'),
    hidden: true
  },
  {
    path: '/sso/login',
    component: () => import('@/views/loginSso'),
    hidden: true
  },
  {
    path: "/:pathMatch(.*)*",
    component: () => import('@/views/error/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: '/index',
    hidden: true,
    children: [
      {
        path: '/index',
        component: () => import('@/views/index'),
        name: '/index',
        meta: { title: '首页', icon: 'dashboard', affix: true }
      },
      {
        path: '/dashboard/suportTechnique',
        component: () => import('@/views/suportTechnique'),
        name: '/dashboard/suportTechnique',
        meta: { title: '支持管理', icon: 'dashboard', affix: true }
      },
      {
        path: '/dashboard/learnPanel',
        component: () => import('@/views/learnPanel'),
        name: '/dashboard/learnPanel',
        meta: { title: '学习手册', icon: 'dashboard', affix: true }
      },

      // >>>>>>>>>>>>>> identity_router_start >>>>>>>>>>>>>>>>>>>>>
      {
        path: '/base/identity/application/index',
        component: () => import('@/views/base/identity/application/index'),
        name: '/base/identity/application/index',
        meta: { title: '应用管理', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/identity/online/index',
        component: () => import('@/views/base/identity/online/index'),
        name: '/base/identity/online/index',
        meta: { title: '在线用户', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/identity/account/index',
        component: () => import('@/views/base/identity/account/index'),
        name: '/base/identity/account/index',
        meta: { title: '账户管理', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/identity/config/index',
        component: () => import('@/views/base/identity/config/index'),
        name: '/base/identity/config/index',
        meta: { title: '认证配置', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/identity/security/index',
        component: () => import('@/views/base/identity/security/index'),
        name: '/base/identity/security/index',
        meta: { title: '企业配置', icon: 'dashboard', affix: true }
      }, 
      {
        path: '/base/identity/record/index',
        component: () => import('@/views/base/identity/record/index'),
        name: '/base/identity/record/index',
        meta: { title: '日志记录', icon: 'dashboard', affix: true }
      }, 
      // >>>>>>>>>>>>>> identity_router_end   >>>>>>>>>>>>>>>>>>>>>

    ]
  },
//  {
//    path: '/user',
//    component: Layout,
//    hidden: true,
//    redirect: 'noredirect',
//    children: [
//      {
//        path: 'profile',
//        component: () => import('@/views/system/user/profile/index'),
//        name: 'Profile',
//        meta: { title: '个人中心', icon: 'user' }
//      }
//    ]
//  }
]

// 动态路由，基于用户权限动态去加载
export const dynamicRoutes = [
]

const router = createRouter({
  history: createWebHistory(),
  routes: constantRoutes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  },
});

export default router;