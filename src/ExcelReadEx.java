import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReadEx {
	public static void main(String[] args) throws FileNotFoundException {
		String spreadsheet = "DB/GradesDatabase6300-students.xlsx";
		ExcelReadEx test = new ExcelReadEx(spreadsheet);
		System.out.println(test.NumRowsCheck());
		HashSet<Student> studentList = test.getStudentRoster();
		for(Student std: studentList){
			System.out.println(std.getName());
		}
	}
	public class Student {
		String name;
		String gtid;
		//Grades grades;
		ExcelReadEx students;
		public Student() throws FileNotFoundException{
			String GRADES_DB = "DB/GradesDatabase6300-grades.xlsx";
			String STUDENTS_DB = "DB/GradesDatabase6300-students.xlsx";
			//grades = new Grades(GRADES_DB);
			students = new ExcelReadEx(STUDENTS_DB);
		}
		public String getName(){
			return this.name;
		}
		
		public String getGtid(){
			return this.gtid;
		}
		
		public int getAttendance(){		
			String gtidAtt = getGtid();
			int AttNum = 0; //grades.AttendanceCheck(gtidAtt);
			return AttNum;
		}
		
		public String getTeam(){
			String gtidAtt = getGtid();
			String TeamNumStr = students.TeamCheck(gtidAtt);
			return TeamNumStr;
		}
	}
	/*Much of the xlsx reading code was based on http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/ */
	FileInputStream file;
	XSSFWorkbook workbook;
	public ExcelReadEx(String studentsDb) throws FileNotFoundException {
		try {
			file = new FileInputStream(new File(studentsDb));
			//Get the workbook instance for XLS file 
			workbook = new XSSFWorkbook(file);			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public int NumRowsCheck(){ //Count Rows in 1st Spreadsheet
		//Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0); //StudentsInfo sheet
		int rowCount = 0;
		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		while(rowIterator.hasNext()) {
	        @SuppressWarnings("unused")
			Row row = rowIterator.next();
	        rowCount++;   
	    }
		return rowCount; 
	}
	
	public HashSet<Student> getStudentRoster(){
		HashSet <Student> studentList = new HashSet <Student>();
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next(); //Initializing iterator at 2nd row
		while(rowIterator.hasNext()) {
			Student currStudent;
			try {
				currStudent = new Student(); //Initializing student
				row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell = cellIterator.next(); //Name column
				if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
					currStudent.name = cell.getStringCellValue(); //Get name as str
				}
				cell = cellIterator.next(); //GTID column
				if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {//Get gtid as str
					int gtidInt = (int)cell.getNumericCellValue();
					currStudent.gtid = String.valueOf(gtidInt);
				}
				studentList.add(currStudent);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		return studentList;
	}
	
	public String TeamCheck(String gtidAtt) {
		XSSFSheet sheet = workbook.getSheetAt(1);
		//Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = sheet.iterator();
		Row row = rowIterator.next(); //Initializing iterator at 2nd row
		while(rowIterator.hasNext()) {
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell = cellIterator.next();
			if(cell.getCellType() == Cell.CELL_TYPE_STRING) {	
				String TeamNum = cell.getStringCellValue(); //Get TeamNo of curr row
				while(cellIterator.hasNext()){
					cell = cellIterator.next();
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {//Get gtid as str	
						String gtidStr = String.valueOf((int)cell.getNumericCellValue());
						if (gtidAtt.compareTo(gtidStr) == 0){
							return TeamNum;
						}
					}	
				}
			}
		}		
		return ""; //If gtid is not found, return empty string
	}
	

}
