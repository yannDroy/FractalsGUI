package main.javabrot.gui.panel;

import java.awt.Graphics;

import main.javabrot.domain.Complex;

public class JuliaPanel extends FractalPanel {
  
  // CLASS FIELDS

  private static final long serialVersionUID = -6551578549017357346L;
  
  private Complex constant;
  
  // CONSTRUCTOR
  
  public JuliaPanel(Complex constant) {
    super();
    
    this.constant = constant;
  }
  
  // METHODS
  
  @Override
  public void paint(Graphics g) {
    double x, y;
    double xRange, yRange, xStep, yStep;
    int count;

    x = xmin;
    y = ymin;

    xRange = Math.abs(xmin - xmax);
    yRange = Math.abs(ymin - ymax);

    xStep = xRange / (double) this.getWidth();
    yStep = yRange / (double) this.getHeight();

    for(int i = 0; i < this.getWidth(); i += 1){
      for(int j = 0; j < this.getHeight(); j += 1){
        count = 0;
        
        Complex current = new Complex(x, y);

        while(current.magnitude() < 2 && count < iterations){
          current = Complex.mandelbrot(current, constant);

          count++;
        }

        g.setColor(chooseColor(count));
        g.fillRect(i, j, 1, 1);

        y += yStep;
      }

      x += xStep;
      y = ymin;
    }
  }

  // GETTERS AND SETTERS
  
  public Complex getConstant() {
    return constant;
  }

  public void setC(Complex constant) {
    this.constant = constant;
    
    repaint();
  }
}
