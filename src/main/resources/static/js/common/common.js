function getQueryString(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    }
    return '';
}

function failHandle(code) {
    let message = '';
    let question = '';
    let url = '';
    switch (code) {
        case 401 :
            message = '身份过期，请重新登录';
            question = '去登陆？';
            url = '/views/security/toLogin';
            break;
        case 403 :
            message = '权限不足，拒绝访问';
            break;
        case 404 :
            message = '数据不存在，请核对你的信息';
            break;
        case 406 :
            message = '格式不符，请重新输入';
            break;
        case 4001 :
            message = '该车辆暂时不可用，请选择其他车辆';
            break;
        case 4002 :
            message = '您还有未完成的订单';
            question = '去完成？';
            url = '/views/user/toOrders';
            break;
        case 4003 :
            message = '余额不足，请充值';
            question = '去充值？';
            url = '/views/user/toRecharge';
            break;
        case 4004 :
            message = '用户不存在';
            question = '去注册？';
            url = '/views/security/toRegister';
            break;
        case 4005 :
            message = '密码错误';
            question = '去找回？';
            break;
        default :
            message = '服务器繁忙，请重试';
            break;
    }
    if (question.length == 0) {
        $.alert(message);
    } else {
        $.confirm(question, message,
            function () {
                if (url.length == 0) {
                    $.alert('该功能尚未实现，敬请期待');
                } else {
                    window.location.href = url;
                }
            },
            function () {
            }
        );
    }
}

// 金额 分->元
let centToDollar = function(value) {
    value /= 100;
    return value.toFixed(2);
}

// 金额 元->分
let dollarToCent = function(value) {
    return Math.ceil(value * 100);
}