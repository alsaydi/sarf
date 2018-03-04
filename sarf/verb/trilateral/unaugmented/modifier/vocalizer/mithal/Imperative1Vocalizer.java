package sarf.verb.trilateral.unaugmented.modifier.vocalizer.mithal;

import java.util.*;

import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.unaugmented.modifier.*;
import sarf.verb.trilateral.unaugmented.ConjugationResult;
import sarf.verb.trilateral.unaugmented.UnaugmentedTrilateralRoot;

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
public class Imperative1Vocalizer extends SubstitutionsApplier implements IUnaugmentedTrilateralModifier {

    private List substitutions = new LinkedList();

    private List acceptList = new LinkedList();
    private List declineList = new LinkedList();

    public Imperative1Vocalizer() {
        acceptList.add("Ê–—");
        acceptList.add("Ê”⁄");
        acceptList.add("Êÿ¡");

        declineList.add("Ê»¡");
        declineList.add("Ê»Â");
        declineList.add("ÊÃ⁄");
        declineList.add("Ê”⁄");
        declineList.add("ÊÂ·");

        substitutions.add(new InfixSubstitution("«Ê˙",""));
    }


    public List getSubstitutions() {
        return substitutions;
    }

    /**
     * ›Õ’ √Õœ À·«À… «Õ „«·« 
     * @param conjugationResult ConjugationResult
     * @return boolean
     */
    public boolean isApplied(ConjugationResult conjugationResult) {
        int kov = conjugationResult.getKov();
        int noc = Integer.parseInt(conjugationResult.getRoot().getConjugation());
        return (kov == 9 && noc == 2)
                || (kov == 11 && (noc == 2 || noc == 6))
                || isApplied1(conjugationResult) //«Õ „«·2
                || isApplied2(conjugationResult); // «Õ „«· 3

    }

    private boolean isApplied1(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        //›Õ’ «·»«» «· ’—Ì›Ì √Ê·«
        if (!root.getConjugation().equals("4")) return false;

        Iterator iter = acceptList.iterator();
        while (iter.hasNext()) {
            String appliedRoot = (String) iter.next();
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return true;
        }
        return false;
    }

    private boolean isApplied2(ConjugationResult conjugationResult) {
        UnaugmentedTrilateralRoot root = conjugationResult.getRoot();
        //›Õ’ «·»«» «· ’—Ì›Ì √Ê·«
        if (!root.getConjugation().equals("3")) return false;

        Iterator iter = declineList.iterator();
        while (iter.hasNext()) {
            String appliedRoot = (String) iter.next();
            char c1 = appliedRoot.charAt(0);
            char c2 = appliedRoot.charAt(1);
            char c3 = appliedRoot.charAt(2);
            if (c1 == root.getC1() && c2 == root.getC2() && root.getC3() == c3)
                return false;
        }
        return true;
    }
}
