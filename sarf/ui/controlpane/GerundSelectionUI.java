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

    ToggleRenderedButton standardBtn = new ToggleRenderedButton("«·„’œ— «·√’·Ì");
    ToggleRenderedButton nomenBtn = new ToggleRenderedButton("„’œ— «·„—…");
    ToggleRenderedButton meemBtn = new ToggleRenderedButton("«·„’œ— «·„Ì„Ì ");

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

        standardBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sarf.Action action = new sarf.Action() {
                    public List execute() {
                        List gerunds = null;
                        if (selectionInfo.isTrilateral()) {
                            gerunds = sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator.getInstance().createGerundList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                            sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.gerund.modifier.trilateral.augmented.standard.TitlateralAugmentedStandardModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                    selectionInfo.getAugmentationFormulaNo(), gerunds, GerundSelectionUI.this);
                            return conjResult.getFinalResult();
                        }

                        if (selectionInfo.isAugmented()) {
                            gerunds = sarf.gerund.quadrilateral.augmented.QuadriliteralAugmentedGerundConjugator.getInstance().createGerundList((AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        }
                        else {
                            gerunds = sarf.gerund.quadrilateral.unaugmented.QuadriliteralUnaugmentedGerundConjugator.getInstance().createGerundList((UnaugmentedQuadriliteralRoot) selectionInfo.getRoot());
                        }
                        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), gerunds);
                        return conjResult.getFinalResult();
                    }
                };
                NounConjugationUI ui = new NounConjugationUI(action, standardBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        nomenBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sarf.Action action = new sarf.Action() {
                    public List execute() {
                        List gerunds = null;
                        if (selectionInfo.isTrilateral()) {
                            gerunds = sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerundConjugator.getInstance().createGerundList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                            sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.gerund.modifier.trilateral.augmented.standard.TitlateralAugmentedStandardModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                    selectionInfo.getAugmentationFormulaNo(), gerunds, GerundSelectionUI.this);
                            return conjResult.getFinalResult();
                        }

                        if (selectionInfo.isAugmented()) {
                            gerunds = sarf.gerund.quadrilateral.augmented.nomen.QuadriliteralAugmentedNomenGerundConjugator.getInstance().createGerundList((AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        }
                        else {
                            gerunds = sarf.gerund.quadrilateral.unaugmented.QuadriliteralUnaugmentedNomenGerundConjugator.getInstance().createGerundList((UnaugmentedQuadriliteralRoot) selectionInfo.getRoot());
                        }
                        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), gerunds);
                        return conjResult.getFinalResult();
                    }
                };
                NounConjugationUI ui = new NounConjugationUI(action, nomenBtn.getText());
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        meemBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Action action = new Action() {
                    public List execute() {
                        if (selectionInfo.isTrilateral()) {
                            //here the Trilateral augmented
                            List result = AugmentedTrilateralPassiveParticipleConjugator.getInstance().createMeemGerundNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                            sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                                    selectionInfo.getAugmentationFormulaNo(), result, GerundSelectionUI.this);

                            return conjResult.getFinalResult();
                        }

                        List result = null;
                        if (selectionInfo.isAugmented()) {
                            result = AugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createMeemGerundNounList((AugmentedQuadriliteralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                        }
                        else {
                            result = UnaugmentedQuadriliteralPassiveParticipleConjugator.getInstance().createMeemGerundNounList((UnaugmentedQuadriliteralRoot) selectionInfo.getRoot());
                        }

                        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier.getInstance().build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                        return conjResult.getFinalResult();
                    }
                };

                NounConjugationUI ui = new NounConjugationUI(action, meemBtn.getText());
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
            String msg = "·Â–« «·„’œ— Ê“‰«‰ („›«⁄·…) Ê  (›⁄«·) «Œ — √ÕœÂ„«";
            Object[] options = {"„›«⁄·…", "›ˆ⁄«·"};
            int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            return cashedPatternFormulaNo = (optionResult == JOptionPane.NO_OPTION ? 2 : 1);
        }
        if (formulaNo == 2) {
            //it must select one of two states
            String msg = "·Â–« «·„’œ— Ê“‰«‰: ( ›⁄Ì·) Ê( ›⁄·…)° «Œ — √ÕœÂ„«";
            Object[] options = {" ›⁄Ì·", " ›⁄·…"};
            int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            return cashedPatternFormulaNo = (optionResult == JOptionPane.NO_OPTION ? 2 : 1);
        }
        return -1;
    }

    int cashedQuadPatternFormulaNo  = -1;
    public int selectFormNo() {
        if (cashedQuadPatternFormulaNo != -1)
            return cashedQuadPatternFormulaNo;

        //it must select one of two states
        String msg = "·Â–« «·„’œ— Ê“‰«‰ (›Û⁄˙·Û·Û…) Ê  (›ˆ⁄˙·«·) «Œ — √ÕœÂ„«";
        Object[] options = {"›Û⁄˙·Û·Û…", "›ˆ⁄˙·«·"};
        int optionResult = JOptionPane.showOptionDialog(this, msg, "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return cashedQuadPatternFormulaNo = (optionResult == JOptionPane.NO_OPTION ? 2 : 1);
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
