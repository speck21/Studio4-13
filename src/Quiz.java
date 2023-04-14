import java.util.*;

public class Quiz {
    public Quiz() {


    }

    public Question addQuestion(){
        Scanner scan = new Scanner(System.in);

        //needs to ask for question, possibleAnswers, correctAnswer(s), and value
        String question;
        HashMap<Character,String> possibleAnswers = new HashMap<>();
        HashMap<Character,String> correctAnswers = new HashMap<>();
        int value;
        System.out.println("Enter 0 for true/false.\nEnter 1 for multiple choice.\nEnter 2 for 'checkbox'.\n");
        int choice = scan.nextInt();
        System.out.println("Enter the question: " + "\n");
        question = scan.next();
        //if t/f get correct answer and value, call constructor
        String choiceChar;
        if(choice == 0){
            boolean flag = true;
            do {
                System.out.println("Enter the correct answer: 'A' for True, 'B' for false. ");
                choiceChar = scan.next();
                if (choiceChar.compareTo("A") != 0) {
                    correctAnswers.put('A', "True");
                    flag = false;
                } else if (choiceChar.compareTo("B") != 0) {
                    correctAnswers.put('B', "False");
                    flag = false;
                } else {
                    System.out.println("Enter 'A' or 'B'.");
                    System.out.println(choiceChar);
                }
            }while(flag);
            System.out.println("Enter point value of question: ");
            value = scan.nextInt();
            return new TrueFalseQuestion(question,correctAnswers,value);
        } else if (choice == 1) {
            //MC Q get possibleAnswers, correctAnswer, value, call constructor

            System.out.println("Enter four possible answers.\nA:");
            possibleAnswers.put('A',scan.nextLine());
            System.out.println("B: ");
            possibleAnswers.put('B',scan.nextLine());
            System.out.println("C: ");
            possibleAnswers.put('C',scan.nextLine());
            System.out.println("D: ");
            possibleAnswers.put('D',scan.nextLine());

            System.out.println("Enter the correct answer: (A,B,C,D");

            do{
                choiceChar = scan.nextLine();
                correctAnswers.put(choiceChar.toUpperCase().charAt(0),possibleAnswers.get(choiceChar.toUpperCase().charAt(0)));
            }while(choiceChar.compareTo("A")==0 || choiceChar.compareTo("B")==0 || choiceChar.compareTo("C")==0 || choiceChar.compareTo("D")==0);
            System.out.println("Enter point value of question: ");
            value = scan.nextInt();
            return new MultipleQuestions(question,possibleAnswers,correctAnswers,value);
        }else if(choice == 2){
            //CB Q get possibleAnswers, correctAnswers -> 1-4, value, call constructor

            System.out.println("Enter possible answers. 'X' to move on.");
            char[] options = {'A','B','C','D'};
            int index = 0;
            do{
                System.out.println(options[index] + ": ");
                choiceChar = scan.nextLine();
                possibleAnswers.put(options[index], choiceChar);
                index++;

            }while(choiceChar.compareTo("X")==0 || possibleAnswers.size() !=4);
            System.out.println("Enter correct answers by letter. 'X' to move on.");
            do{
               choiceChar = scan.nextLine();
               if(possibleAnswers.containsKey(choiceChar.toUpperCase().charAt(0))){
                   correctAnswers.put(choiceChar.toUpperCase().charAt(0), possibleAnswers.get(choiceChar.toUpperCase().charAt(0)));
               }else{
                   System.out.println("Enter valid letter");
               }
            }while(choiceChar.compareTo("X")==0 || correctAnswers.size() !=4);
            System.out.println("Enter point value of question: ");
            value = scan.nextInt();
            return new CheckboxQuestion(question,possibleAnswers,correctAnswers,value);
        }else{
            System.out.println("TEST");
            return addQuestion();
        }

    }

    public double runQuiz(ArrayList<Question> quizMap){
        //iterate through array, asking each question and getting each answer, grade in next method not here
        double pointTally=0;
        for(Question question: quizMap){
            pointTally += question.askQuestion();
        }
        return pointTally;
    }

    public double gradeQuiz(double tally, ArrayList<Question> quizMap){
        double totalAvailablePoints = 0;
        System.out.println("Tally: " + tally);
        for(Question question:quizMap){
            totalAvailablePoints += question.getValue();
            System.out.println("Tot: " + totalAvailablePoints);
        }
        return (tally/totalAvailablePoints)*100;
    }
}
