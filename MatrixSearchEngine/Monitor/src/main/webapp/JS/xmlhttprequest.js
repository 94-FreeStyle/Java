var xmlHttp = null;
function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (ee) {
				xmlHttp = false;
			}
		}
	} else if (window.XMLHttpRequest) {
		try {
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			xmlHttp = false;
		}
	}
}
