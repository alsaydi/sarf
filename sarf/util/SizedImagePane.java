package sarf.util;

import java.awt.Graphics;
import java.net.URL;
import java.awt.MediaTracker;
import java.awt.Image;
import javax.swing.JPanel;

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
public class SizedImagePane extends JPanel {
    protected Image image;

    public SizedImagePane() {
    }

    public SizedImagePane(String file) {

        setImage(getToolkit().getImage(file));
    }

    public SizedImagePane(URL url) {
        setImage(getToolkit().getImage(url));
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(image, 0);
        try {
            mt.waitForAll();
        }
        catch (InterruptedException ep) {}
        //setPreferredSize(new Dimension(image.getWidth(this),image.getHeight(this)));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - image.getWidth(null))/2;
        int y = (getHeight() - image.getHeight(null))/2;
        g.drawImage(image, x, y, image.getWidth(null), image.getHeight(null), this);
    }

}
