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
public class Present1Vocalizer extends SubstitutionsApplier implements IAugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public Present1Vocalizer() {
        substitutions.add(new InfixSubstitution("öæõæ","õæ"));// EX: (åã íõÏúäõæä¡ íÍÇÈæä¡ íäÌáæä¡ íÑÊÖæä¡ íÑÚææä¡ íÓÊÑÖæä¡ íÍáæáæä)
        substitutions.add(new InfixSubstitution("öæõä","õä"));// EX: (åã íõÏúäõäøó¡ íÍÇÈõäøó¡ íäÌáõäøó¡ íÑÊÖõäøó¡ íÑÚæõäøó¡ íÓÊÑÖõäøó¡ íÍáæáõäøó)
        substitutions.add(new SuffixSubstitution("æõ","í"));// EX: (åæ íõÏúäöí¡ íÍÇÈí¡ íäÌáí¡ íÑÊÖí¡ íÑÚóæöí¡ íÓÊÑÖí¡ íÍáæáí)
        substitutions.add(new SuffixSubstitution("æú",""));// EX: (áã íõÏúäö¡ íÍÇÈ¡ íäÌáö¡ íÑÊÖö¡ íÑÚóæö¡ íÓÊÑÖö¡ íÍáæáö)
        substitutions.add(new InfixSubstitution("æúä","íä"));// EX: (ÃäÊä ÊõÏäöíäó¡ ÊÍÇÈíä¡ ÊäÌáíä¡ ÊÑÊÖíä¡ ÊÑÚæíä¡ ÊÓÊÑÖíä¡ ÊÍáæáíä)
        substitutions.add(new InfixSubstitution("öæö","ö"));// EX: (ÃäÊö ÊõÏúäöíäó¡ ÊõÍÇÈöíäó¡ ÊäÌáíä¡ ÊÑÊÖíä¡ ÊÑÚæíä¡ ÊÓÊÑÖíä¡ ÊÍáæáíä)
        substitutions.add(new InfixSubstitution("æó","íó"));// EX: (áä íõÏúäöíó¡ åãÇ íõÏäöíÇä¡ íÍÇÈíÇä¡ íäÌáíÇä¡ íÑÊÖíÇä¡ íÑÚæíÇä¡ íÓÊÑÖíÇä¡ íÍáæáíÇä)
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
