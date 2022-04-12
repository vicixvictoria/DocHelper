package at.ac.tuwien.dochelper.backend.endpoint.dto;

import com.sun.istack.NotNull;
import org.springframework.lang.Nullable;
import javax.validation.constraints.Size;

public class PatientDto {

    @Nullable
    private Long id;

    @NotNull
    @Size(max = 64)
    private String name;

    @Nullable
    public Long getId() {
        return id;
    }

    public void setId(@Nullable Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
