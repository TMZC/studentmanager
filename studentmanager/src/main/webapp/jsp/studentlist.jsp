<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>ѧ����Ϣ�б�</title>

	</head>
	<body>
	<center>
			<table align="center" width="460" border="0">
			<tr>
				<td align="center">
					<h1>ѧ����Ϣ�б�</h1>
				</td>
				<td align="center">
				<a href="jsp/studentinsert.jsp">����</a>
				</td>
				<td align="center">
				<a href="excel.jsp">�ϴ�excel</a>
				</td>
				<td align="center">
				<a href="img.jsp">�ϴ�������Ƭ</a>
				</td>
			</tr>
		</table>
		<table align="center"  width="660" border="1" cellspacing="0" cellpadding="5" bordercolor="#000">
			<tr>
				<th width="50px">   ѧ��</th>
				<th width="100px">	���� </th>
				<th width="70px">	��Ƭ </th>
				<th width="50px">	�Ա�	</th>
				<th width="50px">	����	</th>
				<th width="150px">	�༶	</th>
				<th width="50px">	�ɼ�	</th>
				<th width="50px">	�޸�	</th>
				<th width="50px">	ɾ��	</th>
			</tr>
			<c:forEach var="studentitem" items="${studentlist}">
				<tr>
					<td >
						${studentitem.id}
					</td>
					<td >
						${studentitem.name}
					</td>
					<td >
					<img src="./uploads/${studentitem.fileName} " height="100" width="70" >
				
					</td>
					<td >
						${studentitem.sex}
					</td>
					<td >
						${studentitem.age}
					</td>
					<td >
						${studentitem.grade}
					</td>
					<td >
						${studentitem.score}
					</td>
					<td >
						<a href="UpdateStudentservlet.to?id=${studentitem.id}">�޸�</a>
					</td>
					<td >
						<a href="showStudent.do?id=${studentitem.id}">ɾ��</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</center>
	</body>
</html>

