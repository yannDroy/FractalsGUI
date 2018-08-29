package main.javabrot.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.javabrot.domain.Complex;
import main.javabrot.gui.colorshades.RainbowColorShade;
import main.javabrot.gui.colorshades.RedYellowColorShade;
import main.javabrot.gui.colorshades.BlackWhiteColorShade;
import main.javabrot.gui.colorshades.BlankColorShade;
import main.javabrot.gui.colorshades.BluePurpleYellowColorShade;
import main.javabrot.gui.colorshades.BlueWhiteBrownColorShade;
import main.javabrot.gui.colorshades.CustomColorShade;
import main.javabrot.gui.colorshades.GreyBlackBlueColorShade;
import main.javabrot.gui.colorshades.BlueGreenPinkColorShade;
import main.javabrot.gui.colorshades.OrangeGreenBlueColorShade;
import main.javabrot.gui.colorshades.PinkYellowPurpleColorShade;
import main.javabrot.gui.colorshades.PurplePinkGreenColorShade;
import main.javabrot.gui.colorshades.RedCyanWhiteColorShade;
import main.javabrot.gui.panel.ColorShadeCreationPanel;
import main.javabrot.gui.panel.FractalPanel;
import main.javabrot.gui.panel.HandSpinnerPanel;
import main.javabrot.gui.panel.JuliaPanel;
import main.javabrot.gui.panel.LeafPanel;
import main.javabrot.gui.panel.MandelbrotCubedPanel;
import main.javabrot.gui.panel.MandelbrotPanel;
import main.javabrot.gui.panel.MandelbrotToTheSixPanel;
import main.javabrot.gui.panel.WeirdMandelbrotPanel;

public class OptionsMenu extends JMenuBar {

  // CLASS FIELDS

  private static final long serialVersionUID = -3716294727443916233L;

  private JMenu viewMenu = null;
  private JMenu mathMenu = null;

  private JMenuItem resetViewItem = null;
  private JMenuItem colorShadeMenuItem = null;
  private JMenuItem createColorShadeMenuItem = null;

  private JSlider iterationsMenuItem = null;
  private JSlider hueMenuItem = null;

  private JMenuItem goToPointItem = null;
  private JMenuItem changeFunctionItem = null;
  private JMenuItem changeJuliaC = null;

  // CONSTRUCTOR

  public OptionsMenu(FractalPanel panel) {   
    this.viewMenu = new JMenu("View");
    this.viewMenu.setMnemonic(KeyEvent.VK_V);
    this.viewMenu.getAccessibleContext().setAccessibleDescription(
        "Menu for view parameters");
    this.add(viewMenu);

    resetViewItem = new JMenuItem("Reset view");
    resetViewItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        panel.resetView();
      }
    });
    viewMenu.add(resetViewItem);
    
    viewMenu.addSeparator();

    colorShadeMenuItem = new JMenuItem("Change color shade");
    colorShadeMenuItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] functions = {"Rainobw",
            "Blank",
            "Blue, white and brown", "Pink, yellow and purple", "Red, cyan and white",
            "Purple, pink and green", "Orange, green and blue", "Blue, purple and yellow",
            "Grey, black and blue", "Grey, green and pink", "Red and yellow",
            "Black and white",
            };

        String shade = (String) JOptionPane.showInputDialog(
            null,
            "Color shades list:",
            "Please choose the color shade",
            JOptionPane.PLAIN_MESSAGE,
            null,
            functions,
            functions[0]);

        if((shade != null) && (shade.length() > 0)) {
          switch(shade){
          case "Pink, yellow and purple":
            FractalWindow.getInstance().changeColorShade(new PinkYellowPurpleColorShade());
            break;
          case "Grey, black and blue":
            FractalWindow.getInstance().changeColorShade(new GreyBlackBlueColorShade());
            break;
          case "Grey, green and pink":
            FractalWindow.getInstance().changeColorShade(new BlueGreenPinkColorShade());
            break;
          case "Blue, white and brown":
            FractalWindow.getInstance().changeColorShade(new BlueWhiteBrownColorShade());
            break;
          case "Red, cyan and white":
            FractalWindow.getInstance().changeColorShade(new RedCyanWhiteColorShade());
            break;
          case "Blue, purple and yellow":
            FractalWindow.getInstance().changeColorShade(new BluePurpleYellowColorShade());
            break;
          case "Orange, green and blue":
            FractalWindow.getInstance().changeColorShade(new OrangeGreenBlueColorShade());
            break;
          case "Purple, pink and green":
            FractalWindow.getInstance().changeColorShade(new PurplePinkGreenColorShade());
            break;
          case "Red and yellow":
            FractalWindow.getInstance().changeColorShade(new RedYellowColorShade());
            break;
          case "Black and white":
            FractalWindow.getInstance().changeColorShade(new BlackWhiteColorShade());
            break;
          case "Blank":
            FractalWindow.getInstance().changeColorShade(new BlankColorShade());
            break;
          default:
            FractalWindow.getInstance().changeColorShade(new RainbowColorShade());
          }
        }
      }
    });
    viewMenu.add(colorShadeMenuItem);
    
    createColorShadeMenuItem = new JMenuItem("Create new color shade");
    createColorShadeMenuItem.addActionListener(new ActionListener() {  
      @Override
      public void actionPerformed(ActionEvent e) {
        
        ColorShadeCreationPanel myPanel = new ColorShadeCreationPanel();

        int result = JOptionPane.showConfirmDialog(null, myPanel, 
            "New color shade creation", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION) {
          if(myPanel.getColors().size() <= 0){
            JOptionPane.showMessageDialog(
                null, "The color shade should contain at least one color", "Error", JOptionPane.ERROR_MESSAGE);
          }else{
            CustomColorShade custom = new CustomColorShade(myPanel.getColors());
            FractalWindow.getInstance().changeColorShade(custom);
          }
        }
      }
    });
    viewMenu.add(createColorShadeMenuItem);

    viewMenu.addSeparator();

    iterationsMenuItem = new JSlider(JSlider.HORIZONTAL, 0, 50, (panel.getIterations() / 100));
    iterationsMenuItem.setMajorTickSpacing(10);
    iterationsMenuItem.setMinorTickSpacing(5);
    iterationsMenuItem.setPaintTicks(true);
    iterationsMenuItem.setPaintLabels(true);
    iterationsMenuItem.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        if(!iterationsMenuItem.getValueIsAdjusting()){
          panel.changeIterations(iterationsMenuItem.getValue() * 100);
        }
      }
    });
    viewMenu.add(new JLabel("Iterations"));
    viewMenu.add(iterationsMenuItem);
    
    viewMenu.addSeparator();

    hueMenuItem = new JSlider(JSlider.HORIZONTAL, 1, 10, panel.getNumberOfHue());
    hueMenuItem.setMajorTickSpacing(1);
    hueMenuItem.setPaintTicks(true);
    hueMenuItem.setPaintLabels(true);
    hueMenuItem.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        if(!hueMenuItem.getValueIsAdjusting()){
          panel.changeNumberOfHue(hueMenuItem.getValue());
        }
      }
    });
    viewMenu.add(new JLabel("Number of color shades"));
    viewMenu.add(hueMenuItem);

    this.mathMenu = new JMenu("Math");
    this.mathMenu.setMnemonic(KeyEvent.VK_M);
    this.mathMenu.getAccessibleContext().setAccessibleDescription(
        "Menu for math parameters");
    this.add(mathMenu);

    goToPointItem = new JMenuItem("Go to point");
    goToPointItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JTextField xField = new JTextField(10);
        JTextField yField = new JTextField(10);
        xField.setText("0");
        yField.setText("0");

        JPanel myPanel = new JPanel();
        myPanel.add(xField);
        myPanel.add(new JLabel(" + "));
        myPanel.add(yField);
        myPanel.add(new JLabel("i"));

        int result = JOptionPane.showConfirmDialog(null, myPanel, 
            "Please enter the point", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION) {
          try{
            double x = Double.parseDouble(xField.getText());
            double y = Double.parseDouble(yField.getText());

            panel.goToPointMenu(x, y);
          }catch(NumberFormatException exception){
            exception.printStackTrace();
          }
        }
      }
    });
    mathMenu.add(goToPointItem);

    changeFunctionItem = new JMenuItem("Change fractal");
    changeFunctionItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String[] functions = {"Mandelbrot", "Julia", "Mandelbrot leaf",
            "Hand spinner", "Weird Mandelbrot", "Mandelbrot cubed",
            "Mandelbrot ^6", "Dragon", };

        String function = (String) JOptionPane.showInputDialog(
            null,
            "Functions list:",
            "Please choose the fractal",
            JOptionPane.PLAIN_MESSAGE,
            null,
            functions,
            functions[0]);

        if((function != null) && (function.length() > 0)) {
          switch(function){
          case "Julia":
            JTextField xField = new JTextField(10);
            JTextField yField = new JTextField(10);
            xField.setText("0.285");
            yField.setText("0.01");

            JPanel myPanel = new JPanel();
            myPanel.add(xField);
            myPanel.add(new JLabel(" + "));
            myPanel.add(yField);
            myPanel.add(new JLabel("i"));

            int result = JOptionPane.showConfirmDialog(null, myPanel, 
                "Please enter the Julia constant", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION) {
              try{
                double cRe = Double.parseDouble(xField.getText());
                double cIm = Double.parseDouble(yField.getText());

                FractalWindow.getInstance().changeCenterPanel(new JuliaPanel(new Complex(cRe, cIm)));
              }catch(NumberFormatException exception){
                exception.printStackTrace();
              }
            }
            break;
          case "Mandelbrot leaf":
            FractalWindow.getInstance().changeCenterPanel(new LeafPanel(20));
            break;
          case "Hand spinner":
            FractalWindow.getInstance().changeCenterPanel(new HandSpinnerPanel());
            break;
          case "Weird Mandelbrot":
            FractalWindow.getInstance().changeCenterPanel(new WeirdMandelbrotPanel());
            break;
          case "Mandelbrot ^6":
            FractalWindow.getInstance().changeCenterPanel(new MandelbrotToTheSixPanel());
            break;
          case "Mandelbrot cubed":
            FractalWindow.getInstance().changeCenterPanel(new MandelbrotCubedPanel());
            break;
          default:
            FractalWindow.getInstance().changeCenterPanel(new MandelbrotPanel());
          }
        }
      }
    });
    mathMenu.add(changeFunctionItem);

    if(panel instanceof JuliaPanel){
      changeJuliaC = new JMenuItem("Change Julia constant");
      changeJuliaC.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          JTextField xField = new JTextField(10);
          JTextField yField = new JTextField(10);
          xField.setText("0");
          yField.setText("0");

          JPanel myPanel = new JPanel();
          myPanel.add(xField);
          myPanel.add(new JLabel(" + "));
          myPanel.add(yField);
          myPanel.add(new JLabel("i"));

          int result = JOptionPane.showConfirmDialog(null, myPanel, 
              "Please enter the Julia constant", JOptionPane.OK_CANCEL_OPTION);

          if(result == JOptionPane.OK_OPTION) {
            try{
              double x = Double.parseDouble(xField.getText());
              double y = Double.parseDouble(yField.getText());

              ((JuliaPanel)panel).setC(new Complex(x, y));
            }catch(NumberFormatException exception){
              exception.printStackTrace();
            }
          }
        }
      });
      mathMenu.add(changeJuliaC);
    }else{
      
    }
  }
}
