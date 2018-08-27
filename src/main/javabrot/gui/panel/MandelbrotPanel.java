package main.javabrot.gui.panel;

import java.awt.Graphics;

import main.javabrot.domain.Complex;

public class MandelbrotPanel extends FractalPanel {

  // CLASS FIELDS

  private static final long serialVersionUID = -3902608439027559684L;

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
        double p = Math.sqrt(((x - 0.25) * (x - 0.25)) + (y * y));

        if(x < (p - (2 * p * p) + 0.25) ||
            ((x + 1) * (x + 1)) + (y * y) < (1 / 16)){
          g.setColor(chooseColor(iterations));
          g.fillRect(i, j, 1, 1);
        }else{
          count = 0;

          Complex current = new Complex(0, 0);
          Complex c = new Complex(x, y);

          while(current.magnitude() < 2 && count < iterations){
            current = Complex.mandelbrot(current, c);

            count++;
          }

          g.setColor(chooseColor(count));
          g.fillRect(i, j, 1, 1);
        }

        y += yStep;
      }

      x += xStep;
      y = ymin;
    }
  }
}
