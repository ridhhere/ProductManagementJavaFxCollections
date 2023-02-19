package com.pms.pojo;

// Define a Row class with properties for each column
public class TableDisplay {
    private final String column1;
    private final String column2;
    private final String column3;
    private final String column4;

    public TableDisplay(String column1, String column2, String column3, String column4) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
    }

    public String getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }

    public String getColumn3() {
        return column3;
    }

    public String getColumn4() {
        return column4;
    }
}
