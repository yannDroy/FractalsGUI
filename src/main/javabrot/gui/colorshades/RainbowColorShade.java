package main.javabrot.gui.colorshades;

import java.awt.Color;

public class RainbowColorShade extends ColorShade {

  //CONSTRUCTOR

  public RainbowColorShade() {
    super();
    
    this.maxColor = Color.BLACK;

    colors.add(new Color(0, 0, 255));
    colors.add(new Color(0, 255, 255));
    colors.add(new Color(0, 255, 0));
    colors.add(new Color(255, 255, 0));
    colors.add(new Color(255, 0, 0));
    colors.add(new Color(255, 0, 255));
  }
}
