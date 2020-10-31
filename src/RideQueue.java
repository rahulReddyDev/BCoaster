import java.util.NoSuchElementException;

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
 * @Description This class acts as the queue for the BoardingGroup.
 *
 */
public class RideQueue implements QueueADT<BoardingGroup> {

  private BGNode front;
  private BGNode back;
  private int capacity;
  private int numOfPeople;
  private int numOfGroups;

  /**
   * This is the constructor for RideQueue which takes in one parameter. It also initialises the
   * other fields of the class;
   * 
   * @param capacity - The total capacity of the queue.
   */
  public RideQueue(int capacity) {
    this.capacity = capacity;
    front = null;
    back = null;
    numOfPeople = 0;
    numOfGroups = 0;
  }

  /**
   * This method determines whether or not this queue is empty
   * 
   * @return True when queue is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    if (this.front != null) {
      return false;
    }
    if (this.back != null) {
      return false;
    }
    return true;
  }

  /**
   * This method gives the number of BoardingGroup nodes in this queue.
   * 
   * @return The current number of Groups in the queue.
   */
  @Override
  public int size() {
    return numOfGroups;
  }

  /**
   * This method removes all groups from this queue. This queue will become empty.
   * 
   */
  @Override
  public void clear() {
    front = null;
    back = null;
    numOfGroups = 0;
    numOfPeople = 0;
  }

  /**
   * This method adds the newGroup to the queue.
   * 
   * @param newGroup - The BoardingGroup to be added to the queue.
   * @throws java.lang.IllegalStateException - If the newGroup cannot fit into the queue.
   */
  @Override
  public void enqueue(BoardingGroup newGroup) throws java.lang.IllegalStateException {
    BGNode node = new BGNode(newGroup);
    if (newGroup.getNumOfPeopleInGroup() + numOfPeople > capacity) {
      throw new java.lang.IllegalStateException("The new Group cannot fit in the Queue");
    }
    if (isEmpty()) {
      front = node;
      back = node;

    } else if (newGroup.isVip()) {
      BGNode temp = front;
      front = node;
      front.setNext(temp);
    } else {
      back.setNext(node);
    }
    back = node;
    ++numOfGroups;
    numOfPeople = numOfPeople + newGroup.getNumOfPeopleInGroup();
  }

  /**
   * This method returns the BoardingGroup at the front of this queue without removing it.
   * 
   * @return The Group at the front of the line.
   * @throws java.util.NoSuchElementException - If this queue is empty.
   */
  @Override
  public BoardingGroup peek() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("The Queue is Empty");
    } else {
      return front.getGroup();
    }
  }

  /**
   * This method returns the BoardingGroup at the front of this queue and removes it.
   * 
   * @return The BoardingGroup that was removed from this queue.
   * @throws java.util.NoSuchElementException - If this queue is empty.
   * 
   */
  @Override
  public BoardingGroup dequeue() throws NoSuchElementException {
    if (isEmpty()) {
      throw new NoSuchElementException("The Queue is Empty so it cannot be removed");
    } else {
      BoardingGroup group = front.getGroup();
      front = front.getNext();
      if (front == null) {
        back = null;
      }
      --numOfGroups;
      numOfPeople = numOfPeople - group.getNumOfPeopleInGroup();
      return group;
    }
  }


  /**
   * This method gives a string representation of this queue.
   * 
   * @return This queue represented as a string.
   */
  public String toString() {
    String s = "Number of People in Queue: " + numOfPeople + "\n";
    s += "Number of Groups in Queue: " + numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
      String groupName = current.getGroup().getNameOfGroup();
      s += groupName + " ";
      current = current.getNext();
    }
    return s;
  }
}