import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

class LoginAwt{
	
	static int TOTALUSERS;
	static int USERSFRIENDSLISTSIZE;
	
	static LinkedList<String> name = new LinkedList<String>();
	static LinkedList<String> userName = new LinkedList<String>();
	static LinkedList<String> password = new LinkedList<String>();
	
	static LinkedList<Integer> gotRequest = new LinkedList<Integer>();
	static LinkedList<Integer> friendsCount = new LinkedList<Integer>();
	
	static LinkedList<String> friendRequestUsers = new LinkedList<String>();
	static LinkedList<Integer> setPlace = new LinkedList<Integer>();
	
	static LinkedList<String> friendUsers = new LinkedList<String>();
	static LinkedList<Integer> placeFriend = new LinkedList<Integer>();
	
	JTextField tf,tf1,tf2,tf3,tf4;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	JFrame fr,fr1,fr2,fr3,fr4,fr5;
	JPasswordField pf;
	
	static private Vector<JLabel> vecLabels = new Vector<JLabel>();
	static private Vector<JButton> vecButtons = new Vector<JButton>();
	//static private Vector<JLabel> vecfLabels = new Vector<JLabel>();
	
	static private Vector<JLabel> fRUser = new Vector<JLabel>();
	static private Vector<JButton> acceptButton = new Vector<JButton>();
	static private Vector<JButton> rejectButton = new Vector<JButton>();
	
	static private Vector<JLabel> fUser = new Vector<JLabel>();
	
	static LinkedList<Integer> dummyInteger = new LinkedList<Integer>();
	static LinkedList<String> dummyString = new LinkedList<String>();
	
	void dummyMethod(){
		for(int i=0;i<TOTALUSERS;i++){
			dummyInteger.add(0);
		}
		for(int i=0;i<TOTALUSERS*USERSFRIENDSLISTSIZE;i++){
			dummyString.add("default");
		}
		friendsCount.addAll(dummyInteger);
		gotRequest.addAll(dummyInteger);
		
		placeFriend.addAll(dummyInteger);
		friendUsers.addAll(dummyString);
		
		setPlace.addAll(dummyInteger);
		friendRequestUsers.addAll(dummyString);
	}
	
	LoginAwt(){
		fr = new JFrame("FACE");
		l = new JLabel("Username");
		l.setBounds(100,50,80,30);
		tf = new JTextField("",8);
		tf.setBounds(200,50,150,30);
		l1 = new JLabel("Password");
		l1.setBounds(100,100,80,30);
		pf = new JPasswordField("",8);
		pf.setBounds(200,100,150,30);
		b = new JButton("Login");
		b.setBounds(80,200,100,30);
		b1 = new JButton("Register");
		b1.setBounds(220,200,100,30);
		
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr.dispose();
				register();
			}
		});
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int n=0;
				String pass = new String(pf.getPassword());
				for(int k=0;k<name.size();k++){
					if(tf.getText().equals(userName.get(k))){
						if(pass.equals(password.get(k))){
							//JOptionPane.showMessageDialog(null, "Login Successfull");
							process(k);
						}
						else{
							JOptionPane.showMessageDialog(null, "Username and Password doesn't match");
							tf.setText("");
							pf.setText("");
						}
					}
					else{
						n++;
					}
				}
				if(n==name.size()){
					JOptionPane.showMessageDialog(null, "Username not registered");
					tf.setText("");
					pf.setText("");
				}
			}
		});
		
		fr.add(l);
		fr.add(l1);
		fr.add(tf);
		fr.add(pf);
		fr.add(b);
		fr.add(b1);
		
		fr.addWindowListener(new WindowAdapter() {

		  @Override
		  public void windowClosing(WindowEvent we)
		  { 
			String ObjButtons[] = {"Yes","No"};
			int PromptResult = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to exit?", "Exit?", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				ObjButtons,ObjButtons[1]);
			if(PromptResult==0)
			{
			  System.exit(0);          
			}
			else if(PromptResult==1){
				new LoginAwt();
			}
		  }
		});
		
		
		fr.setSize(400,400);
		fr.setLayout(null);
		fr.setVisible(true);
	}
	
	void register(){
		fr1 = new JFrame("Register");
		l2 = new JLabel("Name");
		l2.setBounds(100,50,80,30);
		tf2 = new JTextField(8);
		tf2.setBounds(200,50,150,30);
		l3 = new JLabel("Username");
		l3.setBounds(100,100,80,30);
		tf3 = new JTextField(8);
		tf3.setBounds(200,100,150,30);
		l4 = new JLabel("Password");
		l4.setBounds(100,150,80,30);
		tf4 = new JTextField(8);
		tf4.setBounds(200,150,150,30);
		b2 = new JButton("Save");
		b2.setBounds(150,200,100,30);
		b10 = new JButton("Back");
		b10.setBounds(10,10,80,30);
				
		//System.out.println(tf2.getText()+" "+tf.getText().length());
			
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(tf2.getText().length()!=0 && tf3.getText().length()!=0 && tf4.getText().length()!=0){int b=0;
					for(int i=0;i<name.size();i++){
						if(tf2.getText().equals(name.get(i)) || tf3.getText().equals(userName.get(i)) ){
							JOptionPane.showMessageDialog(null,"Name already Exists");
							fr1.dispose();
							register();
						}
						else{
							b++;
						}
					}
					if(b==name.size()){
						name.add(tf2.getText());
						userName.add(tf3.getText());
						password.add(tf4.getText());
						fr1.dispose();
						tf.setText("");
						pf.setText("");
						fr.setVisible(true);
						System.out.println(tf2.getText());
						System.out.println(tf3.getText());
						System.out.println(tf4.getText());
						System.out.println("###################");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Enter in all fields");
				}
				
			}
		});
		
		b10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr1.dispose();
				new LoginAwt();
			}
		});
		
		fr1.add(b10);
		fr1.add(l2);
		fr1.add(l3);
		fr1.add(l4);
		fr1.add(tf2);
		fr1.add(tf3);
		fr1.add(tf4);
		fr1.add(b2);
		
		
		fr1.addWindowListener(new WindowAdapter() {

		  @Override
		  public void windowClosing(WindowEvent we)
		  { 
			String ObjButtons[] = {"Yes","No"};
			int PromptResult = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to exit?", "Exit?", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				ObjButtons,ObjButtons[1]);
			if(PromptResult==0)
			{
			  System.exit(0);          
			}
			else if(PromptResult==1){
				register();
			}
		  }
		});
				
		fr1.setSize(400,400);
		fr1.setLayout(null);
		fr1.setVisible(true);
	}
	
	void process(int k){
		fr.dispose();
		
		fr2 = new JFrame(name.get(k));
		
		l5 = new JLabel("Name");
		l5.setBounds(100,50,80,30);
		l8 = new JLabel(name.get(k));
		l8.setBounds(220,50,80,30);
		l6 = new JLabel("Usernamee");
		l6.setBounds(100,100,80,30);
		l9 = new JLabel(userName.get(k));
		l9.setBounds(220,100,80,30);
		l7 = new JLabel("Password");
		l7.setBounds(100,150,80,30);
		l10 = new JLabel(password.get(k));
		l10.setBounds(220,150,80,30);
		
		b3 = new JButton("Logout");
		b3.setBounds(400,400,80,30);
		
		b4 = new JButton("Users");
		b4.setBounds(100,200,80,30);
		
		b5 = new JButton("Friend Request : "+gotRequest.get(k));
		b5.setBounds(100,250,150,30);
		
		b8 = new JButton("Friend : "+friendsCount.get(k));
		b8.setBounds(100,300,150,30);
		
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr2.dispose();
				new LoginAwt();
				
				tf.setText("");
				pf.setText("");
			}
		});
		
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showUsers(k);
			}
		});
		
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				acceptReject(k);
			}
		});
		
		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				showFriends(k);
			}
		});
		
		
		
		fr2.add(l5);
		fr2.add(l6);
		fr2.add(l7);
		fr2.add(l8);
		fr2.add(l9);
		fr2.add(l10);
		fr2.add(b3);
		fr2.add(b4);
		fr2.add(b5);
		fr2.add(b8);
		
		
		fr2.addWindowListener(new WindowAdapter() {

		  @Override
		  public void windowClosing(WindowEvent we)
		  { 
			String ObjButtons[] = {"Yes","No"};
			int PromptResult = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to exit?", "Exit?", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				ObjButtons,ObjButtons[1]);
			if(PromptResult==0)
			{
			  System.exit(0);          
			}
			else if(PromptResult==1){
				process(k);
			}
		  }
		});
		
		fr2.setSize(600,600);
		fr2.setLayout(null);
		fr2.setVisible(true);
		
	}
	
	void showUsers(int k){
		fr2.dispose();
		fr3 = new JFrame("Users");
		
		b6 = new JButton("back");
		b6.setBounds(10,10,80,30);
		int j=50;
		
		
		
		for(int i=0;i<name.size();i++){
			if(!name.get(i).equals(name.get(k))){
				JLabel label = new JLabel(); 
				label.setText(name.get(i)); 
				label.setBounds(100,j,80,30); 
				vecLabels.add(label); 

				JButton button = new JButton();
				button.setText("Send Request");
				button.setBounds(200,j,150,30);
				vecButtons.add(button);
				
				button.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//JOptionPane.showMessageDialog(null, "Request Sent to "+label.getText());
						button.setText("Request Sent");
						sendRequest(k,label.getText());
						
					}
				});
				//fr3.add(slabel);
				fr3.add(button);
				fr3.add(label);
				j=j+50;
			}
		}
		
		b6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr3.dispose();
				process(k);
			}
		});
		
		fr3.addWindowListener(new WindowAdapter() {

		  @Override
		  public void windowClosing(WindowEvent we)
		  { 
			String ObjButtons[] = {"Yes","No"};
			int PromptResult = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to exit?", "Exit?", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				ObjButtons,ObjButtons[1]);
			if(PromptResult==0)
			{
			  System.exit(0);          
			}
			else if(PromptResult==1){
				showUsers(k);
			}
		  }
		});
		
		fr3.add(b6);
		fr3.setSize(400,400);
		fr3.setLayout(null);
		fr3.setVisible(true);
	}
	
	void sendRequest(int k,String friendChoosed){
		int z=0;
		for(int br=0;br<name.size();br++){
			if(friendChoosed.equals(name.get(br))){
				for(int b=0;b<USERSFRIENDSLISTSIZE;b++){
					if(friendRequestUsers.get(b+(USERSFRIENDSLISTSIZE*br)).equals(name.get(k)) || friendRequestUsers.get(b+(USERSFRIENDSLISTSIZE*k)).equals(friendChoosed)){
						JOptionPane.showMessageDialog(null,"Request Already Sent");
					}
					else if(friendUsers.get(b+(USERSFRIENDSLISTSIZE*br)).equals(name.get(k))){
						JOptionPane.showMessageDialog(null,"User is Already your Friend");
					}
					else{
						z++;
					}
				}
				if(z==USERSFRIENDSLISTSIZE){
					for(int i=0;i<name.size();i++){
						if(friendChoosed.equals(name.get(i))){
							gotRequest.set(i,gotRequest.get(i)+1);
							friendRequestUsers.set(setPlace.get(i)+(USERSFRIENDSLISTSIZE*i),name.get(k));
							setPlace.set(i,setPlace.get(i)+1);
						}
					}
				}
			}
		}
		
		
		
		System.out.println("####FRIEND REQUEST####");
			for(int q=0;q<friendRequestUsers.size();q++){
				if(!friendRequestUsers.get(q).equals("default")){
					System.out.println(q+" : "+friendRequestUsers.get(q));
				}
			}
	}
	
	void acceptReject(int k){
		fr2.dispose();
		fr4 = new JFrame("Users");
		
		b7 = new JButton("back");
		b7.setBounds(10,10,80,30);
		int j=50;
		for(int arr=0;arr<name.size();arr++){
			if(name.get(k).equals(name.get(arr))){
				for(int b=0;b<USERSFRIENDSLISTSIZE;b++){
					if(!friendRequestUsers.get(b+(USERSFRIENDSLISTSIZE*arr)).equals("default")){
						//System.out.println(friendRequestUsers.get(b+(50*arr)));
							JLabel frLabel = new JLabel(); // Creates the JLabel
							frLabel.setText(friendRequestUsers.get(b+(USERSFRIENDSLISTSIZE*arr))); // Sets the name
							frLabel.setBounds(50,j,80,30); // Sets the size
							fRUser.add(frLabel); // Adds the JLabel to the vecLabels. ()
				
							JButton accButton = new JButton();
							accButton.setText("Accept");
							accButton.setBounds(100,j,130,30);
							acceptButton.add(accButton);
				
							JButton decButton = new JButton();
							decButton.setText("Reject");
							decButton.setBounds(240,j,130,30);
							rejectButton.add(decButton);
				
							accButton.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									//JOptionPane.showMessageDialog(null, "You're now friends with "+frLabel.getText());
									for(int a=0;a<name.size();a++){
										if(name.get(k).equals(name.get(a))){
											for(int z=0;z<USERSFRIENDSLISTSIZE;z++){
												if(friendRequestUsers.get(z+(USERSFRIENDSLISTSIZE*a)).equals(frLabel.getText())){
													for(int i=0;i<name.size();i++){
														if(frLabel.getText().equals(name.get(i))){
															friendsCount.set(k,friendsCount.get(k)+1);
															friendsCount.set(i,friendsCount.get(i)+1);
															friendUsers.set(placeFriend.get(k)+(USERSFRIENDSLISTSIZE*a),frLabel.getText());
															friendUsers.set(placeFriend.get(i)+(USERSFRIENDSLISTSIZE*i),name.get(k));
															friendRequestUsers.set(z+(USERSFRIENDSLISTSIZE*a),"default");
															gotRequest.set(k,gotRequest.get(k)-1);
															placeFriend.set(k,placeFriend.get(k)+1);
															placeFriend.set(i,placeFriend.get(i)+1);
															
															fr4.dispose();
															acceptReject(k);
															
															System.out.println("####FRIEND REQUEST######");
															for(int q=0;q<friendRequestUsers.size();q++){
																if(!friendRequestUsers.get(q).equals("default")){
																	System.out.println(q+" : "+friendRequestUsers.get(q));
																}
															}
															System.out.println("####FRIEND USER####");
															for(int w=0;w<friendUsers.size();w++){
																if(!friendUsers.get(w).equals("default")){
																	System.out.println(w+" : "+friendUsers.get(w));
																}
															}
														}
													}
												}
											}
										}
									}
								}
							});
				
							decButton.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									JOptionPane.showMessageDialog(null, "You declined "+frLabel.getText());
									for(int a=0;a<name.size();a++){
										if(name.get(k).equals(name.get(a))){
											for(int z=0;z<USERSFRIENDSLISTSIZE;z++){
												if(friendRequestUsers.get(z+(USERSFRIENDSLISTSIZE*a)).equals(frLabel.getText())){
													for(int i=0;i<name.size();i++){
														if(frLabel.getText().equals(name.get(i))){
															friendRequestUsers.set(z+(USERSFRIENDSLISTSIZE*a),"default");
															gotRequest.set(k,gotRequest.get(k)-1);
															fr4.dispose();
															acceptReject(k);
														}
													}
												}
											}
										}
									}
								}
							});
				
							fr4.add(frLabel);
							fr4.add(accButton);
							fr4.add(decButton); // Adds the label to the JFrame
							j=j+50;
					}
				}
			}
		}
		
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr4.dispose();
				process(k);
			}
		});
		
		fr4.addWindowListener(new WindowAdapter() {

		  @Override
		  public void windowClosing(WindowEvent we)
		  { 
			String ObjButtons[] = {"Yes","No"};
			int PromptResult = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to exit?", "Exit?", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				ObjButtons,ObjButtons[1]);
			if(PromptResult==0)
			{
			  System.exit(0);          
			}
			else if(PromptResult==1){
				acceptReject(k);
			}
		  }
		});
		
		fr4.add(b7);
		fr4.setSize(400,400);
		fr4.setLayout(null);
		fr4.setVisible(true);
	}
	
	void showFriends(int k){
		
		
		
		fr2.dispose();
		fr5 = new JFrame("Friends");
		
		b9 = new JButton("back");
		b9.setBounds(10,10,80,30);
		
		int j=50;
		for(int arr=0;arr<name.size();arr++){
			if(name.get(k).equals(name.get(arr))){
				for(int b=0;b<USERSFRIENDSLISTSIZE;b++){
					if(!friendUsers.get(b+(USERSFRIENDSLISTSIZE*arr)).equals("default")){
							JLabel label = new JLabel(); // Creates the JLabel
							label.setText(friendUsers.get(b+(USERSFRIENDSLISTSIZE*arr))); // Sets the name
							label.setBounds(100,j,80,30); // Sets the size
							fUser.add(label);
							
							fr5.add(label);
							j=j+50;
					}
				}
			}
		}
		
		b9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr5.dispose();
				process(k);
			}
		});
		
		fr5.addWindowListener(new WindowAdapter() {

		  @Override
		  public void windowClosing(WindowEvent we)
		  { 
			String ObjButtons[] = {"Yes","No"};
			int PromptResult = JOptionPane.showOptionDialog(null, 
				"Are you sure you want to exit?", "Exit?", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				ObjButtons,ObjButtons[1]);
			if(PromptResult==0)
			{
			  System.exit(0);          
			}
			else if(PromptResult==1){
				showFriends(k);
			}
		  }
		});
		
		fr5.add(b9);
		fr5.setSize(400,400);
		fr5.setLayout(null);
		fr5.setVisible(true);
	}
	
	public static void main(String args[]){
		LoginAwt la = new LoginAwt();
		
		
		Properties p =new Properties();
		try{
			p.load(new FileInputStream("DB.prop"));
			TOTALUSERS = Integer.parseInt(p.getProperty("USERS"));
			USERSFRIENDSLISTSIZE = Integer.parseInt(p.getProperty("FRIENDSLISTSIZE"));
		}
		catch(IOException ioe){
			System.out.println("Property File Doesn't Exists");
		}
		System.out.println(TOTALUSERS+" "+USERSFRIENDSLISTSIZE);
		
		la.dummyMethod();

	}
}