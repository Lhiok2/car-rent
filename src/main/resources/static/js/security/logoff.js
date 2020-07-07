$(function () {
    // 注销api接口url
    let logoffUrl = '/api/v1/security/logoff/tel';
    // 注册页面url
    let toLoginUrl = '/views/security/toLogin';

    $('#submit').click(function () {
        $.ajax({
            async : false,
            url : logoffUrl,
            type : 'POST',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                "tel" : $('#tel').val(),
                "password" : $('#password').val()
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('注销成功!', function () {
                        window.location.href = toLoginUrl;
                    });
                } else {
                    failHandle(data.code);
                }
            }
        });
    });
});