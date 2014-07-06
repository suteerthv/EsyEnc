


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;


public class EncDialog extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton Copy;
	private JFrame Area;
	private JPanel pan;
	private JTextArea inter;
	private JScrollPane pane;
	
	EncDialog(String s)
			{
				super("This is a title");
				Area = new JFrame("Output");
				Area.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				pan = new JPanel();
				Copy = new JButton("Copy!");
				
				inter=new JTextArea(s);
				final String temp = inter.getText();
				pane = new JScrollPane(inter);
				inter.setForeground(Color.BLACK);
				inter.setEnabled(false);
				
				
		        final Clipboard clipboard =Area.getToolkit().getSystemClipboard();
		        


				Copy = new JButton("COPY!");
				Copy.addActionListener(
						new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
											{
											String selection = temp;
											StringSelection data = new StringSelection(selection);
											clipboard.setContents(data, data);
											Area.setVisible(false);
											Area.dispose();

											}
								}	
						);

		        pan.add(Copy);
		        
				
				Area.add(pan,BorderLayout.SOUTH);
				
				Area.add(pane, BorderLayout.CENTER);
				
				
				Area.setSize(400,100);
				Area.setVisible(true);
				
			}

}
