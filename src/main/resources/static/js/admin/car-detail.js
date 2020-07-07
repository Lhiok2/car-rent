$(function () {
    // 车辆列表界面地址
    let toAdminIndexUrl = "/views/admin/toCarList";
    // 车辆操作api地址
    let carUrl = "/api/v1/cars";
    // 车辆更新api地址
    let carUpdateUrl = "/api/v1/cars/admin";
    // 获取车辆状态api地址
    let carStateUrl = "/api/v1/cars/states";
    // 区号列表api接口Url
    let licensesUrl = '/api/v1/cars/licenses';
    init();

    function init() {
        let getCarInfoUrl = carUrl + "?cid=" + getQueryString('cid');
        $.getJSON(getCarInfoUrl, function(data) {
            if (data.code == 200) {
                $('#cid').val(data.data.cid);
                $('#number').val(data.data.number);
                $('#price').val(centToDollar(data.data.price));
                $('#create-time').val(data.data.createTime);
                let lid = data.data.license.lid;
                let state = data.data.state;
                $.getJSON(licensesUrl, function (data) {
                    if (data.code == 200) {
                        let licenseHtml = '';
                        data.data.map(function (item, index) {
                            licenseHtml += '<option data-id="' + item.lid + '"'
                                + (item.lid == lid? 'selected': '')
                                + '>' + item.brand + '</option>';
                        });
                        $('#lid').html(licenseHtml);
                        $.getJSON(carStateUrl, function (data) {
                            if (data.code == 200) {
                                let stateHtml = '';
                                data.data.map(function (item, index) {
                                    stateHtml += '<option data-id="' + item + '" '
                                        + (item == state? 'selected': '')
                                        + ' >' + stateMess(item) + '</option>';
                                });
                                $('#state').html(stateHtml);
                            } else {
                                failHandle(data.code);
                            }
                        });
                    } else {
                        failHandle(data.code);
                    }
                });
            } else {
                failHandle(data.code);
            }
        });
    }

    $('#back').click(function () {
        window.location.href = toAdminIndexUrl;
    });

    $('#submit').click(function () {
        $.ajax({
            async : false,
            url : carUpdateUrl,
            type : 'PUT',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                'cid' : $('#cid').val(),
                'lid' : $('#lid').find('option').not(function () { return !this.selected; }).data('id'),
                'number' : $('#number').val(),
                'price' : dollarToCent($('#price').val()),
                'state' : $('#state').find('option').not(function() { return !this.selected; }).data('id')
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