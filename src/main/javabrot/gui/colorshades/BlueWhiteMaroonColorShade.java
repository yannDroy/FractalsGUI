package main.javabrot.gui.colorshades;

import java.awt.Color;

public class BlueWhiteMaroonColorShade extends ColorShade {

  // METHODS
  
  public Color chooseColor (int n, int max, int numberOfHue) {
    if(n == max){
      return new Color(0, 0, 0);
    }else{
      int nbColors = 5;
      
      n *= (nbColors * 255 * numberOfHue) / max;
      n %= (nbColors * 255);

      if(n <= 255){
        return new Color(0, 0, 60 + newColorValue(n, 0, 255, 100));
      }else if(n <= 255 * 2){
        return new Color(newColorValue(n, 256, 510, 255), newColorValue(n, 256, 510, 255), 160 + newColorValue(n, 256, 510, 95));
      }else if(n <= 255 * 3){
        return new Color(255, 255 - newColorValue(n, 511, 765, 90), 255 - newColorValue(n, 511, 765, 255));
      }else if(n <= 255 * 4){
        return new Color(255 - newColorValue(n, 766, 1020, 165), 165 - newColorValue(n, 766, 1020, 140), newColorValue(n, 766, 1020, 20));
      }else{
        return new Color(90 - newColorValue(n, 1021, 1275, 90), 25 - newColorValue(n, 1021, 1275, 25), 20 + newColorValue(n, 1021, 1275, 40));
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
