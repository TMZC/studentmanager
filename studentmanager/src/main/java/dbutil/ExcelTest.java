package dbutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.*;
import model.*;

public class ExcelTest {

//    public static void main(String[] args) throws Exception {
//        String fileName = "C:\\Users\\ARHM\\Desktop\\11.xlsx";
//        readExcel(fileName);
//    }
	public static ArrayList<Student> readExcel(String fileNamee)
	{
		System.out.println(fileNamee);
		ArrayList<Student> stu = new ArrayList<>();
		StudentModel m = new StudentModel();

        Workbook workbook = null;
        Row row = null;
        //获取Excel文档
        workbook = getWorkbook(fileNamee);
        //获取Excel文档的第一个sheet页
        Sheet sheet = workbook.getSheetAt(0);
        //获取文档中已保存数据的行数
        int rowNum = sheet.getPhysicalNumberOfRows();
        //获取第一行
        row = sheet.getRow(0);
        //获取当前行已保存数据的最大列数
        int colnum = row.getPhysicalNumberOfCells();
        for (int i = 1; i < rowNum; i++) {
            row = sheet.getRow(i);//System.out.println("row--> "+row);
            if (null != row)
            {
                for (int j = 0; j < colnum;) {
                	Student s = new Student();
                    Cell id = row.getCell(j);
                    Cell name = row.getCell(j+1);
                    Cell sex = row.getCell(j+2);
                    Cell grade = row.getCell(j+4);
                    Cell age = row.getCell(j+3);
                    Cell score = row.getCell(j+5);
                    Cell fileName = row.getCell(j+6);
                	s.setId((int)id.getNumericCellValue());
                	s.setName((String)name.getRichStringCellValue().getString());
                	s.setSex((String)sex.getRichStringCellValue().getString());
                	s.setGrade((String)grade.getRichStringCellValue().getString());
                	s.setAge((int)age.getNumericCellValue());
                	s.setScore((float)score.getNumericCellValue());
                	s.setFileName((String)fileName.getRichStringCellValue().getString());
                	j=j+7;
                	int a = m.insert(s.getId(),s.getName(),s.getSex(),s.getAge(),s.getGrade(),s.getScore(),s.getFileName());
                	if(a==1)
                		s.setZt("导入成功");
                	else
                		s.setZt("导入失败，id重复");
                	stu.add(s);
                    
                	
                }
            }
        }
    
		return stu;
		
	
	}


    private static Workbook getWorkbook(String fileNamee) {//根据后缀获取Excel表格
        Workbook workbook = null;
        String suffix = fileNamee.substring(fileNamee.lastIndexOf(".") + 1);
        InputStream in = null;
        try {
            in = new FileInputStream(fileNamee);
            if ("xls".equals(suffix))
            {
                workbook = new HSSFWorkbook(in);
            }
            else if ("xlsx".equals(suffix))
            {
                workbook = new XSSFWorkbook(in);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
}