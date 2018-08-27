package main.javabrot.gui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import main.javabrot.gui.panel.FractalPanel;
import main.javabrot.gui.panel.InfoPanel;

public class FractalMouseMotionListener implements MouseMotionListener {

  private FractalPanel attached = null;

  public FractalMouseMotionListener (FractalPanel attached) {
    this.attached = attached;
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    int mouseX = e.getX();
    int mouseY = e.getY();

    double xRange = Math.abs(attached.getXmin() - attached.getXmax());
    double yRange = Math.abs(attached.getYmin() - attached.getYmax());

    double xStep = xRange / (double) attached.getWidth();
    double yStep = yRange / (double) attached.getHeight();

    double cursorX = (double) (attached.getXmin() + (mouseX * xStep));
    double cursorY = (double) (attached.getYmin() + (mouseY * yStep));
    
    InfoPanel.getInstance().getCursorLabel().setText(cursorX + "  ;  " + cursorY);
  }

}
