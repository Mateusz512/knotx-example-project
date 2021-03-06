[![Build Status](https://dev.azure.com/knotx/Knotx/_apis/build/status/Knotx.knotx-example-project?branchName=master)](https://dev.azure.com/knotx/Knotx/_build/latest?definitionId=15&branchName=master)

# Knot.x Examples
Examples show how you can customize/extend [Knot.x Stack](https://github.com/Knotx/knotx-stack) in 
a real project. They use Gradle to build all custom modules and prepare a distribution 
containing custom configurations and modules. 

## Topics covered in our examples:

### Distribution

Within this module, you will see what [Stack](https://github.com/Knotx/knotx-stack) is and how it can be customized.
It also contains details on how to use [Starter Kit](https://github.com/Knotx/knotx-starter-kit) 
template project to prepare a custom project distribution.

Although we recommend to start with [Starter Kit](https://github.com/Knotx/knotx-starter-kit) that
builds Docker image, using Docker is not mandatory. 

|Topic|Description|Used technologies|Tutorial|Source code|
|-----|-----------|-----------------|--------|-----------|
|Stack|Basic usage of [fragmentsHandler](https://github.com/Knotx/knotx-fragments/tree/master/handler) with a simple graph that uses data from external API and combines them with a static HTML provided by [fsRepoConnectionHandler](https://github.com/Knotx/knotx-repository-connector/tree/master/fs). |[Stack](https://github.com/Knotx/knotx-stack)|[Getting Started with Knot.x Stack](http://knotx.io/tutorials/getting-started-with-knotx-stack/2_0/)| `./distribution/knotx-stack`| 
|Docker|This module covers the same topics as above. However, it uses Docker and embeds Knot.x Stack within a Docker image.|[Stack](https://github.com/Knotx/knotx-stack), [Docker](https://github.com/Knotx/knotx-docker), [Starter Kit](https://github.com/Knotx/knotx-starter-kit) template project |[Getting Started with Docker](http://knotx.io/tutorials/getting-started-with-docker/2_0/)| | 


### API gateway

Knot.x is an integration framework that can be used as a simple API gateway. It can be also combined 
with Cloud solutions like [Apigee Edge](https://docs.apigee.com/api-platform/get-started/what-apigee-edge) 
or [Amazon API Gateway](https://aws.amazon.com/api-gateway/).


|Topic|Description|Used technologies|Tutorial|Source code|
|-----|-----------|-----------------|--------|-----------|
|Securing your API |Simple usage of popular authentication technologies to secure your API.|Docker, OAuth 2.0, OpenId Connect, JWT|*coming soon*|*coming soon*| 
|Composing many APIs|Presents how to combine data from many API (even dependent on each other) using [Configurable Integrations](http://knotx.io/blog/configurable-integrations/).|[Fragments](https://github.com/Knotx/knotx-fragments/tree/master/handler), [WireMock](http://wiremock.org/), Docker|[Configurable API gateway](http://knotx.io/tutorials/configurable-api-gateway/2_0/)|`./api-gateway/composing-many-apis`|
|GraphQL API|Expose GraphQL API using Configurable Integrations.|GraphQL, OpenAPI, Configurable Integrations|[Using GraphQL with Knot.x](http://knotx.io/tutorials/graphql-usage/2_0.html)|`./api-gateway/graphql-api` 

### Template Processing
This module presents the aspects of template processing.

|Topic|Description|Used technologies|Tutorial|Source code|
|-----|-----------|-----------------|--------|-----------|
|Getting started|Basic usage of [fragmentsHandler](https://github.com/Knotx/knotx-fragments/tree/master/handler) with a simple graph that uses data from external API and combines them with a static HTML provided by [fsRepoConnectionHandler](https://github.com/Knotx/knotx-repository-connector/tree/master/fs) | [Template Engine](https://github.com/Knotx/knotx-template-engine), Handlebars, Docker| |`./template-processing/handlebars`| 

[license]:https://github.com/Cognifide/knotx/blob/master/LICENSE
[license img]:https://img.shields.io/badge/License-Apache%202.0-blue.svg

[gitter]:https://gitter.im/Knotx/Lobby
[gitter img]:https://badges.gitter.im/Knotx/knotx-extensions.svg
