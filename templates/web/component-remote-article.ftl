<#import "/templates/system/common/cstudio-support.ftl" as studio />
<div <@studio.componentAttr path=contentModel.storeUrl ice=true /> >

  <h1>Featured Articles</h1>
  <#list articles as article>
   		<h2><a href="/studio/preview/#/?page=${article.url}&site=${siteID}" target="new">${article.title}</a></h2>
  </#list>
</div>