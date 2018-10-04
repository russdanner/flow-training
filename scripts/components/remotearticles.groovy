@Grapes(
        @Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1')
)

import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import groovyx.net.http.ContentType

def siteId = contentModel.siteID.text

def externalServiceHost = "http://localhost:8080"
def externalServiceURI = "/api/search.json?crafterSite=editorial&userTerm=ipsum&categories%5B%5D=style"
def externalServiceURL = externalServiceHost + externalServiceURI

def http = new HTTPBuilder()

http.request( externalServiceURL, Method.GET, ContentType.JSON ) { req ->
    headers.Accept = 'application/json'
    response.success = { resp, reader ->
        def response = reader
        
        try {
            templateModel.articles = response
        }
        catch(err) {
            logger.error("Unable to get articles :"+err)
            templateModel.articles = []

        }
    }
}

