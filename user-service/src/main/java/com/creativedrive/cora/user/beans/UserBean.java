package com.creativedrive.cora.user.beans;

import com.creativedrive.cora.user.documents.enums.TipoPerfil;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "user")
public class UserBean {

    @ApiModelProperty(notes = "ID do usuario")
    @Size(max = 60, message = "Max 60 characters")
    private String id;

    @ApiModelProperty(notes = "Name of user", required = true)
    @NotBlank(message = "Can not be empty")
    @Size(max = 100, message = "Max 100 characters")
    private String nome;

    @ApiModelProperty(notes = "E-mail of user", required = true)
    @NotBlank(message = "Can not be empty")
    @Size(max = 120, message = "Max 120 characters")
    @Email(message = "Invalid e-mail.")
    private String email;

    @ApiModelProperty(notes = "Password of user", required = true)
    @NotBlank(message = "Can not be empty")
    @Size(min = 6, max = 15, message = "Min 6 and max 15 characters")
    private String senha;

    @ApiModelProperty(notes = "Address of user")
    @Max(value = 120, message = "Max 120 characters")
    private String endereco;

    @ApiModelProperty(notes = "Phone number of user", required = true)
    @Max(value = 20, message = "Max 20 characters")
    private String telefone;

    @ApiModelProperty(notes = "Profile of user", required = true)
    @NotBlank(message = "Can not be empty")
    private TipoPerfil perfil;
}
