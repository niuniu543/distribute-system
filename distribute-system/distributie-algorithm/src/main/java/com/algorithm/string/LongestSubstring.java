package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 获取字符串中不包含重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
 */
public class LongestSubstring {

    public static void main(String[] arges){
        String aa="asdfasdfdfghj";
        LongestSubstring tt=new LongestSubstring();
        int i = tt.lengthOfLongestSubstring(aa);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s){
        //使用hashSet记录每一个字符是否出现过
        Set<Character> occ=new HashSet<>();
        int n=s.length();
        //又指针初始值为-1，相当于我们在字符串左边界的左侧，还没有开始移动
        int rk=-1,ans=0;
        for (int i=0;i<n;i++){
            if (i !=0){
                //左指针向右移动一格删除一个字符
                occ.remove(s.charAt(i-1));
            }
            while (rk+1<n && !occ.contains(s.charAt(rk+1))){
                //不断的向右移动指针，将元素添加到集合中
                occ.add(s.charAt(rk+1));
                rk++;
            }
            //第i到rk个字符是一个极长的无重复子串
            ans=Math.max(ans,rk-i+1);
        }
        return ans;


    }
}
