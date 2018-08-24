<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/8/16
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/newone.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../jq.js"></script>
    <%--弹窗--%>
    <script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.all.js"></script>
    <link href="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.css" rel="stylesheet">
    <script src="../js/newone.js"></script>
</head>
<body>
<div class="wel">
    <div class="i1"><span class="glyphicon glyphicon-paperclip" style="color: rgb(100,204,255);font-size: 25px">注册用户</span> </div>
    <form >
        <div class="i1"> <span class="glyphicon glyphicon-user" style="color: rgb(104, 140, 197);font-size: 15px">账&emsp;  号:</span><input class="inputformation" style="BACKGROUND-COLOR: transparent;" type="text" placeholder="仅能输入数字" name="name" id="newname"   onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"> </div>

        <div class="i1"> <span class="glyphicon glyphicon-lock" style="color: rgb(104, 140, 197);font-size: 15px">输入密码:</span><input class="inputformation" style="BACKGROUND-COLOR: transparent;" type="password" name="spassword" id="newpassword"> </div>

        <div class="i1"><span class="glyphicon glyphicon-lock" style="color: rgb(104, 140, 197);font-size: 15px">再次输入:</span><input class="inputformation" style="BACKGROUND-COLOR: transparent;" type="password" name="sspassword" id="againpassword"> </div>

        <div class="i1">
            <div class="i2">
            <input type="button" onclick="newone()" value="注册" class="btn btn-info btn-block">
            </div>
        </div>
    </form>
</div>
</body>
</html>


