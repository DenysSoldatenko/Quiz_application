package org.example.quiz;

import static java.awt.Color.decode;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

public class QuizManager implements ActionListener {
  private final QuizGui ui;
  private final QuizQuestion quizQuestion;
  private final Timer pause;
  private final Timer timer;
  JButton[] buttons = new JButton[4];
  JLabel[] answers = new JLabel[4];
  private int index;
  private int correctAnswers = 0;
  private int seconds = 10;

  public QuizManager(QuizGui ui, QuizQuestion quizQuestion) {
    this.ui = ui;
    this.quizQuestion = quizQuestion;
    String[] buttonLabels = {"A", "B", "C", "D"};

    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton(buttonLabels[i]);
      buttons[i].setBounds(0, 175 + (i * 100), 100, 100);
      buttons[i].setFont(new Font("Comic Sans MS", Font.BOLD, 35));
      buttons[i].setFocusable(false);
      buttons[i].addActionListener(this);

      answers[i] = new JLabel();
      answers[i].setBounds(125, 175 + (i * 100), 500, 100);
      answers[i].setBackground(new Color(50, 50, 50));
      answers[i].setForeground(decode("#D5CAE4"));
      answers[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 35));

      ui.getFrame().add(buttons[i]);
      ui.getFrame().add(answers[i]);
    }

    this.timer = new Timer(1000, e -> {
      seconds--;
      ui.getSecondsLabel().setText(valueOf(seconds));
      if (seconds <= 0) {
        showAnswer();
      }
    });

    this.pause = new Timer(1500, e -> {
      asList(answers).forEach(answer -> answer.setForeground(decode("#D5CAE4")));
      seconds = 10;
      ui.getSecondsLabel().setText(valueOf(seconds));
      buttonsEnable(true);
      index++;
      nextQuestion();
    });

    nextQuestion();
  }

  private void nextQuestion() {
    if (index >= quizQuestion.getQuestions().length) {
      showResults();
    } else {
      ui.getTextField().setText("Question " + (index + 1));
      ui.getTextArea().setText(quizQuestion.getQuestions()[index]);
      for (int i = 0; i < answers.length; i++) {
        answers[i].setText(quizQuestion.getOptions()[index][i]);
      }
      timer.start();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    buttonsEnable(false);
    char selectedAnswer = e.getActionCommand().charAt(0);
    char correctAnswer = quizQuestion.getAnswers()[index];
    if (selectedAnswer == correctAnswer) {
      correctAnswers++;
    }
    showAnswer();
  }

  void showAnswer() {
    timer.stop();
    buttonsEnable(false);

    for (int i = 0; i < answers.length; i++) {
      if (quizQuestion.getAnswers()[index] != 'A' + i) {
        answers[i].setForeground(decode("#ed533b"));
      } else {
        answers[i].setForeground(decode("#7fed3b"));
      }
    }

    pause.setRepeats(false);
    pause.start();
  }

  private void showResults() {
    buttonsEnable(false);
    int result = (int) ((correctAnswers / (double) quizQuestion.getQuestions().length) * 100);

    ui.getTextField().setText("RESULTS!");
    ui.getTextArea().setText("");
    asList(answers).forEach(answer -> answer.setText(""));

    ui.getCorrectAnswersLabel().setText("(" + correctAnswers + "/" + quizQuestion.getQuestions().length + ")");
    ui.getPercentage().setText(result + "%");

    ui.getFrame().add(ui.getCorrectAnswersLabel());
    ui.getFrame().add(ui.getPercentage());
  }

  public void buttonsEnable(boolean bool) {
    for (JButton button : buttons) {
      button.setEnabled(bool);
    }
  }
}
