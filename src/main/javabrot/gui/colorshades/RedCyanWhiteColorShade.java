package main.javabrot.gui.colorshades;

import java.awt.Color;

public class RedCyanWhiteColorShade extends ColorShade {

  //CONSTRUCTOR

  public RedCyanWhiteColorShade() {
    super();
    
    this.maxColor = Color.WHITE;

    colors.add(new Color(145, 0, 0));
    colors.add(new Color(245, 60, 60));
    colors.add(new Color(0, 255, 255));
    colors.add(new Color(245, 255, 255));
  }
}
