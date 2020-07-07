$(function () {
    // 用户操作api地址
    let userUrl = "/api/v1/users";
    // 获取用户状态api地址
    let userProfileUrl = "/api/v1/users/profile";
    init();

    function init() {
        $.getJSON(userProfileUrl, function(data) {
            if (data.code == 200) {
                $('#uid').val(data.data.uid);
                $('#username').val(data.data.username);
                $('#tel').val(data.data.tel);
            }
        });
    }
});