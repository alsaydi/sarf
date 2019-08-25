package sarf.ui.controlpane;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.quadriliteral.augmented.*;
import sarf.noun.quadriliteral.unaugmented.*;
import sarf.noun.trilateral.augmented.*;
import sarf.ui.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.trilateral.augmented.*;
import sarf.Action;
import sarf.verb.quadriliteral.*;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifierListener;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;

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
    private final IMainControlPanel controlPaneContainer;
    private final ActiveParticipleModifier activeParticipleModifier;
    private SelectionInfo selectionInfo;


    private final ToggleRenderedButton activeParticipleBtn = new ToggleRenderedButton("اسم الفاعل");
    private final ToggleRenderedButton passiveParticipleBtn = new ToggleRenderedButton("اسم المفعول");
    private final ToggleRenderedButton timeAndPlaceBtn = new ToggleRenderedButton("اسم الزمان والمكان  ");


    public NamesSelectionUI(ControlPaneContainer controlPaneContainer
            , ActiveParticipleModifier activeParticipleModifier
            , PassiveParticipleModifier passiveParticipleModifier
            , GenericNounSuffixContainer genericNounSuffixContainer
            , AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator
            , AugmentedQuadrilateralActiveParticipleConjugator augmentedQuadrilateralActiveParticipleConjugator
            , UnaugmentedQuadrilateralActiveParticipleConjugator unaugmentedQuadrilateralActiveParticipleConjugator
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator
            , AugmentedQuadrilateralPassiveParticipleConjugator augmentedQuadrilateralPassiveParticipleConjugator
            , UnaugmentedQuadrilateralPassiveParticipleConjugator unaugmentedQuadrilateralPassiveParticipleConjugator
            , sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier quadrilateralActiveParticipleModifier
            , sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier quadrilateralPassiveParticipleModifier) {

        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.activeParticipleModifier = activeParticipleModifier;
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

        activeParticipleBtn.addActionListener(e -> {
            Action action = () -> {
                if (selectionInfo.isTrilateral()) {
                    //here the Trilateral augmented
                    List result = augmentedTrilateralActiveParticipleConjugator.createNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = this.activeParticipleModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(), selectionInfo.getAugmentationFormulaNo(), result, NamesSelectionUI.this);
                    return conjResult.getFinalResult();
                }

                List result;
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadrilateralActiveParticipleConjugator.createNounList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = unaugmentedQuadrilateralActiveParticipleConjugator.createNounList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }

                QuadriConjugationResult conjResult = quadrilateralActiveParticipleModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                return conjResult.getFinalResult();
            };

            NounConjugationUI ui = new NounConjugationUI(this.controlPaneContainer, action, genericNounSuffixContainer, activeParticipleBtn.getText());
            controlPaneContainer.openResult(ui);
        });

        passiveParticipleBtn.addActionListener(e -> {
            Action action = () -> {
                if (selectionInfo.isTrilateral()) {
                    //here the Trilateral augmented
                    List result = augmentedTrilateralPassiveParticipleConjugator.createNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = passiveParticipleModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), result, NamesSelectionUI.this);

                    return conjResult.getFinalResult();
                }

                List result = null;
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadrilateralPassiveParticipleConjugator.createNounList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = unaugmentedQuadrilateralPassiveParticipleConjugator.createNounList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }

                QuadriConjugationResult conjResult = quadrilateralPassiveParticipleModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                return conjResult.getFinalResult();
            };

            NounConjugationUI ui = new NounConjugationUI(this.controlPaneContainer, action, genericNounSuffixContainer, passiveParticipleBtn.getText());
            controlPaneContainer.openResult(ui);
        });


        timeAndPlaceBtn.addActionListener(e -> {
            Action action = () -> {
                if (selectionInfo.isTrilateral()) {
                    //here the Trilateral augmented
                    List result = augmentedTrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                    sarf.verb.trilateral.augmented.ConjugationResult conjResult = passiveParticipleModifier.build((AugmentedTrilateralRoot) selectionInfo.getRoot(), selectionInfo.getKov(),
                            selectionInfo.getAugmentationFormulaNo(), result, NamesSelectionUI.this);

                    return conjResult.getFinalResult();
                }

                List result = null;
                if (selectionInfo.isAugmented()) {
                    result = augmentedQuadrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList((AugmentedQuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo());
                } else {
                    result = unaugmentedQuadrilateralPassiveParticipleConjugator.createTimeAndPlaceNounList((UnaugmentedQuadrilateralRoot) selectionInfo.getRoot());
                }

                QuadriConjugationResult conjResult = quadrilateralPassiveParticipleModifier.build((QuadrilateralRoot) selectionInfo.getRoot(), selectionInfo.getAugmentationFormulaNo(), selectionInfo.getKov(), result);

                return conjResult.getFinalResult();
            };

            NounConjugationUI ui = new NounConjugationUI(this.controlPaneContainer, action, genericNounSuffixContainer, timeAndPlaceBtn.getText());
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
        activeParticipleBtn.doClick();
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
