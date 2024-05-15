package mk.ukim.finki.emt.clubsmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.clubsmanagement.domain.valueobjects.Address;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClubForm {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String website;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Address address;

    @Valid
    @NotEmpty
    private List<SportForm> sports = new ArrayList<>();
}
