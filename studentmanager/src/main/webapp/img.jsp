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
            <div class="card-header"><b>请选择照片，可以选择多张照片</b></div>
            <div class="card-body">
                
                
        <form action="IMGFile" enctype="multipart/form-data" method="post">
            <input type="file" name="file"  accept="image/*" multiple/>
            <input type="submit" value="上传"><a href="ListStudentServlet.do">返回学生列表</a>
        </form>
            </div>
        </div>
        <!-- <div id="excel_data"></div> -->
    </div>
    <div>
    <c:if test="${not empty imgList}">
    <h4>${error }</h4>
    <table width="100"  border="" style="border-collapse: collapse;">
				<thead>
					<tr>
					<th width="10">照片名</th>
					<th width="90">照片</th>
					
					
					</tr>
				</thead>
				<tbody align="center" >
				<c:forEach  varStatus="i" var="u" items="${imgList }">
					<tr>
						<td>${u.url }</td>
						<td>
						<img src="./uploads/${u.url} " height="100" width="70" >
						</td>
					</tr>
				</c:forEach>
				
				</tbody>
			</table>
			</c:if>
			</div>
</body>
</html>

