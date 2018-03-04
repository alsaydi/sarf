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
public class Present2Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present2Vocalizer() {
        substitutions.add(new ExpressionInfixSubstitution("унцC3х","у«C3х"));// EX: (еж нуде«б° нуя «б)
        substitutions.add(new ExpressionInfixSubstitution("унцC3ц","у«C3ц"));// EX: (√д ц  де«бнд°  я «бнд)
        substitutions.add(new ExpressionInfixSubstitution("унцC3у","у«C3у"));// EX: (√д г«  де«б«д°  я «б«д)
        substitutions.add(new ExpressionInfixSubstitution("унцC3ъ","уC3ъ"));// EX: (едш нудъеубъду° нуяъ убъду)

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
