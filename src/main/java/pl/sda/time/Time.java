package pl.sda.time;

import java.time.LocalTime;
import java.util.Objects;

/**
 * @author Tomasz Krutowski
 */
public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours + minutes / 60;
        this.minutes = minutes % 60;
    }

    public Time(String timeString) {
        String[] words = timeString.split(" ");
        try {
            this.hours = Integer.parseInt(words[0]);
            this.minutes = Integer.parseInt(words[2]);

        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna wartość!");
        }
    }

    public Time add(Time t) {
        int h = this.hours + t.hours + ((this.minutes + t.minutes) / 60);
        int m = (this.minutes + t.minutes) % 60;

        return new Time(h, m);
    }

    public Time sub(Time t) {
        int h = this.hours - t.hours - ((this.minutes - t.minutes) / 60);
        int m = (this.minutes - t.minutes) % 60;

        return new Time(h, m);
    }

    public Time multiply(int value) {
        int h = this.hours * value;
        int m = this.minutes * value;
        return new Time(h, m);
    }

    public static Time sum(Time[] tab, int n) {
        int h = 0;
        int m = 0;
        for (Time t : tab) {
            h += t.hours;
            m += t.minutes;
        }
        return new Time(h, m);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time)) return false;
        Time time = (Time) o;
        return hours == time.hours &&
                minutes == time.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }

    @Override
    public String toString() {
        return hours + " h " + minutes + " min";
    }
}
