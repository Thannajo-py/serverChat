package com.example.serverchat


import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse


@RestController
class myChat( private val chatDAO: chatDAO){

    @PostMapping("/newChat")
    fun newChat(
        @RequestBody pseudo: newUserChatBean?,
    ): String {
        if (pseudo != null && pseudo.password == CODE) {
            chatDAO.save(Chat(null,pseudo.pseudo?:"",pseudo.message?:""))
            return "message bien reçu"
        }
        return "error"
    }


    @PostMapping("/getNewChat")
    fun getNewChat(
        @RequestBody user: newUserChatBean?,
        @RequestParam(required=false) filter: String?,
        @RequestParam(required=false) pseudo: String?
    ): Message? = if(user?.password == CODE)Message(chatDAO.findAll().also{it.forEach{ i->i.id=null}}) else null

    @GetMapping("/hello")
    fun hello():String{
        return "hello"
    }

}




