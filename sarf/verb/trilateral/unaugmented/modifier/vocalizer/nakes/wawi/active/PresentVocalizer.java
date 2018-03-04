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

        substitutions.add(new SuffixSubstitution("õæõ","õæ"));// EX: (íÛÒæ¡ íóãúÄõæ¡ íÃÓæ¡ íÓÑæ¡ íÃãæ )
        substitutions.add(new SuffixSubstitution("õæú","õ"));// EX: (áã íóÛúÒõ¡ áã íóãúÁõ¡ íóÃúÓõ¡ íóÓúÑõ¡ íÃãõ)
        substitutions.add(new InfixSubstitution("õæö","ö"));// EX: (ÃäÊö ÊÛÒíä¡ ÊÃãíä¡ ÊÃÓíä¡ ÊóÓÑöíä¡ ÊóÛúÒöäøó)
        substitutions.add(new InfixSubstitution("õæúä","õæä"));// EX: (ÃäÊä ÊÛÒæä¡ ÊÃãæä¡ ÊÃÓæä¡ ÊÓÑæä¡ ÊÃãæä)
        substitutions.add(new InfixSubstitution("õæõæ","õæ"));// EX: (ÃäÊã ÊÛÒæä¡ ÊÃãæä¡ ÊÃÓæä¡ ÊÓÑæä¡ ÊÃãæä )
        substitutions.add(new InfixSubstitution("õæõä","õä"));// EX: (ÃäÊã ÊóÛúÒõäøó )
        substitutions.add(new SuffixSubstitution("óæõ","óì"));// EX: (íÑÖì¡ íÒåì¡ íÌÃì )
        substitutions.add(new SuffixSubstitution("óæó","óì"));// EX: (áä íÑÖì¡ áä íÒåì¡ áä íÌÃì )
        substitutions.add(new SuffixSubstitution("óæú","ó"));// EX: (áã íÑÖó¡ áã íóÒúåó¡ áã íóÌúÃó)
        substitutions.add(new InfixSubstitution("óæóÇ","óíóÇ"));// EX: (ÊÑÖíÇä¡ ÊóÒúåóíóÇä¡ áä ÊÒåíÇ¡ áã ÊÒåíÇ¡ ÊÌÃíÇä )
        substitutions.add(new InfixSubstitution("óæöí","óíú"));// EX: (ÃäÊö ÊÑÖíä¡ ÊóÒúåóíúäó¡ áä ÊóÒúåóíú¡ áã ÊóÒúåóíú¡ ÊóÌúÃóíúäó )
        substitutions.add(new InfixSubstitution("óæöä","óíöä"));// EX: (ÃäÊö ÊÑÖíäøó¡ ÊóÒúåóíöäøó¡)
        substitutions.add(new InfixSubstitution("óæúä","óíúä"));// EX: (ÃäÊä ÊÑÖóíúä¡ ÊóÒúåóíúäó¡ áä ÊÒåóíä¡ áã ÊÒåíä¡ ÊÌÃíä)
        substitutions.add(new InfixSubstitution("óæõæ","óæú"));// EX: (ÃäÊã ÊÑÖóæúäó¡ ÊóÒúåóæúäó¡ áä ÊÒåóæúÇ¡ áã ÊÒåóæúÇ¡ ÊÌÃæä )
        substitutions.add(new InfixSubstitution("óæóä","óíóä"));// EX: (ÃäÊó ÊÑÖíóäøó¡ )
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
