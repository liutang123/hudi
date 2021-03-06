/*
 *  Copyright (c) 2017 Uber Technologies, Inc. (hoodie-dev-group@uber.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package com.uber.hoodie.common.util;

import java.io.Serializable;
import java.util.Properties;

/**
 * Type-aware extension of {@link java.util.Properties}
 */
public class TypedProperties extends Properties implements Serializable {

  public TypedProperties() {
    super(null);
  }

  public TypedProperties(Properties defaults) {
    super(defaults);
  }

  private void checkKey(String property) {
    if (!containsKey(property)) {
      throw new IllegalArgumentException("Property " + property + " not found");
    }
  }

  public String getString(String property) {
    checkKey(property);
    return getProperty(property);
  }

  public String getString(String property, String defaultValue) {
    return containsKey(property) ? getProperty(property) : defaultValue;
  }

  public int getInteger(String property) {
    checkKey(property);
    return Integer.valueOf(getProperty(property));
  }

  public int getInteger(String property, int defaultValue) {
    return containsKey(property) ? Integer.valueOf(getProperty(property)) : defaultValue;
  }

  public long getLong(String property) {
    checkKey(property);
    return Long.valueOf(getProperty(property));
  }

  public long getLong(String property, long defaultValue) {
    return containsKey(property) ? Long.valueOf(getProperty(property)) : defaultValue;
  }

  public boolean getBoolean(String property) {
    checkKey(property);
    return Boolean.valueOf(getProperty(property));
  }

  public boolean getBoolean(String property, boolean defaultValue) {
    return containsKey(property) ? Boolean.valueOf(getProperty(property)) : defaultValue;
  }

  public double getDouble(String property) {
    checkKey(property);
    return Double.valueOf(getProperty(property));
  }

  public double getDouble(String property, double defaultValue) {
    return containsKey(property) ? Double.valueOf(getProperty(property)) : defaultValue;
  }
}
