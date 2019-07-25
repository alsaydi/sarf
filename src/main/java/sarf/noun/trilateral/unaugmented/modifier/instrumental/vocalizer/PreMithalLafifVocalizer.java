package sarf.noun.trilateral.unaugmented.modifier.instrumental.vocalizer;

import java.util.*;

import sarf.Conjugation;
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

        switch (kov) {
            case 8:
                return noc == Conjugation.Forth;
            case 9:
            case 29:
                return noc == Conjugation.Second;
            case 10:
                switch (noc) {
                    case Third:
                    case Forth:
                    case Fifth:
                        return true;
                }
            case 11:
                switch (noc) {
                    case Second:
                    case Third:
                    case Forth:
                    case Fifth:
                    case Sixth:
                        return true;
                }
            case 12:
                return noc == Conjugation.Second || noc == Conjugation.Forth;
            case 13:
                return noc == Conjugation.Forth || noc == Conjugation.Sixth;
            case 14:
                switch (noc) {
                    case First:
                    case Second:
                    case Third:
                    case Forth:
                    case Fifth:
                    case Sixth:
                        return true;
                }
            case 30:
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
