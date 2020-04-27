<%--
  Created by IntelliJ IDEA.
  User: 64156
  Date: 2020/3/16
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
    <title>首页</title>
    <script src="js/jquery.min.js"></script>
</head>
<body>
    <%--<a href="account/findAll">查询所有</a>--%>
    <%--<a href="account/login">跳转到登录页面</a>--%>

    <%--<form action="account/save" method="post">--%>
        <%--姓名：<input type="text" name="name"><br/>--%>
        <%--金额：<input type="text" name="money"><br/>--%>
        <%--<input type="submit" value="保存" ><br/>--%>
    <%--</form>--%>
    <form id="user"  method="post">
        账号：<input type="text" id="username" name="username"><br/>
        密码：<input type="text" id="password"  name="password"><br/>
        <input type="button" id="loginbutton" value="登录">
    </form>
    <a href="/index/register">注册</a>
    <script>
        $(function () {
            $("#loginbutton").click(function () {
                var username  = $("input[name='username']").val();
                var password  = $("input[name='password']").val();
                if(username==''){
                    confirm("用户名不能为空");
                    return false;
                }
                if(password==''){
                    confirm("密码不能为空");
                    return false;
                }
                var data={username:username,password:password};
                 $.ajax({
                      url:"index/testAjax",
                      contentType:"application/json;charset=UTF-8",
                      data:JSON.stringify(data),
                      // dataType:"json",
                      type:"POST",
                      async:true,
                      success:function (data) {
                          if(data=="YES"){
                              alert("登录成功");
                              window.location.href='main.jsp';
                          }
                          else{
                              alert("账号或者密码错误");
                          }
                      }
                 });
            });
        });
    </script>
</body>
</html>
