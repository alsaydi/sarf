package sarf.noun.trilateral.unaugmented.modifier.assimilate.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.verb.trilateral.unaugmented.modifier.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.noun.trilateral.unaugmented.modifier.*;

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
public class Vocalizer1 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Vocalizer1() {
        substitutions.add(new SuffixSubstitution("óíõ", "óì")); // EX: (åĞÇ ÇáÃÚãì¡ )
        substitutions.add(new SuffixSubstitution("öíó", "óì")); // EX: (ÑÃíÊõ ÇáÃÚãì ¡ )
        substitutions.add(new SuffixSubstitution("öíö", "óì")); // EX: (ãÑÑÊõ Úáì ÇáÃÚãì ¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return nounFormula.equals("ÃİÚá") && (kov == 25 || kov == 26) && noc == 4;
    }

}
