using System;

using marsroverprob.commands.intf;
using marsroverprob.model;
using marsroverprob.helper;

namespace marsroverprob.commands.rotateright 
{
    class RotateRightCommand : IRoverCommand {
        public void execute(Rover rover, String maxPos) {
            RoverHelper.rotateRight(rover, maxPos);
        }
    }
}