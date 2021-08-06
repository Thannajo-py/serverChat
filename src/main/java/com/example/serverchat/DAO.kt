package com.example.serverchat

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface chatDAO:JpaRepository<Chat,Long>
