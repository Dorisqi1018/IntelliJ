
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.next();
        System.out.println("Are you a student? (True/False)");
        boolean studentOrNot = in.nextBoolean();

        Person p1;

        if (studentOrNot) {


            //For students, GPA

            ArrayList<Double> scores = new ArrayList<>();

            System.out.println("Please enter all of your scores in this class.");

            while (true) {
                System.out.print("Enter a grade (-1 to stop): ");
                double x = in.nextDouble();

                if (x <= 4.0 && x >= 0.0) {
                    //Store the user input
                    scores.add(x);
                }
                else {
                    break;
                }
            }

            double sum = 0.0;
            for (int a = 0; a < scores.size(); a++) {
                sum = sum + scores.get(a);
            }
            double gpa = sum / scores.size();

            p1 = new Student(name, gpa);
            System.out.println(p1);



        } else {
            //for teachers
            p1 = new Teacher(name);

            System.out.println(p1);
        }

        //name of the lesson
        System.out.println("What is the name of this lesson?");
        String lessonName = in.next();

        //Ask for the professor's name.
        System.out.println("What is the first name of the professor in this lesson?");
        String professorName = in.next();
        String professorLastName;

        try {
            BufferedReader firstNameReader = new BufferedReader(new FileReader("ProfessorFirstName.txt"));
            BufferedReader lastNameReader = new BufferedReader(new FileReader("ProfessorLastName.txt"));

            int nameLine;
            boolean foundName = false;
            for (nameLine = 0; firstNameReader.ready(); nameLine++) {
                String line = firstNameReader.readLine();

                if (line.compareToIgnoreCase(professorName) == 0) {
                    foundName = true;
                    break;
                }
            }

            if (!foundName) {
                System.out.println("Failed to find first name: " + professorName);
                return;
            }
            else {
                List<String> names = lastNameReader
                    .lines()
                    .skip(nameLine)
                    .limit(1)
                    .collect(Collectors.toList());

                if (names.size() < 1) {
                    System.out.println("No last name found");
                    return;
                }
                else {
                    professorLastName = names.get(0);

                    System.out.println("Professor last name: " + professorLastName);
                }
            }
        }
        catch (IOException ex) {
            System.out.println("Failed to read file: " + ex.getMessage());
            return;
        }



        //choice begin

        System.out.println("Which category would you like to evaluate on?" +
                "(Please enter Plans / Lessons / Motivation / Feedback)");
        String category = in.next();
        int one, two, three, four;

        if (category.equals("Plans")) {
            System.out.println("Please enter 5(totally agree), 4(basically agree), 3(neutral)," +
                    " 2(basically disagree), 1(disagree).");
            System.out.println("1. Materials and resources of the class are available for you.");
            one = in.nextInt();
            System.out.println("2. All the activities in the class are related to the curriculum.");
            two = in.nextInt();
            System.out.println("3. All the grouping plans are according to the instructional plans.");
            three = in.nextInt();
            System.out.println("4. You know the long-ranged plan of the class.");
            four = in.nextInt();

        } else if (category.equals("Lessons")) {
            System.out.println("Please enter 5(totally agree), 4(basically agree), 3(neutral)," +
                    " 2(basically disagree), 1(disagree).");
            System.out.println("1. The materials in the lesson are clearly and logically.");
            one = in.nextInt();
            System.out.println("2. You are provided with models, demonstrates and examples in the lesson.");
            two = in.nextInt();
            System.out.println("3. You are provided opportunities to practice under the direct supervision of the teacher.");
            three = in.nextInt();
            System.out.println("4. There is always a smoothly transition from one activity to the next.");
            four = in.nextInt();

        } else if (category.equals("Motivation")) {
            System.out.println("Please enter 5(totally agree), 4(basically agree), 3(neutral)," +
                    " 2(basically disagree), 1(disagree).");
            System.out.println("1. You are interested in teachers' lesson objective.");
            one = in.nextInt();
            System.out.println("2. You can get extrinsic or intrinsic reward after doing something good.");
            two = in.nextInt();
            System.out.println("3. You have invited to participate to most of the activities in the class.");
            three = in.nextInt();
            System.out.println("4. You are communicated from the teacher about the expectations of performance.");
            four = in.nextInt();

        } else if (category.equals("Feedback")) {
            System.out.println("Please enter 5(totally agree), 4(basically agree), 3(neutral)," +
                    " 2(basically disagree), 1(disagree).");
            System.out.println("1. You are provided with feedback on assignment as soon as possible.");
            one = in.nextInt();
            System.out.println("2. The feedback has written and oral comments, as well as points or scores.");
            two = in.nextInt();
            System.out.println("3. You have been provided opportunities for one-to-one conferences to discuss your progress.");
            three = in.nextInt();
            System.out.println("4. The test results have been interpreted to you and also your parents.");
            four = in.nextInt();

        } else {
            System.out.println("Error. Please try again.");
            return;
        }

        Choice c1 = new Choice(one, two, three, four, name);
        System.out.println(c1);
        Print r1 = new Print(one, two, three, four, name);


        //canvas
        Text t1 = new Text(600, 100, "Teacher Evaluation System Result");
        t1.grow(500,50);
        t1.draw();
        Text t2 = new Text(300, 200, "Course: " + lessonName);
        t2.grow(150,35);
        t2.draw();
        Text t3 = new Text(300, 300, "Teacher: " + professorName + " " + professorLastName);
        t3.grow(200,30);
        t3.draw();
        Text t4 = new Text(500, 400, "GPA: " + p1);
        t4.grow(400,30);
        t4.draw();
        Text t5 = new Text(600, 500,  "Final Evaluation: " + r1);
        t5.grow(500,50);
        t5.setColor(Color.RED);
        t5.draw();

        Rectangle re1 = new Rectangle(50,50,1200,600);
        re1.draw();
        Rectangle re2 = new Rectangle(70,50,30,90);
        re2.draw();
        re2.setColor(Color.BLUE);
        re2.fill();
    }
}
