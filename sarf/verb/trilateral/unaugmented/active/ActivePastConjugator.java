package sarf.verb.trilateral.unaugmented.active;

import java.util.List;
import java.util.LinkedList;
import sarf.verb.trilateral.unaugmented.*;
import sarf.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description:  ’—Ì› «·√›⁄«· ›Ì «·„«÷Ì    </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class ActivePastConjugator {
    private ActivePastConjugator() {
    }

    private static ActivePastConjugator instance = new ActivePastConjugator();

    public static ActivePastConjugator getInstance() {
        return instance;
    }

    /**
    *  ≈‰‘«¡ «·›⁄· Õ”» «·÷„Ì—
     * @param pronounIndex int
     * @param root UnaugmentedTrilateralRoot
     * @return PastConjugation
     */
    public ActivePastVerb createVerb(int pronounIndex, UnaugmentedTrilateralRoot root) {
        String dpa2 = PastConjugationDataContainer.getInstance().getDpa2(root);
        String lastDpa = PastConjugationDataContainer.getInstance().getLastDpa(pronounIndex);
        String connectedPronoun = PastConjugationDataContainer.getInstance().getConnectedPronoun(pronounIndex);
        return new ActivePastVerb(root, dpa2, lastDpa, connectedPronoun);
    }

    /**
     *  ≈‰‘«¡  ﬁ«∆„…  Õ ÊÌ «·√›⁄«· „⁄ «·÷„«∆— «·À·«À… ⁄‘—
     * @param root UnaugmentedTrilateralRoot
     * @return List
     */
    public List createVerbList(UnaugmentedTrilateralRoot root) {
        List result = new LinkedList();
        for (int i=0; i<13; i++) {
            result.add(createVerb(i, root));
        }

        return result;
    }

}
