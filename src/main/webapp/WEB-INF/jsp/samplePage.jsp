<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title> Sample JSP Render </title>
</head>
<table>
<c:forEach var="item" items="${dbData}">
<tr>
    <td>${item.id}</td>
    <td>${item.description}</td>
</c:forEach>
</html>