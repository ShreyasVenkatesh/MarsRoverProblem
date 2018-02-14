package com.marsroverprob.commands;

import com.marsroverprob.model.Rover;

public interface RoverCommand {

  void execute(Rover rover, String maxPos);
}
