


function newone() {
    var name = document.getElementById("newname").value;
    var spassword = document.getElementById("newpassword").value;
    var sspassword = document.getElementById("againpassword").value;

    if (name == "" || spassword == "" || sspassword == "") {

        swal({
            title: '请输入账号和密码',
            type: 'error',
            confirmButtonText: 'OK'
        });
        return;
    }
    else if (spassword != sspassword) {
        swal({
            title: '两次输入不一致',
            type: 'error',
            confirmButtonText: 'OK'
        });
        return;
    }
    //判断 之后在传值！！

        $.ajax({
            url: '../NewWelServlet',
            method: 'get',
            data: {
                name: name,
                spassword: spassword,
            },
            success: function (result) {
                if (result == "true") {
                    location.href = "formation.jsp"
                }
                if (result == "false") {
                    swal({
                        title: '用户名已存在',
                        type: 'error',
                        confirmButtonText: 'OK'
                    })
                }


                $("#newname").val("");
            },
            error: function () {
                alert("wrong");
            }
        })

}