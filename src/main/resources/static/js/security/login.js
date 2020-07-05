$(function () {
    // 注册页面url
    var toRegisterUrl = "/views/security/toRegister";
    // 用户首页url
    var toIndexUrl = "/views/user/toIndex";
    // 管理员首页url
    var toAdminIndexUrl = "/views/admin/toCarList";
    // 登录api接口url
    var loginUrl = "/api/v1/security/login/tel";

    $('#back').click(function () {
        window.location.href = toRegisterUrl;
    });

    $('#submit').click(function () {
        $.ajax({
            async : false,
            url : loginUrl,
            type : 'POST',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                "tel" : $('#tel').val(),
                "password" : $('#password').val()
            }),
            success : function (data) {
                if (data.code == 200) {
                    window.location.href = toIndexUrl;
                } else {
                    $.toast(data.code + " : " + data.message);
                }
            }
        });
    });
});