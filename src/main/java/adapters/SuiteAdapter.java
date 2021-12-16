package adapters;

import io.restassured.response.ResponseBody;
import objects.TestSuit;

public class SuiteAdapter extends BaseAdapter{

    private static final String SUITE_URL = "/suite/%s";

    public int create(String projectCode, TestSuit testSuit){
        return
                post(String.format(SUITE_URL, projectCode), converter.toJson(testSuit))
                        .body().path("result.id");
    }

    public ResponseBody createDemo(String projectCode, TestSuit testSuite){
        return post(String.format(SUITE_URL, projectCode), converter.toJson(testSuite))
                .body();
    }

    public boolean delete(String projectCode, int id){
        String url = String.format(SUITE_URL, projectCode+"/"+ id);
        return delete(url).body().path("status");
    }
}