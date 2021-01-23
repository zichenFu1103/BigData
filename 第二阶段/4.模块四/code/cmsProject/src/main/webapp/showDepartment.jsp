<%--
  Created by IntelliJ IDEA.
  User: zichenfu
  Date: 1/23/21
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/listStyle.css" rel="stylesheet">
    <title>部门信息</title>
</head>
<body>
    <h1 id="title">部门信息</h1>
    <table id="content">
        <thead>
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>部门经理</th>
                <th>联系方式</th>
                <th>邮箱</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${department.departId}</td>
                <td>${department.departName}</td>
                <td>${department.departManager}</td>
                <td>${department.managerTel}</td>
                <td>${department.managerEmail}</td>
            </tr>
        </tbody>
    </table>
</body>
</html>
