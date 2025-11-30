import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EnigmaFrame extends JFrame{
    // GUI components
    private JComboBox<Integer> innerRotor, middleRotor, outerRotor;
    private JTextField startPositions;
    private JTextArea inputText, outputText;
    private JButton encryptButton, decryptButton;
   

    public EnigmaFrame() {
      setTitle("Enigma GUI");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(800, 350);
      setLayout(new BorderLayout());
  
      // ---------- TOP BAR (like screenshot) ----------
      JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 5));
  
      // Rotor dropdowns
      top.add(new JLabel("Inner"));
      innerRotor = new JComboBox<>(new Integer[]{1,2,3,4,5});
      top.add(innerRotor);
  
      top.add(new JLabel("Middle"));
      middleRotor = new JComboBox<>(new Integer[]{1,2,3,4,5});
      top.add(middleRotor);
  
      top.add(new JLabel("Out"));
      outerRotor = new JComboBox<>(new Integer[]{1,2,3,4,5});
      top.add(outerRotor);
  
      // Start positions
      top.add(new JLabel("Initial Positions"));
      startPositions = new JTextField(4);
      top.add(startPositions);
  
      // Buttons on same row
      encryptButton = new JButton("Encrypt");
      decryptButton = new JButton("Decrypt");
      top.add(encryptButton);
      top.add(decryptButton);
  
      add(top, BorderLayout.NORTH);
  
    }
  }