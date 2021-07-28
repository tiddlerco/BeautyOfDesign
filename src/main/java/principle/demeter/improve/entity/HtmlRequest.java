package principle.demeter.improve.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HtmlRequest {

    private String url;
    private String address;
    private String bytes;

    public HtmlRequest(String url) {
        this.url = url;
    }
}
