package sarf.ui;

import com.google.inject.Guice;
import com.google.inject.Inject;
import sarf.SarfModule;

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
    private final MainFrame mainFrame;

    /**
     * Construct and show the application.
     */
    @Inject
    private MainApp(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private void run(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (screenSize.height < 768 && screenSize.width < 1024) {
            Toolkit.getDefaultToolkit().beep();
            String msg = "يجب أن تكون دقة الشاشة  1024 * 768";
            JOptionPane.showMessageDialog(null, msg, "لا يمكن تشغيل البرنامج   ", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        // Validate frames that have preset sizes
        // Pack frames that have useful preferred size info, e.g. from their layout
        mainFrame.validate();

        // Center the window

        Dimension frameSize = mainFrame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        mainFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        mainFrame.setVisible(true);
    }

    /**
     * Application entry point.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                //MetalLookAndFeel.setCurrentTheme(new javax.swing.plaf.metal.OceanTheme());
                UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            var injector = Guice.createInjector(new SarfModule());
            var mainApp = injector.getInstance(MainApp.class);
            mainApp.run();
        });
    }
}
