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
package jp.techie.achicoco.framework.guice.conf;

import jp.techie.achicoco.framework.conf.ApplicationConfing;

import com.google.inject.AbstractModule;

/**
 * AchicocoSettingのabstract class<br />
 * このクラスを継承して<br />
 * jp.techie.achicoco.AchicocoSetting<br />
 * クラスを作成して設定を記述する
 * 
 * @author bose999
 *
 */
public abstract class AbstractApplicationConfingImpl extends AbstractModule implements ApplicationConfing{
	
	abstract public String getActionPackageName();
	
	abstract public String getErrorUrl();
	
	abstract public void configure();
	
	abstract public String getMessageBadUrl();

}
