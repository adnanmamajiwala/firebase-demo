<#macro application_base_layout title="">
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Firebase Demo</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <base href="<@spring.url '/' />"/>

    <link href="<@spring.url '/vendor/stylesheets/bootstrap.min.css'/>" rel="stylesheet"/>
    <link href="<@spring.url '/vendor/stylesheets/bootstrap-grid.min.css'/>" rel="stylesheet"/>
    <link href="<@spring.url '/vendor/stylesheets/bootstrap-reboot.min.css'/>" rel="stylesheet"/>
    <link href="<@spring.url '/vendor/stylesheets/font-awesome-4.7.0/css/font-awesome.min.css'/>" rel="stylesheet"/>
</head>
<body>
    <#nested/>

    <script src="<@spring.url '/vendor/javascripts/jquery-3.3.1.min.js'/>"></script>
    <script src="<@spring.url '/vendor/javascripts/popper.min.js'/>"></script>
    <script src="<@spring.url '/vendor/javascripts/bootstrap.min.js'/>"></script>
    <script src="<@spring.url '/vendor/javascripts/bootstrap.bundle.min.js'/>"></script>
    <script src="https://www.gstatic.com/firebasejs/5.5.2/firebase.js"></script>
    <script src="https://www.gstatic.com/firebasejs/5.5.2/firebase-auth.js"></script>

    <script src="<@spring.url '/javascripts/main.js'/>"></script>
    <script src="<@spring.url '/javascripts/application.js'/>"></script>
    <script src="<@spring.url '/javascripts/behaviors/data-submit.js'/>"></script>
    <script src="<@spring.url '/javascripts/behaviors/login.js'/>"></script>
</body>
</html>
</#macro>
