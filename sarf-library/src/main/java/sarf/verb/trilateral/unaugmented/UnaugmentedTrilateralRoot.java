package sarf.verb.trilateral.unaugmented;

import java.util.*;
import sarf.*;
import sarf.verb.trilateral.TrilateralRoot;
import sarf.util.OrderedMap;

/**
 * <p>Title: </p>
 *
 * <p>Description: الجذر الثلاثي المجرد
 * متضمنا الأحرف الثلاثة وباب التصريف  واللزوم أو التعدية مع رموز المصادر              </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class UnaugmentedTrilateralRoot extends TrilateralRoot{

    private String transitive;

    private final OrderedMap<String, Gerund> gerunds = new OrderedMap<>();
    public UnaugmentedTrilateralRoot() {
        super();
    }

    public UnaugmentedTrilateralRoot(char c1, char c2, char c3) {
        super(c1, c2, c3);
    }

    public String getTransitive() {
        return transitive;
    }

    public Collection<String> getGerundsSymbols() {
        return gerunds.getOrderedKeys();
    }

    public Gerund getGerund(String symbol) {
        return gerunds.get(symbol);
    }


    public void setTransitive(String transitive) {
        this.transitive = transitive;
    }


    public void addGerund(Gerund gerund) {
        gerunds.put(gerund.getSymbol(), gerund);
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof UnaugmentedTrilateralRoot))
            return false;

        var other = (UnaugmentedTrilateralRoot) obj;
        return other.getC1() == this.getC1() && other.getC2() == this.getC2() && other.getC3() == this.getC3();
    }
}
