package sequencealignment;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class GUI extends JFrame {
    
    JLabel header = new JLabel("Sequence Alignment");
    Grid grid = new Grid();
    
    GUI(){
        MainPanel mainPanel = new MainPanel();
        add(grid);
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
        }        

    }
    
    class Grid extends JPanel{
        
        Grid(){
            GridBagLayout grid = new GridBagLayout();
            setLayout(grid);
            add(new JLabel("Type: "));
            
            //Grid Constraints
            GridBagConstraints c = new GridBagConstraints();
            c.gridheight = 5;
            c.gridwidth = 5;
            
            
            //Type buttons
            JRadioButton dnaTypeRadioButton = new JRadioButton("DNA");
            JRadioButton rnaTypeRadioButton = new JRadioButton("RNA");
            JRadioButton proteinTypeRadioButton = new JRadioButton("Protein");        
            ButtonGroup typeGroup = new ButtonGroup();
            typeGroup.add(dnaTypeRadioButton);
            typeGroup.add(rnaTypeRadioButton);
            typeGroup.add(proteinTypeRadioButton);
            dnaTypeRadioButton.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){/*ADD CODE HERE*/}});
            rnaTypeRadioButton.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){/*ADD CODE HERE*/}});
            proteinTypeRadioButton.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){/*ADD CODE HERE*/}});
            add(dnaTypeRadioButton);
            add(rnaTypeRadioButton);
            add(proteinTypeRadioButton);
            
            
            
            add(new JButton("Long-Named Button 4"));
            add(new JButton("5"));
        }
        
    }
}
