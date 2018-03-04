package sarf.util;

import java.io.File;
import java.io.*;

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
public class FileUtil {
    public FileUtil() {
    }

    static public String getContents(File aFile) {
        //...checks on aFile are elided
        StringBuffer contents = new StringBuffer();

        //declared here only to make visible to finally clause
        BufferedReader input = null;
        try {
            //use buffering, reading one line at a time
            //FileReader always assumes default encoding is OK!
            input = new BufferedReader(new InputStreamReader(new FileInputStream(aFile), "cp1256"));
            String line = null; //not declared within while loop
            /*
             * readLine is a bit quirky :
             * it returns the content of a line MINUS the newline.
             * it returns null only for the END of the stream.
             * it returns an empty String if two newlines appear in a row.
             */
            while ((line = input.readLine()) != null) {
                contents.append(line);
                contents.append(System.getProperty("line.separator"));
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    //flush and close both "input" and its underlying FileReader
                    input.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return contents.toString();
    }

    static public void saveContents(File aFile, String aContents) throws FileNotFoundException, IOException {
        if (aFile == null) {
            throw new IllegalArgumentException("File should not be null.");
        }
        aFile.createNewFile();

        //declared here only to make visible to finally clause; generic reference
        BufferedWriter output = null;
        try {
            //use buffering
            //FileWriter always assumes default encoding is OK!
            output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aFile), "cp1256"));

            output.write(aContents);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            //flush and close both "output" and its underlying FileWriter
            if (output != null) {
                output.flush();
                output.close();
            }
        }

    }


}
