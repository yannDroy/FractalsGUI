package main.javabrot.gui.colorshades;

import java.awt.Color;

public class PinkYellowPurpleColorShade extends ColorShade {

  //CONSTRUCTOR

  public PinkYellowPurpleColorShade() {
    super();
    
    this.maxColor = Color.BLACK;

    colors.add(new Color(255, 0, 90));
    colors.add(new Color(255, 220, 90));
    colors.add(new Color(255, 185, 0));
    colors.add(new Color(255, 0, 255));
    colors.add(new Color(100, 100, 255));
  }
}
