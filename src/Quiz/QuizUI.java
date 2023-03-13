package Quiz;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class QuizUI {
    JFrame frame = new JFrame();
    QuizController quizController;
    Questions questions = new Questions();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JLabel timer_label = new JLabel();
    JLabel seconds_label = new JLabel();
    JTextField correct_answers_label = new JTextField();
    JTextField percentage = new JTextField();

    public QuizUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(685,750);
        frame.setTitle("History of Ukraine Trivia Quiz");
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        textField.setBounds(0,0,685,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(Color.decode("#E1E5EB"));
        textField.setFont(new Font("Century Gothic",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0,50,685,125);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(Color.decode("#E1E5EB"));
        textArea.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        timer_label.setBounds(565,590,100,25);
        timer_label.setBackground(new Color(50,50,50));
        timer_label.setForeground(Color.decode("#E59462"));
        timer_label.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        timer_label.setHorizontalAlignment(JTextField.CENTER);
        timer_label.setText("Timer");

        seconds_label.setBounds(570,615,100,100);
        seconds_label.setBackground(new Color(25,25,25));
        seconds_label.setForeground(Color.decode("#E59462"));
        seconds_label.setFont(new Font("Comic Sans MS",Font.BOLD,60));
        seconds_label.setBorder(BorderFactory.createBevelBorder(1));
        seconds_label.setOpaque(true);
        seconds_label.setHorizontalAlignment(JTextField.CENTER);
        seconds_label.setText(String.valueOf(10));

        correct_answers_label.setBounds(225,225,200,100);
        correct_answers_label.setBackground(new Color(25,25,25));
        correct_answers_label.setForeground(Color.decode("#81CAD6"));
        correct_answers_label.setFont(new Font("Comic Sans MS",Font.BOLD,50));
        correct_answers_label.setBorder(BorderFactory.createBevelBorder(1));
        correct_answers_label.setHorizontalAlignment(JTextField.CENTER);
        correct_answers_label.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(Color.decode("#EDCD44"));
        percentage.setFont(new Font("Comic Sans MS",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(timer_label);
        frame.add(seconds_label);
        frame.add(textArea);
        frame.add(textField);
        quizController = new QuizController(this, questions);
        frame.setVisible(true);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JTextField getCorrect_answers_label() {
        return correct_answers_label;
    }

    public JTextField getPercentage() {
        return percentage;
    }

    public JLabel getSeconds_label() {
        return seconds_label;
    }

    public JFrame getFrame() {
        return frame;
    }
}