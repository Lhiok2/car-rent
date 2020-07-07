let toIndexUrl = '/views/user/toIndex';
let toOrdersUrl = '/views/user/toOrders';
let toProfileUrl = '/views/user/toProfile';

let pageSwitch = function(url) {
    window.location.href = url;
}

let toIndexPage = function () {
    pageSwitch(toIndexUrl);
}

let toOrdersPage = function () {
    pageSwitch(toOrdersUrl);
}

let toProfilePage = function () {
    pageSwitch(toProfileUrl);
}