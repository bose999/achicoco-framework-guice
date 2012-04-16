package jp.techie.achicoco.framework.guice.control;

import jp.techie.achicoco.framework.action.AchicocoAction;
import jp.techie.achicoco.framework.conf.FrameworkConfing;
import jp.techie.achicoco.framework.control.AchicocoActionControler;
import jp.techie.achicoco.framework.guice.conf.FrameworkConfingImpl;
import jp.techie.achicoco.framework.util.LogUtil;

import com.google.inject.Injector;

/**
 * サーブレットから非同期で処理を受け取りActionをKickする実装クラス
 * 
 * @author bose999
 *
 */
public class AchicocoActionGuiceControler extends AchicocoActionControler {

    /**
     * ログユーティリティ
     */
    public static LogUtil logUtil = new LogUtil(AchicocoActionGuiceControler.class);

    /* (non-Javadoc)
     * @see jp.techie.achicoco.framework.control.AchicocoActionControler#getFrameworkConfing()
     */
    @Override
    protected FrameworkConfing getFrameworkConfing() throws Exception {
        return FrameworkConfingImpl.getInstance();
    }

    /* (non-Javadoc)
     * @see jp.techie.achicoco.framework.control.AchicocoActionControler#getAchicocoAction(java.lang.String)
     */
    @Override
    protected AchicocoAction getAchicocoAction(String actionClassName) throws Exception {
     // URLからActionクラスを特定してGuiceでインスタンス化
        AchicocoAction achicocoAction = null;
    try {
        Class<?> clz = Class.forName(getFrameworkConfing().getActionPackageName() + "." + actionClassName + "Action");
        Injector injector = (Injector) application.getAttribute("injector");
         achicocoAction = (AchicocoAction) injector.getInstance(clz);
    } catch (ClassCastException ce) {
        logUtil.debug("Action Injection Error. Please, check pakagename setting. Or BadUrl.");
        throw ce;
    }catch (ClassNotFoundException classNotFoundException){
        logUtil.debug("Action Injection Error. Please, check pakagename setting. Or BadUrl.");
        throw classNotFoundException;
    }catch (Exception exception){
        logUtil.fatal("Action Injection Error.",exception);
        throw exception;
        
    }
        return achicocoAction;
    }
}
