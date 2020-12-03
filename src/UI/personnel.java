package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.Function;
import Dao.implDao;
import Model.Build_System;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class personnel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	mainUi m=new mainUi();
	Function f=new Function();
	Build_System b=new Build_System();
	private JTextField user;
	private JPasswordField password;
	private JTextField adduser;
	private JPasswordField addpassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			personnel dialog = new personnel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public personnel() {
		setTitle("\u54E1\u5DE5\u767B\u5165");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u54E1\u5DE5\u8EAB\u5206\u78BA\u8A8D");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			lblNewLabel.setBounds(155, 6, 123, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 127, 80));
			panel.setBounds(12, 50, 178, 168);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_2 = new JLabel("\u5E33\u865F");
				lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
				lblNewLabel_2.setForeground(new Color(0, 0, 128));
				lblNewLabel_2.setBounds(10, 10, 35, 20);
				panel.add(lblNewLabel_2);
			}
			{
				user = new JTextField();
				user.setBounds(10, 33, 121, 21);
				panel.add(user);
				user.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("\u5BC6\u78BC");
				lblNewLabel_2.setForeground(new Color(0, 0, 128));
				lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
				lblNewLabel_2.setBounds(10, 64, 35, 20);
				panel.add(lblNewLabel_2);
			}
			JLabel showLogin = new JLabel("");
			showLogin.setForeground(new Color(0, 0, 128));
			showLogin.setFont(new Font("微軟正黑體", Font.BOLD, 12));
			showLogin.setBounds(0, 153, 178, 15);
			panel.add(showLogin);
			
			password = new JPasswordField();
			password.setBounds(10, 90, 121, 21);
			panel.add(password);
			
			JButton login = new JButton("\u78BA\u8A8D");
			login.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Connection conn=implDao.getDB();
					if(user.getText().equals("")!=true&&password.getText().equals("")!=true) 
					{
						if(f.checkp(user.getText())) 
						{
							showLogin.setText("登入成功");
							m.setVisible(true);
							dispose();
						}else 
						{
							showLogin.setText("查無此員工,請註冊新員工帳號");
						}
							
					}
					else 
					{
						showLogin.setText("~~不可為空值~~");
					}
				}
			});
			login.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
			login.setBounds(44, 121, 66, 20);
			panel.add(login);
			
			
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(233, 150, 122));
			panel.setBounds(246, 50, 178, 168);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_2 = new JLabel("\u5E33\u865F");
				lblNewLabel_2.setForeground(new Color(0, 0, 128));
				lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
				lblNewLabel_2.setBounds(10, 10, 35, 20);
				panel.add(lblNewLabel_2);
			}
			{
				adduser = new JTextField();
				adduser.setColumns(10);
				adduser.setBounds(10, 33, 121, 21);
				panel.add(adduser);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("\u5BC6\u78BC");
				lblNewLabel_2.setForeground(new Color(0, 0, 128));
				lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
				lblNewLabel_2.setBounds(10, 64, 35, 20);
				panel.add(lblNewLabel_2);
			}
			{
				addpassword = new JPasswordField();
				addpassword.setBounds(10, 90, 121, 21);
				panel.add(addpassword);
			}
			JLabel showadd = new JLabel("");
			showadd.setForeground(new Color(25, 25, 112));
			showadd.setFont(new Font("微軟正黑體", Font.BOLD, 12));
			showadd.setBounds(0, 151, 178, 15);
			panel.add(showadd);
			{
				JButton add = new JButton("\u78BA\u8A8D");
				add.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(adduser.getText().equals("")!=true&&addpassword.getText().equals("")!=true) 
						{
							if(f.checkp(adduser.getText())) 
							{
								showadd.setText("~~帳號已存在~~");
							}
							else 
							{
								b=new Build_System(adduser.getText(),addpassword.getText());
								f.addp(b);
								showadd.setText("~~新增成功~~請重新登入~~");
								
							}
						}
						else 
						{
							showadd.setText("~~不可為空值~~");
						}
					}
				});
				add.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
				add.setBounds(63, 121, 66, 20);
				panel.add(add);
			}
			
			JLabel lblNewLabel_3 = new JLabel("\u65B0\u589E\u5340");
			lblNewLabel_3.setForeground(new Color(0, 128, 0));
			lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
			lblNewLabel_3.setBounds(132, 13, 46, 15);
			panel.add(lblNewLabel_3);
			{
				
			}
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u7B2C\u4E00\u6B21\u4F7F\u7528\u8ACB\u65B0\u589E\u54E1\u5DE5\u7DE8\u865F");
			lblNewLabel_1.setForeground(new Color(0, 128, 0));
			lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
			lblNewLabel_1.setBounds(268, 27, 154, 23);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 192, 203));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("\u9000\u51FA");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
