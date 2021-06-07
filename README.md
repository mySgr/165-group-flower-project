# 技术背景

前后端分离项目

- 服务端：
  	jdk8
  	mybatis(3.5.6 版本)
  	mysql(8.0.23 版本)
  	maven(3.63 版本)

- 数据交互：
  	jackson(2.12.3 版本)
  	

- 客户端：
  	vue.js
  	element-ui
  	axios.js

- 要求：
  前端：
  	1. 开发工具使用 vs code
  	2. 充分利用 axios 拦截器
  	

  后端：
  	1. 加一层自己的 servlet ,后续使用这一个 servlet 。因为 servlet 可能有一些常用的东西。
  	2. 统一结果处理（ResultVo）
  	3. 统一异常处理 
  	4.命名规范，杜绝出现单字母类，实现类必须 加Impl ，比如 有一个接口 UserMapper,实现类命名则UserMapperImpl
  	5. 测试使用 Postman

- 基本功能：

用户管理
	用户列表
	查看用户
	

会员管理
	会员管理

仓库管理（可选）
	
商品管理
	商品列表

数据分析

设置