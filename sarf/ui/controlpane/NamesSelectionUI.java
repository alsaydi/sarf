package sarf.ui.controlpane;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

import sarf.noun.quadriliteral.augmented.*;
import sarf.noun.quadriliteral.unaugmented.*;
import sarf.noun.trilateral.augmented.*;
import sarf.ui.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.trilateral.augmented.*;
import java.util.Map;
import java.util.HashMap;
import sarf.Action;
import sarf.noun.GenericNounSuffixContainer;
import sarf.verb.quadriliteral.*;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;

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
public class NamesSelectionUI extends JPanel implements IControlPane, AugmentedTrilateralModifierListener {
    private SelectionInfo selectionInfo;


    ToggleRenderedButton activeParticipleBtn = new ToggleRenderedButton("«”„ «·›«⁄·");
    ToggleRenderedButton passiveParticipleBtn = new ToggleRenderedButton("«”„ «·„›⁄Ê·");
    ToggleRenderedButton timeAndPlaceBtn = new ToggleRenderedButton("«”„ «·“„«‰ Ê«·„ﬂ«‰  ");


    public NamesSelectionUI() {
        super(new BorderLayout());
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel buttonsPanel = new APanel(new GridLayout(1, 7));

        buttonsPanel.add(activeParticipleBtn);
        buttonsPanel.add(passiveParticipleBtn);
        buttonsPanel.add(timeAndPlaceBtn);

        activeParticipleBtn.setFont(RenderedButton.FONT);
        passiveParticipleBtn.setFont(RenderedButton.FONT);
        timeAndPlaceBtn.setFont(RenderedButton.FONT);


        ButtonGroup bg = new ButtonGroup();
        bg.add(activeParticipleBtn);
        bg.add(passiveParticipleBtn);
        bg.add(timeAndPlaceBtn);

        add(buttonsPanel);

        activeParticipleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Action action = new Action() {
                    public List execute() {
                        if (selectionInfo.isTrilateral()) {
                            //here the Trilateral augmented
                            List result = AugmentedTrilateralActiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                            sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),selectionInfo.getAugmentationFormulaNo(),result, NamesSelectionUI.this);
                            return conjResult.getFinalResult();
                        }

                        List result = null;
                        if (selectionInfo.isAugmented()) {
                            result = AugmentedQuadriliteralActiveParticipleConjugator.getInstance().createNounList((AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        }
                        else {
                            result = UnaugmentedQuadriliteralActiveParticipleConjugator.getInstance().createNounList((UnaugmentedQuadriliteralRoot) selectionInfo.getRoot());
                        }
                        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                        return conjResult.getFinalResult();
                    }
                };

                NounConjugationUI ui = new NounConjugationUI(action, activeParticipleBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        passiveParticipleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Action action = new Action() {
                    public List execute() {
                        if (selectionInfo.isTrilateral()) {
                            //here the Trilateral augmented
                            List result = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                            sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                    selectionInfo.getAugmentationFormulaNo(), result, NamesSelectionUI.this);

                            return conjResult.getFinalResult();
                        }

                        List result = null;
                        if (selectionInfo.isAugmented()) {
                            result = AugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createNounList((AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        }
                        else {
                            result = UnaugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createNounList((UnaugmentedQuadriliteralRoot) selectionInfo.getRoot());
                        }

                        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                        return conjResult.getFinalResult();
                    }
                };

                NounConjugationUI ui = new NounConjugationUI(action, passiveParticipleBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });


        timeAndPlaceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Action action = new Action() {
                    public List execute() {
                        if (selectionInfo.isTrilateral()) {
                            //here the Trilateral augmented
                            List result = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createTimeAndPlaceNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                            sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                    selectionInfo.getAugmentationFormulaNo(), result, NamesSelectionUI.this);

                            return conjResult.getFinalResult();
                        }

                        List result = null;
                        if (selectionInfo.isAugmented()) {
                            result = AugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createTimeAndPlaceNounList((AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        }
                        else {
                            result = UnaugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createTimeAndPlaceNounList((UnaugmentedQuadriliteralRoot) selectionInfo.getRoot());
                        }

                        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                        return conjResult.getFinalResult();
                    }
                };

                NounConjugationUI ui = new NounConjugationUI(action, timeAndPlaceBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });
    }


    public JComponent getComponent() {
        return this;
    }

    public void setInfo(SelectionInfo selectionInfo) {
        this.selectionInfo = selectionInfo;

        //to ask the user again for this new verb, reset the cashed user response
        cashedUserResponse = null;
        activeParticipleBtn.doClick();
    }

    private boolean opened = false;
    public void controlPaneOpened() {
        opened = true;
    }


    public void controlPaneClosed() {
        opened = false;
    }

    Boolean cashedUserResponse = null;
    //to let the user select when there is two states for the verb: with vocalization and without
    public boolean doSelectVocalization() {
        if (cashedUserResponse != null) {
            return cashedUserResponse.booleanValue();
        }

        //it must select one of two states
        String msg = "·Â–« «·›⁄· Õ«· «‰ : «· ’ÕÌÕ Ê«·≈⁄·«·° «Œ — ≈ÕœÏ «·Õ«· Ì‰";
        Object[] options = {"«· ’ÕÌÕ", "«·≈⁄·«·"};
        int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        cashedUserResponse = new Boolean(optionResult == JOptionPane.NO_OPTION);
        return cashedUserResponse.booleanValue();
    }


}
