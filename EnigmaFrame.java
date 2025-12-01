import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EnigmaFrame extends JFrame{
    // GUI components
    //Jcombobox storing integers for Inner, Middle, and outerroter
    //Jtextfield for entering initial positions
    //Jtextarea for inputtext and outputtext
    //Jbuttons to encrypt and decrypt
    private JComboBox<Integer> innerRotor, middleRotor, outerRotor;
    private JTextField startPositions;
    private JTextArea inputText, outputText;
    private JButton encryptButton, decryptButton;
   

    public EnigmaFrame() {
      //makes the title say Engima GUI
      setTitle("Enigma GUI");
      //makes the frame close on the exit button
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //gets the correct sizing, altered based on what the example looks like
      setSize(800, 350);
      //looks like example.
      setLayout(new BorderLayout());

  
      // ---------- TOP BAR (similar to screenshot) ----------
      JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 5));
  
      // Rotor dropdowns allowing to select Inner from the top menu, choosing from 1 to 5
      top.add(new JLabel("Inner"));
      innerRotor = new JComboBox<>(new Integer[]{1,2,3,4,5});
      top.add(innerRotor);
      //same as the Inner rotor except middle
      top.add(new JLabel("Middle"));
      middleRotor = new JComboBox<>(new Integer[]{1,2,3,4,5});
      top.add(middleRotor);

      //Out to look like example
      top.add(new JLabel("Out"));
      outerRotor = new JComboBox<>(new Integer[]{1,2,3,4,5});
      top.add(outerRotor);
  
      // Start positions
      top.add(new JLabel("Initial Positions"));
      startPositions = new JTextField(4);
      top.add(startPositions);
  
      // Buttons on same row, allowing us to encrypt or decrypt
      encryptButton = new JButton("Encrypt");
      decryptButton = new JButton("Decrypt");
      top.add(encryptButton);
      top.add(decryptButton);
  
      add(top, BorderLayout.NORTH);
  //CENTER TEXT AREAS 
  JPanel textPanel = new JPanel(new GridLayout(2, 1, 5, 5));
  //allowing us to input what we want to encrypt or decrypt
  inputText = new JTextArea();
  inputText.setBorder(BorderFactory.createTitledBorder("Input"));
  textPanel.add(new JScrollPane(inputText));
//allows us to write in output
  outputText = new JTextArea();
  outputText.setBorder(BorderFactory.createTitledBorder("Output"));
  textPanel.add(new JScrollPane(outputText));

  add(textPanel, BorderLayout.CENTER);

  // ---------- ACTION LISTENERS ----------
  //
  //when encrypt button is pressed, processtext is called.
  encryptButton.addActionListener(e -> processText(true));
  //if decrypt button is pressed, processtext is called, but encrypt is false.
  decryptButton.addActionListener(e -> processText(false));

  setVisible(true);
}

private void processText(boolean encrypt) {
  try {

      // Get rotor numbers from what user entered in GUI
      int inner = (int) innerRotor.getSelectedItem();
      int middle = (int) middleRotor.getSelectedItem();
      int outer = (int) outerRotor.getSelectedItem();

      // Get starting positions, checks if user inputs at least 3, if not then prompt user to input 3.
      String start = startPositions.getText().trim();
      if (start.length() != 3) {
          JOptionPane.showMessageDialog(this, "Enter exactly 3 starting characters!", "Error", JOptionPane.ERROR_MESSAGE);
          return;
      }

      // Create Enigma instance
      Enigma enigma = new Enigma(inner, middle, outer, start);

      //Retrieves what user inputs into input text area, replaceAll removes all whitespaces and makes them nothing
      //converts letters to uppercase because enigma mainly works with uppercase letters.
      String input = inputText.getText().replaceAll("\\s", "").toUpperCase();
      //result is equal to encrypt or decrypt of the altered input.
      String result = encrypt ? enigma.encrypt(input) : enigma.decrypt(input);
      //sets output equal to the result variable
      outputText.setText(result);
      // if encrypt or decrypt unsuccessful due to some issue it will display an error message.
  } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
  }
}
}




