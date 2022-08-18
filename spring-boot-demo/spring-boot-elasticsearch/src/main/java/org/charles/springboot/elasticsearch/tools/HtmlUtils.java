package org.charles.springboot.elasticsearch.tools;

import org.charles.springboot.elasticsearch.entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class HtmlUtils {

    private final static String url = "https://www.qidian.com/rank/hotsales/page%d/";

    public static List<Book> getBookList() throws Exception {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            String pageUrl = String.format(url, i);
            Document document = Jsoup.parse(new URL(pageUrl), 5000);
            Objects.requireNonNull(document.getElementById("rank-view-list")).getElementsByTag("li").forEach(element -> {
                String imageUrl = "https:" + element.getElementsByClass("book-img-box").get(0).getElementsByTag("img").attr("src");
                Element bookElement = element.getElementsByClass("book-mid-info").get(0);
                String name = bookElement.getElementsByTag("a").get(0).text();
                String intro = bookElement.getElementsByClass("intro").get(0).text();
                String author = bookElement.getElementsByClass("author").get(0).getElementsByClass("name").get(0).text();
                String category = bookElement.getElementsByTag("a").get(2).text();
                String subCategory = bookElement.getElementsByClass("go-sub-type").get(0).text();
                String url = "https:" + bookElement.getElementsByTag("a").get(0).attr("href");
                String datetime = bookElement.getElementsByClass("update").get(0).getElementsByTag("span").text();
                if (datetime.length() == 11) {
                    datetime = "2022-" + datetime;
                }

                Date updateTime = null;
                try {
                    updateTime = DateUtils.parseDateTime(datetime);
                } catch (ParseException e) {
                    e.printStackTrace();
                    updateTime = new Date();
                }
                Book book = new Book(0, name, url, category, subCategory, author, intro, imageUrl, updateTime);
                bookList.add(book);
            });
        }
        return bookList;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i <= 5; i++) {
            String pageUrl = String.format(url, i);
            Document document = Jsoup.parse(new URL(pageUrl), 5000);
            Objects.requireNonNull(document.getElementById("rank-view-list")).getElementsByTag("li").forEach(element -> {
                String imageUrl = "https:" + element.getElementsByClass("book-img-box").get(0).getElementsByTag("img").attr("src");
                Element bookElement = element.getElementsByClass("book-mid-info").get(0);
                String name = bookElement.getElementsByTag("a").get(0).text();
                String intro = bookElement.getElementsByClass("intro").get(0).text();
                String author = bookElement.getElementsByClass("author").get(0).getElementsByClass("name").get(0).text();
                String category = bookElement.getElementsByTag("a").get(2).text();
                String subCategory = bookElement.getElementsByClass("go-sub-type").get(0).text();
                String url = "https:" + bookElement.getElementsByTag("a").get(0).attr("href");


                String datetime = bookElement.getElementsByClass("update").get(0).getElementsByTag("span").text();
                System.out.println("datetime : " + datetime);

                if (datetime.length() == 11) {
                    datetime = "2022-" + datetime;
                }

                Date updateTime = null;
                try {
                    updateTime = DateUtils.parseDateTime(datetime);
                } catch (ParseException e) {
                    e.printStackTrace();
                    updateTime = new Date();
                }
                System.out.println(name);
                System.out.println(updateTime);
                System.out.println(url);
                System.out.println(imageUrl);
                System.out.println(author);
                System.out.println(category);
                System.out.println(subCategory);
                System.out.println(intro);
                System.out.println("==============================================================================================================================");
            });
        }
    }
}
