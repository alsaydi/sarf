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
    private List rules = new ArrayList(20);

    public QuadrilateralKovRuleList() {
    }

    public void addRule(QuadrilateralKovRule rule) {
        rules.add(rule);
    }

    public List getRules() {
        return rules;
    }
}
