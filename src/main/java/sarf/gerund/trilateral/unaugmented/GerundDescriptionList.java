package sarf.gerund.trilateral.unaugmented;

import java.util.HashMap;
import java.util.Map;

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
public class GerundDescriptionList {
    private final Map<String, GerundDescription> gerundsBySymbol = new HashMap<>();
    private final Map<String, GerundDescription> gerundsByPattern = new HashMap<>();

    public GerundDescriptionList() {
    }

    public void addGerundDescription(GerundDescription gerundDescription) {
        gerundsBySymbol.put(gerundDescription.getSymbol(), gerundDescription);
        gerundsByPattern.put(gerundDescription.getPattern(), gerundDescription);
    }

    public GerundDescription getGerundDescriptionBySymbol(String symbol) {
        return gerundsBySymbol.get(symbol);
    }

    public GerundDescription getGerundDescriptionByPattern(String pattern) {
        return gerundsByPattern.get(pattern);
    }

}
