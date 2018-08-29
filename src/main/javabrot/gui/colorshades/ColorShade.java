package main.javabrot.gui.colorshades;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import main.javabrot.gui.FractalWindow;

public abstract class ColorShade {

  // CLASS FIELDS

  public static int MAX_NUMBER_COLORS = 15;
  
  protected Color maxColor;
  protected List<Color> colors;
  
  // CONSTRUCTOR
  
  public ColorShade() {
    this.colors = new ArrayList<Color>();
  }

  // METHODS
  
  public void addColor(Color c) {
    
    FractalWindow.getInstance().getCenterPanel().repaint();
  }
  
  private static int getRescaledValue (int value, int oldLow, int oldUp, int newUp) {
    return ((value - oldLow) * newUp) / (oldUp - oldLow);
  }
  
  private static int getRVBValueBetween (int from, int to, int n, int times255) {
    if(from > to){
      return from - getRescaledValue(n, (255 * (times255 - 1)), (255 * times255), (from - to));
    }else if(from < to){
      return from + getRescaledValue(n, (255 * (times255 - 1)), (255 * times255), (to - from));
    }else{
      return from;
    }
  }
  
  private static Color fromColorToColor (Color a, Color b, int n, int times255) {
    int rA, gA, bA;
    int rB, gB, bB;
    int rOk, gOk, bOk;
    
    rA = a.getRed(); gA = a.getGreen(); bA = a.getBlue();
    rB = b.getRed(); gB = b.getGreen(); bB = b.getBlue();
    
    rOk = getRVBValueBetween(rA, rB, n, times255);
    gOk = getRVBValueBetween(gA, gB, n, times255);
    bOk = getRVBValueBetween(bA, bB, n, times255);
    
    return new Color(rOk, gOk, bOk);
  }
  
  public Color chooseColor (int n, int max, int numberOfHue) {
    if(n == max){
      return maxColor;
    }else{
      n *= (colors.size() * 255 * numberOfHue) / (double) max;
      n %= (colors.size() * 255);
      
      Color toReturn = null;
      
      for(int i = 0; i < colors.size(); i++){
        if(n <= ((i + 1) * 255)){
          toReturn = fromColorToColor(colors.get(i), colors.get((i + 1) % colors.size()), n, (i + 1));
          break;
        }
      }
      
      return toReturn;
    }
  }
  
  //GETTERS AND SETTERS

  public Color getMaxColor() {
    return maxColor;
  }

  public void setMaxColor(Color maxColor) {
    this.maxColor = maxColor;
  }

  public List<Color> getColors() {
    return colors;
  }

  public void setColors(List<Color> colors) {
    this.colors = colors;
  }
}
