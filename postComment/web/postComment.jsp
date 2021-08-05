<%-- 
    Document   : postCommet
    Created on : Jun 17, 2021, 12:24:11 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Comment</title>
    </head>
    <body>
        <c:forEach items="${listP}" var="p">
            +${p.contentPost}<br>
            <c:forEach items="${p.getCommentByPost()}" var="c">
                -${c.contentComment}<br>
            </c:forEach>
             <form action="wall" method="post">
            new comment for post ${p.idPost}
            <input type="text" name="ccontent" />
            <input type="hidden" name="pid" value="${p.idPost}" />
            <input type="submit" value="submit" />
        </form>
        </c:forEach>
    </body>
</html>
