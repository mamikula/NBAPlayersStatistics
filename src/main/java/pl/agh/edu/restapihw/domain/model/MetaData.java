package pl.agh.edu.restapihw.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetaData {
    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("next_page")
    private int nextPage;

    @JsonProperty("per_page")
    private int perPage;

    @JsonProperty("total_count")
    private int totalCount;

}
