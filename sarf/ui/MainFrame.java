package sarf.ui;

import java.awt.*;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.util.*;
import sarf.util.ImagePane;
import java.util.prefs.Preferences;
import java.awt.im.InputContext;

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
public class MainFrame extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    IntroPane introPane;
    Preferences pref;

    public MainFrame() {

        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();

            boolean openIntro = true;

            pref = Preferences.userNodeForPackage(MainFrame.class);
            String result = pref.get("HideIntro", null);
            if (result == null) {
                pref.put("HideIntro", "false");
            }
            else if (result.equals("true"))
                openIntro = false;

            if (openIntro) {
                introPane = new IntroPane(this);
                getContentPane().add(introPane, BorderLayout.CENTER);
            }
            else {
                openDesktop();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public synchronized void introPaneClicked() {
        if (introPane == null)
            return;

        pref.put("HideIntro", introPane.getHideIntroChkBox().isSelected()+"");
        introPane = null;
        openDesktop();
    }

    private void openDesktop() {
        contentPane.removeAll();
        contentPane.add(ControlPaneContainer.getInstance());


        setJMenuBar(ControlPaneContainer.getInstance().getMenuBar());
        validate();
        repaint();

        ControlPaneContainer.getInstance().getRootFld().requestFocus();
        ControlPaneContainer.getInstance().setPref(pref);

        InputContext inputContext = ControlPaneContainer.getInstance().getRootFld().getInputContext();
        //starting with sy first
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        if (inputContext.selectInputMethod(syLocale))
            return;

        //else searching for suitable arabic country one, if it is exists

        Locale [] locales = Locale.getAvailableLocales();
        for (int i=0; i<locales.length; i++) {
            Locale locale = locales[i];
            System.out.println(i+"");
            //if one of the arabic locales suceeded, then ok
            if (locale.getLanguage().equalsIgnoreCase("ar"))
                if (inputContext.selectInputMethod(locale))
                    break;
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(600, 500));
        setTitle("Arabic Morphology System  -  äÙÇã ÇáÇÔÊÞÇÞ æÇáÊÕÑíÝ Ýí ÇááÛÉ ÇáÚÑÈíÉ");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.addWindowListener(new MainFrame_this_windowAdapter(this));
        contentPane.setFont(new java.awt.Font("Arabic Transparent", Font.PLAIN, 12));
    }

    public void this_windowActivated(WindowEvent windowEvent) {
    }
}


class MainFrame_this_windowAdapter extends WindowAdapter {
    private MainFrame adaptee;
    MainFrame_this_windowAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void windowActivated(WindowEvent windowEvent) {
        adaptee.this_windowActivated(windowEvent);
    }
}
