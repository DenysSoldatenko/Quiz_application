package org.example.quiz;

public class QuizQuestion {

  String[] questions = {
    "During the 10th and 11th centuries, Ukraine was the centre of powerful and prestigious state in Europe. What was it called at the time?",
    "Which two countries was Ukraine ruled by during 1300-1600?",
    "What was established during the mid of seventeenth century by Dnieper Cossacks?",
    "Who led the largest of Cossack uprising against Commonwealth and the Polish king in 1648?",
    "Which country oppressed Ukrainians in Galicia who sympathized with Russia during WW1?",
    "Ukraine became independent in 1917, but that was short-lived when who invaded the city during the January Uprising in 1918?",
    "Who did some elements of the Ukrainian nationalist underground fight against during World War II?",
    "Where did a nuclear reactor explode on 26th April 1986 sending out in the air more radioactivity than Hiroshima and Nagasaki combined?",
    "When did the Ukrainian Parliament proclaim Ukraine's Independence from the USSR?",
    "Who was Ukraine's first president after it gained independence from the Soviet Union?",
    "When was the new Constitution of Ukraine adopted?",
    "What was the name of the scandal involving Ukrainian President Leonid Kuchma's alleged involvement in the murder of a journalist in 2000?",
    "Which Ukrainian president was poisoned in 2004 and survived an assassination attempt?",
    "Who won the Eurovision Song Contest for Ukraine in 2004?",
    "Which Ukrainian football club won the UEFA Cup in 2009?",
    "Which Ukrainian city hosted the final of UEFA European Football Championship in 2012?",
    "In 2014, which region of Ukraine was annexed by Russia?",
    "What was the name of the Ukrainian military pilot who became a symbol of resistance against Russian aggression after being held prisoner for two years?",
    "In 2019, what was the name of the new political party that was founded by Volodymyr Zelensky?",
    "What was the name of the law signed by President Zelensky in 2019 aimed at resolving the conflict in eastern Ukraine?"
  };

  String[][] options = {
    {"Muscovy", "Volhynia", "Poland", "Kyivan Rus"},
    {"Germany and France", "Poland and Lithuania", "Russia and Hungary", "Romania and Turkey"},
    {"Ukraine", "Kyivan Rus", "Rukraine", "Zaporozhian Sich"},
    {"Bohdan Khmelnytsky", "Boghdan Chernivetski", "Oleg Stupka", "Taras Bulba"},
    {"Romania", "Austria", "Austria-Hungary", "Russia"},
    {"Americans", "Nazis", "Bolsheviks", "The Black Hand"},
    {"Nazi", "Both Nazi and Soviet Army", "Soviet Army", "France"},
    {"Chernivtsi", "Kyiv Nuclear Power Plant", "Chernobyl Nuclear Power Plant", "Nuclear Power Plant in Lviv"},
    {"December 12, 1991", "August 24, 1991", "November 23, 1990", "May 1, 1992"},
    {"Leonid Kravchuk", "Viktor Yushchenko", "Petro Poroshenko", "Viktor Yanukovych"},
    {"1991", "1994", "1992", "1996"},
    {"Orange Revolution", "EuroMaidan protests", "Yanukovych Leaks", "Gongadze Affair"},
    {"Petro Poroshenko", "Leonid Kuchma", "Viktor Yushchenko", "Viktor Yanukovych"},
    {"Ruslana", "Ani Lorak", "Verka Serduchka", "Tina Karol"},
    {"Dynamo Kyiv", "Shakhtar Donetsk", "Metalist Kharkiv", "Dnipro Dnipropetrovsk"},
    {"Kyiv", "Lviv", "Kharkiv", "Donetsk"},
    {"Kharkiv", "Crimea", "Kherson", "Mykolaiv"},
    {"Nadiya Savchenko", "Oksana Baiul", "Iryna Bilyk", "Kateryna Bondarenko"},
    {"European Solidarity", "Servant of the People", "Opposition Platform - For Life", "Batkivshchyna"},
    {"Minsk Protocol", "Normandy Format", "Steinmeier Formula", "Zelensky Doctrine"},
  };

  char[] answers = {
    'D',
    'B',
    'D',
    'A',
    'C',
    'C',
    'B',
    'C',
    'B',
    'A',
    'D',
    'D',
    'C',
    'A',
    'B',
    'A',
    'B',
    'A',
    'B',
    'C',
  };

  public QuizQuestion() { }

  public String[] getQuestions() {
    return questions;
  }

  public String[][] getOptions() {
    return options;
  }

  public char[] getAnswers() {
    return answers;
  }
}
