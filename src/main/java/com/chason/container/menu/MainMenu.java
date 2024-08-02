package com.chason.container.menu;

import com.chason.container.dialog.InputDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainMenu {

    public final JMenuBar jMenuBar = new JMenuBar();

    private JFrame jFrame;

    public MainMenu (JFrame jFrame) {

        this.jFrame = jFrame;

        JMenu loadMenu = new JMenu("load");  // load words
        JMenu helpMenu = new JMenu("help");

        JMenuItem inputMenuItem = new JMenuItem("input");
        inputMenuItem.setMnemonic(KeyEvent.VK_N);
        inputMenuItem.setActionCommand("input");

        JMenuItem importMenuItem = new JMenuItem("import");
        importMenuItem.setActionCommand("import");

        loadMenu.add(inputMenuItem);
        loadMenu.add(importMenuItem);

        jMenuBar.add(loadMenu);
        jMenuBar.add(helpMenu);

        MenuItemListener menuItemListener = new MenuItemListener();

        inputMenuItem.addActionListener(menuItemListener);
        importMenuItem.addActionListener(menuItemListener);
    }

    class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case "input":
                    InputDialog dialog = new InputDialog(jFrame);
                    dialog.setVisible(true);
                    break;
                case "import":
                    break;
                case "about":
                    break;
                default:
                    System.err.println("Unknown menu:" + e.getActionCommand());
                    break;
            }

        }
    }

}
