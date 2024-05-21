public class PartyMod {
    private Pult pult;

    public PartyMod(Pult pult){
        this.pult=pult;
    }

    public void PartyOn(){pult.setTextOut("Режим включен");}
    public void PartyOff(){pult.setTextOut("Режим выключен");}
}
