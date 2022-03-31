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

    GUI() {
        MainPanel mainPanel = new MainPanel();
        add(grid);
        setTitle("Sequence Alignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(924, 417));
        setVisible(true);
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
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(seq1Label, gbc);

            //Sequence 1 textpane
            seq1Area = new JTextArea(5, 50);
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
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(seq2Label, gbc);

            //Sequence 2 textpane            
            seq2Area = new JTextArea(5, 50);
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
            convertDNAButton = new JButton("   Convert DNA   ");
            gbc.gridx = 8;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(convertDNAButton, gbc);

            //Convert RNA Button
            convertRNAButton = new JButton("   Convert RNA   ");
            gbc.gridx = 8;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(convertRNAButton, gbc);

            //Convert Protein Button
            convertProteinButton = new JButton("Convert Protein");
            gbc.gridx = 8;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            add(convertProteinButton, gbc);

            //Sequence Align Button
            sequenceAlignButton = new JButton("Sequence Align");
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

    private void sequenceAlign() {
        String str1 = getText(1).toUpperCase();
        String str2 = getText(2).toUpperCase();
        Parser pars1 = new Parser(str1);
        Parser pars2 = new Parser(str2);

        if (typeOfData == 'D') {
            DNASequence[] in = {pars1.parseDNA(), pars2.parseDNA()};
            Aligner aligner = new Aligner();
            in = aligner.needlemanWunsch(in);
            seq1Area.setText(in[0].toReadable());
            seq2Area.setText(in[1].toReadable());
        } else if (typeOfData == 'R') {
            RNASequence[] in = {pars1.parseRNA(), pars2.parseRNA()};
            Aligner aligner = new Aligner();
            in = aligner.needlemanWunsch(in);
            seq1Area.setText(in[0].toReadable());
            seq2Area.setText(in[1].toReadable());
        } else if (typeOfData == 'P') {
            ProteinSequence[] in = {pars1.parseProtein(), pars2.parseProtein()};
            Aligner aligner = new Aligner();
            in = aligner.needlemanWunsch(in);
            seq1Area.setText(in[0].toReadable());
            seq2Area.setText(in[1].toReadable());
        }
    }

    public String getText(int sequence) {
        String s = "";
        if (sequence == 1) {
            s = seq1Area.getText();
        } else if (sequence == 2) {
            s = seq2Area.getText();
        }
        return s;
    }
}
