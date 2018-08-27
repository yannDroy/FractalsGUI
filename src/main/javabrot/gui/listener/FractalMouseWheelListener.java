package main.javabrot.gui.listener;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import main.javabrot.gui.panel.FractalPanel;

public class FractalMouseWheelListener implements MouseWheelListener {
  
  private FractalPanel attached = null;
  
  public FractalMouseWheelListener (FractalPanel attached) {
    this.attached = attached;
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    if(e.getWheelRotation() < 0){
      attached.changeZoom(attached.getZoom() + 1);
    }else{
      attached.changeZoom(attached.getZoom() - 1);
    }
  }

}
