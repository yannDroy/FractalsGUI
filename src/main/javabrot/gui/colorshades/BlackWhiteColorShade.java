package main.javabrot.gui.colorshades;

import java.awt.Color;

public class BlackWhiteColorShade extends ColorShade {

  //CONSTRUCTOR

  public BlackWhiteColorShade() {
    super();
    
    this.maxColor = Color.BLACK;

    colors.add(Color.BLACK);
    colors.add(Color.WHITE);
    ;
  }
}
