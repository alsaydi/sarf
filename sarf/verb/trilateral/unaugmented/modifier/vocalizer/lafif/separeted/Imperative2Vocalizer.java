package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.separeted;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;

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
public class Imperative2Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative2Vocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("ÇæúC2öíú", "C2ö")); // EX: (Şö¡ áö)
        substitutions.add(new ExpressionInfixSubstitution("ÇæúC2öíö","C2ö"));// EX: (ÃäÊö Şöí¡ áöí)
        substitutions.add(new ExpressionInfixSubstitution("ÇæúC2öíú", "C2öí")); // EX: (ÃäÊä Şöíäó¡ áöíäó)
        substitutions.add(new ExpressionInfixSubstitution("ÇæúC2öíõ", "C2õ")); // EX: (ÃäÊã ŞõæÇ¡ áõæÇ)
        substitutions.add(new ExpressionInfixSubstitution("ÇæúC2öíó", "C2öíó")); // EX: (ÃäÊãÇ ŞöíÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 29 || kov == 30) && (noc == 2)) ||
                (kov == 30 && noc == 6);
    }
}
