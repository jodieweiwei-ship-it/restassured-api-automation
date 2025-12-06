package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * User Response POJO
 * Wraps the paginated API response structure for user lists
 *{
    "page": 2,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
        {
            "id": 7,
            "email": "michael.lawson@reqres.in",
            "first_name": "Michael",
            "last_name": "Lawson",
            "avatar": "https://reqres.in/img/faces/7-image.jpg"
        }
        // ... more users ...
    ],
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
 */
public class UserResponse {

    private Integer page;//The current page number the user is viewing.

    @JsonProperty("per_page")//Jackson library annotation @JsonProperty to map JSON field names (which typically use snake_case) to Java field names (which use camelCase).
    private Integer perPage;//How many items are shown on one page.

    private Integer total;//The total number of records available in the database.

    @JsonProperty("total_pages")
    private Integer totalPages;//The total number of pages available.

    private List<User> data;

    private Support support;

    // Default constructor
    public UserResponse() {
    }

    // Getters and Setters
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    // Inner class for Support object
    public static class Support {
        private String url;
        private String text;

        public Support() {
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
