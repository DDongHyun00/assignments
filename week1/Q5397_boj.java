package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5397_boj {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < L; i++){
            String str = br.readLine();

            String password = solution(str);
            System.out.println(password);
        }
    }

    public static String solution(String str){
        Stack<Character> stack = new Stack<>();
        Stack<Character> tmp = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int j = 0 ; j < str.length(); j++){
            switch(str.charAt(j)){
                case'<':
                    if(!stack.isEmpty()) tmp.push(stack.pop());
                    break;
                case'>':
                    if(!tmp.isEmpty()) stack.push(tmp.pop());
                    break;
                case'-':
                    if(!stack.isEmpty()) stack.pop();
                    break;
                default:
                    stack.push(str.charAt(j));
                    break;
            }

        }
        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
        }

        for(int j = 0 ; j < stack.size(); j++){
            sb.append(stack.elementAt(j));
        }
        return sb.toString();
    }
}
