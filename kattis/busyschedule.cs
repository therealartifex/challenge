// Challenge:   https://open.kattis.com/problems/busyschedule
// Solved:      23 Oct 2017 00:03:16

using System;
using System.Collections.Generic;
using System.Linq;

class Solution
{
    static void Main(String[] args)
    {
        while(true)
        {
            var t = int.Parse(Console.ReadLine());
            if (t==0) break;
            var d = new List<DateTime>();

            for (var i=0;i<t;i++)
            {
                var s = Console.ReadLine().Replace(".","");
                d.Add(DateTime.Parse(s));
            }

            var sd = d.OrderBy(x => x.TimeOfDay).ToList();
            foreach (var date in sd) Console.WriteLine($"{date.ToString("t").ToLower().Replace("a","a.").Replace("p","p.")}.");
            Console.WriteLine();
        }
    }
}