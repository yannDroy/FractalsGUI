package main.javabrot.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import main.javabrot.gui.panel.FractalPanel;
import main.javabrot.gui.panel.InfoPanel;
import main.javabrot.gui.panel.MandelbrotPanel;


public class FractalWindow extends JFrame {

  // CLASS FIELDS
  
  private static final long serialVersionUID = -5264541222905738962L;
  
  private static FractalWindow instance = null;
  
  FractalPanel centerPanel = null;
  OptionsMenu menu = null;
  
  // CONSTRUCTOR

  private FractalWindow() {
    this.setTitle("FractalGUI 1.0");
    this.setSize(IConfigGUI.WINDOW_WIDTH, IConfigGUI.WINDOW_HEIGHT);
    this.setResizable(false);
    this.setLocation(IConfigGUI.WINDOW_POSITOIN_X, IConfigGUI.WINDOW_POSITOIN_Y);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.setLayout(new BorderLayout());
    
    this.centerPanel = new MandelbrotPanel();
    this.menu = new OptionsMenu(centerPanel);
    
    this.add(centerPanel, BorderLayout.CENTER);
    this.setJMenuBar(menu);
    this.add(InfoPanel.getInstance(), BorderLayout.SOUTH);
    
    this.setVisible(true);
  }
  
  // METHODS
  
  public void changeCenterPanel(FractalPanel panel) {
    this.invalidate();
    
    this.getContentPane().remove(centerPanel);
    
    centerPanel = panel;
    menu = new OptionsMenu(centerPanel);
    
    this.add(centerPanel, BorderLayout.CENTER);
    this.setJMenuBar(menu);
    
    this.validate();
  }
  
  // GETTERS AND SETTERS
  
  public static FractalWindow getInstance() {
    if(instance == null){
      instance = new FractalWindow();
    }
    
    return instance;
  }
  
  public FractalPanel getCenterPanel() {
    return centerPanel;
  }

  public void setCenterPanel(FractalPanel centerPanel) {
    this.centerPanel = centerPanel;
  }
  
  // MAIN
  
  public static void main(String[] args) {
    FractalWindow.getInstance();
  }
}
