package systango.SalesTaxCalculationProblemStatement;
import java.io.*;
public class salesReport 
{
	public static void main(String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new FileReader("/home/ubox83/Desktop/java_programs/programs/src/systango/SalesTaxCalculationProblemStatement/data.csv"));
	 String line=br.readLine();
	
     FileWriter fw=new FileWriter("solution.csv");
	 PrintWriter out=new PrintWriter(fw);
	 final int sales_tax=5;
	 int count=0;
     line=br.readLine();
	 while(line!=null)
	 {
		if(count==0)
		{
			out.print("Product-Name"+","+"Product-CostPrice"+","+"Product-SalesTax"+","+"Product-SalesTaxAmount"+","+"Product-FinalPrice"+","+"Countries");
			out.println(); 	
		}
		else
		{
		String Product_details[]=line.split(","); 
		float ProductCostPrice=Integer.parseInt(Product_details[1].trim());	
		float ProductSalesTaxAmount=((ProductCostPrice*sales_tax)/100); 		
		out.print(Product_details[0]);
		out.print(",");
		out.print(Product_details[1]);
		out.print(",");
		out.print(sales_tax);
		out.print(",");
		out.print(ProductSalesTaxAmount);
		out.print(",");
		out.print(ProductSalesTaxAmount+ProductCostPrice);
		out.print(",");
		out.print(Product_details[2]);
		//out.print(",");
		out.println();	
     	line=br.readLine();
        
		}
		count++;
	}
	    out.flush();
     	out.close();
	    System.out.println(count);
	}
}