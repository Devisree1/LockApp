import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LockApp extends JFrame
{
	JPanel p1;
	JPanel p2;
	JTextField jt1;
	JTextField jt2;
	JLabel l;
	JButton[] b;
	JButton btnc,btne;
	String nums="",msg="",String pin="";

	public LockApp()
	{
		//Logic to generate OTP Pin
		int min = 1000;
		int max = 10000;
		pin = Integer.toString((int)(Math.random()*(max-min+1)+min));
		
		//Create it	
		p1 = new JPanel();
		p2 = new JPanel();
		jt1 = new JTextField("Enter OTP:",10);
		jt2 = new JTextField(10);
		l = new JLabel("Your OTP:");
		b = new JButton[10];
		btnc = new JButton("Clear");
		btne = new JButton("Enter");
       		
			for(int i=0;i<=9;i++)
		{
			b[i] = new JButton(Integer.toString(i));
			p2.add(b[i]);
		}
		
		//Configure it
		
		setVisible(true);
		setSize(350,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lock Application");
		
		//Add it
		setLayout(new BorderLayout());
		p1.setLayout(new FlowLayout());
		p2.setLayout(new GridLayout(4,3));
		p1.add(jt1);
		p1.add(l);
		p1.add(jt2);
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		p2.add(btnc);
		p2.add(btne);
		jt2.setText(pin);
		
		//Listen it
		for(int n=0;n<=9;n++)
		{
			b[n].addActionListener(new BtnListener1());
		}
		btnc.addActionListener(new BtnListener2());
		btne.addActionListener(new BtnListener2());
	}
	
	class BtnListener1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			nums+=e.getActionCommand();
			msg+="*";
			jt1.setText(msg);
		}
	}

	class BtnListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == btnc)
			{
				jt1.setText("");
				msg = nums = "";
				jt1.setBackground(Color.WHITE);
			}
			if(e.getSource() == btne)
			{
				if(nums.equals(pin))
				{
					jt1.setBackground(Color.GREEN);
				             jt1.setText("OPEN");
				}
                                                     else
				{
					jt1.setBackground(Color.RED);
				             jt1.setText("CLOSE");
				}
			}
		}
	}

	public static void main(String args[])
	{
		new LockApp();
	}
	
}