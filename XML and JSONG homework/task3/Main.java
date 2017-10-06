package task3;
import task3.xmlComponents.Query;

import java.io.File;


public class Main {

	public static void main(String[] args) {
		Query query = Transformer.getFromXML("http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys");

		File file = new File("E:/Java/Pro/xmlLesson/src/task3/1.xml");

		Transformer.setToXml(query, file);
	}

}
