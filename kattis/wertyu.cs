// Challenge:   https://open.kattis.com/problems/wertyu
// Solved:      06 Sep 2017 16:48:36

using System;
using System.Collections.Generic;
using System.Linq;

class Solution
{
    public static void Main (string[] args)
    {
        var mapping = new Dictionary<char,string>()
        {
            {'W',"Q"},
            {'S',"A"},
            {'X',"Z"},
            {'E',"W"},
            {'D',"S"},
            {'C',"X"},
            {'R',"E"},
            {'F',"D"},
            {'V',"C"},
            {'T',"R"},
            {'G',"F"},
            {'B',"V"},
            {'Y',"T"},
            {'H',"G"},
            {'N',"B"},
            {'U',"Y"},
            {'J',"H"},
            {'M',"N"},
            {'I',"U"},
            {'K',"J"},
            {',',"M"},
            {'O',"I"},
            {'L',"K"},
            {'.',","},
            {'P',"O"},
            {';',"L"},
            {'/',"."},
            {'[',"P"},
            {'\'',";"},
            {']',"["},
            {'\\',"]"},
            {'1',"`"},
            {'2',"1"},
            {'3',"2"},
            {'4',"3"},
            {'5',"4"},
            {'6',"5"},
            {'7',"6"},
            {'8',"7"},
            {'9',"8"},
            {'0',"9"},
            {'-',"0"},
            {'=',"-"},
            {' '," "}
        };
        string line = Console.ReadLine();
        do
        {
            Console.WriteLine(string.Concat(line.Select(c => mapping[c])));
        } while(!string.IsNullOrEmpty(line = Console.ReadLine())); 
    }
}