package com.jiangcl.gmall.pms;

import com.jiangcl.gmall.pms.entity.es.EsUserAddress;
import com.jiangcl.gmall.pms.entity.es.EsUserClass;
import com.jiangcl.gmall.pms.entity.es.EsUserInfo;
import com.jiangcl.gmall.pms.entity.GoodsCategory;
import com.jiangcl.gmall.pms.service.UserInfoService;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GmallPmsApplicationTests {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JestClient jestClient;

    @Test
    void contextLoads() {

    }

    @Test
    public void test1(){
        //UserInfo userInfo = userInfoService.getUserInfo();
        //System.out.println(userInfo.toString());
        userInfoService.insertUserInfo();
        System.out.println("添加成功！！！");
    }

    @Test
    public void test2(){
        GoodsCategory category = new GoodsCategory();
        category.setCategoryId(1L);
        category.setCategoryName("redis 测试");
        category.setParentId(0L);
        category.setChildrens(null);

        redisTemplate.opsForValue().set("category",category);

        Object category1 = redisTemplate.opsForValue().get("category");
        System.out.println(category1.toString());
    }

    @Test
    public void test3() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("address","中国湖北"));
        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex("my_index").addType("gmall").build();
        SearchResult result = jestClient.execute(search);
        String jsonString = result.getJsonString();
        System.out.println(jsonString);
    }

    @Test
    public void indexData() throws IOException {
        EsUserAddress userAddress = new EsUserAddress();
        userAddress.setProvenceName("湖北省");
        userAddress.setCityName("武汉市");
        userAddress.setCountyName("洪山区");
        userAddress.setAddressDetail("中国湖北省武汉市洪山区");

        List<EsUserClass> userClasses = new ArrayList<>();
        userClasses.add(new EsUserClass("语文",23));
        userClasses.add(new EsUserClass("数学",22));
        userClasses.add(new EsUserClass("英语",21));

        EsUserInfo userInfo = new EsUserInfo();
        userInfo.setName("lisi");
        userInfo.setPasswd("123456");
        userInfo.setNickName("无所事事");
        userInfo.setAge(22);
        userInfo.setAddress(userAddress);
        userInfo.setUserClasses(userClasses);

        Index putInfo = new Index.Builder(userInfo).index("gmall_pms").type("user").id("2").build();
        DocumentResult result = jestClient.execute(putInfo);
        System.out.println(result.getJsonString());
    }
}
