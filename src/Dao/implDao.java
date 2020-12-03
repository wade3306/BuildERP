package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JLabel;

public interface implDao {
	
	//連線到SQL
	static Connection getDB() 
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/build?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("連接成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn ;
	}
	
	
	//新增資料到SQL_A
	void add_A(Object o);
	//新增資料到SQL_B
	void add_B(Object o);
	//查詢全部資料SQL_A
	String queryAll_A();
	//查詢全部資料SQL_B
	String queryAll_B();
	//查詢單筆資料SQL_A
	Object queryA(Integer Id);
	//查詢單筆資料SQL_B
	Object queryB(Integer Id);
	//更改資料SQL_A
	void update_A(Integer Id,Object o);
	//更改資料SQL_B
	void update_B(Integer Id,Object o);
	//刪除資料SQL_A
	void deleted_A(Integer Id);
	//刪除資料SQL_B
	void deleted_B(Integer Id);
	//匯出SQL_A資料到PDF
	//匯出SQL_B資料到PDF
	
	
	//新增員工帳號
	void addp(Object o);
	//確認員工帳號
	boolean checkp(String pname);
	//時間-日
	String timeDay();
	//時間-分
	void timeRun(JLabel i);
	/*利用timer這個功能
	 * 在java.swing裡面的timer*/
	
	//從資料庫抽取資料到table
	String showAll_A(javax.swing.JTable p1);
	
}
