<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登陆</title>
    </head>
    <body class="jumbotron">
		<script type="text/javascript" src="../js/jquery-2.2.4.min.js" ></script>
    	<script type="text/javascript" src="../js/bootstrap.min.js" ></script>
    	<link rel="stylesheet" href="../css/bootstrap.min.css" />
  			<div class="container" align="center">
      		  <h2 class="text-info" style="font-family:宋体;font-weight:bold;font-size:49px">信息管理系统</h2>
		      <br>
		      <br>
				<table>
		      		<tr>
						<td><span class="text-primary">账号:</span></td>
				  		<td><input id="username" class="form-control" type="text" placeholder="请输入账号"/></td>
			  		</tr>
					<tr>
						<td><span class="text-primary">密码:</span></td>
						<td><input id="password" class="form-control" type="password" placeholder="请输入密码"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input id="login" type="button" class="btn btn-primary" onclick="check()" value="登陆">
							<a role="button" href="/jsp/register.jsp" class="btn btn-success">注册</a></td>
					</tr>
				</table>
  			</div>
	<script>
		var xmlHttp;
		function check() {
			var username=document.getElementById("username").value;
			var password=document.getElementById("password").value;
			var url="/login";
			xmlHttp=new XMLHttpRequest();
			xmlHttp.onreadystatechange=function () {
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
				    var bl=xmlHttp.responseText;
				    if(bl=='true'){
				        alert("登陆成功");
				        location.href="/jsp/studentInfo.jsp";
					}else alert("账号密码错误");
				}
			}
            xmlHttp.open("POST",url,true);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlHttp.send('username='+username+'&password='+password);
        }

	</script>
 	</body>
</html>