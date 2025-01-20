import java.util.Scanner;
public class practiceThing {
public static void main(String[] args){
Scanner reader = new Scanner(System.in);
int score;
boolean valid;
do{
valid = true;
System.out.println("What is your score 0 and 100 : ");
score = reader.nextInt();
if (score < 0 || score > 100){
System.out.println("Try again: must be between 0 and 100");
valid = false;
}
}while (!valid);
}
}
