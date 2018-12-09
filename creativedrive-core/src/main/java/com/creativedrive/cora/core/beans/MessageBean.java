package com.creativedrive.cora.core.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "message")
public class MessageBean {

    @ApiModelProperty(notes = "Message ID")
    @Size(max = 60, message = "Max 60 characters")
    private String id;

    @ApiModelProperty(notes = "Message for user")
    @NotBlank(message = "Can not be empty")
    @Size(max = 300, message = "Max 300 characters")
    private String message;

    @NotNull(message = "User required")
    private UserBean user;

}
