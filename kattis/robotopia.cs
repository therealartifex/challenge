// Challenge:   https://open.kattis.com/problems/robotopia
// Solved:      28 Sep 2017 16:33:34

using System;
using System.Collections.Generic;

class Solution
{
    public static void Main (string[] args)
    {
        var t = int.Parse(Console.ReadLine());
        for (var k = 0; k < t; k++)
        {
    	    var c = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
    
    	    var l1 = c[0];
    	    var a1 = c[1];
    	    var l2 = c[2];
    	    var a2 = c[3];
    	    var lt = c[4];
    	    var at = c[5];
    
    	    var sol = new List<Tuple<int, int>>();
    
    	    var x = 1;
    	    while (l1 * x < lt)
    	    {
    		    double y = (lt - l1 * x) / l2;
    
    		    if (unchecked(y == (int)y) && a1 * x + a2 * y == at && l1 * x + l2 * y == lt) sol.Add(new Tuple<int, int>(x, (int)y));
    		    ++x;
    	    }
    
    	    Console.WriteLine(sol.Count == 1 ? $"{sol[0].Item1} {sol[0].Item2}" : "?");
        }
    }
}