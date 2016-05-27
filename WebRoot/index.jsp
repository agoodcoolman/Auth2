<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
  </head>
  
 
  
  <body>
    This is my JSP page. <br>
     <script >
  	function sendPush() {
  		
  		$.post("sendpush.do?");
  		
  	}
  	
  	function sendmessage() {
  		$.post("txtmessage.do?");
  	}
  	
  	function sendformmessage() {
  		var usernames = $("#username").val();
  		var contents = $("#content").val();
  		var ids = $("#ids").val();
  		var fkdh = $("#fkdh").val();
  		var data = {username:usernames, content:contents};
  		
  		// $.post("txtmessage.do?", {username:"police002", content:"gege"}, null, "json");
  		$.ajax({
                  type: "POST",
                  url:"txtmessage.do?",
                  contentType: "application/json",
                  data:JSON.stringify({
                      username:        usernames,
                      content:         contents,
                      id: 			   ids,
                      fkdh:			   fkdh
                      })
                });
  	}
  </script>
    <button type="button" onclick="sendPush()">send</button></br>
    <h2> ${message}</h2>
    
    <form  method="post">
    	name:<input type="text" name="username" id="username" /><br/>
		content:<input type="text" name="content" id="content"/><br/>
		id:<input type="text" name="ids" id="ids">
		fkdh:<input type="text" name="fkdh" id="fkdh">
		<input type="submit" value="sendformmessage()" onclick="sendformmessage()"/>
    </form>
    </br></br></br></br>
    <button type="button" onclick="sendmessage()">message</button>
    
  </body>
</html>
