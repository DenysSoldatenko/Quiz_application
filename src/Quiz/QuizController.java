package Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class QuizController implements ActionListener {
    private final QuizUI ui;
    private final Questions questions;
    private final Timer pause;
    private final Timer timer;
    JButton[] buttons = new JButton[4];
    JLabel[] answers = new JLabel[4];
    private int index;
    private int correct_answers = 0;
    private int seconds = 10;
    public QuizController(QuizUI ui, Questions questions) {
        this.ui = ui;
        this.questions = questions;
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
            answers[i].setForeground(Color.decode("#D5CAE4"));
            answers[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 35));

            ui.getFrame().add(buttons[i]);
            ui.getFrame().add(answers[i]);
        }

        this.timer = new Timer(1000, e -> {
            seconds--;
            ui.getSeconds_label().setText(String.valueOf(seconds));
            if(seconds<=0) showAnswer();
        });

        this.pause = new Timer(1500, e -> {
            Arrays.asList(answers).forEach(answer -> answer.setForeground(Color.decode("#D5CAE4")));
            seconds = 10;
            ui.getSeconds_label().setText(String.valueOf(seconds));
            buttonsEnable(true);
            index++;
            nextQuestion();
        });

        nextQuestion();
    }

    private void nextQuestion() {
        if (index >= questions.getQuestions().length) {
            showResults();
        } else {
            ui.getTextField().setText("Question " + (index + 1));
            ui.getTextArea().setText(questions.getQuestions()[index]);
            for (int i = 0; i < answers.length; i++) {
                answers[i].setText(questions.getOptions()[index][i]);
            }
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonsEnable(false);
        char selectedAnswer = e.getActionCommand().charAt(0);
        char correctAnswer = questions.getAnswers()[index];
        if (selectedAnswer == correctAnswer) correct_answers++;
        showAnswer();
    }

    void showAnswer() {
        timer.stop();
        buttonsEnable(false);

        for (int i = 0; i < answers.length; i++) {
            if (questions.getAnswers()[index] != 'A' + i) {
                answers[i].setForeground(Color.decode("#ed533b"));
            } else {
                answers[i].setForeground(Color.decode("#7fed3b"));
            }
        }

        pause.setRepeats(false);
        pause.start();
    }

    private void showResults() {
        buttonsEnable(false);
        int result = (int)((correct_answers/(double)questions.getQuestions().length)*100);

        ui.getTextField().setText("RESULTS!");
        ui.getTextArea().setText("");
        Arrays.asList(answers).forEach(answer -> answer.setText(""));

        ui.getCorrect_answers_label().setText("("+ correct_answers +"/"+questions.getQuestions().length+")");
        ui.getPercentage().setText(result+"%");

        ui.getFrame().add(ui.getCorrect_answers_label());
        ui.getFrame().add(ui.getPercentage());
    }

    public void buttonsEnable(boolean bool){
        for (JButton button : buttons) {
            button.setEnabled(bool);
        }
    }
}