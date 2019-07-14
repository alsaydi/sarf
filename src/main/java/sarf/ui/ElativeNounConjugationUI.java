package sarf.ui;

import sarf.noun.INounSuffixContainer;
import sarf.Action;
import sarf.ui.controlpane.NounStateSelectionUI;
import sarf.ui.controlpane.INounStateSelectionUI;
import sarf.ui.controlpane.*;

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
    public ElativeNounConjugationUI(sarf.Action sarfAction, String title) {
        super(sarfAction, null, title);
    }

    protected INounStateSelectionUI createNounStateSelectionUI(Action action, INounSuffixContainer nounSuffixContainer, NounStateSelectionUIListener listener) {
        ElativeNounStateSelectionUI nounStateSelectionUI = new ElativeNounStateSelectionUI();
        nounStateSelectionUI.init(action, nounSuffixContainer,this);
        return nounStateSelectionUI;
    }

}
