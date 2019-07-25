package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.wawi.active;

import java.util.*;

import sarf.KindOfVerb;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Present1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ُ","ِيC3ُ"));// EX: (هو يُقِيمُ، يستدير)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ِ","ِيC3ِ"));// EX: (أنتِ تُقِيمِينَ، تستديرين)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3َ","ِيC3َ"));// EX: (أنتما تُقِيمان، تستديران)
        substitutions.add(new ExpressionInfixSubstitution("ْوِC3ْ","ِC3ْ"));// EX: (هنّ يُقِمْنَ، يستدرنَ)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 1) || ((kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Wawi_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Wawi) && formulaNo == 9);
    }
}
