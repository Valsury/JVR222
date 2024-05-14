public class Supervisor {
    private String[] textFieldStrings = new String[]
            {"Свет в доме", "Гараж", "Подвал",
            "Парковка", "Мастерская", "Теплица 1", "Теплица 2"};
    private int buttonsCount = 9;

    private Pult pult;

    public Supervisor() {pult = new Pult(textFieldStrings, buttonsCount, this);}

    public void print(String message){
        pult.setTextOut(message);
    }
    public void start() {
        Pult pult = new Pult(textFieldStrings, buttonsCount, this);
        pult.setTextOut("Проба\nHello\nWorld!");
        pult.myCreateAndShowAPI(pult);
        pult.setTextOut("Новая проба прошла!");

    }

}
