/*
 * Copyright (C) 2018 Knot.x Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.forms.adapter.multiform.common.configuration;

import io.knotx.configuration.CustomHttpHeader;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClientOptions;
import java.util.ArrayList;
import java.util.List;

/**
 * Options describing how an ServiceAdapter will make connections with external HTTP services.
 */

@DataObject(generateConverter = true, publicConverter = false)
public class MultiStepFormsAdapterConfiguration {

  private String adapterAddress;
  private String sessionAddress;
  private WebClientOptions clientOptions;
  private List<ServiceConfiguration> services;
  private RedisConfiguration redis;
  private CustomHttpHeader customHttpHeader;

  /**
   * Default constructor
   */
  public MultiStepFormsAdapterConfiguration() {
    init();
  }


  /**
   * Copy constructor
   *
   * @param other the instance to copy
   */
  public MultiStepFormsAdapterConfiguration(
      MultiStepFormsAdapterConfiguration other) {
    this.adapterAddress = other.adapterAddress;
    this.sessionAddress = other.sessionAddress;
    this.clientOptions = new WebClientOptions(other.clientOptions);
    this.services = new ArrayList<>(other.services);
    this.customHttpHeader = new CustomHttpHeader(other.customHttpHeader);
  }

  /**
   * Create an settings from JSON
   *
   * @param json the JSON
   */
  public MultiStepFormsAdapterConfiguration(JsonObject json) {
    init();
    MultiStepFormsAdapterConfigurationConverter.fromJson(json, this);
  }

  /**
   * Convert to JSON
   *
   * @return the JSON
   */
  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    MultiStepFormsAdapterConfigurationConverter.toJson(this, json);
    return json;
  }

  private void init() {
    adapterAddress = "knotx.forms.adapter.multistep";
    sessionAddress = "knotx.forms.session";
    clientOptions = new WebClientOptions();
    services = new ArrayList<>();
    customHttpHeader = null;
  }

  public String getAdapterAddress() {
    return adapterAddress;
  }

  public MultiStepFormsAdapterConfiguration setAddress(
      String adapterAddress) {
    this.adapterAddress = adapterAddress;
    return this;
  }

  public String getSessionAddress() {
    return sessionAddress;
  }

  public MultiStepFormsAdapterConfiguration setSessionAddress(
      String sessionAddress) {
    this.sessionAddress = sessionAddress;
    return this;
  }

  /**
   * @return {@link WebClientOptions} of the Http Client used bv the ServiceAdapter to communicate
   * with external services.
   */
  public WebClientOptions getClientOptions() {
    return clientOptions;
  }

  /**
   * Sets the Vert.x Web Client options of the Web client.
   *
   * @param clientOptions clientOptions
   * @return a reference to this, so the API can be used fluently
   */
  public MultiStepFormsAdapterConfiguration setClientOptions(
      WebClientOptions clientOptions) {
    this.clientOptions = clientOptions;
    return this;
  }

  /**
   * @return a list of {@link ServiceConfiguration} describing all service endpoints the ServiceAdapter
   * need to communicate
   */
  public List<ServiceConfiguration> getServices() {
    return services;
  }

  /**
   * Sets the configuration of each service endpoint used by the adapter.
   *
   * @param services the {@link ServiceConfiguration} objects representing each service endpoint
   * @return a reference to this, so the API can be used fluently
   */
  public MultiStepFormsAdapterConfiguration setServices(
      List<ServiceConfiguration> services) {
    this.services = services;
    return this;
  }

  /**
   * @return a Custom Header to be sent in every request to the services
   */
  public CustomHttpHeader getCustomHttpHeader() {
    return customHttpHeader;
  }

  /**
   * Sets the header (name &amp; value) to be sent in every request to the services. If not set, it
   * sends {@code Server-User-Agent=Knot.x} header
   *
   * @param customHttpHeader the header name &amp; value
   * @return a reference to this, so the API can be used fluently
   */
  public MultiStepFormsAdapterConfiguration setCustomHttpHeader(
      CustomHttpHeader customHttpHeader) {
    this.customHttpHeader = customHttpHeader;
    return this;
  }

  public RedisConfiguration getRedis() {
    return redis;
  }

  public void setRedis(RedisConfiguration redis) {
    this.redis = redis;
  }
}
