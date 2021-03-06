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
package org.apache.shindig.gadgets.oauth2;

import org.junit.Assert;
import org.junit.Test;

public class OAuth2ErrorTest {
  @Test
  public void testGetErrorCode_1() throws Exception {
    final OAuth2Error fixture = OAuth2Error.AUTHENTICATION_PROBLEM;

    final String result = fixture.getErrorCode();

    Assert.assertEquals("authentication_problem", result);
  }

  @Test
  public void testGetErrorDescription_1() throws Exception {
    final OAuth2Error fixture = OAuth2Error.AUTHENTICATION_PROBLEM;

    final String result = fixture.getErrorDescription();

    Assert
        .assertEquals(
            "org.apache.shindig.gadgets.oauth2.OAuth2Request encountered a problem :  adding client authentication : {0}",
            result);
  }

  @Test
  public void testGetErrorExplanation_1() throws Exception {
    final OAuth2Error fixture = OAuth2Error.AUTHENTICATION_PROBLEM;

    final String result = fixture.getErrorExplanation();

    Assert.assertEquals("Could not add authentication headers to the request.", result);
  }
}