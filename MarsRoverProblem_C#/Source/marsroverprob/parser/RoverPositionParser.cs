using System;

using marsroverprob.parser.intf;
using marsroverprob.model;
using marsroverprob.helper;

namespace marsroverprob.parser.posImpl
{
    class RoverPositionParser : IAbstractParser
    {
        public Rover parse(Rover rover, String roverInput, String maxPos) {
            return RoverHelper.constructRover(rover, roverInput, maxPos);
        }
    }
}