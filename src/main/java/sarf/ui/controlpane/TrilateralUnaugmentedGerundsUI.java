package sarf.ui.controlpane;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import sarf.gerund.modifier.trilateral.unaugmented.meem.*;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.*;
import sarf.gerund.modifier.trilateral.unaugmented.quality.*;
import sarf.gerund.modifier.trilateral.unaugmented.standard.*;
import sarf.gerund.trilateral.unaugmented.*;
import sarf.gerund.trilateral.unaugmented.meem.*;
import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.ui.*;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
public class TrilateralUnaugmentedGerundsUI extends JPanel implements IControlPane {
	private static final long serialVersionUID = 1L;
    private final IMainControlPanel controlPaneContainer;
    private final MeemGerundConjugator meemGerundConjugator;
    private final TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator;
    private final QualityGerundConjugator qualityGerundConjugator;
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    private final TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator;
    private final StandardTrilateralUnaugmentedSuffixContainer standardTrilateralUnaugmentedSuffixContainer;
    private SelectionInfo selectionInfo;
    private UnaugmentedTrilateralRoot root;
    private final APanel qualityPane = new APanel(new GridLayout(1, 3));
    private final CustomTabbedPane controlPanels = new CustomTabbedPane();

    public TrilateralUnaugmentedGerundsUI(IMainControlPanel controlPaneContainer
            , MeemGerundConjugator meemGerundConjugator
            , TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator
            , QualityGerundConjugator qualityGerundConjugator
            , GenericNounSuffixContainer genericNounSuffixContainer
            , TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator
            , StandardTrilateralUnaugmentedSuffixContainer standardTrilateralUnaugmentedSuffixContainer) {
        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;
        this.meemGerundConjugator = meemGerundConjugator;
        this.trilateralUnaugmentedNomenGerundConjugator = trilateralUnaugmentedNomenGerundConjugator;
        this.qualityGerundConjugator = qualityGerundConjugator;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        this.trilateralUnaugmentedGerundConjugator = trilateralUnaugmentedGerundConjugator;
        this.standardTrilateralUnaugmentedSuffixContainer = standardTrilateralUnaugmentedSuffixContainer;

        //add(new NounStateSelectionUI());
        add(controlPanels);

        controlPanels.addChangeListener(e -> {
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
        });
    }

    public JComponent getComponent() {
        return this;
    }

    void setInfo(SelectionInfo selectionInfo) throws Exception {

        this.selectionInfo = selectionInfo;
        root = (UnaugmentedTrilateralRoot) selectionInfo.getRoot();

        controlPanels.removeAll();

        Collection standardGerundsSymbols = root.getGerundsSymbols();
        if (standardGerundsSymbols != null && !standardGerundsSymbols.isEmpty()) {
            controlPanels.add("المصدر الأصلي ", createControlPanel(trilateralUnaugmentedGerundConjugator, UnaugmentedTrilateralStandardGerundModifier.getInstance(), standardTrilateralUnaugmentedSuffixContainer, "المصدر الأصلي"));
        }

        controlPanels.add("المصدر الميمي ", createControlPanel(this.meemGerundConjugator, TitlateralUnaugmentedMeemModifier.getInstance(), genericNounSuffixContainer, "المصدر الميمي"));

        controlPanels.add("مصدر المرة ", createControlPanel(trilateralUnaugmentedNomenGerundConjugator, TitlateralUnaugmentedNomenModifier.getInstance(), genericNounSuffixContainer, "مصدر المرة"));

        controlPanels.add("مصدر الهيئة ", qualityPane);
        qualityPane.removeAll();
        AbstractButton btn = createButton("فِعْلَة", qualityGerundConjugator, TitlateralUnaugmentedQualityModifier.getInstance(), genericNounSuffixContainer, "مصدر الهيئة");
        qualityPane.add(btn);


        controlPanels.setMaximumSize(new Dimension(1000, 70));
        controlPanels.setPreferredSize(new Dimension(10000, 70));

        validate();
        repaint();
    }

    private APanel createControlPanel(IUnaugmentedTrilateralGerundConjugator conjugator, IUnaugmentedTrilateralNounModifier modifier, INounSuffixContainer nounSuffixContainer, final String title) throws Exception {
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

    private JToggleButton createButton(final String formula, final IUnaugmentedTrilateralGerundConjugator conjugator, final IUnaugmentedTrilateralNounModifier modifier, final INounSuffixContainer nounSuffixContainer, final String title) {
        ToggleRenderedButton button = new ToggleRenderedButton(formula);
        button.addActionListener(e -> {
            sarf.Action sarfAction = () -> {
                List conjugatedNouns = conjugator.createGerundList(root, formula);
                if (modifier == null)
                    return conjugatedNouns;
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


    private boolean opened = false;
    public void controlPaneOpened() {
        opened = true;
    }


    public void controlPaneClosed() {
        opened = false;
    }
}
