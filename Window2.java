import javax.swing.*;
import java.awt.*;
public class Window2 extends JFrame implements ActionListener{
 private Container pane;

 private JButton b;
 private JLabel l;
 private JTextField t;
  
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window2() {
     this.setTitle("Temperature Converter");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout()); 
    
     b = new JButton("Convert");
     l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
     t = new JTextField(12);
     pane.add(l);
     pane.add(b);
     pane.add(t);
 }


  public static void main(String[] args) {
     Window2 g = new Window2();
     g.setVisible(true);
  }
}
