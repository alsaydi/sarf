package sarf.ui.controlpane;

import javax.swing.*;
import sarf.ui.*;
import java.awt.*;
import java.awt.event.*;
import sarf.verb.trilateral.augmented.*;
import java.util.List;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.QuadrilateralRoot;
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
public class PassiveVerbSelectionUI extends JPanel implements IControlPane, AugmentedTrilateralModifierListener {
    private SelectionInfo selectionInfo;

    ToggleRenderedButton pastBtn = new ToggleRenderedButton("«·„«÷Ì «·„ÃÂÊ· ");
    ToggleRenderedButton presentNominativeBtn = new ToggleRenderedButton("«·„÷«—⁄ «·„—›Ê⁄ «·„ÃÂÊ· ");
    ToggleRenderedButton presentAccusativeBtn = new ToggleRenderedButton("«·„÷«—⁄ «·„‰’Ê» «·„ÃÂÊ· ");
    ToggleRenderedButton presentJussiveBtn = new ToggleRenderedButton("«·„÷«—⁄ «·„Ã“Ê„ «·„ÃÂÊ· ");
    ToggleRenderedButton presentEmphasizedBtn = new ToggleRenderedButton("«·„÷«—⁄ «·„ƒﬂœ «·„ÃÂÊ· ");


    public PassiveVerbSelectionUI() {
        super(new BorderLayout());

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel topPane = new APanel(new GridLayout(1, 4));
        topPane.add(Box.createHorizontalBox());

        topPane.add(Box.createHorizontalBox());

        JPanel buttonsPanel = new APanel(new GridLayout(1, 7));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(pastBtn);
        buttonGroup.add(presentNominativeBtn);
        buttonGroup.add(presentAccusativeBtn);
        buttonGroup.add(presentJussiveBtn);
        buttonGroup.add(presentEmphasizedBtn);

        buttonsPanel.add(pastBtn);
        buttonsPanel.add(presentNominativeBtn);
        buttonsPanel.add(presentAccusativeBtn);
        buttonsPanel.add(presentJussiveBtn);
        buttonsPanel.add(presentEmphasizedBtn);

        add(topPane);
        add(buttonsPanel);

        pastBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List result = null;
                if (selectionInfo.isTrilateral()) {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator.getInstance().createVerbList((AugmentedTrilateralRoot) selectionInfo.
                                getRoot(), selectionInfo.getAugmentationFormulaNo());
                        sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build((
                                AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                                SystemConstants.PAST_TENSE, false, PassiveVerbSelectionUI.this);
                        result = conjResult.getFinalResult();
                    }
                    else {
                        result = sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((
                                UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, false);
                        result = conjResult.getFinalResult();
                    }
                }
                else {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.quadriliteral.augmented.passive.past.AugmentedPassivePastConjugator.getInstance().createVerbList((AugmentedQuadriliteralRoot)
                                selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    }
                    else {
                        result = sarf.verb.quadriliteral.unaugmented.passive.PassivePastConjugator.getInstance().createVerbList((UnaugmentedQuadriliteralRoot) selectionInfo.
                                getRoot());
                    }
                    sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot)
                            selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, false);
                    result = conjResult.getFinalResult();

                }
                VerbConjugationUI ui = new VerbConjugationUI(result, pastBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        presentNominativeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List result = null;
                if (selectionInfo.isTrilateral()) {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getNominativeConjugator().createVerbList((
                                AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build((
                                AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                                SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                        result = conjResult.getFinalResult();
                    }
                    else {
                        result = sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().createNominativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                                getRoot());
                        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((
                                UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                        result = conjResult.getFinalResult();
                    }
                }
                else {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.quadriliteral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getNominativeConjugator().createVerbList((
                                AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    }
                    else {
                        result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createNominativeVerbList((UnaugmentedQuadriliteralRoot)
                                selectionInfo.getRoot());
                    }
                    sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot)
                            selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    result = conjResult.getFinalResult();

                }
                VerbConjugationUI ui = new VerbConjugationUI(result, presentNominativeBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        presentAccusativeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List result = null;
                if (selectionInfo.isTrilateral()) {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getAccusativeConjugator().createVerbList((
                                AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build((
                                AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                                SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                        result = conjResult.getFinalResult();
                    }
                    else {
                        result = sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().createAccusativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                                getRoot());
                        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((
                                UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                        result = conjResult.getFinalResult();
                    }
                }
                else {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.quadriliteral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getAccusativeConjugator().createVerbList((
                                AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    }
                    else {
                        result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createAccusativeVerbList((UnaugmentedQuadriliteralRoot)
                                selectionInfo.getRoot());
                    }
                    sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot)
                            selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    result = conjResult.getFinalResult();

                }
                VerbConjugationUI ui = new VerbConjugationUI(result, presentAccusativeBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        presentJussiveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List result = null;
                if (selectionInfo.isTrilateral()) {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                                SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                        result = conjResult.getFinalResult();
                        //testing for applying gemination or not is just for the verb that has c2 = c3
                        //it will displayed in a different component
                        AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                        if (root.getC2() == root.getC3()) {
                            sarf.verb.trilateral.augmented.ConjugationResult notGeminatedConjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                    selectionInfo.getAugmentationFormulaNo(),
                                    conjResult.getOriginalResult(), SystemConstants.PRESENT_TENSE, false, false, PassiveVerbSelectionUI.this);
                            List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                            JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(result, notGeminatedResult, presentJussiveBtn.getText());
                            ControlPaneContainer.getInstance().openResult(ui);
                            return;
                        }
                    }
                    else {
                        result = sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().createJussiveVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                        result = conjResult.getFinalResult();

                        //testing for applying gemination or not is just for the verb that has c2 = c3
                        //it will displayed in a different component
                        UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                        if (root.getC2() == root.getC3()) {
                            sarf.verb.trilateral.unaugmented.ConjugationResult notGeminatedConjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                    conjResult.getOriginalResult(),
                                    SystemConstants.PRESENT_TENSE, false, false);
                            List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                            JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(result, notGeminatedResult, presentJussiveBtn.getText());
                            ControlPaneContainer.getInstance().openResult(ui);
                            return;
                        }
                    }
                }
                else {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.quadriliteral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getJussiveConjugator().createVerbList((
                                AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    }
                    else {
                        result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createJussiveVerbList((UnaugmentedQuadriliteralRoot)
                                selectionInfo.getRoot());
                    }
                    sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    sarf.verb.quadriliteral.ConjugationResult notGeminatedConjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), conjResult.getOriginalResult(),
                            SystemConstants.PRESENT_TENSE, false, false);

                    JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(conjResult.getFinalResult(), notGeminatedConjResult.getFinalResult(), presentJussiveBtn.getText());
                    ControlPaneContainer.getInstance().openResult(ui);
                    return;


                }
                VerbConjugationUI ui = new VerbConjugationUI(result, presentJussiveBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        presentEmphasizedBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List result = null;
                if (selectionInfo.isTrilateral()) {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getEmphasizedConjugator().createVerbList((
                                AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build((
                                AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                                SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                        result = conjResult.getFinalResult();
                    }
                    else {
                        result = sarf.verb.trilateral.unaugmented.passive.PassivePresentConjugator.getInstance().createEmphasizedVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                                getRoot());
                        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((
                                UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                        result = conjResult.getFinalResult();
                    }
                }
                else {
                    if (selectionInfo.isAugmented()) {
                        result = sarf.verb.quadriliteral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getEmphasizedConjugator().createVerbList((
                                AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    }
                    else {
                        result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createEmphasizedVerbList((UnaugmentedQuadriliteralRoot)
                                selectionInfo.getRoot());
                    }
                    sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                    result = conjResult.getFinalResult();

                }
                VerbConjugationUI ui = new VerbConjugationUI(result, presentEmphasizedBtn.getText());
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
        pastBtn.doClick();
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
