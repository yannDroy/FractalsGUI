package main.javabrot.gui.colorshades;

import java.awt.Color;

public class BlueGreenPinkColorShade extends ColorShade {

  // CONSTRUCTOR
  
  public BlueGreenPinkColorShade() {
    super();
    
    this.maxColor = Color.BLACK;
    
    
     colors.add(new Color(60, 60, 60));
     colors.add(new Color(0, 0, 120));
     colors.add(new Color(180, 255, 120));
     colors.add(new Color(255, 200, 230));
  }
}
