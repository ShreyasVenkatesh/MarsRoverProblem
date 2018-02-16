package com.marsroverprob.parser;

import com.marsroverprob.helper.RoverHelper;
import com.marsroverprob.model.Rover;

public class RoverPositionParser implements AbstractParser {

  @Override
  public Rover parse(Rover rover, String roverInput, String maxPos) {
    return RoverHelper.constructRover(rover, roverInput, maxPos);
  }

}