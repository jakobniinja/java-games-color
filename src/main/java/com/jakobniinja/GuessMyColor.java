package com.jakobniinja;

import static javax.swing.SwingConstants.CENTER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class GuessMyColor extends JFrame {

  public static final Long SerialVersionUID = 1L;

  private JPanel samplePanel = new JPanel();

  private JPanel targetPanel = new JPanel();

  private int targetRed = 0;

  private int targetGreen = 0;

  private int targetBlue = 0;

  private int red = 0;

  private int green = 0;

  private int blue = 0;

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
    titleLabel.setBackground(Color.BLACK);
    titleLabel.setForeground(Color.WHITE);
    titleLabel.setOpaque(true);
    titleLabel.setHorizontalAlignment(CENTER);
    add(titleLabel, BorderLayout.PAGE_START);
    setTitle("Guess My Color");

    JLabel centerLabel = new JLabel();
    centerLabel.setBackground(Color.BLUE);
    add(centerLabel, BorderLayout.CENTER);

    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(Color.WHITE);
    add(centerPanel, CENTER);

    Dimension size = new Dimension(50, 50);
    samplePanel.setBackground(Color.BLACK);
    samplePanel.setPreferredSize(size);
    centerPanel.add(samplePanel);

    targetPanel.setBackground(Color.CYAN);
    targetPanel.setPreferredSize(size);
    centerPanel.add(targetPanel);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.BLACK);
    add(buttonPanel, BorderLayout.PAGE_END);

    JPanel leftPanel = new JPanel();
    leftPanel.setBackground(Color.RED);
    add(leftPanel, BorderLayout.LINE_START);

    JPanel rightPanel = new JPanel();
    rightPanel.setBackground(Color.GREEN);
    add(rightPanel, BorderLayout.LINE_END);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(Color.YELLOW);
    add(bottomPanel, BorderLayout.PAGE_END);

    Font font = new Font(Font.DIALOG, Font.BOLD, 18);

    JButton moreRedButton = new JButton("+");
    moreRedButton.setBackground(Color.YELLOW);
    moreRedButton.setFont(font);
    moreRedButton.addActionListener(e -> increaseRed());
    buttonPanel.add(moreRedButton);

    JButton lessRedButton = new JButton("-");
    lessRedButton.setBackground(Color.RED);
    lessRedButton.setFont(font);
    lessRedButton.addActionListener(e -> decreaseRed());
    buttonPanel.add(lessRedButton);

    JButton moreGreenButton = new JButton("+");
    moreGreenButton.setBackground(Color.GREEN);
    moreGreenButton.setFont(font);
    moreGreenButton.addActionListener(e -> increaseGreen());
    buttonPanel.add(moreGreenButton);

    JButton lessGreenButton = new JButton("-");
    lessGreenButton.setBackground(Color.GREEN);
    lessGreenButton.setFont(font);
    lessGreenButton.addActionListener(e -> decreaseGreen());
    buttonPanel.add(lessGreenButton);

    JButton moreBlueButton = new JButton("+");
    moreBlueButton.setBackground(Color.BLUE);
    moreBlueButton.setFont(font);
    moreBlueButton.addActionListener(e -> increaseBlue());
    buttonPanel.add(moreBlueButton);

    JButton lessBlueButton = new JButton("-");
    lessBlueButton.setBackground(Color.BLUE);
    lessBlueButton.setFont(font);
    lessBlueButton.addActionListener(e -> decreaseBlue());
    buttonPanel.add(lessBlueButton);

    add(buttonPanel, BorderLayout.PAGE_END);

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    generateTargetColor();
  }

  private void increaseRed() {
    if (red <= 240) {
      red += 15;
    }
    updateColorSample();
  }

  private void decreaseRed() {
    if (red >= 15) {
      red -= 15;
    }
    updateColorSample();
  }

  private void increaseGreen() {
    if (green <= 250) {
      green += 15;
    }
    updateColorSample();
  }

  private void decreaseGreen() {
    if (green >= 15) {
      green -= 15;
    }
    updateColorSample();
  }


  private void increaseBlue() {
    if (blue <= 250) {
      blue += 15;
    }
    updateColorSample();
  }

  private void decreaseBlue() {
    if (blue >= 15) {
      blue -= 15;
    }
    updateColorSample();
  }

  private void generateTargetColor() {
    Random random = new Random();
    targetRed = random.nextInt(18) * 15;
    targetGreen = random.nextInt(18) * 15;
    targetBlue = random.nextInt(18) * 15;
    Color targetColor = new Color(targetRed, targetGreen, targetBlue);
    targetPanel.setBackground(targetColor);
  }

  public void updateColorSample() {
    Color color = new Color(red, green, blue);
    samplePanel.setBackground(color);
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
