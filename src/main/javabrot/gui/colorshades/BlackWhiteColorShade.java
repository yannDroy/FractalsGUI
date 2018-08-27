package main.javabrot.gui.colorshades;

import java.awt.Color;

public class BlackWhiteColorShade extends ColorShade {

  // METHODS

  public Color chooseColor (int n, int max, int numberOfHue) {
    if(n == max){
      return Color.BLACK;
    }else{
      int nbColors = 2;
      
      n *= (nbColors * 255 * numberOfHue) / max;
      n %= (nbColors * 255);

      if(n < 255){
        return new Color(n, n, n);
      }else{
        return new Color(510 - n, 510 - n, 510 - n);
      }
    }
  }
}
