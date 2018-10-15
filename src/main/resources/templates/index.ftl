<@application_layout>

    <#if user??>
        <div class="form-group pt-5">
            <label for="inputEmail">Hello ${user.name}</label>
        </div>
    <#else>
        <div class="form-group pt-5">
            <label for="inputEmail">Hello</label>
        </div>
    </#if>

</@application_layout>