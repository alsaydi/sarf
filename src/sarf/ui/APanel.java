package sarf.ui;

import javax.swing.*;
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
public class APanel extends JPanel {

    public APanel() {
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    public APanel(LayoutManager layoutManager) {
        super(layoutManager);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
}
