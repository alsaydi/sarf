package sarf.ui;

import java.io.File;

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
public interface IHtmlContentSaver {
    public boolean saveToHtml(File file);
    public String getSavedFileNameTitle();
}
