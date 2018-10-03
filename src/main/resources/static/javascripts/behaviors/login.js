(function (window) {
    "use strict";
    window.firebasedemo = window.firebasedemo || {};
    window.firebasedemo.behaviors = window.firebasedemo.behaviors || {};

    window.firebasedemo.behaviors.login = function ($element) {
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

        var formId = $element.data("form-id");
        var $form = $element.parents().find("#" + formId);

        function submitForm() {
            // $form.submit();
        }

        $element.on("click", submitForm);
    }

})(window);