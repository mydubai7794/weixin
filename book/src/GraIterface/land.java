package GraIterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import textSQL.addUserPassword;
import textSQL.veriSignUp;
import textSQL.verification;

public class land extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					land frame = new land();
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
	public land() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        int result = JOptionPane.showConfirmDialog(null, "确认退出?", "确认",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
		        if (result == JOptionPane.OK_OPTION) {
			        // 退出
		            System.exit(0);
		        }
		    }
		});
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("仿宋", Font.PLAIN, 20));
		lblNewLabel.setBounds(38, 52, 100, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("仿宋", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(38, 110, 100, 37);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(130, 57, 242, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 120, 242, 31);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
//监听登陆事件
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName=textField.getText();

				String password=new String(passwordField.getPassword());
				
				verification vervy = new verification();
				try {
					verification ver = new verification();
				    ver.verifications(userName, password);
				    setVisible(false);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(58, 179, 128, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u6CE8\u518C");
//注册事件
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取账号密码
				String userName=textField.getText();
				System.out.println(userName);
				String password=new String(passwordField.getPassword());
				System.out.println(password);
				addUserPassword signuser = new addUserPassword();
				//写进数据库必要的异常处理
				//注册账号进数据库
				try {
					signuser.adduserpassword(userName, password);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				//进行验证
				veriSignUp veri = new veriSignUp();
				try {
					veri.verifications(userName, password);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(265, 179, 128, 43);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u6CE8\u610F\uFF1A\u6CE8\u518C\u53EA\u80FD\u6CE8\u518C\u501F\u9605\u8005\u8EAB\u4EFD");
		lblNewLabel_2.setBounds(10, 233, 436, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6B32\u6210\u4E3A\u56FE\u4E66\u7BA1\u7406\u5458\u6216\u7528\u6237\u7BA1\u7406\u5458\uFF0C\u8BF7\u8054\u7CFB\u7528\u6237\u7BA1\u7406\u5458");
		lblNewLabel_3.setBounds(10, 261, 359, 37);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
