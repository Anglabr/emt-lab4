package mk.ukim.finki.emt.clubsmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.clubsmanagement.domain.models.SportId;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class SportForm {
    private SportId id;

    @NotNull
    private String name;

    private String description;

    @Valid
    @NotEmpty
    private List<SportCategoryForm> categories = new ArrayList<>();
}
