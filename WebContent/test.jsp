<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.dinner.gts.model.Note,java.util.List"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>NO</th>
			</tr>
			<s:iterator value="#request.noteList">
				<tr>
					<td><s:property value="noteId" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>