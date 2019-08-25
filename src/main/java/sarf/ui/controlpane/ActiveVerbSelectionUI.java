package sarf.ui.controlpane;

import sarf.SystemConstants;
import sarf.ui.*;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.AugmentedPastVerb;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.augmented.passive.past.QuadriAugmentedPassivePastConjugator;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.unaugmented.active.QuadriActivePastConjugator;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugatorFactory;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePastVerb;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;


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
public class ActiveVerbSelectionUI extends JPanel implements IControlPane, AugmentedTrilateralModifierListener {
    private final IMainControlPanel controlPaneContainer;
    private final ActivePastConjugator activePastConjugator;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private SelectionInfo selectionInfo;

    private final ToggleRenderedButton pastBtn = new ToggleRenderedButton("الماضي");
    private final ToggleRenderedButton presentNominativeBtn = new ToggleRenderedButton("المضارع المرفوع");
    private final ToggleRenderedButton presentAccusativeBtn = new ToggleRenderedButton("المضارع المنصوب");
    private final ToggleRenderedButton presentJussiveBtn = new ToggleRenderedButton("المضارع المجزوم");
    private final ToggleRenderedButton presentEmphasizedBtn = new ToggleRenderedButton("المضارع المؤكد");
    private final ToggleRenderedButton imperativeBtn = new ToggleRenderedButton("الأمر");
    private final ToggleRenderedButton imperativeEmphasizedBtn = new ToggleRenderedButton("الأمر المؤكد");
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator;
    private final QuadriActivePastConjugator quadriActivePastConjugator;

    public ActiveVerbSelectionUI(IMainControlPanel controlPaneContainer
            , ActivePastConjugator activePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator
            , QuadriActivePastConjugator quadriActivePastConjugator) {
        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.activePastConjugator = activePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.quadrilateralAugmentedActivePastConjugator = quadrilateralAugmentedActivePastConjugator;
        this.quadriActivePastConjugator = quadriActivePastConjugator;

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        var buttonsPanel = buildButtonPanel();
        add(buttonsPanel);

        pastBtn.addActionListener(e -> {
            List result;
            if (selectionInfo.isTrilateral()) {
                result = generateTrilateralActivePastResult();
            }
            else {
                result = generateQuadrilateralActivePastResult();
            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, "الماضي");
            controlPaneContainer.openResult(ui);
        });

        presentNominativeBtn.addActionListener(e -> {
            List result;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getNominativeConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    result = conjResult.getFinalResult();
                }
                else {
                    result = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createNominativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    result = conjResult.getFinalResult();
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.quadriliteral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getNominativeConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.active.ActivePresentConjugator.getInstance().createNominativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                result = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, "المضارع المرفوع");
            controlPaneContainer.openResult(ui);
        });

        presentAccusativeBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getAccusativeConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    result = conjResult.getFinalResult();
                }
                else {
                    result = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createAccusativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    result = conjResult.getFinalResult();
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.quadriliteral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getAccusativeConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.active.ActivePresentConjugator.getInstance().createAccusativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                result = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, "المضارع المنصوب");
            controlPaneContainer.openResult(ui);
        });

        presentJussiveBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    result = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        sarf.verb.trilateral.augmented.ConjugationResult notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                selectionInfo.getAugmentationFormulaNo(),
                                conjResult.getOriginalResult(), SystemConstants.PRESENT_TENSE, true, false, ActiveVerbSelectionUI.this);
                        List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(this.controlPaneContainer, result, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
                else {
                    result = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createJussiveVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    result = conjResult.getFinalResult();
                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        sarf.verb.trilateral.unaugmented.ConjugationResult notGeminatedConjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                conjResult.getOriginalResult(),
                                SystemConstants.PRESENT_TENSE, true, false);
                        List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(this.controlPaneContainer, result, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.quadriliteral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getJussiveConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.active.ActivePresentConjugator.getInstance().createJussiveVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                sarf.verb.quadriliteral.ConjugationResult notGeminatedConjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), conjResult.getOriginalResult(),
                        SystemConstants.PRESENT_TENSE, true, false);

                JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(this.controlPaneContainer, conjResult.getFinalResult(), notGeminatedConjResult.getFinalResult(), presentJussiveBtn.getText());
                controlPaneContainer.openResult(ui);
                return;

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, "المضارع المجزوم");
            controlPaneContainer.openResult(ui);
        });

        presentEmphasizedBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getEmphasizedConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    result = conjResult.getFinalResult();
                }
                else {
                    result = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createEmphasizedVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    result = conjResult.getFinalResult();
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.quadriliteral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getEmphasizedConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.active.ActivePresentConjugator.getInstance().createEmphasizedVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                result = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, "المضارع المؤكد");
            controlPaneContainer.openResult(ui);
        });

        imperativeBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = AugmentedImperativeConjugatorFactory.getInstance().getNotEmphasizedConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, ActiveVerbSelectionUI.this);
                    result = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {

                        sarf.verb.trilateral.augmented.ConjugationResult notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                selectionInfo.getAugmentationFormulaNo(),
                                conjResult.getOriginalResult(), SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, false, ActiveVerbSelectionUI.this);
                        List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, result, notGeminatedResult, imperativeBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
                else {
                    result = sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result,
                            SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true);
                    result = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        sarf.verb.trilateral.unaugmented.ConjugationResult notGeminatedConjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                conjResult.getOriginalResult(),
                                SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, false);
                        List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, result, notGeminatedResult, imperativeBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.quadriliteral.augmented.imperative.AugmentedImperativeConjugator.getInstance().getNotEmphsizedConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createVerbList((UnaugmentedQuadrilateralRoot) selectionInfo.
                            getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true);

                sarf.verb.quadriliteral.ConjugationResult notGeminatedConjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, false);

                ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, conjResult.getFinalResult(), notGeminatedConjResult.getFinalResult(), imperativeBtn.getText());
                controlPaneContainer.openResult(ui);
                return;
            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, "الأمر");
            controlPaneContainer.openResult(ui);
        });

        imperativeEmphasizedBtn.addActionListener(e -> {
            List result = null;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = AugmentedImperativeConjugatorFactory.getInstance().getEmphasizedConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true, ActiveVerbSelectionUI.this);
                    result = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        sarf.verb.trilateral.augmented.ConjugationResult notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                selectionInfo.getAugmentationFormulaNo(),
                                conjResult.getOriginalResult(), SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true, false, ActiveVerbSelectionUI.this);
                        List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, result, notGeminatedResult, imperativeEmphasizedBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
                else {
                    result = sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createEmphasizedVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result,
                            SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
                    result = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        sarf.verb.trilateral.unaugmented.ConjugationResult notGeminatedConjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                conjResult.getOriginalResult(),
                                SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true, false);
                        List notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, result, notGeminatedResult, imperativeEmphasizedBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            }
            else {
                if (selectionInfo.isAugmented()) {
                    result = sarf.verb.quadriliteral.augmented.imperative.AugmentedImperativeConjugator.getInstance().getEmphsizedConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                }
                else {
                    result = sarf.verb.quadriliteral.unaugmented.UnaugmentedImperativeConjugator.getInstance().createEmphasizedVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
                sarf.verb.quadriliteral.ConjugationResult notGeminatedConjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true, false);

                ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, conjResult.getFinalResult(), notGeminatedConjResult.getFinalResult(), imperativeEmphasizedBtn.getText());
                controlPaneContainer.openResult(ui);
                return;

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, result, "الأمر المؤكد");
            controlPaneContainer.openResult(ui);
        });
    }

    private List<String> generateQuadrilateralActivePastResult() {
        if (selectionInfo.isAugmented()) {
           var result = quadrilateralAugmentedActivePastConjugator.createVerbList((AugmentedQuadrilateralRoot)
                    selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
            sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, true);
            result = conjResult.getFinalResult();
            return result.stream().map(AugmentedPastVerb::toString).collect(Collectors.toList());
        }

        var result = quadriActivePastConjugator.createVerbList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, true);
        result = conjResult.getFinalResult();
        return result.stream().map(v -> v.toString()).collect(Collectors.toList());
    }

    private List generateTrilateralActivePastResult() {
        List result;
        if (selectionInfo.isAugmented()) {
            result = augmentedActivePastConjugator.createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
            sarf.verb.trilateral.augmented.ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                    SystemConstants.PAST_TENSE, true, ActiveVerbSelectionUI.this);
            result = conjResult.getFinalResult();
        }
        else {
            result = activePastConjugator.createVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
            sarf.verb.trilateral.unaugmented.ConjugationResult<ActivePastVerb> conjResult = UnaugmentedTrilateralModifier.getInstance()
                    .build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, true);
            result = conjResult.getFinalResult();
        }
        return result;
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

    /**
     * to let the user select when there is two states for the verb: with vocalization and without
     * @return
     */
    public boolean doSelectVocalization() {
        if (null != cashedUserResponse) {
            return cashedUserResponse;
        }

        //it must select one of two states
        String msg = "لهذا الفعل حالتان : التصحيح والإعلال، اختر إحدى الحالتين";
        Object[] options = {"التصحيح", "الإعلال"};
        int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        cashedUserResponse = optionResult == JOptionPane.NO_OPTION;
        return cashedUserResponse;
    }

    private JPanel buildButtonPanel() {
        JPanel buttonsPanel = new APanel(new GridLayout(1, 7));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(pastBtn);
        buttonGroup.add(presentNominativeBtn);
        buttonGroup.add(presentAccusativeBtn);
        buttonGroup.add(presentJussiveBtn);
        buttonGroup.add(presentEmphasizedBtn);
        buttonGroup.add(imperativeBtn);
        buttonGroup.add(imperativeEmphasizedBtn);

        buttonsPanel.add(pastBtn);
        buttonsPanel.add(presentNominativeBtn);
        buttonsPanel.add(presentAccusativeBtn);
        buttonsPanel.add(presentJussiveBtn);
        buttonsPanel.add(presentEmphasizedBtn);
        buttonsPanel.add(imperativeBtn);
        buttonsPanel.add(imperativeEmphasizedBtn);
        return buttonsPanel;
    }
}
