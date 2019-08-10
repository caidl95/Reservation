


$(function () {
    $.ajax({
        "url": "/indexPage/index",
        "data": $("#form-input").serialize(),
        "type": "GET",
        "dataType": "json",
        "success": function (json) {
            if (json.status == 200) {
                getDataList(json.data);
            } else {
                location.href = "../err/noAuth.html";
            }
        },
        "error": function () {//所有3字头4字头5字头的回应都会被捕获例如：302；404；405；500等
            /*$.dialog({
                autoClose : 2500,
                contentHtml : '<p style="text-align:center;">您登录信息已经过期，请重新登录！</p>'
            });*/
            location.href = "../err/500.html";
        }
    });
})


//转换时间格式
function getDate(time) {
    var now = new Date(time),
        y = now.getFullYear(),
        m = now.getMonth() + 1,
        d = now.getDate();
    return y + "-" + (m < 10 ? "0" + m : m) + "-" + (d < 10 ? "0" + d : d) + " " + now.toTimeString().substr(0, 8);
}


var jsonData = [];
function getDataList(list) {
    //获取JSON数据
    var dataArray = eval(list);
    console.log("asd" + dataArray);
    jsonData = dataArray;
    //加载数据
    var pageSize = 24;
    var curPage = 1;
    pageTo(pageSize, curPage);
}
//获取当前页数据
function query(cur, size) {
    var begin = (cur - 1) * size;
    var end = cur * size;
    return jsonData.slice(begin, end);
}

//打开查询子页面
function condition_search(){
    //alert(111);
    window.open ("appointmentDtl.html", "newwindow", "height=500, width=1000, toolbar=no, top=100,left=200,menubar=no, scrollbars=no, resizable=no, location=no, status=no")
   /* var diag = new Dialog();
    diag.Width = 600;
    diag.Height = 300;
    diag.Title = "设定了高宽和标题的普通窗口";
    diag.URL = "javascript:void(document.write('这是弹出窗口中的内容'))";
    diag.show();*/
}

//加载表格
function pageTo(pageSize, curPage) {
    //调用时清空原来内容
    $("#appointment-bt").empty();
    $("#appointment-list").empty();

    //构建目录
    var html = '<div class="col-md-2">日期</div>'
        + ' <div class="col-md-2">总数</div>'
        + ' <div class="col-md-2">已约</div>'
        + ' <div class="col-md-2">未约</div>'
        + ' <div class="col-md-2">已到</div>'
        + ' <div class="col-md-2">未到</div>';
    //添加到目录
    $("#appointment-bt").append(html);

    //获取当前页数
    var dataSize = jsonData.length;
    var totalPage = Math.ceil(dataSize / pageSize);
    //table
    var datas = query(curPage, pageSize);
    for (var index = 0; index < datas.length; index++) {
        var data = datas[index];
        var date = getDate(data.date);
        var html = '<div class="col-md-2">#{date}</div>'
            + '<div class="col-md-2">#{count}</div>'
            + '<div class="col-md-2">#{reserved}</div>'
            + '<div class="col-md-2">#{unreserved}</div>'
            + '<div class="col-md-2">#{arrived}</div>'
            + '<div class="col-md-2" >#{unarrived}</div>';
        html = html.replace(/#{date}/g, data.date);
        html = html.replace(/#{count}/g, data.count);
        html = html.replace(/#{reserved}/g, data.reserved);
        html = html.replace(/#{unreserved}/g, data.unreserved);
        html = html.replace(/#{arrived}/g, data.arrived);
        html = html.replace(/#{unarrived}/g, data.unarrived);
        $("#appointment-list").append(html);
    }






    //pager
    var phtml = "<div class='pager'>";
    if (curPage == 1) {
        phtml = phtml + "<a href='#' class='button no-page'>上一页</a>";
    } else {
        phtml = phtml + "<a href='#' class='button' onclick='pageTo(" + pageSize + ", " + (curPage - 1) + ");'>上一页</a>";
    }
    phtml = phtml + "<input id='input-as' type='text' value='" + curPage + "' onkeypress='goto(this, " + pageSize + ");'>";
    if (curPage == totalPage) {
        phtml = phtml + "<a href='#' class='button no-page'>下一页</a>";
    } else {
        phtml = phtml + "<a href='#' class='button' onclick='pageTo(" + pageSize + ", " + (curPage + 1) + ");'>下一页</a>";
    }
    phtml = phtml + "&nbsp;共" + totalPage + "页," + dataSize + "条记录</div>";
    $("#appointment-and-input").empty();
    $("#appointment-and-input").append(phtml);
}





