function DeleteRow(obj) {
	createXMLHttpRequest();

	var opts = document.getElementsByName("checkbox");
	var table = document.getElementById(obj);
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			alert("确认删除？");
			table.deleteRow(i + 1);
			var cid = opts[i].value;
			xmlHttp.onreadystatechange = callback;
			xmlHttp.open("post", "/MicroClothesShop/servlet/DeleteClothes");
			xmlHttp.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			xmlHttp.send("cid=" + cid);
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

function querycloth() {
	createXMLHttpRequest();
	var cid = document.getElementById("serachContent").value;
	xmlHttp.onreadystatechange = querycallback;
	xmlHttp.open("post", "/MicroClothesShop/servlet/QueryCloth");
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("cid=" + cid);
}

function querycallback() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var jsonObj = new Object();
			jsonObj = eval("(" + xmlHttp.responseText + ")");
			document.getElementById("ccid").innerHTML = jsonObj.Cloth[0].id;
			document.getElementById("ccname").innerHTML = jsonObj.Cloth[0].name;
			document.getElementById("ccprice").innerHTML = jsonObj.Cloth[0].price;
			document.getElementById("ccbrand").innerHTML = jsonObj.Cloth[0].brand;
			document.getElementById("ccdiscount").innerHTML = jsonObj.Cloth[0].discount;
			document.getElementById("ccsurplus").innerHTML = jsonObj.Cloth[0].surplus;
			document.getElementById("ccselled").innerHTML = jsonObj.Cloth[0].selled;
		}
	}
}

function add() {
	window.location.href = "/MicroClothesShop/servlet/AdminRequestForward?name=AMR_AddClothes.jsp";
}
function edit() {
	var opts = document.getElementsByName("checkbox");
	for (i = 0; i < opts.length; i++) {
		if (opts[i].checked == true) {
			var cid = opts[i].value;
			window.location.href = "/MicroClothesShop/servlet/EditCloth?cid="+cid;
		}
	}

}