package sarf.ui.controlpane;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import sarf.Action;
import sarf.noun.*;
import sarf.ui.*;

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
public class NounStateSelectionUI extends JPanel implements INounStateSelectionUI{

    ToggleRenderedButton definiteBtn = new ToggleRenderedButton("›Ì Õ«·… «·„⁄—›…  ");
    ToggleRenderedButton annexedBtn = new ToggleRenderedButton("›Ì Õ«·… «·≈÷«›…  ");
    ToggleRenderedButton indefiniteBtn = new ToggleRenderedButton("›Ì Õ«·… «·‰ﬂ—…  ");

    public NounStateSelectionUI() {
        super(new BorderLayout());

        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.BLACK, Color.BLUE));

        JPanel buttonsPanel = new APanel(new GridLayout(1, 3));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(definiteBtn);
        buttonGroup.add(annexedBtn);
        buttonGroup.add(indefiniteBtn);

        buttonsPanel.add(indefiniteBtn);
        buttonsPanel.add(annexedBtn);
        buttonsPanel.add(definiteBtn);

        indefiniteBtn.setSelected(true);

        add(buttonsPanel);

        definiteBtn.setFont(RenderedButton.FONT);
        annexedBtn.setFont(RenderedButton.FONT);
        indefiniteBtn.setFont(RenderedButton.FONT);
    }

    public JComponent getComponent() {
        return this;
    }

    public ToggleRenderedButton getDefiniteBtn() {
        return definiteBtn;
    }

    public ToggleRenderedButton getIndefiniteBtn() {
        return indefiniteBtn;
    }

    public ToggleRenderedButton getAnnexedBtn() {
        return annexedBtn;
    }

    public void init(final Action action,final INounSuffixContainer nounSuffixContainer,final NounStateSelectionUIListener listener) {
        definiteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nounSuffixContainer.selectDefiniteMode();
                //generate the new conjugation with the new suffixes
                java.util.List newResult = action.execute();
                //display this new result via this listener
                listener.newStateConjugationResultGenerated(newResult);
            }
        });

        indefiniteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nounSuffixContainer.selectInDefiniteMode();
                //generate the new conjugation with the new suffixes
                java.util.List newResult = action.execute();
                //display this new result via this listener
                listener.newStateConjugationResultGenerated(newResult);

            }
        });

        annexedBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nounSuffixContainer.selectAnnexedMode();
                //generate the new conjugation with the new suffixes
                java.util.List newResult = action.execute();
                //display this new result via this listener
                listener.newStateConjugationResultGenerated(newResult);
            }
        });
    }

    //execute a selected button to refelct the result on the UI
    public void selectOne() {
        indefiniteBtn.doClick();
    }

    public JComponent getComponentUI() {
        return this;
    }
}
