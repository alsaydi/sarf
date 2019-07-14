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

    public void selectDefiniteMode() ;
    public void selectInDefiniteMode();
    public void selectAnnexedMode() ;
    public String getPrefix() ;
    public String get(int index) ;
}
