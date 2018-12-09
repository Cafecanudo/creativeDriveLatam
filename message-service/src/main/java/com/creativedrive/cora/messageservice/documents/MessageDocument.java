package com.creativedrive.cora.messageservice.documents;

import com.creativedrive.cora.core.beans.UserBean;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document("message")
public class MessageDocument {

    @Id
    private String id;

    @DBRef(lazy = true)
    private UserBean user;
}
