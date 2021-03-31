package ru.itcube;

import java.util.Optional;

public class OptionalExample {
    static class Computer {
        private SoundCard soundcard;

        public SoundCard getSoundcard() {
            return this.soundcard;
        }
    }

    static class SoundCard {
        private USB usb;

        public USB getUsb() {
            return this.usb;
        }
    }

    static class USB {
        private String version;

        public String getVersion() {
            return this.version;
        }
    }


    public static String checkUSBVersion(Computer computer) {
        String version = "UNKNOWN";
        if (computer != null) {
            SoundCard soundcard = computer.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUsb();
                if (usb != null && usb.getVersion() != null) {
                    version = usb.getVersion();
                }
            }
        }
        return version;
    }


    public static void main(String[] args) {
        Computer c = new Computer();
        SoundCard soundCard = new SoundCard();
        USB usb = new USB();
        usb.version = "1.1";
        c.soundcard = soundCard;
        soundCard.usb = usb;

        // null-safe стандартная версия
        //System.out.println(checkUSBVersion(new Computer()));

        //  Optional версия
        System.out.println(checkUSBversionOptional(c));


        // orElse
        //System.out.println(Optional.ofNullable(null).orElse("aaaa"));

        // orElseGet
        //System.out.println(Optional.empty().orElseGet(() -> "bbb"));
    }





    public static String checkUSBversionOptional(Computer computer) {
        return Optional.ofNullable(computer)
                .map(Computer::getSoundcard)
                .map(SoundCard::getUsb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
    }

}
