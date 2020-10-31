//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P08 Badger Coaster
// Files: BoardingGroup.java,RideQueue.java,ThemeParkApp.java
// Course: (CS 300, Spring, and 2020)
//
// Author: Sai Rahul Reddy Kondlapudi
// Email: kondlapudi@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////

/**
 * @author SaiRahulReddyKondlapudi
 * @Description This is an instantiable class that will be used to represent groups entering the
 *              ride line.
 *
 */
public class BoardingGroup {

  private String nameOfGroup;
  private int numOfPeopleInGroup;
  private boolean isVip;

  /**
   * This is the constructor for BoardingGroup which takes in two parameters. This also initialises
   * the other fields in the class.
   * 
   * @param nameOfGroup        - used to represent the name of the group
   * @param numOfPeopleInGroup - used to represent the number of people in the group
   */
  public BoardingGroup(String nameOfGroup, int numOfPeopleInGroup) {
    this.nameOfGroup = nameOfGroup;
    this.numOfPeopleInGroup = numOfPeopleInGroup;
    this.isVip = false;
  }

  /**
   * This method is an accessor for the field nameOfGroup
   * 
   * @return The value in nameOfGroup
   */
  public String getNameOfGroup() {
    return nameOfGroup;
  }

  /**
   * This is the accessor for the field numOfPeopleInGroup
   * 
   * @return The value in numOfPeopleInGroup.
   */
  public int getNumOfPeopleInGroup() {
    return numOfPeopleInGroup;
  }

  /**
   * This is an accessor for the field isVip.
   * 
   * @return The value in isVip.
   */
  public boolean isVip() {
    return isVip;
  }

  /**
   * This is the mutator for the field isVip. It sets Vip to non Vip and vice-versa.
   */
  public void setVip() {
    if (this.isVip == true) {
      this.isVip = false;
    }
    if (this.isVip == false) {
      this.isVip = true;
    }
  }
}