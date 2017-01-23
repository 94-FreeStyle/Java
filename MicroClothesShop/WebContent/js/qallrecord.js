function record() {
	window.location.href = "/MicroClothesShop/servlet/QueryAllSelledRecord";
}
function kucun() {
	window.location.href = "/MicroClothesShop/servlet/KuCun";
}
function fenxi() {
	window.location.href = "/MicroClothesShop/servlet/FenXi";
}
function ruku(){
	window.location.href = "/MicroClothesShop/servlet/RuKu";
}
function querykucun() {

	createXMLHttpRequest();
	var cid = document.getElementById("serachContent").value;

	xmlHttp.onreadystatechange = querykucuncall;
	xmlHttp.open("post", "/MicroClothesShop/servlet/QueryKuCun");
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("cid=" + cid);

}

function querykucuncall() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var jsonObj = new Object();
			jsonObj = eval("(" + xmlHttp.responseText + ")");
			document.getElementById("radioss").value = jsonObj.Cloth[0].id;
			document.getElementById("ccid").innerHTML = jsonObj.Cloth[0].id;
			document.getElementById("ccname").innerHTML = jsonObj.Cloth[0].name;
			document.getElementById("ccprice").innerHTML = jsonObj.Cloth[0].price;
			document.getElementById("ccbrand").innerHTML = jsonObj.Cloth[0].brand;
			document.getElementById("ccdiscount").innerHTML = jsonObj.Cloth[0].discount;
			document.getElementById("ccsurplus").innerHTML = jsonObj.Cloth[0].surplus;
		}
	}
}

function updatekucun(cid) {
	createXMLHttpRequest();

	var num = prompt("请输入添加的数量", "");
	xmlHttp.onreadystatechange = updatekucuncall;
	xmlHttp.open("post", "/MicroClothesShop/servlet/UpdateKuCun");
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=UTF-8");

	xmlHttp.send("cid=" + cid + "&num=" + num);

}

function updatekucun1() {
	createXMLHttpRequest();
	var cid = document.getElementById("radioss").value;
	var num = prompt("请输入添加的数量", "");
	xmlHttp.onreadystatechange = updatekucuncall;
	xmlHttp.open("post", "/MicroClothesShop/servlet/UpdateKuCun");
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	xmlHttp.send("cid=" + cid + "&num=" + num);

}

function updatekucuncall() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			alert("添加成功！");
		}
	}
}







// 绘制饼图
function drawCircle(canvasId, data_arr, color_arr, text_arr) {
	var c = document.getElementById(canvasId);
	var ctx = c.getContext("2d");

	var radius = c.height / 2 - 20; // 半径
	var ox = radius + 20, oy = radius + 20; // 圆心

	var width = 30, height = 10; // 图例宽和高
	var posX = ox * 2 + 20, posY = 30; //  
	var textX = posX + width + 5, textY = posY + 10;

	var startAngle = 0; // 起始弧度
	var endAngle = 0; // 结束弧度
	for ( var i = 0; i < data_arr.length; i++) {
		// 绘制饼图
		endAngle = endAngle + data_arr[i] * Math.PI * 2; // 结束弧度
		ctx.fillStyle = color_arr[i];
		ctx.beginPath();
		ctx.moveTo(ox, oy); // 移动到到圆心
		ctx.arc(ox, oy, radius, startAngle, endAngle, false);
		ctx.closePath();
		ctx.fill();
		startAngle = endAngle; // 设置起始弧度

		// 绘制比例图及文字
		ctx.fillStyle = color_arr[i];
		ctx.fillRect(posX, posY + 20 * i, width, height);
		ctx.moveTo(posX, posY + 20 * i);
		ctx.font = 'bold 12px 微软雅黑'; // 斜体 30像素 微软雅黑字体
		ctx.fillStyle = color_arr[i]; // "#000000";
		var percent = text_arr[i] + "：" + 100 * data_arr[i] + "%";
		ctx.fillText(percent, textX, textY + 20 * i);
	}
}

function init() {
	// 绘制饼图
	// 比例数据和颜色
	var data_arr = [ 0.2, 0.25, 0.25, 0.3 ];
	var color_arr = [ "#00FF21", "#FFAA00", "#00AABB", "#FF4400" ];
	var text_arr = [ "第一季度", "第二季度", "第三季度", "第四季度" ];

	drawCircle("canvas_circle", data_arr, color_arr, text_arr);
}

// 页面加载时执行init()函数
// window.onload = init;

// 画柱状图
// chart sample data
var arrVisitors = new Array();
arrVisitors[0] = "星期一, 7500";
arrVisitors[1] = "星期二, 4250";
arrVisitors[2] = "星期三, 9600";
arrVisitors[3] = "星期四, 7000";
arrVisitors[4] = "星期五, 8000";
arrVisitors[5] = "星期六, 9750";
arrVisitors[6] = "星期日, 3750";
var canvas;
var context;
// chart properties
var cWidth, cHeight, cMargin, cSpace;
var cMarginSpace, cMarginHeight;
// bar properties
var bWidth, bMargin, totalBars, maxDataValue;
var bWidthMargin;
// bar animation
var ctr, numctr, speed;
// axis property
var totLabelsOnYAxis;
// barchart constructor
function barChart() {
	canvas = document.getElementById('bchart');
	if (canvas && canvas.getContext) {
		context = canvas.getContext('2d');
	}
	chartSettings();
	drawAxisLabelMarkers();
	drawChartWithAnimation();
}
// initialize the chart and bar values
function chartSettings() {
	// chart properties
	cMargin = 25;
	cSpace = 60;
	cHeight = canvas.height - 2 * cMargin - cSpace;
	cWidth = canvas.width - 2 * cMargin - cSpace;
	cMarginSpace = cMargin + cSpace;
	cMarginHeight = cMargin + cHeight;
	// bar properties
	bMargin = 15;
	totalBars = arrVisitors.length;
	bWidth = (cWidth / totalBars) - bMargin;
	// find maximum value to plot on chart
	maxDataValue = 0;
	for ( var i = 0; i < totalBars; i++) {
		var arrVal = arrVisitors[i].split(",");
		var barVal = parseInt(arrVal[1]);
		if (parseInt(barVal) > parseInt(maxDataValue))
			maxDataValue = barVal;
	}
	totLabelsOnYAxis = 10;
	context.font = "10pt Garamond";

	// initialize Animation variables
	ctr = 0;
	numctr = 100;
	speed = 10;
}
// draw chart axis, labels and markers
function drawAxisLabelMarkers() {
	context.lineWidth = "2.0";
	// draw y axis
	drawAxis(cMarginSpace, cMarginHeight, cMarginSpace, cMargin);
	// draw x axis
	drawAxis(cMarginSpace, cMarginHeight, cMarginSpace + cWidth, cMarginHeight);
	context.lineWidth = "1.0";
	drawMarkers();
}
// draw X and Y axis
function drawAxis(x, y, X, Y) {
	context.beginPath();
	context.moveTo(x, y);
	context.lineTo(X, Y);
	context.closePath();
	context.stroke();
}
// draw chart markers on X and Y Axis
function drawMarkers() {
	var numMarkers = parseInt(maxDataValue / totLabelsOnYAxis);
	context.textAlign = "right";
	context.fillStyle = "#000";
	;
	// Y Axis
	for ( var i = 0; i <= totLabelsOnYAxis; i++) {
		markerVal = i * numMarkers;
		markerValHt = i * numMarkers * cHeight;
		var xMarkers = cMarginSpace - 5;
		var yMarkers = cMarginHeight - (markerValHt / maxDataValue);
		context.fillText(markerVal, xMarkers, yMarkers, cSpace);
	}
	// X Axis
	context.textAlign = 'center';
	for ( var i = 0; i < totalBars; i++) {
		arrval = arrVisitors[i].split(",");
		name = arrval[0];
		markerXPos = cMarginSpace + bMargin + (i * (bWidth + bMargin))
				+ (bWidth / 2);
		markerYPos = cMarginHeight + 10;
		context.fillText(name, markerXPos, markerYPos, bWidth);
	}
	context.save();
	// Add Y Axis title
	context.translate(cMargin + 10, cHeight / 2);
	context.rotate(Math.PI * -90 / 180);
	context.fillText('销售额', 0, 0);
	context.restore();
	// Add X Axis Title
	context.fillText('星期名称', cMarginSpace + (cWidth / 2), cMarginHeight + 30);
}
function drawChartWithAnimation() {
	// Loop through the total bars and draw
	for ( var i = 0; i < totalBars; i++) {
		var arrVal = arrVisitors[i].split(",");
		bVal = parseInt(arrVal[1]);
		bHt = (bVal * cHeight / maxDataValue) / numctr * ctr;
		bX = cMarginSpace + (i * (bWidth + bMargin)) + bMargin;
		bY = cMarginHeight - bHt - 2;
		drawRectangle(bX, bY, bWidth, bHt, true);
	}
	// timeout runs and checks if bars have reached
	// the desired height; if not, keep growing
	if (ctr < numctr) {
		ctr = ctr + 1;
		setTimeout(arguments.callee, speed);
	}
}
function drawRectangle(x, y, w, h, fill) {
	context.beginPath();
	context.rect(x, y, w, h);
	context.closePath();
	context.stroke();
	if (fill) {
		var gradient = context.createLinearGradient(0, 0, 0, 300);
		gradient.addColorStop(0, 'green');
		gradient.addColorStop(1, 'rgba(67,203,36,.15)');
		context.fillStyle = gradient;
		context.strokeStyle = gradient;
		context.fill();
	}
}

function startload() {
	init();
	barChart();
}
