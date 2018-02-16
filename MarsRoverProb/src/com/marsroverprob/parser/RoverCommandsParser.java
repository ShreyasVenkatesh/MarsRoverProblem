package com.marsroverprob.parser;

import com.marsroverprob.helper.RoverHelper;
import com.marsroverprob.model.Rover;

public class RoverCommandsParser implements AbstractParser {

  @Override
  public Rover parse(Rover rover, String roverInput, String maxPos) {
    return RoverHelper.moveRover(rover, roverInput, maxPos);
  }
}
