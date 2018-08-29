package main.javabrot.gui.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorShadeCreationPanel extends JPanel {

  // CLASS FIELDS

  private static final long serialVersionUID = -9149910428867846486L;

  private List<Color> colors;
  private List<JPanel> colorPanels;

  private JColorChooser colorChooser;

  private JPanel previewPanel;

  // CONSTRUCTOR

  public ColorShadeCreationPanel () {
    this.colors = new ArrayList<Color>();
    this.colorPanels = new ArrayList<JPanel>();

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    this.colorChooser = new JColorChooser();
    this.add(colorChooser);

    this.previewPanel = new JPanel();

    JButton addButton = new JButton("Add this color");

    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(colorChooser.getColor() != null){
          colors.add(colorChooser.getColor());

          JPanel color = new JPanel();
          color.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          color.setBackground(colorChooser.getColor());
          
          colorPanels.add(color);

          previewPanel.add(color);
          previewPanel.revalidate();

          colorChooser.setColor(null);
        }
      }
    });
    
    JButton removeButton = new JButton("Remove last color");
    removeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if(colorPanels.size() > 0){
          colors.remove(colorPanels.size() - 1);
          
          previewPanel.remove(colorPanels.get(colorPanels.size() - 1));
          previewPanel.revalidate();
          previewPanel.repaint();
          
          colorPanels.remove(colorPanels.size() - 1);
        }
      }
    });

    previewPanel.add(removeButton);
    previewPanel.add(addButton);

    this.add(previewPanel);
  }

  //GETTERS AND SETTERS

  public List<Color> getColors() {
    return colors;
  }

  public void setColors(List<Color> colors) {
    this.colors = colors;
  }
}
