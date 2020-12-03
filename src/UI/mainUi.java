package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.io.*;
import org.junit.jupiter.api.Test;

import Dao.Function;
import Dao.implDao;
import Model.Build_System;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.activation.FileTypeMap;
import javax.naming.InitialContext;
import javax.sound.midi.MidiDevice.Info;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public  class mainUi extends JFrame {

	private JPanel contentPane;
	Calendar calender;
	SimpleDateFormat timeformat;
	JLabel timelabel = new JLabel();
	String time;
	FilefilterType filter=new FilefilterType();
	private JTextField build_A_name;
	private JTextField build_A_man;
	private JTextField build_A_worker;
	private JTextField build_A_work;
	Build_System b=new Build_System();
	Function f=new Function();
	
	private JTable table;
	private JTextField rep_A_id;
	private JTextField rep_A_name;
	private JTextField rep_A_man;
	private JTextField rep_A_worker;
	private JTextField rep_A_work;
	private JTextField del_A_id;
	private JTable show_rep_A;
	private AbstractTableModel model;
	private String[] columns = { "專案編號", "專案名稱", "專案負責人", "施工人數","施工工項","勞安宣導","備註" };
	private JTextField add_B_name;
	private JTextField add_B_editor;
	private JTextField add_B_service;
	private JTextField add_B_unitprice;
	private JTextField add_B_quan;
	private JTextField add_B_dis;
	private JTable showAll_B;
	private JTextField add_B_coon;
	private JTextField up_B_id;
	private JTextField up_B_name;
	private JTextField up_B_editor;
	private JTextField up_B_service;
	private JTextField up_B_disc;
	private JTextField up_B_quan;
	private JTextField up_B_conn;
	private JTextField up_B_unit;
	private JTextField del_B_id;
	private JTable sre_B_table;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainUi frame = new mainUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*public static java.sql.Date convert(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }*/
	
	/**
	 * @throws HeadlessException
	 */
	
	/**
	 * Create the frame.
	 */
	
	public mainUi() {
		
		setBackground(new Color(255, 255, 204));
		setTitle("\u71DF\u5EFA\u7CFB\u7D71");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(0, 0, 101, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton gohome = new JButton("日報資料");
		gohome.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		gohome.setBounds(10, 114, 87, 23);
		panel.add(gohome);
		
		JButton govendor = new JButton("\u5EE0\u5546\u7BA1\u7406");
		govendor.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		govendor.setBounds(10, 203, 87, 23);
		panel.add(govendor);
		
		JButton goout = new JButton("\u9000\u51FA");
		goout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		goout.setBounds(10, 412, 87, 43);
		panel.add(goout);
		
		JButton search_A = new JButton("\u65E5\u5831\u4FEE\u6539");
		search_A.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		search_A.setBounds(10, 158, 87, 23);
		panel.add(search_A);
		
		JButton search_B = new JButton("\u5EE0\u5546\u4FEE\u6539");
		
		search_B.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		search_B.setBounds(10, 250, 87, 23);
		panel.add(search_B);
		ImageIcon img = new ImageIcon(".\\src\\Img\\DbaiVddh.jpg");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 102));
		panel_1.setBounds(95, 0, 670, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u71DF\u9020\u7CFB\u7D71\u7BA1\u7406");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(273, 13, 118, 22);
		
		timelabel.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		timelabel.setBounds(500, 20, 164, 22);
		new Function().timeRun(timelabel);
		panel_1.add(timelabel);
		panel_1.add(lblNewLabel);
		
		JLabel DateLabel = new JLabel("");
		DateLabel.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		DateLabel.setBounds(500, 5, 135, 15);
		panel_1.add(DateLabel);
		DateLabel.setText(new Function().timeDay());
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(105, 48, 660, 433);
		contentPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
	
		
		JPanel home = new JPanel();
		home.setBackground(new Color(220, 220, 220));
		panel_2.add(home, "name_1213351416228300");
		home.setLayout(null);
		
	
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 255, 255));
		panel_3.setBounds(186, 119, 464, 20);
		home.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("\u5C08\u6848\u7DE8\u865F");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_5.setBounds(8, 5, 49, 15);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u5C08\u6848\u540D\u7A31");
		lblNewLabel_5_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(72, 5, 49, 15);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("\u8CA0\u8CAC\u4EBA");
		lblNewLabel_5_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_5_1_1.setBounds(137, 5, 39, 15);
		panel_3.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("\u4ECA\u65E5\u51FA\u5DE5\u6578");
		lblNewLabel_5_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_5_1_1_1.setBounds(198, 5, 59, 15);
		panel_3.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("\u5DE5\u9805");
		lblNewLabel_5_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_5_1_1_1_1.setBounds(278, 5, 39, 15);
		panel_3.add(lblNewLabel_5_1_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_2 = new JLabel("\u52DE\u5B89");
		lblNewLabel_5_1_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_5_1_1_1_2.setBounds(338, 5, 28, 15);
		panel_3.add(lblNewLabel_5_1_1_1_2);
		
		JLabel lblNewLabel_5_1_1_1_2_1 = new JLabel("\u5099\u8A3B");
		lblNewLabel_5_1_1_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_5_1_1_1_2_1.setBounds(397, 5, 28, 15);
		panel_3.add(lblNewLabel_5_1_1_1_2_1);
		
		table = new JTable();
		/*JScrollPane s=new  JScrollPane(table);
		s.setBounds(186, 113, 464, 310);
		s.setVisible(true);
		s.setLayout(null);
		s.setViewportView(table);
		home.add(s);*/
		table.setBounds(186, 140, 464, 289);
		home.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("\u65E5\u5831\u8CC7\u6599");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 9, 95, 20);
		home.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5C08\u6848\u540D\u7A31");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 38, 55, 15);
		home.add(lblNewLabel_2);
		
		build_A_name = new JTextField();
		build_A_name.setBounds(10, 57, 96, 21);
		home.add(build_A_name);
		build_A_name.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u5C08\u6848\u8CA0\u8CAC\u4EBA");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(126, 38, 68, 15);
		home.add(lblNewLabel_2_1);
		
		build_A_man = new JTextField();
		build_A_man.setColumns(10);
		build_A_man.setBounds(126, 57, 96, 21);
		home.add(build_A_man);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u7576\u65E5\u9032\u5834\u4EBA\u6578");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(245, 38, 81, 15);
		home.add(lblNewLabel_2_2);
		
		build_A_worker = new JTextField();
		build_A_worker.setColumns(10);
		build_A_worker.setBounds(245, 57, 96, 21);
		home.add(build_A_worker);
		
		JLabel lblNewLabel_3 = new JLabel("\u65BD\u5DE5\u5DE5\u9805");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_3.setBounds(357, 39, 55, 15);
		home.add(lblNewLabel_3);
		
		build_A_work = new JTextField();
		build_A_work.setBounds(357, 57, 96, 21);
		home.add(build_A_work);
		build_A_work.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u52DE\u5B89\u5BA3\u5C0E");
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(465, 39, 55, 15);
		home.add(lblNewLabel_3_1);
		
		JCheckBox build_A_safe = new JCheckBox("\u5DF2\u9032\u884C");
		build_A_safe.setBounds(465, 56, 75, 23);
		home.add(build_A_safe);
		
		JLabel lblNewLabel_2_3 = new JLabel("\u5099\u8A3B");
		lblNewLabel_2_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(10, 88, 46, 15);
		home.add(lblNewLabel_2_3);
		
		JTextPane build_A_remind = new JTextPane();
		build_A_remind.setBounds(10, 113, 150, 310);
		home.add(build_A_remind);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("\u9810\u89BD\u8CC7\u6599");
		lblNewLabel_2_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_2_3_1.setBounds(186, 88, 81, 15);
		home.add(lblNewLabel_2_3_1);
		
		JButton add_A = new JButton("\u65B0\u589E\u5B8C\u7562");
		
		add_A.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		add_A.setBounds(73, 84, 87, 23);
		home.add(add_A);
		
		JButton search_A_1 = new JButton("\u641C\u5C0B");
		search_A_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		search_A_1.setBounds(245, 85, 87, 23);
		home.add(search_A_1);
		
		JLabel keyword = new JLabel("");
		keyword.setHorizontalAlignment(SwingConstants.CENTER);
		keyword.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		keyword.setForeground(new Color(255, 51, 0));
		keyword.setBounds(534, 4, 125, 44);
		home.add(keyword);
		
		JTextArea query_A = new JTextArea();
		query_A.setBounds(186, 140, 464, 289);
		home.add(query_A);
		
		
		
		
		/*JComboBox comboBox = new JComboBox();
		comboBox.setBounds(357, 57, 105, 21);
		home.add(comboBox);
		comboBox.addItem("模板");
		comboBox.addItem("鋼筋");
		comboBox.addItem("鷹架");
		comboBox.addItem("門框");
		comboBox.addItem("室內牆");
		comboBox.addItem("土水抹壁");
		comboBox.addItem("石材");
		comboBox.addItem("水電");
		comboBox.addItem("防水");
		comboBox.addItem("打石");*/
		
		JPanel rep_A = new JPanel();
		panel_2.add(rep_A, "name_1253767983079400");
		rep_A.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\u4FEE\u6539\u65E5\u5831");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_4.setBounds(24, 10, 71, 29);
		rep_A.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("\u8F38\u5165\u7DE8\u865F");
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_6.setBounds(118, 14, 63, 21);
		rep_A.add(lblNewLabel_6);
		
		rep_A_id = new JTextField();
		rep_A_id.setBounds(177, 14, 41, 21);
		rep_A.add(rep_A_id);
		rep_A_id.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u5C08\u6848\u540D\u7A31");
		lblNewLabel_7.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_7.setBounds(24, 45, 63, 15);
		rep_A.add(lblNewLabel_7);
		
		rep_A_name = new JTextField();
		rep_A_name.setBounds(24, 64, 71, 21);
		rep_A.add(rep_A_name);
		rep_A_name.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("\u8CA0\u8CAC\u4EBA");
		lblNewLabel_7_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(110, 45, 63, 15);
		rep_A.add(lblNewLabel_7_1);
		
		rep_A_man = new JTextField();
		rep_A_man.setColumns(10);
		rep_A_man.setBounds(110, 64, 71, 21);
		rep_A.add(rep_A_man);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("\u9032\u5834\u4EBA\u6578");
		lblNewLabel_7_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_7_1_1.setBounds(193, 45, 63, 15);
		rep_A.add(lblNewLabel_7_1_1);
		
		rep_A_worker = new JTextField();
		rep_A_worker.setColumns(10);
		rep_A_worker.setBounds(193, 64, 71, 21);
		rep_A.add(rep_A_worker);
		
		JLabel lblNewLabel_7_1_2 = new JLabel("\u5DE5\u9805");
		lblNewLabel_7_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_7_1_2.setBounds(276, 45, 63, 15);
		rep_A.add(lblNewLabel_7_1_2);
		
		rep_A_work = new JTextField();
		rep_A_work.setColumns(10);
		rep_A_work.setBounds(276, 64, 107, 21);
		rep_A.add(rep_A_work);
		
		JLabel lblNewLabel_7_1_3 = new JLabel("\u52DE\u5B89");
		lblNewLabel_7_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_7_1_3.setBounds(393, 45, 63, 15);
		rep_A.add(lblNewLabel_7_1_3);
		
		JLabel lblNewLabel_7_1_4 = new JLabel("\u5099\u8A3B");
		lblNewLabel_7_1_4.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_7_1_4.setBounds(469, 45, 63, 15);
		rep_A.add(lblNewLabel_7_1_4);
		
		JButton up_A = new JButton("\u78BA\u8A8D\u66F4\u6539");
		
		up_A.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		up_A.setBounds(271, 13, 87, 23);
		rep_A.add(up_A);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u522A\u9664\u65E5\u5831");
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(24, 95, 71, 29);
		rep_A.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("\u8F38\u5165\u7DE8\u865F");
		lblNewLabel_6_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(118, 99, 63, 21);
		rep_A.add(lblNewLabel_6_1);
		
		del_A_id = new JTextField();
		del_A_id.setColumns(10);
		del_A_id.setBounds(177, 99, 41, 21);
		rep_A.add(del_A_id);
		
		JButton del_A = new JButton("\u78BA\u8A8D\u522A\u9664");
		
		del_A.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		del_A.setBounds(271, 98, 87, 23);
		rep_A.add(del_A);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("\u67E5\u8A62\u65E5\u5831");
		lblNewLabel_4_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_4_1_1.setBounds(24, 134, 71, 29);
		rep_A.add(lblNewLabel_4_1_1);
		
		JButton search_A_All = new JButton("\u67E5\u8A62");
	
		search_A_All.setBounds(118, 137, 71, 23);
		rep_A.add(search_A_All);
		
		JCheckBox rep_A_safe = new JCheckBox("\u78BA\u8A8D");
		rep_A_safe.setBounds(393, 63, 68, 23);
		rep_A.add(rep_A_safe);
		
		JLabel show_reach_A = new JLabel("");
		show_reach_A.setForeground(Color.RED);
		show_reach_A.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		show_reach_A.setBounds(455, 105, 195, 29);
		rep_A.add(show_reach_A);
		
		show_rep_A = new JTable();
		show_rep_A.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		show_rep_A.setBackground(new Color(255, 228, 181));
		show_rep_A.setBounds(24, 198, 626, 225);
		//JScrollPane scrollPane = new JScrollPane(show_rep_A);
	    /*add(scrollPane,BorderLayout.CENTER);
	    setLayout(new BorderLayout());
	    setLocationRelativeTo(null);*/
		Object[] col= {"專案編號", "專案名稱", "專案負責人", "施工人數","施工工項","勞安宣導","備註"};
	    rep_A.add(show_rep_A);
	    
	    
	    
	    JButton A_toPDF = new JButton("\u532F\u51FAPDF");
	    A_toPDF.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    A_toPDF.setBounds(455, 137, 87, 23);
	    rep_A.add(A_toPDF);
	    
	    JButton A_toExcel = new JButton("\u532F\u51FAExcel");
	  
	    A_toExcel.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    A_toExcel.setBounds(563, 137, 87, 23);
	    rep_A.add(A_toExcel);
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBackground(new Color(255, 140, 0));
	    panel_5.setBounds(24, 173, 626, 25);
	    rep_A.add(panel_5);
	    panel_5.setLayout(null);
	    
	    JLabel lblNewLabel_15 = new JLabel("專案編號");
	    lblNewLabel_15.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_15.setBounds(4, 5, 60, 15);
	    panel_5.add(lblNewLabel_15);
	    
	    JLabel lblNewLabel_15_1 = new JLabel("專案名稱");
	    lblNewLabel_15_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_15_1.setBounds(89, 5, 60, 15);
	    panel_5.add(lblNewLabel_15_1);
	    
	    JLabel lblNewLabel_15_2 = new JLabel("負責人");
	    lblNewLabel_15_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_15_2.setBounds(179, 5, 44, 15);
	    panel_5.add(lblNewLabel_15_2);
	    
	    JLabel lblNewLabel_15_3 = new JLabel("進場人數");
	    lblNewLabel_15_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_15_3.setBounds(269, 5, 60, 15);
	    panel_5.add(lblNewLabel_15_3);
	    
	    JLabel lblNewLabel_15_4 = new JLabel("進行工項");
	    lblNewLabel_15_4.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_15_4.setBounds(358, 5, 60, 15);
	    panel_5.add(lblNewLabel_15_4);
	    
	    JLabel lblNewLabel_15_5 = new JLabel("勞安宣導");
	    lblNewLabel_15_5.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_15_5.setBounds(445, 5, 60, 15);
	    panel_5.add(lblNewLabel_15_5);
	    
	    JLabel lblNewLabel_15_6 = new JLabel("備註");
	    lblNewLabel_15_6.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    lblNewLabel_15_6.setBounds(535, 5, 34, 15);
	    panel_5.add(lblNewLabel_15_6);
	    
	    JLabel filename = new JLabel("固定儲存位置為C://每日日報");
	    filename.setForeground(new Color(255, 0, 0));
	    filename.setFont(new Font("微軟正黑體", Font.BOLD, 12));
	    filename.setBounds(276, 139, 169, 21);
	    rep_A.add(filename);
	    
	    JTextPane rep_A_remind = new JTextPane();
	    rep_A_remind.setBackground(Color.WHITE);
	    rep_A_remind.setBounds(469, 64, 181, 41);
	    rep_A.add(rep_A_remind);
	    /*
	    JButton other = new JButton("其他位置");
	   
	    other.setBounds(563, 111, 87, 23);
	    rep_A.add(other);
	    
	    show_rep_A.setVisible(true);*/
		
		
		
		JPanel vendor = new JPanel();
		vendor.setBackground(new Color(169, 169, 169));
		panel_2.add(vendor, "name_1213344726286000");
		vendor.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("\u65B0\u589E\u5EE0\u5546\u8CC7\u6599");
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_8.setBounds(10, 10, 113, 33);
		vendor.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\u5EE0\u5546\u540D\u7A31");
		lblNewLabel_9.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9.setBounds(10, 48, 64, 15);
		vendor.add(lblNewLabel_9);
		
		add_B_name = new JTextField();
		add_B_name.setBounds(10, 68, 96, 21);
		vendor.add(add_B_name);
		add_B_name.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("\u5EE0\u5546\u7D71\u7DE8");
		lblNewLabel_9_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_1.setBounds(119, 48, 64, 15);
		vendor.add(lblNewLabel_9_1);
		
		add_B_editor = new JTextField();
		add_B_editor.setColumns(10);
		add_B_editor.setBounds(119, 68, 96, 21);
		vendor.add(add_B_editor);
		
		JLabel lblNewLabel_9_2 = new JLabel("\u9032\u5834\u65E5\u671F");
		lblNewLabel_9_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2.setBounds(225, 48, 64, 15);
		vendor.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("\u4E3B\u8981\u696D\u52D9");
		lblNewLabel_9_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1.setBounds(331, 48, 64, 15);
		vendor.add(lblNewLabel_9_2_1);
		
		add_B_service = new JTextField();
		add_B_service.setColumns(10);
		add_B_service.setBounds(331, 68, 96, 21);
		vendor.add(add_B_service);
		
		JLabel lblNewLabel_9_2_2 = new JLabel("\u55AE\u50F9");
		lblNewLabel_9_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_2.setBounds(10, 99, 40, 15);
		vendor.add(lblNewLabel_9_2_2);
		
		add_B_unitprice = new JTextField();
		add_B_unitprice.setColumns(10);
		add_B_unitprice.setBounds(10, 119, 40, 21);
		vendor.add(add_B_unitprice);
		
		JLabel lblNewLabel_10 = new JLabel("\u55AE\u4F4D");
		lblNewLabel_10.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_10.setBounds(56, 99, 40, 15);
		vendor.add(lblNewLabel_10);
		
		JComboBox add_B_1 = new JComboBox();
		add_B_1.setFont(new Font("微軟正黑體", Font.PLAIN, 10));
		add_B_1.setModel(new DefaultComboBoxModel(ed.values()));
		add_B_1.setBounds(56, 118, 81, 23);
		vendor.add(add_B_1);
		
		JLabel lblNewLabel_9_2_1_1 = new JLabel("\u6578\u91CF");
		lblNewLabel_9_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_1.setBounds(144, 99, 64, 15);
		vendor.add(lblNewLabel_9_2_1_1);
		
		add_B_quan = new JTextField();
		add_B_quan.setColumns(10);
		add_B_quan.setBounds(144, 119, 71, 21);
		vendor.add(add_B_quan);
		
		JLabel lblNewLabel_9_2_1_2 = new JLabel("\u6298\u6263");
		lblNewLabel_9_2_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_2.setBounds(225, 99, 40, 15);
		vendor.add(lblNewLabel_9_2_1_2);
		
		add_B_dis = new JTextField();
		add_B_dis.setColumns(10);
		add_B_dis.setBounds(225, 119, 96, 21);
		vendor.add(add_B_dis);
		
		JLabel lblNewLabel_9_2_1_2_1 = new JLabel("\u5099\u8A3B");
		lblNewLabel_9_2_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_2_1.setBounds(435, 48, 40, 15);
		vendor.add(lblNewLabel_9_2_1_2_1);
		
		JTextPane add_B_remind = new JTextPane();
		add_B_remind.setBounds(437, 68, 213, 72);
		vendor.add(add_B_remind);
		
		JButton add_B_go = new JButton("\u65B0\u589E");
		
		add_B_go.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		add_B_go.setBounds(563, 40, 87, 23);
		vendor.add(add_B_go);
		
		JButton querA_B = new JButton("\u67E5\u8A62\u6240\u6709");
		
		querA_B.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		querA_B.setBounds(10, 167, 87, 23);
		vendor.add(querA_B);
		
		showAll_B = new JTable();
		showAll_B.setBounds(10, 223, 640, 200);
		vendor.add(showAll_B);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 228, 181));
		panel_4.setBounds(10, 201, 640, 21);
		vendor.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("\u5EE0\u5546\u7DE8\u865F");
		lblNewLabel_11.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11.setBounds(2, 3, 59, 15);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_11_1 = new JLabel("\u5EE0\u5546\u540D\u7A31");
		lblNewLabel_11_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_1.setBounds(57, 4, 59, 15);
		panel_4.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("\u7D71\u7DE8");
		lblNewLabel_11_2.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_2.setBounds(110, 4, 32, 15);
		panel_4.add(lblNewLabel_11_2);
		
		JLabel lblNewLabel_11_3 = new JLabel("\u9032\u5834\u65E5\u671F");
		lblNewLabel_11_3.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_3.setBounds(161, 3, 59, 15);
		panel_4.add(lblNewLabel_11_3);
		
		JLabel lblNewLabel_11_4 = new JLabel("\u627F\u5305\u5DE5\u9805");
		lblNewLabel_11_4.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_4.setBounds(220, 4, 49, 15);
		panel_4.add(lblNewLabel_11_4);
		
		JLabel lblNewLabel_11_5 = new JLabel("\u55AE\u50F9");
		lblNewLabel_11_5.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_5.setBounds(277, 3, 32, 15);
		panel_4.add(lblNewLabel_11_5);
		
		JLabel lblNewLabel_11_6 = new JLabel("\u6578\u91CF");
		lblNewLabel_11_6.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_6.setBounds(323, 4, 32, 15);
		panel_4.add(lblNewLabel_11_6);
		
		JLabel lblNewLabel_11_7 = new JLabel("\u6298\u6263");
		lblNewLabel_11_7.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_7.setBounds(380, 3, 32, 15);
		panel_4.add(lblNewLabel_11_7);
		
		JLabel lblNewLabel_11_8_1 = new JLabel("\u5408\u4F5C\u5C08\u6848");
		lblNewLabel_11_8_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_8_1.setBounds(476, 3, 49, 15);
		panel_4.add(lblNewLabel_11_8_1);
		
		JLabel lblNewLabel_11_8_1_1 = new JLabel("\u6B20\u6B3E\u7D00\u9304");
		lblNewLabel_11_8_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_8_1_1.setBounds(534, 3, 49, 15);
		panel_4.add(lblNewLabel_11_8_1_1);
		
		JLabel lblNewLabel_11_8 = new JLabel("\u5099\u8A3B");
		lblNewLabel_11_8.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_8.setBounds(589, 3, 32, 15);
		panel_4.add(lblNewLabel_11_8);
		
		JLabel lblNewLabel_11_7_1 = new JLabel("\u7E3D\u50F9");
		lblNewLabel_11_7_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_7_1.setBounds(422, 4, 32, 15);
		panel_4.add(lblNewLabel_11_7_1);
		
		JLabel lblNewLabel_9_2_1_2_2 = new JLabel("\u5408\u4F5C\u5C08\u6848");
		lblNewLabel_9_2_1_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_2_2.setBounds(331, 99, 64, 15);
		vendor.add(lblNewLabel_9_2_1_2_2);
		
		
		JPanel rep_B = new JPanel();
		rep_B.setBackground(new Color(211, 211, 211));
		panel_2.add(rep_B, "name_1320500205017400");
		rep_B.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("\u5EE0\u5546\u8CC7\u6599\u66F4\u6539");
		lblNewLabel_12.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_12.setBounds(10, 10, 116, 30);
		rep_B.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("\u5EE0\u5546\u7DE8\u865F");
		lblNewLabel_13.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_13.setBounds(130, 18, 59, 15);
		rep_B.add(lblNewLabel_13);
		
		up_B_id = new JTextField();
		up_B_id.setBounds(186, 15, 59, 21);
		rep_B.add(up_B_id);
		up_B_id.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setBounds(10, 41, 46, 15);
		rep_B.add(lblNewLabel_14);
		
		JLabel lblNewLabel_9_3 = new JLabel("\u5EE0\u5546\u540D\u7A31");
		lblNewLabel_9_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_3.setBounds(10, 50, 64, 15);
		rep_B.add(lblNewLabel_9_3);
		
		up_B_name = new JTextField();
		up_B_name.setColumns(10);
		up_B_name.setBounds(10, 70, 96, 21);
		rep_B.add(up_B_name);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("\u5EE0\u5546\u7D71\u7DE8");
		lblNewLabel_9_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_1_1.setBounds(119, 50, 64, 15);
		rep_B.add(lblNewLabel_9_1_1);
		
		up_B_editor = new JTextField();
		up_B_editor.setColumns(10);
		up_B_editor.setBounds(119, 70, 96, 21);
		rep_B.add(up_B_editor);
		
		JLabel lblNewLabel_9_2_3 = new JLabel("\u9032\u5834\u65E5\u671F");
		lblNewLabel_9_2_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_3.setBounds(225, 50, 64, 15);
		rep_B.add(lblNewLabel_9_2_3);
		
		JLabel lblNewLabel_9_2_1_3 = new JLabel("\u4E3B\u8981\u696D\u52D9");
		lblNewLabel_9_2_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_3.setBounds(331, 50, 64, 15);
		rep_B.add(lblNewLabel_9_2_1_3);
		
		up_B_service = new JTextField();
		up_B_service.setColumns(10);
		up_B_service.setBounds(331, 70, 96, 21);
		rep_B.add(up_B_service);
		
		JLabel lblNewLabel_9_2_1_1_1 = new JLabel("\u6578\u91CF");
		lblNewLabel_9_2_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_1_1.setBounds(144, 101, 64, 15);
		rep_B.add(lblNewLabel_9_2_1_1_1);
		
		JLabel lblNewLabel_9_2_1_2_3 = new JLabel("\u6298\u6263");
		lblNewLabel_9_2_1_2_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_2_3.setBounds(225, 101, 40, 15);
		rep_B.add(lblNewLabel_9_2_1_2_3);
		
		up_B_disc = new JTextField();
		up_B_disc.setColumns(10);
		up_B_disc.setBounds(225, 121, 96, 21);
		rep_B.add(up_B_disc);
		
		up_B_quan = new JTextField();
		up_B_quan.setColumns(10);
		up_B_quan.setBounds(144, 121, 71, 21);
		rep_B.add(up_B_quan);
		
		JLabel lblNewLabel_9_2_1_2_2_1 = new JLabel("\u5408\u4F5C\u5C08\u6848");
		lblNewLabel_9_2_1_2_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_2_2_1.setBounds(331, 101, 64, 15);
		rep_B.add(lblNewLabel_9_2_1_2_2_1);
		
		up_B_conn = new JTextField();
		up_B_conn.setColumns(10);
		up_B_conn.setBounds(331, 121, 96, 21);
		rep_B.add(up_B_conn);
		
		JLabel lblNewLabel_9_2_1_2_1_1 = new JLabel("\u5099\u8A3B");
		lblNewLabel_9_2_1_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_1_2_1_1.setBounds(435, 50, 40, 15);
		rep_B.add(lblNewLabel_9_2_1_2_1_1);
		
		JTextPane up_B_remind = new JTextPane();
		up_B_remind.setBounds(437, 70, 213, 72);
		rep_B.add(up_B_remind);
		
		up_B_unit = new JTextField();
		up_B_unit.setColumns(10);
		up_B_unit.setBounds(10, 121, 40, 21);
		rep_B.add(up_B_unit);
		
		JLabel lblNewLabel_9_2_2_1 = new JLabel("\u55AE\u50F9");
		lblNewLabel_9_2_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_9_2_2_1.setBounds(10, 101, 40, 15);
		rep_B.add(lblNewLabel_9_2_2_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("\u55AE\u4F4D");
		lblNewLabel_10_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_10_1.setBounds(53, 100, 40, 15);
		rep_B.add(lblNewLabel_10_1);
		
		JComboBox add_B_1_1 = new JComboBox();
		add_B_1_1.setModel(new DefaultComboBoxModel(ed.values()));
		add_B_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 10));
		add_B_1_1.setBounds(53, 119, 81, 23);
		rep_B.add(add_B_1_1);
		
		JLabel lblNewLabel_12_1 = new JLabel("\u5EE0\u5546\u8CC7\u6599\u522A\u9664");
		lblNewLabel_12_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_12_1.setBounds(10, 151, 116, 30);
		rep_B.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_13_1 = new JLabel("\u5EE0\u5546\u7DE8\u865F");
		lblNewLabel_13_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_13_1.setBounds(130, 159, 59, 15);
		rep_B.add(lblNewLabel_13_1);
		
		del_B_id = new JTextField();
		del_B_id.setColumns(10);
		del_B_id.setBounds(186, 156, 59, 21);
		rep_B.add(del_B_id);
		
		JButton ch_B = new JButton("\u66F4\u6539");
		
		ch_B.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		ch_B.setBounds(293, 14, 87, 23);
		rep_B.add(ch_B);
		
		JButton del_B = new JButton("\u522A\u9664");
		
		del_B.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		del_B.setBounds(293, 155, 87, 23);
		rep_B.add(del_B);
		
		JLabel up_B_arr = new JLabel("\u6B20\u6B3E\u7D00\u9304");
		up_B_arr.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		up_B_arr.setBounds(435, 22, 64, 15);
		rep_B.add(up_B_arr);
		
		JCheckBox up_B_arress = new JCheckBox("\u62D6\u6B20\u5DE5\u7A0B\u6B3E");
		up_B_arress.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		up_B_arress.setBounds(497, 18, 97, 23);
		rep_B.add(up_B_arress);
		
		JLabel show_up_b = new JLabel("");
		show_up_b.setFont(new Font("微软雅黑", Font.BOLD, 14));
		show_up_b.setForeground(new Color(255, 0, 0));
		show_up_b.setBounds(497, 41, 153, 26);
		rep_B.add(show_up_b);
		
		JLabel lblNewLabel_12_1_1 = new JLabel("\u8CC7\u6599\u67E5\u8A62");
		lblNewLabel_12_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_12_1_1.setBounds(10, 186, 71, 30);
		rep_B.add(lblNewLabel_12_1_1);
		
		JButton ser_B = new JButton("\u67E5\u8A62");
		
		ser_B.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		ser_B.setBounds(91, 190, 87, 23);
		rep_B.add(ser_B);
		
		sre_B_table = new JTable();
		sre_B_table.setBackground(Color.WHITE);
		sre_B_table.setBounds(10, 245, 640, 178);
		rep_B.add(sre_B_table);
		
		JButton PDF_B = new JButton("\u532F\u51FAPDF");
		
		PDF_B.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		PDF_B.setBounds(435, 190, 87, 23);
		rep_B.add(PDF_B);
		
		JButton B_toexcel = new JButton("\u532F\u51FAExcel");
		
		B_toexcel.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		B_toexcel.setBounds(543, 190, 87, 23);
		rep_B.add(B_toexcel);
		
		JLabel show_up_b_del = new JLabel("");
		show_up_b_del.setForeground(new Color(255, 0, 0));
		show_up_b_del.setFont(new Font("微软雅黑", Font.BOLD, 14));
		show_up_b_del.setBounds(435, 152, 153, 26);
		rep_B.add(show_up_b_del);
		
		JDateChooser up_B_date = new JDateChooser();
		up_B_date.setBounds(225, 70, 96, 21);
		rep_B.add(up_B_date);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(new Color(255, 228, 181));
		panel_4_1.setBounds(10, 224, 640, 21);
		rep_B.add(panel_4_1);
		
		JLabel lblNewLabel_11_9 = new JLabel("廠商編號");
		lblNewLabel_11_9.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_9.setBounds(2, 3, 59, 15);
		panel_4_1.add(lblNewLabel_11_9);
		
		JLabel lblNewLabel_11_1_1 = new JLabel("廠商名稱");
		lblNewLabel_11_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_1_1.setBounds(55, 3, 49, 15);
		panel_4_1.add(lblNewLabel_11_1_1);
		
		JLabel lblNewLabel_11_2_1 = new JLabel("統編");
		lblNewLabel_11_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_2_1.setBounds(110, 3, 32, 15);
		panel_4_1.add(lblNewLabel_11_2_1);
		
		JLabel lblNewLabel_11_3_1 = new JLabel("進場日期");
		lblNewLabel_11_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_3_1.setBounds(161, 3, 59, 15);
		panel_4_1.add(lblNewLabel_11_3_1);
		
		JLabel lblNewLabel_11_4_1 = new JLabel("承包工項");
		lblNewLabel_11_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_4_1.setBounds(215, 3, 49, 15);
		panel_4_1.add(lblNewLabel_11_4_1);
		
		JLabel lblNewLabel_11_5_1 = new JLabel("單價");
		lblNewLabel_11_5_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_5_1.setBounds(268, 3, 32, 15);
		panel_4_1.add(lblNewLabel_11_5_1);
		
		JLabel lblNewLabel_11_6_1 = new JLabel("數量");
		lblNewLabel_11_6_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_6_1.setBounds(323, 3, 32, 15);
		panel_4_1.add(lblNewLabel_11_6_1);
		
		JLabel lblNewLabel_11_7_2 = new JLabel("折扣");
		lblNewLabel_11_7_2.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_7_2.setBounds(375, 3, 32, 15);
		panel_4_1.add(lblNewLabel_11_7_2);
		
		JLabel lblNewLabel_11_8_1_2 = new JLabel("合作專案");
		lblNewLabel_11_8_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_8_1_2.setBounds(476, 3, 49, 15);
		panel_4_1.add(lblNewLabel_11_8_1_2);
		
		JLabel lblNewLabel_11_8_1_1_1 = new JLabel("欠款紀錄");
		lblNewLabel_11_8_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_8_1_1_1.setBounds(534, 3, 49, 15);
		panel_4_1.add(lblNewLabel_11_8_1_1_1);
		
		JLabel lblNewLabel_11_8_2 = new JLabel("備註");
		lblNewLabel_11_8_2.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_8_2.setBounds(589, 3, 32, 15);
		panel_4_1.add(lblNewLabel_11_8_2);
		
		JLabel lblNewLabel_11_7_1_1 = new JLabel("總價");
		lblNewLabel_11_7_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 10));
		lblNewLabel_11_7_1_1.setBounds(423, 3, 32, 15);
		panel_4_1.add(lblNewLabel_11_7_1_1);
		
		JLabel lblc = new JLabel("固定儲存位置為C://廠商資料");
		lblc.setForeground(Color.RED);
		lblc.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblc.setBounds(258, 191, 169, 21);
		rep_B.add(lblc);
		
		add_B_coon = new JTextField();
		add_B_coon.setColumns(10);
		add_B_coon.setBounds(331, 119, 96, 21);
		vendor.add(add_B_coon);
		
		JCheckBox add_B_arress = new JCheckBox("\u6B20\u6B3E\u7D00\u9304");
		add_B_arress.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		add_B_arress.setBounds(472, 40, 81, 23);
		vendor.add(add_B_arress);
		
		JLabel show_B_remind = new JLabel("");
		show_B_remind.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		show_B_remind.setForeground(new Color(255, 255, 0));
		show_B_remind.setBounds(472, 6, 178, 31);
		vendor.add(show_B_remind);
		
		JDateChooser add_B_date = new JDateChooser();
		add_B_date.setBounds(225, 68, 96, 21);
		vendor.add(add_B_date);
		gohome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource()==gohome) 
				{
					home.setVisible(true);
					vendor.setVisible(false);
					rep_A.setVisible(false);
					rep_B.setVisible(false);
				}
			}
		});
		govendor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getSource()==govendor) 
				{
				vendor.setVisible(true);
				home.setVisible(false);
				rep_A.setVisible(false);
				rep_B.setVisible(false);
				}
				
			}
		});
		search_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource()==search_B) 
				{
					rep_B.setVisible(true);
					vendor.setVisible(false);
					home.setVisible(false);
					rep_A.setVisible(false);
				}
			}
		});
		add_A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try 
				{
					if(build_A_name.getText()!=null&&build_A_man.getText()!=null&&build_A_worker.getText()!=null
						&&build_A_work.getText()!=null&&build_A_remind.getText()!=null) 
				{
					Connection conn=implDao.getDB();
					Build_System addhome=new Build_System(build_A_name.getText(),build_A_man.getText()
													,Integer.parseInt(build_A_worker.getText()),build_A_work.getText(),build_A_safe.isSelected(),build_A_remind.getText());
					f.add_A(addhome);
					keyword.setText("新增成功");
					
					}
				}
				catch(java.lang.NumberFormatException e1) 
				{
					keyword.setText("新增失敗");
				}
				
				
			}
		});
		search_A_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection conn=implDao.getDB();
				String SQL="select*from build_home";
				try {
					PreparedStatement ps=conn.prepareStatement(SQL);
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
				
			}
		});
		search_A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource()==search_A) 
				{
					home.setVisible(false);
					vendor.setVisible(false);
					rep_A.setVisible(true);
					rep_B.setVisible(false);
				}
			}
		});
		up_A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try 
				{
				Integer a=null;
				if(rep_A_worker.getText().equals("")!=true)a=Integer.parseInt(rep_A_worker.getText());
				if(rep_A_id.getText().equals("")!=true) 
				{
				Build_System b=new Build_System(rep_A_name.getText(),rep_A_man.getText(),a,rep_A_work.getText(),rep_A_safe.isSelected(),rep_A_remind.getText());
				f.update_A(Integer.parseInt(rep_A_id.getText()),b);
				show_reach_A.setText("~~修改成功~~");
				}
				else 
				{
					show_reach_A.setText("~~修改失敗~~");
				}
				}
				catch(NullPointerException e) 
				{
					show_reach_A.setText("~~修改失敗~~");
				}
				
			}
		});
		del_A.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(del_A_id.getText().equals("")!=true) 
				{
					f.deleted_A(Integer.parseInt(del_A_id.getText()));
					show_reach_A.setText("~~刪除成功~~");
				}
				else 
				{
					show_reach_A.setText("~~刪除失敗~~");
				}
				
			}
		});
		search_A_All.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*ArrayList<Build_System> list=f.userList();
				DefaultTableModel model=(DefaultTableModel)show_rep_A.getModel();
				Object[] row=new Object[7];
				for(int i=0;i<list.size();i++) 
				{	
					row[1]=list.get(i).getBuild_A_name();
				}*/
				//f.showAll_A(show_rep_A);
				/*Object[] col= {
						"專案編號", "專案名稱", "專案負責人", "施工人數","施工工項","勞安宣導","備註"
				};
				DefaultTableModel mm = new DefaultTableModel(col, 0); 
				show_rep_A.setModel(mm);*/
				//show_rep_A(f.showAll_A(show_rep_A).toString(),col);
				//show_rep_A(f.showAll_A(show_rep_A),col);
				//show_rep_A=new JTable(f.toTable(),col);
				Connection conn=implDao.getDB();
				String SQL="select*from build_home";
				PreparedStatement ps;
				try {
					ps = conn.prepareStatement(SQL);
					ResultSet rs=ps.executeQuery();
					show_rep_A.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		querA_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection conn=implDao.getDB();
				String SQL="select*from build_vendor";
				PreparedStatement ps;
				try {
					ps = conn.prepareStatement(SQL);
					ResultSet rs=ps.executeQuery();
					showAll_B.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ch_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try 
				{
					Connection conn=implDao.getDB();
				Double i=null;
				Double j=null;
				Double k=null;
				//java.sql.Date sqlDate = convert(up_B_date.getDate());
				/*Date SQLdate=sqlDate;
				if(up_B_date.getDate()!=null)SQLdate=up_B_date.getDate();*/
				
				if(up_B_unit.getText().equals("")!=true)i=Double.parseDouble(up_B_unit.getText());
				if(up_B_quan.getText().equals("")!=true)j=Double.parseDouble(up_B_quan.getText());
				if(up_B_disc.getText().equals("")!=true)k=Double.parseDouble(up_B_disc.getText());
				if(up_B_id.getText().equals("")!=true) {
					b=new Build_System(up_B_name.getText(),up_B_editor.getText(),up_B_date.getDate(),up_B_service.getText(),i,j,k,up_B_conn.getText(),up_B_arress.isSelected(),up_B_remind.getText());
					//Jcalender現有日曆外掛
					f.update_B(Integer.parseInt(up_B_id.getText()), b);
					show_up_b.setText("~~更新成功~~");
				}
				else 
				{
					show_up_b.setText("~~更新失敗~~");
				}
				}
				catch(NullPointerException e)
				{
					show_up_b.setText("~~更新失敗~~");
				}
				
				
				
				/*catch(NullPointerException e) 
				{
					show_up_b.setText("~~更新失敗~~");
				}*/
				
				
			}
		});
		add_B_go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//java.sql.Date sqlDate = convert(add_B_date.getDate());
				try 
				{
					if(add_B_name.getText().equals("")!=true&&add_B_editor.equals("")!=true&&add_B_date.getDate()!=null
						&&add_B_service.getText().equals("")!=true&&add_B_unitprice.getText().equals("")!=true
						&&add_B_quan.getText().equals("")!=true&&add_B_dis.getText().equals("")!=true
						&&add_B_coon.getText().equals("")!=true) 
				{
					Build_System b=new Build_System(add_B_name.getText(),add_B_editor.getText()
							,add_B_date.getDate(),add_B_service.getText(),Double.parseDouble(add_B_unitprice.getText())
							,Double.parseDouble(add_B_quan.getText()),Double.parseDouble(add_B_dis.getText()),add_B_coon.getText()
							,add_B_arress.isSelected(),add_B_remind.getText());
					f.add_B(b);
					show_B_remind.setText("~~新增成功~~");
				}
				else 
				{
					show_B_remind.setText("~~新增失敗~~");
				}
				}
				catch(NumberFormatException e) 
				{
					show_B_remind.setText("~~新增失敗~~");
				}
				catch(java.lang.NullPointerException e2)
				{
					show_B_remind.setText("~~新增失敗~~");
				}
				
			}
		});
		del_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(del_B_id.getText().equals("")!=true) 
				{
					f.deleted_B(Integer.parseInt(del_B_id.getText()));
					show_up_b_del.setText("~~刪除成功~~");
				}
				else 
				{
					show_up_b_del.setText("~~刪除失敗~~");
				}
			}
		});
		A_toPDF.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent arg0) {
	    		Date date = new Date();
	    		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日");
	    		myFmt.format(date);
	    		try {
					f.DocPDF_A(myFmt.format(date).toString()+"日報",f.queryAll_A());
					show_reach_A.setText("PDF匯出成功");
				} catch (IOException e) {
					show_reach_A.setText("PDF匯出失敗");
					e.printStackTrace();
				}
	    		/*JFileChooser fileChooser = new JFileChooser("C://");//宣告filechooser 
	    		fileChooser.setDialogTitle("儲存檔案");
	    		fileChooser.setFileFilter(new FilefilterType(".pdf","PDF"));
	    		fileChooser.showSaveDialog(null);*/
	    		//int returnValue = fileChooser.showOpenDialog(null);//叫出filechooser 
	    		/*if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) //判斷是否選擇檔案 
	    		{ 
	    			String con=f.queryAll_A();
	    			File fi=fileChooser.getSelectedFile();
	    			String fname = fileChooser.getName(fi);
	    			if(fname.indexOf(".pdf")==-1){
	    				fi=new File(fileChooser.getCurrentDirectory(),fname+".pdf");
	    			}
	    			try {
						FileWriter fw=new FileWriter(fi.getPath());
	    				//FileOutputStream fw = new FileOutputStream(fi);
						fw.write(con);
						fw.flush();
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		//File selectedFile = fileChooser.getSelectedFile();指派給File 
	    		//System.out.println(selectedFile.getName()); 印出檔名 
	    		}*/ 
	    	}
	    });
		
			PDF_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Date date = new Date();
	    		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日");
	    		myFmt.format(date);
	    		try {
					f.DocPDF_B(myFmt.format(date).toString()+"廠商資料",f.queryAll_B());
					show_up_b_del.setText("PDF匯出成功");
				} catch (IOException e) {
					show_up_b_del.setText("PDF匯出失敗");
					e.printStackTrace();
				}
	    		
				/*JFileChooser fileChooser = new JFileChooser("C://");//宣告filechooser 
	    		fileChooser.setDialogTitle("儲存檔案");
	    		fileChooser.setFileFilter(new FilefilterType(".PDF","PDF"));
	    		fileChooser.showSaveDialog(null);
	    		int returnValue = fileChooser.showOpenDialog(null);//叫出filechooser 
	    		if (returnValue == JFileChooser.APPROVE_OPTION) //判斷是否選擇檔案 
	    		{ 
	    			File selectedFile=fileChooser.getSelectedFile();
	    			try {
						FileWriter fw=new FileWriter(selectedFile.getPath());
						//fw.write();
						fw.flush();
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		//File selectedFile = fileChooser.getSelectedFile();指派給File 
	    		//System.out.println(selectedFile.getName()); 印出檔名 
	    		}*/ 
			}
		});
	    ser_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connection conn=implDao.getDB();
				String SQL="select*from build_vendor";
				PreparedStatement ps;
				try {
					ps = conn.prepareStatement(SQL);
					ResultSet rs=ps.executeQuery();
					sre_B_table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    A_toExcel.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		/*JFileChooser fileChooser = new JFileChooser("C://");//宣告filechooser 
	    		fileChooser.setDialogTitle("儲存檔案");
	    		fileChooser.setFileFilter(new FilefilterType(".xls","Excel"));
	    		fileChooser.showSaveDialog(null);
	    		int returnValue = fileChooser.showOpenDialog(null);
	    		if (returnValue == JFileChooser.APPROVE_OPTION) //判斷是否選擇檔案 
	    		{ 
	    			File selectedFile=fileChooser.getSelectedFile();
	    			try {
						FileWriter fw=new FileWriter(selectedFile.getPath());
						//fw.write(ser_B.toString());
						fw.flush();
						fw.close();
					} catch (IOException e2) {
						
						e2.printStackTrace();
					}
	    		//File selectedFile = fileChooser.getSelectedFile();指派給File 
	    		//System.out.println(selectedFile.getName()); 印出檔名 
	    		}*/
	    		Date date=new Date();
	    		SimpleDateFormat ds=new SimpleDateFormat("yyyy年MM月dd日");
	    		ds.format(date);
	    		f.AtoExcel(ds.format(date).toString()+"日報");
	    		show_reach_A.setText("Excel匯出成功");
				
	    	}
	    });
	    B_toexcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date date = new Date();
	    		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日");
	    		myFmt.format(date);
				f.BtoExcel(myFmt.format(date).toString()+"廠商資料");
				show_up_b_del.setText("Excel匯出成功");
			}
		}); 
	    
	    
	    
	}	
	
}

