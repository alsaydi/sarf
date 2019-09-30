package sarf.noun;

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
public interface INounSuffixContainer {
    void selectDefiniteMode();

    void selectInDefiniteMode();

    void selectAnnexedMode();

    String getPrefix();

    String get(int index);
}
