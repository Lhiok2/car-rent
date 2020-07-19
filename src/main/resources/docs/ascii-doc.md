# car-rent项目API文档


<a name="overview"></a>
## 概览
car-rent-1.0项目API文档


### 版本信息
*版本* : 1.0


### 许可信息
*服务条款* : http://localhost:8080


### URI scheme
*域名* : localhost:8080  
*基础路径* : /


### 标签

* bill-controller : Bill Controller
* 安全相关 : Security Controller
* 用户信息 : User Controller
* 车辆管理 : Car Controller




<a name="paths"></a>
## 资源

<a name="bill-controller_resource"></a>
### Bill-controller
Bill Controller


<a name="addbillusingpost"></a>
#### 租贷车辆
```
POST /api/v1/bills
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**cid**  <br>*必填*|车辆id|[Long](#long)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«账单信息构造类»](#bd24d8ef62fa01f42c74364a830b9a30)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/bills
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : {
    "billId" : 0,
    "billState" : "string",
    "car" : {
      "cid" : 0,
      "createTime" : "string",
      "license" : {
        "brand" : "string",
        "lid" : 0,
        "region" : "string"
      },
      "number" : "string",
      "price" : 0,
      "state" : "string"
    },
    "cost" : 0,
    "endTime" : "string",
    "startTime" : "string",
    "user" : {
      "balance" : 0,
      "createTime" : "string",
      "identity" : "string",
      "password" : "string",
      "salt" : "string",
      "tel" : "string",
      "uid" : 0,
      "username" : "string"
    }
  },
  "message" : "string"
}
```


<a name="updatebillusingput"></a>
#### 结束租贷
```
PUT /api/v1/bills
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**billId**  <br>*必填*|账单id|[Long](#long)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/bills
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="getbilllistusingget"></a>
#### 获取账单列表
```
GET /api/v1/bills/list
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**pageIndex**  <br>*可选*|页码|[Integer](#integer)|
|**Body**|**pageSize**  <br>*可选*|页尺寸|[Integer](#integer)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«List«账单信息构造类»»](#781317d73c9b34fa675124ee51acb795)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/bills/list
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : [ {
    "billId" : 0,
    "billState" : "string",
    "car" : {
      "cid" : 0,
      "createTime" : "string",
      "license" : {
        "brand" : "string",
        "lid" : 0,
        "region" : "string"
      },
      "number" : "string",
      "price" : 0,
      "state" : "string"
    },
    "cost" : 0,
    "endTime" : "string",
    "startTime" : "string",
    "user" : {
      "balance" : 0,
      "createTime" : "string",
      "identity" : "string",
      "password" : "string",
      "salt" : "string",
      "tel" : "string",
      "uid" : 0,
      "username" : "string"
    }
  } ],
  "message" : "string"
}
```


<a name="paybillusingput"></a>
#### 支付账单
```
PUT /api/v1/bills/pay
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**billId**  <br>*必填*|账单id|[Long](#long)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/bills/pay
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="getunfinishedbillusingget"></a>
#### 获取未完成订单信息
```
GET /api/v1/bills/unfinished
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«账单信息构造类»](#bd24d8ef62fa01f42c74364a830b9a30)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/bills/unfinished
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : {
    "billId" : 0,
    "billState" : "string",
    "car" : {
      "cid" : 0,
      "createTime" : "string",
      "license" : {
        "brand" : "string",
        "lid" : 0,
        "region" : "string"
      },
      "number" : "string",
      "price" : 0,
      "state" : "string"
    },
    "cost" : 0,
    "endTime" : "string",
    "startTime" : "string",
    "user" : {
      "balance" : 0,
      "createTime" : "string",
      "identity" : "string",
      "password" : "string",
      "salt" : "string",
      "tel" : "string",
      "uid" : 0,
      "username" : "string"
    }
  },
  "message" : "string"
}
```


<a name="e01e2f0e04f2177266b031b6cf063891"></a>
### 安全相关
Security Controller


<a name="loginbytelandpasswordusingpost"></a>
#### 通过手机和密码登录
```
POST /api/v1/security/login/tel
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**password**  <br>*必填*|密码|[String](#string)|
|**Body**|**tel**  <br>*必填*|手机号|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«boolean»](#fbf6d82a552e5b54e6117423f6801f0e)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/security/login/tel
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : false,
  "message" : "string"
}
```


<a name="logoffbytelandpasswordusingpost"></a>
#### 通过手机和密码注销
```
POST /api/v1/security/logoff/tel
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**password**  <br>*必填*|密码|[String](#string)|
|**Body**|**tel**  <br>*必填*|手机号|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/security/logoff/tel
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="logoutusingpost"></a>
#### 登出
```
POST /api/v1/security/logout
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/security/logout
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="registerbytelandpasswordusingpost"></a>
#### 通过手机号和密码进行注册
```
POST /api/v1/security/register/tel
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**password**  <br>*必填*|密码|[String](#string)|
|**Body**|**tel**  <br>*必填*|手机号|[String](#string)|
|**Body**|**username**  <br>*必填*|用户名|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/security/register/tel
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="60dde0f49f7ce039b17e49eae5687c9e"></a>
### 用户信息
User Controller


<a name="updatepasswordusingput"></a>
#### 更改密码
```
PUT /api/v1/users/password
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**newPass**  <br>*必填*|新密码|[String](#string)|
|**Body**|**oldPass**  <br>*必填*|旧密码|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/users/password
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="getprofileusingget"></a>
#### 获取个人信息
```
GET /api/v1/users/profile
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«用户信息构造类»](#d2775f6254700e80f137ac940bd1ff4f)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/users/profile
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : {
    "balance" : 0,
    "createTime" : "string",
    "identity" : "string",
    "tel" : "string",
    "uid" : 0,
    "username" : "string"
  },
  "message" : "string"
}
```


<a name="rechargeusingput"></a>
#### 充值
```
PUT /api/v1/users/recharge
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**money**  <br>*必填*|金额|[Long](#long)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/users/recharge
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="updateusernameusingput"></a>
#### 更改用户名
```
PUT /api/v1/users/username
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**username**  <br>*必填*|用户名|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/users/username
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="1b179c9abbec782bc336c39b4e1bdb52"></a>
### 车辆管理
Car Controller


<a name="getcarusingget"></a>
#### 获取车辆信息
```
GET /api/v1/cars
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**cid**  <br>*必填*|车辆id|[Long](#long)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«车辆信息构造类»](#cb47b5e1ec320e3c6f62e964385aca73)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/cars
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : {
    "cid" : 0,
    "createTime" : "string",
    "license" : {
      "brand" : "string",
      "lid" : 0,
      "region" : "string"
    },
    "number" : "string",
    "price" : 0,
    "state" : "string"
  },
  "message" : "string"
}
```


<a name="addcarusingpost"></a>
#### 添加车辆
```
POST /api/v1/cars/admin
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**lid**  <br>*必填*|车牌区号ID|[Integer](#integer)|
|**Body**|**number**  <br>*必填*|车牌号|[String](#string)|
|**Body**|**price**  <br>*必填*|单价|[Long](#long)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«long»](#b80decf382577a5a0531282446a5a6b8)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/cars/admin
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : 0,
  "message" : "string"
}
```


<a name="updatepriceusingput"></a>
#### 更新车辆信息
```
PUT /api/v1/cars/admin
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**cid**  <br>*必填*|车辆id|[Long](#long)|
|**Body**|**lid**  <br>*必填*|车牌区号ID|[Integer](#integer)|
|**Body**|**number**  <br>*必填*|车牌号|[String](#string)|
|**Body**|**price**  <br>*必填*|价格|[Long](#long)|
|**Body**|**state**  <br>*必填*|车辆状态|[String](#string)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/cars/admin
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="deletecarusingdelete"></a>
#### 删除车辆
```
DELETE /api/v1/cars/admin
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**cid**  <br>*必填*|车辆id|[Long](#long)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«object»](#df580c20e80ec85f87a1879ed07e557f)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/cars/admin
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "message" : "string"
}
```


<a name="getlicensesusingget"></a>
#### 获取区号列表
```
GET /api/v1/cars/licenses
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«List«License»»](#c3a4fa62e1e9ccf02d2439439c575e27)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/cars/licenses
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : [ {
    "brand" : "string",
    "lid" : 0,
    "region" : "string"
  } ],
  "message" : "string"
}
```


<a name="getcarlistusingget"></a>
#### 获取车辆列表
```
GET /api/v1/cars/list
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**pageIndex**  <br>*可选*|页码|[Integer](#integer)|
|**Body**|**pageSize**  <br>*可选*|页尺寸|[Integer](#integer)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«List«车辆信息构造类»»](#59eee59e4bebc9fbf466174b2a24fb2d)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/cars/list
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : [ {
    "cid" : 0,
    "createTime" : "string",
    "license" : {
      "brand" : "string",
      "lid" : 0,
      "region" : "string"
    },
    "number" : "string",
    "price" : 0,
    "state" : "string"
  } ],
  "message" : "string"
}
```


<a name="getstatesusingget"></a>
#### 获取车辆状态列表
```
GET /api/v1/cars/states
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«List«string»»](#572c5730c015cc9a743a8b9141c1f45d)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/api/v1/cars/states
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : [ "string" ],
  "message" : "string"
}
```




<a name="definitions"></a>
## 定义

<a name="car"></a>
### Car

|名称|说明|类型|
|---|---|---|
|**cid**  <br>*可选*|**样例** : `0`|integer (int64)|
|**createTime**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**license**  <br>*可选*|**样例** : `"[license](#license)"`|[License](#license)|
|**number**  <br>*可选*|**样例** : `"string"`|string|
|**price**  <br>*可选*|**样例** : `0`|integer (int64)|
|**state**  <br>*可选*|**样例** : `"string"`|string|


<a name="license"></a>
### License

|名称|说明|类型|
|---|---|---|
|**brand**  <br>*可选*|**样例** : `"string"`|string|
|**lid**  <br>*可选*|**样例** : `0`|integer (int32)|
|**region**  <br>*可选*|**样例** : `"string"`|string|


<a name="user"></a>
### User

|名称|说明|类型|
|---|---|---|
|**balance**  <br>*可选*|**样例** : `0`|integer (int64)|
|**createTime**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**identity**  <br>*可选*|**样例** : `"string"`|string|
|**password**  <br>*可选*|**样例** : `"string"`|string|
|**salt**  <br>*可选*|**样例** : `"string"`|string|
|**tel**  <br>*可选*|**样例** : `"string"`|string|
|**uid**  <br>*可选*|**样例** : `0`|integer (int64)|
|**username**  <br>*可选*|**样例** : `"string"`|string|


<a name="cd25c2d2e32f946af4456cf281a66a54"></a>
### 用户信息构造类

|名称|说明|类型|
|---|---|---|
|**balance**  <br>*可选*|用户余额  <br>**样例** : `0`|integer (int64)|
|**createTime**  <br>*可选*|用户注册时间  <br>**样例** : `"string"`|string (date-time)|
|**identity**  <br>*可选*|用户状态  <br>**样例** : `"string"`|string|
|**tel**  <br>*可选*|11位电话号码  <br>**样例** : `"string"`|string|
|**uid**  <br>*可选*|用户id  <br>**样例** : `0`|integer (int64)|
|**username**  <br>*可选*|用户名(2-16位英文字母及数字)  <br>**样例** : `"string"`|string|


<a name="a0fc378e12a63b55e0c8efbc17f7c8d9"></a>
### 账单信息构造类

|名称|说明|类型|
|---|---|---|
|**billId**  <br>*可选*|账单id  <br>**样例** : `0`|integer (int64)|
|**billState**  <br>*可选*|账单状态  <br>**样例** : `"string"`|string|
|**car**  <br>*可选*|账单关联车辆  <br>**样例** : `"[car](#car)"`|[Car](#car)|
|**cost**  <br>*可选*|账单价格  <br>**样例** : `0`|integer (int64)|
|**endTime**  <br>*可选*|交易结束时间  <br>**样例** : `"string"`|string (date-time)|
|**startTime**  <br>*可选*|交易起始时间  <br>**样例** : `"string"`|string (date-time)|
|**user**  <br>*可选*|账单关联用户  <br>**样例** : `"[user](#user)"`|[User](#user)|


<a name="632bdc41786a16f54ae345210d828dcd"></a>
### 车辆信息构造类

|名称|说明|类型|
|---|---|---|
|**cid**  <br>*可选*|车辆id  <br>**样例** : `0`|integer (int64)|
|**createTime**  <br>*可选*|车辆注册时间  <br>**样例** : `"string"`|string (date-time)|
|**license**  <br>*可选*|车牌区号信息  <br>**样例** : `"[license](#license)"`|[License](#license)|
|**number**  <br>*可选*|车牌号  <br>**样例** : `"string"`|string|
|**price**  <br>*可选*|车辆基础价格  <br>**样例** : `0`|integer (int64)|
|**state**  <br>*可选*|车辆状态  <br>**样例** : `"string"`|string|


<a name="c3a4fa62e1e9ccf02d2439439c575e27"></a>
### 通用响应数据构造类«List«License»»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `[ "[license](#license)" ]`|< [License](#license) > array|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="572c5730c015cc9a743a8b9141c1f45d"></a>
### 通用响应数据构造类«List«string»»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `[ "string" ]`|< string > array|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="781317d73c9b34fa675124ee51acb795"></a>
### 通用响应数据构造类«List«账单信息构造类»»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `[ "[a0fc378e12a63b55e0c8efbc17f7c8d9](#a0fc378e12a63b55e0c8efbc17f7c8d9)" ]`|< [账单信息构造类](#a0fc378e12a63b55e0c8efbc17f7c8d9) > array|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="59eee59e4bebc9fbf466174b2a24fb2d"></a>
### 通用响应数据构造类«List«车辆信息构造类»»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `[ "[632bdc41786a16f54ae345210d828dcd](#632bdc41786a16f54ae345210d828dcd)" ]`|< [车辆信息构造类](#632bdc41786a16f54ae345210d828dcd) > array|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="fbf6d82a552e5b54e6117423f6801f0e"></a>
### 通用响应数据构造类«boolean»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `false`|boolean|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="b80decf382577a5a0531282446a5a6b8"></a>
### 通用响应数据构造类«long»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `0`|integer (int64)|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="df580c20e80ec85f87a1879ed07e557f"></a>
### 通用响应数据构造类«object»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `"object"`|object|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="d2775f6254700e80f137ac940bd1ff4f"></a>
### 通用响应数据构造类«用户信息构造类»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `"[cd25c2d2e32f946af4456cf281a66a54](#cd25c2d2e32f946af4456cf281a66a54)"`|[用户信息构造类](#cd25c2d2e32f946af4456cf281a66a54)|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="bd24d8ef62fa01f42c74364a830b9a30"></a>
### 通用响应数据构造类«账单信息构造类»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `"[a0fc378e12a63b55e0c8efbc17f7c8d9](#a0fc378e12a63b55e0c8efbc17f7c8d9)"`|[账单信息构造类](#a0fc378e12a63b55e0c8efbc17f7c8d9)|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|


<a name="cb47b5e1ec320e3c6f62e964385aca73"></a>
### 通用响应数据构造类«车辆信息构造类»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|请求响应状态码  <br>**样例** : `0`|integer (int64)|
|**data**  <br>*可选*|请求结果数据  <br>**样例** : `"[632bdc41786a16f54ae345210d828dcd](#632bdc41786a16f54ae345210d828dcd)"`|[车辆信息构造类](#632bdc41786a16f54ae345210d828dcd)|
|**message**  <br>*可选*|请求结果描述信息  <br>**样例** : `"string"`|string|





