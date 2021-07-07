<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jfc
  Date: 2019-04-22
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: jfc
  Date: 2019-04-22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<c:forEach var="g" items="${requestScope.games}">
<tr>
    <td>${g.name}</td><td>${g.year}</td><td>${g.price}</td>
</tr>
</c:forEach>

