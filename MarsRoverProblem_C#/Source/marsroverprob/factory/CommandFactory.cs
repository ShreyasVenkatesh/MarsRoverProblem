using System;

using marsroverprob.commands.rotateleft;
using marsroverprob.commands.rotateright;
using marsroverprob.commands.movecommand;
using marsroverprob.commands.intf;
using marsroverprob.constants;

namespace marsroverprob.factory
{
    class CommandFactory {
        
  private MoveCommand moveCommand = new MoveCommand();
  private RotateLeftCommand rotateLeftCommand = new RotateLeftCommand();
  private RotateRightCommand rotateRightCommand = new RotateRightCommand();

  /**
   * This method is used to fetch respective factory methods.
   * @param factoryType - factoryType input string
   * @return IRoverCommand - respective IRoverCommand Object
   */
  public IRoverCommand getFactory(String factoryType) {
    IRoverCommand command = null;
    if (factoryType.Equals(RoverConstants.MOVE_AHEAD)) {
      command = getMoveCommand();
    } else if (factoryType.Equals(RoverConstants.ROTATE_LEFT)) {
      command = getRotateLeftCommand();
    } else if (factoryType.Equals(RoverConstants.ROTATE_RIGHT)) {
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
}