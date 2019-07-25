package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

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
public class Past1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {
    private final List<Substitution> substitutions = new ArrayList<>();

    public Past1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ْ","َC3ْ"));// EX: (أبَدْتُ، استقلتُ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ّ","َC3ّ"));// EX: (أبَتُّ)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3َ","َاC3َ"));// EX: (أبادَ، استقال)
        substitutions.add(new ExpressionInfixSubstitution("ْيَC3ُ","َاC3ُ"));// EX: (أبادُوا، استقالوا)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) && formulaNo == 1) || ((kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Faa || kov == KindOfVerb.Ajwaf_Yaee_Mahmouz_Laam || kov == KindOfVerb.Ajwaf_Yaee) && formulaNo == 9);
    }
}
