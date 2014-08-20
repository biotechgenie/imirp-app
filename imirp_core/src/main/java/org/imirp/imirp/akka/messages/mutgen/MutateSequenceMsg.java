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

package org.imirp.imirp.akka.messages.mutgen;

import org.imirp.imirp.ImirpContext;

public class MutateSequenceMsg {
	private final ImirpContext context;

	public MutateSequenceMsg(ImirpContext context) {
		super();
		this.context = context;
	}

	public ImirpContext getContext() {
		return context;
	}

	@Override
	public String toString() {
		return new StringBuilder("MSM{").append(context).append("}").toString();
	}

}
