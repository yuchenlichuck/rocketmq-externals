/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.connect.jdbc.connector;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.Task;
import io.openmessaging.connector.api.source.SourceConnector;

import org.apache.rocketmq.connect.jdbc.Config;
//import org.apache.rocketmq.connect.jdbc.connector.JdbcSourceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcSourceConnector extends SourceConnector {
    private static final Logger log = LoggerFactory.getLogger(JdbcSourceConnector.class);
    private KeyValue config;

    @Override
    public String verifyAndSetConfig(KeyValue config) {
        log.info("JdbcSourceConnector verifyAndSetConfig enter");
        for (String requestKey : Config.REQUEST_CONFIG) {
            if (!config.containsKey(requestKey)) {
                return "Request config key: " + requestKey;
            }
        }
        this.config = config;
        return "";
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override public void pause() {

    }

    @Override public void resume() {

    }

    @Override
    public Class<? extends Task> taskClass(){
	        return JdbcSourceTask.class;
	}

    @Override
    public List<KeyValue> taskConfigs() {
        List<KeyValue> config = new ArrayList<>();
        config.add(this.config);
        return config;
    }

}
