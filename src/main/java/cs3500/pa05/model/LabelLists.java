package cs3500.pa05.model;

import cs3500.pa05.model.enumerations.Days;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;

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

  public List<Label> getSundayEventList() {
    return sundayEventList;
  }

  public List<Label> getSundayTaskList() {
    return sundayTaskList;
  }

  public List<Label> getMondayEventList() {
    return mondayEventList;
  }

  public List<Label> getMondayTaskList() {
    return mondayTaskList;
  }

  public List<Label> getTuesdayEventList() {
    return tuesdayEventList;
  }

  public List<Label> getTuesdayTaskList() {
    return tuesdayTaskList;
  }

  public List<Label> getWednesdayEventList() {
    return wednesdayEventList;
  }

  public List<Label> getWednesdayTaskList() {
    return wednesdayTaskList;
  }

  public List<Label> getThursdayEventList() {
    return thursdayEventList;
  }

  public List<Label> getThursdayTaskList() {
    return thursdayTaskList;
  }

  public List<Label> getFridayEventList() {
    return fridayEventList;
  }

  public List<Label> getFridayTaskList() {
    return fridayTaskList;
  }

  public List<Label> getSaturdayEventList() {
    return saturdayEventList;
  }

  public List<Label> getSaturdayTaskList() {
    return saturdayTaskList;
  }

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
