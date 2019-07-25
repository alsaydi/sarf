package sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer;

import java.util.*;

import sarf.Conjugation;
import sarf.KindOfVerb;
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
public class PreMithalLafifVocalizer extends TrilateralNounSubstitutionApplier implements IUnaugmentedTrilateralNounModificationApplier {
    private List<Substitution> substitutions = new ArrayList<>();

    public PreMithalLafifVocalizer() {
        substitutions.add(new InfixSubstitution("مِوْ", "مِي")); // EX: (مِيسَم، مِيسمة، مِيصال، مِيفاء)
        substitutions.add(new InfixSubstitution("مِيْ", "مِي")); // EX: (مِيقَن، مِيقنة، مِيقان، مِيداء)
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        KindOfVerb kov = conjugationResult.getKov();
        var noc = conjugationResult.getRoot().getConjugation();

        if (kov == 8) {
            return noc == Conjugation.Forth;
        } else if (kov == 9 || kov == KindOfVerb.Lafeef_Mafrooq_Mahmouz_Ain) {
            return noc == Conjugation.Second;
        } else if (kov == 10) {
            switch (noc) {
                case Third:
                case Forth:
                case Fifth:
                    return true;
            }

            switch (noc) {
                case Second:
                case Third:
                case Forth:
                case Fifth:
                case Sixth:
                    return true;
            }

            return noc == Conjugation.Second || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Mithal_Wawi) {
            switch (noc) {
                case Second:
                case Third:
                case Forth:
                case Fifth:
                case Sixth:
                    return true;
            }

            return noc == Conjugation.Second || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Mithal_Yaee_Mudaaf) {
            return noc == Conjugation.Second || noc == Conjugation.Forth;
        } else if (kov == KindOfVerb.Mithal_Yaee_Mahmouz_Ain) {
            return noc == Conjugation.Forth || noc == Conjugation.Sixth;
        } else if (kov == KindOfVerb.Mithal_Yaee) {
            switch (noc) {
                case First:
                case Second:
                case Third:
                case Forth:
                case Fifth:
                case Sixth:
                    return true;
            }
        } else if (kov == KindOfVerb.Lafeef_Mafrooq) {
            switch (noc) {
                case Second:
                case Forth:
                case Sixth:
                    return true;
            }
        }
        return false;
    }
}
