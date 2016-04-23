<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include/common.jsp"%>
<script type="text/javascript">
//<![CDATA[
    $(document).ready(function(){
//     	listLoad();
    	$('#search').click(function(){
    		listLoad();
    	});
    	$('#reg').click(function(){
    		onDetail();
    	});
    });
    
    function listLoad(){
    	var me = this;
    	$.ajax({
    		url: "http://localhost:8080/notice/listData/list",
    		type : 'GET',
    		dataType: 'json',
    		data:{},
    		success: function(data, textStatus, jqXHR){
    			$.each(data.list, function(idx, data){
    				console.log(idx,'-',data);
    				$('<li>',{
        				text:data.TITLE,
        				click: function() {
        					me.onDetail(data.BBS_ID, data.CN_ID);
        				}
        			}).appendTo('#list');
    			});
    	    },
    	    error: function (jqXHR, textStatus, errorThrown){
    	    	alert(jqXHR);
    	    }
   		});
    }
    
	function onDetail(bbs_id, cn_id){
		var frm = document.NoticeVO;
		var me = this;
		var url = '';
		
		if(bbs_id != undefined && bbs_id != null){
			frm.bbs_id.value = bbs_id;
			frm.cn_id.value = cn_id;
			url = 'http://localhost:8080/notice/detail/view';
		}else{
			url = 'http://localhost:8080/notice/detail/input';
		}
		
		frm.action = url;
		frm.submit();
	}
//]]>
</script>
<form:form commandName="NoticeVO" name="NoticeVO">
<form:hidden path="cmd"/>
<form:hidden path="bbs_id"/>
<form:hidden path="cn_id"/>
<!-- <div id="body"> -->
	<div class="right" id="button_header">
		<span class="btn" id="search" name="search">Search</span>
		<span class="btn" id="reg" name="reg">Regist</span>
	</div>
	<div id="list_area">
		<ul class="list" name="list" id="list">
		</ul>
	</div>
<!-- </div> -->
</form:form>
