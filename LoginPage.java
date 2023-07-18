import java.util.*; 
import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;

public class LoginPage implements ActionListener{

  JFrame frame = new JFrame();
  JButton loginButton = new JButton("Login");
  JButton resetButton = new JButton("Reset");
  JTextField userIDField = new JTextField();
  JPasswordField userPasswordField = new JPasswordField();
  JLabel userIDLabel = new JLabel("userID:");
  JLabel userPasswordLabel = new JLabel("password:");
  JLabel messageLabel = new JLabel();

  //create HashMap 
  HashMap<String, String> loginInfo = new HashMap <String, String>();

  LoginPage(HashMap<String, String> loginInfoOriginal){
    loginInfo = loginInfoOriginal;

    //create user label 
    userIDLabel.setBounds(50,100,75,25);
    userPasswordLabel.setBounds(50,150,75,25);

    //create message label
    messageLabel.setBounds(125,250,250,35);
    messageLabel.setFont(new Font(null,Font.ITALIC, 25));

    //create field where user can enter in username 
    userIDField.setBounds(125,100,200,25);
    //create field where user can enter in password
    userPasswordField.setBounds(125,150,200,25);

    //create login button
    loginButton.setBounds(125,200,100,25);
    loginButton.setFocusable(false); //gets rid of outline on button
    loginButton.addActionListener(this);

    //create reset button
    resetButton.setBounds(225,200,100,25);
    resetButton.setFocusable(false); //gets rid of outline on button
    resetButton.addActionListener(this);

    //adding frames
    frame.add(userIDLabel);
    frame.add(userPasswordLabel);
    frame.add(messageLabel);
    frame.add(userIDField);
    frame.add(userPasswordField);
    frame.add(loginButton);
    frame.add(resetButton);
    //formatting frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420,420);
    frame.setLayout(null);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e){

    //reset button clears fields 
    if(e.getSource()==resetButton){
      userIDField.setText("");
      userPasswordField.setText("");
    }
    if(e.getSource()==loginButton){
      String userID = userIDField.getText();
      //retrieve the password, convert to string, then store within password variable 
      String password = String.valueOf(userPasswordField.getPassword());

      //if username entered in is correct
      if(loginInfo.containsKey(userID)){
        //if login is successful 
        if(loginInfo.get(userID).equals(password)){
          messageLabel.setForeground(Color.green);
          messageLabel.setText("Login successful");
          frame.dispose();
          WelcomePage welcomePage = new WelcomePage(userID);
        }
        else{
          //if the password entered by user is incorrect 
          messageLabel.setForeground(Color.red);
          messageLabel.setText("Wrong Password");
        }
      }
      else{
        //if username entered in is incorrect 
        messageLabel.setForeground(Color.red);
        messageLabel.setText("username not found");
      }
    }
  }
}
