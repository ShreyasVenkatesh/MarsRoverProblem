using System;
using marsroverprob.model;

namespace marsroverprob.executor.intf
{
    public interface IAbstractExecutor
    {
          Rover execute(String roverPos, String roverCmds, String maxPos);
    }
}