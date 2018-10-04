<#import "/templates/system/common/cstudio-support.ftl" as studio />
<div <@studio.componentAttr path=contentModel.storeUrl ice=true /> >
<ul>
   <#list articles as article>
   		<li>${article.title}</li>
   </#list>
 </ul>
</div>