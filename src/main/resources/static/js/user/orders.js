$(function () {
    let pageIndex;
    let pageSize;
    let getBillListUrl = '/api/v1/bills/list';
    let billOperatorUrl = '/api/v1/bills';
    let billPayUrl = '/api/v1/bills/pay';
    init();

    function init() {
        pageIndex = 1;
        pageSize = 999;
        getList();
    }

    function getList() {
        $.ajax({
            async : false,
            url : getBillListUrl,
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
            let td6 = document.createElement('td');
            td1.innerHTML = item.billId;
            td2.innerHTML = item.car.license.brand + '*' + item.car.number;
            td3.innerHTML = (item.cost == null? '': centToDollar(item.cost));
            td4.innerHTML = item.startTime;
            td5.innerHTML = (item.endTime == null? '': item.endTime);
            switch (item.billState) {
                case 'Trading' :
                    td6.innerHTML = '<a href="#" onclick="updateBill(' + item.billId + ')">还车</a>';
                    break;
                case 'Unpaid' :
                    td6.innerHTML = '<a href="#" onclick="payBill(' + item.billId + ')">去支付</a>';
                    break;
                case 'Paid' :
                    td6.innerHTML = '<a style="color: #7d7d7d" href="#" onclick="payBill(' + item.billId + ')">已支付</a>';
                    break;
                default :
                    td6.innerHTML = '';
                    break;
            }
            tr.appendChild(td1);
            tr.appendChild(td2);
            tr.appendChild(td3);
            tr.appendChild(td4);
            tr.appendChild(td5);
            tr.appendChild(td6);
        });
    }

    let operatorHtml = function(billId, billSate) {
        switch (billSate) {
            case 'Trading' :
                return '<a href="#" onclick="updateBill(' + billId + ')">还车</a>';
            case 'Unpaid' :
                return '<a href="#" onclick="payBill(' + billId + ')">去支付</a>';
            case 'Paid' :
                return '<a style="color: #7d7d7d" href="#" onclick="payBill(' + billId + ')">已支付</a>';
            default :
        }
    }

    updateBill = function(billId) {
        $.ajax({
            async : false,
            url : billOperatorUrl,
            type : 'PUT',
            contentType : 'application/x-www-form-urlencoded',
            //或者contentType : 'application/json',
            dataType:'json',
            data : ({
                'billId' : billId,
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('还车成功', function () {
                        window.location.reload();
                    });
                } else {
                    failHandle(data.code);
                }
            }
        });
    }

    payBill = function(billId) {
        $.ajax({
            async : false,
            url : billPayUrl,
            type : 'PUT',
            contentType : 'application/x-www-form-urlencoded',
            //或者contentType : 'application/json',
            dataType:'json',
            data : ({
                'billId' : billId,
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('支付成功', function () {
                        window.location.reload();
                    });
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
});