package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import sarf.Conjugation;
import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import sarf.verb.trilateral.augmented.ConjugationResult;

/**
 * <p>Title: Sarf Program</p>
 *
 * <p>Description: طريقة الفحص المشتركة للأجوف اليائي الماضي والمضارع والأمر         </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: ALEXO</p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public abstract class AbstractAjwafYaeiVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {
    protected AbstractAjwafYaeiVocalizer() {
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        // تطبيق القانون العام للفحص
        return (conjugationResult.getRoot().getConjugation() == Conjugation.Second) &&
                (conjugationResult.getKov() == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || conjugationResult.getKov() == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || conjugationResult.getKov() == KindOfVerb.Ajwaf_Yaee);
    }
}
