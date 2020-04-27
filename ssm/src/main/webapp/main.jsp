<%--
  Created by IntelliJ IDEA.
  User: 64156
  Date: 2020/3/18
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>仓库</title>
    <style type="text/css">
        th{
            float: left;
            text-align:center;
            width: 100px;
        }
        td{
            float: left;
            text-align:center;
            width: 100px;
        }
    </style>
</head>
<body>

    <%--<a>仓库商品清单</a><br/>--%>
    <%--<c:forEach items="${commodity}" var="list">--%>
        <%--${list.getCname()}--%>
   <%--</c:forEach>--%>
    <form id="submitForm" name="submitForm" method="post">
        <div id="box_bottom">
            <input type="text">
            <input type="button" value="查询" />
            <br/>
            <input type="button" value="进货"/>
            <input type="button" value="未处理订单"/>
            <input type="button" value="已成交订单"/>
            <a href="/test/orderst">下单</a>
            <a href="/test/print">打印表格</a>
        </div>
        <form method="post" id="form1" action="/test/in">
            <label>上传文件</label>
            <input type="file" name="file">
            <input type="submit" value="上传excel">
        </form>
        <a>仓库商品清单</a><br/>
        <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
            <tr>
                <th>商品名称</th>
                <th>进货单价</th>
                <th>库存数量</th>
                <th>当前折扣</th>
                <th>销售单价</th>
                <th style="width: 300px" >描述</th>
                <th>操作</th>
            </tr>
        </table>
        <c:forEach items="${commodity}" var="list">
            <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                <tr>
                    <td>${list.getCname()}</td>
                    <td>${list.getCPprice()}</td>
                    <td>${list.getCnum()}</td>
                    <td>${list.getCdiscount()}</td>
                    <td>${list.getCprice()}</td>
                    <td style="width: 300px" >${list.getCdescribe()}</td>
                    <td>
                        <a href="">修改</a>
                        <a href="">出售</a>
                    </td>
                </tr>
            </table>
        <%--${list.getCname()}--%>
        </c:forEach>
</body>
</html>
