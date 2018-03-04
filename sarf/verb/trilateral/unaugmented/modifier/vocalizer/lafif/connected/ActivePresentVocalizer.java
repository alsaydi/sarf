package sarf.verb.trilateral.unaugmented.modifier.vocalizer.lafif.connected;

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
public class ActivePresentVocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    public ActivePresentVocalizer() {
        substitutions.add(new SuffixSubstitution("öíõ","öí"));// EX: (íóÔæí)
        substitutions.add(new SuffixSubstitution("öíú","ö"));// EX: (áã íóÔúæö)
        substitutions.add(new InfixSubstitution("öíöä","öä"));// EX: (ÃäÊö ÊóÔúæöäøó)
        substitutions.add(new InfixSubstitution("öíö","ö"));// EX: (ÃäÊö ÊóÔúæöíäó)
        substitutions.add(new InfixSubstitution("öíú","öí"));// EX: (ÇäÊä ÊÔæíä)
        substitutions.add(new InfixSubstitution("öíõ","õ"));// EX: (ÃäÊã ÊÔææä¡ ÊóÔúæõäøó)
        substitutions.add(new SuffixSubstitution("íóíõ","íóÇ"));// EX: (íóÍúíóÇ)
        substitutions.add(new SuffixSubstitution("íóíó","íóÇ"));// EX: (áä íóÍúíóÇ)
        substitutions.add(new SuffixSubstitution("óíõ","óì"));// EX: (íóŞúæóì)
        substitutions.add(new SuffixSubstitution("óíó","óì"));// EX: (áä íóŞúæóì)
        substitutions.add(new SuffixSubstitution("óíú","ó"));// EX: (áã íóŞúæó¡ íóÍúíó)
        substitutions.add(new InfixSubstitution("óíöí","óíú"));// EX: (ÃäÊö ÊóŞúæóíúäó¡ ÊóÍúíóíúäó)
        substitutions.add(new InfixSubstitution("óíõæ","óæú"));// EX: (ÃäÊã ÊóŞúæóæúäó¡ ÊóÍúíóæúäó)
        substitutions.add(new InfixSubstitution("óíõä","óæõä"));// EX: (ÃäÊã ÊóŞúæóæõäøó¡ ÊóÍúíóæõäøó)
        substitutions.add(new SuffixSubstitution("óæõ","óì"));// EX: (íóÓúæóì)
        substitutions.add(new SuffixSubstitution("óæó","óì"));// EX: (áä íóÓúæóì)
        substitutions.add(new SuffixSubstitution("óæú","ó"));// EX: (áã íóÓúæó)
        substitutions.add(new InfixSubstitution("óæöí","óíú"));// EX: (ÃäÊö ÊóÓúæóíúäó)
        substitutions.add(new InfixSubstitution("óæöä","óíöä"));// EX: (ÃäÊö ÊóÓúæóíöäøó)
        substitutions.add(new InfixSubstitution("óæóä","óíóä"));// EX: (ÃäÊó ÊóÓúæóíóäøó)
        substitutions.add(new InfixSubstitution("óæúä","óíúä"));// EX: (ÃäÊä ÊóÓúæóíúäó)
        substitutions.add(new InfixSubstitution("óæõæ","óæú"));// EX: (ÃäÊã ÊóÓúæóæúäó)
        substitutions.add(new InfixSubstitution("óæó","óíó"));// EX: (ÃäÊãÇ ÊÓúæíÇäö)
    }


    public List getSubstitutions() {
        return substitutions;
    }

    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return ((kov == 27 || kov == 28) && (noc == 2)) ||
                (kov == 28 && noc == 4);
    }
}
