package webdata;

import com.thoughtworks.xstream.XStream;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SerializeToXml {
    private final static String SERIALIZED_XML = "products.xml";

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

        Iterator<Offer> iterator = offers.iterator();
        while (iterator.hasNext()) {
            Offer offer = iterator.next();
            articleId = offer.getArticleId();
            productName = offer.getProductName();
            brand = offer.getBrand();
            color = offer.getColor();
            price = offer.getPrice();
            initialPrice = offer.getInitialPrice();
            description = offer.getDescription();

            stringBuilder.append("" +
                    "<offer>\n"
                    +"<articleId>" +articleId +"</articleId>\n"
                    +"<name>" +productName +"</name>\n"
                    +"<brand>" +brand +"</brand>\n"
                    +"<color>" +color +"</color>\n"
                    +"<price>" +price +"</price>\n"
                    +"<initial_price>" +initialPrice +"</initial_price\n>"
                    +"<description>" +description +"<description>\n"
                    +"</offer>\n");
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

    public static void encodeToXML(List<Offer> linkedList){
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_XML)));
        }catch (Exception e){
            System.out.println(e);
        }

        if (encoder != null) {
            encoder.writeObject(linkedList);
        }
        if (encoder != null) {
            encoder.close();
        }
    }

     public static void encodeToXmlWithXStream(ArrayList offerList){
         XStream xStream = new XStream();
         xStream.processAnnotations(Offer.class);

         try {
             xStream.toXML(offerList
                , new ObjectOutputStream(
                        new FileOutputStream(SERIALIZED_XML)
                     ));
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
}
