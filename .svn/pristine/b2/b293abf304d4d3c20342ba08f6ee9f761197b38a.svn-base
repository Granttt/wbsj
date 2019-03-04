## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql)支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 在线构建器：拖动表单元素生成相应的HTML代码。
16. 连接池监视：监视当期系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 项目结构
```
com.wangbo     
├── wangbo-common            // 工具类
│       └── annotation                    // 自定义注解
│       └── config                        // 全局配置
│       └── constant                      // 通用常量
│       └── enums                         // 通用枚举
│       └── exception                     // 通用异常
│       └── json                          // JSON数据处理
│       └── support                       // 字符集处理
│       └── utils                         // 通用类处理
│       └── xss                           // XSS过滤处理
├── wangbo-framework         // 框架核心
│       └── aspectj                       // 注解实现
│       └── config                        // 系统配置
│       └── datasource                    // 数据权限
│       └── manager                       // 异步处理
│       └── shiro                         // 权限控制
│       └── util                          // 通用工具
│       └── web                           // 前端控制
├── wangbo-generator          // 代码生成
├── wangbo-quartz             // 定时任务
├── wangbo-system             // 系统代码
├── wangbo-admin              // 后台服务
├── wangbo-website            // 网站模块
```
#开发
###1.分页
前端表格Bootstrap Table，Mybatis分页插件PageHelper
启动分页关键代码startPage()（只对该语句以后的第一个查询语句得到的数据进行分页）
```
@ResponseBody
public TableDataInfo list(User user){
    startPage();  // 此方法配合前端完成自动分页
    List<User> list = userService.selectUserList(user);
    return getDataTable(list);
}
```
###2.日志记录
在实际开发中，对于某些关键业务，我们通常需要记录该操作的内容
在需要被记录日志的方法上添加@Log注解，配置请求后记录到（系统管理-操作日志）
@Log(title = "用户管理", businessType = BusinessType.INSERT)
```
/** 业务模块 如：用户管理 */
String title() default "";

/** 操作功能 如：INSERT */
BusinessType businessType() default BusinessType.OTHER;

/** 操作人类别 如：MANAGE */
OperatorType operatorType() default OperatorType.MANAGE;

/** 是否保存请求的参数 如：true */
boolean isSaveRequestData() default true;
```
逻辑实现代码 com.wangbo.framework.aspectj.LogAspect
操作类别默认为MANAGE后台用户，操作功能默认为OTHER其他，默认保存请求参数
###3.数据权限
在实际开发中，需要设置用户可以查看哪些部门的数据，一般称为数据权限
默认用户admin拥有所有权限（userId=1）
在需要数据权限控制方法上添加@DataScope注解
@DataScope(tableAlias = "u")
```
/** 表的别名 */
String tableAlias() default "";
```
逻辑实现代码 com.wangbo.framework.aspectj.DataScopeAspect
在mybatis添加数据范围过滤${params.dataScope}
###4.前端组件
```
表格	$.table	表格封装处理
表格树	$.treeTable	表格树封装处理
表单	$.form	表单封装处理
弹出层	$.modal	弹出层封装处理
操作	$.operate	操作封装处理
校验	$.validate	校验封装处理
树插件	$.tree	树插件封装处理
通用方法	$.common	通用方法封装处理
```
