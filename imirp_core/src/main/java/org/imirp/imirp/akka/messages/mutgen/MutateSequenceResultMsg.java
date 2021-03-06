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

import org.imirp.imirp.mutation.MutationContext;

/**
 * A mutant sequence that resulted from a generator mutating the wild sequence at a specified region
 * 
 * @author torben
 * 
 */
public class MutateSequenceResultMsg {

    public final MutationContext context;

    public MutateSequenceResultMsg(MutationContext context) {
        super();
        this.context = context;
    }

    public MutationContext getContext() {
        return context;
    }

}
