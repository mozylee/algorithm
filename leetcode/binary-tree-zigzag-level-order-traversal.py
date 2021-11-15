from collections import deque


class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ret = []
        queue = deque()
        queue.append(root)
        is_left = True
        while queue:
            length = len(queue)
            level = deque()
            for _ in range(length):
                now = queue.popleft()
                if now is None:
                    break
                level.append(now.val) if is_left else level.appendleft(now.val)
                if now.left:
                    queue.append(now.left)
                if now.right:
                    queue.append(now.right)
            is_left = not is_left
            if level:
                ret.append(list(level))
        return ret


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# [[3],[20,9],[15,7]]
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

# [[1],[3,2],[4,5]]
root2 = TreeNode(1)
root2.left = TreeNode(2)
root2.right = TreeNode(3)
root2.left.left = TreeNode(4)
root2.right.right = TreeNode(5)

# []
root3 = None


s = Solution()
print(s.zigzagLevelOrder(root))
print(s.zigzagLevelOrder(root2))
print(s.zigzagLevelOrder(root3))
