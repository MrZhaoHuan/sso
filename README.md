##1. cas官网或github上下载cas4.x服务端和客户端
##2. tomcat server.xml配置 和 hosts文件配置
![tomcat配置](https://github.com/MrZhaoHuan/sso/blob/master/steps/tomcat配置.png)
![tomcat配置2](https://github.com/MrZhaoHuan/sso/blob/master/steps/tomcat配置2.png)
![hosts配置](https://github.com/MrZhaoHuan/sso/blob/master/steps/hosts配置.png)
##3. 启动tomcat
![首页](https://github.com/MrZhaoHuan/sso/blob/master/steps/indexPage.png)
##3.1 notice:
   cas默认是https协议，回送的cookie是secure的
##4. 修改默认的校验机制(换成自己的数据库)
`需要引入druid和mysql连接的jar，还需要cas-server-support-jdbc-4.0.0.jar`
![数据库校验](https://github.com/MrZhaoHuan/sso/blob/master/steps/修改cas默认登录校验机制.png)
##5. 配置多个客户端实现sso
   ###5.1 新建web工程，引入cas客户端相关的2个jar包(cas-client-core-3.2.1.jar和commons-logging.jar)
   ###5.2 配置web.xml，配置cas相关的Filter和Listener

##6. 修改cas认证成功后的返回信息

##7. 修改cas默认登录页面
    多系统，且各子系统数据库独立的情况下，登录页面可以加1个选项，让用户选择用哪个子系统账号登录
    ，登录成功后，关联各个子系统账号(比如:根据当前登录用户的手机号关联其他子系统账号，
    当用户进入其他子系统后，查询该用户在其他子系统的账号，根据子系统账号做权限处理(比如菜单显示，用户信息显示，操作权限等))，
    根据业务需求，对用户做权限处理(用户user在子系统A登录后，进入B系统，用户user在B系统的身份应该是B系统数据库对应的user信息)
