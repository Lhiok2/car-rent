$(function () {
    let pageIndex;
    let pageSize;
    let getCarListUrl = '/api/v1/cars/list';
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
            let td5 = document.createElement('td');
            td1.innerHTML = item.cid;
            td2.innerHTML = item.license.brand + '*' + item.number;
            td3.innerHTML = centToDollar(item.price);
            td4.innerHTML = stateMess(item.state);
            td5.innerHTML = '<a href="/views/admin/toCarDetail?cid=' + item.cid + '">详情</a>';
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);
        });
    }
});