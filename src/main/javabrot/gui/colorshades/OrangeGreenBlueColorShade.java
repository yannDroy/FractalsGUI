package main.javabrot.gui.colorshades;

import java.awt.Color;

public class OrangeGreenBlueColorShade extends ColorShade {

  // CONSTRUCTOR
  
  public OrangeGreenBlueColorShade() {
    super();
    
    this.maxColor = new Color(0, 0, 130);
    
    colors.add(new Color(255, 165, 0));
    colors.add(new Color(255, 255, 0));
    colors.add(new Color(230, 100, 0));
    colors.add(new Color(0, 255, 0));
  }
}
