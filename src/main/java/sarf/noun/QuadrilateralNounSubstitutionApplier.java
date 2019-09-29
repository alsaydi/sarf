package sarf.noun;

import java.util.*;
import java.util.stream.IntStream;

import sarf.SystemConstants;
import sarf.substitution.SubstitutionsApplier;

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
public abstract class QuadrilateralNounSubstitutionApplier extends SubstitutionsApplier {
    private static final List<String> appliedPronounsIndexes = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
    static {
        IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> i + 1 + "")
                .forEachOrdered(appliedPronounsIndexes::add);
    }

    protected List<String> getAppliedPronounsIndexes() {
        return appliedPronounsIndexes;
    }
}
