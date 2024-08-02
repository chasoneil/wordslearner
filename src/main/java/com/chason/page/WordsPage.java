package com.chason;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WordsPage {

    private JFrame mainFrame;

    private JLabel headerLabel;
    private JLabel centerLabel;
    private JLabel bottomLaber;

    private JPanel controlPanel;

    public WordsPage(){
        prepareGUI();
    }

    private void prepareGUI(){

        mainFrame = new JFrame("Words Learner");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 2));

        headerLabel = new JLabel("",JLabel.CENTER );
        centerLabel = new JLabel("",JLabel.CENTER);
        centerLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(centerLabel);

        mainFrame.setVisible(true);
    }

    private void showBorderLayoutDemo(){

        JPanel headerLeftPanel = new JPanel(new FlowLayout());
        JPanel headerRightPanel = new JPanel(new FlowLayout());
        headerLeftPanel.setBackground(Color.MAGENTA);
        headerRightPanel.setBackground(Color.BLUE);
        headerLabel.add(headerLeftPanel);
        headerLabel.add(headerRightPanel);

        headerLabel.setText("Layout in action: BorderLayout");

//        JPanel panel = new JPanel();
//        panel.setBackground(Color.darkGray);
//        panel.setSize(300,300);
//        BorderLayout layout = new BorderLayout();
//        layout.setHgap(10);
//        layout.setVgap(10);
//
//        panel.setLayout(layout);
//        panel.add(new JButton("Center"),BorderLayout.CENTER);
//        panel.add(new JButton("Line Start"),BorderLayout.LINE_START);
//        panel.add(new JButton("Line End"),BorderLayout.LINE_END);
//        panel.add(new JButton("East"),BorderLayout.EAST);
//        panel.add(new JButton("West"),BorderLayout.WEST);
//        panel.add(new JButton("North"),BorderLayout.NORTH);
//        panel.add(new JButton("South"),BorderLayout.SOUTH);
//
//        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }



}
