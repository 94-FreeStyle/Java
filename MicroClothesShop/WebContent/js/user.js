function DeleteRow(obj) {
	createXMLHttpRequest();
	var opts = document.getElementsByName("checkbox");
	var table = document.getElementById(obj);
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			alert("确认删除？");
			table.deleteRow(i + 1);
			var uid = opts[i].value;
			xmlHttp.onreadystatechange = callback;
			xmlHttp.open("post", "/MicroClothesShop/servlet/DeleteUser");
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xmlHttp.send("uid=" + uid);
		}
	}
}

function callback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {

			alert("删除成功！");
		}
	}
}

function queryuser() {
	createXMLHttpRequest();
	var uname = document.getElementById("serachContent").value;
	xmlHttp.onreadystatechange = querycallback;
	xmlHttp.open("post", "/MicroClothesShop/servlet/QueryUser");
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("uname=" + uname);

}

function querycallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var jsonObj = new Object();
			jsonObj = eval("(" + xmlHttp.responseText + ")");
			document.getElementById("uuname").innerHTML = jsonObj.User[0].name;
			document.getElementById("uumail").innerHTML = jsonObj.User[0].mail;
			document.getElementById("uuphone").innerHTML = jsonObj.User[0].phone;
			document.getElementById("uuadd").innerHTML = jsonObj.User[0].address;
			document.getElementById("uubank").innerHTML = jsonObj.User[0].bank;
			document.getElementById("uupw").innerHTML = jsonObj.User[0].pw;
		}
	}
}
