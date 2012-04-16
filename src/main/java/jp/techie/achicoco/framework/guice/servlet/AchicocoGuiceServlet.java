package jp.techie.achicoco.framework.guice.servlet;

import javax.servlet.ServletContext;

import jp.techie.achicoco.framework.conf.FrameworkConfing;
import jp.techie.achicoco.framework.control.AchicocoActionControler;
import jp.techie.achicoco.framework.guice.conf.FrameworkConfingImpl;
import jp.techie.achicoco.framework.guice.control.AchicocoActionGuiceControler;
import jp.techie.achicoco.framework.servlet.AchicocoServlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * AchicocoGuice連携サーブレット
 * 非同期処理サーブレットなのでweb.xmlでの設定に注意
 * 
 * @author matakeda
 *
 */
@SuppressWarnings("serial")
public class AchicocoGuiceServlet extends AchicocoServlet {
	
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() {
        try {
         // ApplicationスコープにGuiceのコンテナを登録
            ServletContext application = getServletContext();
            FrameworkConfing frameworkConfing = FrameworkConfingImpl.getInstance();
            Module module = (Module) frameworkConfing.getApplicationConfing();
            Injector injector = Guice.createInjector(module);
            application.setAttribute("injector", injector);
        } catch (Exception e) {
            logUtil.fatal("AchicocoGuiceServlet init error. Can't use application",e);
            try {
                throw e;
            } catch (Exception e1) {
            }
        }
    }

    /* (non-Javadoc)
     * @see jp.techie.achicoco.framework.servlet.AchicocoServlet#getAchicocoActionControler()
     */
    @Override
    protected AchicocoActionControler getAchicocoActionControler() {
        return new AchicocoActionGuiceControler();
    }
}
