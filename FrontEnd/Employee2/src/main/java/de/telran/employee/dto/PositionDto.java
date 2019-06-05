package de.telran.employee.dto;

public class PositionDto {

    private int value;
    private String display;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "PositionDto{" +
                "value=" + value +
                ", display='" + display + '\'' +
                '}';
    }
}
