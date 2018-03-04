package sarf.gerund.modifier.trilateral.unaugmented.nomen;

import java.util.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.gerund.modifier.trilateral.unaugmented.nomen.hamza.*;

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
public class Mahmouz {
    private List modifiers = new LinkedList();

    public Mahmouz() {
        modifiers.add(new EinMahmouz());
        modifiers.add(new FaaMahmouz());
        modifiers.add(new LamMahmouz());
    }

    public void apply(ConjugationResult conjResult) {
        Iterator iter = modifiers.iterator();
        while (iter.hasNext()) {
            IUnaugmentedTrilateralNounModificationApplier modifier = (IUnaugmentedTrilateralNounModificationApplier) iter.next();
            if (modifier.isApplied(conjResult)) {
                ((SubstitutionsApplier) modifier).apply(conjResult.getFinalResult(), conjResult.getRoot());
                break;
            }
        }

        //«·√›⁄«· «·À·«ÀÌ… «·„Ã—œ… «·„Â„Ê“… «·›«¡ Ê«·„Â„Ê“… «··«„ (ÊÂÌ: √»√° √À√° √Ã√° √“√° √ﬂ√)
        if (conjResult.getRoot().getC3() == '¡')
            ((SubstitutionsApplier)modifiers.get(2)).apply(conjResult.getFinalResult(), conjResult.getRoot());

    }
}
