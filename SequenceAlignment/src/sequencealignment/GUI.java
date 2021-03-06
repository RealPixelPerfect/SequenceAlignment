package sequencealignment;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

public class GUI extends JFrame {

    JLabel header = new JLabel("Sequence Alignment");
    Grid grid = new Grid();

    JLabel seq1Label, seq2Label;
    JTextArea seq1Area, seq2Area;
    JButton convertDNAButton, convertRNAButton, convertProteinButton, sequenceAlignButton;
    JRadioButton dnaTypeRadioButton, rnaTypeRadioButton, proteinTypeRadioButton;

    //Is data DNA = D, RNA = R or Protein = P
    char typeOfData = 'D';

    public static void setUIFont(javax.swing.plaf.FontUIResource f){   
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while(keys.hasMoreElements()){
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }
    
    GUI() {
        MainPanel mainPanel = new MainPanel();
        add(grid);
        setTitle("Sequence Alignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(930, 480));
        setVisible(true);
        
        try{
            setUIFont(new javax.swing.plaf.FontUIResource("Courier",Font.PLAIN,12));
        }
        catch(Exception e){}
    }

    class MainPanel extends JPanel {

        MainPanel() {
            setBackground(Color.LIGHT_GRAY);
        }

    }

    class Grid extends JPanel {

        Grid() {
            GridBagLayout grid = new GridBagLayout();
            setLayout(grid);

            //Grid Constraints
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.fill = GridBagConstraints.NONE;
            gbc.ipadx = 50;
            gbc.ipady = 50;

            //Sequence 1 label
            seq1Label = new JLabel("Sequence 1");
            seq1Label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(seq1Label, gbc);

            //Sequence 1 textpane
            seq1Area = new JTextArea(5, 50);
            seq1Area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            seq1Area.setLineWrap(true);
            JScrollPane seq1Pane = new JScrollPane(seq1Area);
            seq1Pane.setLayout(new ScrollPaneLayout());
            seq1Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 6;
            gbc.gridheight = 2;
            add(seq1Pane, gbc);
            
            //Sequence 2 lable
            seq2Label = new JLabel("Sequence 2");
            seq2Label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(seq2Label, gbc);

            //Sequence 2 textpane            
            seq2Area = new JTextArea(5, 50);
            seq2Area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            seq2Area.setLineWrap(true);
            JScrollPane seq2Pane = new JScrollPane(seq2Area);
            seq2Pane.setLayout(new ScrollPaneLayout());
            seq2Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 6;
            gbc.gridheight = 2;
            add(seq2Pane, gbc);

            //Convert DNA Button
            convertDNAButton = new JButton("  Convert to DNA  ");
            convertDNAButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
            gbc.gridx = 8;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            convertDNAButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    convertToDNA();
                }
            });
            
            add(convertDNAButton, gbc);

            //Convert RNA Button
            convertRNAButton = new JButton("  Convert to RNA  ");
            convertRNAButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
            gbc.gridx = 8;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            convertRNAButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    convertToRNA();
                }
            });
            
            add(convertRNAButton, gbc);

            //Convert Protein Button
            convertProteinButton = new JButton("Convert to Protein");
            convertProteinButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
            gbc.gridx = 8;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            convertProteinButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    convertToProtein();
                }
            });
            
            add(convertProteinButton, gbc);

            //Sequence Align Button
            sequenceAlignButton = new JButton("  Sequence Align  ");
            sequenceAlignButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 17));
            gbc.gridx = 8;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            sequenceAlignButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sequenceAlign();
                }
            });

            add(sequenceAlignButton, gbc);

            //Radio Buttons
            ButtonGroup typeGroup = new ButtonGroup();

            dnaTypeRadioButton = new JRadioButton("DNA", true);
            dnaTypeRadioButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
            gbc.gridx = 2;
            gbc.gridy = 0;
            typeGroup.add(dnaTypeRadioButton);
            dnaTypeRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    typeOfData = 'D';
                }
            });
            add(dnaTypeRadioButton, gbc);

            rnaTypeRadioButton = new JRadioButton("RNA");
            rnaTypeRadioButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
            gbc.gridx = 3;
            gbc.gridy = 0;
            typeGroup.add(rnaTypeRadioButton);
            rnaTypeRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    typeOfData = 'R';
                }
            });
            add(rnaTypeRadioButton, gbc);

            proteinTypeRadioButton = new JRadioButton("Protein");
            proteinTypeRadioButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
            gbc.gridx = 4;
            gbc.gridy = 0;
            typeGroup.add(proteinTypeRadioButton);
            proteinTypeRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    typeOfData = 'P';
                }
            });
            add(proteinTypeRadioButton, gbc);

        }
    }
       
    private void sequenceAlign(){
        String str1 = seq1Area.getText().toUpperCase();
        String str2 = seq2Area.getText().toUpperCase();
        Parser pars1 = new Parser(str1);
        Parser pars2 = new Parser(str2);

        if (typeOfData == 'D') {
            DNASequence[] in = {pars1.parseDNA(), pars2.parseDNA()};
            Aligner aligner = new Aligner();
            in = aligner.needlemanWunsch(in);
            String[] matchedString = matchCases(in[0].toReadable(), in[1].toReadable());
            seq1Area.setText(matchedString[0]);
            seq2Area.setText(matchedString[1]);
        } else if (typeOfData == 'R') {
            RNASequence[] in = {pars1.parseRNA(), pars2.parseRNA()};
            Aligner aligner = new Aligner();
            in = aligner.needlemanWunsch(in);
            String[] matchedString = matchCases(in[0].toReadable(), in[1].toReadable());
            seq1Area.setText(matchedString[0]);
            seq2Area.setText(matchedString[1]);
        } else if (typeOfData == 'P') {
            ProteinSequence[] in = {pars1.parseProtein(), pars2.parseProtein()};
            Aligner aligner = new Aligner();
            in = aligner.needlemanWunsch(in);
            String[] matchedString = matchCases(in[0].toReadable(), in[1].toReadable());
            seq1Area.setText(matchedString[0]);
            seq2Area.setText(matchedString[1]);
        }
    }
    
    private void convertToDNA(){
        String str1 = seq1Area.getText().toUpperCase();
        String str2 = seq2Area.getText().toUpperCase();
        Parser pars1 = new Parser(str1);
        Parser pars2 = new Parser(str2);
        
        if(typeOfData == 'D'){
            DNASequence[] in = {pars1.parseDNA(), pars2.parseDNA()};
            seq1Area.setText(in[0].flip());
            seq2Area.setText(in[1].flip());
        }else if(typeOfData == 'R'){
            RNASequence[] in = {pars1.parseRNA(), pars2.parseRNA()};
            seq1Area.setText(in[0].toDNA());
            seq2Area.setText(in[1].toDNA());
        }else if(typeOfData == 'P'){
            seq1Area.setText(str1+" This operation does not work");
        }
    }
    
    private void convertToRNA(){
        String str1 = seq1Area.getText().toUpperCase();
        String str2 = seq2Area.getText().toUpperCase();
        Parser pars1 = new Parser(str1);
        Parser pars2 = new Parser(str2);
        
        if(typeOfData == 'D'){
            
            DNASequence[] in = {pars1.parseDNA(), pars2.parseDNA()};
            seq1Area.setText(in[0].toRNA());
            seq2Area.setText(in[1].toRNA());
        }else if(typeOfData == 'R'){
            RNASequence[] in = {pars1.parseRNA(), pars2.parseRNA()};
            seq1Area.setText(in[0].flip());
            seq2Area.setText(in[1].flip());
        }else if(typeOfData == 'P'){
            seq1Area.setText(str1+" This operation does not work");
        }
    }
    
    private void convertToProtein(){
        String str1 = seq1Area.getText().toUpperCase();
        String str2 = seq2Area.getText().toUpperCase();
        
        if(typeOfData == 'D'){
            Parser pars1 = new Parser(str1);
            Parser pars2 = new Parser(str2);
            DNASequence[] in = {pars1.parseDNA(), pars2.parseDNA()};
            seq1Area.setText(in[0].toProtein());
            seq2Area.setText(in[1].toProtein());
        }else if(typeOfData == 'R'){
            Parser pars1 = new Parser(str1);
            Parser pars2 = new Parser(str2);
            RNASequence[] in = {pars1.parseRNA(), pars2.parseRNA()};
            seq1Area.setText(in[0].toProtein());
            seq2Area.setText(in[1].toProtein());
        }else if(typeOfData == 'P'){
            seq1Area.setText(str1+" This operation does not work");
        }
    }
    
    private String[] matchCases(String inString1, String inString2){
        String[] outString = {"", ""};
        
        int shortestLength = Math.min(inString1.length(), inString2.length());
                
        for (int i = 0; i < shortestLength; i++) {
            char[] charI = {inString1.charAt(i), inString2.charAt(i)};
            if(inString1.charAt(i) == inString2.charAt(i)){
                outString[0] += Character.toUpperCase(charI[0]);
                outString[1] += Character.toUpperCase(charI[1]);
            } else {
                outString[0] += Character.toLowerCase(charI[0]);
                outString[1] += Character.toLowerCase(charI[1]);
            }
        }
        
        return outString;
    }
}
