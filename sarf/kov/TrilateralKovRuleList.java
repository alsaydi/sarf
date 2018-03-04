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
public class TrilateralKovRuleList {
    private List rules = new ArrayList(33);

    public TrilateralKovRuleList() {
    }

    public void addRule(TrilateralKovRule rule) {
        rules.add(rule);
    }

    public List getRules() {
        return rules;
    }
}
