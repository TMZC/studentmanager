package control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Student;
import model.StudentModel;

public class Insertservlet extends HttpServlet {

	public Insertservlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=0;
 		String name = "";
		String sex = "";
		int age =0 ;
		String grade = "";
		float score = 0;
		String fileName = "";
		String ext = "";
		

		// 处理文件上传
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    List<FileItem> items;
		try {
			items = upload.parseRequest(request);
			
		

	    String avatarFilePath = null;

	    for (FileItem item : items) {
	        if (item.isFormField()) {
	        	// 处理表单字段
	        	
	            if ("id".equals(item.getFieldName())) {
	                id = Integer.parseInt(item.getString("UTF-8"));
	                System.out.print(id+"\t");
	            } else if ("name".equals(item.getFieldName())) {
	            	name = item.getString("UTF-8");
	            	System.out.print(name+"\t");
	            }else if ("sex".equals(item.getFieldName())) {
	            	sex = item.getString("UTF-8");
	            	System.out.print(sex+"\t");
	            }else if ("age".equals(item.getFieldName())) {
	            	age = Integer.parseInt(item.getString("UTF-8"));
	            	System.out.print(age+"\t");
	            }else if ("grade".equals(item.getFieldName())) {
	            	grade = item.getString("UTF-8");
	            	System.out.print(grade+"\t");
	            }else if ("score".equals(item.getFieldName())) {
	            	score = Float.parseFloat(item.getString("UTF-8"));
	            	System.out.print(score+"\t");
	            }
	        } else {
	            // 处理文件上传
	            fileName = item.getName();
	            ext = fileName.substring(fileName.lastIndexOf("."),fileName.length());
	   
	            if (!fileName.isEmpty()) {
	                String uploadPath = getServletContext().getRealPath("/") + "uploads/";
	                File uploadDir = new File(uploadPath);
	                if (!uploadDir.exists()) {
	                    uploadDir.mkdir();
	                }
	                fileName = String.valueOf(id)+ext;
	                File uploadedFile = new File(uploadPath + fileName);
	                item.write(uploadedFile);
	                avatarFilePath = "uploads/" + fileName;
	                System.out.println("原："+item.getName()+"\t改后"+fileName+"\t");
	                System.out.println("图片保存的路径："+uploadPath+fileName);
	            }
	        }
	        
	    }
	    
	      
	     

 		StudentModel model = new StudentModel();
	    Student student = model.load(id);
	   
		if (null==student)
		{
			
	 	    int a = model.insert(id, name, sex, age, grade, score,fileName);System.out.println(a);
	 	    response.sendRedirect("ListStudentServlet.do");
		}else {
			
			request.setAttribute("error", "该学号存在！！");
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}
     		

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	}


