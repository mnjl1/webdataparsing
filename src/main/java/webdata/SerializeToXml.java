package webdata;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SerializeToXml {
    private static final String SERIALIZED_XML = "products.xml";

    public static void writeToXmlFile(ArrayList<Offer> offers) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String articleId;
        String productName;
        String brand;
        String color;
        String price;
        String initialPrice;
        String description;

        String startXmlString = "" +
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<offers>" +
                "";
        stringBuilder.append(startXmlString);

        for (Offer offer : offers) {
            articleId = offer.getArticleId();
            productName = offer.getProductName();
            brand = offer.getBrand();
            color = offer.getColor();
            price = offer.getPrice();
            initialPrice = offer.getInitialPrice();
            description = offer.getDescription();

            stringBuilder.append("" +
                    " <offer>\n"
                    + "  <articleId>" + articleId + "</articleId>\n"
                    + "  <name>" + productName + "</name>\n"
                    + "  <brand>" + brand + "</brand>\n"
                    + "  <color>" + color + "</color>\n"
                    + "  <price>" + price + "</price>\n"
                    + "  <initial_price>" + initialPrice + "</initial_price\n>"
                    + " <description>" + description + "<description>\n"
                    + " </offer>\n");
        }
        stringBuilder.append("</offers>");
        try(BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter(SERIALIZED_XML))) {
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.append(stringBuilder.toString());
            bufferedWriter.flush();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
