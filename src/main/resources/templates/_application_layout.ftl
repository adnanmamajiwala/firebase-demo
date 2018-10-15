<#macro application_layout>
    <@application_base_layout>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand text-white">Firebase Demo</a>
        <#if user??>
            Welcome ${user??.name}
        <#else>
            <#include "login/signin.ftl"/>
        </#if>
    </nav>
    <div class="container">
        <div id="error-flash" class="row pt-3" style="display: none;">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <p></p>
            </div>
        </div>

        <#nested/>
    </div>
    <footer class="footer ">

    </footer>
    <div id="loginSpinner"
         class="modal"
         tabindex="-1"
         role="dialog"
         aria-labelledby="myLoginSpinner"
         aria-hidden="true">
        <div class="modal-dialog modal-lg align-content-center">
            <i class="fa fa-spinner fa-spin fa-4x"></i>
        </div>
    </div>
    </@application_base_layout>
</#macro>