package esyenc;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.io.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class Control extends JFrame
	{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private JButton Exchange;
	private JButton Enc;
	private JButton Dec;

	private JTextArea input;

//	private Socket connection;

	private JPanel selections;
	private JScrollPane pane;
	
	private JFrame MainArea;
	public static String key="abcdefghijklnop`";


	public Control()
		{
		super("This is a sentence.");
		MainArea = new JFrame("esyEnc");	
		MainArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input = new JTextArea();
		pane = new JScrollPane(input);

		final AES conv = new AES();
		
		MainArea.add(pane,BorderLayout.CENTER);
		selections = new JPanel();	
		MainArea.add(selections,BorderLayout.SOUTH);


		Enc = new JButton("Encrypt!");
		Enc.addActionListener(
					new ActionListener()
						{
						@Override
						public void actionPerformed(ActionEvent e)
							{
								if(key=="")
									{
									JOptionPane.showMessageDialog(new JFrame(),"No key Found!","error",JOptionPane.ERROR_MESSAGE);
									}
							//	This gets the value of the text field
								else{
									String Text=input.getText();
									
							//	This uses the values
									try {
										String out= conv.Encrypt(Text, key);
										new EncDialog(out);
								//	Debug
										System.out.println(Text+"\n"+out);
										
									} catch (InvalidKeyException
											| NoSuchAlgorithmException
											| NoSuchPaddingException
											| IllegalBlockSizeException
											| BadPaddingException
											| UnsupportedEncodingException e1) {
								// 	TODO Auto-generated catch block
										e1.printStackTrace();
										
									}
									
							
							
								}
							
								}
						
						}
					);

		selections.add(Enc);
			
	
	//	Exchange
		Exchange = new JButton("Enter the Key");
		Exchange.addActionListener(
				new ActionListener()
				{
				@Override
				public void actionPerformed(ActionEvent e)
					{
					
					
					new InputKey();
					
					}
				}
			);


		selections.add(Exchange);
	//	Dec
		Dec = new JButton("Decrypt");
		Dec.addActionListener(
					new ActionListener()
						{
						@Override
						public void actionPerformed(ActionEvent e)
							{
							//This gets the text from the text box 
							String Text;

							if(key=="")
								{
								JOptionPane.showMessageDialog(new JFrame(),"No key Found!","error",JOptionPane.ERROR_MESSAGE);
								}
							else{
								try {
							
								Text = conv.Decrypt(input.getText(),key);
								new EncDialog(Text);
								//Debug
								System.out.println("\nDecrypting..: "+Text);
							} catch (InvalidKeyException
									| NoSuchAlgorithmException
									| NoSuchPaddingException
									| IllegalBlockSizeException
									| BadPaddingException
									| UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							//This does something with it
							
							
							}
						}}
					);
	
		selections.add(Dec);



		MainArea.setSize(1000,300);
		MainArea.setVisible(true);


		}

	public static void main(String args[])
		{
		
							new Control();

		}	
	
	
	}
