let toIndexUrl = '/views/user/toIndex';
let toOrdersUrl = '/views/user/toOrders';
let toProfileUrl = '/views/user/toProfile';
let logoutUrl = '/api/v1/security/logout';

pageSwitch = function(url) {
    window.location.href = url;
}

toIndexPage = function () {
    pageSwitch(toIndexUrl);
}

toOrdersPage = function () {
    pageSwitch(toOrdersUrl);
}

toProfilePage = function () {
    pageSwitch(toProfileUrl);
}

logout = function() {
    $.ajax({
        async : false,
        url : logoutUrl,
        type : 'POST',
        contentType : false,
        success : function (data) {
            if (data.code == 200) {
                window.location.reload();
            } else {
                failHandle(data.code);
            }
        }
    });
}