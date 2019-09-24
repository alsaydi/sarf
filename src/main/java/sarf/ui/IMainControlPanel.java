package sarf.ui;

import sarf.KindOfVerb;

import javax.swing.*;

public interface IMainControlPanel {
    void openResult(JComponent resultComponent);
    String getVerbText();
    KindOfVerb getKov();
    IControlPane openControlPane(Class paneClass);
    void setTransitiveType(String text);
    void setVerbText(String text);
}
