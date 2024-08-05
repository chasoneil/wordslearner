package com.chason.container.menu;

import com.chason.container.dialog.InputDialog;
import com.chason.container.dialog.SelectDialog;

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
        JMenu selectMenu = new JMenu("select");  // load words
        JMenu helpMenu = new JMenu("help");

        JMenuItem inputMenuItem = new JMenuItem("input");
        inputMenuItem.setMnemonic(KeyEvent.VK_N);
        inputMenuItem.setActionCommand("input");

        JMenuItem importMenuItem = new JMenuItem("import");
        importMenuItem.setActionCommand("import");

        JMenuItem selectMenuItem = new JMenuItem("select");
        selectMenuItem.setActionCommand("select");

        loadMenu.add(inputMenuItem);
        loadMenu.add(importMenuItem);

        selectMenu.add(selectMenuItem);

        jMenuBar.add(loadMenu);
        jMenuBar.add(selectMenu);
        jMenuBar.add(helpMenu);

        MenuItemListener menuItemListener = new MenuItemListener();

        inputMenuItem.addActionListener(menuItemListener);
        selectMenuItem.addActionListener(menuItemListener);
        importMenuItem.addActionListener(menuItemListener);
    }

    class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case "input":
                    new InputDialog(jFrame).setVisible(true);
                    break;
                case "import":
                    break;
                case "select":
                    new SelectDialog(jFrame).setVisible(true);
                    break;
                default:
                    System.err.println("Unknown menu:" + e.getActionCommand());
                    break;
            }

        }
    }

}
