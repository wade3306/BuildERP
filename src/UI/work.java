package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class work extends JFrame {

	private JPanel contentPane;
	mainUi m=new mainUi();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					work frame = new work();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public work() {
		setTitle("\u5DE5\u9805\u9078\u64C7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5DE5\u9805\u9078\u64C7");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 88, 28);
		contentPane.add(lblNewLabel);
		
		JCheckBox e1 = new JCheckBox("\u92FC\u7B4B");
		e1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		e1.setBounds(10, 70, 58, 23);
		contentPane.add(e1);
		
		JCheckBox e2 = new JCheckBox("\u6A21\u677F");
		e2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		e2.setBounds(70, 70, 58, 23);
		contentPane.add(e2);
		
		JCheckBox e3 = new JCheckBox("\u9DF9\u67B6");
		e3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		e3.setBounds(130, 70, 58, 23);
		contentPane.add(e3);
		
		JCheckBox e4 = new JCheckBox("\u540A\u8ECA");
		e4.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		e4.setBounds(184, 70, 58, 23);
		contentPane.add(e4);
		
		JCheckBox e5 = new JCheckBox("\u6392\u6C34");
		e5.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		e5.setBounds(244, 70, 49, 23);
		contentPane.add(e5);
		
		JCheckBox e6 = new JCheckBox("\u571F\u65B9");
		e6.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		e6.setBounds(295, 70, 58, 23);
		contentPane.add(e6);
		
		JCheckBox e7 = new JCheckBox("\u5B89\u63AA\u652F\u6490");
		e7.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		e7.setBounds(349, 70, 79, 23);
		contentPane.add(e7);
		
		JLabel lblNewLabel_1 = new JLabel("\u7D50\u69CB\u5DE5\u7A0B");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(181, 36, 71, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u88DD\u4FEE\u5BA4\u5167\u5DE5\u7A0B");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(172, 104, 88, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JCheckBox d1 = new JCheckBox("\u6C34\u96FB");
		d1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d1.setBounds(10, 143, 58, 23);
		contentPane.add(d1);
		
		JCheckBox d2 = new JCheckBox("\u653E\u6A23");
		d2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d2.setBounds(70, 143, 58, 23);
		contentPane.add(d2);
		
		JCheckBox d3 = new JCheckBox("\u9580\u6846");
		d3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d3.setBounds(130, 143, 58, 23);
		contentPane.add(d3);
		
		JCheckBox d4 = new JCheckBox("\u7ACB\u7246");
		d4.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d4.setBounds(184, 143, 58, 23);
		contentPane.add(d4);
		
		JCheckBox d6 = new JCheckBox("\u571F\u6C34");
		d6.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d6.setBounds(295, 143, 58, 23);
		contentPane.add(d6);
		
		JCheckBox d5 = new JCheckBox("\u62B9\u58C1");
		d5.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d5.setBounds(244, 143, 49, 23);
		contentPane.add(d5);
		
		JCheckBox d7 = new JCheckBox("\u9632\u6C34");
		d7.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d7.setBounds(349, 143, 79, 23);
		contentPane.add(d7);
		
		JCheckBox d8 = new JCheckBox("\u58C1\u78DA");
		d8.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d8.setBounds(10, 183, 58, 23);
		contentPane.add(d8);
		
		JCheckBox d9 = new JCheckBox("\u5730\u78DA");
		d9.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d9.setBounds(70, 183, 58, 23);
		contentPane.add(d9);
		
		JCheckBox d10 = new JCheckBox("\u7ACB\u7246");
		d10.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d10.setBounds(130, 183, 58, 23);
		contentPane.add(d10);
		
		JCheckBox d11 = new JCheckBox("\u6253\u77F3");
		d11.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d11.setBounds(184, 183, 58, 23);
		contentPane.add(d11);
		
		JCheckBox d12 = new JCheckBox("\u6728\u5DE5");
		d12.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d12.setBounds(244, 183, 49, 23);
		contentPane.add(d12);
		
		JCheckBox d13 = new JCheckBox("\u6A5F\u96FB");
		d13.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d13.setBounds(295, 183, 58, 23);
		contentPane.add(d13);
		
		JCheckBox d14 = new JCheckBox("\u7CFB\u7D71\u6AC3");
		d14.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		d14.setBounds(349, 183, 79, 23);
		contentPane.add(d14);
		
		//
		JButton gotoUi = new JButton("\u78BA\u8A8D");
		gotoUi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.setVisible(true);
				//frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				dispose();
			}
		});
		gotoUi.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		gotoUi.setBounds(173, 234, 87, 23);
		contentPane.add(gotoUi);
	}
	
}
