package com.bankchallenge.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

public class MessageUtil {

    public static void addMessage(final FacesMessage.Severity severity,
                                  final String summary) {
        final FacesContext context = FacesContext.getCurrentInstance();
        final FacesMessage facesMsg
                = new FacesMessage(severity, summary, null);
        context.addMessage(null, facesMsg);
        context.getExternalContext().getFlash().setKeepMessages(true);
    }


    private static void addMessageWithSeverity(final String summary,
                                               final FacesMessage.Severity severity) {

        final FacesContext context = FacesContext.getCurrentInstance();
        final FacesMessage facesMsg
                = new FacesMessage(severity, summary, null);
        context.addMessage(null, facesMsg);
        context.getExternalContext().getFlash().setKeepMessages(true);
    }


    public static void addMessageWarning(final String summary) {
        addMessageWithSeverity(summary, FacesMessage.SEVERITY_WARN);
    }


    public static void addMessageInfo(final String summary) {
        addMessageWithSeverity(summary, FacesMessage.SEVERITY_INFO);
    }


    public static void addMessageError(final String summary) {
        addMessageWithSeverity(summary, FacesMessage.SEVERITY_ERROR);
    }


    public static void addMessageFatal(final String summary) {
        addMessageWithSeverity(summary, FacesMessage.SEVERITY_FATAL);
    }


}
