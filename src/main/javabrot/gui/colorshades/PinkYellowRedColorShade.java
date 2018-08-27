package main.javabrot.gui.colorshades;

import java.awt.Color;

public class PinkYellowRedColorShade extends ColorShade {

  // METHODS
  
  public Color chooseColor (int n, int max, int numberOfHue) {
    if(n == max){
      return new Color(0, 0, 0);
    }else{
      int nbColors = 5;
      
      n *= (nbColors * 255 * numberOfHue) / max;
      n %= (nbColors * 255);

      if(n <= 255){
        return new Color(255, newColorValue(n, 0, 255, 220), 90);
      }else if(n <= 255 * 2){
        return new Color(255, 220 - newColorValue(n, 256, 510, 35), 90 - newColorValue(n, 256, 510, 90));
      }else if(n <= 255 * 3){
        return new Color(255, 185 - newColorValue(n, 511, 765, 185), 0);
      }else if(n <= 255 * 4){
        return new Color(255, 0, newColorValue(n, 766, 1020, 255));
      }else{
        return new Color(255, 0, 255 - newColorValue(n, 1021, 1275, 155));
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
