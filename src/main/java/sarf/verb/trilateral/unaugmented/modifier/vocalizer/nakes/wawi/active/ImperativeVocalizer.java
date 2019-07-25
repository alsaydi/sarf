package sarf.verb.trilateral.unaugmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.Conjugation;
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
    private List<Substitution> substitutions = new ArrayList<>();

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
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();
        return ((kov == 21 || kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) && (noc == Conjugation.First)) ||
                ((kov == 21 || kov == KindOfVerb.Naqis_Wawi) && (noc == Conjugation.Fifth)) ||
                ((kov == KindOfVerb.Naqis_Wawi_Mahmouz_Ain || kov == KindOfVerb.Naqis_Wawi) && (noc == Conjugation.Third)) ||
                (kov == KindOfVerb.Naqis_Wawi && noc == Conjugation.Forth);
    }
}
