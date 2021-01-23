<%--
  Created by IntelliJ IDEA.
  User: zichenfu
  Date: 1/23/21
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/addStyle.css" rel="stylesheet">
    <title>更新员工信息</title>
</head>
<body>
    <div id="container">
    <h1 id="title">更新员工信息</h1>
    <form id="content" action="${pageContext.request.contextPath}/employee/update" method="post">
        <input type="hidden" name="empId" value="${employee.empId}">
        <div>
            <label for="name">姓名：</label>
            <input type="text" id="name" name="empName" placeholder="姓名" value="${employee.empName}">
        </div>
        <div>
            <label for="position">职位：</label>
            <input type="text" id="position" name="empPosition" placeholder="职位" value="${employee.empPosition}">
        </div>
        <div>
            <label for="date">入职时间：</label>
            <input type="text" id="date" name="empStartDate" placeholder="入职时间" value="${employee.empStartDate}">
        </div>
        <div>
            <label for="tel">联系方式：</label>
            <input type="text" id="tel" name="empTel" placeholder="联系方式" value="${employee.empTel}">
        </div>
        <div>
            <label for="departNum">所属部门编号：</label>
            <input type="text" id="departNum" name="empDepartId" placeholder="所属部门编号" value="${employee.empDepartId}">
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>

</div>
</body>
</html>
