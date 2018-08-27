package main.javabrot.gui.colorshades;

import java.awt.Color;

public class OrangeGreenColorShade extends ColorShade {

  // METHODS
  
  public Color chooseColor (int n, int max, int numberOfHue) {
    if(n == max){
      return new Color(20, 0, 100);
    }else{
      int nbColors = 3;
      
      n *= (nbColors * 255 * numberOfHue) / max;
      n %= (nbColors * 255);

      if(n <= 255){
        return new Color(255, 165 - newColorValue(n, 0, 255, 165), 0);
      }else if(n <= 255 * 2){
        return new Color(255 - newColorValue(n, 256, 510, 255), newColorValue(n, 256, 510, 255), 0);
      }else{
        return new Color(newColorValue(n, 511, 765, 255), 255 - newColorValue(n, 511, 765, 90), 0);
      }
    }
  }

  // GETTERS AND SETTERS
  
  public int getNbColors() {
    return nbColors;
  }

  public void setNbColors(int nbColors) {
    this.nbColors = nbColors;
  }
}
