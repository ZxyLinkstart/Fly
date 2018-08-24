
//删除
function move(id) {
    $.ajax({
        url: '../MoveInfoServlet',
        method: 'get',
        data: {
            ID: id,
        },
        success: function (result) {
            if (result == "true") {
                $("#" + id).remove();
                swal({
                    title: '删除成功',
                    type: 'success',
                    confirmButtonText: 'OK'
                });
            }
            if (result == "false") {
                alert("删除失败")
            }
        },
        error: function () {
            alert("删除失败");
        }
    })
}

//-------------------------------监听
function myFunction() {
    var x = document.getElementById("ssSex").value;
    if (x=="男"||x=="女") {
        document.getElementById("jiantingsex").innerHTML = "&thinsp;&thinsp;&thinsp;√";
        document.getElementById("jiantingsex").style.color = "green";
    }
    else{
        document.getElementById("jiantingsex").style.color = "red";
        document.getElementById("jiantingsex").innerHTML = "请输入正确信息";
    }
}
function sexFunction() {
    var x = document.getElementById("Sex").value;
    if (x=="男"||x=="女") {
        document.getElementById("xiusex").innerHTML = "&thinsp;&thinsp;&thinsp;√";
        document.getElementById("xiusex").style.color = "green";
    }
    else{
        document.getElementById("xiusex").style.color = "red";
        document.getElementById("xiusex").innerHTML = "请输入正确信息";
    }
}

function setFunction() {
    var x = document.getElementById("ssId").value;
    if (x=="") {
        document.getElementById("jiantingid").innerHTML ="输入不能为空";
        document.getElementById("jiantingid").style.color = "red";
    }else {
        document.getElementById("jiantingid").innerHTML ="";
    }
}

//----------------------------------增加
function add() {
    var sId = document.getElementById("ssId").value;
    var sName = document.getElementById("ssName").value;
    var sSex = document.getElementById("ssSex").value;
    var sGrade = document.getElementById("ssGrade").value;
    var flag = "true";
    if (sId == "" || sName == "" || sSex == "" || sGrade == "") {

        swal({
            title: '请输入完整信息',
            type: 'error',
            confirmButtonText: 'OK'
        });
        return;
    }
   if(sSex!='男'&&sSex!="女")
   {
       swal({
           title: '请输入正确信息',
           type: 'error',
           confirmButtonText: 'OK'
       });
       return;
   }

        $.ajax({
            url: '../AddInfoServlet',
            method: 'get',
            data: {
                sId: sId,
                sName: sName,
                sSex: sSex,
                sGrade: sGrade
            },
            success: function (result) {
                if (result == "true") {
                    location.href = "../Info.do"
                }
                if (result == "false") {

                    $("#ssId").val("");
                    swal({
                        title: 'ID已存在',
                        type: 'error',
                        confirmButtonText: 'OK'
                    });
                }
            },
            error: function () {
                alert("wrong");
            }
        })

}


//--------------修改
function change(id, name, sex, grade) {
    $("#Id").val(id);
    $("#Name").val(name);
    $('#Sex').val(sex);
    $('#Grade').val(grade);
}

function Change() {
    var sId = document.getElementById("Id").value;
    var sName = document.getElementById("Name").value;
    var sSex = document.getElementById("Sex").value;
    var sGrade = document.getElementById("Grade").value;


    if (sName == "" || sSex =="" || sGrade == "") {
        swal({
            title: '请输入完整信息',
            type: 'error',
            confirmButtonText: 'OK'
        });
        return;
    }
    if(sSex!='男'&&sSex!="女")
    {
        swal({
            title: '请修改正确信息',
            type: 'error',
            confirmButtonText: 'OK'
        });
        return;
    }


    $.ajax({
        url: '../ChangeInfoServlet',
        method: 'get',
        data: {
            sId: sId,
            sName: sName,
            sSex: sSex,
            sGrade: sGrade
        },
        success: function (result) {
            if (result == "true") {
                location.href = "../Info.do"
            }
            if (result == "false") {

            }
        },
        error: function () {
            alert("wrong");
        }
    })
}


$(document).ready(function(){
    $("#bbbc").show(1500);
});

