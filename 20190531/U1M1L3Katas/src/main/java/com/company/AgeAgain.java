import java.util.Scanner;

public class AgeAgain {

        public static void main(String[] args) {

            Scanner myScanner = new Scanner(System.in);
            String userInput;
            int age;

            System.out.println("Enter your Age : ");

            userInput = myScanner.nextLine();
            age = Integer.parseInt(userInput);

            if (age < 14 ) {
                System.out.println("What grade are you in? ");
                String userGrade;
                userGrade = myScanner.nextLine();
            }

            else if (age >= 14 && age <= 18) {

                System.out.println("Are you planning to go to college?");
                String ans;
                ans = myScanner.nextLine();
                if (ans.equals("yes")){
                    System.out.println("What college are you going?");
                    String college;
                    college = myScanner.nextLine();
                    System.out.println(college + " is great school.");
                }
                else if (ans.equals("no")) {
                    System.out.println("What you want to do after high school");
                    System.out.println("Sounds like a plan!");
                }
            }
            else {
                System.out.println("what is your job?");
                String job;
                job = myScanner.nextLine();
                System.out.println(job + " sounds like a great job!");
            }
        }
    }


