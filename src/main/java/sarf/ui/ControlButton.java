package sarf.ui;

import java.awt.*;
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
public class ControlButton extends JPanel{
    public static final Font FONT = new Font("Traditional Arabic", Font.PLAIN, 24);
    //public static final Font FONT = new Font("Tahoma", Font.PLAIN, 12);

    private final String formulaText;
    private final JButton button = new JButton();

    public ControlButton(String text) {
        super(new GridLayout(2,1));
        this.formulaText = text;
        setBorder(BorderFactory.createEtchedBorder());

        JLabel rootLblButton = new JLabel();
        rootLblButton.setText(text);
        rootLblButton.setFont(FONT);

        JTextField formulaTxtFld = new JTextField(text);
        formulaTxtFld.setHorizontalAlignment(JTextField.CENTER);
        formulaTxtFld.setFont(FONT);
        formulaTxtFld.setEditable(false);
        formulaTxtFld.setBorder(null);

        add(formulaTxtFld);
        button.setText("    ");
        button.setFont(FONT);
        add(button);

        button.setFocusPainted(false);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void setEnabled(boolean b) {
        super.setEnabled(b);
        button.setEnabled(b);
        button.setText("    ");
    }

    public void setRootText(String text) {
        button.setText(text);
    }

    public JButton getButton() {
        return button;
    }

    public String getFormulaText() {
        return formulaText;
    }

    public String getVerbText() {
        return button.getText();
    }
}
