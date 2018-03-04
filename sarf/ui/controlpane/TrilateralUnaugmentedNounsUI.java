package sarf.ui.controlpane;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.*;
import sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.*;
import sarf.ui.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.*;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.*;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.*;
import sarf.noun.trilateral.unaugmented.modifier.elative.*;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.*;
import sarf.noun.trilateral.unaugmented.*;
import sarf.noun.trilateral.unaugmented.assimilate.*;
import sarf.noun.trilateral.unaugmented.elative.*;
import javax.swing.event.*;

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
public class TrilateralUnaugmentedNounsUI extends JPanel implements IControlPane {
    private SelectionInfo selectionInfo;
    private UnaugmentedTrilateralRoot root;

    APanel activeParticiplePane = new APanel(new GridLayout(1, 3));
    APanel passiveParticiplePane = new APanel(new GridLayout(1, 3));

    CustomTabbedPane controlPanels = new CustomTabbedPane();


    public TrilateralUnaugmentedNounsUI() {
        super(new BorderLayout());

        //add(new NounStateSelectionUI());
        add(controlPanels);

        controlPanels.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = controlPanels.getSelectedIndex();
                if (selectedIndex != -1) {
                    JPanel selectedPane = ((JPanel)controlPanels.getComponent(selectedIndex));
                    if (selectedPane.getComponentCount()> 0) {
                        JToggleButton btn = (JToggleButton) selectedPane.getComponent(0);
                        if (btn.isSelected()) {
                            btn.setSelected(false);
                        }
                        btn.doClick();
                    }
                }
            }
        });
    }

    public JComponent getComponent() {
        return this;
    }

    public void setInfo(SelectionInfo selectionInfo) {

        this.selectionInfo = selectionInfo;
        root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();

        controlPanels.removeAll();
        TrilateralUnaugmentedNouns nounsObject = new TrilateralUnaugmentedNouns(root);

        controlPanels.add("«”„ «·›«⁄· ", activeParticiplePane);
        activeParticiplePane.removeAll();
        JToggleButton activeParticipleBtn = createButton("›Û«⁄ˆ·", UnaugmentedTrilateralActiveParticipleConjugator.getInstance(), ActiveParticipleModifier.getInstance(), "«”„ «·›«⁄·");
        activeParticiplePane.add(activeParticipleBtn);
        activeParticipleBtn.doClick();

        controlPanels.add("«”„ «·„›⁄Ê· ", passiveParticiplePane);
        passiveParticiplePane.removeAll();
        passiveParticiplePane.add(createButton("„Û›˙⁄ıÊ·", UnaugmentedTrilateralPassiveParticipleConjugator.getInstance(), PassiveParticipleModifier.getInstance(), "«”„ «·„›⁄Ê·"));

        JPanel standardExaggerationsPnl = null;
        if (nounsObject.getStandardExaggerations() != null && !nounsObject.getStandardExaggerations().isEmpty()) {
            standardExaggerationsPnl = createControlPanel(sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator.getInstance(), ExaggerationModifier.getInstance(), "„»«·€… «”„ «·›«⁄·");
        }
        JPanel nonStandardExaggerationsPnl = null;
        if (nounsObject.getNonStandardExaggerations() != null && !nounsObject.getNonStandardExaggerations().isEmpty()) {
            nonStandardExaggerationsPnl = createControlPanel(sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator.getInstance(), ExaggerationModifier.getInstance(), "„»«·€… «”„ «·›«⁄·");
        }
        if (standardExaggerationsPnl != null || nonStandardExaggerationsPnl != null) {
            ButtonGroup bg = new ButtonGroup();
            JPanel result = new APanel();
            int buttonsCount = standardExaggerationsPnl.getComponentCount();
            if (nonStandardExaggerationsPnl != null) {
                buttonsCount += nonStandardExaggerationsPnl.getComponentCount();
            }
            result.setLayout(new GridLayout(1, buttonsCount));

            bg.add((JToggleButton)standardExaggerationsPnl.getComponent(0));
            result.add(standardExaggerationsPnl.getComponent(0));
            if (nonStandardExaggerationsPnl != null) {
                int count = nonStandardExaggerationsPnl.getComponentCount();
                for (int i = 0; i < count; i++) {
                    //the component count will decrease so you have to get the 0
                    JToggleButton btn = (JToggleButton) nonStandardExaggerationsPnl.getComponent(0);
                    result.add(btn);
                    bg.add(btn);
                }
            }
            controlPanels.add("„»«·€… «”„ «·›«⁄·", result);
        }



        JPanel standardInstrumentalsPnl = null;
        if (nounsObject.getStandardInstrumentals() != null && !nounsObject.getStandardInstrumentals().isEmpty()) {
            standardInstrumentalsPnl = createControlPanel(sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator.getInstance(), InstrumentalModifier.getInstance(), "«”„ «·¬·…");
        }
        JPanel nonStandardInstrumentalsPnl = null;
        if (nounsObject.getNonStandardInstrumentals() != null && !nounsObject.getNonStandardInstrumentals().isEmpty()) {
            nonStandardInstrumentalsPnl = createControlPanel(sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator.getInstance(), InstrumentalModifier.getInstance(), "«”„ «·¬·…");
        }
        if (standardInstrumentalsPnl != null || nonStandardInstrumentalsPnl != null) {
            JPanel result = new APanel();
            ButtonGroup bg = new ButtonGroup();
            int buttonsCount = 0;

            if (standardInstrumentalsPnl != null) {
                buttonsCount = standardInstrumentalsPnl.getComponentCount();
            }
            if (nonStandardInstrumentalsPnl != null) {
                buttonsCount += nonStandardInstrumentalsPnl.getComponentCount();
            }

            result.setLayout(new GridLayout(1, buttonsCount));

            if (standardInstrumentalsPnl != null) {
                int count = standardInstrumentalsPnl.getComponentCount();
                for (int i = 0; i < count; i++) {
                    JToggleButton btn = (JToggleButton) standardInstrumentalsPnl.getComponent(0);
                    result.add(btn);
                    bg.add(btn);
                }
            }

            if (nonStandardInstrumentalsPnl != null) {
                int count = nonStandardInstrumentalsPnl.getComponentCount();
                for (int i = 0; i < count; i++) {
                    JToggleButton btn = (JToggleButton) nonStandardInstrumentalsPnl.getComponent(0);
                    result.add(btn);
                    bg.add(btn);
                }
            }
            controlPanels.add("«”„ «·¬·… ", result);
        }

        if (nounsObject.getTimeAndPlaces() != null && !nounsObject.getTimeAndPlaces().isEmpty()) {
            controlPanels.add("«”„« «·“„«‰ Ê«·„ﬂ«‰  ", createControlPanel(sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator.getInstance(), TimeAndPlaceModifier.getInstance(), "«”„ «·“„«‰ Ê«·„ﬂ«‰"));
        }


        if (nounsObject.getElatives() != null && !nounsObject.getElatives().isEmpty()) {
            controlPanels.add("«”„ «· ›÷Ì· ", createElativeControlPanel(sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator.getInstance(), ElativeModifier.getInstance(), ElativeSuffixContainer.getInstance(), "«”„ «· ›÷Ì· "));
        }

        if (nounsObject.getAssimilates() != null && !nounsObject.getAssimilates().isEmpty()) {
            controlPanels.add("«·’›… «·„‘»Â… ", createAssimilateControlPanel(sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator.getInstance(), AssimilateModifier.getInstance(), "«·’›… «·„‘»Â…"));
        }

        controlPanels.setMaximumSize(new Dimension(1000, 70));
        controlPanels.setPreferredSize(new Dimension(10000, 70));

        validate();
        repaint();
    }

    private APanel createControlPanel(IUnaugmentedTrilateralNounConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, String title) {
        return createControlPanel(conjugator, modifier, GenericNounSuffixContainer.getInstance(), title);
    }

    private APanel createControlPanel(IUnaugmentedTrilateralNounConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, INounSuffixContainer nounSuffixContainer, String title) {
        ButtonGroup bg = new ButtonGroup();

        List formulas = conjugator.getAppliedFormulaList(root);
        APanel panel = new APanel(new GridLayout(1, formulas.size()));
        Iterator iter = formulas.iterator();
        while (iter.hasNext()) {
            String formula = (String) iter.next();
            JToggleButton button = createButton(formula, conjugator, modifier, nounSuffixContainer, title);
            panel.add(button);
            bg.add(button);
        }
        panel.setMaximumSize(new Dimension(300, 30));
        panel.setPreferredSize(new Dimension(300, 30));
        return panel;
    }

    private APanel createAssimilateControlPanel(IUnaugmentedTrilateralNounConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, String title) {
        ButtonGroup bg = new ButtonGroup();

        List formulas = conjugator.getAppliedFormulaList(root);
        APanel panel = new APanel(new GridLayout(1, formulas.size()));
        Iterator iter = formulas.iterator();
        while (iter.hasNext()) {
            String formula = (String) iter.next();
            if (formula.equals("√Û›˙⁄Û·")) {
                JToggleButton button = createButton(formula, conjugator, modifier, AssimilateFormulaCSuffixContainer.getInstance(), title);
                panel.add(button);
                bg.add(button);
            }
            else if (formula.equals("›Û⁄˙·«‰ / ›Û⁄˙·«‰…")) {
                JToggleButton button = createButton(formula, conjugator, modifier, AssimilateFormulaE1SuffixContainer.getInstance(), title);
                panel.add(button);
                bg.add(button);
            }
            else if (formula.equals("›Û⁄˙·«‰ / ›Û⁄˙·ÛÏ")) {
                JToggleButton button = createButton(formula, conjugator, modifier, AssimilateFormulaE2SuffixContainer.getInstance(), title);
                panel.add(button);
                bg.add(button);
            }
            else {
                JToggleButton button = createButton(formula, conjugator, modifier, title);
                panel.add(button);
                bg.add(button);
            }
        }
        panel.setMaximumSize(new Dimension(300, 30));
        panel.setPreferredSize(new Dimension(300, 30));
        return panel;
    }

    private JToggleButton createButton(final String formula, final IUnaugmentedTrilateralNounConjugator conjugator, final IUnaugmentedTrilateralNounModifier modifier, String title) {
        return createButton(formula, conjugator, modifier, GenericNounSuffixContainer.getInstance(), title);
    }

    private JToggleButton createButton(final String formula, final IUnaugmentedTrilateralNounConjugator conjugator, final IUnaugmentedTrilateralNounModifier modifier, final INounSuffixContainer nounSuffixContainer, final String title) {
        ToggleRenderedButton button = new ToggleRenderedButton(formula);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sarf.Action sarfAction = new sarf.Action() {
                    public List execute() {
                        List conjugatedNouns = conjugator.createNounList(root, formula);
                        ConjugationResult conjResult = modifier.build(root, selectionInfo.getKov(), conjugatedNouns, formula);
                        return conjResult.getFinalResult();
                    }
                };

                NounConjugationUI ui = new NounConjugationUI(sarfAction, nounSuffixContainer, title);
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        button.setMaximumSize(new Dimension(30, 30));
        button.setPreferredSize(new Dimension(30, 30));
        return button;
    }

    private APanel createElativeControlPanel(IUnaugmentedTrilateralNounConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, INounSuffixContainer nounSuffixContainer, final String title) {
        ButtonGroup bg = new ButtonGroup();
        List formulas = conjugator.getAppliedFormulaList(root);
        APanel panel = new APanel(new GridLayout(1, formulas.size()));
        Iterator iter = formulas.iterator();
        while (iter.hasNext()) {
            String formula = (String) iter.next();
            JToggleButton button = createElativeButton(formula, conjugator, modifier, nounSuffixContainer, title);
            panel.add(button);
            bg.add(button);
        }
        panel.setMaximumSize(new Dimension(300, 30));
        panel.setPreferredSize(new Dimension(300, 30));
        return panel;
    }


    private JToggleButton createElativeButton(final String formula, final IUnaugmentedTrilateralNounConjugator conjugator, final IUnaugmentedTrilateralNounModifier modifier, final INounSuffixContainer nounSuffixContainer, final String title) {
        ToggleRenderedButton button = new ToggleRenderedButton(formula);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sarf.Action sarfAction = new sarf.Action() {
                    public List execute() {
                        List conjugatedNouns = conjugator.createNounList(root, formula);
                        ConjugationResult conjResult = modifier.build(root, selectionInfo.getKov(), conjugatedNouns, formula);
                        return conjResult.getFinalResult();
                    }
                };

                ElativeNounConjugationUI ui = new ElativeNounConjugationUI(sarfAction, title);
                ControlPaneContainer.getInstance().openResult(ui);
            }
        });

        button.setMaximumSize(new Dimension(30, 30));
        button.setPreferredSize(new Dimension(30, 30));
        return button;
    }


    private boolean opened = false;
    public void controlPaneOpened() {
        opened = true;
    }


    public void controlPaneClosed() {
        opened = false;
    }
}
