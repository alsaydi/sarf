package sarf.ui.controlpane;

import javax.swing.*;
import sarf.ui.*;
import java.awt.*;
import sarf.verb.trilateral.augmented.*;
import java.util.List;

import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;

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
    private final IMainControlPanel controlPaneContainer;
    private final AugmentedActivePastConjugator augmentedPassivePastConjugator;
    private SelectionInfo selectionInfo;

    private final ToggleRenderedButton pastBtn = new ToggleRenderedButton("الماضي المجهول ");
    private final ToggleRenderedButton presentNominativeBtn = new ToggleRenderedButton("المضارع المرفوع المجهول ");
    private final ToggleRenderedButton presentAccusativeBtn = new ToggleRenderedButton("المضارع المنصوب المجهول ");
    private final ToggleRenderedButton presentJussiveBtn = new ToggleRenderedButton("المضارع المجزوم المجهول ");
    private final ToggleRenderedButton presentEmphasizedBtn = new ToggleRenderedButton("المضارع المؤكد المجهول ");


    public PassiveVerbSelectionUI(ControlPaneContainer controlPaneContainer
            , AugmentedTrilateralModifier augmentedTrilateralModifier, AugmentedActivePastConjugator augmentedPassivePastConjugator) {
        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.augmentedPassivePastConjugator = augmentedPassivePastConjugator;

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

        pastBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedPassivePastConjugator.createVerbList((AugmentedTrilateralRoot) selectionInfo.
                            getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((
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
                    result = sarf.verb.quadriliteral.augmented.passive.past.AugmentedPassivePastConjugator.getInstance().createVerbList((AugmentedQuadrilateralRoot)
                            selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.passive.PassivePastConjugator.getInstance().createVerbList((UnaugmentedQuadrilateralRoot) selectionInfo.
                            getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot)
                        selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, false);
                result = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, pastBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentNominativeBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getNominativeConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((
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
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createNominativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot)
                        selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                result = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, presentNominativeBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentAccusativeBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getAccusativeConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((
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
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createAccusativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot)
                        selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                result = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, presentAccusativeBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentJussiveBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, false, PassiveVerbSelectionUI.this);
                    result = conjResult.getFinalResult();
                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        sarf.verb.trilateral.augmented.ConjugationResult notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                selectionInfo.getAugmentationFormulaNo(),
                                conjResult.getOriginalResult(), SystemConstants.PRESENT_TENSE, false, false, PassiveVerbSelectionUI.this);
                        List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(controlPaneContainer, result, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
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

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(controlPaneContainer, result, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.quadriliteral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getJussiveConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createJussiveVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                sarf.verb.quadriliteral.ConjugationResult notGeminatedConjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), conjResult.getOriginalResult(),
                        SystemConstants.PRESENT_TENSE, false, false);

                JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(controlPaneContainer, conjResult.getFinalResult(), notGeminatedConjResult.getFinalResult(), presentJussiveBtn.getText());
                controlPaneContainer.openResult(ui);
                return;


            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, presentJussiveBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        presentEmphasizedBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.passive.present.AugmentedPassivePresentConjugator.getInstance().getEmphasizedConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((
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
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.passive.PassivePresentConjugator.getInstance().createEmphasizedVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, false);
                result = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, presentEmphasizedBtn.getText());
            controlPaneContainer.openResult(ui);
        });
    }

    public JComponent getComponent() {
        return this;
    }

    void setInfo(SelectionInfo selectionInfo) {
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

    private Boolean cashedUserResponse = null;
    //to let the user select when there is two states for the verb: with vocalization and without
    public boolean doSelectVocalization() {
        if (cashedUserResponse != null) {
            return cashedUserResponse;
        }

        //it must select one of two states
        String msg = "لهذا الفعل حالتان : التصحيح والإعلال، اختر إحدى الحالتين";
        Object[] options = {"التصحيح", "الإعلال"};
        int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        cashedUserResponse = optionResult == JOptionPane.NO_OPTION;
        return cashedUserResponse;
    }


}
