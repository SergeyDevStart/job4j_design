package ru.job4j.ood.isp.violation.message;

public interface Message {
    String sendSms(String text);

    byte[] sendVoice(byte[] voice);
}
