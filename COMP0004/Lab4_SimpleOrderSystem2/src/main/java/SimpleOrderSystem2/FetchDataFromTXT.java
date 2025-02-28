package SimpleOrderSystem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FetchDataFromTXT {

	private final String filePath;

	public FetchDataFromTXT(String filePath) {  this.filePath = filePath;   }

	public ArrayList<Product> ReadFromTXT()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			int code = 0;

			String line;
			while((line = br.readLine()) != null)
			{
				if(line.trim().isEmpty())
					continue;
				if((line = br.readLine().trim().toLowerCase()).contains("snack"))
				{
					while((line = br.readLine().toLowerCase().trim()).compareTo("end") != 0)
					{
						products.add(parseSnack(line, code));
						code++;
					}
				}

				if((line = br.readLine().trim().toLowerCase().replaceAll("\\s+", "")).contains("dailynecessity"))
				{
					while((line = br.readLine().toLowerCase().trim()).compareTo("end") != 0)
					{
						products.add(parseDailyNecessity(line, code));
						code++;
					}
				}

				if((line = br.readLine().trim().toLowerCase()).contains("beverage"))
				{
					while( (line = br.readLine().toLowerCase().trim()).compareTo("end") != 0)
					{
						products.add(parseBeverage(line, code));
						code++;
					}
				}
			}
		}catch (IOException e)
		{
			e.printStackTrace();
		}

		return products;
	}

	public Snack parseSnack(String line, int code)
	{
		String[] parts = line.split("/");
		return new Snack(code,
						Double.parseDouble(parts[3].trim()),
						parts[0],
						Integer.parseInt(parts[1].trim()),
						Double.parseDouble(parts[2].trim())
						);
	}

	public DailyNecessity parseDailyNecessity(String line, int code)
	{
		String[] parts = line.split("/");
		return new DailyNecessity(code,
								Double.parseDouble(parts[2].trim()),
								parts[0],
								parts[1]);
	}

	public Beverage parseBeverage(String line, int code)
	{
		String[] parts = line.split("/");
		return new Beverage(code,
							Double.parseDouble(parts[2].trim()),
							parts[0],
							Integer.parseInt(parts[1].trim())
							);
	}
}
