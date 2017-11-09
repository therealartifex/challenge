// Challenge:   https://open.kattis.com/problems/sjecista
// Solved:      27 Sep 2017 12:10:25

using System;
using System.Linq;

class Solution
{
    public static void Main (string[] args)
    {
        var n = int.Parse(Console.ReadLine());
        Console.WriteLine(n*(n-1)*(n-2)*(n-3)/24);
    }
}