package com.chason.container.dialog;

import javax.swing.*;
import java.awt.*;

public class InputDialog extends JDialog {

    public InputDialog (JFrame jFrame) {

        super(jFrame, "Input Words", true);
        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1));
        setBounds(650, 330, 434, 270);

        container.add(new Label("This is a Label"));
        container.add(new Label("This is a Label2"));
    }

}
