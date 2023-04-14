import java.util.*;

public class QuizRunner {
    public static void main(String[] args) {
        //test for up to 4 options on checkbox Q
        Scanner scan = new Scanner(System.in);
        Quiz quiz = new Quiz();
        double tally=0;
        ArrayList<Question> quizMap = new ArrayList<>();
        HashMap<Character,String> trueFalseTestAnswer = new HashMap<>();
        trueFalseTestAnswer.put('A',"True");
        quizMap.add(new TrueFalseQuestion("Are you Human?", trueFalseTestAnswer, 3));
        HashMap<Character,String> multipleChoiceTestOption = new HashMap<>();
        multipleChoiceTestOption.put('A',"Pizza");
        multipleChoiceTestOption.put('B', "Sushi");
        multipleChoiceTestOption.put('C', "Pie");
        multipleChoiceTestOption.put('D', "Vegetables");
        HashMap<Character,String> multipleChoiceTestAnswer = new HashMap<>();
        multipleChoiceTestAnswer.put('B', "Sushi");
        quizMap.add(new MultipleQuestions("Whats the best food?", multipleChoiceTestOption, multipleChoiceTestAnswer, 3));
        HashMap<Character,String> checkboxTestOption = new HashMap<>();
        checkboxTestOption.put('A', "Doggo");
        checkboxTestOption.put('B', "Catto");
        checkboxTestOption.put('C', "Spider");
        HashMap<Character,String> checkboxTestAnswers = new HashMap<>();
        checkboxTestAnswers.put('A', "Doggo");
        checkboxTestAnswers.put('B', "Catto");
        quizMap.add(new CheckboxQuestion("Best pet?", checkboxTestOption,checkboxTestAnswers,1));

        boolean cancel = false;
        do {
            System.out.println("0: Add question\n1: Run Quiz\n2: Grade Quiz\n5: cancel\n");
            int choice = scan.nextInt();
            if(choice == 0){
                quizMap.add(quiz.addQuestion());
            }else if(choice == 1){
                tally = quiz.runQuiz(quizMap);
            }else if(choice == 2){
                System.out.println("You scored: " +quiz.gradeQuiz(tally,quizMap) + "%");
            }else if(choice == 5){
                cancel = true;
            }

        } while (!cancel) ;
    }
}