<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" name="baidu-tc-cerfication" src="http://apps.bdimg.com/cloudaapi/lightapp.js#db7b160e2d6af1fdb90696f3ff5777cf"></script><script type="text/javascript">window.bd && bd._qdc && bd._qdc.init({app_id: '374d7174ba704f17afbbae84'});</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./pubjs/bootstrap-3.0.3-dist/dist/css/bootstrap.min.css">
<style type="text/css">
	      .textTitle
	      {
	         line-height:30px;
	         vertical-align:middle;
	      }
	      .text_title_cut{
	      	text-overflow:ellipsis; /*ellipsis是省略号,还有别的可以选*/
			white-space:nowrap;
			overflow:hidden;
	      }
	      .list_group_margin
	      {
	      	margin-bottom:10px;
	      }
</style>
<title>ReadRead</title>
</head>
<body onload="init()">
	<br>
  <div class="container">
<div class="list-group list_group_margin">
  <a href="#" class="list-group-item" id="a_article_id_0">
    <h4 class="list-group-item-heading text_title_cut" id="h_article_id_0">
    	
    </h4>
    <p class="list-group-item-text" id="p_article_id_0">
    	
    </p>
  </a>
  <a href="#" class="list-group-item" id="a_article_id_1">
    <h4 class="list-group-item-heading text_title_cut" id="h_article_id_1">
    	
    </h4>
    <p class="list-group-item-text" id="p_article_id_1">
    	
    </p>
  </a>
  <a href="#" class="list-group-item" id="a_article_id_2">
    <h4 class="list-group-item-heading text_title_cut" id="h_article_id_2">
    	
    </h4>
    <p class="list-group-item-text" id="p_article_id_2">
    	
    </p>
  </a>
  <a href="#" class="list-group-item" id="a_article_id_3">
    <h4 class="list-group-item-heading text_title_cut" id="h_article_id_3">
    	
    </h4>
    <p class="list-group-item-text" id="p_article_id_3">
    	
    </p>
  </a>
  
  <a href="#" class="list-group-item" id="a_article_id_4">
    <h4 class="list-group-item-heading text_title_cut" id="h_article_id_4">
    	
    </h4>
    <p class="list-group-item-text" id="p_article_id_4">
    	
    </p>
  </a>
</div>
	<button type="button" class="btn btn-default btn-block" onclick="gotoInsert()">我要分享 </button>
</div>
<script src="./pubjs/cStorage/cStorage.min.js"></script>
<script type="text/javascript" >
	var myStorage = cst.use("myStorage");
	var lisArticel = '';
	var jsonArticel = myStorage.get("lisArticel");
	var cacheLoacleDate = myStorage.get("loacleDate");
	var myDate = new Date();
	var loacleDate = myDate.toLocaleDateString();
	
	function init(){
	
	if(jsonArticel==''||jsonArticel==undefined || loacleDate==''||loacleDate==undefined||cacheLoacleDate!=loacleDate){
		getDate();
		}
	
	var objArticel = JSON.parse(jsonArticel);
	for(var i=0;i<objArticel.length;i++){
		var strContent = objArticel[i].content;
		var strTitle = objArticel[i].title;
		if(strContent.length>40){
			strContent = strContent.substring(0,40)+"...";
		}
		document.getElementById("h_article_id_"+i).innerHTML=strTitle;
		document.getElementById("p_article_id_"+i).innerHTML=strContent;
		document.getElementById("a_article_id_"+i).href="readAricle.jsp?articleKey="+objArticel[i].articleKey;
	}
	}
	function gotoInsert(){
		 window.location.href="insertAricle.jsp"; 
	}
	function getDate(){
		request = new XMLHttpRequest();
		request.open('POST', 'aricleRead.jsp', false);
		 
		request.onreadystatechange = function() {
		  if (this.readyState === 4){
		    if (this.status >= 200 && this.status < 400){
		      // Success!
		        lisArticel= this.responseText;
				//设置多个值
				myStorage.set("lisArticel",lisArticel);
				myStorage.set("loacleDate",loacleDate);
				jsonArticel = lisArticel;
		    } else {
		      // Error :(
		    }
		  }
		};
		request.send();
		request = null;
	}
</script>
</body>
</html>