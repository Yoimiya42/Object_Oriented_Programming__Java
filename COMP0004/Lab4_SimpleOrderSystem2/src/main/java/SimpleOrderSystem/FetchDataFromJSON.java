package SimpleOrderSystem;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class FetchDataFromJSON {

	private final String filePath;

	public FetchDataFromJSON(String filePath) {
		this.filePath = filePath;
	}

	public ArrayList<Product> readFromJSON()
	{
		ArrayList<Product> products = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();

		try {
			JsonNode rootNode = mapper.readTree(filePath);

			JsonNode snacks = rootNode.get("snacks");
			for (JsonNode node : snacks)
			{
				int code = node.get("code").asInt();
				String name = node.get("name").asText();
				int shelfLife = node.get("shelfLife").asInt();
				double calories = node.get("calories").asDouble();
				double price = node.get("price").asDouble();

				products.add(new Snack(code, price, name, shelfLife, calories));
			}

			JsonNode dailyNecessities = rootNode.get("dailyNecessities");
			for (JsonNode node : dailyNecessities)
			{
				int code = node.get("code").asInt();
				String name = node.get("name").asText();
				String brand = node.get("brand").asText();
				double price = node.get("price").asDouble();

				products.add(new DailyNecessity(code, price, name, brand));
			}

			JsonNode beverages = rootNode.get("beverages");
			for (JsonNode node : beverages)
			{
				int code = node.get("code").asInt();
				String name = node.get("name").asText();
				int volume_weight = node.get("volume_weight").asInt();
				double price = node.get("price").asDouble();

				products.add(new Beverage(code, price, name, volume_weight));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return products;
	}
}

