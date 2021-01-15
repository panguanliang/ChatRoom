package cn.edu.hcnu.client;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * 登录线程
 */
public class LoginThread extends Thread{
	private JFrame loginf;

	private JTextField t;

	public void run() {
		/*
		 * 设置登录界面
		 */
		loginf = new JFrame();
		loginf.setResizable(false);
		loginf.setLocation(300, 200);
		loginf.setSize(400, 150);
		loginf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginf.setTitle("聊天室" + " - 登录");

		t = new JTextField("Version " + "1.1.0" + "        By liwei");
		t.setHorizontalAlignment(JTextField.CENTER);
		t.setEditable(false);
		loginf.getContentPane().add(t, BorderLayout.SOUTH);

		JPanel loginp = new JPanel(new GridLayout(3, 2));
		loginf.getContentPane().add(loginp);

		JTextField t1 = new JTextField("登录名:");
		t1.setHorizontalAlignment(JTextField.CENTER);
		t1.setEditable(false);
		loginp.add(t1);

		final JTextField loginname = new JTextField("liwei");
		loginname.setHorizontalAlignment(JTextField.CENTER);
		loginp.add(loginname);

		JTextField t2 = new JTextField("密码:");
		t2.setHorizontalAlignment(JTextField.CENTER);
		t2.setEditable(false);
		loginp.add(t2);

		final JTextField loginPassword = new JTextField("lw1234");
		loginPassword.setHorizontalAlignment(JTextField.CENTER);
		loginp.add(loginPassword);
		/*
		 * 监听退出按钮(匿名内部类)
		 */
		JButton b1 = new JButton("退  出");
		loginp.add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		final JButton b2 = new JButton("登  录");
		loginp.add(b2);

		loginf.setVisible(true);

		/**
		 * 监听器,监听"登录"Button的点击和TextField的回车
		 */
		class ButtonListener implements ActionListener {
			private Socket s;

			public void actionPerformed(ActionEvent e) {
				String username=loginname.getText();
				String password=loginPassword.getText();

				System.out.println("用户名："+username);
				System.out.println("密码："+password);
			}
		}
		ButtonListener bl = new ButtonListener();
		b2.addActionListener(bl);
		loginname.addActionListener(bl);
		loginPassword.addActionListener(bl);
	}
}