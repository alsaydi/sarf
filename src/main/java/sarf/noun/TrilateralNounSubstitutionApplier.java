package sarf.noun;

import java.util.*;
import java.util.stream.IntStream;

import sarf.SystemConstants;
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
public abstract class TrilateralNounSubstitutionApplier extends SubstitutionsApplier {

    private static final List<String> appliedPronounsIndexes = new ArrayList<>(SystemConstants.NOUN_POSSIBLE_STATES);
    static {
        IntStream.range(0, SystemConstants.NOUN_POSSIBLE_STATES)
                .mapToObj(i -> i + 1 + "")
                .forEachOrdered(appliedPronounsIndexes::add);
    }

    public TrilateralNounSubstitutionApplier() {
    }

    @Override
    protected List getAppliedPronounsIndexes() {
        return appliedPronounsIndexes;
    }
}
