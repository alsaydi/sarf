package sarf.ui.controlpane;

import sarf.Action;
import sarf.Word;
import sarf.WordPresenter;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.modifier.trilateral.augmented.standard.TrilateralAugmentedStandardModifier;
import sarf.gerund.quadrilateral.augmented.QuadrilateralAugmentedGerundConjugator;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedGerundConjugator;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedGerundConjugatorListener;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugatorListener;
import sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerundConjugator;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.ui.*;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.verb.quadriliteral.augmented.AugmentedQuadrilateralRoot;
import sarf.verb.quadriliteral.unaugmented.UnaugmentedQuadrilateralRoot;
import sarf.verb.trilateral.augmented.AugmentedTrilateralRoot;
import sarf.ConjugationResult;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;

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
public class GerundSelectionUI extends JPanel implements IControlPane, TrilateralAugmentedGerundConjugatorListener, QuadrilateralUnaugmentedGerundConjugatorListener, AugmentedTrilateralModifierListener {
    private final IMainControlPanel controlPaneContainer;
    private SelectionInfo selectionInfo;

    private final ToggleRenderedButton standardBtn = new ToggleRenderedButton("المصدر الأصلي");
    private final ToggleRenderedButton nomenBtn = new ToggleRenderedButton("مصدر المرة");
    private final ToggleRenderedButton meemBtn = new ToggleRenderedButton("المصدر الميمي ");

    public GerundSelectionUI(ControlPaneContainer controlPaneContainer
            , TrilateralAugmentedGerundConjugator trilateralAugmentedGerundConjugator
            , TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier
            , PassiveParticipleModifier passiveParticipleModifier
            , QuadrilateralUnaugmentedGerundConjugator quadrilateralUnaugmentedGerundConjugator
            , TrilateralAugmentedNomenGerundConjugator trilateralAugmentedNomenGerundConjugator
            , GenericNounSuffixContainer genericNounSuffixContainer
            , QuadrilateralUnaugmentedNomenGerundConjugator quadrilateralUnaugmentedNomenGerundConjugator
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator
            , AugmentedQuadrilateralPassiveParticipleConjugator augmentedQuadrilateralPassiveParticipleConjugator
            , UnaugmentedQuadrilateralPassiveParticipleConjugator unaugmentedQuadrilateralPassiveParticipleConjugator
            , QuadrilateralAugmentedGerundConjugator quadrilateralAugmentedGerundConjugator
            , QuadrilateralAugmentedNomenGerundConjugator quadrilateralAugmentedNomenGerundConjugator
            , QuadrilateralStandardModifier quadrilateralStandardModifier
            , sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier quadrilateralPassiveParticipleModifier) {

        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel buttonsPanel = new APanel(new GridLayout(1, 7));

        buttonsPanel.add(standardBtn);
        buttonsPanel.add(nomenBtn);
        buttonsPanel.add(meemBtn);

        standardBtn.setFont(RenderedButton.FONT);
        nomenBtn.setFont(RenderedButton.FONT);
        meemBtn.setFont(RenderedButton.FONT);

        ButtonGroup bg = new ButtonGroup();
        bg.add(standardBtn);
        bg.add(nomenBtn);
        bg.add(meemBtn);

        add(buttonsPanel);

        trilateralAugmentedGerundConjugator.setListener(this);
        trilateralAugmentedGerundConjugator.setAugmentedTrilateralModifierListener(this);
        quadrilateralUnaugmentedGerundConjugator.setListener(this);

        standardBtn.addActionListener(e -> {
            Action action = () -> {
                List<? extends Word> gerunds;
                if (selectionInfo.isTrilateral()) {
                    gerunds = trilateralAugmentedGerundConjugator.createGerundList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = trilateralAugmentedStandardModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), gerunds, GerundSelectionUI.this);
                    return conjResult.getFinalResult();
                }

                if (selectionInfo.isAugmented()) {
                    gerunds = quadrilateralAugmentedGerundConjugator.createGerundList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    gerunds = quadrilateralUnaugmentedGerundConjugator.createGerundList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }
                ConjugationResult conjResult = quadrilateralStandardModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), gerunds);
                return conjResult.getFinalResult();
            };
            NounConjugationUI ui = new NounConjugationUI(this.controlPaneContainer, action, genericNounSuffixContainer, standardBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        nomenBtn.addActionListener(e -> {
            Action action = () -> {
                List<? extends Word> gerunds;
                if (selectionInfo.isTrilateral()) {
                    gerunds = trilateralAugmentedNomenGerundConjugator.createGerundList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    var conjResult = trilateralAugmentedStandardModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), gerunds, GerundSelectionUI.this);
                    return conjResult.getFinalResult();
                }

                if (selectionInfo.isAugmented()) {
                    gerunds = quadrilateralAugmentedNomenGerundConjugator.createGerundList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    gerunds = quadrilateralUnaugmentedNomenGerundConjugator.createGerundList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }
                ConjugationResult conjResult = quadrilateralStandardModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), gerunds);
                return conjResult.getFinalResult();
            };
            NounConjugationUI ui = new NounConjugationUI(this.controlPaneContainer, action, genericNounSuffixContainer, nomenBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        meemBtn.addActionListener(e -> {
            Action action = () -> {
                if (selectionInfo.isTrilateral()) {
                    //here the Trilateral augmented
                    List result = augmentedTrilateralPassiveParticipleConjugator.createMeemGerundNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = passiveParticipleModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), result, GerundSelectionUI.this);

                    return conjResult.getFinalResult();
                }

                List result = null;
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadrilateralPassiveParticipleConjugator.createMeemGerundNounList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = unaugmentedQuadrilateralPassiveParticipleConjugator.createMeemGerundNounList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }

                ConjugationResult conjResult = quadrilateralPassiveParticipleModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                return conjResult.getFinalResult();
            };

            NounConjugationUI ui = new NounConjugationUI(this.controlPaneContainer, action, genericNounSuffixContainer, meemBtn.getText());
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
        cashedPatternFormulaNo = -1;
        cashedQuadPatternFormulaNo = -1;
        standardBtn.doClick();
    }

    private boolean opened = false;

    public void controlPaneOpened() {
        opened = true;
    }


    public void controlPaneClosed() {
        opened = false;
    }

    private int cashedPatternFormulaNo = -1;

    public int selectPatternFormNo(int formulaNo) {
        if (cashedPatternFormulaNo != -1)
            return cashedPatternFormulaNo;

        if (formulaNo == 3) {
            //it must select one of two states
            String msg = "لهذا المصدر وزنان (مفاعلة) و  (فعال) اختر أحدهما";
            Object[] options = {"مفاعلة", "فِعال"};
            int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            return cashedPatternFormulaNo = (optionResult == JOptionPane.NO_OPTION ? 2 : 1);
        }
        if (formulaNo == 2) {
            //it must select one of two states
            String msg = "لهذا المصدر وزنان: (تفعيل) و(تفعلة)، اختر أحدهما";
            Object[] options = {"تفعيل", "تفعلة"};
            int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            return cashedPatternFormulaNo = (optionResult == JOptionPane.NO_OPTION ? 2 : 1);
        }
        return -1;
    }

    private int cashedQuadPatternFormulaNo = -1;

    public int selectFormNo() {
        if (cashedQuadPatternFormulaNo != -1)
            return cashedQuadPatternFormulaNo;

        //it must select one of two states
        String msg = "لهذا المصدر وزنان (فَعْلَلَة) و  (فِعْلال) اختر أحدهما";
        Object[] options = {"فَعْلَلَة", "فِعْلال"};
        int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return cashedQuadPatternFormulaNo = (optionResult == JOptionPane.NO_OPTION ? 2 : 1);
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
