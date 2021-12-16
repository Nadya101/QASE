package objects;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestSuit {
    int id;
    String title;
    String description;
    String precondition;
    @SerializedName("parent_id")
    int parentId;
}