<@application_layout>
<form class="form-signin" action="/login" method="post">
    <div class="form-label-group text-center pb-5 pt-5">
        <i class="fa fa-user-circle-o fa-5x fa-align-center" aria-hidden="true"></i>
    </div>

    <div class="form-group">
        <label for="username">Email address</label>
        <input id="username"
               name="username"
               type="email"
               class="form-control"
               aria-describedby="emailHelp"
               placeholder="Enter email"
               required autofocus>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>

    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-primary" >Submit</button>

</form>
</@application_layout>