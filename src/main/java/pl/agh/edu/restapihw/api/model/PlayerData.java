package pl.agh.edu.restapihw.api.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PlayerData {

    @NotEmpty(message = "FirsName can't be empty")
    private String firstName;

    @NotEmpty(message = "LastName can't be empty")
    private String lastName;

    @NotNull(message = "Season1 can't be empty")
    private int season1;

    @NotNull(message = "Season2 can't be empty")
    private int season2;

    private String result;
}