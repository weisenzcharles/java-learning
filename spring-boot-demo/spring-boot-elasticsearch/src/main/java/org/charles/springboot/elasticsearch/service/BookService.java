package org.charles.springboot.elasticsearch.service;

import com.alibaba.fastjson.JSON;
import org.charles.springboot.elasticsearch.entity.Book;
import org.charles.springboot.elasticsearch.tools.HtmlUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public boolean createIndex() throws Exception {
        Settings.Builder builder = Settings.builder().put("number_of_shards", 3).put("number_of_replicas", 2);
        XContentBuilder xContentBuilder = JsonXContent.contentBuilder().startObject().startObject("properties").startObject("name").field("type", "text").field("analyzer", "ik_max_word").endObject().startObject("url").field("type", "text").endObject().startObject("category").field("type", "keyword").endObject().startObject("subCategory").field("type", "keyword").endObject().startObject("author").field("type", "keyword").endObject().startObject("updateTime").field("type", "date").field("format", "yyyy-MM-dd HH:mm:ss").endObject().startObject("intro").field("type", "text").field("analyzer", "ik_max_word").endObject().startObject("imageUrl").field("type", "text").endObject().endObject().endObject();
        CreateIndexRequest indexRequest = new CreateIndexRequest("book").settings(builder).mapping(xContentBuilder);

        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(indexRequest, RequestOptions.DEFAULT);

        return createIndexResponse.isAcknowledged();
//        List<Book> books = HtmlUtils.getBookList();
//        BulkRequest bulkRequest = new BulkRequest();
//        for (Book book : books) {
//            bulkRequest.add(new IndexRequest("book").source(XContentType.JSON, JSON.toJSONString(book)));
//        }
//        return true;
    }


    public boolean updateBook() throws Exception {

        List<Book> books = HtmlUtils.getBookList();
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("3m");
        int i = 0;
        for (Book book : books) {
            i++;
            book.setId(i);
            bulkRequest.add(new IndexRequest("book").id(String.valueOf(i)).source(JSON.toJSONString(book), XContentType.JSON));
            System.out.println("添加索引：" + book.getName());
            restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        }
//        IndexRequest indexRequest = new IndexRequest("book").source(XContentType.JSON, JSON.toJSONString(book));
        return true;
    }


}
