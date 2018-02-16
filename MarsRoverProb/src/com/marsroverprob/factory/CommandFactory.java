package com.marsroverprob.factory;

import com.marsroverprob.commands.MoveCommand;
import com.marsroverprob.commands.RotateLeftCommand;
import com.marsroverprob.commands.RotateRightCommand;
import com.marsroverprob.commands.RoverCommand;
import com.marsroverprob.constants.RoverConstants;

public class CommandFactory {

  private MoveCommand moveCommand = new MoveCommand();
  private RotateLeftCommand rotateLeftCommand = new RotateLeftCommand();
  private RotateRightCommand rotateRightCommand = new RotateRightCommand();

  /**
   * This method is used to fetch respective factory methods.
   * @param factoryType - factoryType input string
   * @return RoverCommand - respective RoverCommand Object
   */
  public RoverCommand getFactory(String factoryType) {
    RoverCommand command = null;
    if (factoryType.equals(RoverConstants.MOVE_AHEAD)) {
      command = getMoveCommand();
    } else if (factoryType.equals(RoverConstants.ROTATE_LEFT)) {
      command = getRotateLeftCommand();
    } else if (factoryType.equals(RoverConstants.ROTATE_RIGHT)) {
      command = getRotateRightCommand();
    }

    return command;
  }

  public MoveCommand getMoveCommand() {
    return moveCommand;
  }

  public void setMoveCommand(MoveCommand moveCommand) {
    this.moveCommand = moveCommand;
  }

  public RotateLeftCommand getRotateLeftCommand() {
    return rotateLeftCommand;
  }

  public void setRotateLeftCommand(RotateLeftCommand rotateLeftCommand) {
    this.rotateLeftCommand = rotateLeftCommand;
  }

  public RotateRightCommand getRotateRightCommand() {
    return rotateRightCommand;
  }

  public void setRotateRightCommand(RotateRightCommand rotateRightCommand) {
    this.rotateRightCommand = rotateRightCommand;
  }

}
