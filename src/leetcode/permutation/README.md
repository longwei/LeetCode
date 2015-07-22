排列组合问题总结：

清楚recursive tree是怎么构建的, 控制每个点pre-condition，after－condition是什么

let path: the path of recursive tree
    nums: be pool we need to permutation or combination
    pos: marker, [0 pos] is processed, (pos end] is todos

核心思想是backtracing
for e in nums
  path.add，
  backtracing(path, nums, pos+1)
  path.pop


subset 因为输入是unique的，path没有到底也算，而且需要记住pos，
====

```
subset(path, nums, pos);
output(path)
  for e [pos nums.length)
    path.add(e)
    subset(path, nums, pos+1);
    path.pop();
```

subset ii,
===
因为输入不能保证uniq， 所以sort之后会出现[1 2 2 ...]
要剔除1 2(3) 2(2) 和 1 2(2) 2(3)
所以每个node，在path.add的时候，需要filter掉多余的elements

```
unique_subset(path, nums, pos);
output(path)
  for e [pos nums.length)
    if(i != pos && nums[i] == nums[i-1]) skip
    path.add(e)
    unique_subset(path, nums, pos+1);
    path.pop();
```

CombinationSum
===

```
CombinationSum(path, nums, pos);
output(path)
  for e [pos nums.length)
    update newSum
      > return
      < path.add(e)
          CombinationSum(path, nums, i);
          path.pop();
      = same as <, except outputToResult

```
Q: 不过既然是combination 为什么需要纪录pos， 而且每次都是pass on pos not pos+1?
A: 因为是每个元素可以被使用多次，所以理论上是不要纪录pos的。不记录pos的结果如下
input: [2,3,6,7], target 7
output:
[2, 2, 3]
[2, 3, 2]
[3, 2, 2]
[7]
又因为[2, 2, 3]，[2, 3, 2]，[3, 2, 2] 是重复元素，需要剔除
如何剔除？确保是ascending order.
input sort就能保证output是ascending order了么？NO. 比如
           2
      22  23
   2222  23[2]

solution 1: i依旧从0开始 只不过 path.add only if cur >= path.peek
solution 2: 纪录pos 为当前的i，通俗的讲就是，如果用了2，子集可以包括2，但是如果2这个node结束了，
比如循环到 [x, 3,6, 7] 的时候，就只能不能用2了。3开头的子集一定不包括2开头的， 因为2开头的一定已经在2的subtree包括了。


LetterCombinations
=====
这次是选择的pool变了，之前都是固定的pool，现在是动态的pool，
这个pool是由input string 的index决定的，所以是double for loop

permutation
====
if the problem is  then we don't need to track the position,
but we need find way to remove that element from pool,
one way to remove the element from the pool is to pass a bool[] visited
another way to swap start and i, so the left zone are picked and right zone are to pick
http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

```
permutation(path, nums);
  toResult
  for i [0, num.length)
    path.add(nums.remove[i])
    permutation(path, nums);
    nums.add(i,path.pop());
```

permuatation unique:

需要注意的是
if( visited[i] || (i != 0 && nums[i] == nums[i-1] && !visited[i-1])){
    continue;
}
选第一个未选取的2开始(作为重复集合中的代表)，每个节点每层有且只有一个*新*2加入, 因为前一个2可能已经进入picked zone, 所以需要!visited[i-1]，


TODO
* iteration method for all them
* DFS