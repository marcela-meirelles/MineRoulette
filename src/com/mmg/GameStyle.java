package com.mmg;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameStyle {
    public static int CELL_SIZE = 20;

    // can use this or ImageIcon
    URL iconURL = getClass().getResource("/some/package/favicon.png");
    // iconURL is null when not found
    ImageIcon icon = new ImageIcon(iconURL);


    public ImageIcon getBlackIcn(){
        ImageIcon icon = new ImageIcon("path//to//image//icon.ico");
        return icon;
    }

    public ImageIcon getWhiteIcn(){
        ImageIcon icon = new ImageIcon("path//to//image//icon.ico");
        return icon;
    }

    public ImageIcon getPossibleIcn(){
        ImageIcon icon = new ImageIcon("path//to//image//icon.ico");
        return icon;
    }

    public ImageIcon getEmptyIcn(){
        ImageIcon icon = new ImageIcon("path//to//image//icon.ico");
        return icon;
    }

}
