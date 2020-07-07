$(function () {
    // 登录页面url
    let toLoginUrl = "/views/security/toLogin";
    // 注册api接口url
    let registerUrl = "/api/v1/security/register/tel";

    // id=back的组件点击事件
    $('#back').click(function () {
        window.location.href = toLoginUrl;
    });

    $('#submit').click(function (message) {
        $.ajax({
            async : false,
            url : registerUrl,
            type : 'POST',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                "username" : $('#username').val(),
                "tel" : $('#tel').val(),
                "password" : $('#password').val()
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('注册成功!', function () {
                        window.location.href = toLoginUrl;
                    });
                } else {
                    failHandle(data.code);
                }
            }
        });
    });
});