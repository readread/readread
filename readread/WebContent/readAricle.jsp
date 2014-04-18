<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
	      .lead {
			  margin-bottom: 20px;
			  font-size: 18px;
			  font-weight: 200;
			  line-height: 1.4;
		   }
			
		   @media (min-width: 768px) {
			  .lead {
			    font-size: 21px;
			  }
		   }
	</style>
<title>ReadRead</title>
<%
String aricleKey = request.getParameter("articleKey");
%>
</head>
<body onload="init()">
<br>
<div class="container">
	<select id="sec_title" class="form-control input-lg" onchange="onSelect(this.value)">
		<option id="option_0"></option>
		<option id="option_1"></option>
		<option id="option_2"></option>
		<option id="option_3"></option>
		<option id="option_4"></option>
	</select>
	<br>
	    <pre class="lead" id="p_article_id">
	    </pre>
	 <h6>
		<button id="button_home" type="button" class="btn btn-default btn-block"  onclick="goHome()">·µ»ØÊ×Ò³ </button>
	</h6>
</div>

<script src="./pubjs/cStorage/cStorage.min.js"></script>
<script type="text/javascript" >
	var myStorage = cst.use("myStorage");
	var jsonArticel = myStorage.get("lisArticel");
	var objArticel = JSON.parse(jsonArticel);
	
	function init(){
		for(var i=0;i<objArticel.length;i++){
			document.getElementById("option_"+i).value=objArticel[i].articleKey;
			document.getElementById("option_"+i).innerHTML=objArticel[i].title;
		}
		document.getElementById("sec_title").value="<%=aricleKey%>";
		onSelect("<%=aricleKey%>");
	}
	
	function onSelect(value){
		for(var i=0;i<objArticel.length;i++){
			if(objArticel[i].articleKey==value){
				document.getElementById("p_article_id").innerHTML=objArticel[i].content;
			}
		}
	}
	function goHome(){
		window.location.href="index.jsp";
	}
</script>
</body>
</html>