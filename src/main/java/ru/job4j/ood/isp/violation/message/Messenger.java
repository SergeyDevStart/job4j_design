package ru.job4j.ood.isp.violation.message;

public class Messenger implements Message {
    @Override
    public String sendSms(String text) {
        return null;
    }

    @Override
    public byte[] sendVoice(byte[] voice) {
        return new byte[0];
    }
}
