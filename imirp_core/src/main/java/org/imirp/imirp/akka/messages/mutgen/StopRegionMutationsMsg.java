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

import java.io.Serializable;

/**
 * Message that is sent to request early cancellation of a particular region.
 * 
 * @author twerner
 *
 */
public class StopRegionMutationsMsg implements Serializable {
	private static final long serialVersionUID = -9186645321509410100L;
	public final String regionId;

    public StopRegionMutationsMsg() {
        super();
        regionId = null;
    }

    public StopRegionMutationsMsg(String regionId) {
        super();
        this.regionId = regionId;
    }
    
    public static final class RegionMutationsTimeoutMsg extends StopRegionMutationsMsg {
		private static final long serialVersionUID = -8459513079719865672L;
		public RegionMutationsTimeoutMsg() {
			super();
		}
		public RegionMutationsTimeoutMsg(String regionId) {
			super(regionId);
		}    	
    }
    
}