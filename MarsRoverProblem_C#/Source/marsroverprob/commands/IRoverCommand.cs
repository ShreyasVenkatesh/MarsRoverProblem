using System;

using marsroverprob.model;

namespace marsroverprob.commands.intf
{
    public interface IRoverCommand
    {
        void execute(Rover rover, String maxPos);
    }
}