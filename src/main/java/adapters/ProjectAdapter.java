package adapters;

import objects.Project;

public class ProjectAdapter extends BaseAdapter {
public static final String PROJECT_URI = "/project";

    public String create(Project project){
        return
        post(PROJECT_URI, converter.toJson(project)).body().path("result.code");
    }

}