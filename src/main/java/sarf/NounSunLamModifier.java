package sarf;

import com.google.inject.Singleton;
import sarf.verb.Root;
import sarf.substitution.Substitution;
import sarf.substitution.SubstitutionsApplier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>
 * Title: Sarf Program
 * </p>
 *
 * <p>
 * Description:
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 *
 * <p>
 * Company: ALEXO
 * </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */

@Singleton
public class NounSunLamModifier extends SubstitutionsApplier {
    private static final List<String> appliedPronounsIndexes = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);

    static {
        IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> i + 1 + "")
                .forEachOrdered(appliedPronounsIndexes::add);
    }

    private final List<Substitution> substitutions = new LinkedList<>();

    public NounSunLamModifier() {
        List<String> sunLetters = new LinkedList<>();
        sunLetters.add("ت");
        sunLetters.add("ث");
        sunLetters.add("د");
        sunLetters.add("ذ");
        sunLetters.add("ر");
        sunLetters.add("ز");
        sunLetters.add("س");
        sunLetters.add("ش");
        sunLetters.add("ص");
        sunLetters.add("ض");
        sunLetters.add("ط");
        sunLetters.add("ظ");
        sunLetters.add("ل");
        sunLetters.add("ن");

        substitutions.add(new ListedInfixSubstitution(sunLetters, "الSLَ", "الSLَّ"));
        substitutions.add(new ListedInfixSubstitution(sunLetters, "الSLُ", "الSLُّ"));
        substitutions.add(new ListedInfixSubstitution(sunLetters, "الSLِ", "الSLِّ"));
    }

    public void apply(ConjugationResult conjResult) {
        apply(conjResult.getFinalResult(), null);
    }

    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @Override
    protected List<String> getAppliedPronounsIndexes() {
        return appliedPronounsIndexes;
    }

    static class ListedInfixSubstitution extends Substitution {
        private final List<String> probableChars;

        ListedInfixSubstitution(List<String> probableChars, String segment, String result) {
            super(segment, result);
            this.probableChars = probableChars;
        }

        @Override
        public String apply(String word, Root root) {
            for (String sl : probableChars) {
                String appliedResult = apply(word, sl);
                if (appliedResult != null) {
                    return appliedResult;
                }
            }
            return null;
        }

        private String apply(String word, String sl) {
            String wordSegment = segment.replaceAll("SL", sl);

            if (!word.contains(wordSegment)) {
                return null;
            }

            String replacedResult = result.replaceAll("SL", sl);
            return word.replaceAll(wordSegment, replacedResult);
        }
    }
}
