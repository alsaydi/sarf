package sarf.ui.controlpane;

import javax.swing.*;
import sarf.ui.*;
import java.util.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.unaugmented.*;

import java.awt.BorderLayout;
import sarf.SystemConstants;
import java.awt.Color;

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

    private final List augmentedButons = new ArrayList(12);

    private final ControlButton unaugmentedBtn = new ControlButton("فَعْلَل يُفَعْلِل");
    private AugmentedQuadrilateralRoot currentAugmentedRoot;
    private UnaugmentedQuadrilateralRoot currentUnaugmentedRoot;

    public QuadrilateralControlPane() {
        super(new BorderLayout());

        JPanel unaugmentedPanel = new JPanel(new GridLayout(1, 3));
        unaugmentedPanel.add(Box.createHorizontalBox());
        unaugmentedPanel.add(Box.createHorizontalBox());
        unaugmentedPanel.add(unaugmentedBtn);
        unaugmentedBtn.getButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SelectionInfo selectionInfo = new SelectionInfo(currentUnaugmentedRoot, false, false, ControlPaneContainer.getInstance().getKov());
                selectionInfo.setFormulaText(unaugmentedBtn.getFormulaText());
                selectionInfo.setVerbText(unaugmentedBtn.getVerbText());
                //اتفق على أن يكون الرقم صفر دلالة على المجرد
                selectionInfo.setAugmentationFormulaNo(0);

                VerbNamesSelectionUI verbNamesSelectionUI = (VerbNamesSelectionUI) ControlPaneContainer.getInstance().openControlPane(VerbNamesSelectionUI.class.getName());
                verbNamesSelectionUI.setInfo(selectionInfo);

                ControlPaneContainer.getInstance().setTransitiveType(currentUnaugmentedRoot.getTransitive());
                ControlPaneContainer.getInstance().setVerbText(unaugmentedBtn.getVerbText());
            }
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
        augmentedButons.add(btn);
        containerPnl.add(btn);
        btn.getButton().setName(++formulaNoCounter + "");
        btn.getButton().addActionListener(augmentedActionListener);
    }

    public JComponent getComponent() {
        return this;
    }

    public List createEmptyList() {
        List result = new ArrayList(13);
        for (int i = 1; i <= 13; i++) {
            result.add("");
        }
        return result;
    }


    public void enableUnaugmentedButton(UnaugmentedQuadrilateralRoot root) {
        unaugmentedBtn.setEnabled(true);
        unaugmentedBtn.setRootText("");
        currentUnaugmentedRoot = root;

        //مع الضمير هو
        //past text formatting
        String pastRootText = sarf.verb.quadriliteral.unaugmented.active.ActivePastConjugator.getInstance().createVerb(7, root).toString();
        List conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build(root, 0, ControlPaneContainer.getInstance().getKov(), conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        String presentRootText = sarf.verb.quadriliteral.unaugmented.active.ActivePresentConjugator.getInstance().createNominativeVerb(7, root).toString();
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build(root, 0, ControlPaneContainer.getInstance().getKov(), conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        unaugmentedBtn.setRootText(pastRootText + " "+ presentRootText);
    }

    public void enableAugmentedButton(int index, AugmentedQuadrilateralRoot root) {
        ControlButton btn = (ControlButton) augmentedButons.get(index);
        btn.setEnabled(true);
        btn.setRootText("");
        currentAugmentedRoot = root;

        int formulaNo = index + 1;

        //مع الضمير هو
        //past text formatting
        String pastRootText = sarf.verb.quadriliteral.augmented.active.past.AugmentedActivePastConjugator.getInstance().createVerb(root, 7, formulaNo).toString();
        List conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        sarf.verb.quadriliteral.ConjugationResult conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build(root, formulaNo, ControlPaneContainer.getInstance().getKov(), conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        String presentRootText = sarf.verb.quadriliteral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getNominativeConjugator().createVerb(root, 7, formulaNo).toString();
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = sarf.verb.quadriliteral.modifier.QuadrilateralModifier.getInstance().build(root, formulaNo, ControlPaneContainer.getInstance().getKov(), conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        btn.setRootText(pastRootText + " "+ presentRootText);
    }


    public void disableAll() {
        for (Object augmentedButon : augmentedButons) {
            ControlButton btn = (ControlButton) augmentedButon;
            btn.setEnabled(false);

        }

        unaugmentedBtn.setEnabled(false);
    }

    class AugmentedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SelectionInfo selectionInfo = new SelectionInfo(currentAugmentedRoot, false, true, ControlPaneContainer.getInstance().getKov());
            int formulaNo = Integer.parseInt(((JButton) e.getSource()).getName());
            selectionInfo.setAugmentationFormulaNo(formulaNo);
            ControlButton controlButton = (ControlButton) augmentedButons.get(formulaNo - 1);
            selectionInfo.setFormulaText(controlButton.getFormulaText());
            selectionInfo.setVerbText(controlButton.getVerbText());

            VerbNamesSelectionUI verbNamesSelectionUI = (VerbNamesSelectionUI) ControlPaneContainer.getInstance().openControlPane(VerbNamesSelectionUI.class.getName());
            verbNamesSelectionUI.setInfo(selectionInfo);

            ControlPaneContainer.getInstance().setTransitiveType(currentAugmentedRoot.getAugmentationFormula(formulaNo).getTransitive() + "");
            ControlPaneContainer.getInstance().setVerbText(controlButton.getVerbText());
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
