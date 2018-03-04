package sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer;

import java.util.*;

import sarf.noun.*;
import sarf.noun.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.Substitution.*;

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
public class YaeiNakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public YaeiNakesLafifVocalizer() {

        substitutions.add(new SuffixSubstitution("َيُ","َى"));// EX: (هذا المِسرى )
        substitutions.add(new SuffixSubstitution("َيَ","َى"));// EX: (رأيت المِسرى)
        substitutions.add(new SuffixSubstitution("َيِ","َى"));// EX: (كالمِسرى )
        substitutions.add(new InfixSubstitution("َيٌ","ًى"));// EX: (هذا مِسرًى )
        substitutions.add(new InfixSubstitution("َيًا","ًى"));// EX: (رأيت مِسرًى)
        substitutions.add(new InfixSubstitution("َيٍ","ًى"));// EX: (كَمِسرًى )
        substitutions.add(new InfixSubstitution("ايًا","اءً"));// EX: (مِسراءً)
        substitutions.add(new InfixSubstitution("َيَة","َاة"));// EX: (مِسراة )
        substitutions.add(new InfixSubstitution("َيَت","َات"));// EX: (مِسراتان )
        substitutions.add(new InfixSubstitution("اي","اء"));// EX: (مِسراء )

    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (conjugationResult.getRoot().getC3() != 'ي')
            return false;

        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());

        switch (kov) {
        case 21:
            return noc == 1 || noc == 5;
        case 22:
            return noc == 1 || noc == 3;
        case 23:
            switch (noc) {
            case 1:
            case 3:
            case 4:
            case 5:
                return true;
            }

        case 24:
        case 26:
            switch (noc) {
            case 2:
            case 3:
            case 4:
                return true;
            }

        case 25:
            return noc == 3 || noc == 4;

        case 27:
        case 29:
            return noc == 2;
        case 28:
            return noc == 2 || noc == 4;
        case 30:
            switch (noc) {
            case 2:
            case 4:
            case 6:
                return true;
            }

        }
        return false;
    }

}
