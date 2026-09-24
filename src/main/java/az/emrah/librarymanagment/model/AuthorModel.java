package az.emrah.librarymanagment.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorModel {

    private Long id;

    private String name;

    private String email;

}
