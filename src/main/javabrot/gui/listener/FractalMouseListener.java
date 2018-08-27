package main.javabrot.gui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import main.javabrot.gui.panel.FractalPanel;

public class FractalMouseListener implements MouseListener {

  private FractalPanel attached = null;

  public FractalMouseListener (FractalPanel attached) {
    this.attached = attached;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if(e.getButton() == MouseEvent.BUTTON1){
      attached.goToPointClick(e.getX(), e.getY());
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }
}
