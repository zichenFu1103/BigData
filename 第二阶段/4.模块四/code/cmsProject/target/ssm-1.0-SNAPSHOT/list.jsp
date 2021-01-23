<%--
  Created by IntelliJ IDEA.
  User: zichenfu
  Date: 1/23/21
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/listStyle.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <title>员工信息表</title>
</head>
<body>
    <div id="container">
        <h1 id="title">员工信息表</h1>
        <form action="${pageContext.request.contextPath}/employee/delete" id="deleteBatchForm">
            <table id="content">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="checkAll">
                        <script>
                            $('#checkAll').click(function () {
                                $('input[name="ids"]').prop('checked',$(this).prop('checked'));
                            })
                        </script>
                    </th>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>职位</th>
                    <th>入职时间</th>
                    <th>联系方式</th>
                    <th>所属部门编号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="employee">
                    <tr>
                        <td>
                            <input type="checkbox" name="ids" value="${employee.empId}">
                        </td>
                        <td>${employee.empId}</td>
                        <td>${employee.empName}</td>
                        <td>${employee.empPosition}</td>
                        <td>${employee.empStartDate}</td>
                        <td>${employee.empTel}</td>
                        <td>${employee.empDepartId}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/department/findById?departId=${employee.empDepartId}">查询部门信息</a>
                            <a href="${pageContext.request.contextPath}/employee/findById?empId=${employee.empId}">修改员工信息</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><input type="button" value="删除选中" id="deleteBatchBtn"></td>
                    <td><a href="${pageContext.request.contextPath}/add.jsp">添加员工</a></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
<script>
    /*给删除选中按钮绑定点击事件*/
    $('#deleteBatchBtn').click(function () {
        if($('input[name=ids]:checked').length > 0){
            if(confirm('您确定要删除吗？')){
                $('#deleteBatchForm').submit()
            }
        }else{
            alert('请选择要删除的员工！')
        }
    })
</script>

</html>
