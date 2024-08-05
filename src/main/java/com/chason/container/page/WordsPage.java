package com.chason.container.page;

import com.chason.container.menu.MainMenu;
import com.chason.entity.EnglishWord;
import com.chason.service.WordsService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class WordsPage {

    private JFrame mainFrame;
    private JPanel headerPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

    private static final int DEFAULT_LESSON = 1;

    private List<EnglishWord> words;

    private int point = -1;

    public WordsPage(){

        initWords();
        if (words != null && words.size() > 0) {
            point = 0;
        }

        prepareGUI();

        MainMenu menu = new MainMenu(mainFrame);
        mainFrame.setJMenuBar(menu.jMenuBar);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    private void initWords() {
        WordsService service = new WordsService();
        words = service.listByLesson(DEFAULT_LESSON);
    }

    private void prepareGUI(){

        mainFrame = new JFrame("Words Learner");
        mainFrame.setBounds(450, 200, 880, 520);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerPanel = new JPanel();

        GridLayout headerPanelLayout = new GridLayout(0,2);
        headerPanel.setLayout(headerPanelLayout);
        mainFrame.add(headerPanel);

        String wordContent = "Word : ";
        String lessonContent = "Lesson : ";
        if (point != -1) {
            wordContent += words.get(point).getWord();
            lessonContent += words.get(point).getLesson();
        }
        JLabel hLLabel = new JLabel(wordContent, JLabel.CENTER);
        JLabel hRLabel = new JLabel(lessonContent, JLabel.CENTER);

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
        bLLabel.setText("Please input...");
        bLLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel bRLabel = new JLabel("Answer: ", JLabel.CENTER);

        bottomPanel.add(bLLabel);
        bottomPanel.add(bRLabel);
        mainFrame.add(bottomPanel);

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        mainFrame.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent windowEvent){
//                System.exit(0);
//            }
//        });


    }

}
