# marsss_will_do
  [marsss_will_do]是一个 Todo记录 类型的项目，采用了前后端分离的开发模式。
  当前仓库是 [marsss_will_do]的后端项目，对应的前端项目地址为：  [待关联到github]
 [***目前前后端还在开发中。。。。。(前期为了配置跟统一这项目中的axios、vue等的规范，花费了不少时间。。。QAQ)] 
  
  后端使用到的框架主要有 {
    基础：Springboot
    数据库相关：Hibrenate、Mysql、Druid、Redis
    Api文档：Swagger2
  }
  前端使用到的框架主要有 {
     基础：Vue、Npm、Vuex
     UI: ElementUI
     Css: Stylus
     Http： axios
  }
  后端项目主要是用来给前端Vue请求，页面全部在前端渲染。
  前端配置了 {
    axios的 [提交token、返回结果预处理、跨域请求]等配置,
    Vuex
    router路由,
    在main.js引用公用工具类，让Vue在子组件各处都能使用到该工具类
    reset.css/border.css
  }
  
