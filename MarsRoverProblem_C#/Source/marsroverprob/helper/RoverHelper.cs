using System;
using System.Text;

using marsroverprob.constants;
using marsroverprob.factory;
using marsroverprob.model;

namespace marsroverprob.helper
{
    
public class RoverHelper {

  private static readonly CommandFactory COMMAND_FACTORY = new CommandFactory();

  /**
   * This method is invoke to move the rover ahead one step.
   * @param rover - rover's current position details
   * @param maxPos - boundary of the planet
   */
  public static void moveAhead(Rover rover, String maxPos) {
    String[] maxPosCords = getMaxCoords(maxPos);
    if (maxPosCords.Length == 2) {
      if (rover.getOrientation().Equals(Orientation.N)) {
        rover.setyCoordinate(Math.Min(rover.getyCoordinate() + 1, 
            Int32.Parse(maxPosCords[1])));
      } else if (rover.getOrientation().Equals(Orientation.W)) {
        rover.setxCoordinate(Math.Min(rover.getxCoordinate() - 1, 
            Int32.Parse(maxPosCords[0])));
      } else if (rover.getOrientation().Equals(Orientation.S)) {
        rover.setyCoordinate(Math.Min(rover.getyCoordinate() - 1, 
            Int32.Parse(maxPosCords[1])));
      } else if (rover.getOrientation().Equals(Orientation.E)) {
        rover.setxCoordinate(Math.Min(rover.getxCoordinate() + 1,
            Int32.Parse(maxPosCords[0])));
      }
    }
  }

  /**
   * This method is invoke to rotate the rover 90 degree left.
   * @param rover - rover's current position details
   * @param maxPos - boundary of the planet
   */
  public static void rotateLeft(Rover rover, String maxPos) {
    if (rover.getOrientation().Equals(Orientation.N)) {
      rover.setOrientation(Orientation.W);
    } else if (rover.getOrientation().Equals(Orientation.W)) {
      rover.setOrientation(Orientation.S);
    } else if (rover.getOrientation().Equals(Orientation.S)) {
      rover.setOrientation(Orientation.E);
    } else if (rover.getOrientation().Equals(Orientation.E)) {
      rover.setOrientation(Orientation.N);
    }
  }

  /**
   * This method is invoke to rotate the rover 90 degree right.
   * @param rover - rover's current position details
   * @param maxPos - boundary of the planet
   */
  public static void rotateRight(Rover rover, String maxPos) {
    if (rover.getOrientation().Equals(Orientation.N)) {
      rover.setOrientation(Orientation.E);
    } else if (rover.getOrientation().Equals(Orientation.E)) {
      rover.setOrientation(Orientation.S);
    } else if (rover.getOrientation().Equals(Orientation.S)) {
      rover.setOrientation(Orientation.W);
    } else if (rover.getOrientation().Equals(Orientation.W)) {
      rover.setOrientation(Orientation.N);
    }
  }

  /**
   * This method is used to fetch the actual orientation enum value of rover from string.
   * @param orientationStr - Orientation of the rover in String
   * @return Orientation - returns orientation enum value
   */
  public static Orientation getOrientation(String orientationStr) {
    Orientation orientation = Orientation.N;
    if (orientationStr.Equals(RoverConstants.NORTH)) {
      orientation = Orientation.N;
    } else if (orientationStr.Equals(RoverConstants.SOUTH)) {
      orientation = Orientation.S;
    } else if (orientationStr.Equals(RoverConstants.WEST)) {
      orientation = Orientation.W;
    } else if (orientationStr.Equals(RoverConstants.EAST)) {
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
    if (!String.IsNullOrEmpty(roverPos)) {
      String[] positions = roverPos.Split(RoverConstants.BLANK_SPACE);
      String[] maxCoords = getMaxCoords(maxPos);
      if (positions.Length == 3 && maxCoords.Length == 2) {
        rover.setxCoordinate(Math.Min(Int32.Parse(positions[0]), Int32.Parse(maxCoords[0])));
        rover.setyCoordinate(Math.Min(Int32.Parse(positions[1]), Int32.Parse(maxCoords[1])));
        rover.setOrientation(RoverHelper.getOrientation(positions[2]));
      }
    }
    return rover;
  }

  private static String[] getMaxCoords(String maxPos) {
    String[] maxPosCords = new String[2];
    if (!String.IsNullOrEmpty(maxPos)) {
      maxPosCords = maxPos.Split(RoverConstants.BLANK_SPACE);
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
    for (int strIndex = 0; strIndex < roverInput.Length; strIndex++) {
      String currstr = roverInput[strIndex].ToString();
      if (currstr.Equals(RoverConstants.MOVE_AHEAD)) {
        COMMAND_FACTORY.getFactory(RoverConstants.MOVE_AHEAD).execute(rover, maxPos);
      } else if (currstr.Equals(RoverConstants.ROTATE_LEFT)) {
        COMMAND_FACTORY.getFactory(RoverConstants.ROTATE_LEFT).execute(rover, maxPos);
      } else if (currstr.Equals(RoverConstants.ROTATE_RIGHT)) {
        COMMAND_FACTORY.getFactory(RoverConstants.ROTATE_RIGHT).execute(rover, maxPos);
      }
    }
    return rover;
  }

}
}