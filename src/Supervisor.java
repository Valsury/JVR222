public class Supervisor implements IPrinter {
    private String[] textFieldStrings = new String[]
            {"Свет в гостинной", "Свет на кухне",
                    "Сотовый вент. в гост.", "Гаражная дверь",
                    "Стерео система", "Общий свет", "Режим вечеринки"};

    private Pult pult;
    private RemoteControl remoteControl;
    public final static int buttonsCount = 8;

    public Supervisor() {
        pult = new Pult(textFieldStrings, buttonsCount, this);
        remoteControl = new RemoteControl();
    }

    @Override
    public void print(String message) {

        pult.setTextOut(remoteControl.toString(message));
        if (message.length() == 3) {
            int slot = Integer.parseInt(message.substring(2, 3));
            remoteControl.onButtonWasPushed((slot));
        } else {
            int slot = Integer.parseInt(message.substring(3, 4));
            remoteControl.offButtonWasPushed((slot));
        }
    }

    public void start() {
        Pult pult = new Pult(textFieldStrings, buttonsCount, this);
        pult.setTextOut("Проба\nHello\nWorld!");
        pult.myCreateAndShowAPI(pult);
        pult.setTextOut("Новая проба прошла!");


        // Создание устройств

        Light livingRoomLight = new Light("в гостинной", pult);
        Light KitchenLight = new Light("на кухне", pult);
        Light AllLight = new Light("", pult);
        Stereo livingRoomStereo = new Stereo("в гостинной", pult);
        GarageDoor LivingGarage = new GarageDoor(pult);
        CeilingFan LivingFan = new CeilingFan("", pult);

// Создание команд для управления освещением

        LivingRoomLightOnCommand livingRoomLightOnCommand =
                new LivingRoomLightOnCommand(livingRoomLight);
        LivingRoomLightOffCommand livingRoomLightOffCommand =
                new LivingRoomLightOffCommand(livingRoomLight);

// Создание команд для управления стереосистемой

        StereoOnWithCommand stereoOnWithCommand =
                new StereoOnWithCommand(livingRoomStereo);
        StereoOffCommand stereoOffCommand =
                new StereoOffCommand(livingRoomStereo);

        GarageDoorOnCommand garageOn =
                new GarageDoorOnCommand(LivingGarage);
        GarageDoorOffCommand garageOff =
                new GarageDoorOffCommand(LivingGarage);

        CeilingFanOnCommand FanOn =
                new CeilingFanOnCommand(LivingFan);
        CeilingFanOffCommand FanOff =
                new CeilingFanOffCommand(LivingFan);

        LivingRoomLightOnCommand KitchenLightOnCommand =
                new LivingRoomLightOnCommand(KitchenLight);
        LivingRoomLightOffCommand KitchenLightOffCommand =
                new LivingRoomLightOffCommand(KitchenLight);

        LivingRoomLightOnCommand AllLightOnCommand =
                new LivingRoomLightOnCommand(AllLight);
        LivingRoomLightOffCommand AllLightOffCommand =
                new LivingRoomLightOffCommand(AllLight);

// Готовые команды связываются с ячейками пульта

        remoteControl.setCommand(1, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(2, KitchenLightOnCommand, KitchenLightOffCommand);
        remoteControl.setCommand(3, FanOn, FanOff);
        remoteControl.setCommand(4, garageOn, garageOff);
        remoteControl.setCommand(5, stereoOnWithCommand, stereoOffCommand);
        remoteControl.setCommand(6, AllLightOnCommand, AllLightOffCommand);


    }

}
