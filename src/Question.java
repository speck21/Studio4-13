import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Question {
    private String question;
    private HashMap<Character,String> possibleAnswers;
    private HashMap<Character,String> correctAnswer;
    private int value;
    Scanner scan = new Scanner(System.in);


    public Question(String question, HashMap<Character,String> possibleAnswers,
                    HashMap<Character,String> correctAnswer, int value) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
        this.value = value;
    }
    public Question(String question, HashMap<Character,String> correctAnswer, int value) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.value = value;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HashMap<Character, String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(HashMap<Character, String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public HashMap<Character, String> getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(HashMap<Character, String> correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer askQuestion(){
        //display the question
        System.out.println(question+"\n");
        for(Map.Entry<Character,String> map: possibleAnswers.entrySet()){
            System.out.println(map.getKey() + ": " + map.getValue());
        }
        //ask for answer
        System.out.println("Enter your letter choice: " +"\n");
        String userAnswer = scan.next();
        //Tell user if they answered correctly

        //return value of question
        int tracker = 0;
        for(Map.Entry<Character,String>map:correctAnswer.entrySet()){
            if(map.getKey() == userAnswer.toCharArray()[0]){
                tracker++;
            }
        }
        if(tracker == correctAnswer.size()){
            return getValue();
        }else{
            return 0;
        }
    }
}
