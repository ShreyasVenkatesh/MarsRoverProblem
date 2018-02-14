package com.marsroverprob.commands;

import com.marsroverprob.helper.RoverHelper;
import com.marsroverprob.model.Rover;

public class MoveCommand implements RoverCommand {
  public void execute(Rover rover, String maxPos) {
    RoverHelper.moveAhead(rover,maxPos);
  }
}
