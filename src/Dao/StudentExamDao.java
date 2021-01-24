package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modell.StudentExam;


public class StudentExamDao {
	private static String DB_NAME = "management_student10";
    private static String DB_URL = "jdbc:mysql://localhost:3306/";
    private static String USER_NAME = "root";
    private static String PASSWORD = "215487467hg";
	 
	public static Connection getConnection() throws Throwable {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = (Connection) DriverManager.getConnection(DB_URL + DB_NAME, USER_NAME, PASSWORD);
	            return connection;
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            throw new Throwable("Can't create connection");
	        }
	}
	public static List<StudentExam> getData(String optionSort) {
		List<StudentExam> listStudentExams = new ArrayList<StudentExam>(); 
		StudentExam studentExam ;
		String query = " SELECT * FROM management_student10.student ;";
		if(optionSort.equals("Sắp xếp theo giới tính")) {
			query = " SELECT * FROM management_student10.student ORDER BY gioitinh ASC ;"; 
		}
		if (optionSort.equals("Sắp xếp theo khu vực")) {
			query = " SELECT * FROM management_student10.student ORDER BY khuvuc ASC;"; 
		} 
		if(optionSort.equals("Sắp xếp theo đối tượng")){
			query = " SELECT * FROM management_student10.student ORDER BY doituong ASC ;"; 
		}
		try {
			Connection connection = getConnection();
			Statement statement = ((java.sql.Connection) connection).createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
               int id = resultSet.getInt("id"); 
               String hoten = resultSet.getString("hoten"); 
               String gioitinh = resultSet.getString("gioitinh"); 
               String ngaysinh = resultSet.getString("ngaysinh"); 
               String diachi = resultSet.getString("diachi"); 
               int diemcong = resultSet.getInt("diemcong"); 
               String truongTH = resultSet.getString("truongTH"); 
               String truongCS = resultSet.getString("truongCS");
               String phongthi = resultSet.getString("phongthi"); 
               String cumthi = resultSet.getString("cumthi"); 
               float diemvan = resultSet.getFloat("van"); 
               float diemtoan = resultSet.getFloat("toan"); 
               float diemanh = resultSet.getFloat("anh"); 
               studentExam = new StudentExam(id, hoten, diachi, diemcong, truongCS, truongTH, ngaysinh, gioitinh, cumthi, phongthi, diemanh, diemtoan, diemvan) ;
               listStudentExams.add(studentExam); 
            }
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return listStudentExams; 
	}
	public static int insertData(StudentExam studentExam) {
		int result = 0; 
		 try {
	            Connection connection = getConnection();
	            String query = "insert into management_student10.student(hoten,  diachi,diemcong, truongCS, truongTH	, van,"
	            		+ "anh, toan, ngaysinh, gioitinh, phongthi, cumthi) values( ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?);";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, studentExam.getHoten());
	            preparedStatement.setString(2, studentExam.getDiachi());
	            preparedStatement.setFloat(3, studentExam.getDiemcong());
	            preparedStatement.setString(4, studentExam.getTruongCS());
	            preparedStatement.setString(5, studentExam.getTruongTH());
	            preparedStatement.setFloat(6,studentExam.getDiemvan());
	            preparedStatement.setFloat(7, studentExam.getDiemanh());
	            preparedStatement.setFloat(8,studentExam.getDiemtoan());
	            preparedStatement.setString(9, studentExam.getNgaysinh());
	            preparedStatement.setString(10, studentExam.getGioitinh());
	            preparedStatement.setString(11, studentExam.getPhongthi());
	            preparedStatement.setString(12, studentExam.getCumthi());
	            result = preparedStatement.executeUpdate();
	            System.out.println(result);
	        } catch (Throwable throwable) {
	            throwable.printStackTrace();
	        }
		 return result;
	}
	public static int delete(int id) {
		int result = 0; 
		 try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String query = "delete from management_student10.student where id=" + id + ";";
            System.out.println(query);
            result = statement.executeUpdate(query);
            
        }catch (Throwable e){
            e.printStackTrace();
        }
        return result;
	}
	public static int update(StudentExam studentExam) {
		int result = 0; 
		 try {
	            Connection connection = getConnection();
	            String query = "update  management_student10.student set hoten = ?,  diachi =?,diemcong =? , truongCS =?, truongTH=?	, van=?,"
	            		+ "anh = ?, toan =?, ngaysinh=?, gioitinh=?, phongthi=?, cumthi=? where id = ?;";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, studentExam.getHoten());
	            preparedStatement.setString(2, studentExam.getDiachi());
	            preparedStatement.setFloat(3, studentExam.getDiemcong());
	            preparedStatement.setString(4, studentExam.getTruongCS());
	            preparedStatement.setString(5, studentExam.getTruongTH());
	            preparedStatement.setFloat(6,studentExam.getDiemvan());
	            preparedStatement.setFloat(7, studentExam.getDiemanh());
	            preparedStatement.setFloat(8,studentExam.getDiemtoan());
	            preparedStatement.setString(9, studentExam.getNgaysinh());
	            preparedStatement.setString(10, studentExam.getGioitinh());
	            preparedStatement.setString(11, studentExam.getPhongthi());
	            preparedStatement.setString(12, studentExam.getCumthi());
	            preparedStatement.setInt(13, studentExam.getId());
	            result = preparedStatement.executeUpdate();
	            System.out.println(result);
	        } catch (Throwable throwable) {
	            throwable.printStackTrace();
	        }
		 return result;
	}
}
