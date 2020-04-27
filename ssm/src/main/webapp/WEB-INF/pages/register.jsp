<%--
  Created by IntelliJ IDEA.
  User: 64156
  Date: 2020/3/17
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="<%=request.getContextPath() %> /js/jquery.min.js"></script>
</head>
<body>
<form id="user"  method="post">
    账号：<input type="text" id="username" name="username"><br/>
    密码：<input type="text" id="password"  name="password"><br/>
    <input type="button" id="registerbutton" value="注册">
</form>
<a href="/index/boom">首页</a>
<script>
    $(function () {
        $("#registerbutton").click(function () {
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
                url:"testAjax1",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(data),
                // dataType:"json",
                type:"POST",
                success:function (data) {
                    if(data=="True"){
                        alert("注册成功");
                        window.location.href='<%=request.getContextPath() %>/index.jsp';
                    }else{
                        alert("用户名已经被占用");
                    }
                }
            });
        });
    });
</script>
</body>
</html>

