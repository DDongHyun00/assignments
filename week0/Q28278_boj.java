package week0;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q28278_boj {
    static Stack<Integer> stackInt = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N; i++){
            String s = br.readLine();
            if(s.startsWith("1")){
                String arr[] = s.split(" ");
                stackInt.add(Integer.parseInt(arr[1]));

            }
            else{
                stack_(Integer.parseInt(s));
            }
        }
        System.out.println(sb.toString());
    }

    public static void stack_(int num){
        switch(num) {
            case 2:
                if(stackInt.empty()) {
                    sb.append(-1 + "\n");
                }
                else {
                    sb.append(stackInt.pop() + "\n");
                }
                break;

            case 3:
                sb.append(stackInt.size() + "\n");
                break;

            case 4:
                if(stackInt.empty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
                break;

            case 5:
                if(stackInt.empty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stackInt.peek() + "\n");
                }
                break;
        }
    }
}
