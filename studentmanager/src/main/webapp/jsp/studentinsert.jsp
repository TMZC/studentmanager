<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
	function checkForm(){
		var id=document.getElementById("id").value;
		var name=document.getElementById("name").value;
		var sex=document.getElementById("sex").value;
		var age=document.getElementById("age").value;
		var grade=document.getElementById("grade").value;
		var score=document.getElementById("score").value;
		
		
		if(id==""||name==""||sex==""||age==""||grade==""||score==""){
			document.getElementById("error").innerHTML="信息填写不完整！";
			return false;
		}
		
		return true;
	}
	
</script>
  <head>

    <title>新增学生信息</title>
    
  </head>
  
  <body>
  
 <center>
		<h1>插入学生信息</h1>
		<img src="" height="180" width="150" >
			<form action="../InsertStudentservlet.do" method="post" enctype="multipart/form-data"  onsubmit="return checkForm()">
				<p>学号: <input type="text" name="id"  id="id" ></p>
				<p>姓名:
				<input type="text" name="name" id="name" "/>
				<br></p>
				<p>性别:
				<input type="text" name="sex" id="sex"/>
				<br></p>
                <p> 年龄:
				<input type="text" name="age" id="age"/>
				<br></p>
                <p>  班级:
				<input type="text" name="grade" id="grade"/>
				<br></p>
                <p>  成绩:
				<input type="text" name="score" id="score"/>
				<br></p>
				<input type="file"  name="avatar" accept="image/*">
				<script>
  var fileInput = document.querySelector('input[type=file]'),
          previewImg = document.querySelector('img');
  fileInput.addEventListener('change', function () {
      var file = this.files[0];
      // 限制图片大小为2MB
      var maxFileSize =1024 * 1024;
      
      if (file.size < maxFileSize) {
      var reader = new FileReader();
      // 监听reader对象的的onload事件，当图片加载完成时，把base64编码賦值给预览图片
      reader.addEventListener("load", function () {
          previewImg.src = reader.result;
      }, false);
      // 调用reader.readAsDataURL()方法，把图片转成base64
      reader.readAsDataURL(file);
    return}
      else {
        document.querySelector('input[type=file]').value = null;
          alert('选择的文件太大了，请选择小于2MB的文件');
          return;
      }
  }, false);
</script><br>
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</form>
			<font id="error" color="red">${error }</font>
     </center>
  </body>
</html>
