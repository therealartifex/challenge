// Challenge:   https://open.kattis.com/problems/slatkisi
// Solved:      27 Sep 2017 04:54:18

using System;
using System.Linq;

class Solution
{
    public static void Main (string[] args)
    {
        var p = Array.ConvertAll(Console.ReadLine().Split(), double.Parse);
        Console.WriteLine(Math.Round(p[0]*Math.Pow(10, -p[1]))*Math.Pow(10, p[1]));
    }
}