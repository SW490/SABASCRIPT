/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.69
 * Generated at: 2025-02-19 00:58:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin.goods;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class modify_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/dev/workspace/port/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/shop/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1735616831101L));
    _jspx_dependants.put("jar:file:/C:/dev/workspace/port/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/shop/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid bg-gradient-primary\">\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("<div class=\"col-md-12\">\r\n");
      out.write("<div class=\"d-flex\">\r\n");
      out.write("	<div class=\"w-25\">\r\n");
      out.write("		<div class=\"mt-1\"></div>\r\n");
      out.write("		");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../include/lnb.jsp", out, false);
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	<div class=\"w-75\">\r\n");
      out.write("		<form role=\"form\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("			<input type=\"hidden\" name=\"gdsNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("			\r\n");
      out.write("			<!-- category -->\r\n");
      out.write("			<div class=\"d-flex\">\r\n");
      out.write("				<label class=\"form-label fw-bold text-white\">1st categorization\r\n");
      out.write("					<select name=\"\" id=\"\" class=\"form-select category1\">\r\n");
      out.write("						<option value=\"\">전체</option>\r\n");
      out.write("					</select>\r\n");
      out.write("				</label>\r\n");
      out.write("			</div>\r\n");
      out.write("				<label class=\"form-label fw-bold mx-3 text-white\">2nd categorization\r\n");
      out.write("					<select name=\"cateCode\" id=\"\" class=\"form-select category2\">\r\n");
      out.write("						<option value=\"\">전체</option>\r\n");
      out.write("					</select>\r\n");
      out.write("				</label>\r\n");
      out.write("			<!-- 수정과 쓰기의 다른 점 \r\n");
      out.write("			 	: 기존에 썼던 내용을 불러와야 함. 따라서 el로 밸류 지정.\r\n");
      out.write("			-->\r\n");
      out.write("			<div class=\"input-group my-3\">\r\n");
      out.write("				<label class=\"form-label fw-bold w-25 text-white\">상품명</label>\r\n");
      out.write("				<input type=\"text\" name=\"gdsName\" id=\"gdsName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"input-group mb-3\">\r\n");
      out.write("				<label class=\"form-label fw-bold w-25 text-white\">상품가격</label>\r\n");
      out.write("				<input type=\"text\" name=\"gdsPrice\" id=\"gdsPrice\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsPrice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"input-group my-3\">\r\n");
      out.write("				<label class=\"form-label fw-bold w-25 text-white\">상품수량</label>\r\n");
      out.write("				<input type=\"text\" name=\"gdsStock\" id=\"gdsStock\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsStock}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\">\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"input-group mb-3\">\r\n");
      out.write("				<label class=\"form-label fw-bold w-25 text-white\">상품소개</label>\r\n");
      out.write("				<textarea name=\"gdsDes\" id=\"gdsDes\" rows=\"5\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsDes}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("				<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/ckeditorConfig.js\">\r\n");
      out.write("				</script>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!--이미지 추가 업로드-->\r\n");
      out.write("			<div class=\"input-group mt-3\">\r\n");
      out.write("				<label class=\"form-label fw-bold w-25 text-white\">이미지</label>\r\n");
      out.write("				<input type=\"file\" name=\"file\" id=\"gdsImg\" class=\"form-control\">\r\n");
      out.write("				<div class=\"my-3\">\r\n");
      out.write("					<div class=\"select_img d-flex justify-content-end\">\r\n");
      out.write("						<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsImg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" alt=\"이미지를 불러올 수 없음.\" class=\"thumb img-thumbnail\">\r\n");
      out.write("						<input type=\"hidden\" name=\"gdsImg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsImg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("						<input type=\"hidden\" name=\"gdsThumbImg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${goods.gdsThumbImg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("					</div>\r\n");
      out.write("				<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/changeImgFunction.js\"></script>\r\n");
      out.write("				<div class=\"text-white\">");
      out.print(request.getRealPath("/"));
      out.write("</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<!--btn set-->\r\n");
      out.write("			<div class=\"d-flex justify-content-end my-5\">\r\n");
      out.write("				<div class=\"btn-group\">\r\n");
      out.write("					<button type=\"submit\" id=\"update_Btn\" class=\"btn btn-primary\">완료</button>\r\n");
      out.write("					<button type=\"button\" id=\"back_Btn\" class=\"btn btn-secondary\">취소</button>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/backBtn.js\"></script>\r\n");
      out.write("			<script>\r\n");
      out.write("				let jsonData = JSON.parse('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${category}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("');\r\n");
      out.write("			</script>\r\n");
      out.write("			<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/jsonDrop2.js\"></script>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../../include/footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
