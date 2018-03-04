package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import java.util.List;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: ÿ—Ìﬁ… «·›Õ’ «·„‘ —ﬂ… ··√ÃÊ› «·Ì«∆Ì «·„«÷Ì Ê«·„÷«—⁄ Ê«·√„—         </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractAjwafYaeiVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    public AbstractAjwafYaeiVocalizer() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        //  ÿ»Ìﬁ «·ﬁ«‰Ê‰ «·⁄«„ ··›Õ’
        return (conjugationResult.getRoot().getConjugation().equals("2")) &&
                (conjugationResult.getKov() == 18 || conjugationResult.getKov() == 19 || conjugationResult.getKov() == 20);
    }

}
