<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
    function fun0() {
        if (${empty sessionScope.user}) {
            location.href = "/jsp/login.jsp";
        }
    }

    window.onload = fun0;
</script>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<style>
    #content {
        position: relative;
        left: 500px;
        top: 20px;
        width: 400px;
        height: 50px;

    }
</style>
<script type="text/javascript" src="../js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<div class="container">
    <p>用户:&nbsp;&nbsp;<span class="text-primary">${user.student.sname}</span>&nbsp;&nbsp;&nbsp;<a
            href="/logout"><input type="button" value="注销" class="btn btn-warning"/></a></p>
</div>
<br/>
<div class="container" align="center">
    <ul class="nav nav-pills nav-tabs">
        <li class="active"><a href="#userInfo" data-toggle="tab">个人信息</a></li>
        <li><a href="#source" data-toggle="tab">选课</a></li>
        <li><a href="#source1" data-toggle="tab">已选课程</a></li>
        <li class="dropdown">
            <a href="#" id="myTabDrop1" class="dropdown-toggle"
               data-toggle="dropdown">成绩查询
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                <li><a href="#pass" tabindex="-1" data-toggle="tab">已通过课程</a></li>
                <li><a href="#notPass" tabindex="-1" data-toggle="tab">未通过课程</a></li>
                <li><a href="#statistic" tabindex="-1" data-toggle="tab">成绩统计</a></li>


            </ul>
        </li>
    </ul>

    </ul>
</div>
<div id="content" class="tab-content">
    <div class="tab-pane fade in active" id="userInfo">
        <form action="/update" method="get">
            <table class="table table-hover table-condensed">
                <tr>
                    <td><span class="text-primary">学号:</span></td>
                    <td><input id="sno" name="sno" type="text" value="${user.student.sno}"
                               disabled="disabled" class="form-control"/></td>
                </tr>
                <tr>
                    <td><span class="text-primary">姓名:</span></td>
                    <td><input id="sname" name="sname" type="text" value="${user.student.sname}"
                               disabled="disabled" class="form-control"/></td>
                </tr>
                <tr>
                    <td><span class="text-primary">年龄:</span></td>
                    <td><input id="age" name="age" type="text" value="${user.student.age}"
                               disabled="disabled" class="form-control"/></td>
                </tr>
                <tr>
                    <td><span class="text-primary">所在系:</span></td>
                    <td><input id="dept" name="dept" type="text" value="${user.student.dept}"
                               disabled="disabled" class="form-control"/></td>
                </tr>
            </table>
            <p align="center"><input id="edit" type="button" value="编辑" class="btn btn-success"
                                     onclick="fun1()">
                <input id="submit" type="submit" value="提交" disabled="disabled"
                       class="btn btn-primary"/></p>
        </form>
    </div>
    <div class="tab-pane fade" id="source">
        <table class="table table-striped table-condensed">
            <thead>
            <td align="center" class="bg-info text-primary"><span>课程号</span></td>
            <td align="center" class="bg-info text-primary"><span>课程名</span></td>
            <td align="center" class="bg-info text-primary"><span>任课老师</span></td>
            <td align="center" class="bg-info text-primary"><span>学分</span></td>
            <td align="center" class="bg-info text-primary"><span>操作</span></td>
            </thead>

            <c:forEach var="course" items="${sessionScope.notCourses}">
                <tr>
                    <td align="center" class="text-info"><span>${course.cno}</span></td>
                    <td align="center" class="text-info"><span>${course.cname}</span></td>
                    <td align="center" class="text-info"><span>${course.teacher}</span></td>
                    <td align="center" class="text-info"><span>${course.credit}</span></td>
                    <td align="center" class="text-info"><a
                            href="/addCourse?sno=${user.student.sno}&cno=${course.cno}"><input
                            type="button" class="btn btn-primary btn-sm" value="选课"/></a></td>
                </tr>

            </c:forEach>

        </table>
    </div>
    <div class="tab-pane fade" id="source1">
        <table class="table table-striped table-condensed">
            <thead>
            <td align="center" class="bg-info text-primary"><span>课程号</span></td>
            <td align="center" class="bg-info text-primary"><span>课程名</span></td>
            <td align="center" class="bg-info text-primary"><span>任课老师</span></td>
            <td align="center" class="bg-info text-primary"><span>学分</span></td>
            <td align="center" class="bg-info text-primary"><span>操作</span></td>
            </thead>
            <c:set var="redit" value="0"/>
            <c:forEach var="stuCourse" items="${sessionScope.stuCourses}">
                <tr>
                    <td align="center" class="text-info"><span>${stuCourse.course.cno}</span></td>
                    <td align="center" class="text-info"><span>${stuCourse.course.cname}</span></td>
                    <td align="center" class="text-info"><span>${stuCourse.course.teacher}</span>
                    </td>
                    <td align="center" class="text-info"><span>${stuCourse.course.credit}</span>
                    </td>
                    <td align="center" class="text-info"><a
                            href="/removeCourse?sno=${user.student.sno}&cno=${stuCourse.course.cno}"><input
                            type="button" class="btn btn-primary btn-sm" value="退选"/></a></td>
                </tr>
                <c:set var="redit" value="${redit+stuCourse.course.credit}"/>
            </c:forEach>
        </table>
        <p align="center" class="bg-success"><span class="text-primary">已选学分:</span><span
                class="text-primary">${redit}</span></p>
    </div>
    <div class="tab-pane fade" id="pass">
        <table class="table table-striped table-condensed">
            <thead>
            <td align="center" class="bg-info text-primary"><span>课程号</span></td>
            <td align="center" class="bg-info text-primary"><span>课程名</span></td>
            <td align="center" class="bg-info text-primary"><span>成绩</span></td>
            </thead>
            <c:forEach var="stuCourse" items="${sessionScope.stuCourses}">
                <c:if test="${stuCourse.grade!=null&&stuCourse.grade>=60}">
                    <tr>
                        <td align="center" class="text-info"><span>${stuCourse.course.cno}</span>
                        </td>
                        <td align="center" class="text-info"><span>${stuCourse.course.cname}</span>
                        </td>
                        <td align="center" class="text-info"><span>${stuCourse.grade}</span></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>

    <div class="tab-pane fade" id="notPass">
        <table class="table table-striped table-condensed">
            <thead>
            <td align="center" class="bg-info text-primary"><span>课程号</span></td>
            <td align="center" class="bg-info text-primary"><span>课程名</span></td>
            <td align="center" class="bg-info text-primary"><span>成绩</span></td>
            </thead>
            <c:forEach var="stuCourse" items="${sessionScope.stuCourses}">
                <c:if test="${stuCourse.grade!=null&&stuCourse.grade<60}">
                    <tr>
                        <td align="center" class="text-info"><span>${stuCourse.course.cno}</span>
                        </td>
                        <td align="center" class="text-info"><span>${stuCourse.course.cname}</span>
                        </td>
                        <td align="center" class="text-info"><span>${stuCourse.grade}</span></td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
    <div class="tab-pane fade" id="statistic">
        <table class="table table-striped table-condensed">
            <thead>
            <td align="center" class="bg-info text-primary"><span>课程名</span></td>
            <td align="center" class="bg-info text-primary"><span>平均分</span></td>
            </thead>
            <c:forEach var="map" items="${sessionScope.avgs}">
                <tr>
                    <td align="center" class="text-info"><span>${map.cname}</span></td>
                    <td align="center" class="text-info"><span>${map.avg}</span></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script>
    var sname = document.getElementById("sname");
    var age = document.getElementById("age");
    var dept = document.getElementById("dept");
    var edit = document.getElementById("edit");
    var submit = document.getElementById("submit");

    function fun1() {
        sname.disabled = "";
        age.disabled = "";
        dept.disabled = "";
        submit.disabled = "";
        edit.disabled = "disabled";
    }
</script>
</body>
</html>