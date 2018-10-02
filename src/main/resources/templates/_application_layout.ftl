<#macro application_layout>
    <@application_base_layout>
    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand text-white">Firebase Demo</a>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
    <div class="container">
        <#nested/>
    </div>
    <footer class="footer ">

    </footer>
    </@application_base_layout>
</#macro>