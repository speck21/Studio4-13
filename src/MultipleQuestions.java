
import java.util.HashMap;

public class MultipleQuestions extends Question{


    public MultipleQuestions(String question, HashMap<Character, String> possibleAnswers, HashMap<Character, String> correctAnswer, int value) {
        super(question, possibleAnswers, correctAnswer, value);
    }


}
