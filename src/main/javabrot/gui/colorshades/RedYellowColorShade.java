package main.javabrot.gui.colorshades;

import java.awt.Color;

public class RedYellowColorShade extends ColorShade {

  //CONSTRUCTOR

  public RedYellowColorShade() {
    super();
    
    this.maxColor = Color.BLACK;
    
    colors.add(new Color(100, 0, 0));
    colors.add(new Color(255, 0, 0));
    colors.add(new Color(255, 195, 0));
  }
}
