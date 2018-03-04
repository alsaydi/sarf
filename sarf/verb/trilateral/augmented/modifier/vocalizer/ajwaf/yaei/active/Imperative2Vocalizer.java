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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("óíöC3õ","óÇC3õ"));// EX: (ÇäÊã ÇäåÇáæÇ¡ ÇßÊÇáæÇ)
        substitutions.add(new ExpressionInfixSubstitution("óíöC3ö","óÇC3ö"));// EX: (ÃäÊö ÇäåÇáí¡ ÇßÊÇáí)
        substitutions.add(new ExpressionInfixSubstitution("óíöC3ó","óÇC3ó"));// EX: (ÃäÊãÇ ÇäåÇáÇ¡ ÇßÊÇáÇ)
        substitutions.add(new ExpressionInfixSubstitution("óíöC3ú","óC3ú"));// EX: (ÃäÊä Çäúåóáúäó¡ ÇßúÊóáúäó)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return (kov == 20  && formulaNo == 4) || ((kov == 20 || kov == 18) && formulaNo == 5);
    }
}
