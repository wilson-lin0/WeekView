package cs3500.pa05.model;

import cs3500.pa05.model.enumerations.Days;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

/**
 * Represents a list of labels.
 */
public class LabelLists {
  private List<Label> sundayList;
  private List<Label> mondayList;
  private List<Label> tuesdayList;
  private List<Label> wednesdayList;
  private List<Label> thursdayList;
  private List<Label> fridayList;
  private List<Label> saturdayList;

  private List<Label> sundayTaskList;
  private List<Label> mondayTaskList;
  private List<Label> tuesdayTaskList;
  private List<Label> wednesdayTaskList;
  private List<Label> thursdayTaskList;
  private List<Label> fridayTaskList;
  private List<Label> saturdayTaskList;
  private List<Label> eventTaskList;

  /**
   * Creates a LabelList.
   */
  public LabelLists() {
    sundayList = new ArrayList<>();
    mondayList = new ArrayList<>();
    tuesdayList = new ArrayList<>();
    wednesdayList = new ArrayList<>();
    thursdayList = new ArrayList<>();
    fridayList = new ArrayList<>();
    saturdayList = new ArrayList<>();

    sundayTaskList = new ArrayList<>();
    mondayTaskList = new ArrayList<>();
    tuesdayTaskList = new ArrayList<>();
    wednesdayTaskList = new ArrayList<>();
    thursdayTaskList = new ArrayList<>();
    fridayTaskList = new ArrayList<>();
    saturdayTaskList = new ArrayList<>();

    eventTaskList = new ArrayList<>();
  }

  /**
   * Returns the event list for Sunday.
   *
   * @return event list
   */
  public List<Label> getSundayList() {
    return this.sundayList;
  }

  /**
   * Returns the task list for Sunday.
   *
   * @return task list
   */
  public List<Label> getSundayTaskList() {
    return this.sundayTaskList;
  }

  /**
   * Returns the event list for Monday.
   *
   * @return event list
   */
  public List<Label> getMondayList() {
    return this.mondayList;
  }

  /**
   * Returns the task list for Monday.
   *
   * @return task list
   */
  public List<Label> getMondayTaskList() {
    return this.mondayTaskList;
  }

  /**
   * Returns the event list for Tuesday.
   *
   * @return event list
   */
  public List<Label> getTuesdayList() {
    return this.tuesdayList;
  }

  /**
   * Returns the task list for Tuesday.
   *
   * @return task list
   */
  public List<Label> getTuesdayTaskList() {
    return this.tuesdayTaskList;
  }

  /**
   * Returns the event list for Wednesday.
   *
   * @return event list
   */
  public List<Label> getWednesdayList() {
    return this.wednesdayList;
  }

  /**
   * Returns the task list for Wednesday.
   *
   * @return task list
   */
  public List<Label> getWednesdayTaskList() {
    return this.wednesdayTaskList;
  }

  /**
   * Returns the event list for Thursday.
   *
   * @return event list
   */
  public List<Label> getThursdayList() {
    return this.thursdayList;
  }

  /**
   * Returns the task list for Thursday.
   *
   * @return task list
   */
  public List<Label> getThursdayTaskList() {
    return this.thursdayTaskList;
  }

  /**
   * Returns the event list for Friday.
   *
   * @return event list
   */
  public List<Label> getFridayList() {
    return this.fridayList;
  }

  /**
   * Returns the task list for Friday.
   *
   * @return task list
   */
  public List<Label> getFridayTaskList() {
    return this.fridayTaskList;
  }

  /**
   * Returns the event list for Saturday.
   *
   * @return event list
   */
  public List<Label> getSaturdayList() {
    return this.saturdayList;
  }

  /**
   * Returns the task list for Saturday.
   *
   * @return task list
   */
  public List<Label> getSaturdayTaskList() {
    return this.saturdayTaskList;
  }

  public List<Label> getEventTaskList() {
    return this.eventTaskList;
  }

  /**
   * Adds the event to the list.
   *
   * @param label the label
   * @param day   the day
   */
  public void addEventToList(Label label, Days day) {
    if (day.equals(Days.SUNDAY)) {
      sundayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.MONDAY)) {
      mondayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.TUESDAY)) {
      tuesdayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesdayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.THURSDAY)) {
      thursdayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.FRIDAY)) {
      fridayList.add(label);
      eventTaskList.add(label);
    } else {
      saturdayList.add(label);
      eventTaskList.add(label);
    }
  }

  /**
   * Adds the task to the list.
   *
   * @param label the label
   * @param day   the day
   */
  public void addTaskToList(Label label, Days day) {
    if (day.equals(Days.SUNDAY)) {
      sundayTaskList.add(label);
      sundayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.MONDAY)) {
      mondayTaskList.add(label);
      mondayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.TUESDAY)) {
      tuesdayTaskList.add(label);
      tuesdayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesdayTaskList.add(label);
      tuesdayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.THURSDAY)) {
      thursdayTaskList.add(label);
      thursdayList.add(label);
      eventTaskList.add(label);
    } else if (day.equals(Days.FRIDAY)) {
      fridayTaskList.add(label);
      fridayList.add(label);
      eventTaskList.add(label);
    } else {
      saturdayTaskList.add(label);
      saturdayList.add(label);
      eventTaskList.add(label);
    }
  }

  /**
   * Clears all the lists.
   */
  public void clearAll() {
    sundayList.clear();
    sundayTaskList.clear();
    mondayList.clear();
    mondayTaskList.clear();
    tuesdayList.clear();
    tuesdayTaskList.clear();
    wednesdayList.clear();
    wednesdayTaskList.clear();
    thursdayList.clear();
    thursdayTaskList.clear();
    fridayList.clear();
    fridayTaskList.clear();
    saturdayList.clear();
    saturdayTaskList.clear();
    eventTaskList.clear();
  }
}
