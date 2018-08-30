using System;
using System.Text;
using marsroverprob.constants;

namespace marsroverprob.model
{
    public class Rover{   

      private int xcoordinate;
      private int ycoordinate;
      private Orientation orientation;

      public Rover(int xcoordinate, int ycoordinate, Orientation orientation) {
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
        this.orientation = orientation;
      }

      public int getxCoordinate() {
        return xcoordinate;
      }

      public void setxCoordinate(int xcoordinate) {
        this.xcoordinate = xcoordinate;
      }

      public int getyCoordinate() {
        return ycoordinate;
      }

      public void setyCoordinate(int ycoordinate) {
        this.ycoordinate = ycoordinate;
      }

      public Orientation getOrientation() {
        return orientation;
      }

      public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
      }
        public override String ToString() {
          StringBuilder builder = new StringBuilder();
          builder.Append(this.getxCoordinate());
          builder.Append(RoverConstants.BLANK_SPACE);
          builder.Append(this.getyCoordinate());
          builder.Append(RoverConstants.BLANK_SPACE);
          builder.Append(this.getOrientation());
          return builder.ToString();
        }
    }
}