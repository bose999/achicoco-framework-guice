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
