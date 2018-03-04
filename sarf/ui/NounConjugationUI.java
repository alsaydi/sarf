package sarf.ui;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import sarf.noun.*;
import sarf.ui.controlpane.*;
import sarf.Action;
import java.io.File;
import java.io.IOException;
import sarf.util.FileUtil;
import java.io.FileNotFoundException;

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
public class NounConjugationUI extends APanel implements NounStateSelectionUIListener ,IHtmlContentSaver  {

    private JPanel conjugationPane;
    private JPanel headerPane;
    List dataFieldsList;
    private String title;

    public NounConjugationUI(sarf.Action sarfAction, INounSuffixContainer nounSuffixContainer, String title) {
        setFont(VerbConjugationUI.FONT);
        this.title = title;

        APanel centerPane = new APanel();
        centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.X_AXIS));

        JPanel rightPane = new JPanel(new GridLayout(3, 1));
        headerPane = new APanel(new GridLayout(1, 4));

        conjugationPane = new JPanel(new GridLayout(3, 1));

        rightPane.add(decorateLabel(new JLabel("«·—›⁄")));
        rightPane.add(decorateLabel(new JLabel("«·‰’»")));
        rightPane.add(decorateLabel(new JLabel("«·Ã—")));

        headerPane.add(decorateLabel(new JLabel()));
        headerPane.add(decorateLabel(new JLabel("„–ﬂ—")));
        headerPane.add(decorateLabel(new JLabel("„ƒ‰À")));

        rightPane.setMaximumSize(new Dimension(100, 700));
        rightPane.setPreferredSize(new Dimension(100, 700));

        headerPane.setMaximumSize(new Dimension(1200, 50));
        headerPane.setPreferredSize(new Dimension(1200, 50));

        centerPane.add(conjugationPane);
        centerPane.add(rightPane);

        JPanel completeHeadPnl = new JPanel();
        completeHeadPnl.setLayout(new BoxLayout(completeHeadPnl, BoxLayout.X_AXIS));
        JLabel lbl = new JLabel();
        lbl.setMaximumSize(new Dimension(134, 50));
        lbl.setPreferredSize(new Dimension(134, 50));
        completeHeadPnl.add(headerPane);
        completeHeadPnl.add(lbl);


        JPanel conjPaneCollapser = new JPanel();
        conjPaneCollapser.setLayout(new BoxLayout(conjPaneCollapser, BoxLayout.Y_AXIS));
        conjPaneCollapser.add(completeHeadPnl);
        conjPaneCollapser.add(centerPane);

        INounStateSelectionUI nounStateSelectionUI = createNounStateSelectionUI(sarfAction, nounSuffixContainer,this);
        nounStateSelectionUI.selectOne();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(conjPaneCollapser);
        add(nounStateSelectionUI.getComponentUI());
    }

    /**
     * be overriden in the child subclasses
     * @param action Action
     * @param nounSuffixContainer INounSuffixContainer
     * @param listener NounStateSelectionUIListener
     * @return JPanel
     */
    protected INounStateSelectionUI createNounStateSelectionUI(Action action, INounSuffixContainer nounSuffixContainer, NounStateSelectionUIListener listener) {
        NounStateSelectionUI nounStateSelectionUI = new NounStateSelectionUI();
        nounStateSelectionUI.init(action, nounSuffixContainer,this);
        return nounStateSelectionUI;
    }

    public NounConjugationUI(sarf.Action sarfAction, String title) {
        this(sarfAction, GenericNounSuffixContainer.getInstance(), title);
    }

    private void displayNounsList(List nouns) {
        StatePanel headerPnl = new StatePanel(false);
        StatePanel pnl2 = new StatePanel(false);
        StatePanel pnl3 = new StatePanel(false);

        for (int i = 0; i < 6; i++) {
            headerPnl.setLabelText(i, nouns.get(i).toString());
        }
        for (int i = 0; i < 6; i++) {
            pnl2.setLabelText(i, nouns.get(i + 6).toString());
        }
        for (int i = 0; i < 6; i++) {
            pnl3.setLabelText(i, nouns.get(i + 12).toString());
        }

        conjugationPane.removeAll();

        //conjugationPane.add(headerPane);
        conjugationPane.add(headerPnl);
        conjugationPane.add(pnl2);
        conjugationPane.add(pnl3);

        conjugationPane.validate();
        conjugationPane.repaint();
    }

    private JLabel decorateLabel(JLabel lbl) {
        lbl.setFont(VerbConjugationUI.FONT);
        lbl.setBorder(VerbConjugationUI.BORDER);
        if (lbl.getText().equals("null")) {
            lbl.setText("");
        }
        lbl.setHorizontalTextPosition(SwingConstants.CENTER);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        return lbl;
    }

    static final Color backgroundcolor2 = new Color(250,231,226);

    private JLabel decorateNounLabel(JLabel lbl) {
        decorateLabel(lbl);
        lbl.setOpaque(true);
        lbl.setBackground(backgroundcolor2);

        return lbl;
    }

    private JLabel decoratePronounLabel(JLabel lbl) {
        decorateLabel(lbl);

        return lbl;
    }

    public void newStateConjugationResultGenerated(List result) {
        displayNounsList(result);
        dataFieldsList = result;
    }

    public boolean saveToHtml(File file) {
        String content = FileUtil.getContents(new File("db/nouns.html"));

        String docTitle = " ’—Ì› "+ " ( "+ title + " ) " +" ··›⁄· "+ " ( "+ ControlPaneContainer.getInstance().getVerbTxtFld().getText() +" )";
        //put the title
        content = content.replaceFirst("DocTitle", docTitle);

        int shift = 0;
        for (int i = 0; i < 6; i++) {
            Object result = dataFieldsList.get(i+shift);
            //&nbsp; means blank in HTML
            String ni = null;
            if (result == null || result.toString().trim().length() == 0)
                ni = "&nbsp;";
            else
                ni = result.toString();

            //NounT noun top of table
            content = content.replaceFirst("NounT" + i, ni);
        }

        shift = 6;
        for (int i = 0; i < 6; i++) {
            Object result = dataFieldsList.get(i+shift);
            String ni = null;
            if (result == null || result.toString().trim().length() == 0)
                ni = "&nbsp;";
            else
                ni = result.toString();

            //NounM noun middle of table
            content = content.replaceFirst("NounM" + i, ni);
        }

        shift = 12;
        for (int i = 0; i < 6; i++) {
            Object result = dataFieldsList.get(i+shift);
            String ni = null;
            if (result == null || result.toString().trim().length() == 0)
                ni = "&nbsp;";
            else
                ni = result.toString();

            //NounM noun bottom of table
            content = content.replaceFirst("NounB" + i, ni);
        }

        try {
            FileUtil.saveContents(file, content);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }



    class StatePanel extends JPanel {
        List labelList = new ArrayList(6);

        StatePanel(boolean isHeader) {
            setFont(VerbConjugationUI.FONT);
            setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

            if (isHeader) {
                setLayout(new GridLayout(4, 3));
                add(decoratePronounLabel(new JLabel()));
                add(decoratePronounLabel(new JLabel("„–ﬂ—")));
                add(decoratePronounLabel(new JLabel("„ƒ‰À")));
            }
            else {
                setLayout(new GridLayout(3, 3));
            }

            add(decoratePronounLabel(new JLabel("„›—œ")));

            JLabel lbl = new JLabel();
            add(lbl);
            decorateNounLabel(lbl);
            labelList.add(lbl);
            lbl = new JLabel();
            add(lbl);
            decorateNounLabel(lbl);
            labelList.add(lbl);

            add(decoratePronounLabel(new JLabel("„À‰Ï")));

            lbl = new JLabel();
            add(lbl);
            labelList.add(lbl);
            decorateNounLabel(lbl);
            lbl = new JLabel();
            add(lbl);
            decorateNounLabel(lbl);
            labelList.add(lbl);

            add(decoratePronounLabel(new JLabel("Ã„⁄")));

            lbl = new JLabel();
            add(lbl);
            decorateNounLabel(lbl);
            labelList.add(lbl);
            lbl = new JLabel();
            add(lbl);
            decorateNounLabel(lbl);
            labelList.add(lbl);
        }

        public void setLabelText(int index, String text) {
            ((JLabel) labelList.get(index)).setText(text);
        }
    }

    public String getSavedFileNameTitle() {
        return " ’—Ì› "+ " "+ title + " " +" ··›⁄· "+ "  "+ ControlPaneContainer.getInstance().getVerbTxtFld().getText();
    }

}
