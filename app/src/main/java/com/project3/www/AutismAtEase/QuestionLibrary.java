package com.project3.www.AutismAtEase;


public class QuestionLibrary {

    private String mQuestions[] = {
            "Question 1 of 14 : \n\nIf you point at something across the  room, does your child look at it?",
            "Question 2 of 14 : \n\nHave you ever wondered if your child  might be deaf?",
            "Question 3 of 14 : \n\nDoes your child play pretend or  make-believe?",
            "Question 4 of 14 : \n\nDoes your child like climbing on things?",
            "Question 5 of 14 : \n\nDoes your child make unusual finger  movements near his or her eyes?",
            "Question 6 of 14 : \n\nDoes your child point with one finger to  ask for something or to get help?",
            "Question 7 of 14 : \n\nDoes your child interact with other  children?",
            "Question 8 of 14 : \n\nDoes your child respond when you call  his or her name?",
            "Question 9 of 14 : \n\nWhen you smile at your child, does he or  she smile back at you?",
            "Question 10 of 14 : \n\nDoes your child get upset by  everyday noises?",
            "Question 11 of 14 : \n\nDoes your child look you in the eye when you are talking to him or her?",
            "Question 12 of 14 : \n\nDoes your child try to copy what  you do?",
            "Question 13 of 14 : \n\nIf you turn your head to look at something, does your child look around to see what you are looking at??",
            "Question 14 of 14 : \n\nDoes your child understand when you tell him or her to do something?"


    };


    private String mChoices[][] = {

            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"},
            {"Yes", "NO"}

    };


    private String mCorrectAnswers[] = {"Yes", "NO", "NO", "Yes", "NO", "Yes", "Yes", "Yes", "Yes", "NO", "Yes", "Yes", "Yes", "Yes"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }


    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
