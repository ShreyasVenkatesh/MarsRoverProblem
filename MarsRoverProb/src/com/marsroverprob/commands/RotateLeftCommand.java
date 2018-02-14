package com.marsroverprob.commands;

import com.marsroverprob.helper.RoverHelper;
import com.marsroverprob.model.Rover;

public class RotateLeftCommand implements RoverCommand {

  public void execute(Rover rover, String maxPos) {
    RoverHelper.rotateLeft(rover, maxPos);
  }

}
