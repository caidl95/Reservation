

$(function () {

    var dateS = GetQueryString("dateS");
    var dateE = GetQueryString("dateE");
    document.getElementById("input-ss").value=dateS;
    document.getElementById("input-s").value=dateE;

    getResDtl();

})

function getResDtl() {
    $.ajax({
        "url": "/indexPage/resDtl",
        "data": $("#form-input").serialize(),
        "type": "GET",
        "dataType": "json",
        "success": function (json) {
            if (json.status == 200) {
                getDataList(json.data);
            }
        },
        "error": function () {//所有3字头4字头5字头的回应都会被捕获例如：302；404；405；500等
            location.href = "../err/500.html";
        }
    });
}


function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

var jsonData = [];
function getDataList(list) {
    //获取JSON数据
    var dataArray = eval(list);

    if (dataArray == null)
        return null;
    jsonData = dataArray;
    //加载数据
    var pageSize = 16;
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
    getResDtl();

}
//加载表格
function pageTo(pageSize, curPage) {
    //调用时清空原来内容
    $("#appointment-list").empty();

    //构建目录
    var html = " <table style= \"font-size: 20px\" style= \"margin : 45px\" border=\"solid\"  width=\"100%\"  cellspacing=\"0\" cellpadding=\"10\" frame=\"solid\" rules=\"solid\" >" +
        "<tbody align=\"center\" valign=\"center\">" +
        "<tr id=\"xs-mx-ml\" class='xs-mx-m1' align=\"center\" valign=\"center\" >" +
        "<td  style=\"width: 12.3%\">日期</td>" +
        "<td style=\"width: 12.3%\">姓名</td>" +
        "<td style=\"width: 12.3%\">年龄</td>" +
        "<td style=\"width: 12.3%\">性别</td>" +
        "<td style=\"width: 12.3%\">电话</td>" +
        "<td style=\"width: 12.3%\">状态</td>" +
        "<td style=\"width: 12.3%\">项目</td>" +
        "<td style=\"width: 12.3%\">操作</td>" +
        "</tr>";

    //获取当前页数
    var dataSize = jsonData.length;
    var totalPage = Math.ceil(dataSize / pageSize);
    //table
    var datas = query(curPage, pageSize);
    for (var index = 0; index < datas.length; index++) {
        var data = datas[index];
        var num = index%2 == 0? 2:1;
        var classs = "xs-mx-m" + num;

        html += "<tr  class="+classs+" id='xs-mx-m1'  align=\"center\" valign=\"center\" >";
        html += "<td style=\"width: 12.3%\">#{resDate}</td>";
        html += "<td style=\"width: 12.3%\">#{name}</td>";
        html += "<td style=\"width: 12.3%\">#{age}</td>";
        html += "<td style=\"width: 12.3%\">#{sex}</td>";
        html += "<td style=\"width: 12.3%\">#{phone}</td>";
        html += "<td style=\"width: 12.3%\">#{status}</td>"
        html += "<td style=\"width: 12.3%\">#{combinItemName}</td>"
        html += "<td style=\"width: 12.3%\"><button STYLE='margin: 1px 0 1px 0' type=\"button\" onclick=\"condition_delete(#{id})\">删除</button>&nbsp;<button type=\"button\" onclick=\"condition_update_info(#{id})\">修改</button></tr>";

        html = html.replace(/#{id}/g, data.id);
        html = html.replace(/#{resDate}/g, data.resDate);
        html = html.replace(/#{name}/g, data.name);
        html = html.replace(/#{age}/g, data.age);
        html = html.replace(/#{sex}/g, data.sex);
        html = html.replace(/#{phone}/g, data.phone);
        html = html.replace(/#{status}/g, data.status);
        html = html.replace(/#{combinItemName}/g, data.combinItemName);

    }
    html +=  "</tbody> </table>";
    $("#appointment-list").append(html);





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


function condition_update_info(id) {
    var state =$("#update-yy").css("display")=="none"?"block":"none";
    $("#update-yy").css("display",state);

    var isNone =$("#update-yy").css("display")=="none"?false:true;
    if (isNone) {
        $("#updateDetailsId").attr("value", "");
        $("#updateDate").attr("value", "");
        $("#updateName").attr("value", "");
        $("#updateAge").attr("value", "");
        $("#updateSex").attr("value", "");
        $("#updateSeq").attr("value", "");
        $("#updateStatus").attr("value", "");
        $("#updateProject").attr("value", "");
        $("#updateRemark").val("");

        $.ajax({
            "url": "/indexPage/resDtl?ID="+id,
            "type": "GET",
            "dataType": "json",
            "success": function (json) {
                if (json.status == 200) {
                    console.log(json.data);
                    var datasArray = eval(json.data);
                    $("#updateDetailsId").attr("value", datasArray[0].id);
                    $("#updateDate").attr("value", datasArray[0].resDate);
                    $("#updateName").attr("value", datasArray[0].name);
                    $("#updateAge").attr("value", datasArray[0].age);
                    $("#updateSex").attr("value", datasArray[0].sex);
                    $("#updateSeq").attr("value", datasArray[0].phone);
                    $("#updateStatus").attr("value", datasArray[0].status);
                    $("#updateProject").attr("value", datasArray[0].combinItemName);
                    $("#updateRemark").val(datasArray[0].description);
                }
            }
        });
    }
}
function condition_update(){

    $.ajax({
        "url": "/indexPage/resUpdate",
        "data": $("#deptFormUpdate").serialize(),
        "type": "POST",
        "dataType": "json",
        "success": function (json) {
            if (json.status == 200) {
                $.dialog({
                    autoClose: 2500,
                    contentHtml: "<p style=\"text-align:center;\">" + json.data + "</p>"
                });
                condition_update_info();
                getResDtl();
            } else {
                $.dialog({
                    autoClose: 2500,
                    contentHtml: "<p style=\"text-align:center;\">" + json.msg + "</p>"
                });
            }
        }

    });
}

function condition_delete(id) {
    $.ajax({
        "url": "/indexPage/resDelete?id="+id,
        "type": "GET",
        "dataType": "json",
        "success": function (json) {
            if (json.status == 200) {
                $.dialog({
                    autoClose: 2500,
                    contentHtml: "<p style=\"text-align:center;\">" + json.data + "</p>"
                });
                getResDtl();
            } else {
                $.dialog({
                    autoClose: 2500,
                    contentHtml: "<p style=\"text-align:center;\">" + json.msg + "</p>"
                });
            }
        },
        "error": function () {//所有3字头4字头5字头的回应都会被捕获例如：302；404；405；500等
            location.href = "../err/noAuth.html";
        }
    });


}


