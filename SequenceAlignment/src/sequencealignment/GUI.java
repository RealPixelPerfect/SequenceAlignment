package sequencealignment;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
    
    JLabel header = new JLabel("Sequence Alignment");
    //JTextArea mainText = new  
    
    GUI(){
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
        setTitle("Sequence Alignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);      
    }
    
    class MainPanel extends JPanel{
        
        MainPanel(){
            setBackground(Color.LIGHT_GRAY);
            add(header);
            
        }        

    }
}
