package com.marsroverprob.executer;

import com.marsroverprob.model.Rover;

public interface AbstractExecutor {

	Rover execute(String roverPos, String roverCmds, String maxPos);
}
