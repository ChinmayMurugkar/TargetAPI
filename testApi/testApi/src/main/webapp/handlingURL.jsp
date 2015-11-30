<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL Handler</title>
</head>
<body>
<h1>Using GET Method to Read Form Data</h1>
<ul>
<li><p><b>Get the Data For Product ID:</b>
   <a href=<%="\"http://localhost:8080/testApi/api/webservice/products/"+request.getParameter("productID")+"\""%> class="link2" target="_blank">Get Data for Product ID : <%= request.getParameter("productID")%> </a>
</p></li>
</ul>
</body>
</html>