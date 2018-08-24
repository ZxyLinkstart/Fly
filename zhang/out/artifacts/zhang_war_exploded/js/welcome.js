
//-------------------------监听------------------------
function loginnameFunction() {
    var x = document.getElementById("loginname").value;
    if (x==""||x==null) {
        document.getElementById("loginnName").style.color = "red";
        document.getElementById("loginnName").innerHTML = "请输入账号";
    }
    else {
        document.getElementById("loginnName").innerHTML = "";
    }
}
function loginpasswordFunction() {
    var y = document.getElementById("loginpassword").value;
    if (y==""||y==null) {
        document.getElementById("loginnPassword").style.color = "red";
        document.getElementById("loginnPassword").innerHTML = "请输入密码";
    }else {
        document.getElementById("loginnPassword").innerHTML = "";
    }

}


function login() {
    var sname = document.getElementById("loginname").value;
    var spassword = document.getElementById("loginpassword").value;
    var checkbox = document.getElementById("isRmbPwd");
    var checkBox;
    if (spassword == "" || sname == "") {

        swal({
            title: '请输入用户名和密码',
            type: 'error',
            confirmButtonText: 'OK'
        });
        return;
    }
    if(checkbox.checked){
        checkBox = checkbox.value;
    }
    else {
        checkBox = null ;
    }
    $.ajax({
        url: 'stuInfo',
        method: 'get',
        data: {
            sname: sname,
            spassword: spassword,
            chekBox: checkBox,

        },
        success: function (result) {
            if (result == "true") {
                location.href = "Info.do"
                // response.sendRedirect("Info.do");
            }
            if (result == "false") {
                swal({
                    title: '用户名不存在或密码错误',
                    type: 'error',
                    confirmButtonText: 'OK'
                });
                $("#loginpassword").val("");
            }
        },
        error: function () {
            alert("wrong");
        }
    })
}






