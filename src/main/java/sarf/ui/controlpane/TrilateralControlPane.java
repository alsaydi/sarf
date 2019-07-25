
package sarf.ui.controlpane;

import javax.swing.*;
import sarf.ui.*;
import java.util.*;
import java.awt.GridLayout;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.augmented.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import sarf.*;
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
public class TrilateralControlPane extends JPanel implements IControlPane{
	private static final long serialVersionUID = 1865647471114470824L;
	private final List<ControlButton> unaugmentedButtons = new ArrayList<>(6);
    private final List<ControlButton> augmentedButtons = new ArrayList<>(12);

    private final List<UnaugmentedTrilateralRoot> unaugmentedTrilateralRoots = new ArrayList<>(6);
    private AugmentedTrilateralRoot currentAugmentedTrilateralRoot;

    private final JPanel unaugmentedPanel = new APanel(new GridLayout(1,6));

    public TrilateralControlPane() {
        super(new BorderLayout());

        unaugmentedTrilateralRoots.add(new UnaugmentedTrilateralRoot());
        unaugmentedTrilateralRoots.add(new UnaugmentedTrilateralRoot());
        unaugmentedTrilateralRoots.add(new UnaugmentedTrilateralRoot());
        unaugmentedTrilateralRoots.add(new UnaugmentedTrilateralRoot());
        unaugmentedTrilateralRoots.add(new UnaugmentedTrilateralRoot());
        unaugmentedTrilateralRoots.add(new UnaugmentedTrilateralRoot());
        

        addUnaugmentedButton("فعَل يفعُل");
        addUnaugmentedButton("فعَل يفعِل");
        addUnaugmentedButton("فعَل يفعَل");
        addUnaugmentedButton("فعِل يفعَل");
        addUnaugmentedButton("فعُل يفعُل");
        addUnaugmentedButton("فعِل يفعِل");

        JPanel augmentedPnl1 = new APanel(new GridLayout(1,3));
        addAugmentedButton("أفْعَل يُفْعِل", augmentedPnl1);
        addAugmentedButton("فعَّل يُفعِّل", augmentedPnl1);
        addAugmentedButton("فاعَل يُفاعِل", augmentedPnl1);

        JPanel augmentedPnl2 = new APanel(new GridLayout(1,5));
        addAugmentedButton("انْفَعَل يَنْفَعِل", augmentedPnl2);
        addAugmentedButton("افْتَعَل يَفْتَعِل", augmentedPnl2);
        addAugmentedButton("افْعَلَّ يَفْعَلُّ", augmentedPnl2);
        addAugmentedButton("تَفاعَل يَتَفاعَل", augmentedPnl2);
        addAugmentedButton("تَفَعَّل يَتَفَعَّل", augmentedPnl2);

        JPanel augmentedPnl3 = new APanel(new GridLayout(1,4));
        addAugmentedButton("اسْتَفْعَل يَسْتَفْعِل", augmentedPnl3);
        addAugmentedButton("افْعَوْعَل يَفْعَوْعِل", augmentedPnl3);
        addAugmentedButton("افْعَوَّل يَفْعَوِّل", augmentedPnl3);
        addAugmentedButton("افْعَالَّ يَفْعَالُّ", augmentedPnl3);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        CustomTabbedPane tabPane1 = new CustomTabbedPane();
        tabPane1.add("الأفعال الثلاثية المجردة", unaugmentedPanel);
        container.add(tabPane1);
        container.add(Box.createVerticalStrut(25));

        CustomTabbedPane tabPane2 = new CustomTabbedPane();
        tabPane2.add("الأفعال الثلاثية المزيدة بحرف", augmentedPnl1);
        container.add(tabPane2);
        container.add(Box.createVerticalStrut(25));

        CustomTabbedPane tabPane3 = new CustomTabbedPane();
        tabPane3.add("الأفعال الثلاثية المزيدة بحرفين", augmentedPnl2);
        container.add(tabPane3);
        container.add(Box.createVerticalStrut(25));

        CustomTabbedPane tabPane4 = new CustomTabbedPane();
        tabPane4.add("الأفعال الثلاثية المزيدة بثلاثة أحرف", augmentedPnl3);
        container.add(tabPane4);

        add(container);
        container.setBackground(new Color(247,243,254));
    }

    private int conjugationNoCounter=0;
    private final ActionListener unaugmentedActionListener = new UnaugmentedActionListener();
    private void addUnaugmentedButton(String text) {
        ControlButton btn = new ControlButton(text);
        unaugmentedButtons.add(btn);
        unaugmentedPanel.add(btn);
        btn.getButton().setName(++conjugationNoCounter + "");
        btn.getButton().addActionListener(unaugmentedActionListener);
    }

    private int formulaNoCounter=0;
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

    public void disableAll() {
    	augmentedButtons.forEach(b -> b.setEnabled(false));
    	unaugmentedButtons.forEach(b -> b.setEnabled(false));
    }

    private static List<String> createEmptyList() {
        List<String> result = new ArrayList<String>(13);
        for (int i = 1; i <= 13; i++) {
            result.add("");
        }
        return result;
    }

    public void enableUnaugmentedButton(int index, UnaugmentedTrilateralRoot root) {
        ControlButton unaugmentedButon = unaugmentedButtons.get(index);
        unaugmentedButon.setEnabled(true);
        unaugmentedTrilateralRoots.set(index, root);

        //مع الضمير هو
        //past text formatting
        String pastRootText = sarf.verb.trilateral.unaugmented.active.ActivePastConjugator.getInstance().createVerb(7, root).toString();
        List<String> conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        sarf.verb.trilateral.unaugmented.ConjugationResult conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, ControlPaneContainer.getInstance().getKov(), conjugations, SystemConstants.PAST_TENSE, true);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //present text formatting
        String presentRootText = sarf.verb.trilateral.unaugmented.active.ActivePresentConjugator.getInstance().createNominativeVerb(7, root).toString();
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = sarf.verb.trilateral.unaugmented.modifier.UnaugmentedTrilateralModifier.getInstance().build(root, ControlPaneContainer.getInstance().getKov(), conjugations, SystemConstants.PRESENT_TENSE, true);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        unaugmentedButon.setRootText(pastRootText + " "+ presentRootText);
    }

    public void enableAugmentedButton(int index, AugmentedTrilateralRoot root) {
        ControlButton btn = (ControlButton) augmentedButtons.get(index);
        btn.setEnabled(true);
        currentAugmentedTrilateralRoot = root;

        int formulaNo = index + 1;

        //مع الضمير هو
        //past text formatting
        String pastRootText = sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator.getInstance().createVerb(root, 7, formulaNo).toString();
        List<String> conjugations = createEmptyList();
        conjugations.set(7, pastRootText);
        sarf.verb.trilateral.augmented.ConjugationResult conjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build(root, ControlPaneContainer.getInstance().getKov(), formulaNo, conjugations, SystemConstants.PAST_TENSE, true, null);
        pastRootText = conjResult.getFinalResult().get(7).toString();

        //past text formatting
        String presentRootText = sarf.verb.trilateral.augmented.active.present.AugmentedActivePresentConjugator.getInstance().getNominativeConjugator().createVerb(root, 7, formulaNo).toString();
        conjugations = createEmptyList();
        conjugations.set(7, presentRootText);
        conjResult = sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier.getInstance().build(root, ControlPaneContainer.getInstance().getKov(), formulaNo, conjugations, SystemConstants.PRESENT_TENSE, true, null);
        presentRootText = conjResult.getFinalResult().get(7).toString();

        btn.setRootText(pastRootText + " "+ presentRootText);

    }

    class UnaugmentedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int conjugationNo = Integer.parseInt(((JButton)e.getSource()).getName());

            UnaugmentedTrilateralRoot root = (UnaugmentedTrilateralRoot) unaugmentedTrilateralRoots.get(conjugationNo-1);
            SelectionInfo selectionInfo = new SelectionInfo(root, true, false, ControlPaneContainer.getInstance().getKov());

            ControlButton controlButton = (ControlButton) unaugmentedButtons.get(conjugationNo-1);
            selectionInfo.setFormulaText(controlButton.getFormulaText());
            selectionInfo.setVerbText(controlButton.getVerbText());

            VerbNamesSelectionUI verbNamesSelectionUI = (VerbNamesSelectionUI) ControlPaneContainer.getInstance().openControlPane(VerbNamesSelectionUI.class.getName());
            verbNamesSelectionUI.setInfo(selectionInfo);
            ControlPaneContainer.getInstance().setTransitiveType(root.getTransitive());

            ControlPaneContainer.getInstance().setVerbText(controlButton.getVerbText());
        }
    }

    class AugmentedActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SelectionInfo selectionInfo = new SelectionInfo(currentAugmentedTrilateralRoot, true, true, ControlPaneContainer.getInstance().getKov());
            int formulaNo = Integer.parseInt(((JButton)e.getSource()).getName());
            selectionInfo.setAugmentationFormulaNo(formulaNo);
            ControlButton controlButton = (ControlButton) augmentedButtons.get(formulaNo-1);
            selectionInfo.setFormulaText(controlButton.getFormulaText());
            selectionInfo.setVerbText(controlButton.getVerbText());

            VerbNamesSelectionUI verbNamesSelectionUI = (VerbNamesSelectionUI) ControlPaneContainer.getInstance().openControlPane(VerbNamesSelectionUI.class.getName());
            verbNamesSelectionUI.setInfo(selectionInfo);
            ControlPaneContainer.getInstance().setTransitiveType(currentAugmentedTrilateralRoot.getAugmentationFormula(formulaNo).getTransitive()+"");
            ControlPaneContainer.getInstance().setVerbText(controlButton.getVerbText());
        }
    }
    public void controlPaneOpened() {
    }

    public void controlPaneClosed() {
    }
}
