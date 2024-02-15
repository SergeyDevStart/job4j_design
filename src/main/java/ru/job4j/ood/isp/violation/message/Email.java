package ru.job4j.ood.isp.violation.message;

public class Email implements Message {
    @Override
    public String sendSms(String text) {
        return null;
    }

    /**
     * В данном случае, классу Email приходится оставять метод пустым, т.к в
     * почте нет голосовых сообщений.Это говорит о нарушении ISP.
     */
    @Override
    public byte[] sendVoice(byte[] voice) {
        throw new UnsupportedOperationException();
    }
}
