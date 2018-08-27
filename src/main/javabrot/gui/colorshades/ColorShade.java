package main.javabrot.gui.colorshades;

import java.awt.Color;

public abstract class ColorShade {

  // CLASS FIELDS

  protected int nbColors;

  // METHODS

  public abstract Color chooseColor (int n, int max, int numberOfHue);
  
  protected static int newColorValue (int value, int oldLow, int oldUp, int newUp) {
    int range = oldUp - oldLow;
    
    value -= oldLow;
    
    return value * newUp / range;
  }

  //GETTERS AND SETTERS

  public int getNbColors() {
    return nbColors;
  }

  public void setNbColors(int nbColors) {
    this.nbColors = nbColors;
  }
}
