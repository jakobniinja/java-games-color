package com.jakobniinja;

import static javax.swing.SwingConstants.CENTER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GuessMyColor extends JFrame {

  public static final Long SerialVersionUID = 1L;

  public GuessMyColor() {
    initGUI();

    setResizable(false);
    pack();
    setVisible(true);
    setSize(400, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void initGUI() {
    JLabel titleLabel = new JLabel();
    Font titleFont = new Font(Font.SERIF, Font.BOLD, 32);
    titleLabel.setFont(titleFont);
    titleLabel.setText("Guess My Color");
    titleLabel.setHorizontalAlignment(CENTER);
    add(titleLabel, BorderLayout.PAGE_START);
    setTitle("Guess My Color");

    JLabel centerLabel = new JLabel();
    centerLabel.setBackground(Color.BLUE);
    add(centerLabel, BorderLayout.CENTER);

    JPanel leftPanel = new JPanel();
    leftPanel.setBackground(Color.RED);
    add(leftPanel, BorderLayout.LINE_START);

    JPanel rightPanel = new JPanel();
    rightPanel.setBackground(Color.GREEN);
    add(rightPanel, BorderLayout.LINE_END);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(Color.YELLOW);
    add(bottomPanel, BorderLayout.PAGE_END);
    //TODO: 2-8
  }

  public static void main(String[] args) {
    try {
      String className = UIManager.getCrossPlatformLookAndFeelClassName();
      UIManager.setLookAndFeel(className);
      new GuessMyColor();
    } catch (Exception e) {
      //
    }
    EventQueue.invokeLater(GuessMyColor::new);
  }
}
