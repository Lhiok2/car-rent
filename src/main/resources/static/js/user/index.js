$(function () {
    let pageIndex;
    let pageSize;
    let getCarListUrl = '/api/v1/cars/list';
    let carRentUrl = '/api/v1/bills';
    let toOrdersUrl = '/views/user/toOrders';
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

    carRent = function(cid) {
        $.ajax({
            async : false,
            url : carRentUrl,
            type : 'POST',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                "cid" : cid,
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('租车成功!', function () {
                        window.location.href = toOrdersUrl;
                    });
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
            td3.innerHTML = item.state;
            td4.innerHTML = '<a href="#" onclick="carRent(' + item.cid + ')">租贷</a>';
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
        });
    }
});