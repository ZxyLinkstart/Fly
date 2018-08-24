<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" import="entity.Info"%>
<%
    List<Info> Infos = (List<Info>)request.getAttribute("infos");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/info.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="../jq.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--弹窗--%>
    <script src="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.all.js"></script>
    <link href="https://cdn.bootcss.com/limonte-sweetalert2/7.21.0/sweetalert2.css" rel="stylesheet">

    <script src="../js/info.js"></script>
    <title>信息</title>
</head>
<body >
<div style="display: none;" id="bbbc">
<div class="infobody" >
    <div class="head"> <span class="glyphicon glyphicon-home" style="color: rgb(81,179,170); font-size: 59px;"> 学生信息</span></div>
    <div class="add">
        <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">
            <span class="glyphicon glyphicon-plus"></span>增加
        </button>
    </div>
    <table id="tableId" class="table table-hover table-bordered" >

        <tr class="success">
            <td><span class="glyphicon glyphicon-user" style="color: rgb(255, 140, 60);  font-size: 18px;"> ID号</span></td>
            <td><span class="glyphicon glyphicon-list-alt" style="color: rgb(255, 140, 60); font-size: 18px;"> 姓名</span></td>
            <td><span class="glyphicon glyphicon-tag" style="color: rgb(255, 140, 60); font-size: 18px;"> 性别</span></td>
            <td><span class="glyphicon glyphicon-file" style="color: rgb(255, 140, 60); font-size: 18px;"> 成绩</span></td>
            <td><span class="glyphicon glyphicon-cog" style="color: rgb(255, 140, 60); font-size: 18px;"> 修改</span></td>
            <td><span class="glyphicon glyphicon-cog" style="color: rgb(255, 140, 60); font-size: 18px;"> 删除</span></td>
        </tr>
        <% if (Infos!=null){%>
        <%for(int i = 0; i < Infos.size(); i++) { %>
            <tr id="<%=Infos.get(i).getId()%>" class="warning" >
            <td><%=Infos.get(i).getId()%></td>
            <td><%=Infos.get(i).getName()%></td>
            <td><%=Infos.get(i).getSex()%></td>
            <td><%=Infos.get(i).getGrade()%></td>
            <td>
                <button  type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModa2" onclick="change('<%=Infos.get(i).getId()%>','<%=Infos.get(i).getName()%>','<%=Infos.get(i).getSex()%>','<%=Infos.get(i).getGrade()%>')">
                    <span class="glyphicon glyphicon-repeat"></span>修改
                </button>
            </td>
                <%--<a href="/jsp/change.jsp?gg=<%=Infos.get(i).getId()%>&name=<%=Infos.get(i).getName()%>&sex=<%=Infos.get(i).getSex()%>&grade=<%=Infos.get(i).getGrade()%>"></a>--%>
            <td >
                <button type="button" class="btn btn-danger"  id="move1" onclick="move(<%=Infos.get(i).getId()%>)" >
                <span class="glyphicon glyphicon-minus"></span>删除
                </button></td>
            </tr>
        <%--<a href="/MoveInfoServlet?gg=<%=Infos.get(i).getId()%>"></a>--%>
        <% } %>
<%}%>

    </table>
</div>

<!------------------------------------- 模态框（Modal）增加 --------------------------------------------------------->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    增加信息
                </h4>
            </div>
            <div class="modal-body" id = "leirong1">
                    <div class="a1"><span class="glyphicon glyphicon-user" style="color: rgb(0,0,0); font-size: 18px;">ID号:</span><input style="BACKGROUND-COLOR: transparent;" class="inputformation"  type="text"  id="ssId"  oninput="setFunction()" onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"> </div>
                    <div id="jianting"> <p id="jiantingid"></p></div>
                    <div class="a1"><span class="glyphicon glyphicon-file" style="color: rgb(0,0,0); font-size: 18px;">姓名:</span><input style="BACKGROUND-COLOR: transparent;" class="inputformation" type="text"  id="ssName" onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"> </div>
                    <div id="jianting"> <p id="jiantingname"></p></div>
                    <div class="a1"><span class="glyphicon glyphicon-tag" style="color: rgb(0,0,0); font-size: 18px;">性别:</span><input style="BACKGROUND-COLOR: transparent;" class="inputformation" type="text"  id="ssSex"  oninput="myFunction()"  onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"></div>
                    <div id="jianting"> <p id="jiantingsex"></p></div>
                    <div class="a1"><span class="glyphicon glyphicon-file" style="color: rgb(0,0,0); font-size: 18px;">成绩:</span><input style="BACKGROUND-COLOR: transparent;" class="inputformation"  type="text" id="ssGrade" onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"> </div>
                    <div id="jianting"> <p id="jiantinggrade"></p></div>
                    <%--<input type="button" onclick="add()" value="增加" class="btn btn-info btn-block">--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="add()" >
                    提交增加
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-------------------------------------------- 模态框（Modal）修改 ---------------------------------------------- -->
<div class="modal fade" id="myModa2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabe2">
                    修改信息
                </h4>
            </div>
            <div class="modal-body" id="leirong2">

                    <div class="a1"><span class="glyphicon glyphicon-user" style="color: rgb(0,0,0); font-size: 18px;"></span><input style="display: none" class="inputformation"  type="text"  id="Id" sty> </div>
                    <div class="a1"><span class="glyphicon glyphicon-file" style="color: rgb(0,0,0); font-size: 18px;">姓名:</span><input style="BACKGROUND-COLOR: transparent;" class="inputformation" type="text"  id="Name" onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"> </div>
                    <div id="jianting"> </div>
                    <div class="a1"><span class="glyphicon glyphicon-tag" style="color: rgb(0,0,0); font-size: 18px;">性别:</span><input style="BACKGROUND-COLOR: transparent;" class="inputformation" type="text"  id="Sex" oninput="sexFunction()" onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"> </div>
                    <div id="jianting"> <p id="xiusex"></p></div>
                    <div class="a1"><span class="glyphicon glyphicon-file" style="color: rgb(0,0,0); font-size: 18px;">成绩:</span><input style="BACKGROUND-COLOR: transparent;" class="inputformation"  type="text" id="Grade" onkeyup="value=value.replace(/[^\d]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"> </div>
                    <div id="jianting"> </div>
                    <%--<input type="button" onclick="add()" value="增加" class="btn btn-info btn-block">--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" onclick="Change()" >
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</div>
</body>
</html>

