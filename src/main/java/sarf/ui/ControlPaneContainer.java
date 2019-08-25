package sarf.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.prefs.*;

import javax.inject.Inject;
import javax.swing.*;

import sarf.*;
import sarf.gerund.modifier.quadrilateral.QuadrilateralStandardModifier;
import sarf.gerund.modifier.trilateral.augmented.standard.TrilateralAugmentedStandardModifier;
import sarf.gerund.modifier.trilateral.unaugmented.meem.TrilateralUnaugmentedMeemModifier;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.TrilateralUnaugmentedNomenModifier;
import sarf.gerund.modifier.trilateral.unaugmented.quality.TrilateralUnaugmentedQualityModifier;
import sarf.gerund.modifier.trilateral.unaugmented.standard.UnaugmentedTrilateralStandardGerundModifier;
import sarf.gerund.quadrilateral.augmented.QuadrilateralAugmentedGerundConjugator;
import sarf.gerund.quadrilateral.augmented.nomen.QuadrilateralAugmentedNomenGerundConjugator;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedGerundConjugator;
import sarf.gerund.quadrilateral.unaugmented.QuadrilateralUnaugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.augmented.TrilateralAugmentedGerundConjugator;
import sarf.gerund.trilateral.augmented.nomen.TrilateralAugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.unaugmented.QualityGerundConjugator;
import sarf.gerund.trilateral.unaugmented.StandardTrilateralUnaugmentedSuffixContainer;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedGerundConjugator;
import sarf.gerund.trilateral.unaugmented.TrilateralUnaugmentedNomenGerundConjugator;
import sarf.gerund.trilateral.unaugmented.meem.MeemGerundConjugator;
import sarf.kov.*;
import sarf.noun.GenericNounSuffixContainer;
import sarf.noun.TrilateralUnaugmentedNouns;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.augmented.AugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralActiveParticipleConjugator;
import sarf.noun.quadriliteral.unaugmented.UnaugmentedQuadrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.augmented.AugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.augmented.modifier.activeparticiple.ActiveParticipleModifier;
import sarf.noun.trilateral.augmented.modifier.passiveparticiple.PassiveParticipleModifier;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralActiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.UnaugmentedTrilateralPassiveParticipleConjugator;
import sarf.noun.trilateral.unaugmented.assimilate.AssimilateAdjectiveConjugator;
import sarf.noun.trilateral.unaugmented.elative.ElativeNounConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.NonStandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.exaggeration.StandardExaggerationConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.NonStandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.instrumental.StandardInstrumentalConjugator;
import sarf.noun.trilateral.unaugmented.modifier.assimilate.AssimilateModifier;
import sarf.noun.trilateral.unaugmented.modifier.elative.ElativeModifier;
import sarf.noun.trilateral.unaugmented.modifier.exaggeration.ExaggerationModifier;
import sarf.noun.trilateral.unaugmented.modifier.instrumental.InstrumentalModifier;
import sarf.noun.trilateral.unaugmented.modifier.timeandplace.TimeAndPlaceModifier;
import sarf.noun.trilateral.unaugmented.timeandplace.TimeAndPlaceConjugator;
import sarf.ui.controlpane.*;
import sarf.verb.quadriliteral.augmented.*;
import sarf.verb.quadriliteral.augmented.active.past.QuadrilateralAugmentedActivePastConjugator;
import sarf.verb.quadriliteral.augmented.passive.past.QuadriAugmentedPassivePastConjugator;
import sarf.verb.quadriliteral.unaugmented.*;
import sarf.verb.quadriliteral.unaugmented.active.QuadriActivePastConjugator;
import sarf.verb.quadriliteral.unaugmented.passive.QuadriUnaugmentedPassivePastConjugator;
import sarf.verb.trilateral.augmented.*;
import sarf.verb.trilateral.augmented.active.past.AugmentedActivePastConjugator;
import sarf.verb.trilateral.augmented.modifier.AugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.passive.past.AugmentedPassivePastConjugator;
import sarf.verb.trilateral.unaugmented.*;
import sarf.verb.trilateral.unaugmented.active.ActivePastConjugator;
import sarf.verb.trilateral.unaugmented.passive.PassivePastConjugator;

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
public class ControlPaneContainer extends JPanel implements IMainControlPanel {
	private static final long serialVersionUID = 1L;
	private final Map<Class, IControlPane> controlPaneMap = new HashMap<>();
    private final JButton backBtn = new RenderedButton("عودة");
    private final JTextField rootFld = new JTextField(5);
    private final JPanel container = new JPanel(new BorderLayout());

    private final JPanel resultPane = new JPanel(new BorderLayout());
    private final SarfDictionary sarfDictionary;
    private final Validator validator;
    private final KovRulesManager kovRulesManager;
    private final MeemGerundConjugator meemGerundConjugator;
    private Preferences pref;

    //store the opened panels so you can go back and forward
    private final List<IControlPane> panelCashSet = new LinkedList<>();
    //used a s a reference to the current panel for the back-forward
    private IControlPane currentControlPane;
    private final JTextField kovFld = new JTextField(14);
    private final JTextField transitiveTypeFld = new JTextField(8);
    private KindOfVerb kov;
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenuItem backMnuItm = new JMenuItem("عودة");
    private final JMenuItem saveMnuItm = new JMenuItem("حفظ الجدول");
    private final JMenuItem showIntroMnuItm = new JCheckBoxMenuItem("إظهار الشاشة التقديمية");

    private final JTextField verbTxtFld = new JTextField(8);

    private String kovText;
    private final NonStandardExaggerationConjugator nonStandardExaggerationConjugator;
    private final NonStandardInstrumentalConjugator nonStandardInstrumentalConjugator;
    private final ElativeNounConjugator elativeNounConjugator;
    private final AssimilateAdjectiveConjugator assimilateAdjectiveConjugator;
    private final TrilateralAugmentedGerundConjugator trilateralAugmentedGerundConjugator;
    private final TrilateralUnaugmentedNouns trilateralUnaugmentedNouns;
    private final StandardExaggerationConjugator standardExaggerationConjugator;
    private final StandardInstrumentalConjugator standardInstrumentalConjugator;
    private final TimeAndPlaceConjugator timeAndPlaceConjugator;
    private final TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier;
    private final PassiveParticipleModifier passiveParticipleModifier;
    private final ActiveParticipleModifier activeParticipleModifier;
    private final AugmentedTrilateralModifier augmentedTrilateralModifier;
    private final TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator;
    private final QualityGerundConjugator qualityGerundConjugator;
    private final GenericNounSuffixContainer genericNounSuffixContainer;
    private final AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator;
    private final AugmentedQuadrilateralActiveParticipleConjugator augmentedQuadrilateralActiveParticipleConjugator;
    private final UnaugmentedQuadrilateralActiveParticipleConjugator unaugmentedQuadrilateralActiveParticipleConjugator;
    private final AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator;
    private final AugmentedQuadrilateralPassiveParticipleConjugator augmentedQuadrilateralPassiveParticipleConjugator;
    private final UnaugmentedQuadrilateralPassiveParticipleConjugator unaugmentedQuadrilateralPassiveParticipleConjugator;
    private final QuadrilateralUnaugmentedGerundConjugator quadrilateralUnaugmentedGerundConjugator;
    private final TrilateralAugmentedNomenGerundConjugator trilateralAugmentedNomenGerundConjugator;
    private final QuadrilateralUnaugmentedNomenGerundConjugator quadrilateralUnaugmentedNomenGerundConjugator;
    private final UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator;
    private final UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator;
    private final QuadrilateralAugmentedGerundConjugator quadrilateralAugmentedGerundConjugator;
    private final QuadrilateralAugmentedNomenGerundConjugator quadrilateralAugmentedNomenGerundConjugator;
    private final TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator;
    private final StandardTrilateralUnaugmentedSuffixContainer standardTrilateralUnaugmentedSuffixContainer;
    private final sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier trilateralUnaugmentedActiveParticipleModifier;
    private final sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier trilateralUnaugmentedPassiveParticipleModifier;
    private final QuadrilateralStandardModifier quadrilateralStandardModifier;
    private final sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier quadrilateralPassiveParticipleModifier;
    private final UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier;
    private final TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier;
    private final TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier;
    private final TrilateralUnaugmentedQualityModifier trilateralUnaugmentedQualityModifier;
    private final sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier quadrilateralActiveParticipleModifier;
    private final ExaggerationModifier exaggerationModifier;
    private final InstrumentalModifier instrumentalModifier;
    private final TimeAndPlaceModifier timeAndPlaceModifier;
    private final ElativeModifier elativeModifier;
    private final AssimilateModifier assimilateModifier;
    private final AugmentedActivePastConjugator augmentedActivePastConjugator;
    private final AugmentedPassivePastConjugator augmentedPassivePastConjugator;
    private final QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator;
    private final QuadriAugmentedPassivePastConjugator quadriAugmentedPassivePastConjugator;
    private final QuadriActivePastConjugator quadriActivePastConjugator;
    private final ActivePastConjugator unaugmentedTriActivePastConjugator;
    private final PassivePastConjugator passivePastConjugator;
    private final QuadriUnaugmentedPassivePastConjugator quadriUnaugmentedPassivePastConjugator;
    private final ActivePastConjugator activePastConjugator;

    @Inject
    public ControlPaneContainer(SarfDictionary sarfDictionary
            , Validator validator
            , KovRulesManager kovRulesManager
            , MeemGerundConjugator meemGerundConjugator
            , NonStandardExaggerationConjugator nonStandardExaggerationConjugator
            , NonStandardInstrumentalConjugator nonStandardInstrumentalConjugator
            , ElativeNounConjugator elativeNounConjugator
            , AssimilateAdjectiveConjugator assimilateAdjectiveConjugator
            , TrilateralAugmentedGerundConjugator trilateralAugmentedGerundConjugator
            , TrilateralUnaugmentedNouns trilateralUnaugmentedNouns
            , StandardExaggerationConjugator standardExaggerationConjugator
            , StandardInstrumentalConjugator standardInstrumentalConjugator
            , TimeAndPlaceConjugator timeAndPlaceConjugator
            , TrilateralAugmentedStandardModifier trilateralAugmentedStandardModifier
            , PassiveParticipleModifier passiveParticipleModifier
            , ActiveParticipleModifier activeParticipleModifier
            , AugmentedTrilateralModifier augmentedTrilateralModifier
            , TrilateralUnaugmentedNomenGerundConjugator trilateralUnaugmentedNomenGerundConjugator
            , QualityGerundConjugator qualityGerundConjugator
            , GenericNounSuffixContainer genericNounSuffixContainer
            , AugmentedTrilateralActiveParticipleConjugator augmentedTrilateralActiveParticipleConjugator
            , AugmentedQuadrilateralActiveParticipleConjugator augmentedQuadrilateralActiveParticipleConjugator
            , UnaugmentedQuadrilateralActiveParticipleConjugator unaugmentedQuadrilateralActiveParticipleConjugator
            , AugmentedTrilateralPassiveParticipleConjugator augmentedTrilateralPassiveParticipleConjugator
            , AugmentedQuadrilateralPassiveParticipleConjugator augmentedQuadrilateralPassiveParticipleConjugator
            , UnaugmentedQuadrilateralPassiveParticipleConjugator unaugmentedQuadrilateralPassiveParticipleConjugator
            , QuadrilateralUnaugmentedGerundConjugator quadrilateralUnaugmentedGerundConjugator
            , TrilateralAugmentedNomenGerundConjugator trilateralAugmentedNomenGerundConjugator
            , QuadrilateralUnaugmentedNomenGerundConjugator quadrilateralUnaugmentedNomenGerundConjugator
            , UnaugmentedTrilateralPassiveParticipleConjugator unaugmentedTrilateralPassiveParticipleConjugator
            , UnaugmentedTrilateralActiveParticipleConjugator unaugmentedTrilateralActiveParticipleConjugator
            , QuadrilateralAugmentedGerundConjugator quadrilateralAugmentedGerundConjugator
            , QuadrilateralAugmentedNomenGerundConjugator quadrilateralAugmentedNomenGerundConjugator
            , TrilateralUnaugmentedGerundConjugator trilateralUnaugmentedGerundConjugator
            , StandardTrilateralUnaugmentedSuffixContainer standardTrilateralUnaugmentedSuffixContainer
            , sarf.noun.trilateral.unaugmented.modifier.activeparticiple.ActiveParticipleModifier trilateralUnaugmentedActiveParticipleModifier
            , sarf.noun.trilateral.unaugmented.modifier.passiveparticiple.PassiveParticipleModifier trilateralUnaugmentedPassiveParticipleModifier
            , QuadrilateralStandardModifier quadrilateralStandardModifier
            , sarf.noun.quadriliteral.modifier.passiveparticiple.PassiveParticipleModifier quadrilateralPassiveParticipleModifier
            , UnaugmentedTrilateralStandardGerundModifier unaugmentedTrilateralStandardGerundModifier
            , TrilateralUnaugmentedMeemModifier trilateralUnaugmentedMeemModifier
            , TrilateralUnaugmentedNomenModifier trilateralUnaugmentedNomenModifier
            , TrilateralUnaugmentedQualityModifier trilateralUnaugmentedQualityModifier
            , sarf.noun.quadriliteral.modifier.activeparticiple.ActiveParticipleModifier quadrilateralActiveParticipleModifier
            , ExaggerationModifier exaggerationModifier
            , InstrumentalModifier instrumentalModifier
            , TimeAndPlaceModifier timeAndPlaceModifier
            , ElativeModifier elativeModifier
            , AssimilateModifier assimilateModifier
            , AugmentedActivePastConjugator augmentedActivePastConjugator
            , AugmentedPassivePastConjugator augmentedPassivePastConjugator
            , QuadrilateralAugmentedActivePastConjugator quadrilateralAugmentedActivePastConjugator
            , QuadriAugmentedPassivePastConjugator quadriAugmentedPassivePastConjugator
            , QuadriActivePastConjugator quadriActivePastConjugator
            , ActivePastConjugator unaugmentedTriActivePastConjugator
            , PassivePastConjugator passivePastConjugator
            , QuadriUnaugmentedPassivePastConjugator quadriUnaugmentedPassivePastConjugator
            , ActivePastConjugator activePastConjugator) {
        
        super(new BorderLayout());
        this.meemGerundConjugator = meemGerundConjugator;
        this.nonStandardExaggerationConjugator = nonStandardExaggerationConjugator;
        this.nonStandardInstrumentalConjugator = nonStandardInstrumentalConjugator;
        this.elativeNounConjugator = elativeNounConjugator;
        this.assimilateAdjectiveConjugator = assimilateAdjectiveConjugator;
        this.trilateralAugmentedGerundConjugator = trilateralAugmentedGerundConjugator;
        this.trilateralUnaugmentedNouns = trilateralUnaugmentedNouns;
        this.standardExaggerationConjugator = standardExaggerationConjugator;
        this.standardInstrumentalConjugator = standardInstrumentalConjugator;
        this.timeAndPlaceConjugator = timeAndPlaceConjugator;
        this.trilateralAugmentedStandardModifier = trilateralAugmentedStandardModifier;
        this.passiveParticipleModifier = passiveParticipleModifier;
        this.activeParticipleModifier = activeParticipleModifier;
        this.augmentedTrilateralModifier = augmentedTrilateralModifier;
        this.trilateralUnaugmentedNomenGerundConjugator = trilateralUnaugmentedNomenGerundConjugator;
        this.qualityGerundConjugator = qualityGerundConjugator;
        this.genericNounSuffixContainer = genericNounSuffixContainer;
        this.augmentedTrilateralActiveParticipleConjugator = augmentedTrilateralActiveParticipleConjugator;
        this.augmentedQuadrilateralActiveParticipleConjugator = augmentedQuadrilateralActiveParticipleConjugator;
        this.unaugmentedQuadrilateralActiveParticipleConjugator = unaugmentedQuadrilateralActiveParticipleConjugator;
        this.augmentedTrilateralPassiveParticipleConjugator = augmentedTrilateralPassiveParticipleConjugator;
        this.augmentedQuadrilateralPassiveParticipleConjugator = augmentedQuadrilateralPassiveParticipleConjugator;
        this.unaugmentedQuadrilateralPassiveParticipleConjugator = unaugmentedQuadrilateralPassiveParticipleConjugator;
        this.quadrilateralUnaugmentedGerundConjugator = quadrilateralUnaugmentedGerundConjugator;
        this.trilateralAugmentedNomenGerundConjugator = trilateralAugmentedNomenGerundConjugator;
        this.quadrilateralUnaugmentedNomenGerundConjugator = quadrilateralUnaugmentedNomenGerundConjugator;
        this.unaugmentedTrilateralPassiveParticipleConjugator = unaugmentedTrilateralPassiveParticipleConjugator;
        this.unaugmentedTrilateralActiveParticipleConjugator = unaugmentedTrilateralActiveParticipleConjugator;
        this.quadrilateralAugmentedGerundConjugator = quadrilateralAugmentedGerundConjugator;
        this.quadrilateralAugmentedNomenGerundConjugator = quadrilateralAugmentedNomenGerundConjugator;
        this.trilateralUnaugmentedGerundConjugator = trilateralUnaugmentedGerundConjugator;
        this.standardTrilateralUnaugmentedSuffixContainer = standardTrilateralUnaugmentedSuffixContainer;
        this.trilateralUnaugmentedActiveParticipleModifier = trilateralUnaugmentedActiveParticipleModifier;
        this.trilateralUnaugmentedPassiveParticipleModifier = trilateralUnaugmentedPassiveParticipleModifier;
        this.quadrilateralStandardModifier = quadrilateralStandardModifier;
        this.quadrilateralPassiveParticipleModifier = quadrilateralPassiveParticipleModifier;
        this.unaugmentedTrilateralStandardGerundModifier = unaugmentedTrilateralStandardGerundModifier;
        this.trilateralUnaugmentedMeemModifier = trilateralUnaugmentedMeemModifier;
        this.trilateralUnaugmentedNomenModifier = trilateralUnaugmentedNomenModifier;
        this.trilateralUnaugmentedQualityModifier = trilateralUnaugmentedQualityModifier;
        this.quadrilateralActiveParticipleModifier = quadrilateralActiveParticipleModifier;
        this.exaggerationModifier = exaggerationModifier;
        this.instrumentalModifier = instrumentalModifier;
        this.timeAndPlaceModifier = timeAndPlaceModifier;
        this.elativeModifier = elativeModifier;
        this.assimilateModifier = assimilateModifier;
        this.augmentedActivePastConjugator = augmentedActivePastConjugator;
        this.augmentedPassivePastConjugator = augmentedPassivePastConjugator;
        this.quadrilateralAugmentedActivePastConjugator = quadrilateralAugmentedActivePastConjugator;
        this.quadriAugmentedPassivePastConjugator = quadriAugmentedPassivePastConjugator;
        this.quadriActivePastConjugator = quadriActivePastConjugator;
        this.unaugmentedTriActivePastConjugator = unaugmentedTriActivePastConjugator;
        this.passivePastConjugator = passivePastConjugator;
        this.quadriUnaugmentedPassivePastConjugator = quadriUnaugmentedPassivePastConjugator;
        this.activePastConjugator = activePastConjugator;

        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.sarfDictionary = sarfDictionary;
        this.validator = validator;
        this.kovRulesManager = kovRulesManager;

        JMenu helpMainMenu = new JMenu("مساعدة");
        JMenu fileMainMenu = new JMenu("ملف");

        menuBar.add(fileMainMenu);
        menuBar.add(helpMainMenu);

        helpMainMenu.setFont(RenderedButton.FONT);
        fileMainMenu.setFont(RenderedButton.FONT);
        //menu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JMenuItem help3MnuItm = new JMenuItem("تعريف بالنظام");
        helpMainMenu.add(help3MnuItm);
        help3MnuItm.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL .\\documents\\progspec.htm");
            }
            catch (IOException ex) {
                ex.printStackTrace();
                ShowMessageBox(ex);
            }
        });
        help3MnuItm.setFont(RenderedButton.FONT);
        help3MnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JMenuItem help2MnuItm = new JMenuItem("دليل الاستعمال");
        helpMainMenu.add(help2MnuItm);
        help2MnuItm.addActionListener(e -> {
            try {
                //for all win
                Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL .\\documents\\userguide.doc");
                //for winnt and xp just
//                    Runtime.getRuntime().exec("cmd /c .\\documents\\userguide.doc");
            }
            catch (IOException ex) {
                ex.printStackTrace();
                ShowMessageBox(ex);
            }
        });
        help2MnuItm.setFont(RenderedButton.FONT);
        help2MnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JMenuItem help1MnuItm = new JMenuItem("قواعد النحو والصرف");
        helpMainMenu.add(help1MnuItm);
        help1MnuItm.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL .\\documents\\rules.doc");
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        help1MnuItm.setFont(RenderedButton.FONT);
        help1MnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fileMainMenu.add(saveMnuItm);
        saveMnuItm.setEnabled(false);
        saveMnuItm.addActionListener(e -> {
            IHtmlContentSaver htmlContentSaverComponent = (IHtmlContentSaver) currentResultPane;
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setSelectedFile(new File(htmlContentSaverComponent.getSavedFileNameTitle()));
            if (fileChooser.showSaveDialog(ControlPaneContainer.this) == JFileChooser.APPROVE_OPTION) {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath();
                int index = fileName.indexOf(".");
                fileName = index == -1 ? fileName : fileName.substring(0, index);

                File file = new File(fileName + ".html");
                htmlContentSaverComponent.saveToHtml(file);
            }
        });
        saveMnuItm.setFont(RenderedButton.FONT);
        //saveMnuItm.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fileMainMenu.add(showIntroMnuItm);
        showIntroMnuItm.addActionListener(e -> pref.put("HideIntro", (!showIntroMnuItm.isSelected()) + ""));
        showIntroMnuItm.setFont(RenderedButton.FONT);
        showIntroMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JMenuItem aboutMnuItm = new JMenuItem("حول البرنامج");
        helpMainMenu.add(aboutMnuItm);
        aboutMnuItm.addActionListener(e -> {
            AboutDialog dialog = new AboutDialog();
            dialog.setVisible(true);
        });
        aboutMnuItm.setFont(RenderedButton.FONT);
        aboutMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        fileMainMenu.add(backMnuItm);
        backMnuItm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        backMnuItm.addActionListener(e -> showPreviousPane());
        backMnuItm.setFont(RenderedButton.FONT);
        backMnuItm.setEnabled(false);
        backMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JMenuItem exitMnuItm = new JMenuItem("خروج");
        fileMainMenu.add(exitMnuItm);
        exitMnuItm.addActionListener(e -> System.exit(0));
        exitMnuItm.setFont(RenderedButton.FONT);
        exitMnuItm.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        Font font = new Font("Traditional Arabic", Font.BOLD, 22);
        Font font2 = new Font("Simplified Arabic", Font.PLAIN, 18);

        verbTxtFld.setFont(font);
        verbTxtFld.setForeground(Color.BLUE);
        verbTxtFld.setEditable(false);
        verbTxtFld.setHorizontalAlignment(JTextField.CENTER);

        JPanel topPane = new APanel();

        kovFld.setEditable(false);
        transitiveTypeFld.setEditable(false);

        JLabel lbl = new JLabel("نوع الفعل المجرد:");
        JLabel transitiveLbl = new JLabel("التعدية واللزوم:");

        lbl.setFont(RenderedButton.FONT);
        transitiveLbl.setFont(RenderedButton.FONT);

        transitiveTypeFld.setFont(RenderedButton.FONT);

        rootFld.setFont(font2);
        transitiveTypeFld.setFont(RenderedButton.FONT);
        kovFld.setFont(RenderedButton.FONT);

        Font font3 = new Font("Simplified Arabic", Font.BOLD, 14);
        backBtn.setFont(font3);

        kovFld.setHorizontalAlignment(SwingConstants.RIGHT);
        transitiveTypeFld.setHorizontalAlignment(SwingConstants.RIGHT);
        rootFld.setHorizontalAlignment(SwingConstants.RIGHT);
        Insets insets = new Insets(0, 0, 0, 10);
        rootFld.setMargin(insets);

        JButton startBtn = new RenderedButton("أدخل جذراً ثلاثياً أو رباعياً");
        topPane.add(startBtn);
        topPane.add(rootFld);
        topPane.add(Box.createHorizontalStrut(5));
        topPane.add(verbTxtFld);
        topPane.add(Box.createHorizontalStrut(5));
        topPane.add(lbl);
        topPane.add(kovFld);
        topPane.add(Box.createHorizontalStrut(5));
        topPane.add(transitiveLbl);
        topPane.add(transitiveTypeFld);
        topPane.add(Box.createHorizontalStrut(25));
        topPane.add(backBtn);

        verbTxtFld.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                rootFld.requestFocus();
            }

            public void focusLost(FocusEvent e) {
            }
        });

        backBtn.setBackground(new Color(255, 233, 233));

        rootFld.addActionListener(e -> {
            try {
                rootEntered();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        JPanel controlPane = new JPanel(new BorderLayout());
        add(controlPane, BorderLayout.NORTH);
        add(resultPane);

        controlPane.add(topPane, BorderLayout.NORTH);
        controlPane.add(container);

        backBtn.setEnabled(false);
        backBtn.addActionListener(e -> showPreviousPane());

        startBtn.addActionListener(e -> {
            try {
                rootEntered();
            } catch (Exception e1) {
                e1.printStackTrace();
                ShowMessageBox(e1);
            }
        });
    }

    private void rootEntered() throws Exception {
        reset();
        String root = rootFld.getText();

        if (!validator.checkLength(root)) {
            container.removeAll();
            displayErrorMessage("عدد أحرف الجذر يجب أن يكون ثلاثة أو أربعة");
            return;
        }
        if (validator.checkStartedWithAlef(root)) {
            container.removeAll();
            displayErrorMessage("لا يمكن أن يبدأ الجذر بحرف الألف      ");
            return;
        }
        if (validator.checkAlefMamdoda(root)) {
            container.removeAll();
            displayErrorMessage("الحرف ( آ ) ليس من حروف المعجم    ");
            return;
        }
        if (validator.checkTashkil(root)) {
            container.removeAll();
            displayErrorMessage("علامات الشكل (الحركات) ليست من حروف المعجم    ");
            return;
        }

        //رد الهمزة إلى أصلها
        root = validator.correctHamza(root);
        //لكي لا تظهر رسالة التصحيح التلقائي للهمزة
        rootFld.setText(root);

        if (!validator.checkArabicLetters(root)) {
            container.removeAll();
            displayErrorMessage("خطأ في أحد أحرف الجذر");
            return;
        }

        if (root.length() == 3) {
            processTrilateral(root);
        }
        else
        if (rootFld.getText().length() == 4) {
            processQuadrilateral(root);
        }
        else {
            container.removeAll();
            JOptionPane.showMessageDialog(ControlPaneContainer.this, "الرجاء ادخال جذر ثلاثي أو رباعي     ", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processTrilateral(String root) throws Exception {
        List<String> alefAlternatives = validator.getTrilateralAlefAlternatives(root);
        if (alefAlternatives.isEmpty()) {
            //لا يوجد احتمالات للألف
            AugmentedTrilateralRoot augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(root);
            List<UnaugmentedTrilateralRoot> unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(root);
            if (augmentedRoot == null && unaugmentedList.isEmpty()) {
                container.removeAll();
                validate();
                repaint();
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
            }
            else {
                displayTrilateral(root, augmentedRoot, unaugmentedList);
            }
        }
        else {
            //تجريب بدائل الألف
            List<String> rootTextList = new LinkedList<>();
            List<AugmentedTrilateralRoot> augmentedList = new LinkedList<>();
            List<List<UnaugmentedTrilateralRoot>> unaugmentedLists = new LinkedList<>();

            for (String alternativeRoot : alefAlternatives) {
                AugmentedTrilateralRoot augmentedRoot = sarfDictionary.getAugmentedTrilateralRoot(alternativeRoot);
                List<UnaugmentedTrilateralRoot> unaugmentedList = sarfDictionary.getUnaugmentedTrilateralRoots(alternativeRoot);

                if (augmentedRoot != null || !unaugmentedList.isEmpty()) {
                    rootTextList.add(alternativeRoot);
                    augmentedList.add(augmentedRoot);
                    unaugmentedLists.add(unaugmentedList);
                }
            }
            //فحص اذا نجح احتمال أو أكثر
            if (rootTextList.isEmpty()) {
                //لم ينجح أي بديل
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
                return;
            }

            //اذا كان هناك بديل واحد فقط فيتم عرض معلوماته فوراً
            int index = 0;
            if (rootTextList.size() > 1) {
                //عرض أكثر من احتمال للمستخدم ليتم انتقاء واحد
                String dialogTitle = "يوجد أكثر من جذر   ";
                String dialogInput = "اختر أحد الجذرين  ";
                int selectionResult = JOptionPane.showOptionDialog(this, dialogInput, dialogTitle, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rootTextList.toArray(),
                        rootTextList.get(0));
                /*for (int i = 0; i < rootTextList.size(); i++) {
                    if (selectedValue.equals(rootTextList.get(i))) {
                        index = i;
                        break;
                    }
                                 }*/
                index = selectionResult == JOptionPane.YES_OPTION ? 0 : 1;
            }
            //عرض معلومات الجذر المنتقى
            AugmentedTrilateralRoot augmentedRoot = augmentedList.get(index);
            List<UnaugmentedTrilateralRoot> unaugmentedList = unaugmentedLists.get(index);
            String newRoot = rootTextList.get(index);
            //حتى لا يتم عرض رسالة نتبيهية
            //إلا في حالة جذر واحد
            if (rootTextList.size() > 1) {
                rootFld.setText(newRoot);
            }
            displayTrilateral(newRoot, augmentedRoot, unaugmentedList);
        }

    }


    private void displayTrilateral(String rootText, AugmentedTrilateralRoot augmentedRoot, List<UnaugmentedTrilateralRoot> unaugmentedRoots) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);

        TrilateralKovRule rule = kovRulesManager.getTrilateralKovRule(c1, c2, c3);
        kovText = rule.getDesc();
        kov = rule.getKov();

        //عرض رسالة تنبيهية اذا تم تصحيح تلقائي
        if (!rootText.equals(rootFld.getText())) {
            String msg = "لقد تم تصحيح الجذر المدخل إلى       ";
            msg += rootText;
            //JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);

            //عرضه بعد التعديل اذا جرى تعديل
            rootFld.setText(rootText);
        }

        TrilateralControlPane trilateralControlPane = (TrilateralControlPane) openControlPane(TrilateralControlPane.class);
        trilateralControlPane.disableAll();

        if (augmentedRoot != null) {
            for (AugmentationFormula formula : augmentedRoot.getAugmentationList()) {
                trilateralControlPane.enableAugmentedButton(formula.getFormulaNo() - 1, augmentedRoot);
            }
        }

        for (UnaugmentedTrilateralRoot root : unaugmentedRoots) {
            trilateralControlPane.enableUnaugmentedButton(root.getConjugation().getValue() - 1, root);
        }
    }

    private void processQuadrilateral(String root) throws Exception {
        //فحص إذا كان الفعل يبتدأ بهمزة
        if (root.charAt(0) == 'ء') {
            displayErrorMessage("لا يوجد رباعي يبتدئ بهمزة");
            return;
        }

        List<String> alefAlternatives = validator.getQuadrilateralAlefAlternatives(root);
        if (alefAlternatives.isEmpty()) {
            //لا يوجد احتمالات للألف
            AugmentedQuadrilateralRoot augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(root);
            UnaugmentedQuadrilateralRoot unaugmentedRoot = sarfDictionary.getUnaugmentedQuadrilateralRoot(root);
            if (augmentedRoot == null && unaugmentedRoot == null) {
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
            }
            else {
                displayQuadrilateral(root, augmentedRoot, unaugmentedRoot);
            }

        }
        else {
            //تجريب بدائل الألف
            List<String> rootTextList = new LinkedList<>();
            List<AugmentedQuadrilateralRoot> augmentedList = new LinkedList<>();
            List<UnaugmentedQuadrilateralRoot> unaugmentedList = new LinkedList<>();

            for (String alternativeRoot : alefAlternatives) {
                AugmentedQuadrilateralRoot augmentedRoot = sarfDictionary.getAugmentedQuadrilateralRoot(alternativeRoot);
                UnaugmentedQuadrilateralRoot unaugmentedRoot = sarfDictionary.getUnaugmentedQuadrilateralRoot(alternativeRoot);
                if (augmentedRoot != null || unaugmentedRoot != null) {
                    rootTextList.add(alternativeRoot);
                    augmentedList.add(augmentedRoot);
                    unaugmentedList.add(unaugmentedRoot);
                }
            }
            //فحص اذا نجح احتمال أو أكثر
            if (rootTextList.isEmpty()) {
                //لم ينجح أي بديل
                displayErrorMessage("لم يرد هذا الجذر في قاعدة المعطيات      ");
                return;
            }

            //اذا كان هناك بديل واحد فقط فيتم عرض معلوماته فوراً
            int index = 0;
            if (rootTextList.size() > 1) {
                //عرض أكثر من احتمال للمستخدم ليتم انتقاء واحد
                String dialogTitle = "يوجد أكثر من جذر   ";
                String dialogInput = "اختر أحد الجذرين  ";
                int selectionResult = JOptionPane.showOptionDialog(this, dialogInput, dialogTitle, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, rootTextList.toArray(), rootTextList.get(0));
                index = selectionResult == JOptionPane.YES_OPTION ? 0 : 1;
            }
            //عرض معلومات الجذر المنتقى
            AugmentedQuadrilateralRoot augmentedRoot = augmentedList.get(index);
            UnaugmentedQuadrilateralRoot unaugmentedRoot = unaugmentedList.get(index);

            String newRoot = rootTextList.get(index).toString();
            //حتى لا يتم عرض رسالة نتبيهية
            //إلا في حالة جذر واحد
            if (rootTextList.size() > 1) {
                rootFld.setText(newRoot);
            }
            displayQuadrilateral(newRoot, augmentedRoot, unaugmentedRoot);
        }
    }


    private void displayQuadrilateral(String rootText, AugmentedQuadrilateralRoot augmentedRoot, UnaugmentedQuadrilateralRoot unaugmentedRoot) {
        char c1 = rootText.charAt(0);
        char c2 = rootText.charAt(1);
        char c3 = rootText.charAt(2);
        char c4 = rootText.charAt(3);

        QuadrilateralKovRule rule = kovRulesManager.getQuadrilateralKovRule(c1, c2, c3, c4);
        kovText = rule.getDesc();
        kov = rule.getKov();

        //عرض رسالة تنبيهية اذا تم تصحيح تلقائي
        if (!rootText.equals(rootFld.getText())) {
            String msg = "لقد تم تصحيح الجذر المدخل إلى       ";
            msg += rootText;
            //JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);

            //عرضه بعد التعديل اذا جرى تعديل
            rootFld.setText(rootText);
        }

        QuadrilateralControlPane quadrilateralControlPane = (QuadrilateralControlPane) openControlPane(QuadrilateralControlPane.class);
        quadrilateralControlPane.disableAll();

        if (unaugmentedRoot != null) {
            quadrilateralControlPane.enableUnaugmentedButton(unaugmentedRoot);
        }

        if (augmentedRoot != null) {
            for (Object o : augmentedRoot.getAugmentationList()) {
                AugmentationFormula formula = (AugmentationFormula) o;
                quadrilateralControlPane.enableAugmentedButton(formula.getFormulaNo() - 1, augmentedRoot);
            }
        }
    }


    private void displayErrorMessage(String msg) {
        resultPane.removeAll();
        resultPane.validate();
        resultPane.repaint();
        saveMnuItm.setEnabled(false);
        container.removeAll();

        validate();
        repaint();

        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.ERROR_MESSAGE);
    }

    public KindOfVerb getKov() {
        return kov;
    }

    JMenuBar getMenuBar() {
        return menuBar;
    }

    JTextField getRootFld() {
        return rootFld;
    }

    JTextField getVerbTxtFld() {
        return verbTxtFld;
    }
    public String getVerbText(){
        return verbTxtFld.getText();
    }

    private IControlPane getControlPane(Class controlPanelClass) {
        IControlPane controlPane = controlPaneMap.get(controlPanelClass);
        if (controlPane == null) {
            try {
//                var constructor = Class.forName(className).getConstructors()[0];
//                controlPane = (IControlPane) constructor.newInstance(this);
                controlPane = createControlPanel(controlPanelClass);
                controlPaneMap.put(controlPanelClass, controlPane);
            }
            catch (Exception ex) {
                ex.printStackTrace();
                ShowMessageBox(ex);
            }
        }
        return controlPane;
    }

    private IControlPane createControlPanel(Class type){
        if (TrilateralControlPane.class.equals(type)) {
            return new TrilateralControlPane(this, augmentedTrilateralModifier, augmentedActivePastConjugator, unaugmentedTriActivePastConjugator);
        }
        else if(QuadrilateralControlPane.class.equals(type)){
            return new QuadrilateralControlPane(this, quadrilateralAugmentedActivePastConjugator, quadriActivePastConjugator);
        }
        else if(VerbNamesSelectionUI.class.equals(type)){
            return new VerbNamesSelectionUI(this);
        }
        else if(GerundSelectionUI.class.equals(type)){
            return  new GerundSelectionUI(this
                    , trilateralAugmentedGerundConjugator
                    , trilateralAugmentedStandardModifier
                    , passiveParticipleModifier
                    , quadrilateralUnaugmentedGerundConjugator
                    , trilateralAugmentedNomenGerundConjugator
                    , genericNounSuffixContainer
                    , quadrilateralUnaugmentedNomenGerundConjugator
                    , augmentedTrilateralPassiveParticipleConjugator
                    , augmentedQuadrilateralPassiveParticipleConjugator
                    , unaugmentedQuadrilateralPassiveParticipleConjugator
                    , quadrilateralAugmentedGerundConjugator
                    , quadrilateralAugmentedNomenGerundConjugator
                    , quadrilateralStandardModifier
                    , quadrilateralPassiveParticipleModifier);
        }
        else if(TrilateralUnaugmentedGerundsUI.class.equals(type)){
            return new TrilateralUnaugmentedGerundsUI(this
                    , meemGerundConjugator
                    , trilateralUnaugmentedNomenGerundConjugator
                    , qualityGerundConjugator
                    , genericNounSuffixContainer
                    , trilateralUnaugmentedGerundConjugator
                    , standardTrilateralUnaugmentedSuffixContainer
                    , unaugmentedTrilateralStandardGerundModifier
                    , trilateralUnaugmentedMeemModifier
                    , trilateralUnaugmentedNomenModifier
                    , trilateralUnaugmentedQualityModifier);
        }
        else if(NamesSelectionUI.class.equals(type)){
            return new NamesSelectionUI(this
                    , activeParticipleModifier
                    , passiveParticipleModifier
                    , genericNounSuffixContainer
                    , augmentedTrilateralActiveParticipleConjugator
                    , augmentedQuadrilateralActiveParticipleConjugator
                    , unaugmentedQuadrilateralActiveParticipleConjugator
                    , augmentedTrilateralPassiveParticipleConjugator
                    , augmentedQuadrilateralPassiveParticipleConjugator
                    , unaugmentedQuadrilateralPassiveParticipleConjugator, quadrilateralActiveParticipleModifier, quadrilateralPassiveParticipleModifier);
        }
        else if(TrilateralUnaugmentedNounsUI.class.equals(type)){
            return new TrilateralUnaugmentedNounsUI(this
                    , nonStandardExaggerationConjugator
                    , nonStandardInstrumentalConjugator
                    , elativeNounConjugator
                    , assimilateAdjectiveConjugator
                    , trilateralUnaugmentedNouns
                    , standardExaggerationConjugator
                    , standardInstrumentalConjugator
                    , timeAndPlaceConjugator
                    , unaugmentedTrilateralPassiveParticipleConjugator
                    , unaugmentedTrilateralActiveParticipleConjugator
                    , genericNounSuffixContainer
                    , trilateralUnaugmentedActiveParticipleModifier
                    , trilateralUnaugmentedPassiveParticipleModifier
                    , exaggerationModifier
                    , instrumentalModifier
                    , timeAndPlaceModifier
                    , elativeModifier
                    , assimilateModifier);
        }
        else if(PassiveVerbSelectionUI.class.equals(type)){
            return new PassiveVerbSelectionUI(this
                    , augmentedTrilateralModifier
                    , augmentedPassivePastConjugator
                    , quadriAugmentedPassivePastConjugator
                    , passivePastConjugator
                    , quadriUnaugmentedPassivePastConjugator);
        }
        else if(ActiveVerbSelectionUI.class.equals(type)){
            return new ActiveVerbSelectionUI(this
                    , activePastConjugator
                    , augmentedTrilateralModifier
                    , augmentedActivePastConjugator
                    , quadrilateralAugmentedActivePastConjugator
                    , quadriActivePastConjugator);
        }
        return null;
    }

    public IControlPane openControlPane(Class panelClass) {
        resultPane.removeAll();
        resultPane.validate();
        resultPane.repaint();
        saveMnuItm.setEnabled(false);

        validate();
        repaint();

        container.removeAll();
        IControlPane controlPane = getControlPane(panelClass);
        container.add(controlPane.getComponent());
        validate();
        repaint();

        if (!panelCashSet.contains(controlPane)) {
            panelCashSet.add(controlPane);
        }
        if (panelCashSet.indexOf(controlPane) > 0) {
            backBtn.setEnabled(true);
            backMnuItm.setEnabled(true);
        }
        controlPane.controlPaneOpened();
        if (currentControlPane != null) {
            currentControlPane.controlPaneClosed();
        }

        currentControlPane = controlPane;
        return controlPane;
    }

    private void showPreviousPane() {
        if (currentControlPane == null) {
            return;
        }
        int index = panelCashSet.indexOf(currentControlPane);
        if (index > 0) {
            IControlPane controlPane = panelCashSet.get(index - 1);
            //first remove it from the cash so the flow will not get effected
            panelCashSet.remove(index);

            openControlPane(controlPane.getClass());
            index--;

            if (index == 0) {
                backBtn.setEnabled(false);
                backMnuItm.setEnabled(false);

                transitiveTypeFld.setText("");
                setVerbText("");
                kovFld.setText("");
            }
        }

    }

    private void reset() {
        panelCashSet.clear();
        currentControlPane = null;
        backBtn.setEnabled(false);
        saveMnuItm.setEnabled(false);
        kovFld.setText("");
        transitiveTypeFld.setText("");
        setVerbText("");

        resultPane.removeAll();
        resultPane.validate();
        resultPane.repaint();
        container.removeAll();

        validate();
        repaint();

    }

    private JComponent currentResultPane = null;
    public void openResult(JComponent resultComponent) {
        resultPane.removeAll();
        resultPane.add(resultComponent);
        resultPane.validate();
        resultPane.repaint();

        validate();
        repaint();

        currentResultPane = resultComponent;
        saveMnuItm.setEnabled(true);
    }

    public void setTransitiveType(String type) {
        if (type.equals("م")) {
            transitiveTypeFld.setText("متعد");
        }
        else if (type.equals("ل")) {
            transitiveTypeFld.setText("لازم");
        }
        else {
            transitiveTypeFld.setText("لازم ومتعد ");
        }
    }

    public void setVerbText(String text) {
        verbTxtFld.setText(text);
        kovFld.setText(kovText);
    }

    void setPref(Preferences pref) {
        this.pref = pref;
        String result = pref.get("HideIntro", null);
        showIntroMnuItm.setSelected(result.equals("false"));
    }
    
    private void ShowMessageBox(Object message) {
    	JOptionPane.showMessageDialog(ControlPaneContainer.this, message, "البرنامج واجه خطأ", JOptionPane.ERROR_MESSAGE);
    }
}
