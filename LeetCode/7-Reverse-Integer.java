using System;

public class Solution {
    public int Reverse(int x) {
        bool isNegative = (x < 0);

        if (isNegative) x *= -1;

        string number = "";
        while (x > 0) {
            int digit = x % 10;
            char digitChar = (char)('0' + digit); 
            number += digitChar;
            x /= 10;
        }

        if (isNegative) number = "-" + number;

        if (Int32.TryParse(number, out int result))
        {
            return result;
        }
        else
        {
            return 0;
        }
    }
}