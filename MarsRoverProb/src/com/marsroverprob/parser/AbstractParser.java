package com.marsroverprob.parser;

import com.marsroverprob.model.Rover;

public interface AbstractParser {

	Rover parse(Rover rover, String roverInput, String maxPos);
}
