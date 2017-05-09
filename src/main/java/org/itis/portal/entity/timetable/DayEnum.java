package org.itis.portal.entity.timetable;

/**
 * Created by thefp on 11.04.2017.
 */
public enum DayEnum {
    Monday(2,2,9),Tuesday(3,9,16),Wednesday(4,16,23),Thursday(5,23,30),Friday(6,30,37),Saturday(7,37,43);
    private final int id;
    private final int startRow;
    private final int endRow;
    private final int timeColumn=2;
    DayEnum(int id, int startRow, int endRow) {
        this.id = id;
        this.startRow=startRow;
        this.endRow=endRow;
    }
    public int getValue() { return id; }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getTimeColumn() {
        return timeColumn;
    }
}
