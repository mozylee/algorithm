class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s)==0:
            return 0
        length = len(s)
        visited = set()
        max_count = 0

        left, right = -1, 0

        while(left<=right and right<length):
            if s[right] in visited:
                left+=1
                visited.remove(s[left])
            else:
                visited.add(s[right])
                right+=1
            max_count = max(max_count, len(visited))
        return max_count




s = Solution()

print(s.lengthOfLongestSubstring("abcabcbb"))
print(s.lengthOfLongestSubstring("bbbbb"))
print(s.lengthOfLongestSubstring("pwwkew"))
print(s.lengthOfLongestSubstring("dvdf"))
print(s.lengthOfLongestSubstring("abcb"))