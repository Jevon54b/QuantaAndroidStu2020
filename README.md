# QuantaAndroidStu2020/02/23
多线程和网络请求直播课源代码

直播课内容概要
多线程/网络请求  （侧重讲使用方法/原理篇幅较长，有兴趣可以自行探索）
一.多线程 
 //主线程 负责ui交互逻辑、    子线程负责处理耗时操作
1.线程的几种写法（匿名接口类/（java8支持lambda简洁写法）
2.handler  、runOnUiThread()（普通写法的内存泄露情况 原理及优化方法https://blog.csdn.net/alex01550/article/details/82744191 )  
3.asyncTask  //子线程 调用doInBackground() 、  // 主线程上调用：onPreExecute()、onProgressUpdate（）、onPostExecute()



二.网络请求（同步与异步）
1.get post 概念 一般来讲 get 从服务器获取数据  post 上传表单到服务器，也会获取数据   http请求   request 、response
httpconnection 
2.okhttp使用   （应用进行网络操作需申请权限，Android P之后无法直接访问非加密http连接，这里建议用真机或是android8.0及以下版本的模拟器，如果还是不行可以在manifest文件中声明android:usesCleartextTraffic="true"） 
3.请求封装类  
4.数据解析（GSON、GsonFormat插件）  JSON格式
5.推荐使用优秀第三方网络请求框架volley/retrofit等
6.postman 接口测试工具

例子     同步：提交请求->等待服务器处理->处理完毕返回   这个期间客户端浏览器不能干任何事
         异步: 请求通过事件触发->服务器处理（这时浏览器仍然可以作其他事情）->处理完毕

三.quanta杯（组队开发）
对接产品：根据产品demo构建项目结构，学习缺乏的知识点
对接设计：设计资源通常有页面psd、图片图标资源  推荐使用pxcook软件
对接后台：后台接口文档 
