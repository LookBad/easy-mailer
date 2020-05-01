package com.easythings.easymailer

abstract class EmailContent {
    abstract val subject: String
    abstract val content: String
}