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
public class Vocalizer42 extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Vocalizer42() {
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (åĞÇ ÇáÕøÏöí )
        substitutions.add(new SuffixSubstitution("öíó","öíó"));// EX: (ÑÃíÊõ ÇáÕøÏöíó)
        substitutions.add(new SuffixSubstitution("öíö","öí"));// EX: (ãÑÑÊ Úáì ÇáÕøÏöí)
        substitutions.add(new InfixSubstitution("öíñ","ò"));// EX: (åĞÇ ÕóÏò¡ )
        substitutions.add(new InfixSubstitution("öíò","ò"));// EX: (ãÑÑÊ Úáì ÕóÏò¡ )
        substitutions.add(new InfixSubstitution("öíõæ","õæ"));// EX: (ÕóÏõæäó¡ )
        substitutions.add(new InfixSubstitution("öíöí","öí"));// EX: (ÕóÏöíäó )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return nounFormula.equals("İóÚöá") && (kov == 24 || kov == 26 || kov == 28) && noc == 4;
    }

}
