function DeleteRow(obj) {
	createXMLHttpRequest();

	var opts = document.getElementsByName("checkbox");
	var table = document.getElementById(obj);
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			alert("确认删除？");
			table.deleteRow(i + 1);
			var oid = opts[i].value;
			xmlHttp.onreadystatechange = callback;
			xmlHttp.open("post", "/MicroClothesShop/servlet/DeleteOrder");
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xmlHttp.send("oid=" + oid);
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

function queryorder() {
	createXMLHttpRequest();
	var oid = document.getElementById("serachContent").value;
	xmlHttp.onreadystatechange = querycallback;
	xmlHttp.open("post", "/MicroClothesShop/servlet/QueryOrder");
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("oid=" + oid);

}

function querycallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var jsonObj = new Object();
			jsonObj = eval("(" + xmlHttp.responseText + ")");
			document.getElementById("ooid").innerHTML = jsonObj.Order[0].id;
			document.getElementById("oodate").innerHTML = jsonObj.Order[0].date;
			document.getElementById("oomoney").innerHTML = jsonObj.Order[0].money;
			document.getElementById("oouser").innerHTML = jsonObj.Order[0].user;
			document.getElementById("ooopt").innerHTML = jsonObj.Order[0].opt;
			document.getElementById("oostatu").innerHTML = jsonObj.Order[0].statu;
		}
	}
}

function fahuo() {
	createXMLHttpRequest();
	var opts = document.getElementsByName("checkbox");
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			var oid = opts[i].value;
			xmlHttp.onreadystatechange = fahuocallback;
			xmlHttp.open("post", "/MicroClothesShop/servlet/FaHuo");
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xmlHttp.send("oid=" + oid);
		}
	}

}

function fahuocallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var con = xmlHttp.responseText;
			alert(con);
		}
	}
}

function xiang() {
	var opts = document.getElementsByName("checkbox");
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			var oid = opts[i].value;

			window.location.href = "/MicroClothesShop/servlet/OrderMess?oid="
					+ oid;

		}
	}

}

function qureybystatu() {
	var opts = document.getElementsByName("statu");
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			var statu = opts[i].value;
			window.location.href = "/MicroClothesShop/servlet/QueryOrderByStatu?statu="
					+ statu;
		}
	}

}

function tuihuo() {
	createXMLHttpRequest();
	var opts = document.getElementsByName("checkbox");
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			var oid = opts[i].value;
			xmlHttp.onreadystatechange = tuihuocallback;
			xmlHttp.open("post", "/MicroClothesShop/servlet/TuiOperate");
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xmlHttp.send("oid=" + oid);
		}
	}

}

function tuihuocallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var con = xmlHttp.responseText;
			alert(con);
		}
	}
}