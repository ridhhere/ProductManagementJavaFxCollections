package com.pms.pojo;

// Define a Row class with properties for each column
public class TableDisplay {
    private final int column1;
    private final String column2;
    private final int column3;
    private final int column4;

    public TableDisplay(int column1, String column2, int column3, int column4) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
    }

    public int getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }

    public int getColumn3() {
        return column3;
    }

    public int getColumn4() {
        return column4;
    }
}
