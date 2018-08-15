package webdata;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class WebDataExtracting {
    public static void main(String[] args) {
        final String ABOUT_YOU_URL = "http://www.aboutyou.de/suche?term=";
        Document searchByKeyWordResult;
        Offer offer;
        ArrayList<Offer> offerList = new ArrayList<>();
        try {
            String keyWord = "boots";
            searchByKeyWordResult = Jsoup.connect(ABOUT_YOU_URL +keyWord).get();

            org.jsoup.select.Elements searchResultPage = searchByKeyWordResult
                    .getElementsByClass("styles__tile--2s8XN col-sm-6 col-md-4 col-lg-4");
            for (Element p: searchResultPage
                 ) {
                Elements linkToProductPage = p.getElementsByTag("a");
                String absHref = linkToProductPage.attr("abs:href");

                Document productPage = Jsoup.connect(absHref).get();
                Elements articleId = productPage.getElementsByClass("styles__articleNumber--1UszN");
                Elements description = productPage.getElementsByClass("styles__textElement--3QlT_");
                Elements productName = p.getElementsByClass("styles__productName--2z0ZU");
                Elements brand = p.getElementsByClass("styles__brandName--2XS22");
                Elements color = productPage.getElementsByClass("styles__title--UFKYd styles" +
                        "__isHoveredState--2BBt9");
                Elements price = p.getElementsByClass("productPrices prices__normal--3SBAf");
                Elements initialPrice = p.getElementsByClass("prices__strike--Htmqx");

                offer = new Offer();
                offer.setArticleId(articleId.text());
                offer.setProductName(productName.text());
                offer.setBrand(brand.text());
                offer.setColor(color.text());
                offer.setPrice(price.text());
                offer.setInitialPrice(initialPrice.text());
                offer.setDescription(description.text());
                offerList.add(offer);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println(offerList.size());

        try {
            SerializeToXml.writeToXmlFile(offerList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
