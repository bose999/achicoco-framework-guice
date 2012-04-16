package jp.techie.achicoco;

import com.google.inject.Scopes;

import jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfingImpl;
import jp.techie.achicoco.framework.guice.control.TestAction;
import jp.techie.achicoco.framework.guice.control.TestActionImpl;

/**
 * テスト用のApplicationConfing
 * 
 * @author bose999
 *
 */
public class ApplicationConfingImpl extends AbstractApplicationConfingImpl {
    
    /**
     * DIするActionクラスのパッケージ名
     */
    public final static String PAKAGE_NAME = "jp.techie.achicoco.framework.guice.control";
    
    /* (non-Javadoc)
     * @see jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfingImpl#getActionPackageName()
     */
    @Override
    public String getActionPackageName() {
        return PAKAGE_NAME;
    }
    
    /* (non-Javadoc)
     * @see jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfingImpl#getErrorUrl()
     */
    @Override
    public String getErrorUrl() {
        return "";
    }
    
    /**
     * Guiceの設定
     */
    @Override
    public void configure() {
        bind(TestAction.class).to(TestActionImpl.class).in(Scopes.NO_SCOPE);
    }
    
    /* (non-Javadoc)
     * @see jp.techie.achicoco.framework.guice.conf.AbstractApplicationConfingImpl#getMessageBadUrl()
     */
    @Override
    public String getMessageBadUrl() {
        return "";
    }
}
