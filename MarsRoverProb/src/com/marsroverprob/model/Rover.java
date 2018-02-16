package com.marsroverprob.model;

import com.marsroverprob.constants.RoverConstants;

public class Rover {

  public Rover() {
    super();
  }

  private int xcoordinate;
  private int ycoordinate;
  private Orientation orientation;

  /**
   * This is a parameterized constructor for Rover class.
   * @param xcoordinate - X coordinate of the rover
   * @param ycoordinate - Y coordinate of the rover
   * @param orientation - direction of the rover
   */
  public Rover(int xcoordinate, int ycoordinate, Orientation orientation) {
    super();
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

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.getxCoordinate());
    builder.append(RoverConstants.BLANK_SPACE);
    builder.append(this.getyCoordinate());
    builder.append(RoverConstants.BLANK_SPACE);
    builder.append(this.getOrientation());
    return builder.toString();
  }
}
