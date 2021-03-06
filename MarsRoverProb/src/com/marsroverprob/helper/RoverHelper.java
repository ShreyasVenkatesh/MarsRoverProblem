package com.marsroverprob.helper;

import com.marsroverprob.constants.RoverConstants;
import com.marsroverprob.factory.CommandFactory;
import com.marsroverprob.model.Orientation;
import com.marsroverprob.model.Rover;

import org.apache.commons.lang.StringUtils;

public class RoverHelper {

  private static final CommandFactory COMMAND_FACTORY = new CommandFactory();

  /**
   * This method is invoke to move the rover ahead one step.
   * @param rover - rover's current position details
   * @param maxPos - boundary of the planet
   */
  public static void moveAhead(Rover rover, String maxPos) {
    String[] maxPosCords = getMaxCoords(maxPos);
    if (maxPosCords.length == 2) {
      if (rover.getOrientation().equals(Orientation.N)) {
        rover.setyCoordinate(Math.min(rover.getyCoordinate() + 1, 
            Integer.parseInt(maxPosCords[1])));
      } else if (rover.getOrientation().equals(Orientation.W)) {
        rover.setxCoordinate(Math.min(rover.getxCoordinate() - 1, 
            Integer.parseInt(maxPosCords[0])));
      } else if (rover.getOrientation().equals(Orientation.S)) {
        rover.setyCoordinate(Math.min(rover.getyCoordinate() - 1, 
            Integer.parseInt(maxPosCords[1])));
      } else if (rover.getOrientation().equals(Orientation.E)) {
        rover.setxCoordinate(Math.min(rover.getxCoordinate() + 1,
            Integer.parseInt(maxPosCords[0])));
      }
    }
  }

  /**
   * This method is invoke to rotate the rover 90 degree left.
   * @param rover - rover's current position details
   * @param maxPos - boundary of the planet
   */
  public static void rotateLeft(Rover rover, String maxPos) {
    if (rover.getOrientation().equals(Orientation.N)) {
      rover.setOrientation(Orientation.W);
    } else if (rover.getOrientation().equals(Orientation.W)) {
      rover.setOrientation(Orientation.S);
    } else if (rover.getOrientation().equals(Orientation.S)) {
      rover.setOrientation(Orientation.E);
    } else if (rover.getOrientation().equals(Orientation.E)) {
      rover.setOrientation(Orientation.N);
    }
  }

  /**
   * This method is invoke to rotate the rover 90 degree right.
   * @param rover - rover's current position details
   * @param maxPos - boundary of the planet
   */
  public static void rotateRight(Rover rover, String maxPos) {
    if (rover.getOrientation().equals(Orientation.N)) {
      rover.setOrientation(Orientation.E);
    } else if (rover.getOrientation().equals(Orientation.E)) {
      rover.setOrientation(Orientation.S);
    } else if (rover.getOrientation().equals(Orientation.S)) {
      rover.setOrientation(Orientation.W);
    } else if (rover.getOrientation().equals(Orientation.W)) {
      rover.setOrientation(Orientation.N);
    }
  }

  /**
   * This method is used to fetch the actual orientation enum value of rover from string.
   * @param orientationStr - Orientation of the rover in String
   * @return Orientation - returns orientation enum value
   */
  public static Orientation getOrientation(String orientationStr) {
    Orientation orientation = null;
    if (orientationStr.equals(RoverConstants.NORTH)) {
      orientation = Orientation.N;
    } else if (orientationStr.equals(RoverConstants.SOUTH)) {
      orientation = Orientation.S;
    } else if (orientationStr.equals(RoverConstants.WEST)) {
      orientation = Orientation.W;
    } else if (orientationStr.equals(RoverConstants.EAST)) {
      orientation = Orientation.E;
    }
    return orientation;
  }

  /**
    * This method is used to construct the rover.
    * @param rover - rover's default position details
    * @param roverPos - rover's actual position
    * @param maxPos - boundary of the planet
    * @return
    */
  public static Rover constructRover(Rover rover, String roverPos, String maxPos) {
    if (StringUtils.isNotEmpty(roverPos)) {
      String[] positions = roverPos.split(RoverConstants.MATCH_SPACE);
      String[] maxCoords = getMaxCoords(maxPos);
      if (positions.length == 3 && maxCoords.length == 2) {
        rover = new Rover(Math.min(Integer.parseInt(positions[0]), Integer.parseInt(maxCoords[0])),
            Math.min(Integer.parseInt(positions[1]), Integer.parseInt(maxCoords[1])),
            RoverHelper.getOrientation(positions[2]));
      }
    }
    return rover;
  }

  private static String[] getMaxCoords(String maxPos) {
    String[] maxPosCords = new String[2];
    if (StringUtils.isNotEmpty(maxPos)) {
      maxPosCords = maxPos.split(RoverConstants.MATCH_SPACE);
    }
    return maxPosCords;
  }


  /**
   * This method is used to move/rotate rover.
   * @param rover - input rover to move/rotate
   * @param roverInput - rover commands to be executed
   * @param maxPos - boundary of the planet
   * @return Rover - final rover position
   */
  public static Rover moveRover(Rover rover, String roverInput, String maxPos) {
    for (int strIndex = 0; strIndex < roverInput.length(); strIndex++) {
      String currstr = String.valueOf(roverInput.charAt(strIndex));
      if (currstr.equals(RoverConstants.MOVE_AHEAD)) {
        COMMAND_FACTORY.getFactory(RoverConstants.MOVE_AHEAD).execute(rover, maxPos);
      } else if (currstr.equals(RoverConstants.ROTATE_LEFT)) {
        COMMAND_FACTORY.getFactory(RoverConstants.ROTATE_LEFT).execute(rover, maxPos);
      } else if (currstr.equals(RoverConstants.ROTATE_RIGHT)) {
        COMMAND_FACTORY.getFactory(RoverConstants.ROTATE_RIGHT).execute(rover, maxPos);
      }
    }
    return rover;
  }

}
