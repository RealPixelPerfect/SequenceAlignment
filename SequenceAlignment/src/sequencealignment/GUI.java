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
            //add(new JLabel("Type: "));
            
            //Grid Constraints
            GridBagConstraints gbc = new GridBagConstraints();
            //gbc.gridheight = 6;
            //gbc.gridwidth = 9;
            
            gbc.fill = GridBagConstraints.NONE;
            gbc.ipadx = 50;
            gbc.ipady = 50;
            
            //Sequence 1 label
            JLabel seq1Label = new JLabel("Sequence 1");
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            
            add(seq1Label, gbc);
            
            //Sequence 1 textpane
            
            JTextArea seq1Area = new JTextArea(5, 50);
            seq1Area.setLineWrap(true);
            JScrollPane seq1Pane = new JScrollPane(seq1Area);
            seq1Pane.setLayout(new ScrollPaneLayout());
            seq1Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.gridwidth = 6;
            gbc.gridheight = 2;
            add(seq1Pane, gbc);
            
            //Sequence 2 lable
            JLabel seq2Label = new JLabel("Sequence 2");
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(seq2Label, gbc);
            
            //Sequence 2 textpane            
            JTextArea seq2Area = new JTextArea(5, 50);
            seq2Area.setLineWrap(true);
            JScrollPane seq2Pane = new JScrollPane(seq2Area);
            seq2Pane.setLayout(new ScrollPaneLayout());
            seq2Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            gbc.gridx = 2;
            gbc.gridy = 3;
            gbc.gridwidth = 6;
            gbc.gridheight = 2;
            add(seq2Pane, gbc);
            
            //Convert DNA Button
            JButton convertDNAButton = new JButton("   Convert DNA   ");
            gbc.gridx = 9;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(convertDNAButton, gbc);
            
            //Convert RNA Button
            JButton convertRNAButton = new JButton("   Convert RNA   ");
            gbc.gridx = 9;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(convertRNAButton, gbc);
            
            //Convert Protein Button
            JButton convertProteinButton = new JButton("Convert Protein");
            gbc.gridx = 9;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(convertProteinButton, gbc);
            
            //Sequence Align Button
            JButton sequenceAlignButton = new JButton("Sequence Align");
            gbc.gridx = 9;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(sequenceAlignButton, gbc);
            
            
            
            
            
            
            
            //Type buttons
           /* JRadioButton dnaTypeRadioButton = new JRadioButton("DNA");
            JRadioButton rnaTypeRadioButton = new JRadioButton("RNA");
            JRadioButton proteinTypeRadioButton = new JRadioButton("Protein");        
            ButtonGroup typeGroup = new ButtonGroup();
            typeGroup.add(dnaTypeRadioButton);
            typeGroup.add(rnaTypeRadioButton);
            typeGroup.add(proteinTypeRadioButton);
            dnaTypeRadioButton.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){/*ADD CODE HERE*///}});
            //rnaTypeRadioButton.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){/*ADD CODE HERE*///}});
            //proteinTypeRadioButton.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){/*ADD CODE HERE*///}});
            /*add(dnaTypeRadioButton);
            add(rnaTypeRadioButton);
            add(proteinTypeRadioButton);
            
            
            
            add(new JButton("Long-Named Button 4"));
            add(new JButton("5")); */
        }
        
    }
}
