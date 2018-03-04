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
public class Vocalizer41 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Vocalizer41() {
        substitutions.add(new SuffixSubstitution("öæõ", "öí")); // EX: (åĞÇ ÇáÑøóÖöí )
        substitutions.add(new SuffixSubstitution("öæó", "öíó")); // EX: (ÑÃíÊõ ÇáÑøóÖöíó )
        substitutions.add(new SuffixSubstitution("öæö", "öí")); // EX: (ãÑÑÊ Úáì ÇáÑøóÖöí )
        substitutions.add(new InfixSubstitution("öæñ", "ò")); // EX: (åĞÇ ÑóÖò¡ )
        substitutions.add(new InfixSubstitution("öæò", "ò")); // EX: (ãÑÑÊ Úáì ÑóÖò¡ )
        substitutions.add(new InfixSubstitution("öæğ", "öíğ")); // EX: (ÑÃíÊ ÑóÖöíğÇ¡ )
        substitutions.add(new InfixSubstitution("öæó", "öíó")); // EX: (ÑóÖöíÇä¡ ÑóÖöíóÉñ¡ )
        substitutions.add(new InfixSubstitution("öæõæ", "õæ")); // EX: (ÑóÖõæäó¡ )
        substitutions.add(new InfixSubstitution("öæöí", "öí")); // EX: (ÑóÖöíäó )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return nounFormula.equals("İóÚöá") && kov == 23 && noc == 4;
    }

}
