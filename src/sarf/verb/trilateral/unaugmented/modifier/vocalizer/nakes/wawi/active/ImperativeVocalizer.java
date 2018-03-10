package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active;

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
public class ImperativeVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ImperativeVocalizer() {

        substitutions.add(new SuffixSubstitution("ُوْ", "ُ")); // EX: (اغْزُ، اسرُ)
        substitutions.add(new InfixSubstitution("ُوِ", "ِ")); // EX: (أنتِ اغزي، اسري )
        substitutions.add(new InfixSubstitution("ُوُو", "ُو")); // EX: (أنتم اغزوا، اسروا )
        substitutions.add(new InfixSubstitution("ُوْن", "ُون")); // EX: (أنتن اغزون، اسرون)
        substitutions.add(new InfixSubstitution("ُوُن", "ُن")); // EX: (أنتم اغْزُنَّ )
        substitutions.add(new SuffixSubstitution("َوْ", "َ")); // EX: (ازْهَ، ارضَ)
        substitutions.add(new InfixSubstitution("َوِي", "َيْ")); // EX: (أنتِ ازهَيْ، ارضَيْ )
        substitutions.add(new InfixSubstitution("َوِن", "َيِن")); // EX: (أنتِ ازهَيِنَّ، ارضيِنَّ)
        substitutions.add(new InfixSubstitution("َوْن", "َيْن")); // EX: (أنتن ازهَيْنَ، ازْهَيْنَانِّ، ارضَيْنَ)
        substitutions.add(new InfixSubstitution("َوُو", "َوْ")); // EX: (أنتم ازهَوْا، ارضَوْا)
        substitutions.add(new InfixSubstitution("َوَا", "َيَا")); // EX: (أنتما ارضيا، ازْهَيَا، )
        substitutions.add(new InfixSubstitution("َوَن", "َيَن")); // EX: (أنتَ ارضيَنَّ، )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 21 || kov == 22 || kov == 23) && (noc == 1)) ||
                ((kov == 21 || kov == 23) && (noc == 5)) ||
                ((kov == 22 || kov == 23) && (noc == 3)) ||
                (kov == 23 && noc == 4);
    }
}
