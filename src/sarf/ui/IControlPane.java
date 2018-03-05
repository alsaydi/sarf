package sarf.ui;

import javax.swing.*;

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
public interface IControlPane {
    public JComponent getComponent();
    public void controlPaneOpened();
    public void controlPaneClosed();
}

