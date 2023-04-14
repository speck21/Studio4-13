import java.util.HashMap;

public class TrueFalseQuestion extends Question{

    public TrueFalseQuestion(String question, HashMap<Character, String> correctAnswer, int value) {
        super(question, correctAnswer, value);
        HashMap<Character,String> trueOrFalse = new HashMap<>();
        trueOrFalse.put('A',"True");
        trueOrFalse.put('B',"False");
        setPossibleAnswers(trueOrFalse);
    }
}
