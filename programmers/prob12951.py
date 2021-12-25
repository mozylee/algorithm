def solution(s: str) -> str:
    return " ".join([token.capitalize() for token in s.lower().split(" ")])


test_cases = ["3people unFollowed me", "for the last week"]
# "3people Unfollowed Me"
# "For The Last Week"
for t in test_cases:
    print(solution(t))
