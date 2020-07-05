$(function(){
    //返回个人信息界面
    var toProfileUrl = "/views/user/toProfile";
    //添加用户名接口Url
    var userNameUrl = "/api/v1/users/username";
    //id=back组件点击事件
    $('#back').click(function(){
        window.location.href = toProfileUrl;
    })

    $('#yes').click(function(){
        $.ajax({
            async : false,
            url : userNameUrl,
            type : 'PUT',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                "username" : $('#username').val(),
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.toast('修改成功!');
                    window.location.href = toProfileUrl;
                } else {
                    $.toast(data.code + " : " + data.message);
                }
            }
        });
    });
});