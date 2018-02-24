<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript">
	function doSync(obj){
		obj.disabled=true;
		document.getElementById("syncForm").submit();
	}
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/sync/init.htm" method="post" id="syncForm">
		主数据库名称 ：<input type="text" value="acewill_muwu" name="master"/>
		从数据库名称：<input type="text" value="1207_" name="slaver"/>
		<input type="submit" value="对比" onclick="doSync(this)"/>
	</form>
</body>
</html>