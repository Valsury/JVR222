public class CeilingFan {
    private Pult pult;
    private String inRoom;

    public CeilingFan(String inRoom, Pult pult)
    {
        this.inRoom=inRoom;
        this.pult=pult;
    }

    public  void FanOn(){pult.setTextOut("Потолочный вентилятор "+inRoom+" включен");}

    public  void FanOff(){pult.setTextOut("Потолочный вентилятор "+inRoom+" выключен");}
}
