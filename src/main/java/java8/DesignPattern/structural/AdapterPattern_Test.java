package java8.DesignPattern.structural;

interface Printer
{
	public void print();
}

class DotPrinter implements Printer
{
	private String data;
	
	public DotPrinter(String data) {
		super();
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void print() {
		System.out.println("data: "+data);
	}
}
// client
interface NewPrinter
{
	void scanAndPrint();
}
class AllInOnePrinter implements NewPrinter
{
	private String data;

	public AllInOnePrinter(String data) {
		this.data = data;
	}
	@Override
	public void scanAndPrint() {
		System.out.println("data: "+data);
	}
}

/*
 * Adapter class which acts a bridge between Printer and New Printer
 */
class PrinterAdapter implements NewPrinter
{
	private DotPrinter dotPrinter;

	public PrinterAdapter(Printer dotPrinter) {
		super();
		this.dotPrinter = (DotPrinter) dotPrinter;
	}

	@Override
	public void scanAndPrint() {
		dotPrinter.print();
	}
	
}

public class AdapterPattern_Test {

	public static void main(String[] args) {

		Printer printer = new DotPrinter("ABCDE");
		NewPrinter newPrinter = new PrinterAdapter(printer);
		newPrinter.scanAndPrint();
	}

}
