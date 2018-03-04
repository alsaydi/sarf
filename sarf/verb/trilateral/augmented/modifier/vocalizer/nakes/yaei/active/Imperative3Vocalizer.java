package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.yaei.active;

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
public class Imperative3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative3Vocalizer() {
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (ÑóŞøö¡ ÇÌúÃæøö)
        substitutions.add(new InfixSubstitution("íöí", "í")); // EX: (ÃäÊö ÑóŞøöí¡ ÇÌúÃæøöí)
        substitutions.add(new InfixSubstitution("íöä", "ä")); // EX: (ÃäÊö ÑóŞøöäøó¡ ÇÌúÃæøöäøó)
        substitutions.add(new InfixSubstitution("íúä", "íä")); // EX: (ÃäÊä ÑóŞøöíäó¡ ÇÌúÃæøöíäó)
        substitutions.add(new InfixSubstitution("øöíõ", "øõ")); // EX: (ÃäÊã ÑóŞøõæÇ¡ ÇÌúÃæøõæÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        return ((kov == 26 || kov == 24) && formulaNo == 2) || (kov == 25 && (formulaNo == 2 || formulaNo == 11));
    }
}
