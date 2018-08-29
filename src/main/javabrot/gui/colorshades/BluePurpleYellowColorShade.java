package main.javabrot.gui.colorshades;

import java.awt.Color;

public class BluePurpleYellowColorShade extends ColorShade {

  // CONSTRUCTOR
  
  public BluePurpleYellowColorShade() {
    super();
    
    this.maxColor = new Color(245, 240, 145);
    
    colors.add(new Color(70, 165, 240));
    colors.add(new Color(30, 30, 235));
    colors.add(new Color(195, 60, 225));
    colors.add(new Color(245, 195, 20));
  }
}
