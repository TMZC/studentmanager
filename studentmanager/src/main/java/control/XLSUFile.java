package control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;






import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;


import entity.Student;
import jxl.Cell;
import jxl.Workbook;


/**
 * Servlet implementation class File
 */
@WebServlet("/XLSFile")
public class XLSUFile extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		File file = null;
		response.setContentType("text/html;charset=UTF-8");
		try
		{
			FileItemFactory factory = new DiskFileItemFactory();
			// 文件上传核心工具类
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(10*1024*1024);	// 单个文件大小限制
			upload.setSizeMax(50*1024*1024);		// 总文件大小限制
			upload.setHeaderEncoding("UTF-8");		// 对中文文件编码处理
			
			if (ServletFileUpload.isMultipartContent(request)) 
			{
				// 3. 把请求数据转换为list集合
				List<FileItem> list = upload.parseRequest(request);
				// 遍历
				for (FileItem item : list)
				{
					// 判断：普通文本数据
					if (item.isFormField())
					{
						//普通表单项操作
					} 
					// 文件表单项
					else 
					{
						// a. 获取文件名称
						String name = item.getName();
						// b. 得到上传目录
						String basePath = getServletContext().getRealPath("/");
						// c. 创建要上传的文件对象
						//String basePath = "f:\\";
						file = new File(basePath,name);
						// d. 上传
						item.write(file);
						
						item.delete();  // 删除组件运行时产生的临时文件
						ArrayList<Student> stus=dbutil.ExcelTest.readExcel(basePath+name);

						
						for (Student s:stus) {
	                        System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getSex()+"\t"+s.getAge()+"\t"+s.getGrade()+"\t"+s.getScore()+"\t"+s.getFileName());
	                        //model.insert(u.getId(),u.getName(),u.getPassword());
	                    }
						request.setAttribute("usersList", stus);
						request.getRequestDispatcher("excel.jsp").forward(request, response);
						
					 

				}
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request,response);
	}
}
