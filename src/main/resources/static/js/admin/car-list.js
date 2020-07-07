$(function () {
    let pageIndex;
    let pageSize;
    let getCarListUrl = '/api/v1/cars/list';
    let logoutUrl = '/api/v1/security/logout';
    init();

    function init() {
        pageIndex = 1;
        pageSize = 999;
        getList();
    }

    function getList() {
        $.ajax({
            async : false,
            url : getCarListUrl,
            type : 'GET',
            contentType : 'application/x-www-form-urlencoded',
            //或者contentType : 'application/json',
            dataType:'json',
            data : ({
                'pageIndex' : pageIndex,
                'pageSize' : pageSize
            }),
            success : function (data) {
                if (data.code == 200) {
                    handleList(data.data);
                } else {
                    failHandle(data.code);
                }
            }
        });
    }

    function handleList(data) {
        let tbody = document.querySelector('tbody');
        data.map(function (item, index) {
            let tr = document.createElement('tr');
            tbody.appendChild(tr);
            let td1 = document.createElement('td');
            let td2 = document.createElement('td');
            let td3 = document.createElement('td');
            let td4 = document.createElement('td');
            td1.innerHTML = item.cid;
            td2.innerHTML = centToDollar(item.price);
            td3.innerHTML = stateMess(item.state);
            td4.innerHTML = '<a href="/views/admin/toCarDetail?cid=' + item.cid + '">详情</a>';
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
        });
    }

    $('#logout').click(function () {
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
    });
});