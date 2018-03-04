package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

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
public class PassivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PassivePresentVocalizer() {
        substitutions.add(new SuffixSubstitution("нунх","ну«"));// EX: (нхЌъну«)
        substitutions.add(new SuffixSubstitution("нуну","ну«"));// EX: (бд нхЌъну«)
        substitutions.add(new SuffixSubstitution("унх","ум"));// EX: (нх‘ъжум)
        substitutions.add(new SuffixSubstitution("уну","ум"));// EX: (бд нх‘ъжум)
        substitutions.add(new SuffixSubstitution("унъ","у"));// EX: (бг нх‘ъжу)
        substitutions.add(new InfixSubstitution("унцн","унъ"));// EX: (√д ц  х‘ъжунъду)
        substitutions.add(new InfixSubstitution("унхж","ужъ"));// EX: (√д г  х‘ъжужъду)
        substitutions.add(new InfixSubstitution("унхд","ужхд"));// EX: (√д г  х‘ъжужхдшу)
        substitutions.add(new SuffixSubstitution("ужх","ум"));// EX: (нх”ъжум)
        substitutions.add(new SuffixSubstitution("ужу","ум"));// EX: (бд нх”ъжум)
        substitutions.add(new SuffixSubstitution("ужъ","у"));// EX: (бг нх”ъжу)
        substitutions.add(new InfixSubstitution("ужцн","унъ"));// EX: (√д ц  х”ъжунъду)
        substitutions.add(new InfixSubstitution("ужцд","унцд"));// EX: (√д ц  х”ъжунцдшу)
        substitutions.add(new InfixSubstitution("ужуд","унуд"));// EX: (√д у  х”ъжунудшу)
        substitutions.add(new InfixSubstitution("ужхж","ужъ"));// EX: (√д г  х”ъжужъду)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 27 || kov == 28) && (noc == 2)) || (kov == 28 && noc == 4);
    }
}
