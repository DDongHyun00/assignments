package week01;

import java.util.Scanner;
import java.util.Stack;

public class Q11899_boj {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Character> st = new Stack<>();

    String str = sc.nextLine();
    int cnt = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        st.push('(');
      } else if (str.charAt(i) == ')') {
        if (st.isEmpty()) cnt++;
        else st.pop();
      }
    }

    System.out.println(cnt+st.size());
  }
}