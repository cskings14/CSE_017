import java.util.Stack;
import java.util.Scanner;
import java.util.EmptyStackException;
// import priority queue
import java.util.PriorityQueue;
// import file IO
import java.io.File;
// imort java not found exception
import java.io.FileNotFoundException;

public class StackTest {
    
    
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a postfix expression... ");
        String postfix = s.nextLine();
        String[] tokens = postfix.split(" ");
        String answer;

        do{

            try{
    
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].matches("\\d{1,}")){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (tokens[i]){
                    case "+":
                        stack.push(op2 + op1);
                        break;
                    case "-":
                        stack.push(op2 - op1);
                        break;
                    case "*":
                        stack.push(op2 * op1);
                        break;
                    case "/":
                        stack.push(op2 / op1);
                        break;
                    default:
                        System.out.println("Invalid operator");
                        
                }
            }

        }
        int result = stack.pop();
        if (stack.isEmpty()){
            System.out.println("Result: " + result);
        }
        else{
            System.out.println("Invalid expression");
        }
    } 
    catch (EmptyStackException e){
        System.out.println("The stack is empty");
    }

        stack.clear();
        System.out.println("Do you want to evaulate another expression? (y/n)");
        answer = s.nextLine();
        
    } while(answer.equals("y"));
















    // priority queue 
    PriorityQueue<Job> pq = new PriorityQueue<>();
    readJobs(pq, "jobs.txt");
    long printerSpeed = 10_000;
    long totalSize = 0;
    while (!pq.isEmpty()){
        Job job = pq.poll();
        String time = calcTime(job.getSize(), printerSpeed);
        System.out.printf("%s\t%s\n", job.toString(), time);
        totalSize += job.getSize();




    }
    System.out.println("Total printing time: " + calcTime(totalSize, printerSpeed));
        



    }   

    public static String calcTime(long size, long speed){
        long time = size / speed; // seconds
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String out = "";
        if (time >= 86400){
            days = (int) (time / 86400);
            time = (int) time % 86400;
            if (days < 10){
                out += "0" + days + ":";
            }
            else{
                out += days + ":";
            }
        }
        else
            out += "00:";
        if (time >= 3600){
            hours = (int) (time / 3600);
            time = (int) time % 3600;
            if (hours < 10){
                out += "0" + hours + ":";
            }
            else{
                out += hours + ":";
            }
        }
        else
            out += "00:";
        if (time >= 60){
            minutes = (int) (time / 60);
            time = (int) time % 60;
            if (minutes < 10){
                out += "0" + minutes + ":";
            }
            else{
                out += minutes + ":";
            }
        }
        else
            out += "00:";
        seconds = (int) Math.round(time);
        if (seconds < 10){
            out += "0" + seconds;
        }
        else{
            out += seconds;
        }
        return out;

        

        


    }

    public static void readJobs(PriorityQueue<Job> pq, String fileName) {
        File file = new File(fileName);
        Scanner readFile = null;
        try{
            readFile = new Scanner(file);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
    
        }
        while (readFile.hasNext()){
            int id = readFile.nextInt();
            int group = readFile.nextInt();
            long size = readFile.nextLong();
            Job job = new Job(id, group, size);
            pq.offer(job);
        }
        readFile.close();
    }






}
