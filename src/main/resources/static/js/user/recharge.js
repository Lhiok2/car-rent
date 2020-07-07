$(function(){
    // 获取用户状态api地址
    let userProfileUrl = "/api/v1/users/profile";
    //
    let rechargeUrl = '/api/v1/users/recharge';
    init();

    function init() {
        $.getJSON(userProfileUrl, function(data) {
            if (data.code == 200) {
                $('#balance').val(centToDollar(data.data.balance));
            } else {
                failHandle(data.code);
            }
        });
    }

    //id=bal的组件点击事件（充值按钮）
    $('#bal').click(function () {
        $.ajax({
            async : false,
            url : rechargeUrl,
            type : 'PUT',
            contentType : 'application/x-www-form-urlencoded',
            data:({
              'money' : dollarToCent($('#money').val()),
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('充值成功!', function () {
                        window.location.reload();
                    });
                } else {
                    failHandle(data.code);
                }
            }
        })
    });
});