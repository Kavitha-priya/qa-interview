package codingtest;

public class FizzBuzz {
    public static void main(String[] args){
        String s;
        for(int i = 1; i <= 100; i++){
            s = "";
            if(i % 3 == 0)
                s = s + "FIZZ";
            if(i % 5 == 0)
                s = s + "BUZZ";
            if(s.equals(""))
                s = String.valueOf(i);
            System.out.println(s);
        }

    }
}
