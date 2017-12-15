<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    Tenants of ${name}.
    <table>
        <c:forEach items="${currentTenants}" var="item">
            <tr>
                <td><c:out value="${item}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@ include file="common/footer.jspf"%>
