from collections import defaultdict, deque


class Solution:

    def canFinish(self, numCourses: int, prerequisites: list) -> bool:
        graph, count = self.init(numCourses, prerequisites)

        q = deque()

        visited = set()
        for course in range(numCourses):
            if count[course] == 0:
                q.append(course)
                visited.add(course)
        print(graph, count, visited)

        if len(visited) == 0:
            return False

        while q:
            now = q.popleft()
            for next in graph[now]:
                if next in visited:
                    return False

                count[next] -= 1

                if count[next] == 0:
                    q.append(next)
                    visited.add(next)

        return len(visited) == numCourses

    def init(self, numCourses, prerequisites):
        count = defaultdict(int)
        graph = {i: [] for i in range(numCourses)}

        for after, before in prerequisites:
            count[after] += 1
            graph[before].append(after)
        return graph, count


s = Solution()

print(s.canFinish(5, [[1, 4], [2, 4], [3, 1], [3, 2]]))
