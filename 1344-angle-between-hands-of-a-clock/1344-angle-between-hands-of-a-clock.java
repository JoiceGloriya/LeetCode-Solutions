class Solution {
    public double angleClock(int hour, int minutes) {
        double myHour = (hour + (minutes / 60.0)) * 30;
        double myMins = minutes * 6;
        double angle = Math.abs(myHour - myMins);
        angle = Math.min(angle, 360 - Math.abs(myHour - myMins));
        return angle;
    }
}