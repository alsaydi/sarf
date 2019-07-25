package sarf.ui.controlpane;

import sarf.ui.NounStateSelectionUIListener;
import sarf.noun.INounSuffixContainer;
import sarf.Action;
import javax.swing.*;

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
public interface INounStateSelectionUI {
    void init(Action action, INounSuffixContainer nounSuffixContainer, NounStateSelectionUIListener listener);
    //execute a selected button to refelct the result on the UI
    void selectOne();

    JComponent getComponentUI();
}
