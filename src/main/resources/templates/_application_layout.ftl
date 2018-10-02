<#macro application_layout>
    <@application_base_layout>
    <nav class="navbar navbar-expand-lg justify-content-center">
        <a class="navbar-brand" href="#">Firebase</a>
    </nav>
    <div class="container">
        <#nested/>
    </div>
    <footer class="footer ">

    </footer>
    </@application_base_layout>
</#macro>