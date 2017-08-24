public class Consumer {

    public static void main(String[] args) {
        FireAlarmConsumerJMS alarmCall = new FireAlarmConsumerJMS();
        String msg = alarmCall.await();
        System.out.println(msg);
    }

}
