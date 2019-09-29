package sarf.ui;

import sarf.SarfDictionary;

import java.awt.*;

import javax.inject.Inject;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.util.*;
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
class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private final BorderLayout borderLayout1 = new BorderLayout();
    private IntroPane introPane;
    private Preferences pref;
    private final ControlPaneContainer controlPaneContainer;

    @Inject
    private MainFrame(SarfDictionary sarfDictionary, ControlPaneContainer controlPaneContainer) {
        this.controlPaneContainer = controlPaneContainer;
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

    synchronized void introPaneClicked() {
        if (introPane == null)
            return;

        pref.put("HideIntro", introPane.getHideIntroChkBox().isSelected()+"");
        introPane = null;
        openDesktop();
    }

    private void openDesktop() {
        contentPane.removeAll();
        contentPane.add(controlPaneContainer);


        setJMenuBar(controlPaneContainer.getMenuBar());
        validate();
        repaint();

        controlPaneContainer.getRootFld().requestFocus();
        controlPaneContainer.setPref(pref);

        InputContext inputContext = controlPaneContainer.getRootFld().getInputContext();
        //starting with sy first
        Locale syLocale = new java.util.Locale("ar", "SY", "");
        if (inputContext.selectInputMethod(syLocale))
            return;

        //else searching for suitable arabic country one, if it is exists

        Locale [] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            //System.out.println(i+"");
            //if one of the arabic locales suceeded, then ok
            if (locale.getLanguage().equalsIgnoreCase("ar"))
                if (inputContext.selectInputMethod(locale))
                    break;
        }
    }

    /**
     * Component initialization.
     */
    private void jbInit() {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(600, 500));
        setTitle("Arabic Morphology System  -  نظام الاشتقاق والتصريف في اللغة العربية");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.addWindowListener(new MainFrame_this_windowAdapter(this));
        contentPane.setFont(new java.awt.Font("Arabic Transparent", Font.PLAIN, 12));
    }

    void this_windowActivated(WindowEvent windowEvent) {
    }
}


class MainFrame_this_windowAdapter extends WindowAdapter {
    private final MainFrame adaptee;
    MainFrame_this_windowAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void windowActivated(WindowEvent windowEvent) {
        adaptee.this_windowActivated(windowEvent);
    }
}
