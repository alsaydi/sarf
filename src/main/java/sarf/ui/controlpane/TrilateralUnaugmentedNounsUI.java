package sarf.ui.controlpane;

import java.awt.*;
import java.util.List;

import javax.swing.*;

import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.noun.trilateral.unaugmented.modifier.activeparticiple.*;
import sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.*;
import sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import sarf.ui.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.ConjugationResult;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.*;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.*;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.*;
import sarf.noun.trilateral.unaugmented.modifier.elative.*;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.*;
import sarf.noun.trilateral.unaugmented.*;
import sarf.noun.trilateral.unaugmented.assimilate.*;
import sarf.noun.trilateral.unaugmented.elative.*;

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
    private final IMainControlPanel controlPaneContainer;
    private final NonStandardExaggerationConjugator nonStandardExaggerationConjugator;
    private final NonStandardInstrumentalConjugator nonStandardInstrumentalConjugator;
    private final ElativeNounConjugator elativeNounConjugator;
    private SelectionInfo selectionInfo;
    private UnaugmentedTrilateralRoot root;

    private final APanel activeParticiplePane = new APanel(new GridLayout(1, 3));
    private final APanel passiveParticiplePane = new APanel(new GridLayout(1, 3));

    private final CustomTabbedPane controlPanels = new CustomTabbedPane();
    private final AssimilateAdjectiveConjugator assimilateAdjectiveConjugator;
    private final TrilateralUnaugmentedNouns trilateralUnaugmentedNouns;
    private final StandardExaggerationConjugator standardExaggerationConjugator;
    private final StandardInstrumentalConjugator standardInstrumentalConjugator;
    private final TimeAndPlaceConjugator timeAndPlaceConjugator;
    private final UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator;
    private final UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator;
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final ExaggerationModifier exaggerationModifier;
    private InstrumentalModifier instrumentalModifier;
    private TimeAndPlaceModifier timeAndPlaceModifier;
    private ElativeModifier elativeModifier;
    private AssimilateModifier assimilateModifier;


    public TrilateralUnaugmentedNounsUI(ControlPaneContainer controlPaneContainer
            , NonStandardExaggerationConjugator nonStandardExaggerationConjugator
            , NonStandardInstrumentalConjugator nonStandardInstrumentalConjugator
            , ElativeNounConjugator elativeNounConjugator
            , AssimilateAdjectiveConjugator assimilateAdjectiveConjugator
            , TrilateralUnaugmentedNouns trilateralUnaugmentedNouns
            , StandardExaggerationConjugator standardExaggerationConjugator
            , StandardInstrumentalConjugator standardInstrumentalConjugator
            , TimeAndPlaceConjugator timeAndPlaceConjugator
            , UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator
            , UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator
            , GenericNounSuffixContainer genericNounSuffixContainer
            , ActiveParticipleModifier activeParticipleModifier
            , PassiveParticipleModifier passiveParticipleModifier
            , ExaggerationModifier exaggerationModifier
            , InstrumentalModifier instrumentalModifier
            , TimeAndPlaceModifier timeAndPlaceModifier
            , ElativeModifier elativeModifier
            , AssimilateModifier assimilateModifier) {

        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.nonStandardExaggerationConjugator = nonStandardExaggerationConjugator;
        this.nonStandardInstrumentalConjugator = nonStandardInstrumentalConjugator;
        this.elativeNounConjugator = elativeNounConjugator;
        this.assimilateAdjectiveConjugator = assimilateAdjectiveConjugator;
        this.trilateralUnaugmentedNouns = trilateralUnaugmentedNouns;
        this.standardExaggerationConjugator = standardExaggerationConjugator;
        this.standardInstrumentalConjugator = standardInstrumentalConjugator;
        this.timeAndPlaceConjugator = timeAndPlaceConjugator;
        this.unaugmentedTrilateralPassiveParticipleConjugator = unaugmentedTrilateralPassiveParticipleConjugator;
        this.unaugmentedTrilateralActiveParticipleConjugator = unaugmentedTrilateralActiveParticipleConjugator;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        this.activeParticipleModifier = activeParticipleModifier;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.exaggerationModifier = exaggerationModifier;
        this.instrumentalModifier = instrumentalModifier;
        this.timeAndPlaceModifier = timeAndPlaceModifier;
        this.elativeModifier = elativeModifier;
        this.assimilateModifier = assimilateModifier;

        //add(new NounStateSelectionUI());
        add(controlPanels);

        controlPanels.addChangeListener(e -> {
            int selectedIndex = controlPanels.getSelectedIndex();
            if (selectedIndex != -1) {
                JPanel selectedPane = ((JPanel) controlPanels.getComponent(selectedIndex));
                if (selectedPane.getComponentCount() > 0) {
                    JToggleButton btn = (JToggleButton) selectedPane.getComponent(0);
                    if (btn.isSelected()) {
                        btn.setSelected(false);
                    }
                    btn.doClick();
                }
            }
        });
    }

    public JComponent getComponent() {
        return this;
    }

    void setInfo(SelectionInfo selectionInfo) {

        this.selectionInfo = selectionInfo;
        root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();

        controlPanels.removeAll();

        controlPanels.add("اسم الفاعل ", activeParticiplePane);
        activeParticiplePane.removeAll();
        JToggleButton activeParticipleBtn = createButton("فَاعِل", unaugmentedTrilateralActiveParticipleConjugator, activeParticipleModifier, "اسم الفاعل");
        activeParticiplePane.add(activeParticipleBtn);
        activeParticipleBtn.doClick();

        controlPanels.add("اسم المفعول ", passiveParticiplePane);
        passiveParticiplePane.removeAll();
        passiveParticiplePane.add(createButton("مَفْعُول", unaugmentedTrilateralPassiveParticipleConjugator, passiveParticipleModifier , "اسم المفعول"));

        JPanel standardExaggerationsPnl = null;
        if (trilateralUnaugmentedNouns.getStandardExaggerations(root) != null && !trilateralUnaugmentedNouns.getStandardExaggerations(root).isEmpty()) {
            standardExaggerationsPnl = createControlPanel(standardExaggerationConjugator, exaggerationModifier, "مبالغة اسم الفاعل");
        }
        JPanel nonStandardExaggerationsPnl = null;
        if (trilateralUnaugmentedNouns.getNonStandardExaggerations(root) != null && !trilateralUnaugmentedNouns.getNonStandardExaggerations(root).isEmpty()) {
            nonStandardExaggerationsPnl = createControlPanel(nonStandardExaggerationConjugator, exaggerationModifier, "مبالغة اسم الفاعل");
        }
        if (standardExaggerationsPnl != null || nonStandardExaggerationsPnl != null) {
            ButtonGroup bg = new ButtonGroup();
            JPanel result = new APanel();
            assert standardExaggerationsPnl != null;
            int buttonsCount = standardExaggerationsPnl.getComponentCount();
            if (nonStandardExaggerationsPnl != null) {
                buttonsCount += nonStandardExaggerationsPnl.getComponentCount();
            }
            result.setLayout(new GridLayout(1, buttonsCount));

            bg.add((JToggleButton) standardExaggerationsPnl.getComponent(0));
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
            controlPanels.add("مبالغة اسم الفاعل", result);
        }


        JPanel standardInstrumentalsPnl = null;
        if (trilateralUnaugmentedNouns.getStandardInstrumentals(root) != null && !trilateralUnaugmentedNouns.getStandardInstrumentals(root).isEmpty()) {
            standardInstrumentalsPnl = createControlPanel(standardInstrumentalConjugator, instrumentalModifier, "اسم الآلة");
        }
        JPanel nonStandardInstrumentalsPnl = null;
        if (trilateralUnaugmentedNouns.getNonStandardInstrumentals(root) != null && !trilateralUnaugmentedNouns.getNonStandardInstrumentals(root).isEmpty()) {
            nonStandardInstrumentalsPnl = createControlPanel(nonStandardInstrumentalConjugator, instrumentalModifier, "اسم الآلة");
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
            controlPanels.add("اسم الآلة ", result);
        }

        if (trilateralUnaugmentedNouns.getTimeAndPlaces(root) != null && !trilateralUnaugmentedNouns.getTimeAndPlaces(root).isEmpty()) {
            controlPanels.add("اسما الزمان والمكان  ", createControlPanel(timeAndPlaceConjugator, timeAndPlaceModifier, "اسم الزمان والمكان"));
        }


        if (trilateralUnaugmentedNouns.getElatives(root) != null && !trilateralUnaugmentedNouns.getElatives(root).isEmpty()) {
            controlPanels.add("اسم التفضيل ", createElativeControlPanel(elativeNounConjugator, elativeModifier, ElativeSuffixContainer.getInstance(), "اسم التفضيل "));
        }

        if (!trilateralUnaugmentedNouns.getAssimilates(root).isEmpty()) {
            controlPanels.add("الصفة المشبهة ", createAssimilateControlPanel(assimilateAdjectiveConjugator, assimilateModifier, "الصفة المشبهة"));
        }

        controlPanels.setMaximumSize(new Dimension(1000, 70));
        controlPanels.setPreferredSize(new Dimension(10000, 70));

        validate();
        repaint();
    }

    private APanel createControlPanel(IUnaugmentedTrilateralNounConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, String title) {
        return createControlPanel(conjugator, modifier, genericNounSuffixContainer, title);
    }

    private APanel createControlPanel(IUnaugmentedTrilateralNounConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, INounSuffixContainer nounSuffixContainer, String title) {
        ButtonGroup bg = new ButtonGroup();

        List formulas = conjugator.getAppliedFormulaList(root);
        APanel panel = new APanel(new GridLayout(1, formulas.size()));
        for (Object o : formulas) {
            String formula = (String) o;
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
        for (Object o : formulas) {
            String formula = (String) o;
            if (formula.equals("أَفْعَل")) {
                JToggleButton button = createButton(formula, conjugator, modifier, AssimilateFormulaCSuffixContainer.getInstance(), title);
                panel.add(button);
                bg.add(button);
            } else if (formula.equals("فَعْلان / فَعْلانة")) {
                JToggleButton button = createButton(formula, conjugator, modifier, AssimilateFormulaE1SuffixContainer.getInstance(), title);
                panel.add(button);
                bg.add(button);
            } else if (formula.equals("فَعْلان / فَعْلَى")) {
                JToggleButton button = createButton(formula, conjugator, modifier, AssimilateFormulaE2SuffixContainer.getInstance(), title);
                panel.add(button);
                bg.add(button);
            } else {
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
        return createButton(formula, conjugator, modifier, genericNounSuffixContainer, title);
    }

    private JToggleButton createButton(final String formula, final IUnaugmentedTrilateralNounConjugator conjugator, final IUnaugmentedTrilateralNounModifier modifier, final INounSuffixContainer nounSuffixContainer, final String title) {
        ToggleRenderedButton button = new ToggleRenderedButton(formula);
        button.addActionListener(e -> {
            sarf.Action sarfAction = () -> {
                List conjugatedNouns = conjugator.createNounList(root, formula);
                ConjugationResult conjResult = modifier.build(root, selectionInfo.getKov(), conjugatedNouns, formula);
                return conjResult.getFinalResult();
            };

            NounConjugationUI ui = new NounConjugationUI(this.controlPaneContainer, sarfAction, nounSuffixContainer, title);
            controlPaneContainer.openResult(ui);
        });

        button.setMaximumSize(new Dimension(30, 30));
        button.setPreferredSize(new Dimension(30, 30));
        return button;
    }

    private APanel createElativeControlPanel(IUnaugmentedTrilateralNounConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, INounSuffixContainer nounSuffixContainer, final String title) {
        ButtonGroup bg = new ButtonGroup();
        List formulas = conjugator.getAppliedFormulaList(root);
        APanel panel = new APanel(new GridLayout(1, formulas.size()));
        for (Object o : formulas) {
            String formula = (String) o;
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
        button.addActionListener(e -> {
            sarf.Action sarfAction = () -> {
                List conjugatedNouns = conjugator.createNounList(root, formula);
                ConjugationResult conjResult = modifier.build(root, selectionInfo.getKov(), conjugatedNouns, formula);
                return conjResult.getFinalResult();
            };

            ElativeNounConjugationUI ui = new ElativeNounConjugationUI(this.controlPaneContainer, sarfAction, title);
            controlPaneContainer.openResult(ui);
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
