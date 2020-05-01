package com.easythings.easymailer

abstract class BaseMailer(protected val from: String, protected val name: String) {

    abstract fun send(emailAddress: String, emailContent: EmailContent)
}