<%--
  Created by IntelliJ IDEA.
  User: 黄凯
  Date: 2018/7/21
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script type="text/javascript" src="statics/js/jquery-1.8.3.js"></script>
</head>
<body>
    <div>
        <h2>小型进销存储系统</h2>
        <form action="login.htmls" method="post" id="myform">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"/></td>
            </tr>

        </table>
            <div><input type="submit" value="登录"/></div>
        </form>
    </div>
<script type="text/javascript">
    $(function () {
        $("#myform").submit(function () {
            var name=$("input[name=userName]").val();
            var pwd=$("input[name=password]").val();
            if (name==''){
                alert("用户名必填")
                return false;
            }
            if (pwd==''){
                alert("密码必填")
                return false;
            }
            return true;
        })
    })
</script>
</body>
</html>
