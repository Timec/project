<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<html>
<head>
<title><decorator:title default="Spring-SiteMesh" /></title>
<link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0"/>
<style type="text/css">
@-ms-viewport{width:device-width;}
@-o-viewport{width:device-width;}
@viewport{width:device-width;}
</style>
<script type="text/javascript" src="/js/jquery-2.2.1.min.js"></script>
<decorator:head />
</head>
<body>
	<!-- warp -->
	<div id="container">
		<!-- header -->
		<div class="main_title" width="100%">
			Chincook
		</div>

		<!-- contents -->
		<div width="100%">
			<decorator:body />
			<!-- footer -->
			<div width="100%">
				Footer
<%-- 				<decorator:footer /> --%>
			</div>
		</div>
	</div>
	
</body>
</html>