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
class IntroPane extends JPanel {
    private final MainFrame mainFrame;
    private final JCheckBox hideIntroChkBox = new JCheckBox("عدم إظهار هذه الشاشة في المرات القادمة");

    IntroPane(MainFrame mainFrame) {
        super(new BorderLayout());
        this.mainFrame = mainFrame;

        SizedImagePane imagePane = new SizedImagePane(ClassLoader.getSystemResource("Intro.jpg"));

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

        var hidingThread = new Thread(() -> {
            try {
                Thread.sleep(8000);
            }
            catch (InterruptedException ignored) {
            }
            IntroPane.this.mainFrame.introPaneClicked();
        });
        hidingThread.start();
    }

    JCheckBox getHideIntroChkBox() {
        return hideIntroChkBox;
    }
}
