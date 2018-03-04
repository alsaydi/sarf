package sarf.ui;

import javax.swing.*;
import java.awt.*;
import sarf.util.ImagePane;
import java.awt.event.*;
import sarf.util.SizedImagePane;

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
public class AboutDialog extends JDialog {
    public AboutDialog() {
        try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        SizedImagePane imagePane = new SizedImagePane(ClassLoader.getSystemResource("sarf/ui/about.jpg"));
        imagePane.setLayout(new BorderLayout());
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(imagePane);
        setResizable(false);

        setSize(imagePane.getImage().getWidth(null)+10, imagePane.getImage().getHeight(null)+10);
        setModal(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        setTitle("ÕÊ· «·»—‰«„Ã ");

        JPanel bottomPane = new JPanel();
        bottomPane.setOpaque(false);
        RenderedButton closeBtn = new RenderedButton("≈€·«ﬁ");
        bottomPane.add(closeBtn);

        bottomPane.setBorder(BorderFactory.createEtchedBorder());
        imagePane.setBorder(BorderFactory.createEtchedBorder());

        imagePane.add(bottomPane, BorderLayout.SOUTH);

        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(new BorderLayout());
    }

}
