package com.chason.container.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDialog extends JDialog {

    private JComboBox lessonBox;

    public SelectDialog(JFrame jFrame) {

        super(jFrame, "Select Lesson", true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(1, 2));
        setBounds(650, 330, 434, 270);

        FlowLayout innerLayout = new FlowLayout();
        JPanel panel = new JPanel(innerLayout);
        innerLayout.setVgap(105);

        JLabel titleLabel = new JLabel("Please select lesson:", JLabel.CENTER);

        final DefaultComboBoxModel lessons = new DefaultComboBoxModel();
        for (int i=1; i<=100; i++) {
            lessons.addElement(i);
        }

        lessonBox = new JComboBox(lessons);
        lessonBox.setSelectedIndex(0);

        // JTextField lessonField = new JTextField(12);

        lessonBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lessonBox.getSelectedIndex() != -1) {
                    System.out.println("selected:" + lessonBox.getItemAt(lessonBox.getSelectedIndex()));
                }
            }
        });

        panel.add(lessonBox);
        container.add(titleLabel);
        container.add(panel);

    }

}
