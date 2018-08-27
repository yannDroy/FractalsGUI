package main.javabrot.gui.colorshades;

import java.awt.Color;

public class RedCyanWhiteColorShade extends ColorShade {

  // METHODS
  
  public Color chooseColor (int n, int max, int numberOfHue) {
    if(n == max){
      return new Color(255, 255, 255);
    }else{
      int nbColors = 4;
      
      n *= (nbColors * 255 * numberOfHue) / max;
      n %= (nbColors * 255);

      if(n <= 255){
        return new Color(145 + newColorValue(n, 0, 255, 100), newColorValue(n, 0, 255, 60), newColorValue(n, 0, 255, 60));
      }else if(n <= 255 * 2){
        return new Color(245, 60 + newColorValue(n, 256, 510, 140), 60 + newColorValue(n, 256, 510, 195));
      }else if(n <= 255 * 3){
        return new Color(245 - newColorValue(n, 511, 765, 245), 200 + newColorValue(n, 511, 765, 55), 255);
      }else{
        return new Color(newColorValue(n, 766, 1020, 145), 255 - newColorValue(n, 766, 1020, 255), 255 - newColorValue(n, 766, 1020, 195));
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
