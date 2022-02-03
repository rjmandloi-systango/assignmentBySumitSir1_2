package systango.SalesTaxCalculationProblemStatement;

import java.io.*;

public class SalesReport2 {
	public static void main(String[] args) throws IOException {

		File inputFile = new File(
				"/home/ubox83/Desktop/java_programs/programs/src/systango/SalesTaxCalculationProblemStatement/data2.csv");
		FileReader fileReader = new FileReader(inputFile);
		if (inputFile.exists()) // checking for file existance
		{
			BufferedReader reader = new BufferedReader(fileReader);
			String oneEntryFromInput = reader.readLine(); // read line by line data from csv file in string format
			PrintWriter writer = new PrintWriter(new FileWriter("solution2.csv")); // print writer object is used to
																					// write in destination file

			int numberOfEntryInInputDataSet = 0;
			oneEntryFromInput = reader.readLine();
			while (oneEntryFromInput != null) {

				if (numberOfEntryInInputDataSet == 0) {
					writer.print("Product-Name" + "," + "Product-CostPrice" + "," + "Product-SalesTax" + ","
							+ "Product-SalesTaxAmount" + "," + "Product-FinalPrice" + "," + "Countries");
					writer.println();
				} else {
					String productDetails[] = oneEntryFromInput.split(",");
					System.out.println(productDetails.length);

					
					if (productDetails.length == 1 || productDetails.length == 2 || productDetails.length == 3) {
						oneEntryFromInput = reader.readLine();
						continue;

					}
					
					for (int count = 0; count < productDetails.length; count++) // checking for null entries in input
																				// dataset and replace it with 0
					{
						if (productDetails[count].isEmpty() || productDetails[count] == null) {
							productDetails[count] = "0";
						}

					}
					float productCostPrice = Float.parseFloat(productDetails[1].trim());
					float salesTax = Float.parseFloat(productDetails[2].trim());
					float productSalesTaxAmount = ((productCostPrice * salesTax) / 100);
					if (productCostPrice <= 0) // validation for blank entry and negative entries
					{
						productCostPrice = 0;
						productSalesTaxAmount = 0;
					}
					
						try {

							writer.print(productDetails[0] + "," + productDetails[1] + "," + productDetails[2] + ","
									+ productSalesTaxAmount + "," + (productCostPrice + productSalesTaxAmount) + ",");
							writer.print(productDetails[3]);
						} catch (Exception e) {
							writer.print("undefined");
						}
						writer.println();
					}
					oneEntryFromInput = reader.readLine();

					numberOfEntryInInputDataSet++;
				
			}
			reader.close();
			writer.flush();
			writer.close();
			System.out.println(numberOfEntryInInputDataSet - 1);
		} else {
			System.out.println("file not existed in machine");
		}
	}

}
