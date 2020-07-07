$(function () {
    // 车辆列表界面地址
    let toAdminIndexUrl = "/views/admin/toCarList";
    // 车辆操作api地址
    let carUrl = "/api/v1/cars";
    // 获取车辆状态api地址
    let carStateUrl = "/api/v1/cars/states";
    init();

    function init() {
        let getCarInfoUrl = carUrl + "?cid=" + getQueryString('cid');
        $.getJSON(getCarInfoUrl, function(data) {
            if (data.code == 200) {
                $('#cid').val(data.data.cid);
                $('#price').val(data.data.price);
                $('#create-time').val(data.data.createTime);
                let state = data.data.state;
                $.getJSON(carStateUrl, function (data) {
                    if (data.code == 200) {
                        let stateHtml = '';
                        data.data.map(function (item, index) {
                            stateHtml += '<option data-id="' + item + '" '
                                + (item == state? 'selected': '')
                                + ' >' + item + '</option>';
                        });
                        $('#state').html(stateHtml);
                    } else {
                        failHandle(data.code);
                    }
                });
            }
        });
    }

    $('#back').click(function () {
        window.location.href = toAdminIndexUrl;
    });

    $('#submit').click(function () {
        $.ajax({
            async : false,
            url : carUrl,
            type : 'PUT',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                "cid" : $('#cid').val(),
                "price" : $('#price').val(),
                "state" : $('#state').find('option').not(function() { return !this.selected; }).data('id')
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('更新成功!', function () {
                        window.location.reload();
                    });
                } else {
                    failHandle(data.code);
                }
            }
        });
    });
});