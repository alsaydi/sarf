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
public class ActivePresent2Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ActivePresent2Vocalizer() {
        substitutions.add(new ExpressionSuffixSubstitution("óæúC2öíõ", "óC2öí")); // EX: (íóŞöí¡ íóáöí)
        substitutions.add(new ExpressionSuffixSubstitution("óæúC2öíú", "óC2ö")); // EX: (áã íóŞö¡ íóáö)
        substitutions.add(new ExpressionInfixSubstitution("óæúC2öíöä", "óC2öä")); // EX: (ÃäÊö ÊóŞöäøó¡ Êóáöäøó)
        substitutions.add(new ExpressionInfixSubstitution("óæúC2öíö", "óC2ö")); // EX: (ÃäÊö ÊóŞöíäó¡ Êóáöíäó)
        substitutions.add(new ExpressionInfixSubstitution("óæúC2öíú", "óC2öí")); // EX: (ÃäÊä ÊóŞöíäó¡ Êóáöíäó)
        substitutions.add(new ExpressionInfixSubstitution("óæúC2öíõ", "óC2õ")); // EX: (ÃäÊã ÊóŞõæä¡ ÊóŞõäøó¡ Êóáõæä¡ Êóáõäøó)
        substitutions.add(new ExpressionInfixSubstitution("óæúC2öíó","óC2öíó"));// EX: (ÃäÊãÇ ÊŞíÇä)
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
