package main.javabrot.gui.colorshades;

import java.awt.Color;

public class GreyBlackBlueColorShade extends ColorShade {

  // CONSTRUCTOR

  public GreyBlackBlueColorShade() {
    super();

    this.maxColor = Color.WHITE;

    colors.add(new Color(120, 120, 120));
    colors.add(new Color(30, 30, 30));
    colors.add(new Color(60, 110, 200));
  }
}
