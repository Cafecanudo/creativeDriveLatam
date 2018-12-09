package com.creativedrive.cora.user.documents;

import com.creativedrive.cora.user.documents.enums.TipoPerfil;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document("usuario")
public class UserDocument {

    @Id
    private String id;

    @NotBlank
    @Size(max = 100, message = "Max 100 characters")
    private String nome;

    @Email
    @NotBlank
    @Indexed(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6, max = 15)
    private String senha;

    @Max(120)
    private String endereco;

    @Max(20)
    private String telefone;

    @NotNull
    private TipoPerfil perfil;

}
