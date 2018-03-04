package sarf;

import java.util.*;
import sarf.verb.trilateral.Substitution.*;
import sarf.verb.trilateral.TrilateralRoot;

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
public class NounSunLamModifier extends SubstitutionsApplier {
    protected static List appliedProunounsIndecies = new ArrayList(13);
    static {
        for (int i = 0; i < 18; i++) {
            appliedProunounsIndecies.add(i + 1 + "");
        }
    }


    List substitutions = new LinkedList();

    private NounSunLamModifier() {
        List sunLetters = new LinkedList();
        sunLetters.add("Ê");
        sunLetters.add("Ë");
        sunLetters.add("Ï");
        sunLetters.add("Ð");
        sunLetters.add("Ñ");
        sunLetters.add("Ò");
        sunLetters.add("Ó");
        sunLetters.add("Ô");
        sunLetters.add("Õ");
        sunLetters.add("Ö");
        sunLetters.add("Ø");
        sunLetters.add("Ù");
        sunLetters.add("á");
        sunLetters.add("ä");

        substitutions.add(new ListedInfixSubstitution(sunLetters,"ÇáSLó","ÇáSLøó"));
        substitutions.add(new ListedInfixSubstitution(sunLetters,"ÇáSLõ","ÇáSLøõ"));
        substitutions.add(new ListedInfixSubstitution(sunLetters,"ÇáSLö","ÇáSLøö"));
    }

    private static NounSunLamModifier instance = new NounSunLamModifier();

    public static NounSunLamModifier getInstance() {
        return instance;
    }

    public void apply(sarf.verb.trilateral.unaugmented.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }

    public void apply(sarf.verb.trilateral.augmented.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }


    public void apply(sarf.verb.quadriliteral.ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }

    public List getSubstitutions() {
        return substitutions;
    }

    protected List getAppliedPronounsIndecies() {
        return appliedProunounsIndecies;
    }

    class ListedInfixSubstitution extends Substitution {
        private List probableChars;
        public ListedInfixSubstitution(List probableChars, String segment, String result) {
            super(segment, result);
            this.probableChars = probableChars;
        }

        /**
         *
         * @param word String
         * @return String
         */
        public String apply(String word, TrilateralRoot root) {
            Iterator iter = probableChars.iterator();
            while (iter.hasNext()) {
                String sl = (String) iter.next();
                String appliedResut = apply(word, sl);
                if (appliedResut != null) {
                    return appliedResut;
                }
            }
            return null;
        }

        public String apply(String word, String sl) {
            String wordSegment = segment.replaceAll("SL", sl);

            if (word.indexOf(wordSegment) == -1) {
                return null;
            }

            String replacedResult = result.replaceAll("SL", sl);
            return word.replaceAll(wordSegment, replacedResult);
        }


    }


}
