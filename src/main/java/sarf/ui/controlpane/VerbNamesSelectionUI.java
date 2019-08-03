package sarf.ui.controlpane;

import javax.swing.*;

import com.google.inject.Inject;
import sarf.ui.*;
import java.awt.*;
import java.awt.event.*;

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
public class VerbNamesSelectionUI extends JPanel implements IControlPane {

	private static final long serialVersionUID = 276620070251792482L;
    private final ControlPaneContainer controlPaneContainer;
    private SelectionInfo selectionInfo;

	@Inject
    public VerbNamesSelectionUI(ControlPaneContainer controlPaneContainer) {
        super(new BorderLayout());
        this.controlPaneContainer = controlPaneContainer;

        JPanel buttonsPanel = new APanel(new GridLayout(1, 4));

        JButton activeVerbBtn = new RenderedButton("الأفعال المبنية للمعلوم");
        JButton passiveVerbBtn = new RenderedButton("الأفعال المبنية للمجهول");
        JButton derivedNamesBtn = new RenderedButton("الأسماء المشتقة");
        JButton gerundBtn = new RenderedButton("المصادر");

        buttonsPanel.add(activeVerbBtn);
        buttonsPanel.add(passiveVerbBtn);
        buttonsPanel.add(derivedNamesBtn);
        buttonsPanel.add(gerundBtn);

        add(buttonsPanel);

        activeVerbBtn.addActionListener(e -> {
            ActiveVerbSelectionUI verbSelectionUI = (ActiveVerbSelectionUI) controlPaneContainer.openControlPane(ActiveVerbSelectionUI.class);
            verbSelectionUI.setInfo(selectionInfo);
        });

        passiveVerbBtn.addActionListener(e -> {
            PassiveVerbSelectionUI verbSelectionUI = (PassiveVerbSelectionUI) controlPaneContainer.openControlPane(PassiveVerbSelectionUI.class);
            verbSelectionUI.setInfo(selectionInfo);
        });

        derivedNamesBtn.addActionListener(e -> {
            if (selectionInfo.isTrilateral() && !selectionInfo.isAugmented()) {
                TrilateralUnaugmentedNounsUI nounsUI = (TrilateralUnaugmentedNounsUI) controlPaneContainer.openControlPane(TrilateralUnaugmentedNounsUI.class);
                nounsUI.setInfo(selectionInfo);
            }
            else {
                NamesSelectionUI namesSelectionUI = (NamesSelectionUI) controlPaneContainer.openControlPane(NamesSelectionUI.class);
                namesSelectionUI.setInfo(selectionInfo);
            }
        });

        gerundBtn.addActionListener(e -> {
            if (selectionInfo.isTrilateral() && !selectionInfo.isAugmented()) {
                TrilateralUnaugmentedGerundsUI gerundSelectionUI = (TrilateralUnaugmentedGerundsUI) controlPaneContainer.openControlPane(TrilateralUnaugmentedGerundsUI.class);
                try {
                    gerundSelectionUI.setInfo(selectionInfo);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            else {
                GerundSelectionUI gerundSelectionUI = (GerundSelectionUI) controlPaneContainer.openControlPane(GerundSelectionUI.class);
                gerundSelectionUI.setInfo(selectionInfo);
            }
        });


    }

    public JComponent getComponent() {
        return this;
    }

    void setInfo(SelectionInfo selectionInfo) {
        this.selectionInfo = selectionInfo;
    }

    private boolean opened = false;
    public void controlPaneOpened() {
        opened = true;
    }


    public void controlPaneClosed() {
        opened = false;
    }

}
