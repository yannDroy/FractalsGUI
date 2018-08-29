package main.javabrot.gui.colorshades;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CustomColorShade extends ColorShade {

  //CONSTRUCTOR

  public CustomColorShade(List<Color> colorList) {
    super();

    this.maxColor = Color.BLACK;
    this.colors = new ArrayList<Color>(colorList);
  }
}
