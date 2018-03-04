package sarf.gerund.modifier.trilateral.unaugmented.meem.vocalizer;

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
public class NakesLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    List substitutions = new LinkedList();

    public NakesLafifVocalizer() {

        substitutions.add(new InfixSubstitution("ужс", "рм")); // EX: (е–« гуџъ“рм )
        substitutions.add(new InfixSubstitution("ужр«", "рм")); // EX: (—√н  гуџъ“рм )
        substitutions.add(new InfixSubstitution("ужт", "рм")); // EX: (»цгуџъ“рм )
        substitutions.add(new SuffixSubstitution("ужх", "ум")); // EX: (е–« гуџъ“ум «б√г—)
        substitutions.add(new SuffixSubstitution("ужу", "ум")); // EX: (—√н  гуџъ“ум «б√г—)
        substitutions.add(new SuffixSubstitution("ужц", "ум")); // EX: (»цгуџъ“ум «б√г—)
        substitutions.add(new InfixSubstitution("унс", "рм")); // EX: (е–« г—грм )
        substitutions.add(new InfixSubstitution("унр«", "рм")); // EX: (—√н  г—грм)
        substitutions.add(new InfixSubstitution("унт", "рм")); // EX: (»цг—грм)
        substitutions.add(new SuffixSubstitution("унх", "ум")); // EX: (е–« г—гум «бёжг)
        substitutions.add(new SuffixSubstitution("уну", "ум")); // EX: (—√н  г—гум «бёжг)
        substitutions.add(new SuffixSubstitution("унц", "ум")); // EX: (»цг—гум «бёжг)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        if (!conjugationResult.getNounFormula().equals("гуЁъЏуб")) {
            return false;
        }

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
