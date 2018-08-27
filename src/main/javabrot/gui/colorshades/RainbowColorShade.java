package main.javabrot.gui.colorshades;

import java.awt.Color;

public class RainbowColorShade extends ColorShade {

  // METHODS
  
  public Color chooseColor (int n, int max, int numberOfHue) {
    if(n == max){
      return new Color(0, 0, 0);
    }else{
      int nbColors = 6;
      
      n *= (nbColors * 255 * numberOfHue) / max;
      n %= (nbColors * 255);

      if(n <= 255){
        return new Color(0, n, 255);         // blue -> cyan
      }else if(n <= 255 * 2){
        return new Color(0, 255, 510 - n);   // cyan -> green
      }else if(n <= 255 * 3){
        return new Color(n - 510, 255, 0);   // green -> yellow
      }else if(n <= 255 * 4){
        return new Color(255, 1020 - n, 0);  // yellow -> red
      }else if(n <= 255 * 5){
        return new Color(255, 0, n - 1020);  // red -> purple
      }else{
        return new Color(1530 - n, 0, 255);  // purple -> blue
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
