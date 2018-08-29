package main.javabrot.gui.colorshades;

import java.awt.Color;

public class BlueWhiteBrownColorShade extends ColorShade {

  //CONSTRUCTOR

  public BlueWhiteBrownColorShade() {
    super();

    this.maxColor = Color.BLACK;

    colors.add(new Color(0, 0, 60));
    colors.add(new Color(255, 255, 255));
    colors.add(new Color(255, 165, 0));
    colors.add(new Color(90, 25, 20));
  }
}
