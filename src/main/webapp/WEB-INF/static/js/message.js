$(function() {
    $("#message-link").click(function () {
        $.ajax({
            type: "get",
            url: "/user/message/list?date=20171111",
            success: function (data) {
                $(".content").html(data);
            }
        });
    });

    $("#message-en-link").click(function () {
        $.ajax({
            type: "get",
            url: "/user/message/list?langType=en&date=20171111",
            success: function (data) {
                $(".content").html(data);
            }
        });
    });

    $("#exception-link").click(function () {
        $.ajax({
            type: "get",
            url: "/user/message/list?langType=en&date=2017-11-11",
            success: function (data) {
                $(".content").html(data);
            }
        });
    });
});