package sarf.verb.trilateral.unaugmented.modifier.vocalizer.ajwaf;

import sarf.Conjugation;
import sarf.verb.trilateral.Substitution.SubstitutionsApplier;
import sarf.verb.trilateral.unaugmented.modifier.IUnaugmentedTrilateralModifier;
import java.util.List;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
        return (conjugationResult.getRoot().getConjugation()== Conjugation.First) &&
                (conjugationResult.getKov() == 15 || conjugationResult.getKov() == 16 || conjugationResult.getKov() == 17);
    }

}
