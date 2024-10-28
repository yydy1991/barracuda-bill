(function ($) {
    $.extend({
        BA: {
            ajax: {
                // 提交数据
                submit: function (url, type, dataType, data) {
                    let r = undefined;
                    let config = {
                        url: url,
                        type: type,
                        dataType: dataType,
                        async: false,
                        data: data,
                        success: function (result) {
                            r = result.data;
                        }
                    };
                    $.ajax(config)
                    return r;
                },
                get: function (url, data) {
                    return this.submit(url, "get", "json", data);
                },
            }
        }
    })
})(jQuery);