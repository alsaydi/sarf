package sarf.noun.trilateral.unaugmented.modifier.activeparticiple.vocalizer;

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
public class Ajwaf2Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Ajwaf2Vocalizer() {

        substitutions.add(new InfixSubstitution("ÇæöÁñ","ÇÁò"));// EX: (åĞÇ äÇÁò)
        substitutions.add(new InfixSubstitution("ÇæöÁğ","ÇÆöíğ"));// EX: (ÑÃíÊõ äÇÆöíÇğ)
        substitutions.add(new InfixSubstitution("ÇæöÁò","ÇÁò"));// EX: (ãÑÑÊõ Úáì äÇÁò)
        substitutions.add(new SuffixSubstitution("ÇæöÁõ","ÇÆöí"));// EX: (åĞÇ ÇáäÇÆöí¡ äÇÆöí ÇáÜ¡ )
        substitutions.add(new SuffixSubstitution("ÇæöÁó","ÇÆöíó"));// EX: (ÑÃíÊõ ÇáäÇÆíó¡ äÇÆöí ÇáÜ¡ )
        substitutions.add(new SuffixSubstitution("ÇæöÁö","ÇÆöí"));// EX: (ãÑÑÊõ Úáì ÇáäÇÆöí¡ äÇÆöí ÇáÜ)
        substitutions.add(new InfixSubstitution("ÇæöÁó","ÇÆöíó"));// EX: (äÇÆöíóÉñ¡ äÇÆöíÇäö¡  )
        substitutions.add(new InfixSubstitution("ÇæöÁõ","ÇÄõ"));// EX: (äÇÄõæäó¡ )
        substitutions.add(new InfixSubstitution("ÇæöÁö","ÇÆö"));// EX: (äÇÆöíäó¡ )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return kov == 16 && (noc ==1 || noc == 4);
    }
}
