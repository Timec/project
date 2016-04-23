<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<div class="right">
<img class="pointer" src="<%=contextImgPath%>/top4.gif" onclick="javascript:{changeLang('en');};"/>
<img class="pointer" src="<%=contextImgPath%>/top1.gif" onclick="javascript:{changeLang('ko');};"/>
<img class="pointer" src="<%=contextImgPath%>/top3.gif" onclick="javascript:{logout();};"/><br/>
</div>
<div class="top_color center">
<img class="pointer" src="<%=contextImgPath%>/sys.jpg" onclick="javascript:{goMain();};"/>
</div>

<!-- <a href="javascript:;" onclick="javascript:{changeLang('en');};">en</a> | -->
<!-- <a href="javascript:;" onclick="javascript:{changeLang('ko');};">ko</a> | -->
<!-- <a href="javascript:;" onclick="javascript:{logout();};">Logout</a>  -->

<script type="text/javascript">
//<![CDATA[
	function changeLang(lang){
		var frm;
		for(i=0;i<document.forms.length;i++){
			if(document.forms[i].name.toLowerCase().indexOf("vo") > -1){
				frm = document.forms[i];
				break;
			}
		}
		if(undefined == frm){
			frm = document.frmsub;
		}
		var input = document.createElement('input');
		input.setAttribute('type', 'hidden');
		input.setAttribute('name', 'lang');
		input.setAttribute('value', lang);
		frm.appendChild(input);
		
		frm.action = '/changeLocale';
// 		frm.lang.value = lang;
		frm.submit();
		
		//changeLocale?lang=en
		///changeLocale
<%-- 		document.frmsub.action = '<%=contextPath%>/'+url; --%>
// 		document.frmsub.cmd.value = cmd;
// 		document.frmsub.submit();
	}
	function logout(){
		document.frmsub.action = '/logout';
		document.frmsub.submit();
	}
	function goMain(){
		document.frmsub.action = '/';
		document.frmsub.submit();
	}
//]]>
</script>