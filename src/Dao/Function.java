package Dao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.bind.annotation.XmlSchemaType.DEFAULT;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFName;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Statement;

import Model.Build_System;
import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Function implements implDao {
	
	private String[] columns = { "專案編號", "專案名稱", "專案負責人", "施工人數","施工工項","勞安宣導","備註" };
	private static Integer index;
	private String[][] data= {{},{},{}};
	private List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	
	public static void main(String[] args) {
		/*新增資料確認
		 * Build_System b=new Build_System("金城舞2","彭襄",25,"結構工程,室內裝修",true,"無");
		new Function().add_A(b);
		Build_System b=new Build_System("城拓規劃工程顧問","30643572","109/10/2","景觀",3000.0,60.0,0.85,"金城舞2",true,"無");
		new Function().add_B(b);*/
		//System.out.println( new Function().queryAll_A());
		//System.out.println(((Build_System)(new Function().queryB(5))).queryB1());
		/*Build_System b=new Build_System("六國景觀", "59875", "109/10/3", null, 100.0,22.0,0.95,"大洋",false,"無");
		new Function().update_B(3,b);*/
		/*Build_System b=new Build_System("榮昌水電","2345875","109/10/5","水電",500.0,100.0,0.9,"竹城甲子園",true,"近期進場");
		new Function().add_B(b);*/
		//Build_System b=new Build_System("wade","123456789");
		//System.out.println(new Function().userList());
		new Function().BtoExcel("wade");
		
	}

	@Override
	public void add_A(Object o) {
		String Acc="insert into build_home (build_A_name,build_A_man,build_A_worker,build_A_work,build_A_safe,build_A_remind) values(?,?,?,?,?,?)";
		Connection conn=implDao.getDB();
		Build_System p=(Build_System)o;
		try {
			PreparedStatement ps=conn.prepareStatement(Acc);
			ps.setString(1, p.getBuild_A_name());
			ps.setString(2,p.getBuild_A_man());
			ps.setInt(3, p.getBuild_A_worker());
			ps.setString(4,p.getBuild_A_work());
			ps.setBoolean(5,p.getBuild_A_safe());
			ps.setString(6,p.getBuild_A_remind());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void add_B(Object o) {
		String Acc="insert into build_vendor (build_B_name,build_B_editor,build_B_date,build_B_service,build_B_unitprice,build_B_quantity,build_B_discount,build_B_sum,build_B_cooperation,build_B_arrears,bUild_B_remind) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn=implDao.getDB();
		Build_System p=(Build_System)o;
		try {
			PreparedStatement ps=conn.prepareStatement(Acc);
			ps.setString(1,p.getBuild_B_name());
			ps.setString(2,p.getBuild_B_editor());
			ps.setDate(3,new java.sql.Date(Long.valueOf(p.getBuild_B_date().getTime())));
			ps.setString(4,p.getBuild_B_service());
			ps.setDouble(5,p.getBuild_B_unitprice());
			ps.setDouble(6,p.getBuild_B_quantity());
			ps.setDouble(7,p.getBuild_B_discount());
			ps.setDouble(8, p.getBuild_B_sum());
			ps.setString(9, p.getBuild_B_cooperation());
			ps.setBoolean(10, p.getBuild_B_arrears());
			ps.setString(11,p.getBuild_B_remind());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String queryAll_B() {
		Connection conn=implDao.getDB();
		String Acc="select*from build_vendor";
		String o="";
		try {
			PreparedStatement ps=conn.prepareStatement(Acc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				o=o+"廠商編號:"+rs.getInt("build_B_id")+"\u00a0廠商名稱:"+rs.getString("build_B_name")
				+"\u00a0廠商統編:"+rs.getString("build_B_editor")+"\u00a0進場日期:"+rs.getDate("build_B_date")
				+"\u00a0工項:"+rs.getString("build_B_service")+"\u00a0單價:"+rs.getDouble("build_B_unitprice")
				+"\n數量:"+rs.getDouble("build_B_quantity")+"\u00a0折扣:"+rs.getDouble("build_B_discount")
				+"\u00a0總和:"+rs.getDouble("build_B_sum")+"\u00a0合作專案:"+rs.getString("build_B_cooperation")
				+"\u00a0欠款紀錄:"+rs.getBoolean("build_B_arrears")+"\u00a0備註:"+rs.getString("build_B_remind")+"\n";
				//	iText會省略"\t"要用-->\u00a0替代
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public String queryAll_A() {
		Connection conn=implDao.getDB();
		String Acc="select*from build_home";
		String o="";
		try {
			PreparedStatement ps=conn.prepareStatement(Acc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				o=o+"專案編號:"+rs.getInt("build_A_id")+"\u00a0專案名稱:"+rs.getString("build_A_name")
				+"\u00a0專案負責人:"+rs.getString("build_A_man")+"\u00a0當日出工數:"+rs.getInt("build_A_worker")
				+"\u00a0工項:"+rs.getString("build_A_work")+"\n勞安檢查:"+rs.getBoolean("build_A_safe")
				+"\u00a0備註:"+rs.getString("build_A_remind")+"\n";
				//	iText會省略"\t"要用-->\u00a0替代
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public Object queryA(Integer Id) {
		String Acc="select*from build_home where build_A_id=?";
		Connection conn=implDao.getDB();
		Build_System b=null;
		try {
			PreparedStatement ps=conn.prepareStatement(Acc);
			ps.setInt(1,Id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			b=new Build_System(rs.getString("build_A_name"),
					rs.getString("build_A_man"),rs.getInt("build_A_worker")
					,rs.getString("build_A_work"),rs.getBoolean("build_A_safe")
					,rs.getString("build_A_remind"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Object queryB(Integer Id) {
		Connection conn=implDao.getDB();
		String Acc="select*from build_vendor where build_B_id=?";
		Build_System b=null;
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(Acc);
			ps.setInt(1,Id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			b=new Build_System(rs.getString("build_B_name"),rs.getString("build_B_editor")
					,rs.getDate("build_B_date"),rs.getString("build_B_service"),rs.getDouble("Build_B_unitprice")
					,rs.getDouble("build_B_quantity"),rs.getDouble("build_B_discount")
					,rs.getString("build_B_cooperation"),rs.getBoolean("build_B_arrears")
					,rs.getString("build_B_remind"));
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public void update_A(Integer Id, Object o) {
		String Acc="update build_home set build_A_name=?,build_A_man=?,build_A_worker=?,build_A_work=?,build_A_safe=?,build_A_remind=? where build_A_id=?";
		Connection conn=implDao.getDB();
		Build_System fn=(Build_System)o;
		Build_System fn2=(Build_System)new Function().queryA(Id);
		if(fn.getBuild_A_name().equals("")!=true)fn2.setBuild_A_name(fn.getBuild_A_name());
		if(fn.getBuild_A_man().equals("")!=true)fn2.setBuild_A_man(fn.getBuild_A_man());
		if(fn.getBuild_A_worker()!=null)fn2.setBuild_A_worker(fn.getBuild_A_worker());
		if(fn.getBuild_A_work().equals("")!=true)fn2.setBuild_A_work(fn.getBuild_A_work());
		if(fn.getBuild_A_safe()!=null)fn2.setBuild_A_safe(fn.getBuild_A_safe());
		if(fn.getBuild_A_remind().equals("")!=true)fn2.setBuild_A_remind(fn.getBuild_A_remind());
		try {
			PreparedStatement rs=conn.prepareStatement(Acc);
			rs.setString(1,fn2.getBuild_A_name());
			rs.setString(2,fn2.getBuild_A_man());
			rs.setInt(3,fn2.getBuild_A_worker());
			rs.setString(4,fn2.getBuild_A_work());
			rs.setBoolean(5,fn2.getBuild_A_safe());
			rs.setString(6,fn2.getBuild_A_remind());
			rs.setInt(7,Id);
			rs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update_B(Integer Id, Object o) {
		Connection conn=implDao.getDB();
		String Acc="update build_vendor set build_B_name=?,build_B_editor=?,Build_B_date=?,build_B_service=?,build_B_unitprice=?,build_B_quantity=?, build_B_discount=?,build_B_sum=?,build_B_cooperation=?,build_B_arrears=?, build_B_remind=? where build_B_id=?";
		Build_System fn=(Build_System)o;
		Build_System fn2=(Build_System)new Function().queryB(Id);
		/*SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String strDate = sdFormat.format(date);*/
		if(fn.getBuild_B_name().equals("")!=true)fn2.setBuild_B_name(fn.getBuild_B_name());
		if(fn.getBuild_B_editor().equals("")!=true)fn2.setBuild_B_editor(fn.getBuild_B_editor());
		if(fn.getBuild_B_date()!=null)fn2.setBuild_B_date(fn.getBuild_B_date());
		if(fn.getBuild_B_service().equals("")!=true)fn2.setBuild_B_service(fn.getBuild_B_service());
		if(fn.getBuild_B_unitprice()!=null)fn2.setBuild_B_unitprice(fn.getBuild_B_unitprice());
		if(fn.getBuild_B_quantity()!=null)fn2.setBuild_B_quantity(fn2.getBuild_B_quantity());
		if(fn.getBuild_B_discount()!=null)fn2.setBuild_B_discount(fn.getBuild_B_discount());
		if(fn.getBuild_B_cooperation().equals("")!=true)fn2.setBuild_B_cooperation(fn.getBuild_B_cooperation());
		if(fn.getBuild_B_arrears()!=false)fn2.setBuild_B_arrears(fn.getBuild_B_arrears());
		if(fn.getBuild_B_remind().equals("")!=true)fn2.setBuild_B_remind(fn.getBuild_B_remind());
		try {
			
			PreparedStatement ps=conn.prepareStatement(Acc);
			ps.setString(1,fn2.getBuild_B_name());
			ps.setString(2,fn2.getBuild_B_editor());
			ps.setDate(3, new java.sql.Date(Long.valueOf(fn2.getBuild_B_date().getTime())));
			ps.setString(4,fn2.getBuild_B_service());
			ps.setDouble(5,fn2.getBuild_B_unitprice());
			ps.setDouble(6,fn2.getBuild_B_quantity());
			ps.setDouble(7,fn2.getBuild_B_discount());
			ps.setDouble(8,fn2.getBuild_B_sum());
			ps.setString(9,fn2.getBuild_B_cooperation());
			ps.setBoolean(10,fn2.getBuild_B_arrears());
			ps.setString(11,fn2.getBuild_B_remind());
			ps.setInt(12,Id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleted_A(Integer Id) {
		Connection conn=implDao.getDB();
		String Acc="delete from build_home where build_A_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(Acc);
			ps.setInt(1,Id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleted_B(Integer Id) {
		Connection conn=implDao.getDB();
		String Acc="delete from build_vendor where build_B_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(Acc);
			ps.setInt(1,Id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String timeDay() {
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd-E");
		return s.format(d);
	}

	@Override
	public void timeRun(JLabel l) {
		Date dd;
		SimpleDateFormat ss;
		new javax.swing.Timer(0,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date d=new Date();
				SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss a");
				l.setText(s.format(d));
				
			}
		}).start();
	}

	@Override
	public void addp(Object o) {
		Connection conn=implDao.getDB();
		String SQL="insert into personnel (personnel_name,personnel_password)values(?,?)";
		Build_System b=(Build_System)o;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,b.getBuild_personname());
			ps.setString(2,b.getBuild_password());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean checkp(String pname) {
		Connection conn=implDao.getDB();
		boolean m=false;
		String SQL="select*from personnel where personnel_name=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,pname);
			ResultSet rs=ps.executeQuery();
			m=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public String showAll_A(JTable p1) {
		Connection conn=implDao.getDB();
		String s=null;
		String SQL="select*from build_home";
		DefaultTableModel df=new DefaultTableModel();
		df.setRowCount(0);
		Object[] col= {"專案編號","專案名稱","負責人","進場人數","工項","勞安宣導","備註"};
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData da=rs.getMetaData();
			//int col=da.getColumnCount();
			while(rs.next()) 
			{
				/*Object[] o= {rs.getInt("build_A_id"),rs.getString("build_A_name"),rs.getString("build_A_man"),rs.getInt("build_A_worker"),rs.getString("build_A_work")
								,rs.getBoolean("build_A_safe"),rs.getString("build_A_remind")};*/
				Object[] o= {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getShort(6),rs.getString(7)};
				df.addRow(o);
				TableRowSorter<DefaultTableModel> sorter=new TableRowSorter<>(df);
				p1.setRowSorter(sorter);
				/*Map<String,Object> rowData = new HashMap<String,Object>();
				for (int i = 1; i <= col; i++) {
					rowData.put(da.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	public ArrayList<Build_System> userList()
	{
		ArrayList<Build_System> userList=new ArrayList<>();
		Connection conn=implDao.getDB();
		String SQL="select*from build_home";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			Build_System user;
			
			while(rs.next()) 
			{
				user=new Build_System(rs.getString("build_A_name")
						,rs.getString("build_A_man"),rs.getInt("build_A_worker")
						,rs.getString("build_A_work"),rs.getBoolean("build_A_safe")
						,rs.getString("build_A_remind"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	public Object[][] toTable()
	{
		Connection conn=implDao.getDB();
		String SQL = "select * from build_home";
		Object[][] x=null;
		try {
			java.sql.Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(SQL);
			List<Object> o1=new ArrayList<Object>();
			while(rs.next()) 
			{
				o1.add(rs.getInt("build_A_id"));
				o1.add(rs.getString("build_A_name"));
				o1.add(rs.getString("build_A_man"));
				o1.add(rs.getInt("build_A_worker"));
				o1.add(rs.getString("build_A_work"));
				o1.add(rs.getBoolean("build_A_safe"));
				o1.add(rs.getString("build_A_remind"));
			}
			if(o1!=null&&o1.size()>0) 
			{
				Object[]o=new Object[o1.size()];
			for(int i=0;i<o1.size();i++) 
				{
				o[i]=o1.get(i);
				}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return x;
		
	}
	
	public void DocPDF_A(String oname,String ocon) throws IOException 
	{
		Document dc=new Document();
		File fi=new File("C://每日日報");
		fi.mkdir();
		 
		try {
			/*BaseFont bf=BaseFont.createFont("控制台\\外觀及個人化\\字型\\微軟正黑體" ,
			         BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
					 Font fontChinese = new Font(bf, 16 , Font.NORMAL);*/
			BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/MSJH.TTC,1",
					BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);  
			Font font = new Font(baseFont);   
			PdfWriter.getInstance(dc, new FileOutputStream("C:/每日日報/"+oname+".pdf"));
			dc.open();
			dc.add(new Paragraph(ocon,font));
			dc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DocPDF_B(String oname,String ocon) throws IOException 
	{
		Document dc=new Document();
		File fi=new File("C://廠商資料");
		fi.mkdir();
		 
		try {
			/*BaseFont bf=BaseFont.createFont("控制台\\外觀及個人化\\字型\\微軟正黑體" ,
			         BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
					 Font fontChinese = new Font(bf, 16 , Font.NORMAL);*/
			BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/MSJH.TTC,1",
					BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);  
			Font font = new Font(baseFont);   
			PdfWriter.getInstance(dc, new FileOutputStream("C:/廠商資料/"+oname+".pdf"));
			dc.open();
			dc.add(new Paragraph(ocon,font));
			dc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void BtoExcel(String finame) 
	{
		Connection conn=implDao.getDB();
		String SQL="select*from build_vendor";
		String[] title = {"廠商編號","廠商名稱","廠商統編","進場日期","承包工項","單價","數量","折扣","總和","合作專案","欠款紀錄","備註"};
		HSSFWorkbook book=new HSSFWorkbook();
		HSSFSheet sheet=book.createSheet("廠商資料");
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			File fi=new File("C://廠商資料");
			fi.mkdir();
			ResultSetMetaData rsmd=rs.getMetaData();
			int c=rsmd.getColumnCount();
			
			HSSFRow row0=sheet.createRow(0);//建立第一行
			for(int i=0;i<c;i++){
				HSSFCell cel=row0.createCell((short) i);//建立第一行的第i列
				cel.setCellValue(title[i]);
				//cel.setCellStyle(style);
			}
			int r=1;
			while(rs.next()){
				HSSFRow row=sheet.createRow(r++);//建立非第一行的其他行
				for(int i=0;i<c;i++){//仍然是c列，匯入第r行的第i列
					HSSFCell cel=row.createCell((short) i);
					//以下兩種寫法均可
					//cel.setCellValue(rs.getString(rsmd.getColumnName(i+1)));
					cel.setCellValue(rs.getString(i+1));
				}
			}
			//用檔案輸出流類建立名為table的Excel表格
			FileOutputStream out=new FileOutputStream("C:/廠商資料/"+finame+".xls");
			book.write(out);//將HSSFWorkBook中的表寫入輸出流中
			out.flush();
			out.close();
		} catch (SQLException | IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void AtoExcel(String finame) 
	{
		Connection conn=implDao.getDB();
		String SQL="select*from build_home";
		String[]title= {"專案編號","專案名稱","負責人","進場人數","進行工項","勞安宣導","備註"};
		File fi=new File("C://每日日報");
		fi.mkdir();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();//->獲得資料庫資料
			HSSFWorkbook book=new HSSFWorkbook();//->創建一個Excel
			HSSFSheet sheet=book.createSheet("廠商資料");//->創造一個sheet
			int c=rsmd.getColumnCount();//->所獲取到的欄位數
			
			HSSFRow row1=sheet.createRow(0);//->創立第一列
			for(int i=0;i<c;i++) //->要小於資料庫欄位數
			{
				HSSFCell cell=row1.createCell((short) i);
				cell.setCellValue(title[i]);//->從自訂義的title找到值
			}
			
			int r=1;//->從第一列開始取值
			while(rs.next()) 
			{
				HSSFRow r2=sheet.createRow(r++);
				for(int x=0;x<c;x++) 
				{
					HSSFCell cel=r2.createCell((short) x);//->創造欄位
					cel.setCellValue(rs.getString(x+1));//->從SQL裡面撈值放進去Execl的欄位
					
				}
			}
			FileOutputStream output=new FileOutputStream("C:/每日日報/"+finame+".xls");//->定義Excel名稱
			book.write(output);//->寫在Excel裡面
			output.flush();
			output.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Aother(String finame) 
	{
		Connection conn=implDao.getDB();
		String SQL="select*from build_home";
		String[]title= {"專案編號","專案名稱","負責人","進場人數","進行工項","勞安宣導","備註"};
		File fi=new File("C://每日日報");
		fi.mkdir();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();//->獲得資料庫資料
			HSSFWorkbook book=new HSSFWorkbook();//->創建一個Excel
			HSSFSheet sheet=book.createSheet("廠商資料");//->創造一個sheet
			int c=rsmd.getColumnCount();//->所獲取到的欄位數
			
			HSSFRow row1=sheet.createRow(0);//->創立第一列
			for(int i=0;i<c;i++) //->要小於資料庫欄位數
			{
				HSSFCell cell=row1.createCell((short) i);
				cell.setCellValue(title[i]);//->從自訂義的title找到值
			}
			
			int r=1;//->從第一列開始取值
			while(rs.next()) 
			{
				HSSFRow r2=sheet.createRow(r++);
				for(int x=0;x<c;x++) 
				{
					HSSFCell cel=r2.createCell((short) x);//->創造欄位
					cel.setCellValue(rs.getString(x+1));//->從SQL裡面撈值放進去Execl的欄位
				}
			}
			FileOutputStream output=new FileOutputStream(finame);//->定義Excel名稱
			book.write(output);//->寫在Excel裡面
			output.flush();
			output.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
