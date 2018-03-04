package sarf.noun.trilateral.unaugmented.modifier.exaggeration.vocalizer;

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
public class I1Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public I1Vocalizer() {
        substitutions.add(new InfixSubstitution("öæñ","ò"));// EX: (åĞÇ Òóåò)
        substitutions.add(new InfixSubstitution("öæğ","öíğ"));// EX: (ÑÃíÊõ ÒóåöíğÇ)
        substitutions.add(new InfixSubstitution("öæò","ò"));// EX: (ãÑÑÊõ Úáì Òóåò)
        substitutions.add(new SuffixSubstitution("öæõ","öí"));// EX: (åĞÇ ÇáÒÇåí¡ )
        substitutions.add(new SuffixSubstitution("öæó","öíó"));// EX: (ÑÃíÊõ ÇáÒÇåíó¡ )
        substitutions.add(new SuffixSubstitution("öæö","öí"));// EX: (ãÑÑÊõ Úáì ÇáÒÇåí¡ )
        substitutions.add(new InfixSubstitution("öæó","öíó"));// EX: (ÒóåöíóÉñ¡ ÒóåöíÇä )
        substitutions.add(new InfixSubstitution("öæõ","õ"));// EX: (Òóåõæä¡ )
        substitutions.add(new InfixSubstitution("öæö","ö"));// EX: (Òóåöíäó¡ )
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        String nounFormula = conjugationResult.getNounFormula();
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return nounFormula.equals("İóÚöá") && (kov == 23 && (noc == 1 || noc == 3 || noc == 5));
    }

}
