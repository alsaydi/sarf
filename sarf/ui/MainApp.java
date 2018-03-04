package sarf.ui;

import java.awt.Toolkit;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.JOptionPane;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class MainApp {
    boolean packFrame = false;

    /**
     * Construct and show the application.
     */
    public MainApp() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (screenSize.height != 768 && screenSize.width != 1024) {
            Toolkit.getDefaultToolkit().beep();
            String msg = "íÌÈ Ãä Êßæä ÏÞÉ ÇáÔÇÔÉ  1024 * 768";
            JOptionPane.showMessageDialog(null, msg, "áÇ íãßä ÊÔÛíá ÇáÈÑäÇãÌ   ", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        MainFrame frame = new MainFrame();
        // Validate frames that have preset sizes
        // Pack frames that have useful preferred size info, e.g. from their layout
        if (packFrame) {
            frame.pack();
        }
        else {
            frame.validate();
        }

        // Center the window

        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }

    /**
     * Application entry point.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    //MetalLookAndFeel.setCurrentTheme(new javax.swing.plaf.metal.OceanTheme());
                    UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }

                new MainApp();
            }
        });
    }
}
