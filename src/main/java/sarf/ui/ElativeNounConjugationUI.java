package sarf.ui;

import sarf.Action;
import sarf.noun.INounSuffixContainer;
import sarf.ui.controlpane.ElativeNounStateSelectionUI;
import sarf.ui.controlpane.INounStateSelectionUI;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: it is different containing 4 noun state buttons </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ElativeNounConjugationUI extends NounConjugationUI {
    public ElativeNounConjugationUI(IMainControlPanel controlPaneContainer, sarf.Action sarfAction, String title) {
        super(controlPaneContainer, sarfAction, null, title);
    }

    @Override
    protected INounStateSelectionUI createNounStateSelectionUI(Action action, INounSuffixContainer nounSuffixContainer, NounStateSelectionUIListener listener) {
        ElativeNounStateSelectionUI nounStateSelectionUI = new ElativeNounStateSelectionUI();
        nounStateSelectionUI.init(action, nounSuffixContainer, listener);
        return nounStateSelectionUI;
    }
}
