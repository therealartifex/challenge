using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Solution {
    static void Main(String[] args) {
      var q = int.Parse(Console.ReadLine());
      
      for(var i=0;i<q;i++)
      {
        var p = Console.ReadLine().Split().Select(ulong.Parse).ToArray();
        var sep =0;
        
        while(level(p[0])>level(p[1]))
        {
          p[0] >>= 1;
          ++sep;
        }
        
        while(level(p[1])>level(p[0]))
        {
          p[1] >>= 1;
          ++sep;
        }
        
        while(p[0]!=p[1])
        {
          p[0] >>= 1;
          p[1] >>= 1;
          sep+=2;
        }
        
        Console.WriteLine(sep);
      }
    }
    
    static uint level(ulong n)
    {
      return (uint)Math.Floor(Math.Log(n,2))+1;
    }
}