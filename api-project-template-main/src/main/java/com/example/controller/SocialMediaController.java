package com.example.controller;

import org.springframework.beans.factory.annotation.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;
import java.util.List;



@RestController
public class SocialMediaController {

    AccountService accountService;
    MessageService messageService;

    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

//    endpoints here

    @GetMapping("/accounts")
    //displays all accounts if connected to data base
    public List<Account> testAccounts(){ return accountService.getAllAccounts()}

    @GetMapping("/messages")
    //displays all messages if connected to data base
    public List<Message> testMessagess(){ return accountService.getAllMessages()}


    @PostMapping("/register")
    //create an account in database
    public ResponseEntity<Account> register(@RequestBody Account account){
        Account registerAccount = accountService.registerAccount(account);
        return ResponseEntity.ok(registerAccount);
    }

    @PostMapping("/login")
    //login to verify if account is in database
    public ResponseEntity<?> login(@RequestBody Account account){
        Acciunt verifiedAccount = accountService.verifyLogin(account)
                if (verifiedAccount != null) {
                    return ResponseEntity.ok(verifiedAccount);
                }
                else{
                    return ResponseEntity.status(401).body("Login not successful")
                }
    }

    @PostMapping("/messages")
    //post endpoint to create a new messages
    public ResponseEntity<?> createMessage(@RequestBody Message message){
        Message createdMessage = messageService.createMessage(message);
        if (createdMessage != null) {
            return ResponseEntity.ok(createdMessage);
        } else{
            return ResponseEntity.status(400).body("Message creation not successful");
        }
    }

    @GetMapping("/messages/{message_id}")
    //get endpoint to return a specific message by its id
    public ResponseEntity<Message> getMessageById(@PathVariable Integer message_id){
        Message message = messageService.getMessageById(message_id);
        if (message != null) {
            return ResponseEntity.ok(message);
        }
        else{
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/messages/{message_id}")
    //delete a message by its id
    public ResponseEntity<Integer> deleteMessageById(@PathVariable Integer message_id){
        messageService.deleteMessageById(message_id);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/messages/{message_id}")
    //patch endpoint to update a messages text by its id
    public ResponseEntity<Message> updateMessage(@PathVariable Integer message_id, @RequestBody Message message){
        Message updatedMessage = messageService.updateMessageTextById(message_id, message);
        if (updatedMessage != null) {
            return ResponseEntity.ok(updatedMessage);
        }
        else{
            return ResponseEntity.status(400).build();
        }
    }
}

