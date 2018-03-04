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
public class Ajwaf4Vocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public Ajwaf4Vocalizer() {

        substitutions.add(new InfixSubstitution("ÇíöÁñ","ÇÁò"));// EX: (åĞÇ ÌÇÁò)
        substitutions.add(new InfixSubstitution("ÇíöÁò","ÇÁò"));// EX: (ãÑÑÊõ Úáì ÌÇÁò)
        substitutions.add(new SuffixSubstitution("ÇíöÁõ","ÇÆöí"));// EX: (åĞÇ ÇáÌÇÆöí¡ )
        substitutions.add(new SuffixSubstitution("ÇíöÁö","ÇÆöí"));// EX: (ãÑÑÊõ Úáì ÇáÌÇÆöí )
        substitutions.add(new InfixSubstitution("ÇíöÁõ","ÇÄõ"));// EX: (ÌÇÄõæäó¡ )
        substitutions.add(new InfixSubstitution("ÇíöÁö","ÇÆö"));// EX: (ÌÇÆöíäó¡ )
        substitutions.add(new InfixSubstitution("ÇíöÁ","ÇÆöí"));// EX: (ÌÇÆíÇä¡ ÌÇÆíóíúä¡ ÌÇÆíÉ¡ ÌÇÆíğÇ¡ ÑÃíÊõ ÇáÌÇÆöíó)

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        return kov == 19 && (noc == 2 || noc == 4);
    }
}
