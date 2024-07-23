package com.example.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }




}
