$(function(){
    // 返回车辆列表Url
    let toCarListUrl = '/views/admin/toCarList';
    // 添加车辆api接口Url
    let carAddUrl = '/api/v1/cars';
    // 车辆详情页
    let toCarDetailUrl = '/views/admin/toCarDetail?cid=';
    // 区号列表api接口Url
    let licensesUrl = '/api/v1/cars/licenses';
    init();

    function init() {
        $.getJSON(licensesUrl, function (data) {
            if (data.code == 200) {
                let licenseHtml = '';
                data.data.map(function (item, index) {
                    licenseHtml += '<option data-id="' + item.lid + '">' + item.brand + '</option>';
                });
                $('#lid').html(licenseHtml);
            } else {
                failHandle(data.code);
            }
        });
    }

    //id=back组件点击事件
    $('#back').click(function(){
        window.location.href = toCarListUrl;
    });

    $('#submit').click(function(){
        $.ajax({
            async : false,
            url : carAddUrl,
            type : 'POST',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                'lid' : $('#lid').find('option').not(function() { return !this.selected; }).data('id'),
                'number' : $('#number').val(),
                'price' : dollarToCent($('#price').val()),
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.alert('添加成功!', function () {
                        window.location.href = toCarDetailUrl + data.data;
                    });
                } else {
                    failHandle(data.code);
                }
            }
        });
    });
});
