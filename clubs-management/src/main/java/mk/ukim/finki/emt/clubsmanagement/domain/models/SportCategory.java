package mk.ukim.finki.emt.clubsmanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "sport_category")
@Getter
public class SportCategory extends AbstractEntity<SportCategoryId> {
    private String name;

    protected SportCategory() {
        super(SportCategoryId.randomId(SportCategoryId.class));
    }

    public SportCategory(@NonNull String name) {
        super(SportCategoryId.randomId(SportCategoryId.class));
        this.name = name;
    }

    public static SportCategory build(String name) {
        SportCategory sportCategory = new SportCategory();
        sportCategory.name = name;
        return sportCategory;
    }
}
