<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertAttribute defaultValue="cmm.frame" flush="true">
	<tiles:putAttribute name="body-content" value="/WEB-INF/views/main.jsp"/>
</tiles:insertAttribute>