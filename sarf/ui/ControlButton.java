package sarf.ui;

import java.awt.*;

import javax.swing.*;
import java.util.LinkedList;

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

    protected String formulaText;
    protected JButton button = new JButton();

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

    private String appyPattern(String text, char c1, char c2, char c3) {
        char [] textArray = text.toCharArray();
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3 = new LinkedList();

        for (int i=0; i<textArray.length; i++) {
            if (textArray[i] == 'Ý')
                l1.add(i+"");
            else if (textArray[i] == 'Ú')
                l2.add(i+"");
            else if (textArray[i] == 'á')
                l3.add(i+"");
        }

        for (int i=0; i<l1.size(); i++) {
            int index = Integer.parseInt(l1.get(i).toString());
            textArray[index] = c1;
        }
        for (int i=0; i<l2.size(); i++) {
            int index = Integer.parseInt(l2.get(i).toString());
            textArray[index] = c2;
        }
        for (int i=0; i<l3.size(); i++) {
            int index = Integer.parseInt(l3.get(i).toString());
            textArray[index] = c3;
        }

        return new String(textArray);
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
