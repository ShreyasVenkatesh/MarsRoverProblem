using System;

using marsroverprob.commands.intf;
using marsroverprob.model;
using marsroverprob.helper;

namespace marsroverprob.commands.rotateleft 
{
    class RotateLeftCommand : IRoverCommand {
        public void execute(Rover rover, String maxPos) {
            RoverHelper.rotateLeft(rover, maxPos);
        }
    }
}