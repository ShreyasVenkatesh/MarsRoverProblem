package com.marsroverprob.model;

import com.marsroverprob.constants.RoverConstants;

public class Rover {

  public Rover() {
    super();
  }

  private int xCoordinate;
  private int yCoordinate;
  private Orientation orientation;

  public Rover(int xCoordinate, int yCoordinate, Orientation orientation) {
    super();
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.orientation = orientation;
  }

  public int getxCoordinate() {
    return xCoordinate;
  }

  public void setxCoordinate(int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public int getyCoordinate() {
    return yCoordinate;
  }

  public void setyCoordinate(int yCoordinate) {
    this.yCoordinate = yCoordinate;
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
