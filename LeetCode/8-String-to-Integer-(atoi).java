class Solution(object):
    chars = {
        "0": 0,
        "1": 1,
        "2": 2,
        "3": 3,
        "4": 4,
        "5": 5,
        "6": 6,
        "7": 7,
        "8": 8,
        "9": 9,
    }

    _INT_MAX =  2147483647
    _INT_MIN = -2147483648

    def myAtoi(self, s) -> int:
        """
        :type s: str
        :rtype: int
        """
        isNegative:bool = False
        s = s.strip()
        if len(s) == 0:
            return 0
        if (s[0] == "-" or s[0] == "+"):
            if (s[0] == "-"):
                isNegative = True
                
            s = s[1:]

        num: int = 0
        for i in range(0, len(s), +1):
            current:chr = s[i]
            if current not in self.chars:
                break
            currentToInt: int = int(self.chars[current])
            num *= 10
            num += currentToInt

        if isNegative is True:
            num *= -1
            if num < self._INT_MIN:
                return self._INT_MIN
            return num
        else:
            if num > self._INT_MAX:
                return self._INT_MAX
            return num