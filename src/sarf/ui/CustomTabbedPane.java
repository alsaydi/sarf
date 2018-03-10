package sarf.ui;

import javax.swing.*;
import java.awt.Font;
import java.awt.*;

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
public class CustomTabbedPane extends JTabbedPane {
    public static final Font FONT = new Font("Traditional Arabic", Font.PLAIN, 18);

    public CustomTabbedPane() {
        setFont(FONT);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
}
