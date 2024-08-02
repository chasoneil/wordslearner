package com.chason.page;

import com.chason.menu.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WordsPage {

    private JFrame mainFrame;
    private JPanel headerPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    public WordsPage(){
        prepareGUI();

        MainMenu menu = new MainMenu();
        mainFrame.setJMenuBar(menu.jMenuBar);
        mainFrame.setVisible(true);
    }

    private void prepareGUI(){

        mainFrame = new JFrame("Words Learner");
        mainFrame.setBounds(450, 200, 880, 520);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerPanel = new JPanel();

        GridLayout headerPanelLayout = new GridLayout(0,2);
        headerPanel.setLayout(headerPanelLayout);
        mainFrame.add(headerPanel);

        JLabel hLLabel = new JLabel("Word:     school", JLabel.CENTER);
        JLabel hRLabel = new JLabel("Lesson1 -> Unit1", JLabel.CENTER);
        headerPanel.add(hLLabel);
        headerPanel.add(hRLabel);

        centerPanel = new JPanel();
        centerPanel.setLayout(headerPanelLayout);

        FlowLayout innerLayout = new FlowLayout();
        innerLayout.setVgap(70);
        JPanel textPanel = new JPanel(innerLayout);
        JTextField cLField = new JTextField(20);
        JButton cRBtn = new JButton("提 交");
        textPanel.add(cLField);
        centerPanel.add(textPanel);

        JPanel btnPanel = new JPanel(innerLayout);
        btnPanel.add(cRBtn);
        centerPanel.add(btnPanel);
        mainFrame.add(centerPanel);

        cRBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("pressed" + cLField.getText());
            }
        });

        bottomPanel = new JPanel();
        bottomPanel.setLayout(headerPanelLayout);
        JLabel bLLabel = new JLabel();
        bLLabel.setText("Correct!");
        bLLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel bRLabel = new JLabel("Answer: 学校 (n)", JLabel.CENTER);

        bottomPanel.add(bLLabel);
        bottomPanel.add(bRLabel);
        mainFrame.add(bottomPanel);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });


    }

}
