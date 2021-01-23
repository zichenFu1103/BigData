<%--
  Created by IntelliJ IDEA.
  User: zichenfu
  Date: 1/23/21
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <title>添加员工</title>
    <link href="${pageContext.request.contextPath}/css/addStyle.css" rel="stylesheet">
</head>
<body>
    <div id="container">
        <h1 id="title">添加员工</h1>
        <form id="content" action="${pageContext.request.contextPath}/employee/save" method="post">
            <div>
                <label for="name">姓名：</label>
                <input type="text" id="name" name="empName" placeholder="姓名">
            </div>
            <div>
                <label for="position">职位：</label>
                <input type="text" id="position" name="empPosition" placeholder="职位">
            </div>
            <div>
                <label for="date">入职时间：</label>
                <input type="text" id="date" name="empStartDate" placeholder="入职时间">
            </div>
            <div>
                <label for="tel">联系方式：</label>
                <input type="text" id="tel" name="empTel" placeholder="联系方式">
            </div>
            <div>
                <label for="departNum">所属部门编号：</label>
                <input type="text" id="departNum" name="empDepartId" placeholder="所属部门编号">
            </div>
            <div>
                <input type="submit" value="提交">
            </div>
        </form>

    </div>
</body>
</html>
