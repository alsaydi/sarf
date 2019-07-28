package sarf.ui.controlpane;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

import sarf.ui.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.quadriliteral.QuadrilateralRoot;
import sarf.Action;
import sarf.noun.quadriliteral.augmented.AugmentedQuadriliteralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadriliteralPassiveParticipleConjugator;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugatorListener;
import sarf.gerund.quadrilateral.unaugmented.QuadriliteralUnaugmentedGerundConjugatorListener;
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
public class GerundSelectionUI extends JPanel implements IControlPane, TrilateralAugmentedGerundConjugatorListener, QuadriliteralUnaugmentedGerundConjugatorListener, AugmentedTrilateralModifierListener {
    private SelectionInfo selectionInfo;

    private final ToggleRenderedButton standardBtn = new ToggleRenderedButton("المصدر الأصلي");
    private final ToggleRenderedButton nomenBtn = new ToggleRenderedButton("مصدر المرة");
    private final ToggleRenderedButton meemBtn = new ToggleRenderedButton("المصدر الميمي ");

    public GerundSelectionUI() {
        super(new BorderLayout());

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

        sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator.getInstance().setListener(this);
        sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator.getInstance().setAugmentedTrilateralModifierListener(this);
        sarf.gerund.quadrilateral.unaugmented.QuadriliteralUnaugmentedGerundConjugator.getInstance().setListener(this);

        standardBtn.addActionListener(e -> {
            Action action = () -> {
                List gerunds = null;
                if (selectionInfo.isTrilateral()) {
                    gerunds = sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator.getInstance().createGerundList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = sarf.gerund.modifier.trilateral.augmented.standard.TitlateralAugmentedStandardModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), gerunds, GerundSelectionUI.this);
                    return conjResult.getFinalResult();
                }

                if (selectionInfo.isAugmented()) {
                    gerunds = sarf.gerund.quadrilateral.augmented.QuadriliteralAugmentedGerundConjugator.getInstance().createGerundList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    gerunds = sarf.gerund.quadrilateral.unaugmented.QuadriliteralUnaugmentedGerundConjugator.getInstance().createGerundList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), gerunds);
                return conjResult.getFinalResult();
            };
            NounConjugationUI ui = new NounConjugationUI(action, standardBtn.getText());
            ControlPaneContainer.getInstance().openResult(ui);
        });

        nomenBtn.addActionListener(e -> {
            Action action = () -> {
                List gerunds = null;
                if (selectionInfo.isTrilateral()) {
                    gerunds = sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerundConjugator.getInstance().createGerundList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = sarf.gerund.modifier.trilateral.augmented.standard.TitlateralAugmentedStandardModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), gerunds, GerundSelectionUI.this);
                    return conjResult.getFinalResult();
                }

                if (selectionInfo.isAugmented()) {
                    gerunds = sarf.gerund.quadrilateral.augmented.nomen.QuadriliteralAugmentedNomenGerundConjugator.getInstance().createGerundList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    gerunds = sarf.gerund.quadrilateral.unaugmented.QuadriliteralUnaugmentedNomenGerundConjugator.getInstance().createGerundList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }
                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), gerunds);
                return conjResult.getFinalResult();
            };
            NounConjugationUI ui = new NounConjugationUI(action, nomenBtn.getText());
            ControlPaneContainer.getInstance().openResult(ui);
        });

        meemBtn.addActionListener(e -> {
            Action action = () -> {
                if (selectionInfo.isTrilateral()) {
                    //here the Trilateral augmented
                    List result = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createMeemGerundNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    ConjugationResult conjResult = sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), result, GerundSelectionUI.this);

                    return conjResult.getFinalResult();
                }

                List result = null;
                if (selectionInfo.isAugmented()) {
                    result = AugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createMeemGerundNounList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = UnaugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createMeemGerundNounList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }

                sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                return conjResult.getFinalResult();
            };

            NounConjugationUI ui = new NounConjugationUI(action, meemBtn.getText());
            ControlPaneContainer.getInstance().openResult(ui);
        });

    }

    public JComponent getComponent() {
        return this;
    }

    public void setInfo(SelectionInfo selectionInfo) {
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

    int cashedPatternFormulaNo  = -1;
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

    private int cashedQuadPatternFormulaNo  = -1;
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
