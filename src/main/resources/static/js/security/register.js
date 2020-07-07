$(function () {
    // 注册api接口url
    let registerUrl = "/api/v1/security/register/tel";

    $('#submit').click(function () {
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