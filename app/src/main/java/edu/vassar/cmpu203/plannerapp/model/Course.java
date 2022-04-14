package edu.vassar.cmpu203.plannerapp.model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class Course {

    public String name;
    public String code;
    public Semester semester;
    public String notes;
    public String room;
    public ArrayList<Pair<LocalDateTime, LocalDateTime>> meetingTimes = new ArrayList<Pair<LocalDateTime, LocalDateTime>>();
    public ArrayList<String> DmeetingTimes = new ArrayList<String>();
    public ArrayList<Task> tasks = new ArrayList<Task>();
    public Pair<ArrayList<Pair<LocalDateTime, LocalDateTime>>, ArrayList<String>> meetingTimesWithDescriptions = new Pair<>(meetingTimes, DmeetingTimes);

    public Course(String name, String code, Semester semester, String notes, String room, ArrayList<Pair<LocalDateTime, LocalDateTime>> meetingTimes) {
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.room = room;
        this.notes = notes;
        this.meetingTimes = meetingTimes;
    }

    public Course() {
        this.name = "";
        this.code = "";
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void setMeetingTimes(ArrayList<Pair<LocalDateTime, LocalDateTime>> meetingTimes) {
        this.meetingTimes = meetingTimes;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void setDmeetingTimes(ArrayList<String> dmeetingTimes) {
        DmeetingTimes = dmeetingTimes;
    }

    public void setMeetingTime(String day, String time, int recurrences) {

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now();
        String mtDescription = "";

        int startHour = Integer.parseInt(time.substring(0, 2));
        String startHourSt = "" + startHour;

        if (startHour < 10) {
            startHourSt = "0" + startHour;
        }

        int startMinute = Integer.parseInt(time.substring(3, 5));
        String startMinuteSt = "" + startMinute;
        if (startMinute < 10) {
            startMinuteSt = "0" + startMinute;
        }

        int endHour = Integer.parseInt(time.substring(time.length() - 6, time.length() - 3));
        if (endHour < 0) {
            endHour *= -1;
        }
        String endHourSt = "" + endHour;
        if (endHour < 10) {
            endHourSt = "0" + endHour;
        }

        int endMinute = Integer.parseInt(time.substring(time.length() - 2, time.length()));
        String endMinuteSt = "" + endMinute;
        if (endMinute < 10) {
            endMinuteSt = "0" + endMinute;
        }

        startTime = startTime.withHour(startHour);
        startTime = startTime.withMinute(startMinute);
        endTime = endTime.withHour(endHour);
        endTime = endTime.withMinute(endMinute);
        day = day.toLowerCase();
        String res = "Meeting time successfully added!";

        // TODO there's almost definitely a way to simplify this,
        // maybe just create a new variable and plug that in for the DOW
        if (day.compareTo("mon") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            meetingTimes.add(StartAndEnd);
            DmeetingTimes.add(mtDescription);
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                meetingTimes.add(StartAndEnd);
                DmeetingTimes.add(mtDescription);
            }
        } else if (day.compareTo("tue") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            meetingTimes.add(StartAndEnd);
            DmeetingTimes.add(mtDescription);
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                meetingTimes.add(StartAndEnd);
                DmeetingTimes.add(mtDescription);
            }
        } else if (day.compareTo("wed") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            meetingTimes.add(StartAndEnd);
            DmeetingTimes.add(mtDescription);
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                meetingTimes.add(StartAndEnd);
                DmeetingTimes.add(mtDescription);
            }
        } else if (day.compareTo("thu") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            meetingTimes.add(StartAndEnd);
            DmeetingTimes.add(mtDescription);
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                meetingTimes.add(StartAndEnd);
                DmeetingTimes.add(mtDescription);
            }
        } else if (day.compareTo("fri") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            meetingTimes.add(StartAndEnd);
            DmeetingTimes.add(mtDescription);
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                meetingTimes.add(StartAndEnd);
                DmeetingTimes.add(mtDescription);
            }
        } else if (day.compareTo("sat") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            meetingTimes.add(StartAndEnd);
            DmeetingTimes.add(mtDescription);
            for (int i = 0; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                meetingTimes.add(StartAndEnd);
                DmeetingTimes.add(mtDescription);
            }
        } else if (day.compareTo("sun") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            meetingTimes.add(StartAndEnd);
            DmeetingTimes.add(mtDescription);
            for (int i = 0; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                meetingTimes.add(StartAndEnd);
                DmeetingTimes.add(mtDescription);
            }
        } else {
            System.out.println("Invalid input. Give a valid day");
        }

        System.out.println(res);

    }

    /* public void removeMeetingTime(String day, String time, int recurrences){
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now();
        String mtDescription = "";
        int priorSize = meetingTimes.size();

        int startHour = Integer.parseInt(time.substring(0, 2));
        String startHourSt = "" + startHour;

        if (startHour < 10) {
            startHourSt = "0" + startHour;
        }
        int startMinute = Integer.parseInt(time.substring(3, 5));
        String startMinuteSt = "" + startMinute;
        if (startMinute < 10) {
            startMinuteSt = "0" + startMinute;
        }
        int endHour = Integer.parseInt(time.substring(time.length() - 6, time.length() - 3));
        if (endHour < 0) {
            endHour *= -1;
        }
        String endHourSt = "" + endHour;
        if (endHour < 10) {
            endHourSt = "0" + endHour;
        }
        int endMinute = Integer.parseInt(time.substring(time.length() - 2, time.length()));
        String endMinuteSt = "" + endMinute;
        if (endMinute < 10) {
            endMinuteSt = "0" + endMinute;
        }
        startTime = startTime.withHour(startHour);
        startTime = startTime.withMinute(startMinute);
        endTime = endTime.withHour(endHour);
        endTime = endTime.withMinute(endMinute);

        if (day.compareTo("mon") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                meetingTimesWithDescriptions.getRight().remove(mtDescription);
            }
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                    meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                    meetingTimesWithDescriptions.getRight().remove(mtDescription);
                }
            }
        } else if (day.compareTo("tue") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                meetingTimesWithDescriptions.getRight().remove(mtDescription);
            }
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                    meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                    meetingTimesWithDescriptions.getRight().remove(mtDescription);
                }
            }
        } else if (day.compareTo("wed") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                meetingTimesWithDescriptions.getRight().remove(mtDescription);
            }
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                    meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                    meetingTimesWithDescriptions.getRight().remove(mtDescription);
                }
            }
        } else if (day.compareTo("thu") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                meetingTimesWithDescriptions.getRight().remove(mtDescription);
            }
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                    meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                    meetingTimesWithDescriptions.getRight().remove(mtDescription);
                }
            }
        } else if (day.compareTo("fri") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                meetingTimesWithDescriptions.getRight().remove(mtDescription);
            }
            for (int i = 1; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                    meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                    meetingTimesWithDescriptions.getRight().remove(mtDescription);
                }
                }
        } else if (day.compareTo("sat") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                meetingTimesWithDescriptions.getRight().remove(mtDescription);
            }
            for (int i = 0; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
                if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                    meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                    meetingTimesWithDescriptions.getRight().remove(mtDescription);
                }
               }
        } else if (day.compareTo("sun") == 0) {
            startTime = startTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            endTime = endTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            Pair<LocalDateTime, LocalDateTime> StartAndEnd = new Pair<>(startTime, endTime);
            mtDescription = "Meeting 1 for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                    + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                    + " at " + endHourSt + ":" + endMinuteSt + ".";
            if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                meetingTimesWithDescriptions.getRight().remove(mtDescription);
            }
           for (int i = 0; i < recurrences; i++) {
                int num = i + 1;
                startTime = startTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
                endTime = endTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
                StartAndEnd = new Pair<>(startTime, endTime);
                mtDescription = "Meeting " + num + " for " + startTime.getDayOfWeek() + " starts on " + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " + startTime.getYear()
                        + " at " + startHourSt + ":" + startMinuteSt + " and ends on " + endTime.getDayOfWeek() + ", " + endTime.getDayOfMonth() + " " + endTime.getMonth() + " " + startTime.getYear()
                        + " at " + endHourSt + ":" + endMinuteSt + ".";
               if(meetingTimesWithDescriptions.getLeft().contains(StartAndEnd) && meetingTimesWithDescriptions.getRight().contains(mtDescription)){
                   meetingTimesWithDescriptions.getLeft().remove(StartAndEnd);
                   meetingTimesWithDescriptions.getRight().remove(mtDescription);
               }
            }
        }

        if (recurrences > 0 && meetingTimes.size() < priorSize){
            System.out.println(recurrences + " meetings successfully removed");
        }


    }

     */

    public String toString() {
        String res = "";
        res += "Course name: " + this.name + "\n" + "Course code: " + this.code + "\n" + "Course semester: " + this.semester.toString() + "\n";
        if (tasks.size() == 0){
            res += "Course tasks: none" + "\n";
        }
        else{
            res += "Course tasks:" + "\n";
            for(int i = 0; i < tasks.size(); i++){
                int num = i + 1;
                res += "Task " + num + ":" + "\n" + tasks.get(i).toString();
            }
        }

        if(meetingTimes.size() == 0){
            res += "Course meeting times: none" + "\n";
        }
        else{
            res += "Course meeting times:" + "\n";
            for(int i = 0; i < meetingTimes.size(); i++){
                res += DmeetingTimes.get(i) + "\n";
            }
        }
        res += "\n";
        return res;
    }



}