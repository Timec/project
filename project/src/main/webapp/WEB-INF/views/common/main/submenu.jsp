<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="cmm_menu"/>

<script type="text/javascript">
//<![CDATA[
	function goMenu(url, cmd){
		document.frmsub.action = '<%=contextPath%>/'+url;
		document.frmsub.cmd.value = cmd;
		document.frmsub.submit();
	}
//]]>
</script>
<form name="frmsub" method="post" >
	<input type="hidden" id="cmd" name="cmd" value="${cmd}" />
	<input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	<input type="hidden" id="gridLoadingFunc" name="gridLoadingFunc" value="${gridLoadingFunc}" />
	<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
		<c:forEach var="i" items="${sicc_menu}">
			<c:choose>
				<c:when test="${i.menu_lvl == 0 }">
					<tr>
						<td class="P_menu">${i.menu_nm}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td class="S_menu"><a href="javascript:;" onclick="javascript:{goMenu('<spring:url value="${i.control_id}"/>', '<spring:url value="${i.control_kind}"/>')};">${i.menu_nm}</a></td>
					</tr>
					<tr><td height="1" bgcolor="#f4f3f4"></td></tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<tr><td height="7" bgcolor="#f4f3f4" colspan="2"></td></tr>
        <tr><td height="1" class="top_color" colspan="2"></td></tr>
	</table>
<!-- 	<ul> -->
<%-- 		<c:forEach var="i" items="${sicc_menu}"> --%>
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${i.menu_lvl == 0 }"> --%>
<%-- 					<li>${i.menu_nm}</li> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<%-- 					<li><a href="javascript:;" onclick="javascript:{goMenu('<spring:url value="${i.control_id}"/>', '<spring:url value="${i.control_kind}"/>')};">${i.menu_nm}</a></li> --%>
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
</form>