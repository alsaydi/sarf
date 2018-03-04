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
public class Present3Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present3Vocalizer() {
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (íõÑóŞøöí¡ íóÌúÃæøöí)
        substitutions.add(new SuffixSubstitution("íú", "")); // EX: (áã íõÑóŞøö¡ íóÌúÃæøö)
        substitutions.add(new InfixSubstitution("íöä", "ä")); // EX: (ÃäÊö ÊõÑóŞøöäøó¡ ÊóÌúÃæøöäøó)
        substitutions.add(new InfixSubstitution("íöí", "í")); // EX: (ÃäÊö ÊõÑóŞøöíäó¡ ÊóÌúÃæøöíäó)
        substitutions.add(new InfixSubstitution("íúä", "íä")); // EX: (ÃäÊä ÊõÑóŞøöíäó¡ ÊóÌúÃæøöíäó)
        substitutions.add(new InfixSubstitution("øöíõæ", "øõæ")); // EX: (ÃäÊã ÊõÑóŞøõæäó¡ ÊóÌúÃæøõæäó)
        substitutions.add(new InfixSubstitution("øöíõä", "øõä")); // EX: (ÃäÊã ÊõÑóŞøõäøó¡ ÊóÌúÃæøõäøó)
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
