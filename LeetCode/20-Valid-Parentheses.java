using System.Collections.Generic;

public class Solution {
    public bool IsValid(string s) {
        if (s.Length == 0) return true; 

        Stack<char> Parentheses = new Stack<char>();
        
        for (int i = 0; i < s.Length; ++i) {
            char current = s[i];

            if (current == '(' || current == '[' || current == '{') {
                Parentheses.Push(current);
            }
            else if (current == ')' || current == ']' || current == '}') {
                if (Parentheses.Count == 0) {
                    return false;
                }
                
                char top = Parentheses.Peek();

                if (current == ')' && top == '(') {
                    Parentheses.Pop();
                } else if (current == ']' && top == '[') {
                    Parentheses.Pop();
                } else if (current == '}' && top == '{') {
                    Parentheses.Pop();
                } else {
                    return false; 
                }
            } 
        }

        return Parentheses.Count == 0;
    }
}