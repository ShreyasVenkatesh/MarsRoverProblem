package com.marsroverprob.executer;

import com.marsroverprob.model.Rover;
import com.marsroverprob.parser.AbstractParser;
import com.marsroverprob.parser.RoverCommandsParser;
import com.marsroverprob.parser.RoverPositionParser;

public class MarsRoverExecutor implements AbstractExecutor {

  @Override
  public Rover execute(String roverPos, String roverCmds, String maxPos) {
    AbstractParser roverPosParser = new RoverPositionParser();
    AbstractParser roverCmdsParser = new RoverCommandsParser();
    Rover rover = new Rover();
    rover = roverPosParser.parse(rover, roverPos, maxPos);
    rover = roverCmdsParser.parse(rover, roverCmds, maxPos);
    System.out.println(rover.toString());
    return rover;
  }

}
