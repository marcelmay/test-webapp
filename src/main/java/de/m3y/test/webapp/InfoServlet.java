package de.m3y.test.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Collections;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (final PrintWriter writer = resp.getWriter()) {
            writer.append("<!doctype html>\n" +
                    "<html lang=\"en\">\n" +
                    "  <head>\n" +
                    "    <!-- Required meta tags -->\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                    "\n" +
                    "    <!-- Bootstrap CSS -->\n" +
                    "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css\" integrity=\"sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4\" crossorigin=\"anonymous\">\n" +
                    "\n" +
                    "    <title>test-webapp" + getAppVersion() + "</title>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "<nav class='navbar navbar-expand-lg navbar-dark bg-dark'>" +
                    "<a class='navbar-brand' href='#'>test-webapp " + getAppVersion() + "</a>" +
                    "</nav>" +
                    "<div class='container'>");

            writer.append("<h2>HttpServletRequest</h2>");
            writer.append("<ul'>");
            appendItem(writer, "AuthType", req.getAuthType());
            writer.append("<li>Attributes<ul>");
            for (String name : Collections.list(req.getAttributeNames())) {
                appendItem(writer, name, req.getAttribute(name).toString());
            }
            writer.append("</ul></li>");
            appendItem(writer, "ContextPath", req.getContextPath());
            appendItem(writer, "CharacterEncoding", req.getCharacterEncoding());
            appendItem(writer, "ContentLength", Integer.toString(req.getContentLength()));
            appendItem(writer, "ContentType", req.getContentType());
            writer.append("<li>Cookies<ul>");
            final Cookie[] cookies = req.getCookies();
            if (null != cookies) {
                for (Cookie cookie : cookies) {
                    appendItem(writer, "Comment", cookie.getComment());
                    appendItem(writer, "Domain", cookie.getDomain());
                    appendItem(writer, "Name", cookie.getName());
                    appendItem(writer, "Value", cookie.getValue());
                    appendItem(writer, "Path", cookie.getPath());
                    appendItem(writer, "MaxAge", Integer.toString(cookie.getMaxAge()));
                    appendItem(writer, "Secure", Boolean.toString(cookie.getSecure()));
                    appendItem(writer, "Version", Integer.toString(cookie.getVersion()));
                }
            }
            writer.append("</ul></li>");
            appendItem(writer, "DispatcherType", req.getDispatcherType().name());
            writer.append("<li>Header<ul>");
            for (String headerName : Collections.list(req.getHeaderNames())) {
                appendItem(writer, headerName, req.getHeader(headerName));
            }
            writer.append("</ul></li>");
            appendItem(writer, "LocalAddr", req.getLocalAddr());
            appendItem(writer, "LocalName", req.getLocalName());
            appendItem(writer, "Locale", req.getLocale().toString());
            appendItem(writer, "Locale", Integer.toString(req.getLocalPort()));
            appendItem(writer, "Method", req.getMethod());
            appendItem(writer, "PathInfo", req.getPathInfo());
            appendItem(writer, "PathTranslated", req.getPathTranslated());
            appendItem(writer, "Protocol", req.getProtocol());
            appendItem(writer, "QueryString", req.getQueryString());
            appendItem(writer, "RemoteUser", req.getRemoteUser());
            appendItem(writer, "RemoteAddr", req.getRemoteAddr());
            appendItem(writer, "RemoteHost", req.getRemoteHost());
            appendItem(writer, "RemotePort", Integer.toString(req.getRemotePort()));
            appendItem(writer, "RequestedSessionId", req.getRequestedSessionId());
            appendItem(writer, "RequestURI", req.getRequestURI());
            appendItem(writer, "RequestURL", req.getRequestURL().toString());
            appendItem(writer, "ServletPath", req.getServletPath());
            writer.append("<li>Parameters<ul>");
            for (String parameterName : Collections.list(req.getParameterNames())) {
                appendItem(writer, parameterName, req.getParameter(parameterName));
            }
            writer.append("</ul></li>");

            appendItem(writer, "Scheme", req.getScheme());
            appendItem(writer, "ServerName", req.getServerName());
            appendItem(writer, "ServerPort", Integer.toString(req.getServerPort()));
            final Principal userPrincipal = req.getUserPrincipal();
            if(null!=userPrincipal) {
                appendItem(writer, "UserPrincipal", userPrincipal.toString());
            } else {
                appendItem(writer, "UserPrincipal", null);
            }

            writer.append("</ul>");

            writer.append("</div>" +
                    "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js\" integrity=\"sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ\" crossorigin=\"anonymous\"></script>\n" +
                    "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js\" integrity=\"sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm\" crossorigin=\"anonymous\"></script>\n" +
                    "  </body>\n" +
                    "</html>");
            writer.flush();
        }
    }

    private void appendItem(PrintWriter writer, String label, String value) {
        appendListStart(writer);
        writer.append(label).append(" : ").append(value);
        appendListEnd(writer);
    }

    private void appendListStart(PrintWriter writer) {
        writer.append("<li>");
    }

    private void appendListEnd(PrintWriter writer) {
        writer.append("</li>");
    }

    private String getAppVersion() {
        return "- replaced -";
    }

    private String getBuildTimeStamp() {
        return "- replaced -";
    }

    private String getBuildScmVersion() {
        return "- replaced -";
    }

    private String getBuildScmBranch() {
        return "- replaced -";
    }
}
