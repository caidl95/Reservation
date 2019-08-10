
/* 显示个人信息 */
function condition_user() {
    var state =$("#add-yy").css("display")=="none"?"block":"none";
    $("#add-yy").css("display",state);
    var isNone =$("#add-yy").css("display")=="none"?false:true;
   if (isNone){
       $.ajax({//发出异步请求
           "url":"/users/get_user",
           "type":"GET",//type:提交方式
           "dataType":"json",//dataType:服务器端即将响应的数据类型，取值可以是json xml html,例如服务器端响应的可能是application/json,那么该属性值json
           "success":function(json){
               if(json.status==200){
                   $("#deptUser").attr("value",json.data.loginname)
                   $("#deptEmail").attr("value",json.data.email)
                   $("#deptSeq").attr("value",json.data.phone)
                   $("#deptName").attr("value",json.data.nickname)
                   $("#deptQuestion").attr("value",json.data.question)
                   $("#deptAnswer").attr("value",json.data.answer)
               }else{
                   $.dialog({
                       autoClose : 2500,
                       contentHtml :"<p style=\"text-align:center;\">"+json.msg+"</p>"
                   });
               }
           },
           "error": function () {//所有3字头4字头5字头的回应都会被捕获例如：302；404；405；500等

               location.href = "./err/500.html";
           }
       });
   }
}

/*修改个人信息*/
function condition_user_update(){
    var isNull = true;
    //获得表单值
    var email=$("#deptEmail").val();
    var phone=$("#deptSeq").val();
    var nickname=$("#deptName").val();
    var question= $("#deptQuestion").val();
    var answer= $("#deptAnswer").val();

    //如果表单为空，提示用户
    if( email=="" || nickname=="" || phone=="" || question=="" || answer==""){
        isNull = false;
        $.dialog({
            autoClose : 2500,
            contentHtml : '<p style="text-align:center;">资料未填写完整！</p>'
        });
    }
    if (isNull) {
        $.ajax({//发出异步请求
            "url": "/users/update_information",//url:将请求提交到哪里去
            "data": $("#deptForm").serialize(),//data:提交的请求参数
            "type": "POST",//type:提交方式
            "dataType": "json",
            "success": function (json) {
                if (json.status == 200) {
                    $.dialog({
                        autoClose : 2500,
                        contentHtml :"<p style=\"text-align:center;\">"+json.msg+"</p>"
                    });
                } else {
                    $.dialog({
                        autoClose : 2500,
                        contentHtml :"<p style=\"text-align:center;\">"+json.msg+"</p>"
                    });
                }
            },
            "error": function () {//所有3字头4字头5字头的回应都会被捕获例如：302；404；405；500等
                location.href = "./err/500.html";
            }
        });
    }

}

/*退出登录*/
function condition_logout(){
    $.ajax({
        "url": "/users/logout",
        "type": "POST",
        "dataType": "json",
        "success": function (json) {
            if (json.status == 200) {
                location.href = "index.html";
            } else {
                $.dialog({
                    autoClose: 2500,
                    contentHtml: "<p style=\"text-align:center;\">" + json.msg + "</p>"
                });
            }
        }
    });
}

function condition_set() {
    $.dialog({
        autoClose: 2500,
        contentHtml: "<p style=\"text-align:center;\">功能暂未开放</p>"
    });
}