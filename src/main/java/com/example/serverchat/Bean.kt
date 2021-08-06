package com.example.serverchat


import javax.persistence.*



@Entity
@Table(name = "chat")
data class Chat(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id:Long?,
    var pseudo:String="",
    var message:String=""
){
    constructor():this(null,"")
}

data class Message(val message:List<Chat>)
class newUserChatBean(
var pseudo:String?, var message:String?, val password: String?)


