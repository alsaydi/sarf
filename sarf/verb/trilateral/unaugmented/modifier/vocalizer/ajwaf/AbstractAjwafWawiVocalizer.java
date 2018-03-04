package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import java.util.List;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ÿ—Ìﬁ… «·›Õ’ «·„‘ —ﬂ… ··√ÃÊ› «·Ê«ÊÌ «·„«÷Ì Ê«·„÷«—⁄ Ê«·√„—         </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractAjwafWawiVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractAjwafWawiVocalizer() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        //  ÿ»Ìﬁ «·ﬁ«‰Ê‰ «·⁄«„ ··›Õ’
        return (conjugationResult.getRoot().getConjugation().equals("1")) &&
                (conjugationResult.getKov() == 15 || conjugationResult.getKov() == 16 || conjugationResult.getKov() == 17);
    }

}
