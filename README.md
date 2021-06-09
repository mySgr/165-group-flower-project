# 项目使用说明

本项目前端是使用 vue-cli 开发的。所以你要先进入 user-client、admin-client 这两个文件夹安装对应的文件，安装命令`npm install`

启动服务 `npm run serve`

- user-client : 使用`http://localhost:9999` 进行访问
- admin-client:使用`http://localhost:8888`进行访问



# 开发日志

- 2021/6/7

  创建项目



# 技术背景

前后端分离项目

- 开发工具
  - maven(3.63 版本)	
  - idea
  - git
  - vs code

- 服务端：
  - jdk8
  - mybatis(3.5.6 版本)
  - mysql(8.0.23 版本)

- 数据交互：使用 jackson(2.12.3 版本) 进行数据转换
- 客户端：
  - vue.js
  - element-ui
  - axios.js



# 开发要求

使用 git 的 PR 工作流。

1. 每个组员，都登录自己的账号，然后，fork 这个项目
2. 每个组员，将自己账号下面的此项目clone 到本地
3. 每个组员，在本地的 git 仓库下，创建一个分支，分支名为自己的名字（比如，江江的分支名为 jj)，以后进行代码的推送或 PR 要基于自己的分支
4. 下游仓库同步上游仓库的步骤
   1. 查看所有的远程库的远程地址 : `git remote -v`
   2. 添加源分支 URL : `git remote add upstream [上游仓库URL]`
   3. 查看是否添加成功：`git remote -v`
   4. 从源分支获取最新的代码：`git fetch upstream`
   5. 合并本地分支和源分支：`git merge upstream/master`
   6. 最后 push 到 fork 分支：`git push`

前端：

 1. 开发工具使用 vs code
 2. 充分利用 axios 拦截器

后端：
 1. 加一层自己的 servlet ,后续使用这一个 servlet 。因为 servlet 可能有一些常用的东西。
 2. 统一结果处理（ResultVo）
 3. 统一异常处理 
 4. 命名规范，杜绝出现单字母类，实现类必须 加Impl ，比如 有一个接口 UserMapper,实现类命名则UserMapperImpl
 5. 测试使用 Postman



# 基本功能

- 用户管理
  - 用户列表
  - 查看用户	

- 会员管理
  - 会员管理

- 仓库管理（可选）

  - 仓库信息

- 商品管理
	- 商品列表

- 数据分析

- 设置