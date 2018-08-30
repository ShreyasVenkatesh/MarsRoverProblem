using System;
using marsroverprob.model;
using marsroverprob.executor.intf;
using marsroverprob.executor.impl;

namespace marsroverprob.executor.main
{
    class MarsRoverMain {

/**
  * This is the main method to invoke the executor.
  * @param args - command line arguments
  * 
Test Input:
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
Expected Output:
1 3 N
5 1 E  
   */
        static void Main(string[] args)
      {
                String maxPos = Console.ReadLine();
                String rover1Pos = Console.ReadLine();
                String rover1Cmds = Console.ReadLine();
                String rover2Pos = Console.ReadLine();
                String rover2Cmds = Console.ReadLine();
                try{
                  IAbstractExecutor executor = new MarsRoverExecutor();
                  executor.execute(rover1Pos, rover1Cmds, maxPos);
                  executor.execute(rover2Pos, rover2Cmds, maxPos);
                }catch(Exception exception){
                    Console.WriteLine(exception);
                }

      }

    }
}