public class PrinterController implements IPrinter {
    private final IPrinter printer;

    public PrinterController(IPrinter printer)
    {
        this.printer=printer;
    }

    public void print(String message)
    {
        printer.print(message);
    }
}
