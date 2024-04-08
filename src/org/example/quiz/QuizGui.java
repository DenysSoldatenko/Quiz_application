package org.example.quiz;

import static java.awt.Color.decode;
import static java.awt.Font.BOLD;
import static java.lang.String.valueOf;
import static javax.swing.BorderFactory.createBevelBorder;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static javax.swing.border.BevelBorder.LOWERED;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QuizGui {
  JFrame frame = new JFrame();
  QuizManager quizManager;
  QuizQuestion quizQuestion = new QuizQuestion();

  JTextField textField = new JTextField();
  JTextArea textArea = new JTextArea();

  JLabel timerLabel = new JLabel();
  JLabel secondsLabel = new JLabel();

  JTextField correctAnswersLabel = new JTextField();
  JTextField percentage = new JTextField();

  public QuizGui() {
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setSize(685, 750);
    frame.setTitle("History of Ukraine Trivia Quiz");
    frame.getContentPane().setBackground(new Color(50, 50, 50));
    frame.setLayout(null);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    textField.setBounds(0, 0, 685, 50);
    textField.setBackground(new Color(25, 25, 25));
    textField.setForeground(decode("#E1E5EB"));
    textField.setFont(new Font("Century Gothic", BOLD, 30));
    textField.setBorder(createBevelBorder(LOWERED));
    textField.setHorizontalAlignment(CENTER);
    textField.setEditable(false);

    textArea.setBounds(0, 50, 685, 125);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setBackground(new Color(25, 25, 25));
    textArea.setForeground(decode("#E1E5EB"));
    textArea.setFont(new Font("Comic Sans MS", BOLD, 25));
    textArea.setBorder(createBevelBorder(1));
    textArea.setEditable(false);

    timerLabel.setBounds(565, 590, 100, 25);
    timerLabel.setBackground(new Color(50, 50, 50));
    timerLabel.setForeground(decode("#E59462"));
    timerLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
    timerLabel.setHorizontalAlignment(CENTER);
    timerLabel.setText("Timer");

    secondsLabel.setBounds(570, 615, 100, 100);
    secondsLabel.setBackground(new Color(25, 25, 25));
    secondsLabel.setForeground(decode("#E59462"));
    secondsLabel.setFont(new Font("Comic Sans MS", BOLD, 60));
    secondsLabel.setBorder(createBevelBorder(1));
    secondsLabel.setOpaque(true);
    secondsLabel.setHorizontalAlignment(CENTER);
    secondsLabel.setText(valueOf(10));

    correctAnswersLabel.setBounds(225, 225, 200, 100);
    correctAnswersLabel.setBackground(new Color(25, 25, 25));
    correctAnswersLabel.setForeground(decode("#81CAD6"));
    correctAnswersLabel.setFont(new Font("Comic Sans MS", BOLD, 50));
    correctAnswersLabel.setBorder(createBevelBorder(1));
    correctAnswersLabel.setHorizontalAlignment(CENTER);
    correctAnswersLabel.setEditable(false);

    percentage.setBounds(225, 325, 200, 100);
    percentage.setBackground(new Color(25, 25, 25));
    percentage.setForeground(decode("#EDCD44"));
    percentage.setFont(new Font("Comic Sans MS", BOLD, 50));
    percentage.setBorder(createBevelBorder(1));
    percentage.setHorizontalAlignment(CENTER);
    percentage.setEditable(false);

    frame.add(timerLabel);
    frame.add(secondsLabel);
    frame.add(textArea);
    frame.add(textField);
    quizManager = new QuizManager(this, quizQuestion);
    frame.setVisible(true);
  }

  public JTextField getTextField() {
    return textField;
  }

  public JTextArea getTextArea() {
    return textArea;
  }

  public JTextField getCorrectAnswersLabel() {
    return correctAnswersLabel;
  }

  public JTextField getPercentage() {
    return percentage;
  }

  public JLabel getSecondsLabel() {
    return secondsLabel;
  }

  public JFrame getFrame() {
    return frame;
  }
}
