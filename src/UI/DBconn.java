package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implDao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class DBconn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField load;
	private JTextField user;
	private JPasswordField password;
	mainUi m=new mainUi();
	personnel p=new personnel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBconn dialog = new DBconn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBconn() {
		setTitle("Database\u9023\u7DDA\u7CFB\u7D71");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 204, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DataBase\u9023\u7DDA\u767B\u5165");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(149, 10, 136, 35);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8DEF\u5F91\uFF1A");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 59, 46, 15);
		contentPanel.add(lblNewLabel_1);
		
		load = new JTextField();
		load.setText("jdbc:mysql://localhost:3306/build?useUnicode=true&characterEncoding=utf8");
		load.setBounds(52, 56, 372, 21);
		contentPanel.add(load);
		load.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4F7F\u7528\u8005\uFF1A");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 101, 56, 35);
		contentPanel.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setFont(new Font("新細明體", Font.PLAIN, 12));
		user.setBounds(76, 108, 96, 21);
		contentPanel.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u5BC6\u78BC\uFF1A");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 156, 56, 35);
		contentPanel.add(lblNewLabel_2_1);
		
		password = new JPasswordField();
		password.setFont(new Font("新細明體", Font.PLAIN, 12));
		password.setColumns(10);
		password.setBounds(76, 163, 96, 21);
		contentPanel.add(password);
		
		JTextPane show = new JTextPane();
		show.setForeground(Color.RED);
		show.setText("\u9810\u8A2D\u4F7F\u7528\u8005\uFF1Aroot\r\n\u9810\u8A2D\u5BC6\u78BC\uFF1A1234");
		show.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		show.setBounds(251, 121, 136, 55);
		contentPanel.add(show);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 204, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton sure = new JButton("\u78BA\u8A8D");
				sure.addMouseListener(new MouseAdapter() {
					@Override
					public  void mouseClicked(MouseEvent arg0) {
						/*String creA="CREATE TABLE `build`.`build_home` (\r\n"
								+ "  `build_A_id` INT NOT NULL AUTO_INCREMENT,\r\n"
								+ "  `build_A_name` VARCHAR(45) NULL,\r\n"
								+ "  `build_A_man` VARCHAR(45) NULL,\r\n"
								+ "  `build_A_worker` VARCHAR(45) NULL,\r\n"
								+ "  `build_A_work` VARCHAR(45) NULL,\r\n"
								+ "  `build_safe` TINYINT NULL,\r\n"
								+ "  `build_A_remind` LONGTEXT NULL,\r\n"
								+ "  PRIMARY KEY (`build_A_id`))\r\n"
								+ "ENGINE = InnoDB\r\n"
								+ "DEFAULT CHARACTER SET = utf8;";
						String creB="CREATE TABLE `build`.`build_vendor` (\r\n"
								+ "  `build_B_id` INT NOT NULL AUTO_INCREMENT,\r\n"
								+ "  `build_B_name` VARCHAR(45) CHARACTER SET 'utf8' NULL,\r\n"
								+ "  `build_B_editor` VARCHAR(45) NULL,\r\n"
								+ "  `build_B_date` VARCHAR(45) NULL,\r\n"
								+ "  `build_B_service` VARCHAR(45) NULL,\r\n"
								+ "  `build_B_unitprice` DOUBLE NULL,\r\n"
								+ "  `build_B_quantity` DOUBLE NULL,\r\n"
								+ "  `build_B_discount` DOUBLE NULL,\r\n"
								+ "  `build_B_sum` DOUBLE NULL,\r\n"
								+ "  `build_B_cooperation` VARCHAR(45) CHARACTER SET 'utf8' NULL,\r\n"
								+ "  `build_B_arrears` VARCHAR(45) NULL,\r\n"
								+ "  `build_B_remind` VARCHAR(45) NULL,\r\n"
								+ "  PRIMARY KEY (`build_B_id`))\r\n"
								+ "ENGINE = InnoDB\r\n"
								+ "DEFAULT CHARACTER SET = utf8;";
						String creP="CREATE TABLE `build`.`personnel` (\r\n"
								+ "  `presonnel_id` INT NOT NULL AUTO_INCREMENT,\r\n"
								+ "  `personnel_name` VARCHAR(45) CHARACTER SET 'utf8' NULL,\r\n"
								+ "  `personnel_password` VARCHAR(45) NULL,\r\n"
								+ "  PRIMARY KEY (`presonnel_id`))\r\n"
								+ "ENGINE = InnoDB\r\n"
								+ "DEFAULT CHARACTER SET = utf8;";*/
						if(user.getText().equals("root")&&password.getText().equals("1234")) 
						{
							Connection conn=implDao.getDB();
							p.setVisible(true);
							dispose();
							/*try {//->新增表單Table
								PreparedStatement as=conn.prepareStatement(creA);
								as.executeUpdate();
								PreparedStatement bs=conn.prepareStatement(creB);
								bs.executeUpdate();
								PreparedStatement ps=conn.prepareStatement(creP);
								ps.executeUpdate();
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/
							
							
						}
						else 
						{
							show.setText("資料庫連線失敗\n請重新輸入資料");
						}
					}
				});
				sure.setActionCommand("OK");
				buttonPane.add(sure);
				getRootPane().setDefaultButton(sure);
			}
			{
				JButton out = new JButton("\u9000\u51FA");
				out.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				out.setActionCommand("Cancel");
				buttonPane.add(out);
			}
		}
	}
}
