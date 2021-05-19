# WanAndroid 开放API

## 1.首页相关
### 1.1 首页文章列表
>> https://www.wanandroid.com/article/list/0/json
>> 方法：GET
>> 参数：页码，拼接在连接中，从0开始。

### 1.2 首页banner
>> https://www.wanandroid.com/banner/json
>> 方法：GET
>> 参数：无

### 1.3 常用网站
>> https://www.wanandroid.com/friend/json
>> 方法：GET
>> 参数：无
>> 可直接点击查看示例：https://www.wanandroid.com/friend/json

### 1.4 搜索热词
>> 即目前搜索最多的关键词。
>> https://www.wanandroid.com//hotkey/json
>> 方法：GET
>> 参数：无
>> 可直接点击查看示例：https://www.wanandroid.com/hotkey/json

### 1.5 置顶文章
>> https://www.wanandroid.com/article/top/json



## 2. 体系
### 2.1 体系数据
>> https://www.wanandroid.com/tree/json
>> 方法：GET
>> 参数：无
>> 可直接点击查看示例：https://www.wanandroid.com/tree/json

### 2.2 知识体系下的文章
>> https://www.wanandroid.com/article/list/0/json?cid=60
>> 方法：GET
>> 参数：
>> cid 分类的id，上述二级目录的id
>> 页码：拼接在链接上，从0开始。
>> 例如查看类别：Android Studio下所有的文章：https://www.wanandroid.com/article/list/0/json?cid=60

### 2.3 按照作者昵称搜索文章
>> https://wanandroid.com/article/list/0/json?author=鸿洋
>> 方法:GET
>> 页码：拼接在链接上，从0开始。
>> author：作者昵称，不支持模糊匹配。



## 3. 导航
### 3.1 导航数据
>> https://www.wanandroid.com/navi/json
>> 方法：GET
>> 参数：无
>> 可直接点击查看示例：https://www.wanandroid.com/navi/json



## 4. 项目
### 4.1 项目分类
>> https://www.wanandroid.com/project/tree/json
>> 方法： GET
>> 参数： 无
>> 项目为包含一个分类，该接口返回整个分类。
>> 可以直接访问：https://www.wanandroid.com/project/tree/json

### 4.2 项目列表数据
>> 某一个分类下项目列表数据，分页展示
>> https://www.wanandroid.com/project/list/1/json?cid=294
>> 方法：GET
>> 参数：
>> cid 分类的id，上面项目分类接口
>> 页码：拼接在链接中，从1开始。
>> 可以直接访问：https://www.wanandroid.com/project/list/1/json?cid=294



## 5. 登录与注册
### 5.1 登录
>> https://www.wanandroid.com/user/login
>> 方法：POST
>> 参数：
>> username，password
>> 登录后会在cookie中返回账号密码，只要在客户端做cookie持久化存储即可自动登录验证。

### 5.2 注册
>> https://www.wanandroid.com/user/register
>> 方法：POST
>> 参数
>> username,password,repassword
	
### 5.3 退出
>> https://www.wanandroid.com/user/logout/json
>> 方法：GET
>> 访问了 logout 后，服务端会让客户端清除 Cookie（即cookie max-Age=0），如果客户端 Cookie 实现合理，可以实现自动清理，如果本地做了用户账号密码和保存，及时清理。
>> 如果需要特殊的errorCode 来支持清除数据，请反馈。



