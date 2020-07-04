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

* 业务相关 : Bill Controller
* 安全相关 : Security Controller
* 用户信息 : User Controller
* 车辆管理 : Car Controller




<a name="paths"></a>
## 资源

<a name="1101be8288349aafa3a5b7cf55b455b2"></a>
### 业务相关
Bill Controller


<a name="addbillusingpost"></a>
#### 租贷车辆
```
POST /api/v1/bills
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**cid**  <br>*必填*|cid|integer (int64)|


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


###### 请求 query
```
json :
{
  "cid" : 0
}
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


<a name="updatebillusingput"></a>
#### 结束租贷
```
PUT /api/v1/bills
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**cid**  <br>*必填*|cid|integer (int64)|


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


###### 请求 query
```
json :
{
  "cid" : 0
}
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


<a name="paybillusingput"></a>
#### 支付账单
```
PUT /api/v1/bills/pay
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**billId**  <br>*必填*|billId|integer (int64)|


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


###### 请求 query
```
json :
{
  "billId" : 0
}
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
|**Query**|**password**  <br>*必填*|password|string|
|**Query**|**tel**  <br>*必填*|tel|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«用户信息构造类»](#d2775f6254700e80f137ac940bd1ff4f)|
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


###### 请求 query
```
json :
{
  "password" : "string",
  "tel" : "string"
}
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


<a name="logoffbytelandpasswordusingpost"></a>
#### 通过手机和密码注销
```
POST /api/v1/security/logoff/tel
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**password**  <br>*必填*|password|string|
|**Query**|**tel**  <br>*必填*|tel|string|


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


###### 请求 query
```
json :
{
  "password" : "string",
  "tel" : "string"
}
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
|**Query**|**password**  <br>*必填*|password|string|
|**Query**|**tel**  <br>*必填*|tel|string|
|**Query**|**username**  <br>*必填*|username|string|


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


###### 请求 query
```
json :
{
  "password" : "string",
  "tel" : "string",
  "username" : "string"
}
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
|**Query**|**newPass**  <br>*必填*|newPass|string|
|**Query**|**oldPass**  <br>*必填*|oldPass|string|


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


###### 请求 query
```
json :
{
  "newPass" : "string",
  "oldPass" : "string"
}
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


<a name="rechargeusingput"></a>
#### 充值
```
PUT /api/v1/users/recharge
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**money**  <br>*必填*|money|integer (int32)|


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


###### 请求 query
```
json :
{
  "money" : 0
}
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
|**Query**|**username**  <br>*必填*|username|string|


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


###### 请求 query
```
json :
{
  "username" : "string"
}
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


<a name="addcarusingpost"></a>
#### 添加车辆
```
POST /api/v1/cars
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**price**  <br>*必填*|price|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[通用响应数据构造类«车辆信息构造类»](#cb47b5e1ec320e3c6f62e964385aca73)|
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
/api/v1/cars
```


###### 请求 query
```
json :
{
  "price" : 0
}
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
    "price" : 0,
    "state" : "string"
  },
  "message" : "string"
}
```


<a name="getcarusingget"></a>
#### 获取车辆信息
```
GET /api/v1/cars
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**cid**  <br>*必填*|cid|integer (int64)|


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


###### 请求 query
```
json :
{
  "cid" : 0
}
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
    "price" : 0,
    "state" : "string"
  },
  "message" : "string"
}
```


<a name="deletecarusingdelete"></a>
#### 删除车辆
```
DELETE /api/v1/cars
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**cid**  <br>*必填*|cid|integer (int64)|


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
/api/v1/cars
```


###### 请求 query
```
json :
{
  "cid" : 0
}
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


<a name="updatepriceusingput"></a>
#### 更新车辆价格
```
PUT /api/v1/cars/price
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**cid**  <br>*必填*|cid|integer (int64)|
|**Query**|**price**  <br>*必填*|price|integer (int32)|


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
/api/v1/cars/price
```


###### 请求 query
```
json :
{
  "cid" : 0,
  "price" : 0
}
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


<a name="updatestateusingput"></a>
#### 更新车辆状态
```
PUT /api/v1/cars/state
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**cid**  <br>*必填*|cid|integer (int64)|
|**Query**|**state**  <br>*必填*|state|string|


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
/api/v1/cars/state
```


###### 请求 query
```
json :
{
  "cid" : 0,
  "state" : "string"
}
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




<a name="definitions"></a>
## 定义

<a name="car"></a>
### Car

|名称|说明|类型|
|---|---|---|
|**cid**  <br>*可选*|**样例** : `0`|integer (int64)|
|**createTime**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**price**  <br>*可选*|**样例** : `0`|integer (int32)|
|**state**  <br>*可选*|**样例** : `"string"`|string|


<a name="user"></a>
### User

|名称|说明|类型|
|---|---|---|
|**balance**  <br>*可选*|**样例** : `0`|integer (int32)|
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
|**balance**  <br>*可选*|用户余额  <br>**样例** : `0`|integer (int32)|
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
|**cost**  <br>*可选*|账单价格  <br>**样例** : `0`|integer (int32)|
|**endTime**  <br>*可选*|交易结束时间  <br>**样例** : `"string"`|string (date-time)|
|**startTime**  <br>*可选*|交易起始时间  <br>**样例** : `"string"`|string (date-time)|
|**user**  <br>*可选*|账单关联用户  <br>**样例** : `"[user](#user)"`|[User](#user)|


<a name="632bdc41786a16f54ae345210d828dcd"></a>
### 车辆信息构造类

|名称|说明|类型|
|---|---|---|
|**cid**  <br>*可选*|车辆id  <br>**样例** : `0`|integer (int64)|
|**createTime**  <br>*可选*|车辆注册时间  <br>**样例** : `"string"`|string (date-time)|
|**price**  <br>*可选*|车辆基础价格  <br>**样例** : `0`|integer (int32)|
|**state**  <br>*可选*|车辆状态  <br>**样例** : `"string"`|string|


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





