package esyenc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class InputKey extends JFrame{

	private JButton ok;
	private JTextField in;
	private JFrame part;
	InputKey()
	{
		super("This is to enter the key");
		part = new JFrame();
		part.setLayout(new FlowLayout());
		JLabel l = new JLabel("Key:");
		part.add(l);
		
		in = new JTextField(32);
		in.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String temp = in.getText();
						if(!(temp=="")&&Control.key!="")
						{
							while(!(ispowerof2(temp.length()) && temp.length()>=16))
							{temp +="\0";}
						
					
							Control.key=temp;
						}
						part.setVisible(false);
						part.dispose();						
					}
					
				});
		part.add(in);
		
		ok = new JButton("Submit");
		ok.addActionListener(
				new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						String temp = in.getText();
						if(!(temp=="")&&Control.key!="")
						{
							while(!(ispowerof2(temp.length()) && temp.length()>=16))
							{temp +="\0";}
						
					
							Control.key=temp;
						}
						part.setVisible(false);
						part.dispose();						
					}
					
				});
		part.add(ok);
		part.setSize(600, 100);
		part.setVisible(true);
		
	}
	public static boolean ispowerof2(int i)
    {
    if(i==1)
            return true;

    else if (i%2==0)
            {return ispowerof2(i/2);}
    else
            return false;
    }

}
