package sarf.verb.trilateral.augmented.modifier.vocalizer.ajwaf.yaei.active;

import java.util.*;

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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("úíöC3õ","öíC3õ"));// EX: (ÃäÊã ÃÈíÏæÇ¡ ÇÓÊŞíáæÇ)
        substitutions.add(new ExpressionInfixSubstitution("úíöC3ö","öíC3ö"));// EX: (ÃäÊö ÃÈíÏí¡ ÇÓÊŞíáí)
        substitutions.add(new ExpressionInfixSubstitution("úíöC3ó","öíC3ó"));// EX: (ÃäÊãÇ ÃÈíÏÇ¡ ÇÓÊŞíáÇ)
        substitutions.add(new ExpressionInfixSubstitution("úíöC3ú","öC3ú"));// EX: (ÃäÊä ÃÈöÏúäó¡ ÇÓúÊóŞöáúäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 1) || ((kov == 18 || kov == 19 || kov == 20) && formulaNo == 9);
    }
}
