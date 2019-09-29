package sarf.kov;

import java.util.*;

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
public class QuadrilateralKovRuleList {
    private final List<QuadrilateralKovRule> rules = new ArrayList<>(20);

    public QuadrilateralKovRuleList() {
    }

    /**
     * this function is used at run-time when the app starts.
     */
    public void addRule(QuadrilateralKovRule rule) {
        rules.add(rule);
    }

    public List<QuadrilateralKovRule> getRules() {
        return rules;
    }
}
