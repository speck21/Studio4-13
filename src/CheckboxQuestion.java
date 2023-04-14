import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckboxQuestion extends Question{


    public CheckboxQuestion(String question, HashMap<Character, String> possibleAnswers, HashMap<Character, String> correctAnswer, int value) {
        super(question, possibleAnswers, correctAnswer, value);
    }
    @Override
    public Integer askQuestion(){
        //display the question
        System.out.println(getQuestion()+"\n");
        for(Map.Entry<Character,String> map: getPossibleAnswers().entrySet()){
            System.out.println(map.getKey() + ": " + map.getValue());
        }
        //ask for answer
        boolean choosing = true;
        ArrayList<String> userAnswer = new ArrayList<>();
        do{
            System.out.println("Enter your letter choice: \n'X' when done choosing");
            String choice = scan.next();
            if(choice.compareTo("X") == 0){
                choosing = false;
            }
            userAnswer.add(choice);

        }while(choosing);
        //Tell user if they answered correctly
        //return value of question
        int tracker = 0;
        for(Map.Entry<Character,String>map:getCorrectAnswer().entrySet()){
            for(String answer: userAnswer)
                if(map.getKey() == answer.toCharArray()[0]){

                    tracker++;
                }
        }
        //overridden to give partial credit
        if(getCorrectAnswer().size() == tracker){
            return getValue();
        }else{
            return (getCorrectAnswer().size() - tracker)/getValue();
        }
    }
}
