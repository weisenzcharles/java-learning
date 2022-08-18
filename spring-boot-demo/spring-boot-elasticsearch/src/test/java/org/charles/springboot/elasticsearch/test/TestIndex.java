package org.charles.springboot.elasticsearch.test;

import com.alibaba.fastjson.JSON;
import org.charles.springboot.elasticsearch.entity.Book;
import org.charles.springboot.elasticsearch.tools.HtmlUtils;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestIndex {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    private static String INDEX = "order";

    @Test
    public void saveDataBMap() throws Exception {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("orderId", 11111);
        jsonMap.put("orderName", "1111的订单");
        jsonMap.put("content", "破欸俗人伟大撒打发的");
        IndexRequest request = new IndexRequest(INDEX).id(jsonMap.get("orderId").toString()).source(jsonMap);
        this.save(request);
    }

    @Test
    public void saveDataByContentBuild() throws Exception {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.field("orderId", 2222);
        builder.field("orderName", "2222的订单");
        builder.field("content", "送iu恶意然后我i和拉票；萨拉宽度");
        builder.endObject();
        IndexRequest request = new IndexRequest(INDEX).id("222").source(builder);
        this.save(request);
    }

    @Test
    public void saveDataByObject() throws Exception {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.field("orderId", 2222);
        builder.field("orderName", "测试订单");
        builder.field("content", "测试订单 222");
        builder.endObject();
        IndexRequest request = new IndexRequest(INDEX).id("3333").source("orderId", 3333, "orderName", "3333的订单", "content", "laisuyeiluqwgkjhgkjsgd");
        this.save(request);
    }

    private boolean save(IndexRequest request) throws Exception {
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        if (response.status().getStatus() == 200) {
            return true;
        }
        return false;
    }

    @Test
    public void saveDataByJson() throws Exception {
        List<Book> books = HtmlUtils.getBookList();
        int i = 0;
        for (Book book : books) {
            i++;
            book.setId(i);
            IndexRequest request = new IndexRequest("book").id(String.valueOf(book.getId()));
            request.source(JSON.toJSONString(book), XContentType.JSON);
            this.save(request);
            System.out.println("添加索引：" + book.getName());
//            restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        }

//        Book book = Book.builder().build().setId(12345).setAuthor("测试12345的订单").setIntro("的撒出手大方【平时都i法第四u发");
//        IndexRequest request = new IndexRequest("book").id(String.valueOf(book.getId()));
//        request.source(JSON.toJSONString(book), XContentType.JSON);
//        this.save(request);
    }

    @Test
    public void insertIndex() {


    }
}
