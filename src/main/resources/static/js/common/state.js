let stateMess = function (state) {
    switch (state) {
        case 'Normal':
            return '正常';
        case 'Used':
            return '使用中';
        case 'Malfunction':
            return '待维修';
        default :
    }
}