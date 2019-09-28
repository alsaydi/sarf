package sarf.ui.controlpane;

import javax.swing.*;

import sarf.Word;
import sarf.ui.*;
import java.util.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.augmented.active.present.AugmentedQuadActivePresentConjugator;
import sarf.verb.quadriliteral.modifier.QuadrilateralModifier;
import sarf.verb.quadriliteral.unaugmented.*;

import java.awt.BorderLayout;
import sarf.SystemConstants;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.unaugmented.active.QuadActivePresentConjugator;
import sarf.verb.quadriliteral.unaugmented.active.QuadriActivePastConjugator;
import sarf.ConjugationResult;

import java.awt.Color;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
public class QuadrilateralControlPane extends JPanel implements IControlPane {

    private final List<ControlButton> augmentedButtons = new ArrayList<>(12);

    private final ControlButton unaugmentedBtn = new ControlButton("فَعْلَل يُفَعْلِل");
    private final IMainControlPanel controlPaneContainer;
    private final QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator;
    private final QuadriActivePastConjugator quadriActivePastConjugator;
    private final QuadActivePresentConjugator quadActivePresentConjugator;
    private final QuadrilateralModifier quadrilateralModifier;
    private final AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator;

    private AugmentedQuadrilateralRoot currentAugmentedRoot;
    private UnaugmentedQuadrilateralRoot currentUnaugmentedRoot;

    public QuadrilateralControlPane(ControlPaneContainer controlPaneContainer
            , QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator
            , QuadriActivePastConjugator quadriActivePastConjugator
            , QuadActivePresentConjugator quadActivePresentConjugator
            , QuadrilateralModifier quadrilateralModifier
            , AugmentedQuadActivePresentConjugator augmentedQuadActivePresentConjugator) {
        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.quadrilateralAugmentedActivePastConjugator = quadrilateralAugmentedActivePastConjugator;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.quadActivePresentConjugator = quadActivePresentConjugator;
        this.quadrilateralModifier = quadrilateralModifier;
        this.augmentedQuadActivePresentConjugator = augmentedQuadActivePresentConjugator;

        JPanel unaugmentedPanel = new JPanel(new GridLayout(1, 3));
        unaugmentedPanel.add(Box.createHorizontalBox());
        unaugmentedPanel.add(Box.createHorizontalBox());
        unaugmentedPanel.add(unaugmentedBtn);
        unaugmentedBtn.getButton().addActionListener(e -> {
            SelectionInfo selectionInfo = new SelectionInfo(currentUnaugmentedRoot, false, false, controlPaneContainer.getKov());
            selectionInfo.setFormulaText(unaugmentedBtn.getFormulaText());
            selectionInfo.setVerbText(unaugmentedBtn.getVerbText());
            //اتفق على أن يكون الرقم صفر دلالة على المجرد
            selectionInfo.setAugmentationFormulaNo(0);

            VerbNamesSelectionUI verbNamesSelectionUI = (VerbNamesSelectionUI) controlPaneContainer.openControlPane(VerbNamesSelectionUI.class);
            verbNamesSelectionUI.setInfo(selectionInfo);

            controlPaneContainer.setTransitiveType(currentUnaugmentedRoot.getTransitive());
            controlPaneContainer.setVerbText(unaugmentedBtn.getVerbText());
        });

        JPanel augmentedPnl1 = new JPanel(new GridLayout(1, 3));
        JPanel augmentedPnl2 = new JPanel(new GridLayout(1, 3));

        augmentedPnl1.add(Box.createHorizontalBox());
        augmentedPnl1.add(Box.createHorizontalBox());
        augmentedPnl2.add(Box.createHorizontalBox());

        addAugmentedButton("تَفعْلَل يَتفَعْلَل", augmentedPnl1);
        addAugmentedButton("افْعَنْلَل يَفْعَنْلِل", augmentedPnl2);
        addAugmentedButton("افْعَلَلّ يَفعَلِلّ", augmentedPnl2);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        CustomTabbedPane tabPane1 = new CustomTabbedPane();
        tabPane1.add("الأفعال الرباعية المجردة", unaugmentedPanel);
        container.add(tabPane1);
        container.add(Box.createVerticalStrut(40));

        CustomTabbedPane tabPane2 = new CustomTabbedPane();
        tabPane2.add("الأفعال الرباعية المزيدة بحرف", augmentedPnl1);
        container.add(tabPane2);
        container.add(Box.createVerticalStrut(40));

        CustomTabbedPane tabPane3 = new CustomTabbedPane();
        tabPane3.add("الأفعال الرباعية المزيدة بحرفين", augmentedPnl2);
        container.add(tabPane3);

        add(container);
        container.setBackground(new Color(247,243,254));
    }

    private int formulaNoCounter = 0;
    private final ActionListener augmentedActionListener = new AugmentedActionListener();
    private void addAugmentedButton(String text, JPanel containerPnl) {
        ControlButton btn = new ControlButton(text);
        augmentedButtons.add(btn);
        containerPnl.add(btn);
        btn.getButton().setName(++formulaNoCounter + "");
        btn.getButton().addActionListener(augmentedActionListener);
    }

    public JComponent getComponent() {
        return this;
    }

    public List<Word> createEmptyList() {
        return IntStream.rangeClosed(1, SystemConstants.PRONOUN_RANGE_END)
                .mapToObj(i -> Word.Empty)
                .collect(Collectors.toCollection(() -> new ArrayList<>(SystemConstants.PRONOUN_RANGE_END)));
    }


    public void enableUnaugmentedButton(UnaugmentedQuadrilateralRoot root) {
        unaugmentedBtn.setEnabled(true);
        unaugmentedBtn.setRootText("");
        currentUnaugmentedRoot = root;

        //مع الضمير هو
        //past text formatting
        String pastRootText = quadriActivePastConjugator.createVerb(7, root).toString();
        var conjugations = createEmptyList();
        conjugations.set(7, Word.fromText(pastRootText));
        ConjugationResult conjResult = quadrilateralModifier.build(root, 0, controlPaneContainer.getKov(), conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        String presentRootText = quadActivePresentConjugator.createNominativeVerb(7, root).toString();
        conjugations = createEmptyList();
        conjugations.set(7, Word.fromText(presentRootText));
        conjResult = quadrilateralModifier.build(root, 0, controlPaneContainer.getKov(), conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        unaugmentedBtn.setRootText(pastRootText + " "+ presentRootText);
    }

    public void enableAugmentedButton(int index, AugmentedQuadrilateralRoot root) {
        ControlButton btn = augmentedButtons.get(index);
        btn.setEnabled(true);
        btn.setRootText("");
        currentAugmentedRoot = root;

        int formulaNo = index + 1;

        //مع الضمير هو
        //past text formatting
        String pastRootText = quadrilateralAugmentedActivePastConjugator.createVerb(root, 7, formulaNo).toString();
        List<Word> conjugations = createEmptyList();
        conjugations.set(7, Word.fromText(pastRootText));
        ConjugationResult conjResult = quadrilateralModifier.build(root, formulaNo, controlPaneContainer.getKov(), conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        String presentRootText = augmentedQuadActivePresentConjugator.getNominativeConjugator().createVerb(root, 7, formulaNo).toString();
        conjugations = createEmptyList();
        conjugations.set(7, Word.fromText(presentRootText));
        conjResult = quadrilateralModifier.build(root, formulaNo, controlPaneContainer.getKov(), conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        btn.setRootText(pastRootText + " "+ presentRootText);
    }


    public void disableAll() {
        augmentedButtons.forEach(augmentedButton -> augmentedButton.setEnabled(false));

        unaugmentedBtn.setEnabled(false);
    }

    class AugmentedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SelectionInfo selectionInfo = new SelectionInfo(currentAugmentedRoot, false, true, controlPaneContainer.getKov());
            int formulaNo = Integer.parseInt(((JButton) e.getSource()).getName());
            selectionInfo.setAugmentationFormulaNo(formulaNo);
            ControlButton controlButton = augmentedButtons.get(formulaNo - 1);
            selectionInfo.setFormulaText(controlButton.getFormulaText());
            selectionInfo.setVerbText(controlButton.getVerbText());

            VerbNamesSelectionUI verbNamesSelectionUI = (VerbNamesSelectionUI) controlPaneContainer.openControlPane(VerbNamesSelectionUI.class);
            verbNamesSelectionUI.setInfo(selectionInfo);

            controlPaneContainer.setTransitiveType(currentAugmentedRoot.getAugmentationFormula(formulaNo).getTransitive() + "");
            controlPaneContainer.setVerbText(controlButton.getVerbText());
        }
    }


    private boolean opened = false;
    public void controlPaneOpened() {
        opened = true;
    }


    public void controlPaneClosed() {
        opened = false;
    }


}
