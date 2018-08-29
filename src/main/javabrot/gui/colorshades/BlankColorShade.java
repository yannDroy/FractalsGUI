package main.javabrot.gui.colorshades;

import java.awt.Color;

public class BlankColorShade extends ColorShade {

  // CONSTRUCTOR
  
  public BlankColorShade() {
    super();
    
    this.maxColor = Color.BLACK;
    
    colors.add(new Color(255, 255, 255));
  }
}
