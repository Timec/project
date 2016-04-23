<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Notice Edit</title>
<script type="text/javascript">
//<![CDATA[
    $(document).ready(function(){
    	var frm = document.NoticeVO;
    	
    	if(frm.cmd.value == 'edit'){
	    	dataLoad();
    	}
    		
    	$('#reg').click(function(){
    		onSave();
    	});
    });
    
    function dataLoad(){
    	var frm = document.NoticeVO;
    	var me = this;
    	$.ajax({
    		url: "http://localhost:8080/notice/detailData/view",
    		type : 'GET',
    		dataType: 'json',
    		data:{bbs_id:frm.bbs_id.value, cn_id:frm.cn_id.value},
    		success: function(data, textStatus, jqXHR){
    			frm.title.value = data.title;
    			frm.content.value = data.content;
    	    },
    	    error: function (jqXHR, textStatus, errorThrown){
    	    	alert(jqXHR);
    	    }
   		});
    }
    
	function onSave(){
		var frm = document.NoticeVO;
		var cmd = frm.cmd.value;
		
		$("#NoticeVO").submit(function(e){
		    var postData = $(this).serializeArray();
		    var formURL = '';
		    if(cmd == 'edit'){
		    	formURL = 'http://localhost:8080/notice/detailData/update';
		    }else{
		    	formURL = 'http://localhost:8080/notice/detailData/insert';
		    }
		    $.ajax({
		        url : formURL,
		        type: "POST",
		        data : postData,
		        success:function(data, textStatus, jqXHR) 
		        {
		            alert(1);
		        },
		        error: function(jqXHR, textStatus, errorThrown) 
		        {
		            alert(222);
		        }
		    });
		    e.preventDefault();
		});
		 
		$("#NoticeVO").submit();
	}
    
	function onDetail(){
		alert('list click');
	}
//]]>
</script>
</head>
<body>
<form:form commandName="NoticeVO" name="NoticeVO" method="POST">
<form:hidden path="cmd"/>
<form:hidden path="bbs_id"/>
<form:hidden path="cn_id"/>
<div class="content">
	<form:input cssClass="title" path="title"/>
	<form:textarea cssClass="textarea" path="content"/>
</div>
<div class="button_area right">
	<span class="btn right" id="reg" name="reg">등록</span>
</div>

</form:form>
</body>
</html>