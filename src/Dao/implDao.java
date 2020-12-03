package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JLabel;

public interface implDao {
	
	//�s�u��SQL
	static Connection getDB() 
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/build?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("�s�����\");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn ;
	}
	
	
	//�s�W��ƨ�SQL_A
	void add_A(Object o);
	//�s�W��ƨ�SQL_B
	void add_B(Object o);
	//�d�ߥ������SQL_A
	String queryAll_A();
	//�d�ߥ������SQL_B
	String queryAll_B();
	//�d�߳浧���SQL_A
	Object queryA(Integer Id);
	//�d�߳浧���SQL_B
	Object queryB(Integer Id);
	//�����SQL_A
	void update_A(Integer Id,Object o);
	//�����SQL_B
	void update_B(Integer Id,Object o);
	//�R�����SQL_A
	void deleted_A(Integer Id);
	//�R�����SQL_B
	void deleted_B(Integer Id);
	//�ץXSQL_A��ƨ�PDF
	//�ץXSQL_B��ƨ�PDF
	
	
	//�s�W���u�b��
	void addp(Object o);
	//�T�{���u�b��
	boolean checkp(String pname);
	//�ɶ�-��
	String timeDay();
	//�ɶ�-��
	void timeRun(JLabel i);
	/*�Q��timer�o�ӥ\��
	 * �bjava.swing�̭���timer*/
	
	//�q��Ʈw�����ƨ�table
	String showAll_A(javax.swing.JTable p1);
	
}
