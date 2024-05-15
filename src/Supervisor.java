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
        if(message.length()==3){
            int slot = Integer.parseInt(message.substring(2,3));
            remoteControl.onButtonWasPushed((slot));
        }
        else {
            int slot = Integer.parseInt(message.substring(3,4));
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
        Stereo livingRoomStereo = new Stereo("в гостинной", pult);

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

// Готовые команды связываются с ячейками пульта

        remoteControl.setCommand(1, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(5, stereoOnWithCommand, stereoOffCommand);
    }

}
