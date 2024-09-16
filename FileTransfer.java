import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.*;


class body implements ActionListener
{
JFrame window;
JPanel content;
JButton SEND,RECEIVE;

/* Variables For Server */
JButton back;
JLabel s_c_info;
JLabel ipadd;
JTextField sf1,s_b;
JButton s_browse;
JLabel s_f_name;
JLabel s_status;
JButton s_send;
JTextField s_status_show;
JFileChooser s_f_choose;
String s1=null,s2=null;
String server_inet="127.0.0.1";
ServerSocket server;
Socket server_sock;

/* Variables For Client */

JButton back_c;
JLabel c_c_info;
JLabel c_ipadd;
JTextField cf1,c_b;
JButton c_browse;
JLabel c_f_name;
JLabel c_status;
JButton c_receive;
JTextField c_status_show;
JFileChooser c_f_choose;
String s3=null,s4=null,s5=null,s6=null;
String client_inet=null;
Socket client_sock;
String c_file;
String final_file;


body()
{


/* Layout */
content=new JPanel();

content.setLayout(null);

/*Layout for server*/

back=new JButton("<--");
back.addActionListener(this);
back.setEnabled(false);
back.setVisible(false);
back.setBounds(10,10,50,30);
content.add(back);

s_c_info=new JLabel("Connecting Information");
s_c_info.setVisible(false);
s_c_info.setBounds(150,30,250,100);
s_c_info.setFont(new Font("Baskerville",Font.BOLD,18));
s_c_info.setForeground(new Color(100,40,40));
content.add(s_c_info);

ipadd=new JLabel("IP Address");
ipadd.setVisible(false);
ipadd.setBounds(15,60,100,100);
ipadd.setFont(new Font("Baskerville",Font.BOLD,12));
ipadd.setForeground(new Color(100,0,40));
content.add(ipadd);


sf1=new JTextField(16);
sf1.setVisible(false);
sf1.setBounds(100,100,200,20);
content.add(sf1);


s_f_name=new JLabel("Select File");
s_f_name.setVisible(false);
s_f_name.setBounds(15,150,60,20);
s_f_name.setFont(new Font("Baskerville",Font.BOLD,12));
s_f_name.setForeground(new Color(100,0,40));
content.add(s_f_name);


s_b=new JTextField(100);
s_b.setEnabled(false);
s_b.setVisible(false);
s_b.setBounds(100,150,200,20);
content.add(s_b);


s_browse=new JButton("Browse");
s_browse.addActionListener(this);
s_browse.setEnabled(false);
s_browse.setVisible(false);
s_browse.setBounds(310,150,80,20);
content.add(s_browse);




s_status=new JLabel("Status");
s_status.setVisible(false);
s_status.setBounds(15,200,40,20);
s_status.setFont(new Font("Baskerville",Font.BOLD,12));
s_status.setForeground(new Color(100,0,40));
content.add(s_status);

s_status_show=new JTextField(100);
s_status_show.setEnabled(false);
s_status_show.setVisible(false);
s_status_show.setBounds(100,200,200,20);
content.add(s_status_show);


s_send=new JButton("Send");
s_send.addActionListener(this);
s_send.setEnabled(false);
s_send.setVisible(false);
s_send.setBounds(200,260,80,30);
content.add(s_send);



/* Layout For client Section */

back_c=new JButton("<--");
back_c.addActionListener(this);
back_c.setEnabled(false);
back_c.setVisible(false);
back_c.setBounds(10,10,50,30);
content.add(back_c);


c_c_info=new JLabel("Connecting Information");
c_c_info.setVisible(false);
c_c_info.setBounds(150,30,250,100);
c_c_info.setFont(new Font("Baskerville",Font.BOLD,18));
c_c_info.setForeground(new Color(100,40,40));
content.add(c_c_info);


c_ipadd=new JLabel("IP Address");
c_ipadd.setVisible(false);
c_ipadd.setBounds(15,60,100,100);
c_ipadd.setFont(new Font("Baskerville",Font.BOLD,12));
c_ipadd.setForeground(new Color(100,0,40));
content.add(c_ipadd);


cf1=new JTextField(16);
cf1.setText(" ");
cf1.setVisible(false);
cf1.setBounds(100,100,200,20);
content.add(cf1);


c_b=new JTextField(100);
c_b.setEnabled(false);
c_b.setVisible(false);
c_b.setBounds(100,150,200,20);
content.add(c_b);


c_f_name=new JLabel("Select Folder");
c_f_name.setVisible(false);
c_f_name.setBounds(10,150,80,20);
c_f_name.setFont(new Font("Baskerville",Font.BOLD,12));
c_f_name.setForeground(new Color(100,0,40));
content.add(c_f_name);


c_browse=new JButton("Browse");
c_browse.addActionListener(this);
c_browse.setEnabled(false);
c_browse.setVisible(false);
c_browse.setBounds(310,150,80,20);
content.add(c_browse);


c_status=new JLabel("Status");
c_status.setVisible(false);
c_status.setBounds(15,200,40,20);
c_status.setFont(new Font("Baskerville",Font.BOLD,12));
c_status.setForeground(new Color(100,0,40));
content.add(c_status);

c_status_show=new JTextField(100);
c_status_show.setEnabled(false);
c_status_show.setVisible(false);
c_status_show.setBounds(100,200,200,20);
content.add(c_status_show);


c_receive=new JButton("Receive");
c_receive.addActionListener(this);
c_receive.setEnabled(false);
c_receive.setVisible(false);
c_receive.setBounds(200,260,80,30);
content.add(c_receive);




/*Layout for first page*/

SEND=new JButton("   SEND   ");
SEND.addActionListener(this);
SEND.setBounds(200,100,100,50);
content.add(SEND);

RECEIVE=new JButton("RECEIVE");
RECEIVE.addActionListener(this);
RECEIVE.setBounds(200,250,100,50);
content.add(RECEIVE);


/*Layout For Window*/
window=new JFrame("File Transfer");
window.setIconImage(Toolkit.getDefaultToolkit().getImage("picture.png"));
window.setLayout(null);
window.setSize(500,500);
window.setResizable(false);
window.setContentPane(content);
window.setLocation(450,130);
window.getContentPane().setBackground(new Color(10,80,100));
window.setVisible(true);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}//end of constructor


public void actionPerformed(ActionEvent e)
{

/////////////////////////Server Portion////////////////////////////////////

/*code execute when SEND button is pressed */

if(e.getSource()==SEND)
{
ip();

window.setTitle("Send");
SEND.setEnabled(false);
SEND.setVisible(false);

RECEIVE.setEnabled(false);
RECEIVE.setVisible(false);

back.setEnabled(true);
back.setVisible(true);

s_c_info.setVisible(true);

ipadd.setVisible(true);

sf1.setVisible(true);

s_browse.setEnabled(true);
s_browse.setVisible(true);

s_b.setEnabled(true);
s_b.setVisible(true);

s_f_name.setVisible(true);

s_status.setVisible(true);

s_send.setEnabled(true);
s_send.setVisible(true);

s_status_show.setEnabled(false);
s_status_show.setVisible(true);

}//end if for send button


/*code executed when back button is pressed */

if(e.getSource()==back)
{
window.setTitle("File Transfer");
SEND.setEnabled(true);
SEND.setVisible(true);

RECEIVE.setEnabled(true);
RECEIVE.setVisible(true);

back.setEnabled(false);
back.setVisible(false);

s_c_info.setVisible(false);

ipadd.setVisible(false);

sf1.setVisible(false);

s_browse.setEnabled(false);
s_browse.setVisible(false);

s_b.setEnabled(false);
s_b.setVisible(false);

s_f_name.setVisible(false);

s_status.setVisible(false);

s_send.setEnabled(false);
s_send.setVisible(false);

s_status_show.setEnabled(false);
s_status_show.setVisible(false);

}//end if for back button


/* code execute when server browse button is pressed */

if(e.getSource()==s_browse)
{
filechoose();

}




if(e.getSource()==s_send)
{
   
       s_status_show.setText("Server mode Enabled");

try
{
TimeUnit.SECONDS.sleep(1);
SwingUtilities.invokeLater(new Runnable() {
      public void run() {
serv();

      }
    });
}
catch(Exception ae)
{
}

}


/////////////////////////////Client Portion///////////////////////////////

/* Code Executed When RECEIVE Button is pressed */

if(e.getSource()==RECEIVE)
{
window.setTitle("Receive");

back_c.setEnabled(true);
back_c.setVisible(true);

SEND.setEnabled(false);
SEND.setVisible(false);

RECEIVE.setEnabled(false);
RECEIVE.setVisible(false);

c_c_info.setVisible(true);

cf1.setEnabled(true);
cf1.setVisible(true);

c_ipadd.setVisible(true);

c_f_name.setVisible(true);

c_b.setEnabled(true);
c_b.setVisible(true);

c_browse.setEnabled(true);
c_browse.setVisible(true);

c_status.setVisible(true);

c_status_show.setEnabled(false);
c_status_show.setVisible(true);

c_receive.setEnabled(true);
c_receive.setVisible(true);

}

/* Code for client back button */

if(e.getSource()==back_c)
{
window.setTitle("File Transfer");
SEND.setEnabled(true);
SEND.setVisible(true);

RECEIVE.setEnabled(true);
RECEIVE.setVisible(true);

back_c.setEnabled(false);
back_c.setVisible(false);

c_c_info.setVisible(false);

cf1.setEnabled(false);
cf1.setVisible(false);

c_ipadd.setVisible(false);

c_f_name.setVisible(false);

c_b.setEnabled(false);
c_b.setVisible(false);

c_browse.setEnabled(false);
c_browse.setVisible(false);

c_status.setVisible(false);

c_status_show.setEnabled(false);
c_status_show.setVisible(false);

c_receive.setEnabled(false);
c_receive.setVisible(false);
}

if(e.getSource()==c_browse)
{
c_filechoose();
}


if(e.getSource()==c_receive)
{

c_status_show.setText("Client Mode Enabled");

try
{
TimeUnit.SECONDS.sleep(1);
SwingUtilities.invokeLater(new Runnable() {
      public void run() {
cli();

      }
    });
}
catch(Exception ae)
{
}

}

}//end of action performing function





/* Place for function defining */


/////////////////////////////Server Functions//////////////////////


/*Load IP address to server IP address bar */

void ip()
{
try
{
server_inet=InetAddress.getLocalHost().getHostAddress();
sf1.setText(server_inet);
sf1.setEnabled(false);

}
catch(Exception e)
{
s_status_show.setText("Error in Obtaining IP address");
}

}


void filechoose()
{
int r;
s_f_choose=new JFileChooser();
r=s_f_choose.showOpenDialog(s_browse);

if(r==JFileChooser.APPROVE_OPTION)
{
s1=s_f_choose.getSelectedFile().getPath();
s2=s_f_choose.getSelectedFile().getName();
s_b.setText(s1);
s_status_show.setText("File Selected");
}

}


void serv()
{

if(s1==null)
{
s_status_show.setText("Please Select The File First");
}

else if(server_inet.equals("127.0.0.1")==true)
{
s_status_show.setText("Not Connected To Internet");
}

else
{

try

{
s_status_show.setText(s_status_show.getText()+"waiting");
s_status_show.repaint();

server=new ServerSocket();
server.bind(new InetSocketAddress(server_inet,8888),5);
server.setSoTimeout(600000);
server_sock=server.accept();



s_status_show.setText("Client Connected");

FileInputStream server_file=new FileInputStream(s1);

OutputStream out=server_sock.getOutputStream();
DataOutputStream s_out=new DataOutputStream(out);
s_out.writeUTF(s2);
 


s_status_show.setText("Sending File");

int x;
while(true)
{

x=server_file.read();

if(x==-1)
break;

out.write(x);

}



s_status_show.setText("File Successfully Send");

      

server_file.close();
s_out.close();
out.flush();
server.close();
server_sock.close();


}
catch(Exception e)
{
s_status_show.setText("Client Not Connected");
}

}//end of else

}

///////////////////////////////////////////Client Functions///////////////////////////////////////

void c_filechoose()
{
c_f_choose=new JFileChooser();

c_f_choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

int x=c_f_choose.showOpenDialog(c_browse);

if(x==JFileChooser.APPROVE_OPTION)
{
s3=c_f_choose.getCurrentDirectory().toString();
s4=c_f_choose.getSelectedFile().toString();
}

s5=s3+s4;
System.setProperty("user.dir", s3);


c_b.setText(s5);

c_status_show.setText("File Selected");


}//end of c_filechooser function

/////////////////////////Client Socket///////////////////////////////////
void cli()
{
client_inet=cf1.getText();

if(s3==null)
{
c_status_show.setText("Please Select The File");
}
else if(client_inet.equals(" ")==true)
{
c_status_show.setText("Please Enter IP Address");
}

else
{
client_inet=cf1.getText();
s6=client_inet.replace(" ","");

try
{
client_sock=new Socket();
client_sock.connect(new InetSocketAddress(s6,8888),600000);

InputStream c_in=client_sock.getInputStream();
DataInputStream c_d_in=new DataInputStream(c_in);

c_file=c_d_in.readUTF();

final_file=c_file;


FileOutputStream c_fout=new FileOutputStream(final_file);
 
int x=0;
while(true)
{
x=c_in.read();

if(x==-1)
break;

c_fout.write(x);
}

c_status_show.setText("File Successfully Received");

c_fout.flush();
c_fout.close();
c_d_in.close();
c_in.close();
client_sock.close();
}

catch(Exception q)
{
c_status_show.setText("Error In Connection");
}

}//end of else

}//end of function

}//end of body class


public class FileTransfer
{
public static void main(String[] args)
{


try
{
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch(Exception e)
{
}

body transfer=new body();
}//end of void main

}//end of class File Transfer