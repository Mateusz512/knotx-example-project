
# Getting started with Docker example
This project is a result of completing either [Getting Started with Knot.x Stack](http://knotx.io/tutorials/getting-started-with-knotx-stack/2_0/) or [Getting started with Docker](http://knotx.io/tutorials/getting-started-with-docker/2_0/) tutorials.

This example is built using the [Starter Kit](https://github.com/Knotx/knotx-starter-kit) template project.

## How to build & run
    
### Stack

#### Prerequisites
- JDK 8
- Linux or OSX bash console (for Windows users we recommend using e.g. Ubuntu with [Windows Subsystem for Linux](https://docs.microsoft.com/en-us/windows/wsl/install-win10))

#### Run
```
    # build the Knot.x stack
$ ./gradlew build

    # unzip the distribution
$ cd build/distributions
$ unzip knotx-stack-<version of your project>.zip

    # run Knot.x
$ cd knotx
$ chmod +x bin/knotx
$ bin/knotx run-knotx
```   

and validate url:
- [`localhost:8092/api/public`](http://localhost:8092/api/public)
    
### Docker

#### Prerequisites
- JDK 8
- Docker

#### Run
```
$ ./gradlew build-docker
```

The [build-docker](https://github.com/Knotx/knotx-starter-kit#build--validate-docker-image) builds and validates the custom project Docker image.

Then, start Docker container:
```
$ docker run -p8092:8092 knotx/secure-api-gateway
```

and validate url:
- [`localhost:8092/api/public`](http://localhost:8092/api/public)

## Endpoints:

- [`localhost:8092/api/public`](http://localhost:8092/api/public) public endpoint without security
- [`localhost:8092/api/secure/basic`](http://localhost:8092/api/security/basic) endpoint protected with [Basic Auth](https://en.wikipedia.org/wiki/Basic_access_authentication)
  - Available credentials: user `john` password `s3cr3t`
- [`localhost:8092/api/secure/jwt`](http://localhost:8092/api/security/jwt) endpoint protected with [JWT](https://jwt.io/)
  - Symmetric key using `HS256`: `M0NTY3ODkwIiwibmFtZSI6`
- [`localhost:8092/api/secure/login`](http://localhost:8092/api/security/jwt) endpoint implementing *Authorization Code* flow of [OAuth2](https://oauth.net/2/)
  - It redirects to Google Account consent page
- [`localhost:8092/api/secure/oauth2`](http://localhost:8092/api/security/oauth2) endpoint expecting a redirect from Google Account consent page as part of [OAuth2](https://oauth.net/2/)
  - It uses received Authorization Code to obtain Access Token and uses the received token to fetch user data 


## What is the delta between [Starter Kit](https://github.com/Knotx/knotx-starter-kit)?

- `security-module` that includes implementation of security handlers 
- `hello-module` module that includes a handler that prints a configured message to response
- `health-check` module is modified to rely on `/api/public`
- `functional` tests also rely on `/api/public`
- new tests in `functional` module that verify security endpoints
- this code was cleaned from unnecessary example modules and configurations (**not covered in tutorials**)