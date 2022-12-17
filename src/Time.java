public class Time {
    private int seconds;
    private int minutes;
    private int hours;

    public Time(int seconds) throws IllegalArgumentException {
        if (seconds < 0 || seconds > 359999) {
            throw new IllegalArgumentException("Seconds incorrect");
        }

        setHours(seconds / (60 * 60));
        seconds %= 60 * 60;

        setMinutes(seconds / 60);
        seconds %= 60;

        setSeconds(seconds);
    }

    int getSeconds() {
        return seconds;
    }

    void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 60) {
            throw new IllegalArgumentException("Seconds incorrect");
        }
        this.seconds = seconds;
    }

    int getMinutes() {
        return minutes;
    }

    void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 60) {
            throw new IllegalArgumentException("Minutes incorrect");
        }
        this.minutes = minutes;
    }

    int getHours() {
        return hours;
    }

    void setHours(int hours) {
        if (hours < 0 || hours > 100) {
            throw new IllegalArgumentException("Hours incorrect");
        }
        this.hours = hours;
    }

    private String getStringByLimit(int min, int max, int value) {
        if (value == min || value == max) {
            return "00";
        } else if (value < 10) {
            return "0" + value;
        }
        return Integer.toString(value);
    }

    public void printTime() {
        String HH = getStringByLimit(0, 100, getHours());
        String MM = getStringByLimit(0, 60, getMinutes());
        String SS = getStringByLimit(0, 60, getSeconds());

        System.out.println(HH + ":" + MM + ":" + SS);
    }
}
