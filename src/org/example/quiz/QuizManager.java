package org.example.quiz;

import static java.awt.Color.decode;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * The QuizManager class handles the logic for managing the quiz game. It manages the
 * quiz questions, user answers, and timing for the quiz. It also updates the GUI based
 * on user interactions and the state of the quiz.
 */
public class QuizManager implements ActionListener {
  private final QuizGui quizGui;
  private final QuizQuestion quizQuestion;
  private final Timer pause;
  private final Timer timer;

  private int index;
  private int correctAnswers = 0;
  private int seconds = 10;

  private final JButton[] buttons = new JButton[4];
  private final JLabel[] answers = new JLabel[4];

  /**
   * Constructs a new QuizManager instance, initializing the quiz UI and setting up
   * the timers for handling quiz timing.
   *
   * @param quizGui the QuizGui instance used for updating the UI
   * @param quizQuestion the QuizQuestion instance containing questions and answers
   */
  public QuizManager(QuizGui quizGui, QuizQuestion quizQuestion) {
    this.quizGui = quizGui;
    this.quizQuestion = quizQuestion;
    String[] buttonLabels = {"A", "B", "C", "D"};

    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton(buttonLabels[i]);
      buttons[i].setBounds(0, 175 + (i * 100), 100, 100);
      buttons[i].setFont(new Font("Comic Sans MS", BOLD, 35));
      buttons[i].setFocusable(false);
      buttons[i].addActionListener(this);

      answers[i] = new JLabel();
      answers[i].setBounds(125, 175 + (i * 100), 500, 100);
      answers[i].setBackground(new Color(50, 50, 50));
      answers[i].setForeground(decode("#D5CAE4"));
      answers[i].setFont(new Font("Comic Sans MS", PLAIN, 35));

      quizGui.getFrame().add(buttons[i]);
      quizGui.getFrame().add(answers[i]);
    }

    this.timer = new Timer(1000, e -> {
      seconds--;
      quizGui.getSecondsLabel().setText(valueOf(seconds));
      if (seconds <= 0) {
        showAnswer();
      }
    });

    this.pause = new Timer(1500, e -> {
      asList(answers).forEach(answer -> answer.setForeground(decode("#D5CAE4")));
      seconds = 10;
      quizGui.getSecondsLabel().setText(valueOf(seconds));
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
      quizGui.getTextField().setText("Question " + (index + 1));
      quizGui.getTextArea().setText(quizQuestion.getQuestions()[index]);
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

    quizGui.getTextField().setText("RESULTS!");
    quizGui.getTextArea().setText("");
    asList(answers).forEach(answer -> answer.setText(""));

    quizGui.getCorrectAnswersLabel().setText("(" + correctAnswers + "/" + quizQuestion.getQuestions().length + ")");
    quizGui.getPercentage().setText(result + "%");

    quizGui.getFrame().add(quizGui.getCorrectAnswersLabel());
    quizGui.getFrame().add(quizGui.getPercentage());
  }

  public void buttonsEnable(boolean bool) {
    for (JButton button : buttons) {
      button.setEnabled(bool);
    }
  }
}
