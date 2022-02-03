package systango.SalesTaxCalculationProblemStatement;

import java.io.*;

public class SalesReport {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"/home/ubox83/Desktop/java_programs/programs/src/systango/SalesTaxCalculationProblemStatement/data.csv"));
		String oneEntryFromInput = reader.readLine();     // read line by line data from csv file in string format
		PrintWriter writer = new PrintWriter(new FileWriter("solution.csv"));   // print writer object is used to write in destination file
		final int salesTax = 5;
		int numberOfEntryInInputDataSet= 0;
		oneEntryFromInput = reader.readLine();      
		while (oneEntryFromInput != null) {
			if (numberOfEntryInInputDataSet == 0) {
				writer.print("Product-Name" + "," + "Product-CostPrice" + "," + "Product-SalesTax" + ","
						+ "Product-SalesTaxAmount" + "," + "Product-FinalPrice" + "," + "Countries");
				writer.println();
			} else {
				String productDetails[] = oneEntryFromInput.split(",");       
				float productCostPrice = Integer.parseInt(productDetails[1].trim());
				float productSalesTaxAmount = ((productCostPrice * salesTax) / 100);
				writer.print(
						productDetails[0] + "," + productDetails[1] + "," + salesTax + "," + productSalesTaxAmount
								+ "," + productSalesTaxAmount + productCostPrice + "," + productDetails[2]);
				writer.println();
				oneEntryFromInput = reader.readLine();

			}
			numberOfEntryInInputDataSet++;
		}
		reader.close();
		writer.flush();
		writer.close();
		System.out.println(numberOfEntryInInputDataSet - 1);
	}
}