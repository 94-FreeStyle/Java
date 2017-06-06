
function callbackpw() {
    var mail = prompt("请输入您的注册邮箱", "");
    createXMLHttpRequest();
    xmlHttp.open("post", "/Monitor/CallBackPW");
    xmlHttp.setRequestHeader("Content-Type",
            "application/x-www-form-urlencoded;charset=UTF-8");
    xmlHttp.onreadystatechange = callback;
    xmlHttp.send("mail=" + mail);
}

function callback() {
    if (xmlHttp.readyState == 4) {
        if (xmlHttp.status == 200) {
            var fan = xmlHttp.responseText;
            if (fan == "ok") {
                alert("已成功发送邮件！");
            } else {
                alert("密码找回失败！");
            }
        }

    }
}




