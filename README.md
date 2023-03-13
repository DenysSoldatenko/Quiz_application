# Quiz game
This program is a simple quiz game that allows users to answer questions with multiple-choice options.

### How to Play
1. Download and run the Quiz program.
2. Click the buttons (A, B, C, D) to select an answer for each question.
3. You have 10 seconds to select an answer before the timer runs out.
4. If you select the correct answer, your score will increase.
5. After answering all the questions, you will receive your score as a percentage.

### Features
- Multiple-choice questions
- Countdown timer for each question
- Automatic progression to the next question
- Displays correct answers and final results

### Technical Details
The QuizController class is responsible for managing the game logic and user interface. It utilizes the QuizUI and Questions classes to display questions and handle user input. The class contains an array of JButtons for each answer option, an array of JLabels to display the answer text, and two Timer objects to manage the game timer and answer display delay.

The class implements the ActionListener interface to handle button clicks and updates the game state accordingly. It also includes methods for displaying questions, showing answers, and calculating the final result.

The game timer is set to 10 seconds per question, after which the correct answer is displayed for 1.5 seconds. The user's score is calculated as a percentage of correct answers out of total questions answered.
