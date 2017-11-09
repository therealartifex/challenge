using System;
using System.Collections.Generic;
using System.IO;

class Solution {
          static void Main(string[] args)
        {
            var _prefs = new List<int>();
            var _board = new List<int> { 0, 0, 0, 0, 0, 0, 0, 0, 0};

            for (var i = 1; i <= 9; i++)
            {
                var c = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                var index = (c[0] * 3 + c[1]) - 4;
                _prefs.Add(index);
            }

            var output = solve(_board, _prefs);
            foreach (var v in output)Console.WriteLine($"{v/3+1} {v%3+1}");
            
        }

        private static bool solved(List<int> board)
        {
            var sum1 = board[0] + board[1] + board[2];
            var sum2 = board[3] + board[4] + board[5];
            var sum3 = board[6] + board[7] + board[8];

            var sum4 = board[0] + board[3] + board[6];
            var sum5 = board[1] + board[4] + board[7];
            var sum6 = board[2] + board[5] + board[8];

            var sum7 = board[0] + board[4] + board[8];
            var sum8 = board[2] + board[4] + board[6];

            return (sum1 == 3 || sum1 == -3) || (sum2 == 3 || sum2 == -3) || (sum3 == 3 || sum3 == -3) || (sum4 == 3 || sum4 == -3) || (sum5 == 3 || sum5 == -3) || (sum6 == 3 || sum6 == -3) || (sum7 == 3 || sum7 == -3) || (sum8 == 3 || sum8 == -3);
        }

        private static List<int> betterSolution(List<int> b1, List<int> b2)
        {
            if (b1.Count < b2.Count) return b1;
            if (b2.Count < b1.Count) return b2;

            for (var i = 0; i < 9; i++)
            {
                var r1 = b1[i] / 3;
                var c1 = b1[i] % 3;
                var r2 = b2[i] / 3;
                var c2 = b2[i] % 3;


                if (r1 < r2) return b1;
                if (r2 < r1) return b2;
                if (c1 < c2) return b1;
                if (c2 < c1) return b2;

            }

            return b1;
        }


        private static List<int> solve(List<int> board, List<int> prefs)
        {
            var nextPref = -1;
            //Make Bob's move first
            foreach (var p in prefs)
            {
                if (board[p] != 0) continue;
                board[p] = 1;
                nextPref = p;
                break;
            }

            var moves = new List<int>();
            if (solved(board))
            {
                if(nextPref != -1)
                  board[nextPref] = 0;
                return moves;
            }

            //Try all possible moves, keep best one
            for (var loc = 0; loc < 9; loc++)
            {
                if (board[loc] == 0)
                {
                    board[loc] = -1;
                    if (!solved(board))
                    {
                        var attempt = solve(board, prefs);
                        attempt.Insert(0,loc);
                        moves = moves.Count==0 ? attempt : betterSolution(moves, attempt);
                    }
                    board[loc] = 0;
                }
            }
            if(nextPref != -1)
              board[nextPref] = 0;
            if(moves.Count == 0)
              return new List<int> { 0,0,0,0,0,0,0,0,0 };
            return moves;
        }
}