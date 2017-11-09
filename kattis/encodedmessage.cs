// Challenge:   https://open.kattis.com/problems/encodedmessage
// Solved:      26 Sep 2017 23:31:06

using System;
class Solution
{
    public static void Main (string[] args)
    {
        var t = int.Parse(Console.ReadLine());
        for (var k=0;k<t;k++)
        {
            var s = Console.ReadLine();
            var sq = (int)Math.Sqrt(s.Length);
    
            for (var i = sq - 1; i != sq * (sq - 1); i += sq)
            {
    	        i = i > s.Length ? i % s.Length-1 : i;
    	        Console.Write(s[i]);
            }
            Console.WriteLine(s[sq * (sq - 1)]);
        }
    }
}