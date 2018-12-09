package com.creativedrive.cora.messageservice.repositories;

import com.creativedrive.cora.messageservice.documents.MessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<MessageDocument, String> {

    List<MessageDocument> findByUser_Id(String id);

}
