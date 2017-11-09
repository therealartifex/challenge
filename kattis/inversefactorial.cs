// Challenge:   https://open.kattis.com/problems/inversefactorial
// Solved:      27 Sep 2017 23:32:30

using System;
using System.Collections.Generic;

class Solution
{
    public static void Main (string[] args)
    {
        var fmap = new Dictionary<int, int>() {{1, 1}, {2, 2}, {6, 3}, {24, 4}, {120, 5}, {720,6}, {5040,7}, {40320,8}, {362880,9}};
        var fmap2 = new Dictionary<int, int>() {{ 7, 10 }};
        double lk = 7;
        for (var i = 0; i < 205016; i++)
        {
            lk = lk + Math.Log10(11+i);
            fmap2.Add((int)Math.Round(Math.Round(lk,1,MidpointRounding.AwayFromZero), MidpointRounding.AwayFromZero),11+i);
        }
        
        var s = Console.ReadLine();
        var len = s.Length;
        Console.WriteLine(len >= 7 ? fmap2[len] : fmap[int.Parse(s)]);
    }
}
