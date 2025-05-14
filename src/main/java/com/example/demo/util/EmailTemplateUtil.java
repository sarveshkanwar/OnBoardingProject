package com.example.demo.util;

public class EmailTemplateUtil {

    public static String buildJobOfferEmail(String name) {
        return "<html><body>"
             + "<h2>Congratulations, " + name + "!</h2>"
             + "<p>We are pleased to offer you a position at our company.</p>"
             + "<p>Please check your portal for more details.</p>"
             + "<p>Best Regards,<br>HR Team</p>"
             + "</body></html>";
    }
}