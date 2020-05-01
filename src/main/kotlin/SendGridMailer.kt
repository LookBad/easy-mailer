package com.easythings.easymailer

import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.SendGrid
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Content
import com.sendgrid.helpers.mail.objects.Email

class SendGridMailer(private val apiKey: String, from: String, name: String) : BaseMailer(from, name) {
    override fun send(emailAddress: String, emailContent: EmailContent) {
        SendGrid(apiKey).api(
            Request().apply {
                method = Method.POST
                endpoint = "mail/send"
                body = Mail(
                    Email(from, name),
                    emailContent.subject,
                    Email(emailAddress),
                    Content("text/html", emailContent.content)
                ).buildPretty()
            }
        )
    }
}
