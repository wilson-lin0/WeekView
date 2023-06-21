package cs3500.pa05.model;

import cs3500.pa05.model.enumerations.Days;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

/**
 * Represents a list of labels.
 */
public class LabelLists {
  private List<Label> sundayEventList;
  private List<Label> mondayEventList;
  private List<Label> tuesdayEventList;
  private List<Label> wednesdayEventList;
  private List<Label> thursdayEventList;
  private List<Label> fridayEventList;
  private List<Label> saturdayEventList;

  private List<Label> sundayTaskList;
  private List<Label> mondayTaskList;
  private  List<Label> tuesdayTaskList;
  private List<Label> wednesdayTaskList;
  private List<Label> thursdayTaskList;
  private List<Label> fridayTaskList;
  private List<Label> saturdayTaskList;

  /**
   * Creates a LabelList.
   */
  public LabelLists() {
    sundayEventList = new ArrayList<>();
    mondayEventList = new ArrayList<>();
    tuesdayEventList = new ArrayList<>();
    wednesdayEventList = new ArrayList<>();
    thursdayEventList = new ArrayList<>();
    fridayEventList = new ArrayList<>();
    saturdayEventList = new ArrayList<>();

    sundayTaskList = new ArrayList<>();
    mondayTaskList = new ArrayList<>();
    tuesdayTaskList = new ArrayList<>();
    wednesdayTaskList = new ArrayList<>();
    thursdayTaskList = new ArrayList<>();
    fridayTaskList = new ArrayList<>();
    saturdayTaskList = new ArrayList<>();
  }

  /**
   * Returns the event list for Sunday.
   *
   * @return event list
   */
  public List<Label> getSundayEventList() {
    return sundayEventList;
  }

  /**
   * Returns the task list for Sunday.
   *
   * @return task list
   */
  public List<Label> getSundayTaskList() {
    return sundayTaskList;
  }

  /**
   * Returns the event list for Monday.
   *
   * @return event list
   */
  public List<Label> getMondayEventList() {
    return mondayEventList;
  }

  /**
   * Returns the task list for Monday.
   *
   * @return task list
   */
  public List<Label> getMondayTaskList() {
    return mondayTaskList;
  }

  /**
   * Returns the event list for Tuesday.
   *
   * @return event list
   */
  public List<Label> getTuesdayEventList() {
    return tuesdayEventList;
  }

  /**
   * Returns the task list for Tuesday.
   *
   * @return task list
   */
  public List<Label> getTuesdayTaskList() {
    return tuesdayTaskList;
  }

  /**
   * Returns the event list for Wednesday.
   *
   * @return event list
   */
  public List<Label> getWednesdayEventList() {
    return wednesdayEventList;
  }

  /**
   * Returns the task list for Wednesday.
   *
   * @return task list
   */
  public List<Label> getWednesdayTaskList() {
    return wednesdayTaskList;
  }

  /**
   * Returns the event list for Thursday.
   *
   * @return event list
   */
  public List<Label> getThursdayEventList() {
    return thursdayEventList;
  }

  /**
   * Returns the task list for Thursday.
   *
   * @return task list
   */
  public List<Label> getThursdayTaskList() {
    return thursdayTaskList;
  }

  /**
   * Returns the event list for Friday.
   *
   * @return event list
   */
  public List<Label> getFridayEventList() {
    return fridayEventList;
  }

  /**
   * Returns the task list for Friday.
   *
   * @return task list
   */
  public List<Label> getFridayTaskList() {
    return fridayTaskList;
  }

  /**
   * Returns the event list for Saturday.
   *
   * @return event list
   */
  public List<Label> getSaturdayEventList() {
    return saturdayEventList;
  }

  /**
   * Returns the task list for Saturday.
   *
   * @return task list
   */
  public List<Label> getSaturdayTaskList() {
    return saturdayTaskList;
  }

  /**
   * Adds the event to the list.
   *
   * @param label the label
   * @param day the day
   */
  public void addEventToList(Label label, Days day) {
    if (day.equals(Days.SUNDAY)) {
      sundayEventList.add(label);
    } else if (day.equals(Days.MONDAY)) {
      mondayEventList.add(label);
    } else if (day.equals(Days.TUESDAY)) {
      tuesdayEventList.add(label);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesdayEventList.add(label);
    } else if (day.equals(Days.THURSDAY)) {
      thursdayEventList.add(label);
    } else if (day.equals(Days.FRIDAY)) {
      fridayEventList.add(label);
    } else {
      saturdayEventList.add(label);
    }
  }

  /**
   * Adds the task to the list.
   *
   * @param label the label
   * @param day the day
   */
  public void addTaskToList(Label label, Days day) {
    if (day.equals(Days.SUNDAY)) {
      sundayTaskList.add(label);
    } else if (day.equals(Days.MONDAY)) {
      mondayTaskList.add(label);
    } else if (day.equals(Days.TUESDAY)) {
      tuesdayTaskList.add(label);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesdayTaskList.add(label);
    } else if (day.equals(Days.THURSDAY)) {
      thursdayTaskList.add(label);
    } else if (day.equals(Days.FRIDAY)) {
      fridayTaskList.add(label);
    } else {
      saturdayTaskList.add(label);
    }
  }
}
