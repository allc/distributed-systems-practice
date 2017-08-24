public class Producer {

    public static void main(String[] args) {
        FireAlarmJMS alarm = new FireAlarmJMS();
        alarm.raise();
    }

}
