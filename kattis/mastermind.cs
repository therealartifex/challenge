// Challenge:   https://open.kattis.com/problems/mastermind
// Solved:      07 Nov 2017 22:49:41

using System;
using System.Collections.Generic;
using System.Linq;

class Solution
{
    static void Main(String[] args)
    {
        var p = Console.ReadLine().Split().Skip(1).Select(q => q.ToCharArray());
        var n = p.First().Length;
        var a = p.First();
        var b = p.Last();
    
        var s = 0;
        var r = 0;
    
        for (var i=0;i<n;i++)
        {
            if (a[i]==b[i])
            {
                ++r;
                a[i] = b[i] = '_';
            }
        }
    
        s =  a.Intersect(b).Where(c => c != '_').Sum(ch => Math.Min(b.Count(k=>k==ch),a.Count(l=>l==ch)));
        Console.WriteLine($"{r} {s}");
    }
}