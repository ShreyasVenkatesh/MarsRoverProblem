using System;
using marsroverprob.executor.intf;
using marsroverprob.model;
using marsroverprob.parser.intf;
using marsroverprob.parser.posImpl;
using marsroverprob.parser.commdImpl;

namespace marsroverprob.executor.impl
{
    class MarsRoverExecutor : IAbstractExecutor
    {
        public Rover execute(String roverPos, String roverCmds, String maxPos){
                IAbstractParser roverPosParser = new RoverPositionParser();
                IAbstractParser roverCmdsParser = new RoverCommandsParser();
                Rover rover = new Rover(0,0,Orientation.N);
                roverPosParser.parse(rover, roverPos, maxPos);
                roverCmdsParser.parse(rover, roverCmds, maxPos);
                Console.WriteLine(rover);
                return rover;
        }
    }
}