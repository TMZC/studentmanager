<%@ page language="java" import="java.util.*,dbutil.*,entity.*,model.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
    <meta charset="utf-8" />
    <title>excel导入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    
    <script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script> 
</head>
<body>
    <div class="container">
        <!-- <h2 class="text-center mt-4 mb-4">Convert Excel to HTML Table using JavaScript</h2> -->
        <div>
            <div class="card-header"><b>请选择Excel文件</b><a href="uploads/Student.xlsx">模板</a></div>
            <div class="card-body">
                
                
        <form action="XLSFile" enctype="multipart/form-data" method="post">
            <input type="file" name="file"  accept=".xlsx,.xls;" />
            <input type="submit" value="上传Excel"><a href="ListStudentServlet.do">返回学生列表</a>
        </form>
            </div>
        </div>
        <!-- <div id="excel_data"></div> -->
    </div>
    <div>
    <c:if test="${not empty usersList}">
    <table width="600"  border="1" style="border-collapse: collapse;">
				<thead>
					<tr>
					<th>id</th>
					<th>name</th>
					<th>sex</th>
					<th>grade</th>
					<th>age</th>
					<th>score</th>
					<th>fileName</th>
					<th></th>
					
					</tr>
				</thead>
				<tbody align="center" >
				<c:forEach  varStatus="i" var="u" items="${usersList }">
					<tr>
						<td>${u.id }</td>
						<td>${u.name }</td>
						<td>${u.sex }</td>
						<td>${u.grade}</td>
						<td>${u.age }</td>
						<td>${u.score }</td>
						<td>${u.fileName }</td>
						<td>${u.zt}</td>
						
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
			</c:if>
			</div>
</body>
</html>

