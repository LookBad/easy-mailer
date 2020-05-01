package com.easythings.easymailer

class ConsoleMailer : BaseMailer("console@development.com", "Console") {
    override fun send(emailAddress: String, emailContent: EmailContent) {
        println("********************************************************************************")
        println("From: $from | To: $emailAddress")
        println("Subject: ${emailContent.subject}")
        println("Content: \n ${emailContent.content}")
        println("\n********************************************************************************")
    }
}
