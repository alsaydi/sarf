package sarf.ui.controlpane;

import sarf.ConjugationResult;
import sarf.SystemConstants;
import sarf.Word;
import sarf.WordPresenter;
import sarf.ui.*;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.augmented.active.present.AugmentedQuadActivePresentConjugator;
import sarf.verb.quadriliteral.augmented.imperative.AugmentedQuadImperativeConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.QuadUnaugmentedImperativeConjugator;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.unaugmented.active.QuadActivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.active.QuadriActivePastConjugator;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator;
import sarf.verb.trilateral.augmented.imperative.AugmentedImperativeConjugatorFactory;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;
import sarf.verb.trilateral.unaugmented.UnaugmentedImperativeConjugator;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator;
import sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier;

import javax.swing.*;
import java.awt.*;
import java.util.List;


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
    private final AugmentedActivePresentConjugator augmentedActivePresentConjugator;
    private final AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory;
    private final QuadActivePresentConjugator quadActivePresentConjugator;
    private final QuadrilateralModifier quadrilateralModifier;
    private final QuadUnaugmentedImperativeConjugator quadUnaugmentedImperativeConjugator;
    private final AugmentedQuadImperativeConjugator augmentedQuadImperativeConjugator;
    private final AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator;
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
    private final UnaugmentedTrilateralModifier unaugmentedTrilateralModifier;
    private final ActivePresentConjugator activePresentConjugator;
    private final UnaugmentedImperativeConjugator unaugmentedImperativeConjugator;

    public ActiveVerbSelectionUI(IMainControlPanel controlPaneContainer
            , ActivePastConjugator activePastConjugator
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , AugmentedActivePresentConjugator augmentedActivePresentConjugator
            , AugmentedImperativeConjugatorFactory augmentedImperativeConjugatorFactory
            , QuadActivePresentConjugator quadActivePresentConjugator
            , QuadrilateralModifier quadrilateralModifier
            , QuadUnaugmentedImperativeConjugator quadUnaugmentedImperativeConjugator
            , AugmentedQuadImperativeConjugator augmentedQuadImperativeConjugator
            , AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator
            , QuadriActivePastConjugator quadriActivePastConjugator
            , UnaugmentedTrilateralModifier unaugmentedTrilateralModifier
            , ActivePresentConjugator activePresentConjugator
            , UnaugmentedImperativeConjugator unaugmentedImperativeConjugator) {
        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.activePastConjugator = activePastConjugator;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.augmentedActivePresentConjugator = augmentedActivePresentConjugator;
        this.augmentedImperativeConjugatorFactory = augmentedImperativeConjugatorFactory;
        this.quadActivePresentConjugator = quadActivePresentConjugator;
        this.quadrilateralModifier = quadrilateralModifier;
        this.quadUnaugmentedImperativeConjugator = quadUnaugmentedImperativeConjugator;
        this.augmentedQuadImperativeConjugator = augmentedQuadImperativeConjugator;
        this.augmentedQuadActivePresentConjugator = augmentedQuadActivePresentConjugator;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.quadrilateralAugmentedActivePastConjugator = quadrilateralAugmentedActivePastConjugator;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.unaugmentedTrilateralModifier = unaugmentedTrilateralModifier;
        this.activePresentConjugator = activePresentConjugator;
        this.unaugmentedImperativeConjugator = unaugmentedImperativeConjugator;

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        var buttonsPanel = buildButtonPanel();
        add(buttonsPanel);

        pastBtn.addActionListener(e -> {
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                finalResult = generateTrilateralActivePastResult();
            } else {
                finalResult = generateQuadrilateralActivePastResult();
            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, "الماضي");
            controlPaneContainer.openResult(ui);
        });

        presentNominativeBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedActivePresentConjugator.getNominativeConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                } else {
                    result = this.activePresentConjugator.createNominativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    finalResult = conjResult.getFinalResult();
                }
            } else {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedQuadActivePresentConjugator.getNominativeConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = this.quadActivePresentConjugator.createNominativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                finalResult = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, "المضارع المرفوع");
            controlPaneContainer.openResult(ui);
        });

        presentAccusativeBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = augmentedActivePresentConjugator.getAccusativeConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                } else {
                    result = this.activePresentConjugator.createAccusativeVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    finalResult = conjResult.getFinalResult();
                }
            } else {
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadActivePresentConjugator.getAccusativeConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = quadActivePresentConjugator.createAccusativeVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                finalResult = conjResult.getFinalResult();
            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, "المضارع المنصوب");
            controlPaneContainer.openResult(ui);
        });

        presentJussiveBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = augmentedActivePresentConjugator.getJussiveConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        ConjugationResult notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                selectionInfo.getAugmentationFormulaNo(),
                                conjResult.getOriginalResult(), SystemConstants.PRESENT_TENSE, true, false, ActiveVerbSelectionUI.this);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                } else {
                    result = this.activePresentConjugator.createJussiveVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    finalResult = conjResult.getFinalResult();
                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        var notGeminatedConjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                conjResult.getOriginalResult(),
                                SystemConstants.PRESENT_TENSE, true, false);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedResult, presentJussiveBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            } else {
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadActivePresentConjugator.getJussiveConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = quadActivePresentConjugator.createJussiveVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = this.quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                ConjugationResult notGeminatedConjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), conjResult.getOriginalResult(),
                        SystemConstants.PRESENT_TENSE, true, false);

                finalResult = conjResult.getFinalResult();
                JussiveVerbConjugationUI ui = new JussiveVerbConjugationUI(this.controlPaneContainer, conjResult.getFinalResult(), notGeminatedConjResult.getFinalResult(), presentJussiveBtn.getText());
                controlPaneContainer.openResult(ui);
                return;

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, "المضارع المجزوم");
            controlPaneContainer.openResult(ui);
        });

        presentEmphasizedBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = augmentedActivePresentConjugator.getEmphasizedConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.PRESENT_TENSE, true, ActiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();
                } else {
                    result = this.activePresentConjugator.createEmphasizedVerbList((UnaugmentedTrilateralRoot) selectionInfo.
                            getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                    finalResult = conjResult.getFinalResult();
                }
            } else {
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadActivePresentConjugator.getEmphasizedConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = quadActivePresentConjugator.createEmphasizedVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PRESENT_TENSE, true);
                finalResult = conjResult.getFinalResult();

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, "المضارع المؤكد");
            controlPaneContainer.openResult(ui);
        });

        imperativeBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedImperativeConjugatorFactory.getNotEmphasizedConjugator().createVerbList((
                            AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, ActiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {

                        ConjugationResult notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                selectionInfo.getAugmentationFormulaNo(),
                                conjResult.getOriginalResult(), SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, false, ActiveVerbSelectionUI.this);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedResult, imperativeBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                } else {
                    result = this.unaugmentedImperativeConjugator.createVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result,
                            SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true);
                    finalResult = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        var notGeminatedConjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                conjResult.getOriginalResult(),
                                SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, false);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedResult, imperativeBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            } else {
                if (selectionInfo.isAugmented()) {
                    result = this.augmentedQuadImperativeConjugator.getNotEmphasizedConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = this.quadUnaugmentedImperativeConjugator.createVerbList((UnaugmentedQuadrilateralRoot) selectionInfo.
                            getRoot());
                }
                var conjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true);
                finalResult = conjResult.getFinalResult();

                var notGeminatedConjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.NOT_EMPHASIZED_IMPERATIVE_TENSE, true, false);

                ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedConjResult.getFinalResult(), imperativeBtn.getText());
                controlPaneContainer.openResult(ui);
                return;
            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, "الأمر");
            controlPaneContainer.openResult(ui);
        });

        imperativeEmphasizedBtn.addActionListener(e -> {
            List<? extends Word> result;
            List<WordPresenter> finalResult;
            if (selectionInfo.isTrilateral()) {
                if (selectionInfo.isAugmented()) {
                    result = augmentedImperativeConjugatorFactory.getEmphasizedConjugator().createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                            SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true, ActiveVerbSelectionUI.this);
                    finalResult = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    AugmentedTrilateralRoot root = (AugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        var notGeminatedConjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot()
                                , selectionInfo.getKov()
                                , selectionInfo.getAugmentationFormulaNo()
                                , conjResult.getOriginalResult()
                                , SystemConstants.EMPHASIZED_IMPERATIVE_TENSE
                                , true
                                , false
                                , ActiveVerbSelectionUI.this);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedResult, imperativeEmphasizedBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                } else {
                    result = this.unaugmentedImperativeConjugator.createEmphasizedVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
                    var conjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result,
                            SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
                    finalResult = conjResult.getFinalResult();

                    //testing for applying gemination or not is just for the verb that has c2 = c3
                    //it will displayed in a different component
                    UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();
                    if (root.getC2() == root.getC3()) {
                        var notGeminatedConjResult = this.unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                conjResult.getOriginalResult(),
                                SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true, false);
                        var notGeminatedResult = notGeminatedConjResult.getFinalResult();

                        ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedResult, imperativeEmphasizedBtn.getText());
                        controlPaneContainer.openResult(ui);
                        return;
                    }
                }
            } else {
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadImperativeConjugator.getEmphasizedConjugator().createVerbList((
                            AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = quadUnaugmentedImperativeConjugator.createEmphasizedVerbList((UnaugmentedQuadrilateralRoot)
                            selectionInfo.getRoot());
                }
                ConjugationResult conjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true);
                ConjugationResult notGeminatedConjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result,
                        SystemConstants.EMPHASIZED_IMPERATIVE_TENSE, true, false);

                finalResult = conjResult.getFinalResult();
                ImperativeVerbConjugationUI ui = new ImperativeVerbConjugationUI(this.controlPaneContainer, finalResult, notGeminatedConjResult.getFinalResult(), imperativeEmphasizedBtn.getText());
                controlPaneContainer.openResult(ui);
                return;

            }
            VerbConjugationUI ui = new VerbConjugationUI(this.controlPaneContainer, finalResult, "الأمر المؤكد");
            controlPaneContainer.openResult(ui);
        });
    }

    private List<WordPresenter> generateQuadrilateralActivePastResult() {
        if (selectionInfo.isAugmented()) {
            var result = quadrilateralAugmentedActivePastConjugator.createVerbList((AugmentedQuadrilateralRoot)
                    selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
            ConjugationResult conjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, true);
            return conjResult.getFinalResult();
        }

        var result = quadriActivePastConjugator.createVerbList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
        ConjugationResult conjResult = quadrilateralModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, true);
        return conjResult.getFinalResult();
    }

    private List<WordPresenter> generateTrilateralActivePastResult() {
        List<? extends Word> result;
        List<WordPresenter> presentableResult;
        if (selectionInfo.isAugmented()) {
            result = augmentedActivePastConjugator.createVerbList((AugmentedTrilateralRoot) selectionInfo.getRoot()
                    , selectionInfo.getAugmentationFormulaNo());
            var conjResult = augmentedTrilateralModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot()
                    , selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result,
                    SystemConstants.PAST_TENSE, true, ActiveVerbSelectionUI.this);
            presentableResult = conjResult.getFinalResult();
        } else {
            result = activePastConjugator.createVerbList((UnaugmentedTrilateralRoot) selectionInfo.getRoot());
            var conjResult =
                    unaugmentedTrilateralModifier.build((UnaugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), result, SystemConstants.PAST_TENSE, true);
            presentableResult = conjResult.getFinalResult();
        }
        return presentableResult;
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
