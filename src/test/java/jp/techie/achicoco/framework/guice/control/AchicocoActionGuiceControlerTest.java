/*
 * Copyright 2012 bose999.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.techie.achicoco.framework.guice.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;

import jp.techie.achicoco.framework.conf.FrameworkConfing;
import jp.techie.achicoco.framework.guice.conf.FrameworkConfingImpl;
import jp.techie.achicoco.framework.util.LogUtil;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * AchicocoActionGuiceControlerテスト用クラス
 * 
 * @author bose999
 *
 */
public class AchicocoActionGuiceControlerTest {

    /**
     * ログユーティリティ
     */
    public static LogUtil logUtil = new LogUtil(AchicocoActionGuiceControlerTest.class);

    /**
     * FrameworkConfing取得メソッドで<br />
     * jp.techie.achicoco.framework.guice.conf.FrameworkConfingImpl<br />
     * が取得できるか？
     */
    @Test
    public void testGetFrameworkConfing() {
        AchicocoActionGuiceControler achicocoActionGuiceControler = new AchicocoActionGuiceControler();
        try {
            assertEquals("jp.techie.achicoco.framework.guice.conf.FrameworkConfingImpl",
                achicocoActionGuiceControler.getFrameworkConfing().getClass().getName());
        } catch (Exception e) {
            fail();
            logUtil.fatal("Exception", e);
        }
    }

    /**
     * AchicocoAction継承クラスがGuiceから<br />
     * 意図した文字列で取れるかをテストする
     */
    @Test
    public void testGetAchicocoAction() {

        try {
            // FrameworkではServletでやっている処理をMockで記述
            ServletContext application = new ServletContextMock();
            FrameworkConfing frameworkConfing = FrameworkConfingImpl.getInstance();
            Module module = (Module) frameworkConfing.getApplicationConfing();
            Injector injector = Guice.createInjector(module);
            application.setAttribute("injector", injector);

            AchicocoActionGuiceControler achicocoActionGuiceControler = new AchicocoActionGuiceControler();
            achicocoActionGuiceControler.application = application;

            //Testという文字列でjp.techie.achicoco.framework.guice.control.TestActionImplのインスタンスが返ってくるか？
            assertEquals("jp.techie.achicoco.framework.guice.control.TestActionImpl",
                achicocoActionGuiceControler.getAchicocoAction("Test").getClass().getName());

        } catch (Exception e) {
            logUtil.fatal("Exception", e);
            fail();
        }
    }

    /**
     * テスト前処理
     */
    protected void setUp() {
        logUtil.info("---------- start ----------");
    }

    /**
     * テスト後処理
     */
    protected void tearDown() {
        logUtil.info("---------- end ----------");
    }

    private static class ServletContextMock implements ServletContext {

        Map<String, Object> attribute = new HashMap<String, Object>();

        @Override
        public Dynamic addFilter(String arg0, String arg1) {
            return null;
        }

        @Override
        public Dynamic addFilter(String arg0, Filter arg1) {
            return null;
        }

        @Override
        public Dynamic addFilter(String arg0, Class<? extends Filter> arg1) {
            return null;
        }

        @Override
        public void addListener(String arg0) {
        }

        @Override
        public <T extends EventListener> void addListener(T arg0) {
        }

        @Override
        public void addListener(Class<? extends EventListener> arg0){
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addServlet(String arg0, String arg1) {
            return null;
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addServlet(String arg0, Servlet arg1) {
            return null;
        }

        @Override
        public javax.servlet.ServletRegistration.Dynamic addServlet(String arg0, Class<? extends Servlet> arg1) {
            return null;
        }

        @Override
        public <T extends Filter> T createFilter(Class<T> arg0) throws ServletException {
            return null;
        }

        @Override
        public <T extends EventListener> T createListener(Class<T> arg0) throws ServletException {
            return null;
        }

        @Override
        public <T extends Servlet> T createServlet(Class<T> arg0) throws ServletException {
            return null;
        }

        @Override
        public void declareRoles(String... arg0) {
        }

        @Override
        public Object getAttribute(String arg0) {
            return attribute.get(arg0);
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public ClassLoader getClassLoader() {
            return null;
        }

        @Override
        public ServletContext getContext(String arg0) {
            return null;
        }

        @Override
        public String getContextPath() {
            return null;
        }

        @Override
        public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
            return null;
        }

        @Override
        public int getEffectiveMajorVersion() {
            return 0;
        }

        @Override
        public int getEffectiveMinorVersion() {
            return 0;
        }

        @Override
        public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
            return null;
        }

        @Override
        public FilterRegistration getFilterRegistration(String arg0) {
            return null;
        }

        @Override
        public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
            return null;
        }

        @Override
        public String getInitParameter(String arg0) {
            return null;
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return null;
        }

        @Override
        public JspConfigDescriptor getJspConfigDescriptor() {
            return null;
        }

        @Override
        public int getMajorVersion() {
            return 0;
        }

        @Override
        public String getMimeType(String arg0) {
            return null;
        }

        @Override
        public int getMinorVersion() {
            return 0;
        }

        @Override
        public RequestDispatcher getNamedDispatcher(String arg0) {
            return null;
        }

        @Override
        public String getRealPath(String arg0) {
            return null;
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String arg0) {
            return null;
        }

        @Override
        public URL getResource(String arg0) throws MalformedURLException {
            return null;
        }

        @Override
        public InputStream getResourceAsStream(String arg0) {
            return null;
        }

        @Override
        public Set<String> getResourcePaths(String arg0) {
            return null;
        }

        @Override
        public String getServerInfo() {
            return null;
        }

        @Override
        public Servlet getServlet(String arg0) throws ServletException {
            return null;
        }

        @Override
        public String getServletContextName() {
            return null;
        }

        @Override
        public Enumeration<String> getServletNames() {
            return null;
        }

        @Override
        public ServletRegistration getServletRegistration(String arg0) {
            return null;
        }

        @Override
        public Map<String, ? extends ServletRegistration> getServletRegistrations() {
            return null;
        }

        @Override
        public Enumeration<Servlet> getServlets() {
            return null;
        }

        @Override
        public SessionCookieConfig getSessionCookieConfig() {
            return null;
        }

        @Override
        public void log(String arg0) {
        }

        @Override
        public void log(Exception arg0, String arg1) {
        }

        @Override
        public void log(String arg0, Throwable arg1) {
        }

        @Override
        public void removeAttribute(String arg0) {
        }

        @Override
        public void setAttribute(String arg0, Object arg1) {
            attribute.put(arg0, arg1);
        }

        @Override
        public boolean setInitParameter(String arg0, String arg1) {
            return false;
        }

        @Override
        public void setSessionTrackingModes(Set<SessionTrackingMode> arg0) {
        }
    }
}
