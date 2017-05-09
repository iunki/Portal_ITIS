package org.itis.portal.entity.timetable;

/**
 * Created by thefp on 13.04.2017.
 */
public class Cell {

    private Integer row;

    private Integer column;

    public Cell(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }
}
