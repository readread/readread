<%@ page language="java" contentType="text/html; charset=gbk"  pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./pubjs/bootstrap-3.0.3-dist/dist/css/bootstrap.min.css">
	<style type="text/css">
	      .textTitle
	      {
	         line-height:30px;
	         vertical-align:middle;
	      }
	      .button_width{
	      	width:38%;
	      }
	      .button_width_left{
	      	margin-left:1%;
	      }
	      .button_clear_width{
	      	width:20%;
	      }
	</style>
<title>ReadRead</title>
<%
String aricleKey = request.getParameter("articleKey");
%>
</head>
<body onload="init()">
    <h4 class="text-center list-group-item-heading textTitle">
    	ReadRead
    </h4>
    
<div class="container">
	<h4 id="h_title_id"></h4>
	<div class="list-group">
	    <p class="list-group-item-text" id="p_article_id">
	    </p>
	 </div>
	 <h6>
		<button id="button_home" type="button" class="btn btn-default btn-block"  onclick="goHome()">返回首页 </button>
	</h6>
</div>

<script src="./pubjs/cStorage/cStorage.min.js"></script>
<script type="text/javascript" >
	var myStorage = cst.use("myStorage");
	var jsonArticel = myStorage.get("lisArticel");
	var objArticel = JSON.parse(jsonArticel);
	
	function init(){
		onSelect("<%=aricleKey%>");
	}
	
	function onSelect(value){
		for(var i=0;i<objArticel.length;i++){
			if(objArticel[i].articleKey==value){
				document.getElementById("p_article_id").innerHTML=objArticel[i].content;
				document.getElementById("h_title_id").innerHTML=objArticel[i].title;
			}
		}
	}
	function goHome(){
		window.location.href="index.jsp";
	}
</script>
</body>
</html>