$(function(){
    //返回车辆列表Url
    var toCarListUrl = "/views/admin/toCarList";
    //添加车辆api接口Url
    var addUrl = "/api/v1/cars";
    // 车辆详情页
    var toCarDetailUrl = "/views/admin/toCarDetail?cid=";

    //id=back组件点击事件
    $('#back').click(function(){
        window.location.href = toCarListUrl;
    });

    $('#submit').click(function(){
        $.ajax({
            async : false,
            url : addUrl,
            type : 'POST',
            contentType : 'application/x-www-form-urlencoded',
            data : ({
                "price" : $('#price').val(),
            }),
            success : function (data) {
                if (data.code == 200) {
                    $.toast('添加成功!');
                    window.location.href = toCarDetailUrl + data.data;
                } else {
                    $.toast(data.code + " : " + data.message);
                }
            }
        });
    });
});
