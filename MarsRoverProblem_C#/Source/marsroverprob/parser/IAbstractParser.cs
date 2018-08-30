using System;

using marsroverprob.model;

namespace marsroverprob.parser.intf
{
    public interface IAbstractParser
    {
        Rover parse(Rover rover, String roverInput, String maxPos);
    }
}