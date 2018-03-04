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
public class PresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public PresentVocalizer() {

        substitutions.add(new SuffixSubstitution("ُوُ","ُو"));// EX: (يغزو، يَمْؤُو، يأسو، يسرو، يأمو )
        substitutions.add(new SuffixSubstitution("ُوْ","ُ"));// EX: (لم يَغْزُ، لم يَمْءُ، يَأْسُ، يَسْرُ، يأمُ)
        substitutions.add(new InfixSubstitution("ُوِ","ِ"));// EX: (أنتِ تغزين، تأمين، تأسين، تَسرِين، تَغْزِنَّ)
        substitutions.add(new InfixSubstitution("ُوْن","ُون"));// EX: (أنتن تغزون، تأمون، تأسون، تسرون، تأمون)
        substitutions.add(new InfixSubstitution("ُوُو","ُو"));// EX: (أنتم تغزون، تأمون، تأسون، تسرون، تأمون )
        substitutions.add(new InfixSubstitution("ُوُن","ُن"));// EX: (أنتم تَغْزُنَّ )
        substitutions.add(new SuffixSubstitution("َوُ","َى"));// EX: (يرضى، يزهى، يجأى )
        substitutions.add(new SuffixSubstitution("َوَ","َى"));// EX: (لن يرضى، لن يزهى، لن يجأى )
        substitutions.add(new SuffixSubstitution("َوْ","َ"));// EX: (لم يرضَ، لم يَزْهَ، لم يَجْأَ)
        substitutions.add(new InfixSubstitution("َوَا","َيَا"));// EX: (ترضيان، تَزْهَيَان، لن تزهيا، لم تزهيا، تجأيان )
        substitutions.add(new InfixSubstitution("َوِي","َيْ"));// EX: (أنتِ ترضين، تَزْهَيْنَ، لن تَزْهَيْ، لم تَزْهَيْ، تَجْأَيْنَ )
        substitutions.add(new InfixSubstitution("َوِن","َيِن"));// EX: (أنتِ ترضينَّ، تَزْهَيِنَّ،)
        substitutions.add(new InfixSubstitution("َوْن","َيْن"));// EX: (أنتن ترضَيْن، تَزْهَيْنَ، لن تزهَين، لم تزهين، تجأين)
        substitutions.add(new InfixSubstitution("َوُو","َوْ"));// EX: (أنتم ترضَوْنَ، تَزْهَوْنَ، لن تزهَوْا، لم تزهَوْا، تجأون )
        substitutions.add(new InfixSubstitution("َوَن","َيَن"));// EX: (أنتَ ترضيَنَّ، )
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
