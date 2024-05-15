package mk.ukim.finki.emt.clubsmanagement.services.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SportCategoryForm {
    @NotNull
    private String name;
}
