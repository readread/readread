<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./pubjs/bootstrap-3.0.3-dist/dist/css/bootstrap.css">
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
</head>
<body onload="init()">
	<br>    
<div class="container">
	<input class="form-control " type="text" maxlength="16" placeholder="您的标题" id="title_id">
	<h6>
		<textarea class="form-control" rows="14" placeholder="您的分享内容" id="content" 
					onkeypress="return(this.value.length<2000)"  
                    onkeydown="textlen(this,2000)"   
                    onkeyup="textlen(this,2000)"   
                    onblur="maxtext(this,2000)" ></textarea>
    </h6>
	<button type="button" class="btn btn-default btn-lg button_width"  onclick="save()">分享 </button>
	<button id="button_temp_save" type="button" class="btn btn-default btn-lg button_width button_width_left"  onclick="tempSave()">暂存 </button>
	<button id="button_clear" type="button" class="btn btn-default btn-lg button_clear_width button_width_left"  onclick="doClear()">擦除 </button>
	<h6>
		<button id="button_home" type="button" class="btn btn-default btn-block"  onclick="goHome()">返回首页 </button>
	</h6>
</div>

<script src="./pubjs/jquery/jquery-1.11.0.min.js"></script>
<script src="./pubjs/cStorage/cStorage.min.js"></script>
<script type="text/javascript" >
	function tempSave(){
		var myStorage = cst.use("myStorage");
		var objArticel={};
		objArticel.title = $("#title_id").val();
		objArticel.content = $("#content").val();
		myStorage.set("tempArticel",objArticel);
		$("#button_temp_save").removeClass("btn-default").addClass("btn-success");
		setTimeout("changeClass()",300);
	}
	function changeClass(){
		$("#button_temp_save").removeClass("btn-success").addClass("btn-default");
	}
	function init(){
		var myStorage = cst.use("myStorage");
		var objArticel = myStorage.get("tempArticel");
		if(objArticel!=null&& objArticel!=undefined){
			$("#title_id").attr("value", objArticel.title); 
			document.getElementById("content").innerText=objArticel.content;
		}
		
	}
	function doClear(){
		document.getElementById("title_id").value="";
		document.getElementById("content").value="";
		var myStorage = cst.use("myStorage");
		myStorage.remove("tempArticel");
	}
	function goHome(){
		window.location.href="index.jsp";
	}
	function save(){
		if($("#title_id").val()==""){
			$("#title_id").focus();
			return;
		}else if($("#content").val()==""){
			$("#content").focus();
			return;
		}
		$.ajax({
			type: "POST",
			async:false,
			data:{title:$("#title_id").val(),content:$("#content").val()},
			url:'aricleInsert.jsp',
			success:function(data){
				alert("成功提交");
				var myStorage = cst.use("myStorage");
				myStorage.remove("tempArticel");
				goHome();
			}
			});
	}
	function textlen(x,y){  
		  var thelength = x.value.length;  
		  window.status=thelength+' of '+y+' maximum characters.';  
		}  
		  
	function maxtext(x,y){  
		tempstr = x.value;
	  if(tempstr.length>y){  
	    x.value = tempstr.substring(0,y);  
	  }  
	  	textlen(x,y);  
	}  
</script>
</body>
</html>