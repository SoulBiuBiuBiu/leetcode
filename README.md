# leetcode

## 位运算 （与或非，左移，右移，无符号左移、右移）

### 知识点

> 1. 负数比正数多1，考虑边界的时候需要慎重
> 2. “>>” 带符号位移 ，”>>>“ 无符号位移

### 题目

> P001

> P003 题解 https://leetcode-cn.com/problems/w3tCBm/solution/rang-ni-miao-dong-de-shuang-bai-ti-jie-b-84hh/

> P004

> P005

## 双指针

> P006

> P007（*） 排序 去重技巧

> p019

> p021 链表的题目再删除的时候，考虑添加一个头结点

## 滑动窗口

> P008

> p009(*)  一般来说求连续的子数组或者子数组个数 可以考虑双指针或者滑动窗口来解决

> p014 需要懂得提取题目中的性质， A字符串排列之后变为B -> A与B长度一致；A与B字符个数一致

> p017（*）注意一起一伏

## 前綴和

### 知识点

针对“连续区间和问题” ，不是连续区间和问题可以转换为连续区间和问题

### 题目

> p010(*) 滑动窗口对于 数组中存在负数的情况不适用，因为不知道应该往左边还是右边扩展，可以采用前缀和的方式。

> p011 与p010类似，但需要懂得转换问题

> p012 问题中如果存在一些关系，可以进行推导，然后得出一些精简的结论。

### 回文中心扩展

> p020 关键是要知道 回文中心枚举出来有2n-1个，然后分别计算出left和right

## 链表

### 细节题

> p029

### 有没有坏，环的入口在哪？（快慢指针）

> p022 不要记错了相关结论，第一次相遇的时候在环内，再从头开始，相遇才是环节点的入口。

### 第一个重合点在哪？

> p023 a+c=m,b+c=n ->交换走-> a+c+b =b+c +a;

### 寻找链表中点 + 链表逆序 + 合并链表

> p026(*) 链表全方位联系

> P027

### 深度优先搜索

> p028 双向链表处理

## 哈希表

> p030 设计 ： 动态数组+hash

> p031 设计 ： 双向队列+hash

## 时间处理

> p035 注意边界处理

## 栈

> p037(*)

### 单调栈

单调递增栈：单调递增栈就是从栈底到栈顶数据是从大到小

单调递减栈：单调递减栈就是从栈底到栈顶数据是从小到大
> p038(*) 经典题目

> p039(**) 没有理解透彻
