package main.javabrot.gui.panel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

  // CLASS FIELDS
  
  private static final long serialVersionUID = -5378872058978559576L;
  
  private static InfoPanel instance = null;
  
  private JLabel zoomLabel;
  //private JLabel centerLabel;
  private JLabel cursorLabel;
  
  // CONSTRUCTOR
  
  private InfoPanel() {
    zoomLabel = new JLabel("Zoom: 0");
    //centerLabel = new JLabel("Center: ");
    cursorLabel = new JLabel("Cursor: 0 ; 0");
    
    this.setLayout(new FlowLayout());
    
    //this.add(centerLabel);
    this.add(cursorLabel);
    this.add(zoomLabel);
  }
  
  // GETTERS AND SETTERS
  
  public static InfoPanel getInstance() {
    if(instance == null){
      instance = new InfoPanel();
    }
    return instance;
  }

  public JLabel getZoomLabel() {
    return zoomLabel;
  }

  public void setZoomLabel(JLabel zoomLabel) {
    this.zoomLabel = zoomLabel;
  }

  /*public JLabel getCenterLabel() {
    return centerLabel;
  }*/

  /*public void setCenterLabel(JLabel centerLabel) {
    this.centerLabel = centerLabel;
  }*/

  public JLabel getCursorLabel() {
    return cursorLabel;
  }

  public void setCursorLabel(JLabel cursorLabel) {
    this.cursorLabel = cursorLabel;
  }

}
