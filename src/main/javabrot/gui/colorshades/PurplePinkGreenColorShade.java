package main.javabrot.gui.colorshades;

import java.awt.Color;

public class PurplePinkGreenColorShade extends ColorShade {

  // CONSTRUCTOR
  
  public PurplePinkGreenColorShade() {
    super();
    
    this.maxColor = Color.BLACK;
    
    colors.add(new Color(145, 50, 100));
    colors.add(new Color(65, 35, 120));
    colors.add(new Color(255, 230, 255));
    colors.add(new Color(40, 150, 20));
  }
}
