import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Tict
implements ActionListener
{
	Tict t;
	static int value[]={2,2,2,2,2,2,2,2,2};
    static String curPlayerSym= "x";
    static int num=0,num1=0,prod,pro,i,j,mov,e=0,r,w=0,zeroth,secnd,trd,fst,chance;
    static boolean z;
	static JFrame f;
	static JButton user=new JButton("first user");
    static JButton computer=new JButton("first comp");
    static JButton  b[] = new JButton[10];
	Tict()
	{
		f=new JFrame("TicTacToe");
		f.setVisible(true);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gl=new GridLayout(0,3);
		f.setLayout(gl);
		for(int i=0;i<9;i++)
		{ 
			b[i]=new JButton("");
			f.add(b[i]);
			b[i].setActionCommand("bu["+i+"]");
			b[i].addActionListener(this);
		}
		f.add(user);
		user.setActionCommand("f");
		user.addActionListener(this);
		f.add(computer);
		computer.setActionCommand("c");
		computer.addActionListener(this);

	}
   public static void changePlayer() 
   {
        if (curPlayerSym == "x")
            curPlayerSym = "o";
        else 
            curPlayerSym= "x";
   }
   public static void placeMark(int place)
   {   
	  
	   if(curPlayerSym=="x")
	   {
		    b[place].setText("x");
		   value[place]=3;
	   }
	   else
	   {
		    b[place].setText("o");
           value[place]=5;
	   }
	   b[place].setEnabled(false);
   }
   public static void compMove()
   {
	   if(num==1)
	   {
		   if(value[4]!=2)
		   {
			   placeMark(0);
			   mov=0;
		   }
		   else
		   {
			   placeMark(4);
			   mov=1;
		   }
	   }
	   if(num==3)
	   {
		   z=possWin("x");		
		   if(z==false)
		   {
			   if(mov==0)
			   {
				   if(value[2]==2)
					   placeMark(2);
				   else if(value[6]==2)
					   placeMark(6);
				   else
					   placeMark(8);
			   }
			   else
			   {
				   if(zeroth==7&&secnd==0)
					   placeMark(5);
				   else if(zeroth==7&&secnd==2)
					   placeMark(5);
				   else if(zeroth==0&&secnd==7)
					   placeMark(5);
				   else if(zeroth==2&&secnd==7)
					   placeMark(3);
				   else if(zeroth==6&&secnd==1)
					   placeMark(5);
				   else if(value[1]==3&&value[3]==3&&value[0]==2)
					   placeMark(0);
				   else if(value[1]==3&&value[5]==3&&value[2]==2)
					   placeMark(2);
				   else if(value[7]==3&&value[3]==3&&value[6]==2)
					   placeMark(6);
				   else if(value[7]==3&&value[5]==3&&value[8]==2)
					   placeMark(8);
				   else if(value[1]==2)
					   placeMark(1);
				   else if(value[3]==2)
					   placeMark(3);
				   else if(value[5]==2)
					   placeMark(5);
				   else
					   placeMark(7);
			   }
		   }
	   }
	   if(num==5||num==7)
	   {
		   z=possWin("o");
		   if(z==true)
			   num=9;
		   else
		   {
			   z=possWin("x");
			   if(z==false)
			   {
                   for (i = 0; i < 9; i++) 
		           {
                             if(value[i]== 2)
							{
								 placeMark(i);		
								 break;
							}
                   }
			   }
		   }
	   }
   }

   public static void compMove1()
   {
	   if(num1==2)
	   {
		   if(fst==8)
			   placeMark(4);
		   else
			   placeMark(8);
	   }
	   if(num1==4)
	   {
		   z=possWin("x");
		   if(z==true)
			   num1=9;
		   else if(z==false)
		   {
			   z=possWin("o");
			   if(z==true){}
			   else if(trd==1)
				   placeMark(6);
			   else if(trd==3)
				   placeMark(2);
		   }
	   }
	   if(num1==6||num1==8)
	   {
		   z=possWin("x");
		   if(z==true)
			   num1=9;
		   else if(z==false)
		   {
			   z=possWin("o");
			   if(z==true){}
			   else 
			   {
				   for(i=0;i<9;i++)
				   {
					   if(value[i]==2)
					   {
						   placeMark(i);
						   break;
					   }
				   }
			   }
		   }
	   }

   }


   public static boolean possWin(String sym)
   {
	   if(sym=="x")
		   pro=18;
	   else
		   pro=50;
	   for(int a=0;a<=6;a+=3)//row check
	   {
		   prod=value[a]*value[a+1]*value[a+2];
		   if(prod==pro)
		   {
			   if(value[a]==2)
				   placeMark(a);
			   else if(value[a+1]==2)
                   placeMark(a+1);
			   else
				   placeMark(a+2);
			   return true;
		   }
	   }
	   for(int b=0;b<3;b++)//col check
	   {
		    prod=value[b]*value[b+3]*value[b+6];
		    if(prod==pro)
		   {
			   if(value[b]==2)
				   placeMark(b);
			   else if(value[b+3]==2)
                   placeMark(b+3);
			   else
				   placeMark(b+6);
			   return true;
		   }
	   }
	   if(value[0]*value[4]*value[8]==pro)//diagnol
	   {
			   if(value[0]==2)
				   placeMark(0);
			   else if(value[4]==2)
                   placeMark(4);
			   else
				   placeMark(8);
			   return true;
	   }
	   else if(value[2]*value[4]*value[6]==pro)//diagnol
	   {
			   if(value[2]==2)
				   placeMark(2);
			   else if(value[4]==2)
                   placeMark(4);
			   else
				   placeMark(6);
			   return true;
	   }			
	   else //no win
		   return false;
   }
    public static void main(String args[])
	{
		Tict t=new Tict(); 
	}
	public void actionPerformed(ActionEvent a)
	{
		    String e=a.getActionCommand();		
			 if(e.equals("f"))
		     {
				 chance=0;
				 user.setEnabled(false);
			 }
			 else if(e.equals("c"))
		     {
				  chance=1;
				  computer.setEnabled(false);
			 }
		else if(chance==0)//first user
		{
			    for(int m=0;m<9;m++)
				{
                       if(e.equals("bu["+m+"]"))
				              r=m;
				}
				if(num==0)
					zeroth=r;
				if(num==2)
					secnd=r;
			if(curPlayerSym=="x")
			{
		        placeMark(r);			
				num++;
				if(num==9)
				{
					w=1;
					JOptionPane.showMessageDialog(null, "Draw..........!!");
				}
			    changePlayer();
				compMove();
				num++;
			    changePlayer();
			}
	}
		else  //first comp
		{
			for(int m=0;m<9;m++)
		    {
                  if(e.equals("bu["+m+"]"))
				       r=m;
			}
			if(num1==1)
					fst=r;
			if(num1==3)
					trd=r;
			 if(num1==0)
			{
				placeMark(0);
				num1++;
				changePlayer();
			}			
		    else if(curPlayerSym=="o")//comp
			{
                placeMark(r);
				num1++;
			    changePlayer();
				compMove1();
				num1++;
				if(num1==9)
				{
					w=1;
					JOptionPane.showMessageDialog(null, "Draw..........!!");
				}
			    changePlayer();
			}
		}
			if((num==10&&(w!=1))||(num1==10&&(w!=1)))
		    {
			     JOptionPane.showMessageDialog(null, "Computer Wins.....!!!");
			     w=1;
		     }
		if(w==1)
		{
		    for(i=0;i<9;i++)
	        {     
				b[i].setText("");
				value[i]=2;
				b[i].setEnabled(true);
		    }
			num=0;
			num1=0;
			w=0;
			curPlayerSym="x";
			user.setEnabled(true);
			computer.setEnabled(true);
		}
	}
}
