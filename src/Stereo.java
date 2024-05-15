public class Stereo {
    private Pult pult;


    public Stereo(String inRoom,Pult pult) {

        this.pult = pult;

    }


    public void on() {

        pult.setTextOut("Стереосистема включена");
    }

    public void off() {
        pult.setTextOut("Стереосистема выключена");

    }


    public void setCD() {
        pult.setTextOut("Установить CD диск");
    }


    public void setDVD() {
        pult.setTextOut("Установить DVD диск");
    }


    public void setRadio() {
        pult.setTextOut("Установить радио");
    }


    public void setVolume(String value) {
        pult.setTextOut("Изменить звук до " + value);
    }
}
