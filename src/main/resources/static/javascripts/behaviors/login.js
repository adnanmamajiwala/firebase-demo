(function (window) {
    "use strict";
    window.firebasedemo = window.firebasedemo || {};
    window.firebasedemo.behaviors = window.firebasedemo.behaviors || {};

    window.firebasedemo.behaviors.login = function ($element) {
        var $email = $element.parents().find("#username");
        var $password = $element.parents().find("#password");
        var $loginSpinner = $element.parents().find("#loginSpinner");
        var $form = $element.parents().find("#login");

        // Initialize Firebase
        var config = {
            apiKey: "AIzaSyCFwU02IpORKN_4O8lFWKh0pkMFpZLu9jY",
            authDomain: "my-demo-sample.firebaseapp.com",
            databaseURL: "https://my-demo-sample.firebaseio.com",
            projectId: "my-demo-sample",
            storageBucket: "my-demo-sample.appspot.com",
            messagingSenderId: "68491857110"
        };
        firebase.initializeApp(config);

        function submitForm() {
            $loginSpinner.modal({
                backdrop: 'static',
                show : true
            });

            firebase.auth()
                .signInWithEmailAndPassword($email.val(), $password.val())
                .then(function (value) {
                    value.user.getIdToken()
                        .then(function (token) {
                            $password.val(token);
                            $form.submit();
                        });
                })
                .catch(function (error) {
                    var errorCode = error.code;
                    var errorMessage = error.message;
                    console.error(error);
                    $loginSpinner.modal("hide");
                });
        }

        $element.on("click", submitForm);
    }

})(window);