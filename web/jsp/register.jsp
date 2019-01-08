<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
</head>
<script type="text/javascript" src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<body class="jumbotron">
<div class="container" align="center">
    <h2 class="text-success" style="font-family:宋体;font-weight:bold;font-size:49px">注册</h2>
    <br>
    <br>
    <form action="/register" method="post">
        <table>
            <tr>
                <td><span class="text-primary" >账号:</span></td>
                <td><input id="username" class="form-control" onblur="check1()" name="username" type="text"/></td>
                <td><span id="alert1" class="alert-danger"></span></td>
            </tr>
            <tr>
                <td><span class="text-primary">密码:</span></td>
                <td><input id="password" class="form-control" onblur="check2()" name="password" type="password"/></td>
                <td><span id="alert2" class="alert-danger"></span></td>
            </tr>
            <tr>
                <td><span class="text-primary">确认密码:</span></td>
                <td><input id="password1" class="form-control" onmouseout="check3()" type="password"/></td>
                <td><span id="alert3" class="alert-danger"></span></td>
            </tr>
            <tr id="snoInput">
                <td><span class="text-primary">绑定学号:</span></td>
                <td><input type="text" id="sno" name="sno" class="form-control" onchange="check5()"></td>
                <td><span id="alert4" class="alert-danger"></span></td>
            </tr>
            <tr>
                <td><span class="text-primary">权限:</span></td>
                <td><select class="form-control" onchange="check4()" id="role" name="role">
                    <option value="ONE" selected="selected">学生</option>
                    <option value="ZERO">老师</option>
                    <option value="TWO">游客</option>
                </select></td>
            </tr>
        </table>
    <br/>
    <p><input id="submit" type="submit" class="btn btn-primary disabled" disabled="disabled" value="提交"></p>
   </form>

</div>
<script>
    var xmlHttp=new XMLHttpRequest();
    var password=document.getElementById("password");
    var password1=document.getElementById("password1");
    var alert1=document.getElementById("alert1");
    var alert2=document.getElementById("alert2");
    var alert3=document.getElementById("alert3");
    var alert4=document.getElementById("alert4");
    var submit=document.getElementById("submit");
    var sno=document.getElementById("sno");
    var role=document.getElementById("role");
    function check0() {
        if (alert1.classList.contains("alert-success")&&alert3.classList.contains("alert-success")&&(role.value!="ONE"||alert4.classList.contains("alert-success"))){
                submit.classList.remove("disabled");
                submit.disabled="";

        }else {
            submit.classList.add("disabled");
            submit.disabled="disabled";
        }

    }
    function check1() {
        var username = document.getElementById("username").value;
        var alert1=document.getElementById("alert1");
        var url = "/checkUser?username="+username;
        if (username.length==0){
            alert1.innerHTML="账号不能为空!";
            alert1.classList.remove("alert-success");
            alert1.classList.add("alert-danger");
            return;
        }
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                var bl = xmlHttp.responseText;
                if (bl=='false'){
                        alert1.innerHTML="该账号已存在";
                        alert1.classList.add("alert-danger");
                        alert1.classList.remove("alert-success");
                        submit.classList.add("disabled");
                        submit.disabled="disabled";
                }else {
                    alert1.innerHTML="该账号可以使用";
                    alert1.classList.remove("alert-danger");
                    alert1.classList.add("alert-success");
                    check0();
                }
            }
        }
        xmlHttp.open("GET", url, true);
        xmlHttp.send(null);
    }
    function check2() {
         if (password.value.length==0){
             alert2.innerHTML="密码不能为空!";
             alert2.classList.remove("alert-success");
             alert2.classList.add("alert-danger");
         }else{
             alert2.innerHTML="";
             alert2.classList.remove("alert-danger");
             alert2.classList.add("alert-success");
         }
    }
    function check3() {
        if (password.value !=password1.value){
            alert3.innerHTML="两次密码不一致!";
            alert3.classList.remove("alert-success");
            alert3.classList.add("alert-danger");
        }else {
            alert3.innerHTML="";
            alert3.classList.remove("alert-danger");
            alert3.classList.add("alert-success");

        }
        check0();
    }
    function check4() {
        var snoInput=document.getElementById("snoInput");
        if (role.value=="ONE"){
            snoInput.style.display='';
        }else {
            alert4.innerHTML="";
            sno.value="";
            alert4.classList.remove("alert-success");
            alert4.classList.add("alert-danger");
            snoInput.style.display = 'none';
        }
    }
    function check5() {
        var snoInput=document.getElementById("snoInput");
        if (snoInput.style.display=='none')
            return;
        var url1="/checkSno?sno="+sno.value;
        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                var bl = xmlHttp.responseText;
                if(bl=='true'){
                    alert4.innerHTML="该学号存在";
                    alert4.classList.remove("alert-danger");
                    alert4.classList.add("alert-success");
                    check0();
                }else {
                    alert4.innerHTML="找不到该学号";
                    alert4.classList.remove("alert-success");
                    alert4.classList.add("alert-danger");
                    check0();
                }
            }

        }
        xmlHttp.open("GET", url1, true);
        xmlHttp.send(null);

    }
</script>
</body>
</html>