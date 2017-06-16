var fOrgaName;

var sOrgaName;

var ptName;
var pt;

var pName;
var p;

function getSorga(fOrgaName)
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 	alert("Ie6");
	}
	xmlhttp.onreadystatechange = function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("sOrganizationName").innerHTML = "";
			var sorgaSelection = xmlhttp.responseText;
			var option = sorgaSelection.split(";");
			var i;
			for(i=0;i<option.length;i++)
			{
				var op = document.createElement('option');
				op.innerHTML = option[i];
				se = document.getElementById("sOrganizationName");
				se.appendChild(op);
			}
		}
	}
	xmlhttp.open("POST","GetSelectionServlet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("organizationName="+fOrgaName+"&t="+Math.random());
}

function getTorga(sOrgaName)
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 	alert("Ie6");
	}
	xmlhttp.onreadystatechange = function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("tOrganizationName").innerHTML = "";
			var torgaSelection = xmlhttp.responseText;
			var option = torgaSelection.split(";");
			var i;
			for(i=0;i<option.length;i++)
			{
				var op = document.createElement('option');
				op.innerHTML = option[i];
				se = document.getElementById("tOrganizationName");
				se.appendChild(op);
			}
		}
	}
	xmlhttp.open("POST","GetSelectionServlet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("organizationName="+sOrgaName+"&t="+Math.random());
}

function getPt(ptName,pt)
{
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 	alert("Ie6");
	}
	xmlhttp.onreadystatechange = function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("postType").innerHTML = "";
			var torgaSelection = xmlhttp.responseText;
			var option = torgaSelection.split(";");
			var i;
			for(i=0;i<option.length;i++)
			{
				var op = document.createElement('option');
				op.innerHTML = option[i];
				se = document.getElementById("postType");
				se.appendChild(op);
			}
		}
	}
	xmlhttp.open("POST","GetSelectionServlet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("organizationName="+ptName+"&pt="+pt+"&t="+Math.random());
}

function getP(pName,p)
{
	var xmlhttp;
	var tOrgaName = document.getElementById("tOrganizationName").value;
	if (window.XMLHttpRequest)
	{
		xmlhttp=new XMLHttpRequest();
	}
	else
	{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 	alert("Ie6");
	}
	xmlhttp.onreadystatechange = function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("postName").innerHTML = "";
			var torgaSelection = xmlhttp.responseText;
			var option = torgaSelection.split(";");
			var i;
			for(i=0;i<option.length;i++)
			{
				var op = document.createElement('option');
				op.innerHTML = option[i];
				se = document.getElementById("postName");
				se.appendChild(op);
			}
		}
	}
	xmlhttp.open("POST","GetSelectionServlet",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("organizationName="+pName + "&tOrganizationName=" + tOrgaName + "&pt="+p+"&t="+Math.random());
}
