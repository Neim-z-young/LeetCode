class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        charDic = {}
        maxL=0
        curL=0
        for i in range(len(s)):
            if charDic.has_key(s[i]) and i-curL<=charDic[s[i]]:
                    maxL=max(maxL, curL)
                    curL=i-charDic[s[i]]
            else:
                curL+=1
            charDic[s[i]] = i
        maxL=max(maxL,curL)
        return maxL
        