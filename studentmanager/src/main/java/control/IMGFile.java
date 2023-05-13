package control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Student;
import entity.img;


/**
 * Servlet implementation class IMGFile
 */
@WebServlet("/IMGFile")
public class IMGFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMGFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 处理文件上传
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    List<FileItem> items;
	    ArrayList<img> imgs = new ArrayList<>();
		try {
			items = upload.parseRequest(request);
			
		
			int sum=0;
	    String avatarFilePath = null;
	    for (FileItem item : items) {

	            // 处理文件上传
	            String fileName = item.getName();

	   
	            if (!fileName.isEmpty()) {sum++;
	                String uploadPath = getServletContext().getRealPath("/") + "uploads/";
	                File uploadDir = new File(uploadPath);
	                if (!uploadDir.exists()) {
	                    uploadDir.mkdir();
	                }
	                File uploadedFile = new File(uploadPath + fileName);
	                item.write(uploadedFile);
	                avatarFilePath = "uploads/" + fileName;
	                System.out.println("图片名："+fileName);
	                System.out.println("图片保存的路径："+uploadPath+fileName);
	                img i = new img();
	                i.setUrl(fileName);
	                imgs.add(i);
	                
	            }
	            
	        
	    }
	    request.setAttribute("imgList", imgs);
	    request.setAttribute("error", sum);
		request.getRequestDispatcher("img.jsp").forward(request, response);

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
