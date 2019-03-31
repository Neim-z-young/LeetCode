class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        sLen = len(s)
        i=0
        j=0
        charDic = {}
        maxl=0
        while i<sLen:
            if not charDic.has_key(s[i]):
                charDic[s[i]] = i
                i=i+1
            else:
                i = charDic[s[i]] + 1
                x=len(charDic)
                if x>maxl:
                    maxl=x
                charDic.clear()
        x=len(charDic)
        if x>maxl:
            maxl=x
        return maxl
        