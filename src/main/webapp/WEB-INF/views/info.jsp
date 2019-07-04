<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Evrika test work</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="card text-center">
        <div class="card-header">
            Evrika Test Work
        </div>
        <div class="card-body">
            <h4 class="card-title">Информация</h4>
            <div class="card-text">
                <p>Текущая дата компьютера: ${time}</p>
                <p>Имя компьютера: &quot;${name}&quot;</p>
                <p>Свободная память Java: ${freeJavaMemory} Мб</p>
                <p>Общая память Java: ${totalJavaMemory} Мб</p>
            </div>
            <a href="/" class="btn btn-primary btn-sm">Обновить</a>
        </div>
    </div>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
