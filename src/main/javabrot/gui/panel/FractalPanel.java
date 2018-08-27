package main.javabrot.gui.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import main.javabrot.gui.colorshades.ColorShade;
import main.javabrot.gui.colorshades.RainbowColorShade;
import main.javabrot.gui.listener.FractalMouseListener;
import main.javabrot.gui.listener.FractalMouseMotionListener;
import main.javabrot.gui.listener.FractalMouseWheelListener;

public abstract class FractalPanel extends JPanel {
  
  // CLASS FIELDS
  
  private static final long serialVersionUID = 4448988517932344359L;

  public static final int MAX_ZOOM = 44;
  public static final int MIN_ZOOM = -2;
  public static final int MAX_DEFINITION = 30;

  protected int iterations = 300;
  
  protected int zoom = 0;

  protected double xmin = -2;
  protected double xmax = 2;
  protected double ymin = -2;
  protected double ymax = 2;

  protected int numberOfHue = 3;
  
  protected ColorShade colorShade;
  
  // CONSTRUCTOR
  
  public FractalPanel() {
    this.addMouseMotionListener(new FractalMouseMotionListener(this));
    this.addMouseListener(new FractalMouseListener(this));
    this.addMouseWheelListener(new FractalMouseWheelListener(this));
    
    colorShade = new RainbowColorShade();
  }
  
  // METHODS
  
  @Override
  public abstract void paint(Graphics g);
  
  public void resetView() {
    zoom = 0;
    InfoPanel.getInstance().getZoomLabel().setText("Zoom: 0");

    xmin = -2;
    xmax = 2;
    ymin = -2;
    ymax = 2;

    repaint();
  }
  
  public void goToPointClick(double x, double y) {
    double xRange = Math.abs(xmin - xmax);
    double yRange = Math.abs(ymin - ymax);

    double xStep = xRange / (double) getWidth();
    double yStep = yRange / (double) getHeight();

    double pointX = (double) (xmin + (x * xStep));
    double pointY = (double) (ymin + (y * yStep));
    
    if(Math.abs(pointX) <= 2 && Math.abs(pointY) <= 2){
      xmin = pointX - (xRange / 2);
      xmax = pointX + (xRange / 2);
      ymin = pointY - (yRange / 2);
      ymax = pointY + (yRange / 2);

      repaint();
    }
  }
  
  public void goToPointMenu(double x, double y) {
    double xRange = Math.abs(xmin - xmax);
    double yRange = Math.abs(ymin - ymax);
    
    if(Math.abs(x) <= 2 && Math.abs(y) <= 2){
      xmin = x - (xRange / 2);
      xmax = x + (xRange / 2);
      ymin = y - (yRange / 2);
      ymax = y + (yRange / 2);

      repaint();
    }
  }
  
  public void changeNumberOfHue (int n) {
    this.numberOfHue = n;
    repaint();
  }

  public void changeIterations (int iterations) {
    this.iterations = iterations;
    repaint();
  }

  public void changeColorShade (ColorShade cs) {
    this.colorShade = cs;
    repaint();
  }
  
  public void changeZoom (int zoom) {
    int centerX = getWidth() / 2;
    int centerY = getHeight() / 2;

    double xRange = Math.abs(xmin - xmax);
    double yRange = Math.abs(ymin - ymax);

    double xStep = xRange / (double) getWidth();
    double yStep = yRange / (double) getHeight();

    double zoomToX = (double) (xmin + (centerX * xStep));
    double zoomToY = (double) (ymin + (centerY * yStep));

    if(this.zoom < zoom){
      if(zoom < MAX_ZOOM){
        xmin = zoomToX - (xRange / 4);
        xmax = zoomToX + (xRange / 4);
        ymin = zoomToY - (yRange / 4);
        ymax = zoomToY + (yRange / 4);

        this.zoom = zoom;

        repaint();
        InfoPanel.getInstance().getZoomLabel().setText("Zoom: " + zoom);
      }
    }else if(this.zoom > zoom){
      if(this.zoom > MIN_ZOOM){
        this.xmin = zoomToX - xRange;
        this.xmax = zoomToX + xRange;
        this.ymin = zoomToY - yRange;
        this.ymax = zoomToY + yRange;

        this.zoom = zoom;
        
        repaint();
        InfoPanel.getInstance().getZoomLabel().setText("Zoom: " + zoom);
      }
    }
  }
  
  protected Color chooseColor (int n) {
    return colorShade.chooseColor(n, iterations, numberOfHue);
  }
  
  // GETTERS AND SETTERS

  public int getIterations() {
    return iterations;
  }

  public void setIterations(int iterations) {
    this.iterations = iterations;
  }

  public int getZoom() {
    return zoom;
  }

  public void setZoom(int zoom) {
    this.zoom = zoom;
  }

  public double getXmin() {
    return xmin;
  }

  public void setXmin(double xmin) {
    this.xmin = xmin;
  }

  public double getXmax() {
    return xmax;
  }

  public void setXmax(double xmax) {
    this.xmax = xmax;
  }

  public double getYmin() {
    return ymin;
  }

  public void setYmin(double ymin) {
    this.ymin = ymin;
  }

  public double getYmax() {
    return ymax;
  }

  public void setYmax(double ymax) {
    this.ymax = ymax;
  }

  public int getNumberOfHue() {
    return numberOfHue;
  }

  public void setNumberOfHue(int numberOfHue) {
    this.numberOfHue = numberOfHue;
  }

  public ColorShade getColorShade() {
    return colorShade;
  }

  public void setColorShade(ColorShade colorShade) {
    this.colorShade = colorShade;
  }
}
