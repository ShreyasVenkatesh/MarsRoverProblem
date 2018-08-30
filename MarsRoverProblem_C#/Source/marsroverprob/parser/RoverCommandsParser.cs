using System;

using marsroverprob.parser.intf;
using marsroverprob.model;
using marsroverprob.helper;

namespace marsroverprob.parser.commdImpl
{
    class RoverCommandsParser : IAbstractParser
    {
          public Rover parse(Rover rover, String roverInput, String maxPos) {
            return RoverHelper.moveRover(rover, roverInput, maxPos);
        }
    }
}