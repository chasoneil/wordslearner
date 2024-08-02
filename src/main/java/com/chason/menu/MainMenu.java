package com.chason.menu;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainMenu {

    public final JMenuBar jMenuBar = new JMenuBar();

    public MainMenu () {

        JMenu loadMenu = new JMenu("load");  // load words
        JMenu helpMenu = new JMenu("help");

        JMenuItem inputMenuItem = new JMenuItem("input");
        inputMenuItem.setMnemonic(KeyEvent.VK_N);
        inputMenuItem.setActionCommand("input");

        JMenuItem openMenuItem = new JMenuItem("import");
        openMenuItem.setActionCommand("import");

        loadMenu.add(inputMenuItem);
        loadMenu.add(openMenuItem);

        jMenuBar.add(loadMenu);
        jMenuBar.add(helpMenu);
    }

}
