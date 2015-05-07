<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="playerTurnStatuses" scope= "request" type= "java.util.List<austinmckinley.pitboss.status.dataobjects.PlayerTurnStatus>"/>
<html>
<head>
<title>Status</title>

</head>
<body>
	<br>
	<div style="text-align: center">
        <h1>Player Statuses</h1>
	    <table>
            <c:forEach items="${playerTurnStatuses}" var="playerTurnStatus">
                <tr>
                    <td>${playerTurnStatus.getPlayerName()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${playerTurnStatus.isTurnFinished()}">
                                Turn Finished
                            </c:when>
                            <c:otherwise>
                                Turn Pending
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
	</div>
</body>
</html>