import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Program {

	private JFrame frmDigitalSignature;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frmDigitalSignature.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JPanel panelMDS;
	JPanel panelDS;
	JPanel panelSessionKey;
	JPanel panelGK;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField_7;
	public JTextField textField_8;
	public JTextArea textArea_3;
	public JTextArea textArea_4;
	public JTextField textField_9;
	public JTextArea textArea;
	
	public void initialize() {
		
		convertion conn = new convertion();
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frmDigitalSignature = new JFrame();
		frmDigitalSignature.setTitle("Digital Signature");
		frmDigitalSignature.getContentPane().setBackground(Color.ORANGE);
		frmDigitalSignature.setResizable(false);
		frmDigitalSignature.getContentPane().setLayout(null);
		
		JButton btnSessionKey = new JButton("Session Key");
		btnSessionKey.setBackground(Color.LIGHT_GRAY);
		btnSessionKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMDS.setVisible(false);
				panelDS.setVisible(false);
				panelGK.setVisible(false);
				panelSessionKey.setVisible(true);
			}
		});
		btnSessionKey.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnSessionKey.setBounds(321, 11, 134, 31);
		btnSessionKey.setBorder(new LineBorder(Color.black,3));
		frmDigitalSignature.getContentPane().add(btnSessionKey);
		
		JButton btnMessageDigital = new JButton("Digital Sinature Message &  Session Key");
		btnMessageDigital.setBackground(Color.LIGHT_GRAY);
		btnMessageDigital.setActionCommand("Message & Digital Signature");
		btnMessageDigital.setBorder(new LineBorder(Color.black,3));
		btnMessageDigital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMDS.setVisible(false);
				panelDS.setVisible(true);
				panelGK.setVisible(false);
				panelSessionKey.setVisible(false);
			}
		});
		btnMessageDigital.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnMessageDigital.setBounds(707, 11, 352, 31);
		frmDigitalSignature.getContentPane().add(btnMessageDigital);
		
		JButton btnDigitalSignature = new JButton("Message & Digital Sinature");
		btnDigitalSignature.setBackground(Color.LIGHT_GRAY);
		btnDigitalSignature.setBorder(new LineBorder(Color.black,3));
		btnDigitalSignature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMDS.setVisible(true);
				panelDS.setVisible(false);
				panelGK.setVisible(false);
				panelSessionKey.setVisible(false);
			}
		});
		btnDigitalSignature.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnDigitalSignature.setBounds(465, 11, 232, 31);
		frmDigitalSignature.getContentPane().add(btnDigitalSignature);
		
		panelDS = new JPanel();
		panelDS.setBorder(new LineBorder(Color.BLACK, 3, true));
		panelDS.setVisible(false);
		
		panelGK = new JPanel();
		panelGK.setBackground(Color.DARK_GRAY);
		panelGK.setBounds(10, 53, 1174, 607);
		panelGK.setBorder(new LineBorder(Color.BLACK, 3, true));
		panelGK.setVisible(false);
		
		panelMDS = new JPanel();
		panelMDS.setBorder(new LineBorder(Color.BLACK, 3, true));
		panelMDS.setVisible(false);
		
		panelSessionKey = new JPanel();
		panelSessionKey.setBorder(new LineBorder(Color.BLACK, 3));
		panelSessionKey.setVisible(false);
		panelSessionKey.setBackground(Color.DARK_GRAY);
		panelSessionKey.setBounds(10, 53, 1174, 607);
		panelSessionKey.setLayout(null);
		frmDigitalSignature.getContentPane().add(panelSessionKey);
		
		JLabel lblSessionKey = new JLabel("Session Key");
		lblSessionKey.setForeground(Color.ORANGE);
		lblSessionKey.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSessionKey.setBounds(21, 11, 113, 33);
		panelSessionKey.add(lblSessionKey);
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField.setBorder(new LineBorder(Color.BLACK, 3));
		textField.setBounds(115, 55, 887, 33);
		panelSessionKey.add(textField);
		textField.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message : ");
		lblMessage.setForeground(Color.ORANGE);
		lblMessage.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblMessage.setBounds(21, 55, 113, 33);
		panelSessionKey.add(lblMessage);
		
		JLabel lblKey = new JLabel("KeyAES : ");
		lblKey.setForeground(Color.ORANGE);
		lblKey.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblKey.setBounds(481, 187, 113, 33);
		panelSessionKey.add(lblKey);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_1.setBorder(new LineBorder(Color.BLACK, 3));
		textField_1.setColumns(10);
		textField_1.setBounds(567, 188, 291, 33);
		panelSessionKey.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_2.setBorder(new LineBorder(Color.BLACK, 3));
		textField_2.setColumns(10);
		textField_2.setBounds(230, 100, 628, 33);
		panelSessionKey.add(textField_2);
		
		JLabel lblPublicKey = new JLabel("Public Key for encryp :");
		lblPublicKey.setForeground(Color.ORANGE);
		lblPublicKey.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPublicKey.setBounds(21, 99, 251, 33);
		panelSessionKey.add(lblPublicKey);
		
		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnChooseFile.setBorder(new LineBorder(Color.black,3));
		btnChooseFile.setBackground(Color.LIGHT_GRAY);
		btnChooseFile.setBounds(868, 99, 134, 35);
		btnChooseFile.addActionListener(new Action(this, "PubChoose",conn));
		panelSessionKey.add(btnChooseFile);
		
		JButton btnDecryp = new JButton("Decryp");
		btnDecryp.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnDecryp.setBorder(new LineBorder(Color.black,3));
		btnDecryp.setBackground(Color.LIGHT_GRAY);
		btnDecryp.setBounds(1009, 144, 141, 35);
		btnDecryp.addActionListener(new Action(this,"PriDec",conn));
		panelSessionKey.add(btnDecryp);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnClear.setBorder(new LineBorder(Color.black,3));
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setBounds(1009, 52, 141, 37);
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		panelSessionKey.add(btnClear);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setForeground(Color.ORANGE);
		lblOutput.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblOutput.setBounds(21, 187, 78, 33);
		panelSessionKey.add(lblOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 231, 1129, 354);
		panelSessionKey.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.BLACK, 3));
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
		
		JButton btnEncryp = new JButton("Encryp");
		btnEncryp.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnEncryp.setBorder(new LineBorder(Color.black,3));
		btnEncryp.setBackground(Color.LIGHT_GRAY);
		btnEncryp.setBounds(868, 186, 134, 35);
		btnEncryp.addActionListener(new Action(this,"AESEncrypt",conn));
		panelSessionKey.add(btnEncryp);
		
		JButton btnEncryp_1 = new JButton("Encryp");
		btnEncryp_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnEncryp_1.setBorder(new LineBorder(Color.black,3));
		btnEncryp_1.setBackground(Color.LIGHT_GRAY);
		btnEncryp_1.setBounds(1009, 98, 141, 35);
		btnEncryp_1.addActionListener(new Action(this,"PubEnc",conn));
		panelSessionKey.add(btnEncryp_1);
		
		JLabel lblPrivateKey_1 = new JLabel("Private key for decryp :");
		lblPrivateKey_1.setForeground(Color.ORANGE);
		lblPrivateKey_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPrivateKey_1.setBounds(21, 144, 251, 33);
		panelSessionKey.add(lblPrivateKey_1);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_9.setColumns(10);
		textField_9.setBorder(new LineBorder(Color.BLACK, 3));
		textField_9.setBounds(230, 144, 628, 33);
		panelSessionKey.add(textField_9);
		
		JButton button_4 = new JButton("Choose File");
		button_4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button_4.setBorder(new LineBorder(Color.black,3));
		button_4.setBackground(Color.LIGHT_GRAY);
		button_4.setBounds(868, 145, 134, 35);
		button_4.addActionListener(new Action(this,"PriChoose", conn));
		panelSessionKey.add(button_4);
		
		JButton button_6 = new JButton("Decryp");
		button_6.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button_6.setBorder(new LineBorder(Color.black,3));
		button_6.setBackground(Color.LIGHT_GRAY);
		button_6.setBounds(1009, 187, 141, 35);
		button_6.addActionListener(new Action(this,"AESDecrypt",conn));
		panelSessionKey.add(button_6);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnSend.setBorder(new LineBorder(Color.black,3));
		btnSend.setBackground(Color.LIGHT_GRAY);
		btnSend.setBounds(1009, 9, 141, 37);
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					conn.singFile();
					conn.writeToFile("MyData/DataForSend.txt");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		panelSessionKey.add(btnSend);
		
		JLabel lblSenddata = new JLabel("SendData : ");
		lblSenddata.setForeground(Color.ORANGE);
		lblSenddata.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSenddata.setBounds(892, 11, 113, 33);
		panelSessionKey.add(lblSenddata);
		
		panelMDS.setBackground(Color.DARK_GRAY);
		panelMDS.setBounds(10, 53, 1174, 607);
		panelMDS.setLayout(null);
		frmDigitalSignature.getContentPane().add(panelMDS);
		JLabel lblDigitalSignature = new JLabel("Message & Digital Sinature");
		lblDigitalSignature.setBounds(21, 11, 301, 33);
		panelMDS.add(lblDigitalSignature);
		lblDigitalSignature.setForeground(Color.ORANGE);
		lblDigitalSignature.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("Message");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label_1.setBounds(31, 55, 113, 33);
		panelMDS.add(label_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(41, 99, 1093, 195);
		panelMDS.add(scrollPane_3);
		
		textArea_3 = new JTextArea();
		textArea_3.setBorder(new LineBorder(Color.BLACK, 3));
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_3.setLineWrap(true);
		scrollPane_3.setViewportView(textArea_3);
		
		JLabel label_2 = new JLabel("Select Private for encryp :");
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label_2.setBounds(31, 310, 251, 33);
		panelMDS.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(Color.BLACK, 3));
		textField_5.setBounds(258, 311, 588, 33);
		panelMDS.add(textField_5);
		
		JButton button = new JButton("Choose File");
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button.setBorder(new LineBorder(Color.black,3));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(856, 310, 134, 35);
		button.addActionListener(new Action(this,"Choose FileB1",conn));
		panelMDS.add(button);
		
		JButton button_1 = new JButton("Encrypt");
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button_1.setBorder(new LineBorder(Color.black,3));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(1000, 310, 134, 35);
		button_1.addActionListener(new Action(this, "EncryptMD",conn));
		panelMDS.add(button_1);
		
		JLabel label_3 = new JLabel("Select Public for decryp  :");
		label_3.setForeground(Color.ORANGE);
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label_3.setBounds(31, 354, 251, 33);
		panelMDS.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(Color.BLACK, 3));
		textField_6.setBounds(258, 355, 588, 33);
		panelMDS.add(textField_6);
		
		JButton button_2 = new JButton("Choose File");
		button_2.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button_2.setBorder(new LineBorder(Color.black,3));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(856, 354, 134, 35);
		button_2.addActionListener(new Action(this,"Choose FileB2",conn));
		panelMDS.add(button_2);
		
		JButton button_3 = new JButton("Decrypt");
		button_3.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		button_3.setBorder(new LineBorder(Color.black,3));
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBounds(1000, 354, 134, 35);
		button_3.addActionListener(new Action(this,"DecryptMD",conn));
		panelMDS.add(button_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(41, 435, 1093, 144);
		panelMDS.add(scrollPane_4);
		
		textArea_4 = new JTextArea();
		textArea_4.setBorder(new LineBorder(Color.BLACK, 3));
		textArea_4.setLineWrap(true);
		textArea_4.setFont(new Font("Monospaced", Font.BOLD, 18));
		scrollPane_4.setViewportView(textArea_4);
		
		JLabel label_4 = new JLabel("Output");
		label_4.setForeground(Color.ORANGE);
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		label_4.setBounds(31, 398, 251, 33);
		panelMDS.add(label_4);
		panelGK.setLayout(null);
		
		
		frmDigitalSignature.getContentPane().add(panelGK);
		
		JLabel lblNewLabel = new JLabel("Generate Private Key ");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 70));
		lblNewLabel.setBounds(129, 53, 927, 343);
		panelGK.add(lblNewLabel);
		
		JLabel lblPrivateKey = new JLabel("& Private Key Success .");
		lblPrivateKey.setFont(new Font("Monospaced", Font.BOLD, 70));
		lblPrivateKey.setBounds(116, 189, 1119, 343);
		panelGK.add(lblPrivateKey);
		
		panelDS.setBackground(Color.DARK_GRAY);
		panelDS.setBounds(10, 53, 1174, 607);
		panelDS.setLayout(null);
		frmDigitalSignature.getContentPane().add(panelDS);
		
		/*
		 * Digital Signature & Session key
		 * 
		 * */
		JLabel lblMessageDigital = new JLabel("Digital Signature & Session key");
		lblMessageDigital.setBounds(21, 11, 290, 33);
		panelDS.add(lblMessageDigital);
		lblMessageDigital.setForeground(Color.ORANGE);
		lblMessageDigital.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel lblMessage_1 = new JLabel("Message");
		lblMessage_1.setForeground(Color.ORANGE);
		lblMessage_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblMessage_1.setBounds(31, 55, 113, 33);
		panelDS.add(lblMessage_1);
		
		JLabel lblSelectPrivateFor = new JLabel("Private for encryp :");
		lblSelectPrivateFor.setForeground(Color.ORANGE);
		lblSelectPrivateFor.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSelectPrivateFor.setBounds(31, 310, 160, 33);
		panelDS.add(lblSelectPrivateFor);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(Color.BLACK, 3));
		textField_3.setBounds(201, 311, 244, 33);
		panelDS.add(textField_3);
		
		JButton priChoose = new JButton("Choose File");
		priChoose.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		priChoose.setBorder(new LineBorder(Color.black,3));
		priChoose.setBackground(Color.LIGHT_GRAY);
		priChoose.setBounds(455, 309, 101, 35);
		panelDS.add(priChoose);
		
		JButton encrypM = new JButton("Encrypt");
		encrypM.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		encrypM.setBorder(new LineBorder(Color.black,3));
		encrypM.setBackground(Color.LIGHT_GRAY);
		encrypM.setBounds(566, 310, 89, 77);
		panelDS.add(encrypM);
		
		JLabel lblSelectPublicFor = new JLabel("Public for encryp  :");
		lblSelectPublicFor.setForeground(Color.ORANGE);
		lblSelectPublicFor.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSelectPublicFor.setBounds(31, 354, 171, 33);
		panelDS.add(lblSelectPublicFor);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(Color.BLACK, 3));
		textField_4.setBounds(201, 354, 244, 33);
		panelDS.add(textField_4);
		
		JButton pubChoose = new JButton("Choose File");
		pubChoose.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		pubChoose.setBorder(new LineBorder(Color.black,3));
		pubChoose.setBackground(Color.LIGHT_GRAY);
		pubChoose.setBounds(455, 353, 101, 35);
		panelDS.add(pubChoose);
		
		JButton decrypM = new JButton("Decrypt");
		decrypM.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		decrypM.setBorder(new LineBorder(Color.black,3));
		decrypM.setBackground(Color.LIGHT_GRAY);
		decrypM.setBounds(1048, 310, 89, 78);
		panelDS.add(decrypM);
		
		JLabel lblOutput_1 = new JLabel("Output");
		lblOutput_1.setForeground(Color.ORANGE);
		lblOutput_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblOutput_1.setBounds(31, 398, 251, 33);
		panelDS.add(lblOutput_1);
		
		JLabel lblPublicForDecryp = new JLabel("Public for decryp :");
		lblPublicForDecryp.setForeground(Color.ORANGE);
		lblPublicForDecryp.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPublicForDecryp.setBounds(665, 310, 171, 33);
		panelDS.add(lblPublicForDecryp);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_7.setColumns(10);
		textField_7.setBorder(new LineBorder(Color.BLACK, 3));
		textField_7.setBounds(821, 311, 140, 33);
		panelDS.add(textField_7);
		
		JLabel lblPrivateForDecryp = new JLabel("Private for decryp :");
		lblPrivateForDecryp.setForeground(Color.ORANGE);
		lblPrivateForDecryp.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPrivateForDecryp.setBounds(665, 354, 171, 33);
		panelDS.add(lblPrivateForDecryp);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Monospaced", Font.BOLD, 16));
		textField_8.setColumns(10);
		textField_8.setBorder(new LineBorder(Color.BLACK, 3));
		textField_8.setBounds(831, 355, 130, 33);
		panelDS.add(textField_8);
		
		JButton btnChoose = new JButton("Choose File");
		btnChoose.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		btnChoose.setBorder(new LineBorder(Color.black,3));
		btnChoose.setBackground(Color.LIGHT_GRAY);
		btnChoose.setBounds(971, 353, 67, 35);
		panelDS.add(btnChoose);
		
		JButton button_5 = new JButton("Choose File");
		button_5.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		button_5.setBorder(new LineBorder(Color.black,3));
		button_5.setBackground(Color.LIGHT_GRAY);
		button_5.setBounds(971, 310, 67, 35);
		panelDS.add(button_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 99, 1096, 187);
		panelDS.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBorder(new LineBorder(Color.BLACK, 3));
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(41, 442, 1096, 134);
		panelDS.add(scrollPane_2);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		textArea_2.setBorder(new LineBorder(Color.BLACK, 3));
		scrollPane_2.setViewportView(textArea_2);
		
		JLabel label = new JLabel("จัดทำโดย :  60011212017 นายคุณัฐญ์ คำพรมมาภิรักษ์            60011212116 นายสารัช ธนภัทรภักดี");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(177, 671, 878, 33);
		frmDigitalSignature.getContentPane().add(label);
		
		JButton btnGena = new JButton("Generate Key");
		btnGena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGK.setVisible(true);
				panelMDS.setVisible(false);
				panelDS.setVisible(false);
				panelSessionKey.setVisible(false);
				try {
					GenerateKeys myKeys = new GenerateKeys(2048);
			        myKeys.createKeys();
			        myKeys.writeToFile("MyKeys/publicKey", myKeys.getPublicKey().getEncoded());
			        myKeys.writeToFile("MyKeys/privateKey", myKeys.getPrivateKey().getEncoded());
				} catch (Exception e2) {}
			}
		});
		btnGena.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnGena.setBorder(new LineBorder(Color.black,3));
		btnGena.setBackground(Color.LIGHT_GRAY);
		btnGena.setBounds(177, 11, 134, 31);
		frmDigitalSignature.getContentPane().add(btnGena);
		
		frmDigitalSignature.setBounds(100, 100, 1200, 744);
		frmDigitalSignature.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
