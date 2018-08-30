using System;

using marsroverprob.commands.intf;
using marsroverprob.model;
using marsroverprob.helper;

namespace marsroverprob.commands.movecommand
{
    class MoveCommand : IRoverCommand {
        public void execute(Rover rover, String maxPos) {
            RoverHelper.moveAhead(rover,maxPos);
        }
    }
}