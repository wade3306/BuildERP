package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.jupiter.params.shadow.com.univocity.parsers.fixed.FixedWidthWriter;

import Dao.Function;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class dotest extends JFrame {

	private JPanel contentPane;
	Function f=new Function();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dotest frame = new dotest();
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
	public dotest() {
		setTitle("SaveTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton save = new JButton("\u5132\u5B58\u6A94\u6848");
		
		save.setBounds(10, 10, 87, 23);
		contentPane.add(save);
		
		save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JFileChooser fc=new JFileChooser("C://");
				fc.setDialogTitle("¶×¥XÀÉ®×");
				fc.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
				fc.setFileFilter(new FilefilterType(".xls","Excel"));
				fc.setFileFilter(new FilefilterType(".pdf","PDF"));
				int res=fc.showSaveDialog(null);
				if(res==JFileChooser.APPROVE_OPTION) 
				{	
					File fi=fc.getSelectedFile();
					String filetemp=fi.getAbsolutePath()+"/"+fi.getName();
					if(!fi.exists()) 
					{
						try {
							FileWriter fw=new FileWriter(filetemp);
							fw.write(f.queryAll_B());
							fw.flush();
							fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					
				}
				
			}
		});
	}
}
