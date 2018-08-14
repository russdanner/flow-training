def queryStatement = "content-type:\"/component/alerts\""
def searchService = targetedContentService.getSearchService()
def query = searchService.createQuery()
query.setQuery(queryStatement)

def executedQuery = searchService.search(query)

def matches = [:]
matches.found = executedQuery.response.numFound
matches.alerts = executedQuery.response.documents
matches.query = queryStatement

def alerts = matches.alerts
def alertTitle = ""
if(alerts.size() > 0){
    alertTitle = alerts[0].title
}

println "Returning ${alertTitle}"
templateModel.alerts = alertTitle