package xml;

import java.io.*;
import xml.*;
import sarf.util.*;
import java.sql.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class XmlDataGenerator {
    public XmlDataGenerator() {
    }

    public static void generateTrilateralUnaugmented() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("TripleUnaugmented");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/trilateral/unaugmented/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("roots", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("root");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    rootElement.addAttribute("conjugation", resultSet.getString("noc"));
                    rootElement.addAttribute("transitive", resultSet.getString("T"));
                    rootElement.closeStartTag();

                    for (int i = 1; i <= 8; i++) {
                        String gerundSymbol = resultSet.getString("S" + i);
                        if (gerundSymbol != null && gerundSymbol != "") {
                            XmlElement gerundElement = rootElement.addElement("gerund");
                            gerundElement.addAttribute("symbol", gerundSymbol);
                            gerundElement.addAttribute("value", resultSet.getString("G" + i));
                            gerundElement.closeStartAndEndTag();
                            //rootElement.addDataElement("infinitive", infinitiveSymbol);
                        }
                    }

                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateTrilateralAugmented() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("TripleAugmented");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/trilateral/augmented/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("roots", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("root");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    rootElement.closeStartTag();

                    for (int i = 1; i <= 12; i++) {
                        String transitive = resultSet.getString("F" + i);
                        if (transitive != null && transitive != "" && !transitive.equals(".")) {
                            XmlElement infElement = rootElement.addElement("augmentationFormula");
                            infElement.addAttribute("formulaNo", i + "");
                            infElement.addAttribute("transitive", transitive);
                            infElement.closeStartAndEndTag();
                        }
                    }

                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateQuadriliteralUnaugmented() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("QuadriliteralUnaugmented");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/quadriliteral/unaugmented/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("roots", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("root");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    rootElement.addAttribute("c4", resultSet.getString("c4"));
                    rootElement.addAttribute("transitive", resultSet.getString("transitivity"));
                    rootElement.closeStartTag();

                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateNounDB(String dbName, String folderName) throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter(dbName);
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/noun/" + folderName + "/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("formulas", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("formula");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    rootElement.addAttribute("example", resultSet.getString(4));
                    rootElement.addAttribute("pattern", resultSet.getString(5));
                    rootElement.closeStartTag();

                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateAssimilateAdjective() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("assimilate");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/noun/assimilate/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("formulas", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("formula");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));

                    rootElement.addAttribute("conjugation", resultSet.getString("noc"));
                    String adj1 = resultSet.getString("adj1");
                    String adj2 = resultSet.getString("adj2");
                    String adj3 = resultSet.getString("adj3");

                    adj1 = adj1 == null ? "" : adj1;
                    adj2 = adj2 == null ? "" : adj2;
                    adj3 = adj3 == null ? "" : adj3;

                    rootElement.addAttribute("adj1", adj1);
                    rootElement.addAttribute("adj2", adj2);
                    rootElement.addAttribute("adj3", adj3);
                    rootElement.closeStartTag();

                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateElativeNouns() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("elative");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/noun/elative/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("formulas", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("formula");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    rootElement.closeStartTag();

                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateInstrumentalNouns() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("instrumental");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/noun/instrumental/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("formulas", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("formula");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    String form1 = resultSet.getString("form1");
                    if (form1 != null)
                        rootElement.addAttribute("form1", form1);
                    else
                        rootElement.addAttribute("form1", "");

                    String form2 = resultSet.getString("form2");
                    if (form2 != null)
                        rootElement.addAttribute("form2", form2);
                    else
                        rootElement.addAttribute("form2", "");

                    rootElement.closeStartTag();
                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateExaggerationNouns() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("ex");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/noun/exaggeration/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("formulas", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("formula");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    String form1 = resultSet.getString("form1");
                    if (form1 != null)
                        rootElement.addAttribute("form1", form1);
                    else
                        rootElement.addAttribute("form1", "");

                    String form2 = resultSet.getString("form2");
                    if (form2 != null)
                        rootElement.addAttribute("form2", form2);
                    else
                        rootElement.addAttribute("form2", "");

                    String form3 = resultSet.getString("form3");
                    if (form3 != null)
                        rootElement.addAttribute("form3", form3);
                    else
                        rootElement.addAttribute("form3", "");


                    rootElement.closeStartTag();
                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void generateTimeAndPlaceNouns() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("timeandplace");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/noun/timeandplace/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("formulas", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("formula");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    rootElement.addAttribute("noc", resultSet.getString("noc"));
                    String form1 = resultSet.getString("form1");
                    if (form1 != null)
                        rootElement.addAttribute("form1", form1);
                    else
                        rootElement.addAttribute("form1", "");

                    String form2 = resultSet.getString("form2");
                    if (form2 != null)
                        rootElement.addAttribute("form2", form2);
                    else
                        rootElement.addAttribute("form2", "");

                    rootElement.closeStartTag();
                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }




    public static void generateQuadriliteralAugmented() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("QuadriliteralAugmented");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/quadriliteral/augmented/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("roots", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("root");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    rootElement.addAttribute("c4", resultSet.getString("c4"));
                    rootElement.closeStartTag();

                    for (int i = 1; i <= 3; i++) {
                        String transitive = resultSet.getString("F" + i);
                        if (transitive != null && transitive != "" && !transitive.equals(".")) {
                            XmlElement infElement = rootElement.addElement("augmentationFormula");
                            infElement.addAttribute("formulaNo", i + "");
                            infElement.addAttribute("transitive", transitive);
                            infElement.closeStartAndEndTag();
                        }
                    }

                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateMeemGerunds() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("meem");
        ResultSet charsResultSet = queryExecuter.executeQuery("Select distinct c1 from Base");
        try {
            while (charsResultSet.next()) {
                String c1 = charsResultSet.getString(1);
                PrintStream out = new PrintStream(new FileOutputStream("C:/sarf/gerund/meem/" + c1 + ".xml"));
                //for arabic supported xml
                out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

                XmlElement rootsElement = new DefaultXmlElement("formulas", out);
                rootsElement.closeStartTag();

                ResultSet resultSet = queryExecuter.executeQuery("Select * from Base where c1='" + c1 + "'");
                while (resultSet.next()) {
                    XmlElement rootElement = rootsElement.addElement("formula");

                    rootElement.addAttribute("c1", c1);
                    rootElement.addAttribute("c2", resultSet.getString("c2"));
                    rootElement.addAttribute("c3", resultSet.getString("c3"));
                    String symbol1 = resultSet.getString("symbol1");
                    if (symbol1 != null) {
                        rootElement.addAttribute("symbol1", symbol1);
                        rootElement.addAttribute("gerund1", resultSet.getString("gerund1"));
                    }
                    else {
                        rootElement.addAttribute("symbol1", "");
                        rootElement.addAttribute("gerund1", "");
                    }

                    String symbol2 = resultSet.getString("symbol2");
                    if (symbol2 != null) {
                        rootElement.addAttribute("symbol2", symbol2);
                        rootElement.addAttribute("gerund2", resultSet.getString("gerund2"));
                    }
                    else {
                        rootElement.addAttribute("symbol2", "");
                        rootElement.addAttribute("gerund2", "");
                    }



                    rootElement.closeStartTag();
                    rootElement.close();
                }

                rootsElement.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void generateGerundDescription() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("gerund");
        ResultSet resultSet = queryExecuter.executeQuery("Select * from Base");
        try {
            PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/gerund/GerundDescription.xml"));
            //for arabic supported xml
            out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

            XmlElement rootsElement = new DefaultXmlElement("gerunds", out);
            rootsElement.closeStartTag();

            while (resultSet.next()) {
                String symbol = resultSet.getString("s");
                String pattern = resultSet.getString("p");
                XmlElement rootElement = rootsElement.addElement("gerund");

                rootElement.addAttribute("symbol", symbol);
                rootElement.addAttribute("pattern", pattern);
                rootElement.closeStartTag();

                rootElement.close();
            }

            rootsElement.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateKov() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("kov");
        ResultSet resultSet = queryExecuter.executeQuery("Select * from Base");
        try {
            PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/TrilateralKov.xml"));
            //for arabic supported xml
            out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

            XmlElement rootsElement = new DefaultXmlElement("rules", out);
            rootsElement.closeStartTag();

            while (resultSet.next()) {
                XmlElement rootElement = rootsElement.addElement("rule");

                rootElement.addAttribute("c1", resultSet.getString("c1"));
                rootElement.addAttribute("c2", resultSet.getString("c2"));
                rootElement.addAttribute("c3", resultSet.getString("c3"));
                rootElement.addAttribute("kov", resultSet.getString("kov"));
                rootElement.addAttribute("desc", resultSet.getString("desc"));
                rootElement.addAttribute("example", resultSet.getString("example"));

                rootElement.closeStartTag();

                rootElement.close();
            }

            rootsElement.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void generateQuadKov() throws FileNotFoundException {
        QueryExecuter queryExecuter = new QueryExecuter("kov4");
        ResultSet resultSet = queryExecuter.executeQuery("Select * from Base");
        try {
            PrintStream out = new PrintStream(new FileOutputStream("c:/sarf/Quadrilateralkov.xml"));
            //for arabic supported xml
            out.println("<?xml version=\"1.0\" encoding=\"windows-1256\" ?>");

            XmlElement rootsElement = new DefaultXmlElement("rules", out);
            rootsElement.closeStartTag();

            while (resultSet.next()) {
                XmlElement rootElement = rootsElement.addElement("rule");

                rootElement.addAttribute("c1", resultSet.getString("c1"));
                rootElement.addAttribute("c2", resultSet.getString("c2"));
                rootElement.addAttribute("c3", resultSet.getString("c3"));
                rootElement.addAttribute("c4", resultSet.getString("c4"));
                rootElement.addAttribute("kov", resultSet.getString("kov"));
                rootElement.addAttribute("desc", resultSet.getString("desc"));
                rootElement.addAttribute("example", resultSet.getString("example"));

                rootElement.closeStartTag();

                rootElement.close();
            }

            rootsElement.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }




    public static void main(String[] args) throws FileNotFoundException {
        //generateNounDB("noundb","exaggeration");
//        generateAssimilateAdjective();
//        generateElativeNouns();
//        generateInstrumentalNouns();
//        generateTimeAndPlaceNouns();
//        generateExaggerationNouns();
  //      generateQuadriliteralUnaugmented();
    //    generateQuadriliteralAugmented();
     //   generateTrilateralAugmented();
        generateTrilateralUnaugmented();
//        generateGerundDescription();
        //generateKov();
        //generateQuadKov();
//        generateMeemGerunds();
    }

}
