import javax.swing.*;
import java.awt.event.*;
public class EnigmaFrame extends JFrame{
   /*  
    private JComboBox<String> Rotornums;
    
    private JTextField rotorStart;
    private JTextField rotorEnd;
    
    private JTextArea input;
    private JTextArea output;
    
    private JButton encrypt;
    private JButton decrypt;

    private JLabel inner;
    private JLabel outer;
    */
  private JComboBox<Integer> innerRotor, middleRotor, outerRotor;
  private JTextField startPositions;
  private JTextArea inputText, outputText;
  private JButton encryptButton, decryptButton;

   
//public static class WindowDisposer extends WindowAdapter {
    //int count;

    //public WindowDisposer(int i) {
     //  count = i; //initialize with the number of windows
   // }
//}
  private int id;

  public EnigmaFrame(int id, WindowDisposer wd) {
    this.id = id;
    this.setTitle("Enigma GUI" + this.id);
    this.setSize(300, 400);
    this.setLocation(100 + 10 * this.id, 100 + 10 * this.id);
    this.addWindowListener(wd);//set up the window listener
  }
 
  public int getId() {
    return id;
  }  
}

