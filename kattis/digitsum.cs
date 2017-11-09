// Challenge:   https://open.kattis.com/problems/digitsum
// Solved:      10 Oct 2016 14:25:29

using System;
using System.Linq;

class Solution
{
	public static void Main()
	{
		var n = int.Parse(Console.ReadLine());
		for (int i = 0; i < n; i++)
		{
			ulong[] d = Array.ConvertAll(Console.ReadLine().Split(' '), ulong.Parse);
			var s = solve(d[1] + 1) - solve(d[0]);
			Console.WriteLine(s);
		}
	}

	static ulong solve(ulong n)
	{
		if (n <= 0) return 0;
		if (n % 10 == 0) return 10 * solve(n / 10) + 45 * (n / 10);
		return solve(n - 1) + (ulong)(n - 1).ToString().Sum(c => c - '0');
	}
}