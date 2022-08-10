/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.17
 * Generated at: 2022-07-15 15:36:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.resources.view;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class register_002dconfirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/index.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <link href=\"../css/head.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Macondo\">\n");
      out.write("  <title>InTaberna - Music Store</title>\n");
      out.write("  <link rel=\"icon\" href=\"../icons/icon.png\" type=\"image/icon type\">\n");
      out.write("\n");
      out.write("  <div class=\"navbar\">\n");
      out.write("    <div class=\"logo\">\n");
      out.write("      <h3 class=\"logo\"><a class=\"logo\" href=\"index.jsp\">In Taberna</a></h3>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"search\">\n");
      out.write("      <form action=\"\" method=\"get\" id=\"searchAlbum\" class=\"search\">\n");
      out.write("        <input type=\"search\" name=\"search\" id=\"searchBar\" onkeyup=\"showResult(this.value)\" autocomplete=\"off\" size=\"20\">\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"buttons\">\n");
      out.write("      <ul class=\"buttons\">\n");
      out.write("        <li class=\"buttons\"><a class=\"buttons\" href=\"#HOME\">🛒</a></li>\n");
      out.write("        <li class=\"buttons\"><a class=\"buttons\" href=\"login.jsp\">Log-In</a></li>\n");
      out.write("        <li class=\"buttons\"><a class=\"buttons\" href=\"help.jsp\">Help</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Metodo per eseguire la ricerca live -->\n");
      out.write("  <script>\n");
      out.write("    function showResult(str) {\n");
      out.write("      if (str.length==0) {\n");
      out.write("        $(\".result\").hide();\n");
      out.write("        $(\".main\").fadeIn();\n");
      out.write("        return;\n");
      out.write("      }\n");
      out.write("      var xmlhttp=new XMLHttpRequest();\n");
      out.write("      xmlhttp.onreadystatechange=function() {\n");
      out.write("        if (this.readyState==4 && this.status==200) {\n");
      out.write("          var obj = JSON.parse(this.responseText);\n");
      out.write("          $(\".main\").fadeOut();\n");
      out.write("          $(\".result\").show();\n");
      out.write("          var str = \"<img style=\\\"width:400px; height: 400px\\\" src=\\\"../../getPicture?id=\"+ obj[0].name+ \"\\\">\" + \"<h3>\" + obj[0].name +\"</h3> <p>\" +obj[0].prezzo +\"$</p>\" + \"<form action='../../addSession' style='display: inline'><input style='background-color: limegreen; border-radius: 10px' type='submit' value='Aggiungi al carrello'><input type='hidden' name='albumName' value='\"+obj[0].name+\"\\'></form>\";\n");
      out.write("          $(\".result .content\").html(str);\n");
      out.write("          $(\"#songList\").text(\"\");\n");
      out.write("          for(let i = 0; i<obj.length; i++){\n");
      out.write("            for(let j = 0; j < obj[i].songs.length; j++){\n");
      out.write("              $(\"#songList\").append(\"<li style='float: left;'>\"+obj[i].songs[j]+\"</li><br>\");\n");
      out.write("            }\n");
      out.write("          }\n");
      out.write("\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("      xmlhttp.open(\"GET\",\"../../livesearch?str=\"+str,true);\n");
      out.write("      xmlhttp.send();\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("  <style>\n");
      out.write("    .result{\n");
      out.write("      display: grid;\n");
      out.write("      width: 100%;\n");
      out.write("      grid-template-columns: 1fr 1fr;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    #songList{\n");
      out.write("      background-color: whitesmoke;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    @media screen and (max-width: 900px) {\n");
      out.write("      .result {\n");
      out.write("        display: block;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      #songList{\n");
      out.write("        padding: 0%;\n");
      out.write("      }\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div class=\"result\">\n");
      out.write("  <div class=\"content\">\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <div id=\"songList\">\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"main\">\n");
      out.write("  <h1>Registrazione avvenuta con successo.</h1>\n");
      out.write("\n");
      out.write("  <script>\n");
      out.write("    function redirect(){\n");
      out.write("      location.href = \"../../index.jsp\";\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    setTimeout(redirect,3000);\n");
      out.write("\n");
      out.write("  </script>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}