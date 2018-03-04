package sarf.ui;

import javax.swing.*;
import java.awt.Font;

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
public class RenderedButton extends JButton {
    public static final Font FONT = new Font("Tahoma", Font.PLAIN, 12);

    public RenderedButton(String text) {
        super(text);
        setFont(FONT);
        setFocusPainted(false);
    }

    public RenderedButton() {
        setFont(FONT);
    }
}
