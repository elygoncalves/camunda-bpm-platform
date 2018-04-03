/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthenticationException extends ProcessEngineException {

  private static final long serialVersionUID = 1L;

  private static final Format dateFormat = new SimpleDateFormat("HH:mm:ssZ");

  public AuthenticationException(String userId) {
    super("The user with id '" + userId + "' is permanently locked. Please contact your admin to unlock the account.");
  }

  public AuthenticationException(String userId, Date lockExpirationDate) {
    super("The user with id '" + userId + "' is locked. The lock will expire at " + dateFormat.format(lockExpirationDate));
  }

  public AuthenticationException(String userId, String message) {
    super("The user with id '" + userId + "' tries to login without success. " + message);
  }

}
