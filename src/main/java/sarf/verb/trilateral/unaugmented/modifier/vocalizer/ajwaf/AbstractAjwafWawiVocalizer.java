package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import sarf.Conjugation;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import sarf.ConjugationResult;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;

import static sarf.KindOfVerb.*;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: طريقة الفحص المشتركة للأجوف الواوي الماضي والمضارع والأمر         </p>
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
        // تطبيق القانون العام للفحص
        return (conjugationResult.getRoot().getConjugation() == Conjugation.First) &&
                (conjugationResult.getKov() == Ajwaf_Wawi_Mahmouz_Faa
                        || conjugationResult.getKov() == Ajwaf_Wawi_Mahmouz_Laam
                        || conjugationResult.getKov() == Ajwaf_Wawi);
    }
}
