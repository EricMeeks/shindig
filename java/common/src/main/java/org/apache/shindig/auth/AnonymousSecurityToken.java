/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.shindig.auth;

import java.util.EnumSet;

import org.apache.shindig.common.Nullable;
import org.apache.shindig.config.ContainerConfig;

/**
 * A special class of Token representing the anonymous viewer/owner
 */
public class AnonymousSecurityToken extends AbstractSecurityToken implements SecurityToken {
  private static final EnumSet<Keys> MAP_KEYS = EnumSet.of(
    Keys.OWNER, Keys.VIEWER, Keys.APP_URL, Keys.MODULE_ID, Keys.EXPIRES, Keys.TRUSTED_JSON
  );

  public AnonymousSecurityToken() {
    this(ContainerConfig.DEFAULT_CONTAINER);
  }

  public AnonymousSecurityToken(String container) {
    this(container, 0L, "", null);
  }

  public AnonymousSecurityToken(String container, Long moduleId, String appUrl, Long expiresAt) {
    setContainer(container).setModuleId(moduleId).setAppUrl(appUrl).setExpiresAt(expiresAt)
      .setOwnerId("-1")
      .setViewerId("-1")
      .setDomain("*")
      .setTrustedJson("");
  }

  @Override
  public String getAppId() {
    return getAppUrl();
  }

  public boolean isAnonymous() {
    return true;
  }

  public String getUpdatedToken() {
    return "";
  }

  public String getAuthenticationMode() {
    return AuthenticationMode.UNAUTHENTICATED.name();
  }

  public String getActiveUrl() {
    throw new UnsupportedOperationException("No active URL available");
  }

  protected EnumSet<Keys> getMapKeys() {
    return MAP_KEYS;
  }
}
