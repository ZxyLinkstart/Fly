<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/8/13
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/welcome.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../jq.js"></script>

    <%--弹窗--%>
    <script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.all.js"></script>
    <link href="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.css" rel="stylesheet">
    <%--<script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.js"></script>--%>
    <%--<link href="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.min.css" rel="stylesheet">--%>
    <%--<script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.min.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.all.min.js"></script>--%>

    <%--导入js--%>
    <script src="../js/welcome.js"></script>



</head>
<body>

<%
    String username = null;
    String password = null;
    //获取cookie
    Cookie[] cookies = request.getCookies();
    if(cookies!=null){
        //如果cookies不为空的话遍历
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("coolusername")){
                username = cookie.getValue();//获取coolusername的值
            }
            if(cookie.getName().equals("coolpassword")){
                password = cookie.getValue();//获取coolpassword的值
            }
        }
    }
    //如果存在cookie的话不需要输入用户名和密码自己登陆
    if(username!=null && password!=null){
        request.getRequestDispatcher("../Info.do?username="+username+"&password="+password).forward(request, response);
    }

%>

    <div class="bodystyle">
        <div class="welw">
            <h1 > LOGIN</h1>
            <form method="post" autocomplete="off" onsubmit="return check()" id="loginForm">
                <div class="f1">
                    <span class="glyphicon glyphicon-user" style="color: rgb(104, 140, 197);font-size: 25px">:</span>
                    &#12288<input class="inputformation" type="text" name="sname" id="loginname" oninput="loginnameFunction()" placeholder="输入账号"  style="BACKGROUND-COLOR: transparent;"  onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">
                </div>
                <div class="jian"> <p id="loginnName"></p></div>
                <div class="f1">
                    <span class="glyphicon glyphicon-lock" style="color: rgb(104, 140, 197);font-size: 25px">:</span> &#12288<input class="inputformation" type="password" name="spassword"   id="loginpassword" oninput="loginpasswordFunction()" placeholder="输入账号" placeholder="输入密码" style="BACKGROUND-COLOR: transparent;">
                </div>
                <div class="jian"> <p id="loginnPassword"></p> </div>
                <div class="f2"> <input type="button"  onclick="login()"  value="登录" class="btn btn-info btn-block"></div>
            <div class="f2"><a href="jsp/newone.jsp"><button  type="button"   class="btn btn-info btn-block">注册</button></a></div>
                <label><input type="checkbox" name="checkbox" value="1" id="isRmbPwd">自动登录<br></label>
            <%--<label><input id="remember" type="checkbox">记住密码</label>--%>
            </form>
        </div>
    </div>
</body>
</html>

