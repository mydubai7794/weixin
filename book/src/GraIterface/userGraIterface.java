package GraIterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//借阅者功能界面

public class userGraIterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userGraIterface frame = new userGraIterface();
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
	public userGraIterface() {
		setTitle("\u4F60\u597D\uFF0C\u501F\u9605\u4EBA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u501F\u4E66");
		btnNewButton.setBounds(30, 42, 132, 51);
		contentPane.add(btnNewButton);

		
		JButton btnNewButton_1 = new JButton("\u8FD8\u4E66");
		btnNewButton_1.setBounds(226, 42, 132, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u56FE\u4E66\u9884\u5B9A");
		btnNewButton_2.setBounds(100, 113, 181, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u56FE\u4E66\u68C0\u7D22");
		btnNewButton_3.setBounds(100, 186, 181, 50);
		contentPane.add(btnNewButton_3);
	}


}
