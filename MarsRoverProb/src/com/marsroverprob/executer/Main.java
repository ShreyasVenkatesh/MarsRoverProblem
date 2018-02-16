package com.marsroverprob.executer;

import java.util.Scanner;

public class Main {

  /**
   * This is the main method to invoke the executer.
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
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String maxPos = scanner.nextLine();
    String rover1Pos = scanner.nextLine();
    String rover1Cmds = scanner.nextLine();
    String rover2Pos = scanner.nextLine();
    String rover2Cmds = scanner.nextLine();
    AbstractExecutor executor = new MarsRoverExecutor();
    executor.execute(rover1Pos, rover1Cmds, maxPos);
    executor.execute(rover2Pos, rover2Cmds, maxPos);
    scanner.close();
  }

}
