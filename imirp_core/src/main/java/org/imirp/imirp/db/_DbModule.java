/**
*   Copyright 2014 Torben Werner, Bridget Ryan
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/

package org.imirp.imirp.db;

import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

import org.apache.log4j.Logger;
import org.jongo.Jongo;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.typesafe.config.Config;

public class _DbModule extends AbstractModule {
	private static final Logger logger = Logger.getLogger(_DbModule.class);
	
	@Override
	protected void configure() {
		bind(ImirpDataStore.class).to(MongoDataStoreImpl.class);
	}

	@Provides @Singleton
	Mongo provideMongo(Config config) throws UnknownHostException{
		// Read the db connection properties
		String dbHost = config.getString("imirp.db.host");
		int dbPort = config.getInt("imirp.db.port");
		logger.info("Connecting to db at host[" + dbHost + "] and port[" + dbPort + "]");		
		
		// Setup connection options
		MongoClientOptions.Builder optionsBuilder = new MongoClientOptions.Builder();
		if(config.getBoolean("imirp.db.ssl_enabled")){
			logger.debug("Mongo SSL enabled.");
			optionsBuilder = optionsBuilder.socketFactory(SSLSocketFactory.getDefault());
		}
        MongoClientOptions o = optionsBuilder.build();
		MongoClient mongo = new MongoClient(new ServerAddress(dbHost, dbPort), o);
		
		return mongo;
	}
	
	@SuppressWarnings("deprecation")
	@Provides @Singleton
	Jongo provideJongo(Mongo mongo, Config config){
		String dbName = config.getString("imirp.db.name");
		logger.debug("Using database[" + dbName + "]");
		DB db = mongo.getDB(dbName);
		logger.debug("Authenticating...");
		if(config.hasPath("imirp.db.user")){
			if(!db.authenticate(config.getString("imirp.db.user"), config.getString("imirp.db.password").toCharArray())){
				logger.error("Unable to authenticate to mongo database.");
				return null;
			}
		}
		return new Jongo(db);
	}
}
