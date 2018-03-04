package sarf.verb.trilateral.augmented.modifier.vocalizer.nakes.wawi.active;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.augmented.modifier.*;
import sarf.verb.trilateral.augmented.ConjugationResult;

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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Imperative1Vocalizer() {
        substitutions.add(new InfixSubstitution("öæõæ","õæ"));// EX: (ÃäÊã ÃÏúäõæÇ¡ ÍÇÈõæÇ¡ ÇäÌáõæÇ¡ ÇÑÊÖõæÇ¡ ÇÑÚóæõæÇ¡ ÇÓÊÑÖõæÇ¡ ÇÍáóæúáõæÇ)
        substitutions.add(new InfixSubstitution("öæõä","õä"));// EX: (ÃäÊã ÃÏúäõäøó¡ ÍÇÈõäøó¡ ÇäÌáõäøó¡ ÇÑÊÖõäøó¡ ÇÑÚóæõäøó¡ ÇÓÊÑÖõäøó¡ ÇÍáóæúáõäøó)
        substitutions.add(new SuffixSubstitution("æú",""));// EX: (ÃÏúäö¡ ÍÇÈö¡ ÇäÌáö¡ ÇÑÊÖö¡ ÇÑÚóæö¡ ÇÓÊÑÖö¡ ÇÍáóæúáö)
        substitutions.add(new InfixSubstitution("æúä","íä"));// EX: (ÃäÊä ÃÏäöíäó¡ ÍÇÈöíä¡ ÇäÌáöíä¡ ÇÑÊÖíä¡ ÇÑÚæíä¡ ÇÓÊÑÖíä¡ ÇÍáæáíä)
        substitutions.add(new InfixSubstitution("öæö","ö"));// EX: (ÃäÊö ÃÏúäöí¡ ÍÇÈöí¡ ÇäÌáöí¡ ÇÑÊÖí¡ ÇÑÚæí¡ ÇÓÊÑÖí¡ ÇÍáæáí)
        substitutions.add(new InfixSubstitution("æó","íó"));// EX: (ÃäÊãÇ ÃÏúäöíÇ¡ ÍÇÈöíÇ¡ ÇäÌáöíÇ¡ ÇÑÊÖíÇ¡ ÇÑÚæíÇ¡ ÇÓÊÑÖíÇ¡ ÇÍáæáíÇ)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int formulaNo = conjugationResult.getFormulaNo();

        if ((kov == 22 || kov == 23) && formulaNo == 4) return true;
        if ((kov == 21 || kov == 23) &&  formulaNo == 9) return true;
        if (kov == 23 && (formulaNo == 6 || formulaNo == 10)) return true;

        switch (kov) {
        case 21:
        case 22:
        case 23:
            switch (formulaNo) {
            case 1:
            case 3:
            case 5:
                return true;
            }
        }
        return false;
    }
}
