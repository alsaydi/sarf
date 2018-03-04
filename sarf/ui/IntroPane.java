package sarf.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import sarf.util.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class IntroPane extends JPanel {
    private MainFrame mainFrame;
    private JCheckBox hideIntroChkBox = new JCheckBox("⁄œ„ ≈ŸÂ«— Â–Â «·‘«‘… ›Ì «·„—«  «·ﬁ«œ„…");

    public IntroPane(MainFrame mainFrame) {
        super(new BorderLayout());
        this.mainFrame = mainFrame;


        SizedImagePane imagePane = new SizedImagePane(ClassLoader.getSystemResource("sarf/ui/Intro.jpg"));

        add(imagePane);
        imagePane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                IntroPane.this.mainFrame.introPaneClicked();
            }
        });

        hideIntroChkBox.setSelected(false);

        JPanel bottomPane = new JPanel();
        bottomPane.add(hideIntroChkBox);

        add(bottomPane, BorderLayout.SOUTH);

        Thread hidingThread = new Thread(){
            public void run() {
                try {
                    Thread.sleep(8000);
                }
                catch (InterruptedException ex) {
                }
                IntroPane.this.mainFrame.introPaneClicked();
            }
        };
        hidingThread.start();
    }

    public JCheckBox getHideIntroChkBox() {
        return hideIntroChkBox;
    }
}
